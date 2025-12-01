package com.docencia.objetos.repo.interfaces;

import com.docencia.objetos.domain.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository {
    /**
     * Buscar todos los roles
     * 
     * @return
     */
    List<Rol> findAll();

    /**
     * Buscar rol por id
     * 
     * @param id
     * @return
     */
    Optional<Rol> findById(Long id);

    /**
     * Buscar rol por nombre
     * 
     * @param nombre
     * @return
     */
    Optional<Rol> findByNombre(String nombre);

    /**
     * Guardar o actualizar un rol
     * 
     * @param rol
     * @return
     */
    Rol save(Rol rol);

    /**
     * Eliminar un rol por id
     * 
     * @param id
     */
    void deleteById(Long id);

    /**
     * Contar el numero de roles
     * 
     * @return
     */
    long count();
}
