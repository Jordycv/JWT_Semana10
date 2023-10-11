package com.example.ExamenSem10_Jordy_Caichihua.application.useCase;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in.PersonaUseCase;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out.PersonaRepositoryPort;

import java.util.List;
import java.util.Optional;

public class PersonaUseCaseImpl implements PersonaUseCase {
    private final PersonaRepositoryPort personaRepositoryPort;

    public PersonaUseCaseImpl(PersonaRepositoryPort personaRepositoryPort) {
        this.personaRepositoryPort = personaRepositoryPort;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepositoryPort.save(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaRepositoryPort.findById(id);
    }

    @Override
    public Optional<Persona> updatePersona(Long id, Persona persona) {
        return personaRepositoryPort.update(id,persona);
    }

    @Override
    public Persona deletePersona(Long id) {
        return personaRepositoryPort.deleteById(id);
    }

    @Override
    public List<Persona> findAll() {
        return personaRepositoryPort.getAll();
    }
}
