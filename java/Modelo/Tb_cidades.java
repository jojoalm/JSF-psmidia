/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author USER
 */
@javax.persistence.Entity
public class Tb_cidades implements Serializable {

    @Id
    private int id;
    private String estado;
    private String nome;
    private String uf;

    public Tb_cidades() {
    }

    public Tb_cidades(int id, String estado, String nome, String uf) {
        this.id = id;
        this.estado = estado;
        this.nome = nome;
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setCid_nome(String nome) {
        this.nome = nome;
    }

    
}
