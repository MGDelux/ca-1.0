/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.JokeDTO;
import facades.Facadexxxxxxxxxxx;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author mathi
 */
@Path("joke")
public class JokeResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final Facadexxxxxxxxxxx FACADE =  Facadexxxxxxxxxxx.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
 
    

    @Path("byid/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeById(@PathParam("id")long id){
        JokeDTO joke = FACADE.getJokeById(id);
        return GSON.toJson(joke);
    }
    
    @Path("random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String joke(){
        List<JokeDTO> jk = FACADE.getJoke();
        Random rand = new Random();
        int i = rand.nextInt(jk.size());
        return GSON.toJson(jk.get(i));
    }
     @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String jokeAll(){
        List<JokeDTO> jk = FACADE.getJoke();
        return GSON.toJson(jk);
    }
  


    

}
