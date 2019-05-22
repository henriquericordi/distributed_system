/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import Classes.Livro;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author cc45966446830
 */
@WebService(serviceName = "WSAndroid")
@Stateless()
public class WSAndroid {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "soma")
    public double soma(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        return num1+num2;
    }
    
    @WebMethod(operationName = "retornaLivro")
    public Livro retornaLivro() {
        Livro livro = new Livro("SD", "UENP", 2012);
        return livro;
    }
    
    @WebMethod(operationName = "retornaLista")
    public ArrayList<Livro> retornaLista() {
        ArrayList<Livro> lista = new ArrayList();
        Livro livro1 = new Livro("Sistemas Distribuidos", "UENP", 2012);
        lista.add(livro1);
        Livro livro2 = new Livro("Comptação Gráfica", "UENP", 2017);
        lista.add(livro2);
        return lista;
    }
}
