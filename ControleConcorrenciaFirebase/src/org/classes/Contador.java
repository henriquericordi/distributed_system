/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.classes;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Henrique Ricordi
 */
public class Contador {

    private int contador = 0;

    public int getContador() {
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/contador.json");
        String response = wr.get(String.class);
        Gson gson = new Gson();
        if (response.equals("null")) {
            inicializaContador();
        } else {
            this.contador = gson.fromJson(response, Integer.class);
        }
        contador++;
        wr.type("application/json").put(String.class, gson.toJson(contador));
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void inicializaContador() {
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/contador.json");
        Gson gson = new Gson();
        wr.type("application/json").put(String.class, gson.toJson(contador));
    }
}
