package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.Model.FoliadaGrupo;
import com.foliadas.foliadas_api.Model.FoliadaGrupoId;
import com.foliadas.foliadas_api.Repository.FoliadaGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/foliadaGrupo")
public class FoliadaGrupoController {

    @Autowired
    private final FoliadaGrupoRepository foliadaGrupoRepository;

    public FoliadaGrupoController(FoliadaGrupoRepository foliadaGrupoRepository) {
        this.foliadaGrupoRepository = foliadaGrupoRepository;
    }

    @GetMapping("/foliada/{foliada_id}")
    public List<FoliadaGrupo> getGruposDeFoliada(@PathVariable int foliada_id) {
        return foliadaGrupoRepository.findByIdFoliadaId(foliada_id);
    }

    @PostMapping("/añadir")
    public FoliadaGrupo agregarGrupoFoliada(@RequestBody FoliadaGrupoId id) {
        FoliadaGrupo relacion = new FoliadaGrupo();
        relacion.setId(id);
        return foliadaGrupoRepository.save(relacion);
    }

    @DeleteMapping("delete/{id}")
    public void eliminarGrupoFoliada(@RequestBody FoliadaGrupoId id) {
        foliadaGrupoRepository.deleteById(id);
    }
}