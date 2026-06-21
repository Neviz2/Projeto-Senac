package br.senac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.model.Servico;
import br.senac.service.ServicoService;


@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "*")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public Servico salvarServico(@RequestBody Servico servico){
        return servicoService.SalvarServico(servico);
    }

    @GetMapping
    public List<Servico> listarTodos(){
        return servicoService.ListarTodosServicos();
    }

    @GetMapping("/cliente/{nome}")
    public List<Servico> buscarPorCliente(@PathVariable String nome){
        return servicoService.BuscarPorClienteServico(nome);
    }
}
