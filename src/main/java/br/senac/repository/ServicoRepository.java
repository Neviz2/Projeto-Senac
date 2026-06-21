package br.senac.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.senac.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
    List<Servico> findByClienteNomeContainingIgnoreCase(String nome); 

    List<Servico> findByMercadoriaTipoContainingIgnoreCase(String tipo); 
}