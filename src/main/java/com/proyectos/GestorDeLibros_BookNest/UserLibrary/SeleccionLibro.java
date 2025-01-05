package com.proyectos.GestorDeLibros_BookNest.UserLibrary;

import com.proyectos.GestorDeLibros_BookNest.Model.mainDatos;

import java.util.Scanner;

public class SeleccionLibro {

    private Scanner scannerint = new Scanner(System.in);
    int seleccionLibro;

    public int selectLibro(mainDatos datosBusqueda) {

        if (!(datosBusqueda.listaResultados().isEmpty())) {
            System.out.println("====== LIBRO ENCONTRADO ====");
            int sizeList = datosBusqueda.listaResultados().size();

            if (sizeList == 1) {
                seleccionLibro = 0;
            } else {
                for (int i = 0; i < sizeList; i++) {
                    System.out.println(i + ". " + datosBusqueda.listaResultados().get(i).titulo() + " = " + (datosBusqueda.listaResultados().get(i).DatosAutor().isEmpty()?"Desconocido" : datosBusqueda.listaResultados().get(i).DatosAutor().get(0).nombreAutor()));
                }
                do {
                    System.out.println("Digite el libro de su seleccion:");
                    seleccionLibro = scannerint.nextInt();

                    if (seleccionLibro < 0 || seleccionLibro >= sizeList) {
                        System.out.println("Número fuera de rango. Intenta de nuevo.");
                    }
                } while (seleccionLibro < 0 || seleccionLibro >= sizeList);
            }
        }else{
            seleccionLibro = -1;
        }
        return seleccionLibro;
    }
}

