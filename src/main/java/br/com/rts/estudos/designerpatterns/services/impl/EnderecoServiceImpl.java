package br.com.rts.estudos.designerpatterns.services.impl;

import br.com.rts.estudos.designerpatterns.client.ViaCepClient;
import br.com.rts.estudos.designerpatterns.entities.Endereco;
import br.com.rts.estudos.designerpatterns.mappers.EnderecoMapper;
import br.com.rts.estudos.designerpatterns.repositories.EnderecoRepository;
import br.com.rts.estudos.designerpatterns.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final ViaCepClient viaCepClient;

    private final EnderecoRepository enderecoRepository;

    private final EnderecoMapper enderecoMapper;

    @Override
    public Endereco findById(String cep) {

        Optional<Endereco> enderecoOptional = enderecoRepository.findById(cep);

        return enderecoOptional
                .orElseGet(() ->
                        enderecoRepository.save(
                                this.findViaCep(cep)));

    }

    private Endereco findViaCep(String cep) {
        return enderecoMapper.viaCepResponseToEntity(
                viaCepClient.getEnderecoViaCep(cep));
    }

}
