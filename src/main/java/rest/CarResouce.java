/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dtos.CarsDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.Facade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author mathi
 */
    @Path("cars")
public class CarResouce {
  private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final Facade FACADE =  Facade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
          @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String isAlive() {
        return "{\"msg\":\"alive\"}";
    }
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll(){
        List<CarsDTO> cars = FACADE.getAllCars();
        return GSON.toJson(cars);
    }
    

}
