package br.jisellemartins.infnet.bookstore.controller;

import br.jisellemartins.infnet.bookstore.model.domain.LivroDigital;
import br.jisellemartins.infnet.bookstore.model.domain.LivroFisico;
import br.jisellemartins.infnet.bookstore.model.service.LivroDigitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LivroDigitalController {
    @Autowired
    private AppController appController;
    @Autowired
    private LivroDigitalService livroDigitalService;

    @GetMapping(value = "/livrodigital/pesquisar")
    public String pesquisar(Model model, String campoBusca) {

        LivroDigital livroDigital = livroDigitalService.pesquisar(Integer.valueOf(campoBusca));
        if (livroDigital != null){
            model.addAttribute("objeto", livroDigital);
            return appController.showHome(model);
        }
        return "redirect:/livrodigital/lista";
    }

    @GetMapping(value = "/livrodigital/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        livroDigitalService.excluirLivroDigital(id);
        return "redirect:/livrodigital/lista";
    }

    @GetMapping(value = "/livrodigital/lista")
    public String obterLivroDigitalLista(Model model) {
        model.addAttribute("rota", "livrodigital");
        model.addAttribute("titulo", "Livros Digitais:");
        model.addAttribute("listagem", livroDigitalService.obterListaLivrosDigitais());
        return appController.showHome(model);
    }
}
