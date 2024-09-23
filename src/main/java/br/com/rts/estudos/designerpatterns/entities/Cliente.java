package br.com.rts.estudos.designerpatterns.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
