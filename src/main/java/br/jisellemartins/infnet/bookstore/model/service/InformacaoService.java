package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.clients.IInformacaoClient;
import br.jisellemartins.infnet.bookstore.model.domain.Informacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InformacaoService {

    @Autowired
    private IInformacaoClient iInformacaoClient;
    public List<Informacao> obterInformacao(){
        return iInformacaoClient.obterInformacao();
    }

    public Informacao incluirInformacao(Informacao informacao){
        return iInformacaoClient.incluirInformacao(informacao);
    }
}
