package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "favorita", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "foliada_id"})
})
public class Favorita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "foliada_id", nullable = false)
    private Foliada foliada;

    public Favorita() {
    }

    public Favorita(int id, Usuario usuario, Foliada foliada) {
        this.id = id;
        this.usuario = usuario;
        this.foliada = foliada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Foliada getFoliada() {
        return foliada;
    }

    public void setFoliada(Foliada foliada) {
        this.foliada = foliada;
    }
}