package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;
    JLabel emptylbusername, emptylbhotname, emptylbtoper, emptylbday, emptylbroom, emptylbfood, emptylbid, emptylbidnumber, emptylbphone, emptylbprice;

    ViewBookedHotel(String username) {

        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(new Color(255, 102, 204));
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(320, 10, 350, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        // getting username value
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30, 50, 150, 25);
        add(lbusername);

        emptylbusername = new JLabel(username);
        emptylbusername.setBounds(220, 50, 150, 25);
        add(emptylbusername);

        // getting packagename value
        JLabel lbhotname = new JLabel("Hotel Name");
        lbhotname.setBounds(30, 90, 150, 25);
        add(lbhotname);

        emptylbhotname = new JLabel();
        emptylbhotname.setBounds(220, 90, 150, 25);
        add(emptylbhotname);

        // getting total persons value
        JLabel lbtoper = new JLabel("Total Persons");
        lbtoper.setBounds(30, 130, 150, 25);
        add(lbtoper);

        emptylbtoper = new JLabel();
        emptylbtoper.setBounds(220, 130, 150, 25);
        add(emptylbtoper);

        JLabel lbday = new JLabel("Total Days");
        lbday.setBounds(30, 170, 150, 25);
        add(lbday);

        emptylbday = new JLabel();
        emptylbday.setBounds(220, 170, 150, 25);
        add(emptylbday);
        
        JLabel lbroom = new JLabel("AC / Non-AC Room");
        lbroom.setBounds(30, 210, 150, 25);
        add(lbroom);

        emptylbroom = new JLabel();
        emptylbroom.setBounds(220, 210, 150, 25);
        add(emptylbroom);
        
        JLabel lbfood = new JLabel("Food Include");
        lbfood.setBounds(30, 250, 150, 25);
        add(lbfood);

        emptylbfood = new JLabel();
        emptylbfood.setBounds(220, 250, 150, 25);
        add(emptylbfood);
        
        // getting idcard value
        JLabel lbid = new JLabel("Id card");
        lbid.setBounds(30, 290, 150, 25);
        add(lbid);

        emptylbid = new JLabel();
        emptylbid.setBounds(220, 290, 150, 25);
        add(emptylbid);

        // getting id number value
        JLabel lbdnumber = new JLabel("Id Number");
        lbdnumber.setBounds(30, 330, 150, 25);
        add(lbdnumber);

        emptylbidnumber = new JLabel();
        emptylbidnumber.setBounds(220, 330, 150, 25);
        add(emptylbidnumber);

        // getting phone value
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(30, 370, 150, 25);
        add(lbphone);

        emptylbphone = new JLabel();
        emptylbphone.setBounds(220, 370, 150, 25);
        add(emptylbphone);

        // getting price value
        JLabel lbprice = new JLabel("Total Cost");
        lbprice.setBounds(30, 410, 150, 25);
        add(lbprice);

        emptylbprice = new JLabel();
        emptylbprice.setBounds(220, 410, 200, 25);
        emptylbprice.setForeground(Color.white);
        emptylbprice.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(emptylbprice);

        // create a back button
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(100, 465, 100, 25);
        back.addActionListener(this);
        add(back);

        // adding image
        ImageIcon imgico = new ImageIcon(ClassLoader.getSystemResource("icons/ViewBookHotel.png"));
        Image img = imgico.getImage().getScaledInstance(470, 430, Image.SCALE_DEFAULT);
        ImageIcon imgicon = new ImageIcon(img);
        JLabel limage = new JLabel(imgicon);
        limage.setBounds(480, 70, 470, 430);
        add(limage);

        try {
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '" + username + "'";
            ResultSet result = c.s.executeQuery(query);
            while (result.next()) {
                emptylbusername.setText(result.getString("username"));
                emptylbhotname.setText(result.getString("name"));
                emptylbtoper.setText(result.getString("person"));
                emptylbday.setText(result.getString("days"));
                emptylbroom.setText(result.getString("room"));
                emptylbfood.setText(result.getString("food"));
                emptylbid.setText(result.getString("id"));
                emptylbidnumber.setText(result.getString("id_number"));
                emptylbphone.setText(result.getString("phone"));
                emptylbprice.setText(result.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String args[]) {
        new ViewBookedHotel("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
}

