package com.example.ExamenSem10_Jordy_Caichihua.application.service;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;
import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in.PersonaUseCase;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.in.UsuarioUseCase;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsuarioService implements UsuarioUseCase {
    private final UsuarioUseCase usuarioUseCase;

    public UsuarioService(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }
    @Autowired
    private PersonaUseCase personaUseCase;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        Persona persona =personaUseCase.getPersona(usuario.getPersonaId()).get();
        PersonaEntity personaEntity =PersonaEntity.fromDomainModel(persona);
        usuario.setPersonaEntity(personaEntity);
        return usuarioUseCase.crearUsuario(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {
        return usuarioUseCase.getUsuario(id);
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        return usuarioUseCase.loginWithUser(requestMap);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
        Usuario user = usuarioUseCase.getUsuario(id).orElse(null);
        usuario.setFechaMod(new Date());
        usuario.setFechaCrea(user.getFechaCrea());
        Persona persona =personaUseCase.getPersona(usuario.getPersonaId()).get();
        PersonaEntity personaEntity =PersonaEntity.fromDomainModel(persona);
        usuario.setPersonaEntity(personaEntity);
        return usuarioUseCase.updateUsuario(id,usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioUseCase.findAll();
    }

    @Override
    public Usuario deleteUsuario(Long id) {

        Usuario usuario = usuarioUseCase.getUsuario(id).orElse(null);
        usuario.setFechaMod(new Date());
        Integer estadoCero=0;
        usuario.setEstado(estadoCero);
        Persona persona =personaUseCase.getPersona(usuario.getPersonaId()).get();
        PersonaEntity personaEntity =PersonaEntity.fromDomainModel(persona);
        usuario.setPersonaEntity(personaEntity);
        usuario.setPersonaId(personaEntity.getId());
        return usuarioUseCase.updateUsuario(id,usuario).get();
    }
}
