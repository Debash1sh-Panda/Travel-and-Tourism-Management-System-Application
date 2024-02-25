package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    JButton back;
            
    About(){
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lab = new JLabel("ABOUT");
        lab.setBounds(200, 10, 100, 40);
        lab.setForeground(Color.cyan);
        lab.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lab);
        
        JLabel lab1 = new JLabel("ABOUT");
        lab1.setBounds(198, 10, 100, 40);
        lab1.setForeground(Color.black);
        lab1.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lab1);
        
        String abouttext = "About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:\n"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                ;
        
        TextArea area  = new TextArea(abouttext, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        area.setForeground(Color.red);
        add(area);
        
        
        back = new JButton("BACK");
        back.setBounds(195, 450, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
    }
    
    public static void main(String args[]){
        new About();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if ( ae.getSource() == back){
            setVisible(false);
        }
    }
    
}
