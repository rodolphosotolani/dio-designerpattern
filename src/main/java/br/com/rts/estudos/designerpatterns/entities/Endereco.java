package br.com.rts.estudos.designerpatterns.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
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
