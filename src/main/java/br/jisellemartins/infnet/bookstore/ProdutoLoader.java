package br.jisellemartins.infnet.bookstore;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import br.jisellemartins.infnet.bookstore.model.domain.LivroFisico;
import br.jisellemartins.infnet.bookstore.model.domain.Produto;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/produtos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {

            campos = linha.split(";");


            switch (campos[8]) {
                case "F":
                    LivroFisico livroFisico = new LivroFisico();
                    livroFisico.setCodigo(Integer.parseInt(campos[0]));
                    livroFisico.setTitulo(campos[1]);
                    livroFisico.setDescricao(campos[2]);
                    livroFisico.setEstoque(Boolean.parseBoolean(campos[3]));
                    livroFisico.setPreco(Float.parseFloat(campos[4]));
                    livroFisico.setQtdPaginas(Integer.parseInt(campos[5]));
                    livroFisico.setPeso(Float.parseFloat(campos[6]));
                    livroFisico.setTipoCapa(campos[7]);

                    produtoService.incluirProduto(livroFisico);
                    break;

                case "D":
                    LivroDigital livroDigital = new LivroDigital();
                    livroDigital.setCodigo(Integer.parseInt(campos[0]));
                    livroDigital.setTitulo(campos[1]);
                    livroDigital.setDescricao(campos[2]);
                    livroDigital.setEstoque(Boolean.parseBoolean(campos[3]));
                    livroDigital.setPreco(Float.parseFloat(campos[4]));
                    livroDigital.setQtdPaginas(Integer.parseInt(campos[5]));
                    livroDigital.setTamanho(Integer.parseInt((campos[6])));
                    livroDigital.setFormato(campos[7]);
                    produtoService.incluirProduto(livroDigital);
                    break;

                default:
                    break;
            }

            linha = leitura.readLine();
        }

        for (Produto produto : produtoService.obterListaProdutos()) {
            System.out.println("[Produto] " + produto);
        }
        leitura.close();
    }
}
