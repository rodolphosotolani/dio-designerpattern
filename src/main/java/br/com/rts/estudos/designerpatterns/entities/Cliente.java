package br.com.rts.estudos.designerpatterns.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nome;

    private String documento;

    @ManyToOne
    @JoinColumn(name = "endereco")
    private Endereco endereco;

}
