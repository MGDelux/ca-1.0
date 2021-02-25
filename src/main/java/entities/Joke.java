/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author mathi
 */
@Entity
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke")
public class Joke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jokeSetUp;
    private String punchLine;

    public Joke() {
    }

    public Joke(String jokeSetUp, String punchLine) {
        this.jokeSetUp = jokeSetUp;
        this.punchLine = punchLine;
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
        return "Joke{" + "id=" + id + ", jokeSetUp=" + jokeSetUp + ", punchLine=" + punchLine + '}';
    }


}
