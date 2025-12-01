package com.docencia.personas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Objects;

@Document(collection = "roles")
public class Rol {

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    /**
     * Constructor vacio
     */
    public Rol() {
    }

    /**
     * Constructor por defecto
     * 
     * @param id     identificador unico
     * @param nombre del rol
     */
    public Rol(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor con el identificador del Rol
     * 
     * @param id Identificador unico
     */
    public Rol(String id) {
        this.id = id;
    }

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

    public Rol id(String id) {
        setId(id);
        return this;
    }

    public Rol nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rol)) {
            return false;
        }
        Rol rol = (Rol) o;
        return Objects.equals(id, rol.id);
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
                "}";
    }

}
