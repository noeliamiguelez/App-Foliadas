package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.Model.Grupo;
import com.foliadas.foliadas_api.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private final GrupoRepository grupoRepository;

    public GrupoController(GrupoRepository grupoRepository) { this.grupoRepository = grupoRepository; }

    @GetMapping
    public List<Grupo> getGrupos() { return grupoRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Grupo> findGrupoById(@PathVariable int id) { return grupoRepository.findById(id); }

    @GetMapping("/buscar")
    public List<Grupo> findGrupoByNombre(@RequestParam String nombre) {
        return grupoRepository.findByNomeContainingIgnoreCase(nombre);
    }

    @PostMapping("/añadir")
    public Grupo crearGrupo(@RequestBody Grupo grupo) { return grupoRepository.save(grupo); }

    @PutMapping("/actualizar/{id}")
    public Grupo actualizarGrupo(@PathVariable int id, @RequestBody Grupo nuevoGrupo) {
        return grupoRepository.findById(id)
                .map(grupo -> {
                    grupo.setNome(nuevoGrupo.getNome());
                    grupo.setOrixen(nuevoGrupo.getOrixen());
                    grupo.setTipo(nuevoGrupo.getTipo());
                    return grupoRepository.save(grupo);
                }).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarGrupo(@PathVariable int id) { grupoRepository.deleteById(id); }
}