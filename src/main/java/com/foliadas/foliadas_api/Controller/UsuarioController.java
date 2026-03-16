package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.Model.Usuario;
import com.foliadas.foliadas_api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }

    @GetMapping
    public List<Usuario> getUsuarios() { return usuarioRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable int id) { return usuarioRepository.findById(id); }

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("El email ya está registrado");
        }
        usuario.setFecha_rexistro(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuarioLogin) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioLogin.getEmail());
        if (usuario.isPresent() && usuario.get().getContrasinal().equals(usuarioLogin.getContrasinal())) {
            return usuario.get();
        }
        throw new RuntimeException("Email o contraseña incorrectos");
    }
}