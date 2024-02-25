package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class LoadingPage extends JFrame implements Runnable{
    
    Thread thread;
    JProgressBar pbar;
    String username;
    
    LoadingPage( String username ){
        //used for store local variable into global variable
        this.username = username;
        
        thread = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel titletext = new JLabel ("Travel and Tourism Application");
        titletext.setBounds(90, 20, 600, 40);
        titletext.setForeground(Color.blue);
        titletext.setFont(new Font("Railway", Font.BOLD, 30));
        add(titletext);
        
        //Used for displaying Progressbar
        pbar = new JProgressBar();
        pbar.setBounds(150, 100, 300, 35);
        pbar.setStringPainted(true);// used for show progress value 0%
        add(pbar);
        
        JLabel loadingmessgae = new JLabel ("Loading, please wait");
        loadingmessgae.setBounds(230, 130, 150, 30);
        loadingmessgae.setForeground(Color.red);
        loadingmessgae.setFont(new Font("Railway", Font.BOLD, 14));
        add(loadingmessgae);
        
        JLabel welcomemessage = new JLabel ("Welcome " + username);
        welcomemessage.setBounds(20, 310, 400, 40);
        welcomemessage.setForeground(Color.green);
        welcomemessage.setFont(new Font("Railway", Font.BOLD, 16));
        add(welcomemessage);
        
        thread.start();
        setVisible(true);
    }
    
    public static void main (String args[]){
        new LoadingPage("");
    }

    // for running progressbar from 0% to 100%, multithreadung concept is used by using Runnable interface
    @Override
    public void run() {
        try{
            for(int i = 1; i <= 101; i++){
                int maximum = pbar.getMaximum(); //it's 100
                int value = pbar.getValue();
                
                if(value < maximum){ // upto 100 <101
                    pbar.setValue(pbar.getValue() + 1); // increment the value by 1
                }else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(30);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
