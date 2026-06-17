package br.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.model.Clientes;
import br.senac.repository.ClientesRepository;

@Service
public class ClientesService {
 
    
    @Autowired
    private ClientesRepository ClientesRepository; // puxa o repository para utilizar no service


    public Clientes salvar(Clientes cliente){
        
        return ClientesRepository.save(cliente); // save é um comando nativo do spring que faz o insert no banco dentro da tabela clientes
    }

    public List<Clientes> listarTodos(){

        return ClientesRepository.findAll();

    };

    public List<Clientes> buscarPorNome(String nome){

    return ClientesRepository.findByNome(nome);

    };    

    public List<Clientes> buscarPorCpf(String cfp){

        return ClientesRepository.findBycpf(cfp);
    };

}
