package com.foliadas.foliadas_api.Controller;


import com.foliadas.foliadas_api.DTO.FavoritaDTO;
import com.foliadas.foliadas_api.Service.FavoritaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritas")
public class FavoritaController {

    @Autowired
    private final FavoritaService favoritaService;

    public FavoritaController(FavoritaService favoritaService) {
        this.favoritaService = favoritaService;
    }

    @GetMapping
    public ResponseEntity<List<FavoritaDTO>> getAll() {
        return ResponseEntity.ok(favoritaService.getAll());
    }

    @PostMapping
    public ResponseEntity<FavoritaDTO> create(@RequestBody FavoritaDTO favoritaDTO) {
        return ResponseEntity.ok(favoritaService.create(favoritaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        favoritaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
