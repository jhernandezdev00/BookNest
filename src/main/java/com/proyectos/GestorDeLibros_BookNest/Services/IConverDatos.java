package com.proyectos.GestorDeLibros_BookNest.Services;

public interface IConverDatos {
    <T> T getDatos(String json, Class<T> clase);
}
