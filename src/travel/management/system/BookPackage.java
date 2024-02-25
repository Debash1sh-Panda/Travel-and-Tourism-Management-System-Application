package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener{
    
    Choice choicepackage;
    JTextField tftoper;
    String username;
    JLabel lbusername, lbid, lbnumber, lbphone, lbtotalprice, lbltotalprice, emptylbusername, lblid, lblnumber, lblphone;
    JButton checkprice, bookpackage, back; 
    
    BookPackage(String username){
        
        this.username = username;
        
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(new Color(151, 152, 107));
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(460, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        lbusername = new JLabel("Username");
        lbusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbusername.setBounds(40, 70, 100, 20);
        add(lbusername);
        
        emptylbusername = new JLabel(username);
        emptylbusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        emptylbusername.setBounds(250, 70, 200, 20);
        add(emptylbusername);
        
        
        JLabel lbselpack = new JLabel("Select Package");
        lbselpack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbselpack.setBounds(40, 110, 200, 20);
        add(lbselpack);
        
        choicepackage = new Choice();
        choicepackage.add("Gold Package");
        choicepackage.add("Silver Package");
        choicepackage.add("Bronze Package");
        choicepackage.setBounds(250, 110, 200, 20);
        add(choicepackage);
        
        JLabel lbtoper = new JLabel("Total Persons");
        lbtoper.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbtoper.setBounds(40, 150, 200, 20);
        add(lbtoper);
        
        tftoper = new JTextField("1");
        tftoper.setBounds(250, 150, 200, 20);
        add(tftoper);
        
        lbid = new JLabel("Id Card");
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbid.setBounds(40, 190, 200, 20);
        add(lbid);
        
        lblid = new JLabel();
        lblid.setBounds(250, 190, 200, 20);
        add(lblid);
        
        lbnumber = new JLabel("Id Number");
        lbnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbnumber.setBounds(40, 230, 200, 20);
        add(lbnumber);
        
        lblnumber = new JLabel();
        lblnumber.setBounds(250, 230, 200, 20);
        add(lblnumber);
        
        lbphone = new JLabel("Phone");
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbphone.setBounds(40, 270, 200, 20);
        add(lbphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(250, 270, 200, 20);
        add(lblphone);
        
        lbtotalprice = new JLabel("Total Price");
        lbtotalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbtotalprice.setBounds(40, 310, 200, 20);
        add(lbtotalprice);
        
        lbltotalprice = new JLabel();
        lbltotalprice.setBounds(250, 310, 200, 20);
        lbltotalprice.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltotalprice.setForeground(Color.red);
        add(lbltotalprice);
        
        try{
            Conn c = new Conn();
            String query = "select * from coustomerdeatils where username = '"+username+"'";
            ResultSet result = c.s.executeQuery(query);
            while(result.next()){
                emptylbusername.setText(result.getString("username"));
                lblid.setText(result.getString("id"));
                lblnumber.setText(result.getString("number"));              
                lblphone.setText(result.getString("phone"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon detailicon = new ImageIcon(ClassLoader.getSystemResource("icons/BookPackage.png"));
        Image img = detailicon.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon imgico = new ImageIcon(img);
        JLabel image = new JLabel(imgico);
        image.setBounds(550, 70, 500, 350);
        add(image);
        
        setVisible(true);
    }
    
    public static void main (String args[]){
        new BookPackage("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == checkprice){
            
            String pack = choicepackage.getSelectedItem();
            int cost = 0;
            
            if (pack.equals("Gold Package")){
                cost += 12999;
            } else if (pack.equals("Silver Package")){
                cost += 23999;
            } else{
                cost += 31999;
            }
            
            int person = Integer.parseInt(tftoper.getText());
            cost *= person;
            lbltotalprice.setText("Rs "+cost+ "/- only");
            
        } else if (ae.getSource() == bookpackage){
                try{
                   Conn c = new Conn();
                   c.s.executeUpdate( "insert into bookpackages values('"+emptylbusername.getText()+"', '"+choicepackage.getSelectedItem()+"', '"+tftoper.getText()+"', '"+lblid.getText()+"', '"+lblnumber.getText()+"', '"+lblphone.getText()+"', '"+lbltotalprice.getText()+"' )" );
                   
                   JOptionPane.showMessageDialog(null, "Your "+choicepackage.getSelectedItem()+" Booked Successfully");
                   setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
        } else {
            setVisible(false);
        }
    }
}
