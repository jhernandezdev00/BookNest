package com.proyectos.GestorDeLibros_BookNest.repository;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseLibros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClaseLibrosRepository extends JpaRepository<ClaseLibros, Long> {
    Optional<ClaseLibros> findBytituloLibroContainsIgnoreCase(String tituloLibro);

    @Query("SELECT l.tituloLibro, a.nombreAutor, l.idiomaDisponible, l.generosLibro, l.numeroDeDescargas, l.derechoAutor FROM ClaseAutores a JOIN a.libros l")
    List<Object[]> listarlibros();

}
