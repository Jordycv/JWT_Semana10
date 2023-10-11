package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity;

import com.example.ExamenSem10_Jordy_Caichihua.domain.model.Usuario;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Where(clause = "estado = 1")
@Table(name = "users")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String password;
    private Integer estado;
    @Column(name = "fecha_crea")
    private Date fechaCrea;
    @Column(name = "fecha_mod")
    private Date fechaMod;
    @OneToOne
    @JoinColumn(name = "persons_id",referencedColumnName = "id")
    private PersonaEntity personaEntity;

    public UsuarioEntity(Long id, String usuario, String password, Integer estado,Date fechaCrea,Date fechaMod, PersonaEntity personaEntity) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaMod = fechaMod;
        this.personaEntity = personaEntity;
    }

    public UsuarioEntity() {
    }

    public static UsuarioEntity fromDomainModel(Usuario usuario){
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getPassword(),
                usuario.getEstado(),
                usuario.getFechaCrea(),
                usuario.getFechaMod(),
                usuario.getPersonaEntity()
        );
    }
    public Usuario toDomainModel(){
        return new Usuario(id, usuario, password, estado, fechaCrea,fechaMod,personaEntity.getId());
    }
}
