package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Payment extends JFrame implements ActionListener{
    
    JButton pay, back;
    
    Payment(){
        
        setBounds(500, 200, 600, 600);
        setLayout(null);
        
        //Add Image 
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/Payment.png"));
        Image image = imageicon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabel = new JLabel(imageicon2); 
        jlabel.setBounds(40, 70, 500, 500);
        add(jlabel);
        
        pay = new JButton("PAY");
        pay.setBounds(80, 10, 90, 30);
        pay.setForeground(Color.black);
        pay.setBackground(new Color(135, 206, 235));
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("BACK");
        back.setBounds(420, 10, 90, 30);
        back.setForeground(Color.black);
        back.setBackground(new Color(135, 206, 235));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);  
    }
    
    
    public static void main(String args[]){
        new Payment();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay){
            setVisible(false);
            new OnlinePayment();
        } else{
            setVisible(false);
        }
    }
}
