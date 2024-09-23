package br.com.rts.estudos.designerpatterns.repositories;

import br.com.rts.estudos.designerpatterns.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
