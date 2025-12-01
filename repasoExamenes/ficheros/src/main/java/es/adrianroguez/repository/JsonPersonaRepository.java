package es.adrianroguez.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.adrianroguez.model.Persona;
import es.adrianroguez.repository.interfaces.PersonaRepository;

public class JsonPersonaRepository implements PersonaRepository {

    private final Path filePath;
    private final ObjectMapper objectMapper;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public JsonPersonaRepository(Path filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Persona> findAll() {
        lock.readLock().lock();
        try {
            return objectMapper.readValue(filePath.toFile(), new TypeReference<List<Persona>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Optional<Persona> findById(String id) {
        lock.readLock().lock();
        try {
            List<Persona> personas = objectMapper.readValue(filePath.toFile(), new TypeReference<List<Persona>>() {
            });
            return personas.stream().filter(p -> p.getId().equals(id)).findFirst();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Persona save(Persona persona) {
        lock.writeLock().lock();
        try {
            List<Persona> personas = objectMapper.readValue(filePath.toFile(), new TypeReference<List<Persona>>() {
            });
            personas.removeIf(p -> p.getId().equals(persona.getId()));
            personas.add(persona);
            objectMapper.writeValue(filePath.toFile(), personas);
            return persona;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public boolean existsById(String id) {
        lock.readLock().lock();
        try {
            List<Persona> personas = objectMapper.readValue(filePath.toFile(), new TypeReference<List<Persona>>() {
            });
            return personas.stream().anyMatch(p -> p.getId().equals(id));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean deleteById(String id) {
        lock.writeLock().lock();
        try {
            List<Persona> personas = objectMapper.readValue(filePath.toFile(), new TypeReference<List<Persona>>() {
            });
            boolean removed = personas.removeIf(p -> p.getId().equals(id));
            if (removed) {
                objectMapper.writeValue(filePath.toFile(), personas);
            }
            return removed;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Long count() {
        lock.readLock().lock();
        try {
            List<Persona> personas = objectMapper.readValue(filePath.toFile(), new TypeReference<List<Persona>>() {
            });
            return (long) personas.size();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.readLock().unlock();
        }
    }

}
