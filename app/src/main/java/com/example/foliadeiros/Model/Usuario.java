package com.example.foliadeiros.Model;

import java.util.HashSet;
import java.util.Set;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String password;

    private Set<Foliada> favoritas= new HashSet<>();

}
