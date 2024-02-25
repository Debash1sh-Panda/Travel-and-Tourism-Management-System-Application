
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlinePayment extends JFrame implements ActionListener{
    
    JButton back;
            
    OnlinePayment(){
        
        setBounds(400, 150, 1000, 700);
        
        JEditorPane epane = new JEditorPane();
        epane.setEditable(false);
        
        try{
            epane.setPage("https://paytm.com/rent-payment");
        }catch (Exception e){
            epane.setContentType("text/html");
            epane.setText("<html>Could not load, Error 404</html>");
        }
        
        JScrollPane scroll = new JScrollPane(epane);
        getContentPane().add(scroll);
        
        back = new JButton("BACK");
        back.setBounds(450, 10, 90, 30);
        back.setForeground(Color.black);
        back.setBackground(new Color(135, 206, 235));
        back.addActionListener(this);
        epane.add(back);
        
        ImageIcon qrcode = new ImageIcon(ClassLoader.getSystemResource("icons/Qrcode.jpg"));
        Image img2 = qrcode.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon imgicon = new ImageIcon(img2);
        JLabel dashboardicon = new JLabel(imgicon);
        dashboardicon.setBounds(700, 10, 200, 200);
        epane.add(dashboardicon);
        
        setVisible(true);
    }
    

     public static void main(String args[]){
        new OnlinePayment();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ae.getSource() == back){
                new Payment();
                setVisible(false);
            }
        }
    }

