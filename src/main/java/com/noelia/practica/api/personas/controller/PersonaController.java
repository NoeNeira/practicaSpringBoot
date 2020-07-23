package com.noelia.practica.api.personas.controller;

import com.noelia.practica.api.personas.model.Persona;
import com.noelia.practica.api.personas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;


    public PersonaController(){
    }

    @GetMapping
    public List<Persona> getPersonas(){
        return this.personaService.getPersonas();
    }

    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable Long id){
        return this.personaService.getPersonaById(id);
    }

    @PostMapping
    public Persona addNewPersona(@RequestBody Persona persona){
        return this.personaService.addNewPersona(persona);
    }

    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona persona){
        return this.personaService.updatePersona(id, persona);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public Persona deletePersonaById(@PathVariable Long id){
        return this.personaService.deletePersonaById(id);
    }


/*    private int getNewId(ArrayList<Persona> personas){
        int idMax = personas.get(0).getId();

        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getId() > idMax){
                idMax = personas.get(i).getId();
            }
        }
        return idMax + 1;
    }

    */
}
