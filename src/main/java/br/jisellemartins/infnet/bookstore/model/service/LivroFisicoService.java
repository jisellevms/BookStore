package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import br.jisellemartins.infnet.bookstore.model.domain.LivroFisico;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroFisicoService {
    private Map<Integer, LivroFisico> mapaLivroFisico = new HashMap<Integer, LivroFisico>();

    public void incluirLivroFisico(LivroFisico livroFisico) {
        mapaLivroFisico.put(livroFisico.getCodigo(), livroFisico);
    }

    public Collection<LivroFisico> obterListaLivrosFisicos(){
        return mapaLivroFisico.values();
    }
}
