package br.senac.service;

import br.senac.model.Usuario;
import br.senac.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new IllegalArgumentException("O e-mail não pode ser vazio!");
        }
        return repository.save(usuario);
    }

    public Optional<Usuario> autenticarLogin(String email, String senha) {
        // O Service pede a informação para o Repository
        return repository.findByEmailAndSenha(email, senha);
    }
}