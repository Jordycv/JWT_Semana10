package com.example.ExamenSem10_Jordy_Caichihua.infraestructura.repository;

import com.example.ExamenSem10_Jordy_Caichihua.infraestructura.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJpaRepository extends JpaRepository<PersonaEntity,Long> {
}
