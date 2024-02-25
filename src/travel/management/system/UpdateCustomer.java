package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel customername, id, lusername, number, name, lname, gender, country, address, email, phone;
    JComboBox idlist;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfid,tfgender;
    JButton add, back;
    
    UpdateCustomer(String username){
    
    setBounds(500, 200, 850, 550);
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    
    JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
    text.setBounds(50, 0, 300, 25);
    text.setFont(new Font("Tohoma", Font.PLAIN, 20));
    add(text);
    
    //add username label
    customername =new JLabel("Username");
    customername.setBounds(30, 50, 150, 25);
    add(customername);
    
    lusername =new JLabel(username);
    lusername.setBounds(220, 50, 150, 25);
    add(lusername);
    
    // add id label
    id =new JLabel("Id Name");
    id.setBounds(30, 90, 150, 25);
    add(id);
    
    tfid = new JTextField();
    tfid.setBounds(220, 90, 150, 25);
    add(tfid);
 
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
    
    tfgender = new JTextField();
    tfgender.setBounds(220, 210, 150, 25);
    add(tfgender);
    
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
    
    add = new JButton("UPDATE");
    add.setBackground(Color.BLACK);
    add.setForeground(Color.WHITE);
    add.setBounds(180, 430, 100, 25);
    add.addActionListener(this);
    add(add);
    
    back = new JButton("BACK");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(320, 430, 100, 25);
    back.addActionListener(this);
    add(back);
    
    ImageIcon detailicon = new ImageIcon(ClassLoader.getSystemResource("icons/UdateDetails.png"));
    Image img = detailicon.getImage().getScaledInstance(350, 450, Image.SCALE_DEFAULT);
    ImageIcon imgico = new ImageIcon(img);
    JLabel image = new JLabel(imgico);
    image.setBounds(430, 35, 350, 450);
    add(image);
    
    try{
        Conn c = new Conn();
        ResultSet result = c.s.executeQuery("select * from coustomerdeatils where username = '"+username+"'");
        while(result.next()){
        lusername.setText(result.getString("username"));
        lname.setText(result.getString("name"));
        tfid.setText(result.getString("id"));
        tfnumber.setText(result.getString("number"));
        tfgender.setText(result.getString("gender"));
        tfcountry.setText(result.getString("country"));
        tfaddress.setText(result.getString("address"));
        tfemail.setText(result.getString("email"));
        tfphone.setText(result.getString("phone"));
        }
    } catch(Exception e){
            e.printStackTrace();
    }
    setVisible(true);
    }
    
    public static void main (String args[]){
        new UpdateCustomer("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == add){
            String username = lusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = lname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
                try{
                    Conn c = new Conn();
                    String query = "update coustomerdeatils set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', email = '"+email+"', phone = '"+phone+"' ";
                    c.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Your Details Updated Successfully");
                    setVisible(false);
                } catch(Exception e){
                    e.printStackTrace();
                }
        }else{
            setVisible(false);
//          new AddCustomer("");
        }
    }
}

