package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.repository.LivroDigitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroDigitalService {
    @Autowired
    private LivroDigitalRepository livroDigitalRepository;

    public void incluirLivroDigital(LivroDigital livroDigital) {
        livroDigitalRepository.save(livroDigital);
    }

    public Collection<LivroDigital> obterListaLivrosDigitais() {
        return (Collection<LivroDigital>) livroDigitalRepository.findAll();
    }
}
