package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String contrasinal;

    @Column(name = "fecha_rexistro")
    private LocalDateTime fecha_rexistro;

    @OneToMany(mappedBy = "usuario")
    private List<Favorita> favoritas;

    public Usuario() {}

    public Usuario(int id, String nome, String email, String contrasinal, LocalDateTime fecha_rexistro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.contrasinal = contrasinal;
        this.fecha_rexistro = fecha_rexistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    public LocalDateTime getFecha_rexistro() {
        return fecha_rexistro;
    }

    public void setFecha_rexistro(LocalDateTime fecha_rexistro) {
        this.fecha_rexistro = fecha_rexistro;
    }
}