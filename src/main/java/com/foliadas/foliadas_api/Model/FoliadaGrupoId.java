package com.foliadas.foliadas_api.Model;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FoliadaGrupoId {

    private int foliadaId;
    private int grupoId;

    public int getFoliada_id() { return foliadaId; }
    public void setFoliada_id(int foliada_id) { this.foliadaId = foliada_id; }

    public int getGrupo_id() { return grupoId; }
    public void setGrupo_id(int grupo_id) { this.grupoId = grupo_id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoliadaGrupoId)) return false;
        FoliadaGrupoId that = (FoliadaGrupoId) o;
        return foliadaId == that.foliadaId && grupoId == that.grupoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(foliadaId, grupoId);
    }
}
