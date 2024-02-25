package travel.management.system;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {
    
    JLabel limg1, limg2, limg3, limg4, limg5, limg6, limg7, limg8, limg9, limg10, limg11, limg12, limg13, limg14, limg15, limg16; 
    JLabel[] label = new JLabel[]{limg1, limg2, limg3, limg4, limg5, limg6, limg7, limg8, limg9, limg10, limg11, limg12, limg13, limg14, limg15, limg16};
    
    Thread thread;
   
    
    Destinations(){
    
        setBounds(470, 200, 900, 600);
        
        
        ImageIcon imgico1 = null, imgico2 = null, imgico3  = null, imgico4  = null, imgico5  = null, imgico6  = null, imgico7= null, imgico8 = null, imgico9 = null, imgico10 = null, imgico11 = null, imgico12 = null, imgico13 = null, imgico14 = null, imgico15 = null, imgico16 = null;
        ImageIcon[] imageico = {imgico1, imgico2, imgico3, imgico4, imgico5, imgico6, imgico7, imgico8, imgico9, imgico10, imgico11, imgico12, imgico13, imgico14, imgico15, imgico16 };
        
        Image img1 = null, img2 = null, img3 = null, img4 = null, img5 = null, img6 = null, img7 = null, img8 = null, img9 = null, img10 = null, img11 = null, img12 = null, img13 = null, img14= null, img15 = null, img16 = null;
        Image[] image = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16}; 
        
        ImageIcon imgicon1 = null, imgicon2 = null, imgicon3  = null, imgicon4  = null, imgicon5  = null, imgicon6  = null, imgicon7= null, imgicon8 = null, imgicon9 = null, imgicon10 = null, imgicon11 = null, imgicon12 = null, imgicon13 = null, imgicon14 = null, imgicon15 = null, imgicon16 = null;
        ImageIcon[] imgicon = {imgicon1, imgicon2, imgicon3, imgicon4, imgicon5, imgicon6, imgicon7, imgicon8, imgicon9, imgicon10, imgicon11, imgicon12, imgicon13, imgicon14, imgicon15, imgicon16 };
        
        
        for(int i = 0; i < label.length ;i++){
        // Showing images one by one
        imageico[i] = new ImageIcon(ClassLoader.getSystemResource("icons/Dest"+(i+1)+".jpg"));
        image[i] = imageico[i].getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        imgicon[i] = new ImageIcon(image[i]);
        label[i] = new JLabel(imgicon[i]);
        label[i].setBounds(0, 0, 900, 600);
        add(label[i]);
        
        thread= new Thread(this);
        thread.start();
        
        setVisible(true);
    }}

    public static void main (String args[]){
        new Destinations();
    }

    @Override
    public void run() {
        try{
            for(int i = 0; i < label.length ;i++){
                label[i].setVisible(true);
                Thread.sleep(4000);
                label[i].setVisible(false);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
