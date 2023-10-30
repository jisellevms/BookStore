package br.jisellemartins.infnet.bookstore.model.repository;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroDigitalRepository extends CrudRepository<LivroDigital, Integer> {
}
