package com.noelia.practica.api.personas.service;

import com.noelia.practica.api.personas.model.Persona;
import com.noelia.practica.api.personas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService { //El service actua como intermediario entre el controller y el repository
    @Autowired
    private PersonaRepository personaRepository; //atributo del objeto. Insertado por springboot

//El @autowired equivale a un constructor con el atributo correspondiente
//    public PersonaService(PersonaRepository personaRepository) {
//        this.personaRepository = personaRepository;
//    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public Persona getPersonaById(Long id) { // Método llamado desde el controller, para pedir datos del repository
        return personaRepository.findById(id).get();
    }

    public Persona addNewPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona updatePersona(Long id, Persona persona) {
        Optional<Persona> personaEnDB = this.personaRepository.findById(id);

        if (personaEnDB.isPresent()) {
            persona.setId(id); // relaciona el id que paso por parámetro con el id del RequestBody, que lo trae de la URL del Controller
            return personaRepository.save(persona);
        }
        return null;
    }

    public Persona deletePersonaById(Long id) {
        Optional<Persona> personaEnDB = this.personaRepository.findById(id);

        if (personaEnDB.isPresent()) {
            personaRepository.deleteById(id);
            return personaEnDB.get();
        }
        return null;
    }
}
