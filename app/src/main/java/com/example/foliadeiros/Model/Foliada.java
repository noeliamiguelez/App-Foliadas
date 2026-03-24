package com.example.foliadeiros.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Foliada {

    private int id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String lugar;
    private String descripcion;
    private Double latitude;
    private Double lonxitude;
    private String imaxe;

    private Provincia provincia;

    private Set<Grupo> grupos= new HashSet<>();

}
