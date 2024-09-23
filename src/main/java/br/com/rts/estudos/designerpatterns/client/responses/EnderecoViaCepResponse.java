package br.com.rts.estudos.designerpatterns.client.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoViaCepResponse {

    public String cep;

    public String logradouro;

    public String complemento;

    public String unidade;

    public String bairro;

    public String localidade;

    public String uf;

    public String estado;

    public String regiao;

    public String ibge;

    public String gia;

    public String ddd;
}
