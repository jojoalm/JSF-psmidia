/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Tb_cidades;
import Modelo.Estabelecimentos;
import Modelo.Tb_estados;
import Util.HibernateUtil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.primefaces.model.CroppedImage;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Hipercom
 */
@ManagedBean //gera bean
@RequestScoped
public class EstabelecimentosDAO {

    private String imagemTemporaria;
    EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
    Estabelecimentos e = new Estabelecimentos();
    List<Estabelecimentos> lista;
    List<Tb_estados> estados;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
     
    
     public void newInstance() {
        Estabelecimentos e = new Estabelecimentos();
    }
     
    Tb_cidades cid = new Tb_cidades();
    public Estabelecimentos getE() {
        return e;
    }

    public void setE(Estabelecimentos e) {
        this.e = e;
    }

    public Tb_cidades getCid() {
        return cid;
    }

    public void setCid(Tb_cidades cid) {
        this.cid = cid;
    }
    
    private StreamedContent imagemEnviada = new DefaultStreamedContent();
    private CroppedImage croppedImage;
    private boolean exibeBotao = false;

    /* getters e setters */
    public StreamedContent getImagemEnviada() {
        return imagemEnviada;
    }

    public void setImagemEnviada(StreamedContent imagemEnviada) {
        this.imagemEnviada = imagemEnviada;
    }

    public String getImagemTemporaria() {
        return imagemTemporaria;
    }

    public void setImagemTemporaria(String imagemTemporaria) {
        this.imagemTemporaria = imagemTemporaria;
    }

    public CroppedImage getCroppedImage() {
        return croppedImage;
    } 

    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }

    public boolean isExibeBotao() {
        return exibeBotao;
    }

    public void setExibeBotao(boolean exibeBotao) {
        this.exibeBotao = exibeBotao;
    }

    public void criaArquivo(byte[] bytes, String arquivo) throws IOException {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstabelecimentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstabelecimentosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Tb_estados> $BuscarUF() {
         EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
         Query query = em.createQuery("SELECT e fROM Tb_estados e");
         estados = (List<Tb_estados>) query.getResultList();
         
        return estados;
    }
    
    
     public List<Tb_estados> $BuscarCidades() {
         EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
         Query query = em.createQuery("SELECT c.nome fROM Tb_cidades c where c.estados");
         estados = (List<Tb_estados>) query.getResultList();
         
        return estados;
    }

     EntityManager em2 = HibernateUtil.getEntityManagerFactory().createEntityManager();
    public String $AdicionarEstabelecimentos() {
       
        this.em2.getTransaction().begin();
        this.em2.persist(e);
        this.em2.getTransaction().commit();        
        this.em2.close();        
        String a = "Inserir";
        return a;
    }

    EntityManager em4 = HibernateUtil.getEntityManagerFactory().createEntityManager();
    public String $ExcluirEstabelecimentos() {                
        this.em.getTransaction().begin();
        this.em.remove(e);
        this.em.getTransaction().commit();
//      this.em4.close();         
        lista = null;       
        return "remover";
                
    }

    public Estabelecimentos $RetornarEstabelecimentos(int id) {
        this.em.getTransaction().begin();
        Estabelecimentos est1 = this.em.find(Estabelecimentos.class, id);
        this.em.getTransaction().commit();
        this.em.close();
        return est1;
    }

    EntityManager em5 = HibernateUtil.getEntityManagerFactory().createEntityManager();
    public String $EditarEstabelecimentos() {
        this.em.getTransaction().begin();
        this.em.merge(e);
        this.em.getTransaction().commit();
//        this.em.close();
        return "atualizar";
    }

    public List<Estabelecimentos> $RetornarTodosEstabelecimentos() {
        
   EntityManager em3 = HibernateUtil.getEntityManagerFactory().createEntityManager();
   
        Query query = em.createQuery("SELECT e FROM Estabelecimentos e");
        
        lista = (List<Estabelecimentos>) query.getResultList();
             
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    public List getEstabelecimentos() {
        return $RetornarTodosEstabelecimentos();
    }
    
     public List getUF() {
        return $BuscarUF();
    }
}
