package com.proyectos.GestorDeLibros_BookNest.repository;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseAutores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClaseAutoresRepository extends JpaRepository<ClaseAutores, Long> {
    Optional<ClaseAutores> findBynombreAutorContainsIgnoreCase(String nombreAutor);

    @Query("SELECT l FROM ClaseAutores l")
    List<ClaseAutores> listarAutores();

    @Query("SELECT l FROM ClaseAutores l WHERE l.yearNacimiento>= :yearInicio AND l.yearFallecimiento<= :yearFinalizacion")
    List<ClaseAutores> listarAutoresPerYear(int yearInicio, int yearFinalizacion);
}
