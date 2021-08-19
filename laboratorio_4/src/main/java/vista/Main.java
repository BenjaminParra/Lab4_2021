/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.SocialNetwork;
import modelo.Usuario;

/**
 *
 * @author Benjamin Parra
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(date);
        //String[] fechaClase = fechaFormateada.split("/");
        System.out.println(fechaFormateada);
        Usuario benja = new  Usuario("benjaParra", "benja123", fechaFormateada);
        Usuario chilo = new Usuario("chiloParra","chilo123",fechaFormateada);
        
        SocialNetwork sn = new SocialNetwork("Facebook",fechaFormateada);
        sn.getUsuarios().add(benja);
        sn.getUsuarios().add(chilo);
        benja.post("Hola a todos.text", sn);
        
        benja.follow(chilo.getNombreUsuario(), sn);
        //sn.registerUser(benja, sn.getFecha());
        
        /*Menu_Bienvenida mb = new Menu_Bienvenida();
        mb.setLocationRelativeTo(null);
        mb.setVisible(true);*/
    
     
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu_Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Menu_Bienvenida().setVisible(true);
                Menu_Bienvenida mb = new Menu_Bienvenida(sn);
                mb.setAlwaysOnTop(true);
                mb.setLocationRelativeTo(null);
                mb.setVisible(true);
            }
        });
    }
    
}
