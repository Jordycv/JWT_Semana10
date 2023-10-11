package com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaUseCase {
    Persona crearPersona(Persona persona);

    Optional<Persona> getPersona(Long id);

    Optional<Persona> updatePersona(Long id, Persona persona);
    Persona deletePersona(Long id);
    List<Persona> findAll();
}
