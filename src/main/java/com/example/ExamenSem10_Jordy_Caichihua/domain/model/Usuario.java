package com.example.ExamenSem10_Jordy_Caichihua.domain.model;

import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.PersonaEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Usuario {
    @Getter
    @Setter
    private Long id;
    @Getter @Setter private String usuario;
    @Getter @Setter private String password;
    @Getter @Setter private Integer estado;
    @JsonIgnore
    @Getter @Setter private Date fechaCrea;
    @JsonIgnore
    @Getter @Setter private Date fechaMod;
    @Getter @Setter private Long personaId;

    @JsonIgnore
    @Getter @Setter private PersonaEntity personaEntity;


    public Usuario(Long id, String usuario, String password, Integer estado,Date fechaCrea ,Date fechaMod, Long personaId) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
        this.personaId = personaId;
    }

}
