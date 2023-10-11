package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out.PersonaRepositoryPort;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.PersonaEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PersonaJpaRepositoryAdapter implements PersonaRepositoryPort {
    private final PersonaJpaRepository personaJpaRepository;

    public PersonaJpaRepositoryAdapter(PersonaJpaRepository personaJpaRepository) {
        this.personaJpaRepository = personaJpaRepository;
    }


    @Override
    public Persona save(Persona persona) {
        PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
        personaEntity.setFechaCrea(new Date());
        personaEntity.setFechaMod(new Date());
        PersonaEntity savePersonaEntity = personaJpaRepository.save(personaEntity);
        return savePersonaEntity.toDomainModel();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaJpaRepository.findById(id).map(PersonaEntity::toDomainModel);

    }
    @Override
    public Optional<Persona> update(Long id, Persona persona) {
        Persona per = findById(id).get();
        if (personaJpaRepository.existsById(persona.getId())) {
            PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
            personaEntity.setFechaMod(new Date());
            personaEntity.setFechaCrea(per.getFechaCrea());
            PersonaEntity updatedPersonaEntity = personaJpaRepository.save(personaEntity);
            return Optional.of(updatedPersonaEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public Persona deleteById(Long id) {
        Persona personaExistente=findById(id).get();
        Integer estadoCero=0;
        personaExistente.setEstado(estadoCero);

        PersonaEntity usuarioEntity = PersonaEntity.fromDomainModel(personaExistente);
        usuarioEntity.setFechaMod(new Date());
        PersonaEntity saveUsuarioEntity = personaJpaRepository.save(usuarioEntity);

        return saveUsuarioEntity.toDomainModel();
    }

    @Override
    public List<Persona> getAll() {
        List<Persona> getPersona = personaJpaRepository.findAll().stream().map(PersonaEntity::toDomainModel).collect(Collectors.toList());
        return getPersona;
    }
}
