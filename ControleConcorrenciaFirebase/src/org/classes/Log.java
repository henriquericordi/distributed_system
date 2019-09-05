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
public class Log {
    
    private int log = 0;
    
    public void setLog(int log) {
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/log.json");
        String response = wr.get(String.class);
        Gson gson = new Gson();
        if (response.equals("null")) {
            inicializaLog();
        } else {
            this.log = gson.fromJson(response, Integer.class);
        }
        wr.type("application/json").put(String.class, gson.toJson(log));
    }

    public int getLog() {
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/log.json");
        String response = wr.get(String.class);
        Gson gson = new Gson();
        if (response.equals("null")) {
            inicializaLog();
        } else {
            this.log = gson.fromJson(response, Integer.class);
        }
        wr.type("application/json").put(String.class, gson.toJson(log));
        return log;
    }

    public void inicializaLog() {
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/log.json");
        Gson gson = new Gson();
        wr.type("application/json").put(String.class, gson.toJson(log));
    }
}
