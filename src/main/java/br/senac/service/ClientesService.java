package br.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.model.Clientes;
import br.senac.repository.ClientesRepository;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository; // puxa o repository para utilizar no service

    public Clientes salvar(Clientes cliente) {

        return clientesRepository.save(cliente);
    }

    public List<Clientes> ListarTodos() {

        return clientesRepository.findAll();
    }

    public Clientes BuscarID(Long id) {

        return clientesRepository.findById(id).orElse(null);
    }

    public List<Clientes> buscarNome(String nome) {

        return clientesRepository.findByNome(nome);

    }

    public List<Clientes> BuscarCpf(String cpf) {

        return clientesRepository.findByCpf(cpf);
    }

    public void deletar(Long id) // void pq não retorna e usa o delete do spring
    {
        clientesRepository.deleteById(id);
    }

}
