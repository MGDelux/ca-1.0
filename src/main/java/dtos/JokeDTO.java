/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Joke;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathi
 */
public class JokeDTO {
      private Long id;
    private String jokeSetUp;
    private String punchLine;
    
     public static List<JokeDTO> getDtos(List<Joke> rms){
        List<JokeDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new JokeDTO(rm)));
        return rmdtos;
    }

  public JokeDTO (long id,String SetUp, String punchLine ){
      this.id = id;
      this.jokeSetUp = SetUp;
      this.punchLine = punchLine;
  }
    
     public JokeDTO(Joke jk){
          this.id = jk.getId();
      this.jokeSetUp = jk.getJokeSetUp();
      this.punchLine = jk.getPunchLine();
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJokeSetUp() {
        return jokeSetUp;
    }

    public void setJokeSetUp(String jokeSetUp) {
        this.jokeSetUp = jokeSetUp;
    }

    public String getPunchLine() {
        return punchLine;
    }

    public void setPunchLine(String punchLine) {
        this.punchLine = punchLine;
    }

    @Override
    public String toString() {
        return "JokeDTO{" + "id=" + id + ", jokeSetUp=" + jokeSetUp + ", punchLine=" + punchLine + '}';
    }
     
}
