package com.proyectos.GestorDeLibros_BookNest.repository;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseLibros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaseLibrosRepository extends JpaRepository<ClaseLibros, Long> {
    Optional<ClaseLibros> findBytituloLibroContainsIgnoreCase(String tituloLibro);
}
