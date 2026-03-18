package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.ProvinciaDTO;
import com.foliadas.foliadas_api.Service.ProvinciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provincias")
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping
    public ResponseEntity<List<ProvinciaDTO>> getAll() {
        return ResponseEntity.ok(provinciaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvinciaDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(provinciaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProvinciaDTO> create(@RequestBody ProvinciaDTO provinciaDTO) {
        return ResponseEntity.ok(provinciaService.create(provinciaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        provinciaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
