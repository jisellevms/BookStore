package br.jisellemartins.infnet.bookstore;

import br.jisellemartins.infnet.bookstore.model.domain.LivroFisico;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.service.LivroFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(3)
@Component
public class LivroFisicoLoader implements ApplicationRunner {
    @Autowired
    private LivroFisicoService livroFisicoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/livrosFisicos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;
        Vendedor vendedor = new Vendedor();

        while (linha != null) {
            campos = linha.split(";");
            LivroFisico livroFisico = new LivroFisico();
            livroFisico.setCodigo(Integer.parseInt(campos[0]));
            livroFisico.setTitulo(campos[1]);
            livroFisico.setDescricao(campos[2]);
            livroFisico.setEstoque(Boolean.parseBoolean(campos[3]));
            livroFisico.setPreco(Float.parseFloat(campos[4]));
            livroFisico.setQtdPaginas(Integer.parseInt(campos[5]));
            livroFisico.setPeso(Float.parseFloat(campos[6]));
            livroFisico.setTipoCapa(campos[7]);

            vendedor.setId(Integer.valueOf(campos[8]));
            livroFisico.setVendedor(vendedor);

            livroFisicoService.incluirLivroFisico(livroFisico);

            linha = leitura.readLine();
        }

        for (LivroFisico livroFisico : livroFisicoService.obterListaLivrosFisicos()) {
            System.out.println("[Livro Fisico] " + livroFisico);
        }

        leitura.close();

    }
}
