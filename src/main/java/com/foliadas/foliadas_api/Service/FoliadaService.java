package com.foliadas.foliadas_api.Service;


import com.foliadas.foliadas_api.DTO.FoliadaDTO;

import java.util.List;

public interface FoliadaService {

    List<FoliadaDTO> getAll();
    FoliadaDTO getById(int id);
    FoliadaDTO create(FoliadaDTO foliadaDTO);
    void delete(int id);

}
