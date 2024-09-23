package br.com.rts.estudos.designerpatterns.controllers.responses;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

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
