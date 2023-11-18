package br.jisellemartins.infnet.bookstore.controller;

import br.jisellemartins.infnet.bookstore.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private LivroFisicoService livroFisicoService;
    @Autowired
    private LivroDigitalService livroDigitalService;
    @Autowired
    private InformacaoService informacaoService;

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("informacoes", informacaoService.obterInformacao());
        model.addAttribute("qtdVendedor", vendedorService.obterQuantidade());
        model.addAttribute("qtdProdutos", produtoService.obterQuantidade());
        model.addAttribute("qtdLivroFisico", livroFisicoService.obterQuantidade());
        model.addAttribute("qtdLivroDigital", livroDigitalService.obterQuantidade());
        return "home";
    }







}
