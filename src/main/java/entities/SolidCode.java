package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "SolidCode.deleteAllRows", query = "DELETE from SolidCode")
public class SolidCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String navn;
    private String studentId;
    private String favTvShow;
    
    public SolidCode() {
    }  
    public SolidCode(String navn, String studentId, String favTvShow) {
        this.navn = navn;
        this.studentId = studentId;
        this.favTvShow = favTvShow;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "SolidCode{" + "id=" + id + ", navn=" + navn + ", studentId=" + studentId + ", favTvShow=" + favTvShow + '}';
    }
    
    
    
    

   
}
