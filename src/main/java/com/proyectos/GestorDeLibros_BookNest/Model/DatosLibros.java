package com.proyectos.GestorDeLibros_BookNest.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DatosAutor> DatosAutor,
        @JsonAlias("subjects") List<String> generos,
        @JsonAlias("languages") List<String> idiomasDisponibles,
        @JsonAlias("download_count") int numeroDeDescargas,
        @JsonAlias("copyright") Boolean derechoAutor
) {
}
