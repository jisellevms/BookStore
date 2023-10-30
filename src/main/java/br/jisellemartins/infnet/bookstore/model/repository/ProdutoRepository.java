package br.jisellemartins.infnet.bookstore.model.repository;

import br.jisellemartins.infnet.bookstore.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
    @Query("from Produto p  where p.vendedor.id = :vendedorId")
    Collection<Produto> obterProdutosPorVendedor(Integer vendedorId);
}
