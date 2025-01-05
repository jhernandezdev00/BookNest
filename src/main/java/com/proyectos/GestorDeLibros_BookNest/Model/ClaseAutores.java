package com.proyectos.GestorDeLibros_BookNest.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Autores")
public class ClaseAutores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(unique = true)
    private String nombreAutor;
    private int yearNacimiento;
    private int yearFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ClaseLibros> libros;

    public ClaseAutores(){
        this.nombreAutor = "Desconocido";
        this.yearNacimiento = 0;
        this.yearFallecimiento = 0;
    }

    public ClaseAutores(DatosAutor autor){
        this.nombreAutor = autor.nombreAutor();
        this.yearNacimiento = autor.yearNacimiento();
        this.yearFallecimiento = autor.yearFallecimiento();
    }


    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getYearFallecimiento() {
        return yearFallecimiento;
    }

    public void setYearFallecimiento(int yearFallecimiento) {
        this.yearFallecimiento = yearFallecimiento;
    }

    public int getYearNacimiento() {
        return yearNacimiento;
    }

    public void setYearNacimiento(int yearNacimiento) {
        this.yearNacimiento = yearNacimiento;
    }

}
