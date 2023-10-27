package br.jisellemartins.infnet.bookstore.model.repository;

import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {
}
