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
public class Atualizar {
    public static void main(String[] args) {
        // TODO code application logic here    
        Alunos a = new Alunos();
        a.setIdaluno(1);
        a.setNome("alex");
        a.setIdade(30);
        a.setRA("449");

        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/alunos/"+a.getIdaluno()+".json");
        
        Gson gson = new Gson();
        String response = wr.type("application/json")
		   .put(String.class, gson.toJson(a));        
                
        System.out.println(response);                
    }  
}
