package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.Model.Favorita;
import com.foliadas.foliadas_api.Repository.FavoritaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/favoritas")
public class FavoritaController {

    @Autowired
    private final FavoritaRepository favoritaRepository;

    public FavoritaController(FavoritaRepository favoritaRepository) {
        this.favoritaRepository = favoritaRepository;
    }

    @GetMapping
    public List<Favorita> findAll() { return favoritaRepository.findAll(); }

    @GetMapping("usuario/{usuario_id}")
    public List<Favorita> getFavoritasUsuario(@PathVariable int usuario_id) {
        return favoritaRepository.findByUsuarioId(usuario_id);
    }

    @PostMapping("/guardar/{id}")
    public Favorita guardarFavorita(@RequestBody Favorita favorita) {
        return favoritaRepository
                .findByUsuarioIdAndFoliadaId(favorita.getUsuarioId(), favorita.getFoliadaId())
                .orElseGet(() -> favoritaRepository.save(favorita));
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarFavorita(@PathVariable int id) { favoritaRepository.deleteById(id); }
}
