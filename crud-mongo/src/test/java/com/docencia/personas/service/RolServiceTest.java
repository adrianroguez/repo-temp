package com.docencia.personas.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.docencia.personas.model.Rol;
import com.docencia.personas.services.IRolesService;

@SpringBootTest
public class RolServiceTest {
    private static final String ROL_1 = "ROL-1";
    private static final String ROL_NOMBRE = "ROL-1";
    IRolesService iRolesService;
    Rol rol;

    @Autowired
    public void setIRolesService(IRolesService iRolesService) {
        this.iRolesService = iRolesService;
    }

    @BeforeEach
    void setup() {
        if (rol == null) {
            rol = new Rol(ROL_1, ROL_NOMBRE);
        }
        iRolesService.save(rol);
    }

    @Test
    void findByTest() {
        Rol rolFind = new Rol(ROL_1);
        rolFind = iRolesService.findBy(rolFind);
        Assertions.assertNotNull(rolFind);
        Assertions.assertEquals(rol, rolFind);
        Assertions.assertEquals(ROL_1, rolFind.getId());
        Assertions.assertEquals(ROL_NOMBRE, rolFind.getNombre());
    }

    @AfterEach
    void afterEach() {
        Rol rolDelete = new Rol(ROL_1);
        iRolesService.delete(rolDelete);
        rolDelete = iRolesService.findBy(rolDelete);
        Assertions.assertNull(rolDelete);
    }

}
