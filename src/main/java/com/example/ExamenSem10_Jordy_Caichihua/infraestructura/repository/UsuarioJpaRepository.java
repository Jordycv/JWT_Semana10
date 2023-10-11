package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository;

import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity,Long> {
    UsuarioEntity findByUsuario(String usuario);
}
