package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;
    JLabel emptylbusername, emptylbpkgname, emptylbtoper, emptylbid, emptylbidnumber, emptylbphone, emptylbprice;

    ViewPackage(String username) {

        setBounds(450, 200, 900, 450);
        getContentPane().setBackground(new Color(181, 152, 107));
        setLayout(null);

        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(300, 10, 250, 30);
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
        JLabel lbpkgname = new JLabel("Package Name");
        lbpkgname.setBounds(30, 90, 150, 25);
        add(lbpkgname);

        emptylbpkgname = new JLabel();
        emptylbpkgname.setBounds(220, 90, 150, 25);
        add(emptylbpkgname);

        // getting total persons value
        JLabel lbtoper = new JLabel("Total Persons");
        lbtoper.setBounds(30, 130, 150, 25);
        add(lbtoper);

        emptylbtoper = new JLabel();
        emptylbtoper.setBounds(220, 130, 150, 25);
        add(emptylbtoper);

        // getting idcard value
        JLabel lbid = new JLabel("Id card");
        lbid.setBounds(30, 170, 150, 25);
        add(lbid);

        emptylbid = new JLabel();
        emptylbid.setBounds(220, 170, 150, 25);
        add(emptylbid);

        // getting id number value
        JLabel lbdnumber = new JLabel("Id Number");
        lbdnumber.setBounds(30, 210, 150, 25);
        add(lbdnumber);

        emptylbidnumber = new JLabel();
        emptylbidnumber.setBounds(220, 210, 150, 25);
        add(emptylbidnumber);

        // getting phone value
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(30, 250, 150, 25);
        add(lbphone);

        emptylbphone = new JLabel();
        emptylbphone.setBounds(220, 250, 150, 25);
        add(emptylbphone);

        // getting price value
        JLabel lbprice = new JLabel("Price");
        lbprice.setBounds(30, 290, 150, 25);
        add(lbprice);

        emptylbprice = new JLabel();
        emptylbprice.setBounds(220, 290, 200, 25);
        add(emptylbprice);

        // create a back button
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(100, 360, 100, 25);
        back.addActionListener(this);
        add(back);

        // adding image
        ImageIcon imgico = new ImageIcon(ClassLoader.getSystemResource("icons/ViewPackage.png"));
        Image img = imgico.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imgicon = new ImageIcon(img);
        JLabel limage = new JLabel(imgicon);
        limage.setBounds(500, 70, 250, 250);
        add(limage);

        try {
            Conn c = new Conn();
            String query = "select * from bookpackages where username = '" + username + "'";
            ResultSet result = c.s.executeQuery(query);
            while (result.next()) {
                emptylbusername.setText(result.getString("username"));
                emptylbpkgname.setText(result.getString("package"));
                emptylbtoper.setText(result.getString("person"));
                emptylbid.setText(result.getString("id"));
                emptylbidnumber.setText(result.getString("number"));
                emptylbphone.setText(result.getString("phone"));
                emptylbprice.setText(result.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String args[]) {
        new ViewPackage("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
}
