package br.jisellemartins.infnet.bookstore.model.repository;

import br.jisellemartins.infnet.bookstore.model.domain.LivroFisico;
import br.jisellemartins.infnet.bookstore.model.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroFisicoRepository extends CrudRepository<LivroFisico, Integer> {
    LivroFisico findByCodigo(Integer codigo);
}
