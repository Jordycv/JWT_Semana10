package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.config;

import com.example.ExamenSem10_Jordy_Caichihua.application.service.PersonaService;
import com.example.ExamenSem10_Jordy_Caichihua.application.service.UsuarioService;
import com.example.ExamenSem10_Jordy_Caichihua.application.useCase.PersonaUseCaseImpl;
import com.example.ExamenSem10_Jordy_Caichihua.application.useCase.UsuarioUseCaseImpl;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out.PersonaRepositoryPort;
import com.example.ExamenSem10_Jordy_Caichihua.domain.ports.out.UsuarioRepositoryPort;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository.PersonaJpaRepositoryAdapter;
import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository.UsuarioJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PersonaService personaService(PersonaRepositoryPort personaRepositoryPort){
        return new PersonaService(new PersonaUseCaseImpl(personaRepositoryPort));
    }

    @Bean
    public PersonaRepositoryPort personaRepositoryPort(PersonaJpaRepositoryAdapter personaJpaRepositoryAdapter){
        return personaJpaRepositoryAdapter;
    }

    @Bean
    public UsuarioService usuarioService(UsuarioRepositoryPort usuarioRepositoryPort){
        return new UsuarioService(new UsuarioUseCaseImpl(usuarioRepositoryPort));
    }


    @Bean
    public UsuarioRepositoryPort usuarioRepositoryPort(UsuarioJpaRepositoryAdapter usuarioJpaRepositoryAdapter){
        return usuarioJpaRepositoryAdapter;
    }
}
