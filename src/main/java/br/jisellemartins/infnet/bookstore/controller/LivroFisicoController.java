package br.jisellemartins.infnet.bookstore.controller;

import br.jisellemartins.infnet.bookstore.model.service.LivroFisicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LivroFisicoController {
    @Autowired
    private AppController appController;
    @Autowired
    private LivroFisicoService livroFisicoService;

    @GetMapping(value = "/livrofisico/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        livroFisicoService.excluirLivroFisico(id);
        return "redirect:/livrofisico/lista";
    }

    @GetMapping(value = "/livrofisico/lista")
    public String obterLivroFisicoLista(Model model) {
        model.addAttribute("rota", "livrofisico");
        model.addAttribute("titulo", "Livros Fisicos:");
        model.addAttribute("listagem", livroFisicoService.obterListaLivrosFisicos());
        return appController.showHome(model);
    }
}
