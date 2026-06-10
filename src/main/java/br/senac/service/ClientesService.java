package br.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.model.Clientes;
import br.senac.repository.ClientesRepository;

@Service
public class ClientesService {
 
    
    @Autowired
    private ClientesRepository ClientesRepository; // puxa o repository para utilizar no service


    public Clientes salvar(Clientes cliente){
        
        return ClientesRepository.save(cliente);
    }







}
