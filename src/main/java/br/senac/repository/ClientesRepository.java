package br.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    
}
