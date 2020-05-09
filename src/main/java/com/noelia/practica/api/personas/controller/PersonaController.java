package com.noelia.practica.api.personas.controller;

import com.noelia.practica.api.personas.model.GeneroEnum;
import com.noelia.practica.api.personas.model.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
    private ArrayList<Persona> personas;

    public PersonaController(){
        personas = new ArrayList<Persona>();

        Persona p1 = new Persona(1,"Carla", "Gonzalez", 37, "argentina", GeneroEnum.FEMENINO);
        Persona p2 = new Persona(2,"Alberto", "Fernandez", 60, "argentina", GeneroEnum.MASCULINO);
        Persona p3 = new Persona(3,"Sol", "Perez", 23, "argentina", GeneroEnum.OTRO);

        personas.add(p1);
        personas.add(p2);
        personas.add(p3);

    }


    @GetMapping
    public List<Persona> getPersonas(){
        return personas;
    }

    @GetMapping("/{id}")
    public Persona getPesona(@PathVariable int id){
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (id == persona.getId()){
                return persona;
            }
        }
        return null;
    }

    @PostMapping
    public Persona addPersona(@RequestBody Persona persona){
        personas.add(persona);
        return persona;
    }
}
