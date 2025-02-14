package com.proyectos.GestorDeLibros_BookNest.Model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "Libros")
public class ClaseLibros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String tituloLibro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private ClaseAutores autor;

    private String[] generosLibro;
    private String[] idiomaDisponible;
    private int numeroDeDescargas;
    private boolean derechoAutor;

    public ClaseLibros() {

    }

    public ClaseLibros(DatosLibros libros, ClaseAutores autor){
        this.tituloLibro = libros.titulo();
        this.autor = autor;
        this.generosLibro = libros.generos().toArray(new String[0]);
        this.idiomaDisponible = libros.idiomasDisponibles().toArray(new String[0]);
        this.numeroDeDescargas = libros.numeroDeDescargas();
        this.derechoAutor = libros.derechoAutor();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public boolean isDerechoAutor() {
        return derechoAutor;
    }

    public void setDerechoAutor(boolean derechoAutor) {
        this.derechoAutor = derechoAutor;
    }

    public int getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(int numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public String[] getIdiomaDisponible() {
        return idiomaDisponible;
    }

    public void setIdiomaDisponible(String[] idiomaDisponible) {
        this.idiomaDisponible = idiomaDisponible;
    }

    public String[] getGenerosLibro() {
        return generosLibro;
    }

    public void setGenerosLibro(String[] generosLibro) {
        this.generosLibro = generosLibro;
    }

    public ClaseAutores getAutor() {
        return autor;
    }

    public void setAutor(ClaseAutores autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "=====================\n" +
                "Titulo del Libro    => "+ tituloLibro +"\n"+
                "Autor del Libro     => "+ autor.getNombreAutor() +"\n"+
                "Genero del Libro    => "+ Arrays.toString(generosLibro) +"\n"+
                "Idiomas Disponible  => "+ Arrays.toString(idiomaDisponible) +"\n"+
                "Numero de Descargas => "+ numeroDeDescargas +"\n"+
                "Derechos de Autor   => "+ derechoAutor +"\n";
    }
}
