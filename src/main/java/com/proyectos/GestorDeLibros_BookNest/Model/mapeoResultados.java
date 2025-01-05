package com.proyectos.GestorDeLibros_BookNest.Model;

import java.util.Arrays;
import java.util.List;

public class mapeoResultados {
    public void mapeoResultadosBooks(List<Object[]> resultados){
        if(resultados.isEmpty()){
            System.out.println("NO HAY LIBROS REGISTRADOS");
        }else{
            for (Object[] fila:resultados){
                System.out.println("=================================");
                System.out.println("Titulo del Libro        => " + ((String) fila[0] != null ? (String) fila[0] : "Desconocido"));
                System.out.println("Autor del Libro         => " + ((String) fila[1] != null ? (String) fila[1] : "Desconocido"));
                System.out.println("Idiomas Disponibles     => " + (Arrays.toString((Object[]) fila[2])));
                System.out.println("Genero del Libro        => " + (Arrays.toString((Object[]) fila[3])));
                System.out.println("Num. de Descargas       => " + (fila[4]));
                if(fila[5].equals(false)){
                    System.out.println("Vig. Derechos de Autor  => SIN DERECHOS DE AUTOR");
                }else{
                    System.out.println("Vig. Derechos de Autor  => CON DERECHOS DE AUTOR");
                }
            }
        }
    }

    public void mapeoResultadosAuthors(List<ClaseAutores> resultadosAutores){
        if(resultadosAutores.isEmpty()){
            System.out.println("NO SE HAN ENCONTRADO ESCRITORES");
        }else{
            for(int i=0; i<resultadosAutores.size(); i++){
                System.out.println("=================================");
                System.out.println("Nombre del Escritor     => "+resultadosAutores.get(i).getNombreAutor());
                System.out.println("Año de Nacimiento       => "+resultadosAutores.get(i).getYearNacimiento());
                System.out.println("Año de Fallecimiento    => "+resultadosAutores.get(i).getYearFallecimiento());
            }
        }
    }

}
