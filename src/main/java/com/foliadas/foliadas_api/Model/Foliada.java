package com.foliadas.foliadas_api.Model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name="foliada")
public class Foliada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private LocalDate fecha;

    private Timestamp hora;

    private String lugar;

    @Enumerated(EnumType.STRING)
    private Provincia provincia;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String imaxe;

    private Double latitude;

    private Double lonxitude;

    public Foliada() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Timestamp getHora() { return hora; }
    public void setHora(Timestamp hora) { this.hora = hora; }

    public String getLugar() { return lugar; }
    public void setLugar(String lugar) { this.lugar = lugar; }

    public Provincia getProvincia() { return provincia; }
    public void setProvincia(Provincia provincia) { this.provincia = provincia; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImaxe() { return imaxe; }
    public void setImaxe(String imaxe) { this.imaxe = imaxe; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLonxitude() { return lonxitude; }
    public void setLonxitude(Double lonxitude) { this.lonxitude = lonxitude; }
}