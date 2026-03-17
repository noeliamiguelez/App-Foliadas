package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.GrupoDTO;
import com.foliadas.foliadas_api.Model.Grupo;
import com.foliadas.foliadas_api.Repository.GrupoRepository;
import com.foliadas.foliadas_api.Service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private final GrupoService grupoService;

    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping
    public ResponseEntity<List<GrupoDTO>> getAllGrupos() {
        return ResponseEntity.ok(grupoService.getALl());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrupoDTO> getGrupoById(@PathVariable int id) {
        return ResponseEntity.ok(grupoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<GrupoDTO> createGrupo(@RequestBody GrupoDTO grupoDTO) {
        return ResponseEntity.ok(grupoService.create(grupoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable int id) {
        grupoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}