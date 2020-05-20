/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeAffine extends JFrame{
    
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel imagelabel;  
    private FlowLayout layout;
    private JButton nextBtn;

    public WelcomeAffine()
    {
       super("Welcome to Affine Cipher");
       layout= new FlowLayout();
       setLayout(new BorderLayout());
       setContentPane(new JLabel(new ImageIcon((getClass().getResource("background.png")))));
       setLayout(new FlowLayout());
       setLayout(layout);
       layout.setAlignment(FlowLayout.CENTER);
        
       lbl1= new JLabel("Welcome to Affine Cipher: ");
       lbl1.setFont(new Font("Serif", Font.BOLD,23));
       add(lbl1);
       lbl1.setForeground(Color.WHITE);
       
       Icon icon1= new ImageIcon(getClass().getResource("icon.png"));
        imagelabel= new JLabel(icon1);
        add(imagelabel);
       
       lbl2= new JLabel(">>>>>>>>>>>>>>>>>>>>>>>>");
       lbl2.setFont(new Font("Serif", Font.BOLD,23));
       add(lbl2);
       lbl2.setForeground(Color.WHITE);
       nextBtn= new JButton("Next");
       add(nextBtn);

       setSize(400,400);
       ActionListenerHandler handler= new ActionListenerHandler();
       nextBtn.addActionListener(handler);
    }
    
    private class ActionListenerHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==nextBtn)
            {
                AffineCalculation childFrame1= new AffineCalculation();
                childFrame1.setSize(400, 500);
                childFrame1.setVisible(true);
            }
        }
    }
    
}
