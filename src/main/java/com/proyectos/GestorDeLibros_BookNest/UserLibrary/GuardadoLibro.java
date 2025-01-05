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
        try{
            Optional<ClaseLibros> infolibro = repository_libros.findBytituloLibroContainsIgnoreCase(datos.titulo());
            Optional<ClaseAutores> autorExistente = repository_autores.findBynombreAutorContainsIgnoreCase(autor.getNombreAutor());

            if(infolibro.isPresent()){
                System.out.println("EL LIBRO YA ESTA REGISTRADO EN LA BASE DE DATOS");
            }else{
                if(autorExistente.isPresent()){
                    autor = autorExistente.get();
                }else{
                    repository_autores.save(autor);
                }
                ClaseLibros libro = new ClaseLibros(datos,autor);
                repository_libros.save(libro);
                System.out.println("===== LIBRO REGISTRADO CON EXITO =====");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
