package com.foliadas.foliadas_api.DTO;

public class FavoritaDTO {

    private int id;
    private UsuarioDTO usuario;
    private FoliadaDTO foliada;

    public FavoritaDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public FoliadaDTO getFoliada() {
        return foliada;
    }

    public void setFoliada(FoliadaDTO foliada) {
        this.foliada = foliada;
    }
}
