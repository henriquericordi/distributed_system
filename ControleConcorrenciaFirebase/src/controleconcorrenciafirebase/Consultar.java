/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleconcorrenciafirebase;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.classes.Alunos;

/**
 *
 * @author Henrique Ricordi
 */
public class Consultar {
    public static void main(String[] args) {   
        Alunos a = new Alunos();
        
        Client c = Client.create();
        
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/alunos/1.json");
        String response = wr.get(String.class);  
        Gson gson = new Gson();
        a = gson.fromJson(response, Alunos.class);
        System.out.println(a.getNome());                
    }      
}
