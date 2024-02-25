package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
    JButton back;
    
    ViewCustomer(String username){
        
        setBounds(450, 180, 870, 625);
        getContentPane().setBackground(new Color(157, 152, 107));
        setLayout(null);
        
        // getting username value
        JLabel lbusername = new JLabel("Username:");
        lbusername.setBounds(30, 50, 150, 25);
        add(lbusername);
        
        JLabel emptylbusername = new JLabel(username);
        emptylbusername.setBounds(180, 50, 150, 25);
        add(emptylbusername);
        
        // getting id value
        JLabel lbid = new JLabel("Id:");
        lbid.setBounds(30, 110, 150, 25);
        add(lbid);
        
        JLabel emptylbid = new JLabel();
        emptylbid.setBounds(180, 110, 150, 25);
        add(emptylbid);
        
        // getting idnumber value
        JLabel lbidnumber = new JLabel("Id Number:");
        lbidnumber.setBounds(30, 170, 150, 25);
        add(lbidnumber);
        
        JLabel emptylbnumber = new JLabel();
        emptylbnumber.setBounds(180, 170, 150, 25);
        add(emptylbnumber);
        
        // getting idnumber value
        JLabel lbname = new JLabel("Name:");
        lbname.setBounds(30, 230, 150, 25);
        add(lbname);
        
        JLabel emptylbname = new JLabel();
        emptylbname.setBounds(180, 230, 150, 25);
        add(emptylbname);
        
        // getting gender value
        JLabel lbgender = new JLabel("Gender:");
        lbgender.setBounds(30, 290, 150, 25);
        add(lbgender);
        
        JLabel emptylbgender = new JLabel();
        emptylbgender.setBounds(180, 290, 150, 25);
        add(emptylbgender);
        
        // getting country value
        JLabel lbcountry = new JLabel("Country:");
        lbcountry.setBounds(480, 50, 150, 25);
        add(lbcountry);
        
        JLabel emptylbcountry = new JLabel();
        emptylbcountry.setBounds(600, 50, 150, 25);
        add(emptylbcountry);
        
        // getting address value
        JLabel lbaddress = new JLabel("Address:");
        lbaddress.setBounds(480, 110, 150, 25);
        add(lbaddress);
        
        JLabel emptylbaddress = new JLabel();
        emptylbaddress.setBounds(600, 110, 200, 25);
        add(emptylbaddress);
        
        // getting email value
        JLabel lbemail = new JLabel("Email:");
        lbemail.setBounds(480, 170, 150, 25);
        add(lbemail);
        
        JLabel emptylbemail = new JLabel();
        emptylbemail.setBounds(600, 170, 200, 25);
        add(emptylbemail);
        
        // getting phone value
        JLabel lbphone = new JLabel("Phone:");
        lbphone.setBounds(480, 230, 150, 25);
        add(lbphone);
        
        JLabel emptylbphone = new JLabel();
        emptylbphone.setBounds(600, 230, 150, 25);
        add(emptylbphone);
        
        // create a back button
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(370, 350, 90, 25);
        back.addActionListener(this);
        add(back);
        
        // adding image
        ImageIcon imgico = new ImageIcon(ClassLoader.getSystemResource("icons/ViewDetails.png"));
        Image img = imgico.getImage().getScaledInstance(800, 195, Image.SCALE_DEFAULT);
        ImageIcon imgicon = new ImageIcon(img);
        JLabel limage = new JLabel(imgicon);
        limage.setBounds(20, 400, 800, 195);
        add(limage);
        
        try{
            Conn c = new Conn();
            String query = "select * from coustomerdeatils where username = '"+username+"'";
            ResultSet result = c.s.executeQuery(query);
            while(result.next()){
                emptylbusername.setText(result.getString("username"));
                emptylbid.setText(result.getString("id"));
                emptylbnumber.setText(result.getString("number"));
                emptylbname.setText(result.getString("name"));
                emptylbgender.setText(result.getString("gender"));
                emptylbcountry.setText(result.getString("country"));
                emptylbaddress.setText(result.getString("address"));
                emptylbemail.setText(result.getString("email"));
                emptylbphone.setText(result.getString("phone"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    public static void main(String args[]){
        new ViewCustomer("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       setVisible(false);
    }
}
