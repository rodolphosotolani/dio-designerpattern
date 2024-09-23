package br.com.rts.estudos.designerpatterns.services;

import br.com.rts.estudos.designerpatterns.entities.Endereco;

public interface EnderecoService {

    Endereco findById(String cep);
}
