/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;

/**
 *
 * @author cc45966446830
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(soma(1, 3));
        
        Livro livro = retornaLivro();
        System.out.println(livro.getNome());
        
        ArrayList<Livro> lista = new ArrayList<>();
        lista = (ArrayList<Livro>) retornaLista();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getNome());
        }
        
    }      

    private static double soma(double num1, double num2) {
        ws.WSAndroid_Service service = new ws.WSAndroid_Service();
        ws.WSAndroid port = service.getWSAndroidPort();
        return port.soma(num1, num2);
    }    

    private static Livro retornaLivro() {
        ws.WSAndroid_Service service = new ws.WSAndroid_Service();
        ws.WSAndroid port = service.getWSAndroidPort();
        return port.retornaLivro();
    }

    private static java.util.List<ws.Livro> retornaLista() {
        ws.WSAndroid_Service service = new ws.WSAndroid_Service();
        ws.WSAndroid port = service.getWSAndroidPort();
        return port.retornaLista();
    }
    
}
