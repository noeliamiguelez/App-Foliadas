package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Usuario;
import com.foliadas.foliadas_api.Repository.FoliadaRepository;
import com.foliadas.foliadas_api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final FoliadaRepository foliadaRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, FoliadaRepository foliadaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.foliadaRepository = foliadaRepository;
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

    @Override
    public Usuario update(int id, Usuario usuario) {
        Usuario existente= usuarioRepository.findById(id).orElse(null);

        if (existente== null){
            return null;
        }
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());

        return usuarioRepository.save(existente);
    }

    @Override
    public Set<Foliada> getFavoritas(int usuarioId) {
        Usuario usuario= usuarioRepository.findById(usuarioId).orElse(null);
        return usuario != null ? usuario.getFavoritas() : new HashSet<>();

    }

    @Override
    public void addFavorita(int usuarioId, int foliadaId) {
        Usuario usuario= usuarioRepository.findById(usuarioId).orElse(null);
        Foliada foliada= foliadaRepository.findById(foliadaId).orElse(null);
        if (usuario != null && foliada != null){
            usuario.getFavoritas().add(foliada);
            usuarioRepository.save(usuario);
        }
    }

    @Override
    public void removeFavorita(int usuarioId, int foliadaId) {
        Usuario usuario= usuarioRepository.findById(usuarioId).orElse(null);
        Foliada foliada= foliadaRepository.findById(foliadaId).orElse(null);
        if (usuario != null && foliada != null){
            usuario.getFavoritas().remove(foliada);
            usuarioRepository.save(usuario);
        }
    }
}
