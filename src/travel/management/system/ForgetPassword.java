package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField  tfusername, tfname, tfsecurityquestion, tfsecurityanswer, tfpassword;
    JButton search, retrieve, back;
    
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        // used for add image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/ForgetPassword.png"));
        Image img = image.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon image2 = new ImageIcon(img);
        JLabel jlimage = new JLabel(image2);
        jlimage.setBounds(550, 70, 250, 200);
        add(jlimage);
        
        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBounds(30, 30, 500, 280);
        add(jpanel);
        
        // Create username field
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 25);
        username.setFont(new Font("Tohoma", Font.BOLD, 14));
        jpanel.add(username);
        
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfusername);
        
        // Create a search button
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.white);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        jpanel.add(search);
        
        // Create name field
        JLabel name = new JLabel("Name");
        name.setBounds(40, 60, 100, 25);
        name.setFont(new Font("Tohoma", Font.BOLD, 14));
        jpanel.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfname);
        
        // Create password field
        JLabel securityquestion = new JLabel("Security Question");
        securityquestion.setBounds(40, 100, 150, 25);
        securityquestion.setFont(new Font("Tohoma", Font.BOLD, 14));
        jpanel.add(securityquestion);
        
        tfsecurityquestion = new JTextField();
        tfsecurityquestion.setBounds(220, 100, 150, 25);
        tfsecurityquestion.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfsecurityquestion);
        
        // Create Answer field
        JLabel securityanswer = new JLabel("Your Answer");
        securityanswer.setBounds(40, 140, 150, 25);
        securityanswer.setFont(new Font("Tohoma", Font.BOLD, 14));
        jpanel.add(securityanswer);
        
        tfsecurityanswer = new JTextField();
        tfsecurityanswer.setBounds(220, 140, 150, 25);
        tfsecurityanswer.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfsecurityanswer);
        
        //Create Retrieve button
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380, 140, 100, 25);
        retrieve.addActionListener(this);
        jpanel.add(retrieve);
        
        // Create password field
        JLabel password = new JLabel("Password");
        password.setBounds(40, 180, 150, 25);
        password.setFont(new Font("Tohoma", Font.BOLD, 14));
        jpanel.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfpassword);
        
        // Create Back button
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.white);
        back.setBounds(252, 230, 80, 25);
        back.addActionListener(this);
        jpanel.add(back);
        
        
        setVisible(true);
    }
    public static void main(String args[]){
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'" ;
                Conn c = new Conn();
                
                //ResultSet class is used for store the result and it stay in sql package.
                ResultSet result = c.s.executeQuery(query);
                while(result.next()){
                    tfname.setText(result.getString("name"));
                    tfsecurityquestion.setText(result.getString("questions"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+tfsecurityanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet result = c.s.executeQuery(query);
                while(result.next()){
                    tfpassword.setText(result.getString("password"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Login();
        }
    }
}
