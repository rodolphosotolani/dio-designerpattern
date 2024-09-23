package br.com.rts.estudos.designerpatterns.controllers.responses;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;

    private String nome;

    private String documento;

    private EnderecoResponse endereco;

}
