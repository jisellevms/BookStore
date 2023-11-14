package br.jisellemartins.infnet.bookstore.controller;

import br.jisellemartins.infnet.bookstore.model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoController {
    @Autowired
    private AppController appController;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/produto/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
        return "redirect:/produto/lista";
    }

    @GetMapping(value = "/produto/lista")
    public String obterProdutoLista(Model model) {
        model.addAttribute("rota", "produto");
        model.addAttribute("titulo", "Produtos:");
        model.addAttribute("listagem", produtoService.obterListaProdutos());
        return appController.showHome(model);
    }
}
