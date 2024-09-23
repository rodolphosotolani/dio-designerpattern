package br.com.rts.estudos.designerpatterns.mappers;

import br.com.rts.estudos.designerpatterns.controllers.requests.ClienteRequest;
import br.com.rts.estudos.designerpatterns.controllers.responses.ClienteResponse;
import br.com.rts.estudos.designerpatterns.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface ClienteMapper {

    ClienteResponse entityToResponse(Cliente cliente);


    @Mapping(source = "cep", target = "endereco.cep")
    @Mapping(target = "id", ignore = true)
    Cliente requestToEntity(ClienteRequest request);
}
