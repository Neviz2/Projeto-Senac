package br.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.model.Mercadorias;
import br.senac.repository.MercadoriasRepository;

@Service
public class MercadoriasService {
    

    @Autowired
    private MercadoriasRepository mercadoriasrepository;

    public Mercadorias salvarMerc(Mercadorias merc){

        return mercadoriasrepository.save(merc); // usar save que é o padrão do spring
    }

    public List<Mercadorias> ListarTodos(){

        return mercadoriasrepository.findAll();
    }
    public Mercadorias BuscarID(Long id) { 

        return mercadoriasrepository.findById(id).orElse(null);
    }

    public List<Mercadorias> buscarNomeMerc(String nomeMerc){

        return mercadoriasrepository.findByTipo(nomeMerc);
    }

    public List<Mercadorias> buscarPorMarca(String marca){

        return mercadoriasrepository.findByMarca(marca);
    }
}
