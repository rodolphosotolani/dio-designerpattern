package br.com.rts.estudos.designerpatterns.controllers;

import br.com.rts.estudos.designerpatterns.controllers.requests.ClienteRequest;
import br.com.rts.estudos.designerpatterns.controllers.responses.ClienteResponse;
import br.com.rts.estudos.designerpatterns.entities.Cliente;
import br.com.rts.estudos.designerpatterns.mappers.ClienteMapper;
import br.com.rts.estudos.designerpatterns.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    private final ClienteMapper clienteMapper;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos() {

        var clientes = clienteService.findAll();

        if (clientes.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity
                .ok(clientes
                        .stream()
                        .map(clienteMapper::entityToResponse)
                        .toList());
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<ClienteResponse> buscarCliente(@PathVariable Long idCliente) {

        Optional<Cliente> cliente = clienteService.findById(idCliente);

        if (cliente.isPresent())
            return ResponseEntity
                    .ok(cliente
                            .map(clienteMapper::entityToResponse)
                            .get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> criarCliente(@RequestBody ClienteRequest request) {

        clienteService.create(
                clienteMapper.requestToEntity(request));

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<Void> atualizarCliente(
            @PathVariable Long idCliente,
            @RequestBody ClienteRequest request) throws ClassNotFoundException {

        clienteService.update(
                idCliente,
                clienteMapper.requestToEntity(request));

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> deletarCliente(
            @PathVariable Long idCliente) throws ClassNotFoundException {

        clienteService.deleteCliente(idCliente);

        return ResponseEntity.notFound().build();
    }


}
