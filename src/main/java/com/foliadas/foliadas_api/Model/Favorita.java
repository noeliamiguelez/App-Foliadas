package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "favorita")
public class Favorita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favorita_id;

    private int usuarioId;

    private int foliadaId;

    public int getFavorita_id() { return favorita_id; }
    public void setFavorita_id(int favorita_id) { this.favorita_id = favorita_id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public int getFoliadaId() { return foliadaId; }
    public void setFoliadaId(int foliadaId) { this.foliadaId = foliadaId; }
}