package com.proyectos.GestorDeLibros_BookNest.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombreAutor,
        @JsonAlias("birth_year") int yearNacimiento,
        @JsonAlias("death_year") int yearFallecimiento
) {
}
