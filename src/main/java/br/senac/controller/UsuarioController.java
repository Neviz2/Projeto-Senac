package br.senac.controller;

import br.senac.model.Usuario;
import br.senac.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = service.salvarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario tentativaLogin) {
        
        Optional<Usuario> usuarioEncontrado = service.autenticarLogin(
                tentativaLogin.getEmail(), 
                tentativaLogin.getSenha()
        );

        if (usuarioEncontrado.isPresent()) {
            return ResponseEntity.ok(usuarioEncontrado.get());
        } 
        
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}