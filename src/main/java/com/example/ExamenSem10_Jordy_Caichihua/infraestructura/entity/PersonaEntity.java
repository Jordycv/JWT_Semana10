package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Persona;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Where(clause = "estado = 1")
@Table(name="persons")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Integer estado;
    @Column(name = "fecha_crea")
    private Date fechaCrea;
    @Column(name = "fecha_mod")
    private Date fechaMod;

    public PersonaEntity(){

    }

    public PersonaEntity(Long id, String nombre, String apellidos, String direccion, String email,String telefono,Integer estado,Date fechaCrea,Date fechaMod) {
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

    public static PersonaEntity fromDomainModel(Persona persona){
        return new PersonaEntity(persona.getId(),persona.getNombre(), persona.getApellidos(), persona.getDireccion(), persona.getEmail(),persona.getTelefono(),persona.getEstado(),persona.getFechaCrea(),persona.getFechaMod());
    }
    public Persona toDomainModel(){
        return new Persona(id,nombre,apellidos,direccion,email,telefono,estado,fechaCrea,fechaMod);
    }
}
