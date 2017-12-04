/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import Controle.EstabelecimentosDAO;
import Modelo.Estabelecimentos;
import java.sql.SQLException;



/**
 *
 * @author Josi
 */
public class TesteUSu {

    private static String i;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        
        
//        Usuarios u = new Usuarios();
//        
//        u.setUsu_nome("jdsds");
//        u.setUsu_password("dsds");
//        u.setUsu_email("sddssd");
//        u.setUsu_nickname("dssd");
//        u.setUsu_username("dds");
//        
//        
//        UsuariosDAO d = new UsuariosDAO();
////        d.$AdicionarUsuarios(u);
//        
        Estabelecimentos e = new Estabelecimentos();
        
        e.setEst_bairro("ds");
        e.setEst_cidades("sds");
        e.setEst_desc("sds");
        e.setEst_nome("sdd");
        e.setEst_numero(123);
        e.setEst_rua("sdsd");
        e.setEst_uf("sds");
//        


        EstabelecimentosDAO es = new EstabelecimentosDAO();


         // es.$AdicionarEstabelecimentos(e);

//        List<Tb_cidades> cid = es.$BuscarCidades();



//        for (Tb_cidades c : cid) {
//            System.out.println(c.toString());
//
//        }
        System.out.println("sdss");

    }
}
