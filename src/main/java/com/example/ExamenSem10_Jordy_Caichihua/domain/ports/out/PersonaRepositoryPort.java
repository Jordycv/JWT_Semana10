package com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaRepositoryPort {
    Persona save(Persona persona);
    Optional<Persona> findById(Long id);

    Optional<Persona> update(Long id, Persona persona);
    Persona deleteById(Long id);
    List<Persona> getAll();
}
