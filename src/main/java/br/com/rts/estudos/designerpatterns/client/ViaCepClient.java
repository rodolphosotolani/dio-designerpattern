package br.com.rts.estudos.designerpatterns.client;

import br.com.rts.estudos.designerpatterns.client.responses.EnderecoViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "viacep.com.br/ws", name = "ViaCep")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    EnderecoViaCepResponse getEnderecoViaCep(@PathVariable String cep);
}
