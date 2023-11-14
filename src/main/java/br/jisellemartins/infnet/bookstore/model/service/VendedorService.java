package br.jisellemartins.infnet.bookstore.model.service;

import br.jisellemartins.infnet.bookstore.clients.IEnderecoClient;
import br.jisellemartins.infnet.bookstore.model.domain.Endereco;
import br.jisellemartins.infnet.bookstore.model.domain.Vendedor;
import br.jisellemartins.infnet.bookstore.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private IEnderecoClient iEnderecoClient;

    public void incluirVendedor(Vendedor vendedor) {
        Endereco endereco = iEnderecoClient.buscarCep(vendedor.getEndereco().getCep());
        vendedor.setEndereco(endereco);
        vendedorRepository.save(vendedor);
    }

    public void excluirVendedor(Integer id) {
        vendedorRepository.deleteById(id);
    }

    public Collection<Vendedor> obterListaVendedores() {
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

    public long obterQuantidade() {
        return vendedorRepository.count();
    }
}
