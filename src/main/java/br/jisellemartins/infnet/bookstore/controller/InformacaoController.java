package br.jisellemartins.infnet.bookstore.controller;

import br.jisellemartins.infnet.bookstore.model.domain.Informacao;
import br.jisellemartins.infnet.bookstore.model.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformacaoController {
    @Autowired
    private InformacaoService informacaoService;
    @PostMapping(value = "/informacao/incluir")
    public String incluir(Informacao informacao) {
        Informacao result = informacaoService.incluirInformacao(informacao);
        return "redirect:/";
    }
}
