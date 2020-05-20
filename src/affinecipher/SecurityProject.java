/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

import javax.swing.JFrame;

public class SecurityProject extends JFrame{

    public static void main(String[] args) 
    {
        WelcomeAffine frm= new WelcomeAffine();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(400, 200);
        frm.setVisible(true);
        
    }
}
