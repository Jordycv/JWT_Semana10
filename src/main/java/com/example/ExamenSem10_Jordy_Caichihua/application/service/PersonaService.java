package com.example.ExamenSem10_Jordy_Caichihua.application.service;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in.PersonaUseCase;

import java.util.List;
import java.util.Optional;

public class PersonaService implements PersonaUseCase {
    private final PersonaUseCase personaUseCase;


    public PersonaService(PersonaUseCase personaUseCase){
        this.personaUseCase=personaUseCase;
    }
    @Override
    public Persona crearPersona(Persona persona) {

        return personaUseCase.crearPersona(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaUseCase.getPersona(id);
    }

    @Override
    public Optional<Persona> updatePersona(Long id, Persona persona) {
        return personaUseCase.updatePersona(id,persona);
    }

    @Override
    public Persona deletePersona(Long id) {

        return personaUseCase.deletePersona(id);
    }

    @Override
    public List<Persona> findAll() {
        return personaUseCase.findAll();
    }
}
