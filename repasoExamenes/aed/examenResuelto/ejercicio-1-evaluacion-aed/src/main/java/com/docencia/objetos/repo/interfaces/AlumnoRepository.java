package com.docencia.objetos.repo.interfaces;

import com.docencia.objetos.domain.Alumno;
import java.util.List;
import java.util.Optional;

public interface AlumnoRepository {
  /**
   * Buscar todos los alumnos
   * 
   * @return
   */
  List<Alumno> findAll();

  /**
   * Buscar alumno por id
   * 
   * @param id
   * @return
   */
  Optional<Alumno> findById(Long id);

  /**
   * Guardar o actualizar un alumno
   * 
   * @param alumno
   * @return
   */
  Alumno save(Alumno alumno);

  /**
   * Comprobar si existe un alumno por email
   * 
   * @param email
   * @return
   */
  boolean existsByEmail(String email);

  /**
   * Eliminar un alumno por id
   * 
   * @param id
   */
  void deleteById(Long id);

  /**
   * Contar el numero de alumnos
   * 
   * @return
   */
  long count();

}
