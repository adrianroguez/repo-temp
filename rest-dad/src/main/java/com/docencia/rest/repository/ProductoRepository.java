package com.docencia.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.rest.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
