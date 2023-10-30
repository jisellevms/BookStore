package br.jisellemartins.infnet.bookstore;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.service.LivroDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(4)
@Component
public class LivroDigitalLoader implements ApplicationRunner {

    @Autowired
    private LivroDigitalService livroDigitalService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/livrosDigitais.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;
        Vendedor vendedor = new Vendedor();
        while (linha != null) {
            campos = linha.split(";");

            LivroDigital livroDigital = new LivroDigital();
            livroDigital.setCodigo(Integer.parseInt(campos[0]));
            livroDigital.setTitulo(campos[1]);
            livroDigital.setDescricao(campos[2]);
            livroDigital.setEstoque(Boolean.parseBoolean(campos[3]));
            livroDigital.setPreco(Float.parseFloat(campos[4]));
            livroDigital.setQtdPaginas(Integer.parseInt(campos[5]));
            livroDigital.setTamanho(Integer.parseInt((campos[6])));
            livroDigital.setFormato(campos[7]);

            vendedor.setId(Integer.valueOf(campos[8]));
            livroDigital.setVendedor(vendedor);

            livroDigitalService.incluirLivroDigital(livroDigital);

            linha = leitura.readLine();
        }

        for (LivroDigital livroDigital: livroDigitalService.obterListaLivrosDigitais()){
            System.out.println("[Livro Digital] " + livroDigital);
        }

        leitura.close();
    }
}
