package com.proyectos.GestorDeLibros_BookNest;

import com.proyectos.GestorDeLibros_BookNest.Main.mainClass;
import com.proyectos.GestorDeLibros_BookNest.Model.ClaseAutores;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseAutoresRepository;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseLibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestorDeLibrosBookNestApplication implements CommandLineRunner {

	@Autowired
	private ClaseLibrosRepository repository_libros;
	private ClaseAutoresRepository repository_autores;

	public static void main(String[] args) {
		SpringApplication.run(GestorDeLibrosBookNestApplication.class, args);
	}

	@Override
	public void run(String... args) throws  Exception {
		mainClass main = new mainClass(repository_libros, repository_autores);
		main.getMenu();
	}

}
