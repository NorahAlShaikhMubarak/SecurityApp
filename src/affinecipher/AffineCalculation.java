/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affinecipher;

import static affinecipher.Affine.a;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AffineCalculation extends JFrame {
    private JLabel key1Lbl;
    private JLabel key2Lbl;
    private JTextField key1Txt;
    private JTextField key2Txt;
    private JButton submitBtn;
    private JLabel msgLbl;
    private JLabel resultLbl;
    private JButton encryptionBtn;
    private JButton deccryptionnBtn;
    private JTextField resultxt;
    private JTextField msgTxt;
    private GridLayout layout;
    private FlowLayout flowLayout;

    public AffineCalculation() {
        
       super("Affine Cipher");
        flowLayout= new FlowLayout();
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon((getClass().getResource("background.png")))));
        setLayout(new FlowLayout());
        layout= new GridLayout(13,5,5,5);
        setLayout(layout);

        key1Lbl = new JLabel("Enter the first key: ");
        key1Lbl.setFont(new Font("Serif", Font.BOLD, 19));
        add(key1Lbl);
        key1Lbl.setForeground(Color.WHITE);
        key1Txt = new JTextField(20);
        add(key1Txt);

        key2Lbl = new JLabel("Enter the second key: ");
        key2Lbl.setFont(new Font("Serif", Font.BOLD, 19));
        add(key2Lbl);
        key2Lbl.setForeground(Color.WHITE);
        key2Txt = new JTextField(20);
        add(key2Txt);

        submitBtn = new JButton("Submit");
        submitBtn.addActionListener(new ActionListenerHandler());
        add(submitBtn);

        msgLbl = new JLabel("Enter your message: ");
        msgLbl.setFont(new Font("Serif", Font.BOLD, 19));
        add(msgLbl);
        msgLbl.setForeground(Color.WHITE);
        msgTxt=new HintTextField("Enter only characters");
        add(msgTxt);
        
        encryptionBtn = new JButton("Encryption");
        encryptionBtn.addActionListener(new ActionListenerHandler());
        add(encryptionBtn);
        deccryptionnBtn = new JButton("Decryption");
        deccryptionnBtn.addActionListener(new ActionListenerHandler());
        add(deccryptionnBtn);

        resultLbl=new JLabel("Encrypted/Decrypted message: ");
        resultLbl.setFont(new Font("Serif", Font.BOLD, 19));
        add(resultLbl);
        resultLbl.setForeground(Color.WHITE);

        resultxt = new JTextField(20);
        add(resultxt);
    }

    private class ActionListenerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == submitBtn) {
                try{
                if(Integer.parseInt(key1Txt.getText())==Integer.valueOf(key1Txt.getText())&&
                Integer.parseInt(key2Txt.getText())==Integer.valueOf(key2Txt.getText())){
                    
                    Affine.a = Integer.parseInt(key1Txt.getText());
                    Affine.b = Integer.parseInt(key2Txt.getText());
                }
                
                } 
                catch(NumberFormatException x)
                {
                    JOptionPane.showMessageDialog(null, "You should enter a number", "Error message", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == encryptionBtn) {
            
                String result = Affine.encryptionMessage(msgTxt.getText().toLowerCase());
                resultxt.setText(result);
            }
            
            else if (e.getSource() == deccryptionnBtn) {
            int gcd=0;
  
            for(int i = 1; i <= a && i <= 26; ++i)
            {
            if(a % i==0 && 26%i==0)
                gcd = i;
            }
             
            if (gcd != 1)
            {
              JOptionPane.showMessageDialog(rootPane, "GCD of a and 26 is not 1. Try again", "Error", JOptionPane.ERROR_MESSAGE);
            } 
             
                String result = Affine.decryptionMessage(msgTxt.getText().toLowerCase());
                resultxt.setText(result);
            }
}
}
}
  class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean show;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.show = true;
    super.addFocusListener(this);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      show = false;
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      show = true;
    }
  }

  @Override
  public String getText() {
    return show ? "" : super.getText();
  }
}