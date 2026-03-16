package com.foliadas.foliadas_api.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class FoliadaGrupo {

    @EmbeddedId
    private FoliadaGrupoId id;

    public FoliadaGrupoId getId() { return id; }
    public void setId(FoliadaGrupoId id) { this.id = id; }
}