/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Planorama_LoginPage.View1;

/**
 *
 * @author Kalli-Ann
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author shabm2770
 */
class ImagePanel extends JPanel {

    // creating fields
    BufferedImage the_image; // bufferedimage is a subclass of the image class that helps handle the image data
    int height;
    int width;
    int X;
    int Y;
    String the_path;

    // constructor 
    public ImagePanel(String image_path, int theX, int theY, int theWidth, int theHeight) {

        this.height = theHeight;
        this.width = theWidth;
        this.X = theX;
        this.Y = theY;
        this.the_path = image_path;

        // using try and catch in case there are any issues with the image path, ie if it doesn't exist
        try {
            File myFile = new File(image_path);
            the_image = ImageIO.read(myFile);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    
    @Override //here i override the paint component method so that my images are properly able to be displayed on the screen at the wanted coordinates and with the desired size
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (the_image != null) {
            g.drawImage(the_image, this.X, this.Y, this.width, this.height, null);
        }
    }

}

public class HomePageUI {

    public static JLayeredPane layeredPane;
    public static String currentUser = null;  // null means no one is logged in

    public static void homeScreen(JFrame frame) {

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 700));

        // here i use the imagepanel class i made to create the background image
        ImagePanel back = new ImagePanel("C:\\Users\\adupa\\OneDrive\\Documents\\NetBeansProjects\\CSProject\\src\\main\\java\\Planorama (2).png", 0, 0, 1200, 700);
        back.setBounds(0, 0, 1200, 700);

        ImagePanel yourEventsPic = new ImagePanel("C:\\Users\\adupa\\OneDrive\\Documents\\NetBeansProjects\\CSProject\\src\\main\\java\\yourevents.png", 0, 0, 150, 50);
        yourEventsPic.setBounds(70, 150, 150, 50);

        JButton yourEventsBut = new JButton();
        yourEventsBut.setBounds(70, 150, 150, 50);
        yourEventsBut.setContentAreaFilled(false);

        ImagePanel eventsNearYouPic = new ImagePanel("C:\\Users\\adupa\\OneDrive\\Documents\\NetBeansProjects\\CSProject\\src\\main\\java\\eventnearu.png", 0, 0, 150, 50);
        eventsNearYouPic.setBounds(70, 220, 150, 50);

        JButton eventsNearYouBut = new JButton();
        eventsNearYouBut.setBounds(70, 220, 150, 50);
        eventsNearYouBut.setContentAreaFilled(false);
//        eventsNearYouBut.addActionListener(new EventsNearYou(frame));
        
        ImagePanel createEventPic = new ImagePanel("C:\\Users\\adupa\\OneDrive\\Documents\\NetBeansProjects\\CSProject\\src\\main\\java\\createEvent.png", 0, 0, 150, 50);
        createEventPic.setBounds(70, 440, 150, 50);

        //creating events
        JButton createEventBut = new JButton();
        createEventBut.setBounds(70, 440, 150, 50);
        createEventBut.setContentAreaFilled(false);
        createEventBut.addActionListener(new toEventsManager(currentUser));
        
        ImagePanel aboutUsPic = new ImagePanel("C:\\Users\\adupa\\OneDrive\\Documents\\NetBeansProjects\\CSProject\\src\\main\\java\\aboutUs.png", 0, 0, 150, 50);
        aboutUsPic.setBounds(70, 510, 150, 50);

        JButton aboutUsBut = new JButton();
        aboutUsBut.setBounds(70, 510, 150, 50);
        aboutUsBut.setContentAreaFilled(false);


        layeredPane.add(back, Integer.valueOf(0));
        layeredPane.add(yourEventsPic, Integer.valueOf(3));
        layeredPane.add(yourEventsBut, Integer.valueOf(4));
        layeredPane.add(eventsNearYouPic, Integer.valueOf(5));
        layeredPane.add(eventsNearYouBut, Integer.valueOf(6));
        layeredPane.add(createEventPic, Integer.valueOf(7));
        layeredPane.add(createEventBut, Integer.valueOf(8));
        layeredPane.add(aboutUsPic, Integer.valueOf(11));
        layeredPane.add(aboutUsBut, Integer.valueOf(12));


        frame.setContentPane(layeredPane); //this method ensures that the layered pane i have created occupies the entire center of the frame (which is f in this case)
        frame.pack(); // sizes the frame to make sure all the contents are at preferred sizes

        frame.setVisible(true); //ensures the frame can actually be seen!

    }
    
    public static void refreshFrame(JFrame frame){
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
    } 

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homeScreen(frame);
    }
}
