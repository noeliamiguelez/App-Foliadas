package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Model.Usuario;
import com.foliadas.foliadas_api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail())).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getById(int id) {
        Usuario u= usuarioRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        return new UsuarioDTO(u.getId(), u.getNome(), u.getEmail());
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        Usuario u= new Usuario();
        u.setNome(usuarioDTO.getNombre());
        u.setEmail(usuarioDTO.getEmail());

        u.setContrasinal("1234");
        Usuario saved= usuarioRepository.save(u);
        return new UsuarioDTO(saved.getId(), saved.getNome(), saved.getEmail());
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }
}
