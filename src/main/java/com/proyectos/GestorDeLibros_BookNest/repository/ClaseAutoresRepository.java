package com.proyectos.GestorDeLibros_BookNest.repository;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseAutores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClaseAutoresRepository extends JpaRepository<ClaseAutores, Long> {
}
