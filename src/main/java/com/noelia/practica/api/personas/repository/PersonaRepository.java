package com.noelia.practica.api.personas.repository;

import com.noelia.practica.api.personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
//    Aca declaro los metodos de crudrepository que voy a usar
    List<Persona> findAll();

    Optional<Persona> findById(Long id);

    // Método Save de JpaRepository está implicíto en CRUDRepository.

    // Método Delete de JpaRepository está implicíto en CRUDRepository.
}
