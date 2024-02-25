package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton addpersonaldetails, updatepersonaldetails, viewpersonaldetails, deletepersonaldetails, checkpackage, bookpackage, viewpackage, viewhotels;
    JButton destinations, bookhotels, viewbookedhotel;
    JButton payment, calculator, notepad, about;
    String username;
    
    
    Dashboard(String username){
        
        this.username = username;
        // setBounds(0,0,1600,1000) instead of it we can use below methode
        setExtendedState(JFrame.MAXIMIZED_BOTH);// display the big screen
        setLayout(null);
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(0, 0, 102));
        panel1.setBounds(0, 0, 1600, 65);
        add(panel1);
        
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/TTMLogo.png"));
        Image img = logo.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon imgico = new ImageIcon(img);
        JLabel icon = new JLabel(imgico);
        icon.setBounds(5, 0, 70, 70);
        panel1.add(icon);
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tohoma", Font.BOLD, 30));
        panel1.add(heading);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(new Color(0, 0, 102));
        panel2.setBounds(0, 65, 300, 900);
        add(panel2);
        
        
        addpersonaldetails = new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0, 0, 300, 50);
        addpersonaldetails.setBackground(new Color(0, 0, 102));
        addpersonaldetails.setForeground(Color.white);
        addpersonaldetails.setFont(new Font("Tohoma", Font.PLAIN, 22));
        addpersonaldetails.setMargin(new Insets(0, 0, 0, 60));
        addpersonaldetails.addActionListener(this);
        panel2.add(addpersonaldetails);
        
        updatepersonaldetails = new JButton("Update Personal Details");
        updatepersonaldetails.setBounds(0, 51, 300, 50);
        updatepersonaldetails.setBackground(new Color(0, 0, 102));
        updatepersonaldetails.setForeground(Color.white);
        updatepersonaldetails.setFont(new Font("Tohoma", Font.PLAIN, 22));
        updatepersonaldetails.setMargin(new Insets(0, 0, 0, 30));
        updatepersonaldetails.addActionListener(this);
        panel2.add(updatepersonaldetails);
        
        viewpersonaldetails = new JButton("View Details");
        viewpersonaldetails.setBounds(0, 102, 300, 50);
        viewpersonaldetails.setBackground(new Color(0, 0, 102));
        viewpersonaldetails.setForeground(Color.white);
        viewpersonaldetails.setFont(new Font("Tohoma", Font.PLAIN, 22));
        viewpersonaldetails.setMargin(new Insets(0, 0, 0, 148));
        viewpersonaldetails.addActionListener(this);
        panel2.add(viewpersonaldetails);
        
        deletepersonaldetails = new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0, 152, 300, 50);
        deletepersonaldetails.setBackground(new Color(0, 0, 102));
        deletepersonaldetails.setForeground(Color.white);
        deletepersonaldetails.setFont(new Font("Tohoma", Font.PLAIN, 22));
        deletepersonaldetails.setMargin(new Insets(0, 0, 0, 40));
        deletepersonaldetails.addActionListener(this);
        panel2.add(deletepersonaldetails);
        
        checkpackage = new JButton("Check Package");
        checkpackage.setBounds(0, 203, 300, 50);
        checkpackage.setBackground(new Color(0, 0, 102));
        checkpackage.setForeground(Color.white);
        checkpackage.setFont(new Font("Tohoma", Font.PLAIN, 22));
        checkpackage.setMargin(new Insets(0, 0, 0, 114));
        checkpackage.addActionListener(this);
        panel2.add(checkpackage);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 254, 300, 50);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.white);
        bookpackage.setFont(new Font("Tohoma", Font.PLAIN, 22));
        bookpackage.setMargin(new Insets(0, 0, 0, 125));
        bookpackage.addActionListener(this);
        panel2.add(bookpackage);
        
        viewpackage = new JButton("View Booked Package");
        viewpackage.setBounds(0, 304, 370, 50);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.white);
        viewpackage.setFont(new Font("Tohoma", Font.PLAIN, 22));
        viewpackage.setMargin(new Insets(0, 10, 0, 125));
        viewpackage.addActionListener(this);
        panel2.add(viewpackage);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 355, 300, 50);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tohoma", Font.PLAIN, 22));
        viewhotels.setMargin(new Insets(0, 0, 0, 150));
        viewhotels.addActionListener(this);
        panel2.add(viewhotels);
        
        bookhotels = new JButton("Book Hotel");
        bookhotels.setBounds(0, 406, 300, 50);
        bookhotels.setBackground(new Color(0, 0, 102));
        bookhotels.setForeground(Color.white);
        bookhotels.setFont(new Font("Tohoma", Font.PLAIN, 22));
        bookhotels.setMargin(new Insets(0, 0, 0, 160));
        bookhotels.addActionListener(this);
        panel2.add(bookhotels);
        
        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0, 456, 300, 50);
        viewbookedhotel.setBackground(new Color(0, 0, 102));
        viewbookedhotel.setForeground(Color.white);
        viewbookedhotel.setFont(new Font("Tohoma", Font.PLAIN, 22));
        viewbookedhotel.setMargin(new Insets(0, 0, 0, 82));
        viewbookedhotel.addActionListener(this);
        panel2.add(viewbookedhotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 507, 300, 50);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tohoma", Font.PLAIN, 22));
        destinations.setMargin(new Insets(0, 0, 0, 145));
        destinations.addActionListener(this);
        panel2.add(destinations);
        
        payment = new JButton("Payments");
        payment.setBounds(0, 558, 300, 50);
        payment.setBackground(new Color(0, 0, 102));
        payment.setForeground(Color.white);
        payment.setFont(new Font("Tohoma", Font.PLAIN, 22));
        payment.setMargin(new Insets(0, 0, 0, 170));
        payment.addActionListener(this);
        panel2.add(payment);
        
        calculator = new JButton("Calculator");
        calculator.setBounds(0, 608, 300, 50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tohoma", Font.PLAIN, 22));
        calculator.setMargin(new Insets(0, 0, 0, 170));
        calculator.addActionListener(this);
        panel2.add(calculator);
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0, 659, 300, 50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tohoma", Font.PLAIN, 22));
        notepad.setMargin(new Insets(0, 0, 0, 180));
        notepad.addActionListener(this);
        panel2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0, 770, 300, 50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tohoma", Font.PLAIN, 22));
        about.setMargin(new Insets(0, 0, 0, 200));
        about.addActionListener(this);
        panel2.add(about);
        
        ImageIcon dashboardlogo = new ImageIcon(ClassLoader.getSystemResource("icons/Dashboard.jpg"));
        Image img2 = dashboardlogo.getImage().getScaledInstance(1600, 900,Image.SCALE_DEFAULT);
        ImageIcon imgicon = new ImageIcon(img2);
        JLabel dashboardicon = new JLabel(imgicon);
        dashboardicon.setBounds(0, 0, 1650, 1000);
        add(dashboardicon);
        
        JLabel maintext = new JLabel("Travel and Tourism Management System");
        maintext.setBounds(450, 75, 1000, 70);
        maintext.setForeground(new Color(88, 37,91));
        maintext.setFont(new Font("Raleway", Font.BOLD, 45));
        dashboardicon.add(maintext);
        
        JLabel maintext2 = new JLabel("Travel and Tourism Management System");
        maintext2.setBounds(447, 75, 1000, 70);
        maintext2.setForeground(Color.white);
        maintext2.setFont(new Font("Raleway", Font.BOLD, 45));
        dashboardicon.add(maintext2);
        
        setVisible(true);
    }
    public static void main(String args[]){
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addpersonaldetails){
            new AddCustomer(username);
        }else if(ae.getSource() == viewpersonaldetails){
            new ViewCustomer(username);
        }else if (ae.getSource() == updatepersonaldetails){
            new UpdateCustomer(username);
        }else if (ae.getSource() == checkpackage){
            new CheckPackages();
        }else if (ae.getSource() == bookpackage){
            new BookPackage(username);
        }else if (ae.getSource() == viewpackage){
            new ViewPackage(username);
        }else if (ae.getSource() == viewhotels){
            new ViewHotels();
        }else if (ae.getSource() == destinations){
            new Destinations();
        }else if (ae.getSource() == bookhotels){
            new BookHotels(username);
        }else if (ae.getSource() == viewbookedhotel){
            new ViewBookedHotel(username);
        }else if (ae.getSource() == payment){
            new Payment();
        }else if (ae.getSource() == calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == about){
            new About();
        } else if (ae. getSource() == deletepersonaldetails){
            new DeleteDetails(username);
        }
    }
}
