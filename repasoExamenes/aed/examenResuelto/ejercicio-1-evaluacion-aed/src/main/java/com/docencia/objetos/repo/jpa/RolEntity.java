package com.docencia.objetos.repo.jpa;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class RolEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String nombre;

  @OneToMany(mappedBy = "rol")
  private List<AlumnoEntity> alumnos = new ArrayList<>();
  
  public RolEntity() {
  }
  
  public RolEntity(Long id) {
    this.id = id;
  }

  public RolEntity(Long id, String nombre, List<AlumnoEntity> alumnos) {
    this.id = id;
    this.nombre = nombre;
    this.alumnos = alumnos;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<AlumnoEntity> getAlumnos() {
    return this.alumnos;
  }

  public void setAlumnos(List<AlumnoEntity> alumnos) {
    this.alumnos = alumnos;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof RolEntity)) {
      return false;
    }
    RolEntity rolEntity = (RolEntity) o;
    return Objects.equals(id, rolEntity.id);
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
        ", alumnos='" + getAlumnos() + "'" +
        "}";
  }

}
