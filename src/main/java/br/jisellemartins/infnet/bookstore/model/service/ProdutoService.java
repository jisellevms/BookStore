package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.Produto;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluirProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public void excluirProduto(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Collection<Produto> obterListaProdutos() {
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Collection<Produto> obterProdutosPorVendedor(Vendedor vendedor) {
        return (Collection<Produto>) produtoRepository.obterProdutosPorVendedor(vendedor.getId());
    }
    public long obterQuantidade(){
        return produtoRepository.count();
    }
}
