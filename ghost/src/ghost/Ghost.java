/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ghost;
import ghost.View.Usuarios;
import ghost.Classe.Connection_BD;
/**
 *
 * @author LUCIANO MARCOS
 */
public class Ghost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuarios usuariosview = new Usuarios();
        usuariosview.setVisible(true);
        
    }
    
}
