package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProdutoService {
    private Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>();

    public void incluirProduto(Produto produto){
        mapaProduto.put(produto.getCodigo(), produto);
    }

    public Collection<Produto> obterListaProdutos(){
        return mapaProduto.values();
    }
}
