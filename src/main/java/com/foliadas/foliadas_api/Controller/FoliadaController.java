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

    private static Logger LOG= LoggerFactory.getLogger(FoliadasApiApplication.class);

    public FoliadaController(FoliadaService foliadaService) {
        this.foliadaService = foliadaService;
    }

    @GetMapping
    public List<FoliadaDTO> getAll() {
        return foliadaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoliadaDTO> getById(@PathVariable int id) {
        return foliadaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}