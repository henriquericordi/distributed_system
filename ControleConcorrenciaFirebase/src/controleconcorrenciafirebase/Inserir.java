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
import org.classes.Contador;
import org.classes.Log;

/**
 *
 * @author Henrique Ricordi
 */
public class Inserir {

    public static void main(String[] args) {
        Alunos a = new Alunos();
        //log com caractere aleatorio
        //destravar depois de um tempo
        Contador contador = new Contador();
        Log log = new Log();

        int cont = contador.getContador(); //criado variável cont por a incrementação estar na chamada da funcao getContador()      
        
        if (log.getLog() == 0) {       
            log.setLog(cont);//reserva do log para essa operação, setando log como contador
            a.setNome("Henrique Ricordi");
            a.setIdade(21);
            a.setIdaluno(cont);
            a.setRA("120120");
            //verifica se o log é seu 
            //se não aguarda destravar
            Client c = Client.create();
            WebResource wr = c.resource("https://sistemasdistribuidos-4171a.firebaseio.com/alunos/" + cont + ".json");
            Gson gson = new Gson();
                      
            String response = wr.type("application/json").put(String.class, gson.toJson(a));
            log.setLog(0);
            System.out.println("Response: " + response);
            System.out.println("GetLog: " + log.getLog());
        } 
        //se nao tenta novamente (fazer)
    }
}
