package travel.management.system;

import javax.swing.*;
import java.awt.*;


public class CheckPackages extends JFrame{
    
    CheckPackages(){
    
        setBounds(450, 200, 900, 600);
        
        String[] package1 = {"GOLD PACKAGE", "6 Days and 7 Nights", "Airport Assistance", "Half Day City Tour", "Daily Buffet", "Welcome Drinks on Arrival", "Full Day 3 Island Crulse", "English Speaking Guide", "BOOK NOW !", "SUMMER SPECIAL", "RS 12999/- only", "GoldPackage.png"};
        String[] package2 = {"SILVER PACKAGE", "5 Days and 5 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Airport", "Daily Buffet", "Soft Drinks Free", "Night Safari", "Crulse with Dinner", "BOOK NOW !", "WINTER SPECIAL", "RS 23999/- only", "SilverPackage.png"};
        String[] package3 = {"BRONZE PACKAGE", "4 Days and 5 Nights", "Return Airport", "Free Clubbing, Horse Riding", "River Rafting", "Hard Drinks", "Daily Buffet", "BBQ Dinner", "BOOK NOW !", "WINTER SPECIAL", "RS 31999/- only","BronzePackage.png"};
        
        JTabbedPane tab = new JTabbedPane();
        
        JPanel pan1 = createPackage(package1);
        tab.addTab("GOLD Package", null, pan1);
        
        JPanel pan2 = createPackage(package2);
        tab.addTab("SILVER Package", null, pan2);
        
        JPanel pan3 = createPackage(package3);
        tab.addTab("BRONZE Package", null, pan3);
   
        add(tab);
        tab.setBackground(Color.white);
        
        setVisible(true);
    }
    
    public JPanel createPackage(String[] pack){
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(229, 184, 11));
        add(panel1);
        
        JLabel goldpack = new JLabel(pack[0]);
        goldpack.setBounds(350, 5, 300, 30);
        goldpack.setForeground(Color.black);
        goldpack.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel1.add(goldpack);
        
        JLabel packquantity = new JLabel(pack[1]);
        packquantity.setBounds(30, 90, 300, 30);
        packquantity.setForeground(Color.black);
        packquantity.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(packquantity);
        
        JLabel assistancetext = new JLabel(pack[2]);
        assistancetext.setBounds(30, 130, 300, 30);
        assistancetext.setForeground(Color.black);
        assistancetext.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(assistancetext);
        
        JLabel assistancetext1 = new JLabel(pack[3]);
        assistancetext1.setBounds(30, 170, 300, 30);
        assistancetext1.setForeground(Color.black);
        assistancetext1.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(assistancetext1);
        
        JLabel assistancetext2 = new JLabel(pack[4]);
        assistancetext2.setBounds(30, 210, 300, 30);
        assistancetext2.setForeground(Color.black);
        assistancetext2.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(assistancetext2);
        
        JLabel assistancetext3 = new JLabel(pack[5]);
        assistancetext3.setBounds(30, 250, 300, 30);
        assistancetext3.setForeground(Color.black);
        assistancetext3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(assistancetext3);
        
        JLabel assistancetext4 = new JLabel(pack[6]);
        assistancetext4.setBounds(30, 290, 300, 30);
        assistancetext4.setForeground(Color.black);
        assistancetext4.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(assistancetext4);
        
        JLabel assistancetext5 = new JLabel(pack[7]);
        assistancetext5.setBounds(30, 330, 300, 30);
        assistancetext5.setForeground(Color.black);
        assistancetext5.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel1.add(assistancetext5);
        
        JLabel booknowmsg = new JLabel(pack[8]);
        booknowmsg.setBounds(30, 390, 300, 30);
        booknowmsg.setForeground(Color.red);
        booknowmsg.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel1.add(booknowmsg);
        
        JLabel summermsg = new JLabel(pack[9]);
        summermsg.setBounds(80, 480, 300, 30);
        summermsg.setForeground(Color.white);
        summermsg.setFont(new Font("Tahoma", Font.BOLD, 17));
        panel1.add(summermsg);
        
        JLabel moneymsg = new JLabel(pack[10]);
        moneymsg.setBounds(580, 480, 300, 30);
        moneymsg.setForeground(Color.white);
        moneymsg.setFont(new Font("Tahoma", Font.BOLD, 17));
        panel1.add(moneymsg);
        
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image image = imageicon.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabel = new JLabel(imageicon2); 
        jlabel.setBounds(350, 100, 500, 300);
        panel1.add(jlabel);
        
        
        return panel1;
    }
    
    public static void main (String args[]){
        new CheckPackages();
    }

}
