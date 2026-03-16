package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Provincia;
import com.foliadas.foliadas_api.Repository.FoliadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foliadas")
public class FoliadaController {

    @Autowired
    private final FoliadaRepository foliadaRepository;

    public FoliadaController(FoliadaRepository foliadaRepository) {
        this.foliadaRepository = foliadaRepository;
    }

    @GetMapping
    public List<Foliada> listarFoliadas() { return foliadaRepository.findAll(); }

    @GetMapping("/{id}")
    public Optional<Foliada> listarPorId(@PathVariable int id) { return foliadaRepository.findById(id); }

    @GetMapping("/buscar")
    public List<Foliada> buscarFoliadas(@RequestParam String nombre) {
        return foliadaRepository.findByNomeContainingIgnoreCase(nombre);
    }

    @GetMapping("/provincia/{provincia}")
    public List<Foliada> listarPorProvincia(@PathVariable String provincia) {
        return foliadaRepository.findByProvincia(Provincia.valueOf(provincia.toUpperCase()));
    }

    @PostMapping("/añadir")
    public Foliada crearFoliada(@RequestBody Foliada foliada) { return foliadaRepository.save(foliada); }

    @PutMapping("/actualizar/{id}")
    public Foliada actualizarFoliada(@PathVariable int id, @RequestBody Foliada nuevaFoliada) {
        return foliadaRepository.findById(id)
                .map(foliada -> {
                    foliada.setNome(nuevaFoliada.getNome());
                    foliada.setFecha(nuevaFoliada.getFecha());
                    foliada.setHora(nuevaFoliada.getHora());
                    foliada.setLugar(nuevaFoliada.getLugar());
                    foliada.setProvincia(nuevaFoliada.getProvincia());
                    foliada.setDescripcion(nuevaFoliada.getDescripcion());
                    foliada.setLatitude(nuevaFoliada.getLatitude());
                    foliada.setLonxitude(nuevaFoliada.getLonxitude());
                    foliada.setImaxe(nuevaFoliada.getImaxe());
                    return foliadaRepository.save(foliada);
                }).orElseThrow(() -> new RuntimeException("Foliada no encontrada"));
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarFoliada(@PathVariable int id) { foliadaRepository.deleteById(id); }
}