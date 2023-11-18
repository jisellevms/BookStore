package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.LivroFisico;
import br.jisellemartins.infnet.bookstore.model.domain.Produto;
import br.jisellemartins.infnet.bookstore.model.repository.LivroFisicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LivroFisicoService {
    @Autowired
    private LivroFisicoRepository livroFisicoRepository;

    public LivroFisico pesquisar(Integer codigo) {
        return livroFisicoRepository.findByCodigo(codigo);
    }

    public void incluirLivroFisico(LivroFisico livroFisico) {
        livroFisicoRepository.save(livroFisico);
    }

    public void excluirLivroFisico(Integer id) {
        livroFisicoRepository.deleteById(id);
    }

    public Collection<LivroFisico> obterListaLivrosFisicos() {
        return (Collection<LivroFisico>) livroFisicoRepository.findAll();
    }

    public long obterQuantidade(){
        return livroFisicoRepository.count();
    }
}
