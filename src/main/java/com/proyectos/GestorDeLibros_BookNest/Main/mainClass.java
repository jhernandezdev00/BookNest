package com.proyectos.GestorDeLibros_BookNest.Main;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseAutores;
import com.proyectos.GestorDeLibros_BookNest.Model.ClaseLibros;
import com.proyectos.GestorDeLibros_BookNest.Model.mainDatos;
import com.proyectos.GestorDeLibros_BookNest.Services.ConverDatos;
import com.proyectos.GestorDeLibros_BookNest.Services.GestionAPI;
import com.proyectos.GestorDeLibros_BookNest.UserLibrary.GuardadoLibro;
import com.proyectos.GestorDeLibros_BookNest.UserLibrary.SeleccionLibro;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseAutoresRepository;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseLibrosRepository;

import java.util.Scanner;

public class mainClass {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scannerint = new Scanner(System.in);
    private int opcion;
    int seleccion_Libro;

    private static final String URL_BASE = "https://gutendex.com/books/";
    private final GestionAPI API = new GestionAPI();
    private final ConverDatos convertdatos = new ConverDatos();
    private final SeleccionLibro selectBook = new SeleccionLibro();
    private final GuardadoLibro saveBook = new GuardadoLibro();

    private ClaseLibrosRepository repositorio_Libros;
    private ClaseAutoresRepository repositorio_Autores;

    public mainClass(ClaseLibrosRepository repository_Libros, ClaseAutoresRepository repository_autores) {
        this.repositorio_Libros = repository_Libros;
        this.repositorio_Autores = repository_autores;
    }


    public void getMenu(){
        do{
            System.out.println("\n======== MENÚ PRINCIPAL ========");
            System.out.println("\nDIGITE UN NUMERO PARA ESCOGER UNA OPCION");
            System.out.println("\n1. BUSCAR NUEVOS LIBRO POR TITULO");
            System.out.println("2. MOSTRAR INFORMACION DE UN LIBRO REGISTRADOS");
            System.out.println("3. MOSTRAR LIBROS POR GENERO");
            System.out.println("X. LISTAR AUTORES REGISTRADOS");
            System.out.println("X. LISTAR AUTORES VIVOS POR AÑO");
            System.out.println("X. LISTAR LIBROS POR IDIOMA");
            System.out.println("0. SALIR");
            System.out.print("Selecciona una opción: ");
            opcion = scannerint.nextInt();

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Ingrese el nombre del libro a buscar:");
                    String libroBuscar = scanner.nextLine();
                    libroBuscar = libroBuscar.toUpperCase();
                    searchBook(libroBuscar);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        }while (opcion != 0);
        scanner.close();
        scannerint.close();
    }

    private void searchBook(String libroBuscar) {
        var json = API.getDatos(URL_BASE + "?search=" + libroBuscar.replace(" ", "+"));
        mainDatos datosBusqueda = convertdatos.getDatos(json, mainDatos.class);
        seleccion_Libro = selectBook.selectLibro(datosBusqueda);

        if(seleccion_Libro != -1){
            System.out.println(seleccion_Libro);
            System.out.println(datosBusqueda.listaResultados().get(seleccion_Libro).DatosAutor().get(0));
            ClaseAutores autor = new ClaseAutores(datosBusqueda.listaResultados().get(seleccion_Libro).DatosAutor().get(0));
            saveBook.registrarLibro(datosBusqueda.listaResultados().get(seleccion_Libro),autor,repositorio_Libros, repositorio_Autores);
        }else{
            System.out.println("==== LIBRO NO ENCONTRADO ====");
        }

    }

}
