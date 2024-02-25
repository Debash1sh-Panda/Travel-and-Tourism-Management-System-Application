package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel customername, id, lusername, number, name, lname, gender, country, address, email, phone;
    JComboBox idlist;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton malebutton, femalebutton;
    JButton add, back;
    
    AddCustomer(String username){
    
    setBounds(450, 200, 850, 550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    //add username label
    customername =new JLabel("Username");
    customername.setBounds(30, 50, 150, 25);
    add(customername);
    
    lusername =new JLabel(username);
    lusername.setBounds(220, 50, 150, 25);
    add(lusername);
    
    // add id label
    id =new JLabel("Id");
    id.setBounds(30, 90, 150, 25);
    add(id);
    
    idlist = new JComboBox(new String[] {"Aadhar Card", "Pan Card", "Voter Id", "Passport"});
    idlist.setBounds(220, 90, 150, 25);
    idlist.setBackground(Color.white);
    add(idlist);
 
    //add number label
    number =new JLabel("Id Number");
    number.setBounds(30, 130, 150, 25);
    add(number);
    
    tfnumber = new JTextField();
    tfnumber.setBounds(220, 130, 150, 25);
    add(tfnumber);
    
    //add name label
    name =new JLabel("Name");
    name.setBounds(30, 170, 150, 25);
    add(name);
    
    lname =new JLabel();
    lname.setBounds(220, 170, 150, 25);
    add(lname);
    
    //add gender label
    gender =new JLabel("Gender");
    gender.setBounds(30, 210, 150, 25);
    add(gender);
    
    //create some radio buttons for gender label
    malebutton = new JRadioButton("Male");
    malebutton.setBounds(220, 210, 70, 25);
    malebutton.setBackground(Color.white);
    add(malebutton);
    
    //create some radio buttons for gender label
    femalebutton = new JRadioButton("Female");
    femalebutton.setBounds(290, 210, 70, 25);
    femalebutton.setBackground(Color.white);
    add(femalebutton);
    
    //make radio button as a single select
    ButtonGroup singleselect = new ButtonGroup();
    singleselect.add(malebutton);
    singleselect.add(femalebutton);
    
    //add country label
    country =new JLabel("Country");
    country.setBounds(30, 250, 150, 25);
    add(country);
    
    tfcountry = new JTextField();
    tfcountry.setBounds(220, 250, 150, 25);
    add(tfcountry);
    
    //add address label
    address =new JLabel("Address");
    address.setBounds(30, 290, 150, 25);
    add(address);
    
    tfaddress = new JTextField();
    tfaddress.setBounds(220, 290, 150, 25);
    add(tfaddress);
    
    // add email label
    email =new JLabel("Email");
    email.setBounds(30, 330, 150, 25);
    add(email);
    
    tfemail = new JTextField();
    tfemail.setBounds(220, 330, 150, 25);
    add(tfemail);
    
    //add phone label
    phone =new JLabel("Phone");
    phone.setBounds(30, 370, 150, 25);
    add(phone);
    
    tfphone = new JTextField();
    tfphone.setBounds(220, 370, 150, 25);
    add(tfphone);
    
    add = new JButton("ADD");
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add.setBounds(210, 430, 80, 25);
    add.addActionListener(this);
    add(add);
    
    back = new JButton("BACK");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(300, 430, 80, 25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon detailicon = new ImageIcon(ClassLoader.getSystemResource("icons/Detail.png"));
    Image img = detailicon.getImage().getScaledInstance(280, 380, Image.SCALE_DEFAULT);
    ImageIcon imgico = new ImageIcon(img);
    JLabel image = new JLabel(imgico);
    image.setBounds(400, 20, 400, 500);
    add(image);
    
    try{
        Conn c = new Conn();
        ResultSet result = c.s.executeQuery("select * from account where username = '"+username+"'");
        while(result.next()){
        lusername.setText(result.getString("username"));
        lname.setText(result.getString("name"));
        }
    } catch(Exception e){
            e.printStackTrace();
    }
    setVisible(true);
    }
    
    public static void main (String args[]){
        new AddCustomer("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == add){
            String username = lusername.getText();
            String id = (String)idlist.getSelectedItem();
            String number = tfnumber.getText();
            String name = lname.getText();
            String gender = null;
                if(malebutton.isSelected()){
                    gender = "Male";
                } else {
                    gender ="Female";
                }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
                try{
                    Conn c = new Conn();
                    String query = "insert into coustomerdeatils values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+email+"', '"+phone+"' )";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Your Details Added Successfully");
                    setVisible(false);
                } catch(Exception e){
                    e.printStackTrace();
                }
        }else{
            setVisible(false);
        }
    }
}
