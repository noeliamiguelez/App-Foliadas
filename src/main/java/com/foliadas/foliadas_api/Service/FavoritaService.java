package com.foliadas.foliadas_api.Service;

import com.foliadas.foliadas_api.DTO.FavoritaDTO;

import java.util.List;

public interface FavoritaService {

    List<FavoritaDTO> getAll();
    FavoritaDTO create(FavoritaDTO favoritaDTO);
    void delete(int id);
}
