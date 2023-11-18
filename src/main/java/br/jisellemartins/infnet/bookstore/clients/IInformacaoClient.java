package br.jisellemartins.infnet.bookstore.clients;

import br.jisellemartins.infnet.bookstore.model.domain.Informacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8081/api/informacao", name = "informacaoClient")
public interface IInformacaoClient {
    @GetMapping(value = "/lista")
    public List<Informacao> obterInformacao();

    @PostMapping(value = "/incluir")
    public Informacao incluirInformacao(Informacao informacao);
}
