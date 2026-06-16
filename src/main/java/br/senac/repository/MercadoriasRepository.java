package br.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.model.Mercadorias;

public interface MercadoriasRepository extends JpaRepository<Mercadorias, Long>{

    Mercadorias salvarMerc(Mercadorias merc);
    List<Mercadorias> findByNome(String nome);
    List<Mercadorias> findBymarca(String marca);
    
}
