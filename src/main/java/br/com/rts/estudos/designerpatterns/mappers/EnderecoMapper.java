package br.com.rts.estudos.designerpatterns.mappers;

import br.com.rts.estudos.designerpatterns.client.responses.EnderecoViaCepResponse;
import br.com.rts.estudos.designerpatterns.controllers.responses.EnderecoResponse;
import br.com.rts.estudos.designerpatterns.entities.Endereco;
import br.com.rts.estudos.designerpatterns.services.EnderecoService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    @Mapping(target = "cep")
    Endereco stringToEntity(String cep);

    EnderecoResponse entityToResponse(Endereco endereco);

    Endereco viaCepResponseToEntity(EnderecoViaCepResponse endereco);
}
