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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Mercadorias getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(Mercadorias mercadoria) {
        this.mercadoria = mercadoria;
    }

    public String getDescServico() {
        return descServico;
    }

    public void setDescServico(String descServico) {
        this.descServico = descServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataEnt() {
        return dataEnt;
    }

    public void setDataEnt(LocalDate dataEnt) {
        this.dataEnt = dataEnt;
    }

}
