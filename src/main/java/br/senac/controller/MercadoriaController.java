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

import br.senac.model.Mercadorias;
import br.senac.service.MercadoriasService;


@RestController
@RequestMapping("/mercadorias")
@CrossOrigin(origins = "*")
public class MercadoriaController {
    
   @Autowired
    private MercadoriasService mercadoriasService;

    @PostMapping
    public Mercadorias SalvarMerc(@RequestBody Mercadorias merc){
        return mercadoriasService.salvarMerc(merc);
    }

    @GetMapping
    public List<Mercadorias> ListarTodos(){
        return mercadoriasService.ListarTodos();
    }

    @GetMapping("/id/{id}")
    public Mercadorias ListarID(@PathVariable Long id){
        
        return mercadoriasService.BuscarID(id); // não é list pq pega exatamente o id igual
    };

    @GetMapping("/marca/{marca}")
    public List<Mercadorias> ListarMarca(@PathVariable String marca){

        return mercadoriasService.buscarPorMarca(marca);
    }

    @GetMapping("/nomeMerc/{nomeMerc}")
    public List<Mercadorias> ListarNomeMerc(@PathVariable String nomeMerc){

        return mercadoriasService.buscarNomeMerc(nomeMerc);
    }

}
