package com.docencia.objetos.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolJpaRepository extends JpaRepository<RolEntity, Long> {
    /**
     * Buscar rol por nombre
     * 
     * @param nombre
     * @return
     */
    boolean existsByNombre(String nombre);

}
