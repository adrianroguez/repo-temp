package com.docencia.objetos.repo.json;

import com.docencia.objetos.domain.Rol;
import com.docencia.objetos.repo.interfaces.RolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RolJsonFileRepository implements RolRepository {

    private final Path path;
    private final ObjectMapper mapper;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public RolJsonFileRepository(Path path, ObjectMapper mapper) {
        this.path = null;
        this.mapper = null;
    }

    @Override
    public List<Rol> findAll() {
        return null;
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return null;
    }

    @Override
    public Optional<Rol> findByNombre(String nombre) {
        return null;
    }

    @Override
    public Rol save(Rol rol) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        
    }

    @Override
    public long count() {
        return 0;
    }

}
