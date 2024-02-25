package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookHotels extends JFrame implements ActionListener{
    
    Choice chotel, chac, chfood;
    JTextField tftoper, tfdays;
    String username;
    JLabel lbusername, lbid, lbnumber, lbphone, lbtotalprice, lbltotalprice, emptylbusername, lblid, lblnumber, lblphone;
    JButton checkprice, bookhotel, back; 
    
    BookHotels(String username){
        
        this.username = username;
        
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(new Color(135, 206, 235));
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        
        JLabel lbselpack = new JLabel("Select Hotel");
        lbselpack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbselpack.setBounds(40, 110, 200, 20);
        add(lbselpack);
        
        chotel = new Choice();       
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet result = c.s.executeQuery("select * from Hotel");
            while(result.next()){
                chotel.add(result.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel lbtoper = new JLabel("Total Persons");
        lbtoper.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbtoper.setBounds(40, 150, 200, 20);
        add(lbtoper);
        
        tftoper = new JTextField("1");
        tftoper.setBounds(250, 150, 200, 20);
        add(tftoper);
        
        JLabel lbdays = new JLabel("No. of Days");
        lbdays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbdays.setBounds(40, 190, 200, 20);
        add(lbdays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 20);
        add(tfdays);
        
        JLabel lbac = new JLabel("AC / Non-AC");
        lbac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbac.setBounds(40, 230, 200, 20);
        add(lbac);
        
        chac = new Choice();   
        chac.add("AC");
        chac.add("Non-AC");
        chac.setBounds(250, 230, 200, 20);
        add(chac);
        
        JLabel lbfood = new JLabel("Food Included");
        lbfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbfood.setBounds(40, 270, 200, 20);
        add(lbfood);
        
        chfood = new Choice();   
        chfood.add("Yes");
        chfood.add("No");
        chfood.setBounds(250, 270, 200, 20);
        add(chfood);
        
        lbid = new JLabel("Id Card");
        lbid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbid.setBounds(40, 310, 200, 20);
        add(lbid);
        
        lblid = new JLabel();
        lblid.setBounds(250, 310, 200, 20);
        add(lblid);
        
        lbnumber = new JLabel("Id Number");
        lbnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbnumber.setBounds(40, 350, 200, 20);
        add(lbnumber);
        
        lblnumber = new JLabel();
        lblnumber.setBounds(250, 350, 200, 20);
        add(lblnumber);
        
        lbphone = new JLabel("Phone");
        lbphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbphone.setBounds(40, 390, 200, 20);
        add(lbphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(250, 390, 200, 20);
        add(lblphone);
        
        lbtotalprice = new JLabel("Total Price");
        lbtotalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbtotalprice.setBounds(40, 430, 200, 20);
        add(lbtotalprice);
        
        lbltotalprice = new JLabel();
        lbltotalprice.setBounds(250, 430, 200, 20);
        lbltotalprice.setFont(new Font("Tahoma", Font.BOLD, 17));
        lbltotalprice.setForeground(Color.yellow);
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
        checkprice.setBounds(60, 480, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.black);
        bookhotel.setForeground(Color.white);
        bookhotel.setBounds(200, 480, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340, 480, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon detailicon = new ImageIcon(ClassLoader.getSystemResource("icons/BookHotel.png"));
        Image img = detailicon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon imgico = new ImageIcon(img);
        JLabel image = new JLabel(imgico);
        image.setBounds(600, 110, 400, 400);
        add(image);
        
        ImageIcon detailicon1 = new ImageIcon(ClassLoader.getSystemResource("icons/BookHotel.png"));
        Image img1 = detailicon1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon imgico1 = new ImageIcon(img1);
        JLabel image1 = new JLabel(imgico1);
        image1.setBounds(600, 20, 400, 400);
        add(image1);
        
        setVisible(true);
    }
    
    public static void main (String args[]){
        new BookHotels("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == checkprice){
            
            try{
            Conn c = new Conn();
            ResultSet result = c.s.executeQuery( " select * from Hotel where name ='"+chotel.getSelectedItem()+"' ");
            while(result.next()){
                int cost = Integer.parseInt(result.getString("costoerperson"));
                int room = Integer.parseInt(result.getString("acroom"));
                int food = Integer.parseInt(result.getString("foodincluded"));
                  
                int person = Integer.parseInt(tftoper.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = chac.getSelectedItem();
                String foodselected = chfood.getSelectedItem();
                
                if (person * days > 0){
                    int total = 0;
                    total += acselected.equals("AC") ? room : 0;
                    total += foodselected.equals("Yes") ? food : 0;
                    total += cost;
                    total = total * person * days;
                    lbltotalprice.setText("Rs " +total+ "/- only");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Person and Days");
                }           
            }
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }
        else if (ae.getSource() == bookhotel){
                try{
                   Conn c = new Conn();
                   c.s.executeUpdate( "insert into bookhotel values('"+emptylbusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tftoper.getText()+"', '"+tfdays.getText()+"', '"+chac.getSelectedItem()+"', '"+chfood.getSelectedItem()+"', '"+lblid.getText()+"', '"+lblnumber.getText()+"', '"+lblphone.getText()+"', '"+lbltotalprice.getText()+"' )" );
                   
                   JOptionPane.showMessageDialog(null, chotel.getSelectedItem()+" Booked Successfully");
                   setVisible(false);
                }catch (Exception e){
                    e.printStackTrace();
                }
        } else {
            setVisible(false);
        }
    }
}
