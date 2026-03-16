package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grupo_id;

    private String nome;

    private String orixen;

    private String tipo;

    public Grupo() {}

    public int getGrupo_id() { return grupo_id; }
    public void setGrupo_id(int grupo_id) { this.grupo_id = grupo_id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getOrixen() { return orixen; }
    public void setOrixen(String orixen) { this.orixen = orixen; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}