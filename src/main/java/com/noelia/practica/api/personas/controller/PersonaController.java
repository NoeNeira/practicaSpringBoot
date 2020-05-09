package com.noelia.practica.api.personas.controller;

import com.noelia.practica.api.personas.model.GeneroEnum;
import com.noelia.practica.api.personas.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @GetMapping
    public List<Persona> getPersonas(){
        Persona p1 = new Persona("Carla", "Gonzalez", 37, "argentina", GeneroEnum.FEMENINO);
        Persona p2 = new Persona("Alberto", "Fernandez", 60, "argentina", GeneroEnum.MASCULINO);
        Persona p3 = new Persona("Sol", "Perez", 23, "argentina", GeneroEnum.OTRO);

        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);

        return personas;

    }
}
