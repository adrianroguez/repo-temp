package es.adrianroguez.repository.interfaces;

import java.util.List;
import java.util.Optional;

import es.adrianroguez.model.Persona;

public interface PersonaRepository {
    /**
     * Devuelve todas las personas almacenadas
     * 
     * @return Lista de personas
     */
    List<Persona> findAll();

    /**
     * Devuelve una persona por su id
     * 
     * @param id Identificador de la persona
     * @return Persona encontrada o null si no existe
     */
    Optional<Persona> findById(String id);

    /**
     * Almacena una persona
     * 
     * @param persona Persona a almacenar
     * @return Persona almacenada
     */
    Persona save(Persona persona);

    /**
     * Comprueba si una persona existe por su id
     * 
     * @param id Identificador de la persona
     * @return true si existe, false si no
     */
    boolean existsById(String id);

    /**
     * Elimina una persona por su id
     * 
     * @param id Identificador de la persona
     * @return true si se ha eliminado, false si no existia
     */
    boolean deleteById(String id);

    /**
     * Cuenta el numero de personas almacenadas
     * 
     * @return Numero de personas
     */
    Long count();
}
