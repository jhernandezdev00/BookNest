package com.proyectos.GestorDeLibros_BookNest.Main;

import com.proyectos.GestorDeLibros_BookNest.Model.ClaseAutores;
import com.proyectos.GestorDeLibros_BookNest.Model.mainDatos;
import com.proyectos.GestorDeLibros_BookNest.Model.mapeoResultados;
import com.proyectos.GestorDeLibros_BookNest.Services.ConverDatos;
import com.proyectos.GestorDeLibros_BookNest.Services.GestionAPI;
import com.proyectos.GestorDeLibros_BookNest.UserLibrary.GuardadoLibro;
import com.proyectos.GestorDeLibros_BookNest.UserLibrary.SeleccionLibro;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseAutoresRepository;
import com.proyectos.GestorDeLibros_BookNest.repository.ClaseLibrosRepository;

import java.util.List;
import java.util.Map;
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
    private final mapeoResultados mapResult = new mapeoResultados();
    private final mapeoResultados.idiomasLibros idiomas = new mapeoResultados.idiomasLibros();
    private Map<String, String> listIdiomas;

    private ClaseLibrosRepository repositorio_Libros;
    private ClaseAutoresRepository repositorio_Autores;

    public mainClass(ClaseLibrosRepository repository_Libros, ClaseAutoresRepository repository_autores) {
        this.repositorio_Libros = repository_Libros;
        this.repositorio_Autores = repository_autores;
    }

    public void getMenu(){
        listIdiomas =  idiomas.listarIdiomas();

        do{
            System.out.println("\n======== MENÚ PRINCIPAL ========");
            System.out.println("DIGITE UN NUMERO PARA ESCOGER UNA OPCION");
            System.out.println("1. BUSCAR NUEVOS LIBRO POR TITULO");
            System.out.println("2. LISTAR LIBROS REGISTRADOS");
            System.out.println("3. LISTAR AUTORES REGISTRADOS");
            System.out.println("4. LISTAR AUTORES VIVOS POR DETERMINADO RANGO DE AÑO");
            System.out.println("5. LISTAR LIBROS POR IDIOMA");
            System.out.println("0. SALIR");
            System.out.print("Selecciona una opción: ");
            opcion = scannerint.nextInt();

            System.out.println("\n================================= ");

            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Ingrese el nombre del libro a buscar:");
                    String libroBuscar = scanner.nextLine();
                    libroBuscar = libroBuscar.toUpperCase();
                    searchBook(libroBuscar);
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    listAuthorsPerYear();
                    break;
                case 5:
                    searchBookPerLanguages();
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
            ClaseAutores autor;
            try {
                autor = new ClaseAutores(datosBusqueda.listaResultados().get(seleccion_Libro).DatosAutor().get(0));
            } catch (Exception e) {
                autor = new ClaseAutores();
            }
            saveBook.registrarLibro(datosBusqueda.listaResultados().get(seleccion_Libro),autor,repositorio_Libros, repositorio_Autores);
        }else{
            System.out.println("==== LIBRO NO ENCONTRADO ====");
        }
    }

    private void listBooks(){
        System.out.println("=== LISTA DE LIBROS REGISTRADOS ===");
        List<Object[]> resultados = repositorio_Libros.listarlibros();
        mapResult.mapeoResultadosBooks(resultados);
    }

    private void listAuthors() {
        System.out.println("=== LISTA DE AUTORES REGISTRADOS ===");
        List<ClaseAutores> resultadosAutores = repositorio_Autores.listarAutores();
        mapResult.mapeoResultadosAuthors(resultadosAutores);
    }

    private void listAuthorsPerYear() {
        System.out.println("Registre el Año de Inicio de la Busqueda");
        int yearInicio = scannerint.nextInt();
        System.out.println("Registre el Año de Fin de la Busqueda");
        int yearFinalizacion = scannerint.nextInt();

        if(yearFinalizacion<yearInicio){
            int variableTemporal;
            variableTemporal = yearFinalizacion;
            yearFinalizacion = yearInicio;
            yearInicio = variableTemporal;
        }

        try {
            List<ClaseAutores> resultadosAutoresPerYear = repositorio_Autores.listarAutoresPerYear(yearInicio, yearFinalizacion);
            System.out.println("ESCRITORES VIVOS ENTRE " +yearInicio+" -- "+yearFinalizacion);
            mapResult.mapeoResultadosAuthors(resultadosAutoresPerYear);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void searchBookPerLanguages() {
        for (Map.Entry<String, String> entry : listIdiomas.entrySet()) {
            System.out.println("Código: " + entry.getKey() + " - Idioma: " + entry.getValue());
        }

        System.out.println("Ingrese el codigo del idioma a buscar: ");
        String codigoIdioma = scanner.nextLine().trim().toLowerCase();

        if (listIdiomas.containsKey(codigoIdioma)) {
            List<Object[]> resultadosLibros = repositorio_Libros.listarlibrosPerlanguages(codigoIdioma);
            mapResult.mapeoResultadosBooks(resultadosLibros);
        } else {
            System.out.println("El código de idioma ingresado no es válido. Por favor ingrese un código correcto.");
        }
    }

}
