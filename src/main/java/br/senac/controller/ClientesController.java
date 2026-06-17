package br.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.model.Clientes;
import br.senac.service.ClientesService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {
    
    @Autowired
    private ClientesService clientesService;
    

    //  (POST)
    @PostMapping
    public Clientes salvarCliente(@RequestBody Clientes cliente) {
        return clientesService.salvar(cliente);
    }

    // (GET)
    @GetMapping
    public List<Clientes> listarTodos() {
        return clientesService.listarTodos();
    }
}
