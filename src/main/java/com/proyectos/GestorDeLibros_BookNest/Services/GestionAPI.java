package com.proyectos.GestorDeLibros_BookNest.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GestionAPI {
    public String getDatos (String url){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException();
        }

        String json_request = response.body();
        return json_request;
    }
}
