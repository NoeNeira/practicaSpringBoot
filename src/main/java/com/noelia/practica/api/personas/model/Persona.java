package com.noelia.practica.api.personas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String nacionalidad;
    private GeneroEnum genero;
}
