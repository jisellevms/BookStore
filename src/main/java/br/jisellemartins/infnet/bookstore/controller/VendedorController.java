package br.jisellemartins.infnet.bookstore.controller;

import br.jisellemartins.infnet.bookstore.model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VendedorController {
    @Autowired
    private AppController appController;
    @Autowired
    private VendedorService vendedorService;

    @GetMapping(value = "/vendedor/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        vendedorService.excluirVendedor(id);
        return "redirect:/vendedor/lista";
    }

    @GetMapping(value = "/vendedor/lista")
    public String obterVendedorLista(Model model) {
        model.addAttribute("rota", "vendedor");
        model.addAttribute("titulo", "Vendedores:");
        model.addAttribute("listagem", vendedorService.obterListaVendedores());
        return appController.showHome(model);
    }
}
