package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.FavoritaDTO;
import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Model.Favorita;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Usuario;
import com.foliadas.foliadas_api.Repository.FavoritaRepository;
import com.foliadas.foliadas_api.Repository.FoliadaRepository;
import com.foliadas.foliadas_api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoritaServiceImpl implements FavoritaService{

   @Autowired
   private final FavoritaRepository favoritaRepository;
   @Autowired
   private final UsuarioRepository usuarioRepository;
   @Autowired
   private final FoliadaRepository foliadaRepository;

    public FavoritaServiceImpl(FavoritaRepository favoritaRepository, UsuarioRepository usuarioRepository, FoliadaRepository foliadaRepository) {
        this.favoritaRepository = favoritaRepository;
        this.usuarioRepository = usuarioRepository;
        this.foliadaRepository = foliadaRepository;
    }

    @Override
    public List<FavoritaDTO> getAll() {
        return favoritaRepository.findAll().stream()
                .map(favorita -> {
                    FavoritaDTO dto= new FavoritaDTO();
                    dto.setId(favorita.getId());
                    dto.setUsuario(new UsuarioDTO(favorita.getUsuario().getId(), favorita.getUsuario().getNome(), favorita.getUsuario().getEmail()));
                    dto.setFoliada(new FoliadaDTO());
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public FavoritaDTO create(FavoritaDTO favoritaDTO) {
        Usuario u= usuarioRepository.findById(favoritaDTO.getUsuario().getId()).orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
        Foliada f= foliadaRepository.findById(favoritaDTO.getFoliada().getId()).orElseThrow(()-> new RuntimeException("Foliada no encontrada"));

        Favorita fav= new Favorita();
        fav.setUsuario(u);
        fav.setFoliada(f);
        Favorita saved= favoritaRepository.save(fav);

        FavoritaDTO dto= new FavoritaDTO();
        dto.setId(saved.getId());
        dto.setUsuario(new UsuarioDTO(u.getId(), u.getNome(), u.getEmail()));
        dto.setFoliada(new FoliadaDTO());
        return dto;
    }

    @Override
    public void delete(int id) {
        favoritaRepository.deleteById(id);
    }
}
