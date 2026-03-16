package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuario_id;

    private String nome;

    private String email;

    private String contrasinal;

    private LocalDateTime fecha_rexistro;

    public Usuario() {}

    public int getUsuario_id() { return usuario_id; }
    public void setUsuario_id(int usuario_id) { this.usuario_id = usuario_id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getContrasinal() { return contrasinal; }
    public void setContrasinal(String contrasinal) { this.contrasinal = contrasinal; }

    public LocalDateTime getFecha_rexistro() { return fecha_rexistro; }
    public void setFecha_rexistro(LocalDateTime fecha_rexistro) { this.fecha_rexistro = fecha_rexistro; }
}