package br.senac.model; // Ajuste para o seu pacote

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String senha;
    private String usuario;
    private String email;

    // Construtor vazio (obrigatório para o Spring)
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(Long idUsuario, String senha, String usuario, String email) {
        this.idUsuario = idUsuario;
        this.senha = senha;
        this.usuario = usuario;
        this.email = email;
    }

    // --- GETTERS E SETTERS (Essenciais para o JSON funcionar) ---
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}