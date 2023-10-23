package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendedorService {
    private Map<String, Vendedor> mapaVendedor = new HashMap<String, Vendedor>();

    public void incluirVendedor(Vendedor vendedor) {
        mapaVendedor.put(vendedor.getCpf(), vendedor);
    }

    public Collection<Vendedor> obterListaVendedores() {
        return mapaVendedor.values();
    }
}
