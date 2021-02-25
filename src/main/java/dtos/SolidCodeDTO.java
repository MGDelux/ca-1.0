/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.SolidCode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class SolidCodeDTO {
    private long id;
 private String navn;
    private String studentId;
    private String favTvShow;
    
    
    public static List<SolidCodeDTO> getDtos(List<SolidCode> rms){
        List<SolidCodeDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new SolidCodeDTO(rm)));
        return rmdtos;
    }

    public SolidCodeDTO(long ids,String navn,String studentId, String tvshow) {
         this.id = ids;
        this.navn = navn;
        this.studentId = studentId;
        this.favTvShow = tvshow;
    }


    
    
    public SolidCodeDTO(SolidCode rm) {
        this.id = rm.getId();
        this.navn = rm.getNavn();
        this.studentId = rm.getStudentId();
        this.favTvShow = rm.getFavTvShow();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFavTvShow() {
        return favTvShow;
    }

    public void setFavTvShow(String favTvShow) {
        this.favTvShow = favTvShow;
    }

    @Override
    public String toString() {
        return "RenameMeDTO{" + "id=" + id + ", navn=" + navn + ", studentId=" + studentId + ", favTvShow=" + favTvShow + '}';
    }

  
    
    
    
    
    
    
}
