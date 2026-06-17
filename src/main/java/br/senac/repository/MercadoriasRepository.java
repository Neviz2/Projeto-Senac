package br.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.model.Mercadorias;

public interface MercadoriasRepository extends JpaRepository<Mercadorias, Long>{

    
    List<Mercadorias> findByTipo(String tipo);
    List<Mercadorias> findByMarca(String marca);
    
}
