package com.proyectos.GestorDeLibros_BookNest.UserLibrary;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseAutores;
import com.proyectos.GestorDeLibros_BookNest.Model.ClaseLibros;
import com.proyectos.GestorDeLibros_BookNest.Model.DatosLibros;
import com.proyectos.GestorDeLibros_BookNest.Model.mainDatos;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseAutoresRepository;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseLibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GuardadoLibro {

    public void registrarLibro(DatosLibros datos, ClaseAutores autor, ClaseLibrosRepository repository_libros, ClaseAutoresRepository repository_autores){
        Optional<ClaseAutores> autorExistente = repository_autores.findBynombreAutorContainsIgnoreCase(autor.getNombreAutor());
        System.out.println(autorExistente);

        if (autorExistente.isPresent()){
            autor = autorExistente.get();
        }else{
            repository_autores.save(autor);
        }

        ClaseLibros libro = new ClaseLibros(datos,autor);
        repository_libros.save(libro);
    }
}
