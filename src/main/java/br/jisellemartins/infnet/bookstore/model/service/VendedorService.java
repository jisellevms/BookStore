package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public void incluirVendedor(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public Collection<Vendedor> obterListaVendedores() {
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }
}
