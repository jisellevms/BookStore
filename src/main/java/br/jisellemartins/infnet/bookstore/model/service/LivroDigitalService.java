package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroDigitalService {
    private Map<Integer, LivroDigital> mapaLivroDigital = new HashMap<Integer, LivroDigital>();

    public void incluirLivroDigital(LivroDigital livroDigital) {
        mapaLivroDigital.put(livroDigital.getCodigo(), livroDigital);
    }

    public Collection<LivroDigital> obterListaLivrosDigitais(){
        return mapaLivroDigital.values();
    }
}
