package travel.management.system;

import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable{  // Runnable Interface used for start() and run()
    Thread thread;
    
    Splash (){
//        setSize(1200,600);
//        setLocation(200, 200); static size (HardCode)
        
        
        ImageIcon imgico = new ImageIcon (ClassLoader.getSystemResource("icons/Splash.jpg"));
        Image img = imgico.getImage().getScaledInstance(1400, 600, Image.SCALE_DEFAULT);
        
        ImageIcon imgico2 = new ImageIcon (img);
        JLabel image = new JLabel(imgico2);

        add(image);
        
        setVisible(true);// used for display frame
        thread = new Thread(this);
        thread.start();
    }
    
    //Override the abstract method
    @Override
    public void run() {
        try{
            Thread.sleep(7000);
            new Login();
            setVisible(false);
        } catch (Exception e){}
    }
    
    public static void main(String args[]){
        
        Splash frame = new Splash();
        
        int x = 1;
        for(int i = 1; i <= 590; x+=7, i+=6){
            frame.setLocation(750 - (x+i)/2, 480 - (i/2));
            frame.setSize(x+i,i); //Used for give the dynamic size
            try{
                Thread.sleep(20);
            } catch(Exception e){}
    }
}

    
}
