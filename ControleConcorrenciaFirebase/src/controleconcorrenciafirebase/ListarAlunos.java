/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleconcorrenciafirebase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;
import java.util.List;
import org.classes.Alunos;

/**
 *
 * @author Henrique Ricordi
 */
public class ListarAlunos {
    public static void main(String[] args) {   
        List<Alunos> lista = new ArrayList();
        java.lang.reflect.Type listType = new TypeToken<ArrayList<Alunos>>(){}.getType();
        
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/.json");
        String response = wr.get(String.class);  
        Gson gson = new Gson();
        lista = gson.fromJson(response, listType );
                
        for (int i = 1; i < lista.size();i++) {
            System.out.println(lista.get(i).getNome());                
        }        
    }          
}
