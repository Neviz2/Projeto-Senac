package br.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senac.model.Clientes;


// repositorio controla o model do sql com o jpaRepository que é uma classe padrão do spring para isso

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    
    List<Clientes> findByNome(String nome);

    List<Clientes> findBycpf(String cpf);
}
