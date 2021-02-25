/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.CarsEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class CarsDTO {
     private Long id;
    private String make;
    private String model;
    private int year;
    private int price;
    private String owner;

    
    
    
      public static List<CarsDTO> getDtos(List<CarsEntity> rms){
        List<CarsDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new CarsDTO(rm)));
        return rmdtos;
    }

    public CarsDTO(Long id, String make, String model, int year, int price, String owner) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    public CarsDTO(CarsEntity cars) {
          this.id = cars.getId();
        this.make = cars.getMake();
        this.model =  cars.getModel();
        this.year =  cars.getYear();
        this.price = cars.getPrice();
        this.owner = cars.getOwner();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CarsDTO{" + "id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", price=" + price + ", owner=" + owner + '}';
    }
      
      
      
}
