package br.senac.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mercadorias") // informa a tabela do sql para o Spring
public class Mercadorias {

    public Mercadorias() { // precisa ter essa classe vazia para o String
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmerc;

    private String tipo;
    private String marca;
    private String descDefeito;
    private Double preco;

    public Mercadorias(String tipo, String marca, String descDefeito, Double preco){

        this.tipo = tipo;
        this.marca = marca;
        this.descDefeito = descDefeito;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescDefeito() {
        return descDefeito;
    }

    public void setDescDefeito(String descDefeito) {
        this.descDefeito = descDefeito;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

public Long getIdmerc() {
        return idmerc;
    }

    public void setIdmerc(Long idmerc) {
        this.idmerc = idmerc;
    }
}
