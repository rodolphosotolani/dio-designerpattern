package br.com.rts.estudos.designerpatterns.repositories;

import br.com.rts.estudos.designerpatterns.entities.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
