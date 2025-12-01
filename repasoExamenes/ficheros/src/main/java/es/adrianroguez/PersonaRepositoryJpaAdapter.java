package es.adrianroguez;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import es.adrianroguez.model.Persona;
import es.adrianroguez.repository.interfaces.PersonaRepository;
import es.adrianroguez.repository.jpa.PersonaEntity;
import es.adrianroguez.repository.jpa.PersonaJpaRepository;

public class PersonaRepositoryJpaAdapter implements PersonaRepository {

    private final PersonaJpaRepository jpa;

    public PersonaRepositoryJpaAdapter(PersonaJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Persona> findAll() {
        List<PersonaEntity> personasEntities = jpa.findAll();
        return personasEntities.stream().map(p -> new Persona(p.getId(), p.getNombre(), p.getEdad()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Persona> findById(String id) {
        Optional<PersonaEntity> personaEntity = jpa.findById(id);
        return personaEntity.map(p -> new Persona(p.getId(), p.getNombre(), p.getEdad()));
    }

    @Override
    public Persona save(Persona persona) {
        PersonaEntity personaEntity = new PersonaEntity(persona.getId(), persona.getNombre(), persona.getEdad());
        PersonaEntity entitySaved = jpa.save(personaEntity);
        return new Persona(entitySaved.getId(), entitySaved.getNombre(), entitySaved.getEdad());
    }

    @Override
    public boolean existsById(String id) {
        return jpa.existsById(id);
    }

    @Override
    public boolean deleteById(String id) {
        if (jpa.existsById(id)) {
            jpa.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Long count() {
        return jpa.count();
    }

}
