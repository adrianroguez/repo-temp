package es.adrianroguez.repository.jpa;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class PersonaEntity {
    @Id
    private String id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="edad")
    private int edad;

    /**
     * Constructor por defecto
     */
    public PersonaEntity() {
    }

    /**
     * Constructor con id
     * 
     * @param id Identificador de la personaI
     */
    public PersonaEntity(String id) {
        this.id = id;
    }

    /**
     * Constructor con todos los atributos
     * 
     * @param id     Identificador de la persona
     * @param nombre Nombre de la persona
     * @param edad   Edad de la persona
     */
    public PersonaEntity(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Override methods
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonaEntity)) {
            return false;
        }
        PersonaEntity persona = (PersonaEntity) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", edad='" + getEdad() + "'" +
                "}";
    }

}