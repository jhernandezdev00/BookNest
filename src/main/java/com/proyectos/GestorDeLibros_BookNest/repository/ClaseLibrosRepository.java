package com.proyectos.GestorDeLibros_BookNest.repository;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseLibros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClaseLibrosRepository extends JpaRepository<ClaseLibros, Long> {
    Optional<ClaseLibros> findBytituloLibroContainsIgnoreCase(String tituloLibro);

    @Query("SELECT l.tituloLibro, a.nombreAutor, l.idiomaDisponible, l.generosLibro, l.numeroDeDescargas, l.derechoAutor FROM ClaseAutores a JOIN a.libros l")
    List<Object[]> listarlibros();

    @Query(value = "SELECT l.titulo_libro, ca.nombre_autor, l.idioma_disponible, l.generos_libro, l.numero_de_descargas, l.derecho_autor " +
            "FROM libros l JOIN autores ca ON ca.id = l.id_autor WHERE :idioma = ANY(l.idioma_disponible::text[])", nativeQuery = true)
    List<Object[]> listarlibrosPerlanguages(@Param("idioma") String idioma);

}
