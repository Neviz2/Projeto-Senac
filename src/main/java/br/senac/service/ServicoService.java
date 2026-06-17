package br.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senac.model.Servico;
import br.senac.repository.ServicoRepository;

@Service
public class ServicoService {
    

    @Autowired
    private ServicoRepository servicoRepository;

    public Servico SalvarServico(Servico servico){
        return servicoRepository.save(servico);
    };


    public List<Servico> ListarTodosServicos(){
        return servicoRepository.findAll();
    };

    public Servico BuscarIDServico(Long id){
        return servicoRepository.findById(id).orElse(null);
    };

    public List<Servico> BuscarPorClienteServico(String nome){ // buscar servico

       return servicoRepository.findByClienteNomeContainingIgnoreCase(nome);
    };

    public List<Servico> BuscarPormercServico(String mercadoria){ // buscar mercadoria

        return servicoRepository.findByMercadoriaNomeContainingIgnoreCase(mercadoria);
    };


}
