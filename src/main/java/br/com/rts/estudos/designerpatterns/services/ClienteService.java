package br.com.rts.estudos.designerpatterns.services;

import br.com.rts.estudos.designerpatterns.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();

    Optional<Cliente> findById(Long idCliente);

    void create(Cliente cliente);

    void update(Long idCliente, Cliente cliente) throws ClassNotFoundException;

    void deleteCliente(Long idCliente) throws ClassNotFoundException;
}
