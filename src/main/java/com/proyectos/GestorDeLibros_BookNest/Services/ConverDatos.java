package com.proyectos.GestorDeLibros_BookNest.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverDatos {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> T getDatos(String json, Class<T> clase){
        try {
            return mapper.readValue(json.toString(), clase);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
