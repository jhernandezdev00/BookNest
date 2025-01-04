package com.proyectos.GestorDeLibros_BookNest.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record mainDatos(
        @JsonAlias("results") List<DatosLibros> listaResultados
) {
}
