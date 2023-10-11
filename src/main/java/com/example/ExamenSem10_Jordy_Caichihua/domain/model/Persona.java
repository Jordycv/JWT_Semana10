package com.example.ExamenSem10_Jordy_Caichihua.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Persona {

    private Long id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Integer estado;
    @JsonIgnore
    private Date fechaCrea;
    @JsonIgnore
    private Date fechaMod;

    public Persona(Long id, String nombre, String apellidos,String direccion,String email,String telefono,Integer estado, Date fechaCrea, Date fechaMod) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
    }
}
