/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Id;

/**
 *
 * @author USER
 */
@javax.persistence.Entity
public class Tb_estados implements Serializable{
    
    @Id
    private int id;
    private String uf;
    private String nome;

    public Tb_estados() {
    }

    public Tb_estados(String uf, String nome) {
        this.uf = uf;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
