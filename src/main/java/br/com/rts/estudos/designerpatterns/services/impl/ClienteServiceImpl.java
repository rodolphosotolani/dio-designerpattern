package br.com.rts.estudos.designerpatterns.services.impl;

import br.com.rts.estudos.designerpatterns.entities.Cliente;
import br.com.rts.estudos.designerpatterns.entities.Endereco;
import br.com.rts.estudos.designerpatterns.repositories.ClienteRepository;
import br.com.rts.estudos.designerpatterns.services.ClienteService;
import br.com.rts.estudos.designerpatterns.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final EnderecoService enderecoService;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    @Override
    public void create(Cliente cliente) {

        cliente.setEndereco(
                enderecoService.findById(cliente.getEndereco().getCep()));

        clienteRepository.save(cliente);
    }

    @Override
    public void update(Long idCliente, Cliente cliente) throws ClassNotFoundException {

        Cliente clienteAntigo = this.findById(idCliente)
                .orElseThrow(() -> new ClassNotFoundException("Cliente não encontrado na base de dados!"));

        Endereco endereco = clienteAntigo.getEndereco();
        if (Objects.nonNull(cliente.getEndereco().getCep()))
            endereco = enderecoService.findById(cliente.getEndereco().getCep());

        Cliente clienteNovo = clienteAntigo
                .toBuilder()
                .nome(clienteAntigo.getNome())
                .endereco(endereco)
                .build();

        clienteRepository.save(clienteNovo);
    }

    @Override
    public void deleteCliente(Long idCliente) throws ClassNotFoundException {

        if (clienteRepository.existsById(idCliente))
            clienteRepository.deleteById(idCliente);
        else
            throw new ClassNotFoundException("Cliente não encontrado na base de dados!");
    }
}
