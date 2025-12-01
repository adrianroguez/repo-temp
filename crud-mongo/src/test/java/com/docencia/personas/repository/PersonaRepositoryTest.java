package com.docencia.personas.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;

@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {

    private Persona personaFind;
    private PersonaRepository personaRepository;
    private Persona personaCollection;
    Direccion direccion;
    private String email = "un@email.com";

    @Autowired
    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDataBase() {
        personaRepository.deleteAll();
        direccion = new Direccion("Una calle", "Una Ciudad", "12345", "Viva España");
        personaCollection = new Persona("test", 18, email, direccion);
        personaRepository.save(personaCollection);
        personaFind = personaRepository.save(personaCollection);
    }

    @Test
    void testFind() {
        Assertions.assertEquals(1, personaRepository.count());
        Assertions.assertNotNull(personaFind);
        Assertions.assertNotNull(personaFind.getId());
    }

    @Test
    void testFindByEmail() {
        personaRepository.findByEmail(email);
        Assertions.assertEquals(email, direccion);
    }

    @Test
    void testFindByNombreContainingIgnoreCase() {

    }

    @Test
    void testFindByEdadBetween() {

    }

    @Test
    void testFindByCiudad() {
        List<Persona> PersonasByCiudad = personaRepository.findByCiudad(email);
        Assertions.assertEquals(email, PersonasByCiudad.getFirst().getEmail());
    }

}
