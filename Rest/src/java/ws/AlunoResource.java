/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author cc45966446830
 */
@Path("Aluno")
public class AlunoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AlunoResource
     */
    public AlunoResource() {
    }

    /**
     * Retrieves representation of an instance of ws.AlunoResource
     * @return an instance of java.lang.String
     */
    @GET  
    @Produces(MediaType.TEXT_PLAIN)
    public String getNome(){
        return "Fábio";      
    }
    
    /**
     * Retrieves representation of an instance of ws.AlunoResource
     * @return an instance of java.lang.String
     */
    @GET  
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{nome}")
    public String getNome(@PathParam("nome") String nome){
        return "Olá "+nome;      
    }
    
    /**
     * Retrieves representation of an instance of ws.AlunoResource
     * @return an instance of java.lang.String
     */
    @GET  
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("{num1},{num2}")
    public int getNum(@PathParam("num1") int num1, @PathParam("num2") int num2){        
        return num1+num2;      
    }
    
    @GET  
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/retorna")
    public String getAluno(){  
        Aluno a = new Aluno();
        a.setNome("Aluno_1");
        a.setIdade(123);
        Gson json = new Gson();        
        return json.toJson(a);      
    }

    /**
     * PUT method for updating or creating an instance of AlunoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String putXml(String content) {
        Aluno a;
        Gson json = new Gson();
        a = json.fromJson(content, Aluno.class);
        return a.getNome() + " " + String.valueOf(a.getIdade());
    }
}
