/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Picasa;

import Views.FrmAlbum;
import Views.FrmLogin;
import Views.FrmPersonas;
import javax.swing.JFrame;

/**
 *
 * @author Axel
 */
public class Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        FrmLogin frm = new FrmLogin();
        /*FrmLogin frm = new FrmLogin();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
        FrmPersonas frmp = new FrmPersonas();
        frmp.setLocationRelativeTo(null);
        frmp.setVisible(true);
    }

}
