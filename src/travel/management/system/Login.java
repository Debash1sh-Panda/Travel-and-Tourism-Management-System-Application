package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
   // If we wants to add events in Signup, login and forgetpassword button then we declair all of these as globaly
   JButton login, signup, forgetpassword;
   JTextField tfusername;
   JPasswordField tfpassword;
   JLabel text;
   
   
   Login(){
       setSize(900, 400);
       setLocation(350, 200);
       setLayout(null);// if we donot wants to use Swing concept for creating panel,this functoin used for creating own design panel frame.
       
       getContentPane().setBackground(Color.white);
       
       JPanel jpanel = new JPanel();// Used for divide page into multiple parts
       jpanel.setBackground(new Color(131, 193, 233));
       jpanel.setBounds(0, 0, 400, 400);
       add(jpanel);
       
       ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/Login.png"));
       Image image = imageicon.getImage().getScaledInstance(375, 375, Image.SCALE_SMOOTH);
       ImageIcon imageicon2 = new ImageIcon(image);
       JLabel jlabel = new JLabel(imageicon2); 
       jlabel.setBounds(100, 120, 200, 200);
       jpanel.add(jlabel);
       
       JPanel jpanel2 = new JPanel();
       jpanel2.setLayout(null);
       jpanel2.setBounds(400, 30, 450, 300);
       add(jpanel2);
       
       //Creating Username
       JLabel username = new JLabel("Username"); // The main uses of JLabel is for creating text formate in frame
       username.setBounds(60, 20, 100, 25);
       username.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
       jpanel2.add(username);
       
       tfusername = new JTextField();
       tfusername.setBounds(60, 60, 300, 30);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       jpanel2.add(tfusername);
       
       //Creating Password
       JLabel password = new JLabel("Password");
       password.setBounds(60, 110, 100, 25);
       password.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
       jpanel2.add(password);
       
       tfpassword = new JPasswordField();
       tfpassword.setBounds(60, 150, 300, 30);
       tfpassword.setBorder(BorderFactory.createEmptyBorder());
       jpanel2.add(tfpassword);
       
       //Creating Login button
       login = new JButton("Login");
       login.setBounds(60, 200, 130, 30);
       login.setBackground(new Color(133, 193, 233));
       login.setForeground(Color.WHITE);
       login.setBorder(new LineBorder(new Color(133, 193, 233)));
       login.addActionListener(this);
       jpanel2.add(login);
       
       //Creating Signup button
       signup = new JButton("Signup");
       signup.setBounds(230, 200, 130, 30);
       signup.setBackground(new Color(133, 193, 233));
       signup.setForeground(Color.WHITE);
       signup.setBorder(new LineBorder(new Color(133, 193, 233)));
       signup.addActionListener(this);
       jpanel2.add(signup);
       
       
       //Creating forgetpassword button
       forgetpassword = new JButton("Forget Password");
       forgetpassword.setBounds(130, 250, 130, 30);
       forgetpassword.setBackground(new Color(133, 193, 233));
       forgetpassword.setForeground(Color.WHITE);
       forgetpassword.setBorder(new LineBorder(new Color(133, 193, 233)));
       forgetpassword.addActionListener(this);
       jpanel2.add(forgetpassword);
       
       //Add a error mesage
       text = new JLabel("Trouble in login time...");
       text.setBounds(300, 250, 150, 20);
       text.setForeground(Color.red);
       jpanel2.add(text);
       text.setVisible(false);
       
       
       setVisible(true);
   } 
   
    public static void main (String args[]){
        new Login(); //Anonumous object
    }

    // it is very important to generate events
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == login){
            try{
                
               String username = tfusername.getText(); 
               String password = tfpassword.getText();
               
               // used query for getting username and password
               String query = "select * from account where username = '"+username+"' AND password = '"+password+"'" ;
               Conn c = new Conn();
               
               ResultSet result = c.s.executeQuery(query);
               if(result.next()){
                   setVisible(false);
                   new LoadingPage(username);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect username or password");
                   text.setVisible(true); // show the error message
               }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
}
