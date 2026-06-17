package br.senac.model;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {


    public Servico(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;


    @ManyToOne
    @JoinColumn(name = "merc_id")
    private Mercadorias mercadoria;


    private String descServico;
    private String status;
    private LocalDate dataEnt;


    public Servico(Long id, Clientes cliente, Mercadorias mercadoria, String descServico, String status, LocalDate dataEnt){

        this.id = id;
        this.cliente = cliente;
        this.mercadoria = mercadoria;
        this.descServico = descServico;
        this.status = status;
        this.dataEnt = dataEnt;
        
    }

}
