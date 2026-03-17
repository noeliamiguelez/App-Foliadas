package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.FoliadasApiApplication;
import com.foliadas.foliadas_api.Service.FoliadaService;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/foliadas")
public class FoliadaController {

        private final FoliadaService foliadaService;

        public FoliadaController(FoliadaService foliadaService) {
            this.foliadaService = foliadaService;
        }

        // 🔹 GET todas las foliadas
        @GetMapping
        public ResponseEntity<List<FoliadaDTO>> getAllFoliadas() {
            return ResponseEntity.ok(foliadaService.getAll());
        }

        // 🔹 GET foliada por ID
        @GetMapping("/{id}")
        public ResponseEntity<FoliadaDTO> getFoliadaById(@PathVariable int id) {
            return ResponseEntity.ok(foliadaService.getById(id));
        }

        // 🔹 POST crear nueva foliada
        @PostMapping
        public ResponseEntity<FoliadaDTO> createFoliada(@RequestBody FoliadaDTO foliadaDTO) {
            return ResponseEntity.ok(foliadaService.create(foliadaDTO));
        }

        // 🔹 DELETE eliminar foliada
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteFoliada(@PathVariable int id) {
            foliadaService.delete(id);
            return ResponseEntity.noContent().build();
        }
}