package br.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
    List<Servico> findByClienteServ(String clienteServ);

    List<Servico> findByClienteNomeContainingIgnoreCase(String nome); //Necessario ignoreCase para deixar de ser case sensitive 

    List<Servico> findByMercadoriaNomeContainingIgnoreCase(String mercadoria);
}
