/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.SolidCodeDTO;
import entities.SolidCode;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacade(emf);
        fe.create(new SolidCodeDTO(new SolidCode("First 1", "Last 1","xc")));
        fe.create(new SolidCodeDTO(new SolidCode("First 2", "Last 2","x")));
        fe.create(new SolidCodeDTO(new SolidCode("First 3", "Last 3","xd")));
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
