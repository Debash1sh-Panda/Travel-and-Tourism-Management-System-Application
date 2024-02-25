
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;// Used for Triger events

public class Signup extends JFrame implements ActionListener{
    
    // Create or back button's are declaired in local scope, thats why we can not call them into other scope
    //* Here we goto declare both as global for making Anonomous Obj.
    JButton create, back;
    
    // Create all TextField name as globaly
    JTextField tfusername, tfname, tfpassword, tfsecurityanswer;
    
    // Create Dropdown name as globaly
    Choice securitydropdown;
    
    Signup(){
        //create a boundries of a signup frame
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        //Create panel in that frame
        JPanel jpanel = new JPanel();
        jpanel.setBackground(new Color(133, 193, 233));
        jpanel.setBounds(0, 0, 500, 400);
        jpanel.setLayout(null);
        add(jpanel);
        
        //Create labels 
        //Create Username field
        JLabel username =new JLabel("Username");
        username.setFont(new Font("Tahoma", Font.BOLD, 14));
        username.setBounds(50, 20, 125, 25);
        jpanel.add(username);

        tfusername = new JTextField();
        tfusername.setBounds(200, 20, 200, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfusername);
        
        //Create Name field
        JLabel name =new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        name.setBounds(50, 60, 125, 25);
        jpanel.add(name);

        tfname = new JTextField();
        tfname.setBounds(200, 60, 200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfname);
        
        //Create Password field
        JLabel password =new JLabel("Password");
        password.setFont(new Font("Tahoma", Font.BOLD, 14));
        password.setBounds(50, 100, 125, 25);
        jpanel.add(password);

        tfpassword = new JTextField();
        tfpassword.setBounds(200, 100, 200, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfpassword);
        
        //Create Security Questions field
        JLabel securityquestions =new JLabel("Security Questions");
        securityquestions.setFont(new Font("Tahoma", Font.BOLD, 14));
        securityquestions.setBounds(50, 140, 125, 25);
        jpanel.add(securityquestions);
        
        //Create DropDown by using Choice class
        securitydropdown = new Choice();
        securitydropdown.add("Your Favorite Singer");
        securitydropdown.add("Your First Pet's Name");
        securitydropdown.add("Your Favorite Marvel Superhero");
        securitydropdown.add("Your Favorite Movie");
        securitydropdown.setBounds(200, 140, 200, 25);
        jpanel.add(securitydropdown);

        //Create security Answer field
        JLabel securityanswer =new JLabel("Answer");
        securityanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        securityanswer.setBounds(50, 180, 125, 25);
        jpanel.add(securityanswer);

        tfsecurityanswer = new JTextField();
        tfsecurityanswer.setBounds(200, 180, 200, 25);
        tfsecurityanswer.setBorder(BorderFactory.createEmptyBorder());
        jpanel.add(tfsecurityanswer);

        //Create Buttons 
        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(195, 250, 100, 30);
        create.addActionListener(this);
        jpanel.add(create);
        
        //Create Buttons 
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(306, 250, 100, 30);
        back.addActionListener(this);
        jpanel.add(back);
    
        //Add Image 
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image image = imageicon.getImage().getScaledInstance(375, 375, Image.SCALE_SMOOTH);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabel = new JLabel(imageicon2); 
        jlabel.setBounds(580, 50, 250, 250);
        add(jlabel);
        
        setVisible(true);
    }
    
    public static void main (String args[]){
       new Signup();
    }

    //ActionListener Interface method() used for perform action
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == create){
            
            // Getting all values by using corresponde objects
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String questions = securitydropdown.getSelectedItem();
            String answer = tfsecurityanswer.getText();
            
            //Sql query for insert data into database
            String query = "insert into account values('"+username+"','"+name+"', '"+password+"', '"+questions+"', '"+answer+"')";
            
            try{
                Conn c = new Conn();
                // step-4 Executing MySQL Queries
                c.s.executeUpdate(query);
                
                //JOptionPane class is used for Showing Pop-Up screen
                JOptionPane.showMessageDialog(null, "Your Account Created Successfully");
                
                setVisible(false); // if it created successfully then signup page will be close
                new Login(); // and goto the Login() constructor page
                
            }catch (Exception e){
                e.printStackTrace();//used for handel the exception
            }
            
        }else if(ae.getSource() == back){
            setVisible(false); // if click back then current page will be close
            new Login();      // and goto the Login() constructor page
            
        }
    }

}
