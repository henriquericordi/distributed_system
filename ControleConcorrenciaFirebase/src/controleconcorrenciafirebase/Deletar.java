/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleconcorrenciafirebase;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Henrique Ricordi
 */
public class Deletar {
    public static void main(String[] args) {
        // TODO code application logic here         
        Client c = Client.create();
        WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/alunos/1.json");
        String response = wr.delete(String.class);  
                
        System.out.println(response);   
    }
}
