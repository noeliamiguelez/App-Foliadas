package com.foliadas.foliadas_api.Controller;

import com.foliadas.foliadas_api.DTO.FoliadaDTO;
import com.foliadas.foliadas_api.DTO.UsuarioDTO;
import com.foliadas.foliadas_api.Model.Foliada;
import com.foliadas.foliadas_api.Model.Usuario;
import com.foliadas.foliadas_api.Repository.UsuarioRepository;
import com.foliadas.foliadas_api.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.create(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public Usuario update (@PathVariable int id, @RequestBody Usuario usuario){
        return usuarioService.update(id, usuario);
    }

    /*------------------------------------------
                      FAVORITAS
     ------------------------------------------*/

    @GetMapping("/{id}/favoritas")
    public Set<FoliadaDTO> getFavoritas(@PathVariable int id){
        return usuarioService.getFavoritas(id);
    }

    @PostMapping("/{id}/favoritas/{foliadaId}")
    public void addFavorita(@PathVariable int id, @PathVariable int foliadaId){
        usuarioService.addFavorita(id, foliadaId);
    }

    @DeleteMapping("/{id}/favoritas/{foliadaId}")
    public void removeFavorita(@PathVariable int id, @PathVariable int foliadaId){
        usuarioService.removeFavorita(id, foliadaId);
    }

}