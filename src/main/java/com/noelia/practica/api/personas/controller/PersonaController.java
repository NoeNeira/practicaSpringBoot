package com.noelia.practica.api.personas.controller;

import com.noelia.practica.api.personas.model.GeneroEnum;
import com.noelia.practica.api.personas.model.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
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
    public Persona getPersona(@PathVariable int id){
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
        int newId = this.getNewId(this.personas);
        persona.setId(newId);
        personas.add(persona);
        return persona; // devuelve la persona que agrega antes
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable int id, @RequestBody Persona persona){
        Persona p2 = null;

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == id){

                p2 = personas.get(i);

                p2.setNombre(persona.getNombre());
                p2.setApellido(persona.getApellido());
                p2.setEdad(persona.getEdad());
                p2.setGenero(persona.getGenero());
                p2.setNacionalidad(persona.getNacionalidad());

                personas.set(i, p2);
            }
        }
        return p2;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public Persona deletePersona(@PathVariable int id){
        Persona persona = null;

        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getId() == id){
                persona = personas.remove(i);
            }
        }
        return persona;
    }


    private int getNewId(ArrayList<Persona> personas){
        int idMax = personas.get(0).getId();

        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getId() > idMax){
                idMax = personas.get(i).getId();
            }
        }
        return idMax + 1;
    }
}
