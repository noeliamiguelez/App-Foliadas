package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> getAll();
    UsuarioDTO getById(int id);
    UsuarioDTO create(UsuarioDTO usuarioDTO);
    void delete(int id);

}
