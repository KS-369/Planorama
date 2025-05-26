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


public class RSVPModel {
    
    public static JLayeredPane layeredPane;
    
    public static void makeScreen(JFrame frame){
    
    MyProgram.refreshFrame(frame);
            
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1200, 700));
        
    // here i use the imagepanel class i made to create the background image
    ImagePanel back = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\eventOptions.png", 0, 0, 1200, 700);
    back.setBounds(0,0,1200,700);
    
    ImagePanel firstRSVPPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\RSVPPic.png", 0, 0, 150, 50);
    firstRSVPPic.setBounds(700,250, 150, 50);
    
    JButton firstRSVPBut = new JButton();
    firstRSVPBut.setBounds(700, 250, 150, 50);
    firstRSVPBut.setContentAreaFilled(false);
    
    ImagePanel secondRSVPPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\RSVPPic.png", 0, 0, 150, 50);
    secondRSVPPic.setBounds(700,420, 150, 50);
    
    JButton secondRSVPBut = new JButton();
    secondRSVPBut.setBounds(700, 420, 150, 50);
    secondRSVPBut.setContentAreaFilled(false);
    
    ImagePanel thirdRSVPPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\RSVPPic.png", 0, 0, 150, 50);
    thirdRSVPPic.setBounds(700,590, 150, 50);
    
    JButton thirdRSVPBut = new JButton();
    thirdRSVPBut.setBounds(700, 590, 150, 50);
    thirdRSVPBut.setContentAreaFilled(false);
    
    firstRSVPBut.addActionListener(new RSVPBut("Cheese Tasting", frame));
    secondRSVPBut.addActionListener(new RSVPBut("Dog Yoga", frame));
    thirdRSVPBut.addActionListener(new RSVPBut("Spring Festival", frame));
        
    layeredPane.add(back, Integer.valueOf(0));
    
    layeredPane.add(firstRSVPPic, Integer.valueOf(1));
    layeredPane.add(firstRSVPBut, Integer.valueOf(2));
    
    layeredPane.add(secondRSVPPic, Integer.valueOf(3));
    layeredPane.add(secondRSVPBut, Integer.valueOf(4));
    
    layeredPane.add(thirdRSVPPic, Integer.valueOf(5));
    layeredPane.add(thirdRSVPBut, Integer.valueOf(6)); 
            
     
    frame.setContentPane(layeredPane); //this method ensures that the layered pane i have created occupies the entire center of the frame (which is f in this case)
    frame.pack(); // sizes the frame to make sure all the contents are at preferred sizes
      
    frame.setVisible(true); //ensures the frame can actually be seen!

    }
    
    public static JTextField commentField;
    
    public static void RSVPScreen(JFrame frame, String eventName){
    
    MyProgram.refreshFrame(frame);
    
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1200, 700));
        
    ImagePanel back = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\plainBack.png", 0, 0, 1200, 700);
    back.setBounds(0,0,1200,700);
    
    JLabel titleLabel = new JLabel("Event: " + eventName);
    titleLabel.setBounds(500, 200, 200, 30);

    JLabel nameLabel = new JLabel("Name: Melika Shaban");
    nameLabel.setBounds(500, 250, 200, 30);

    commentField = new JTextField("Enter your comment...");
    commentField.setBounds(500, 300, 200, 30);

    JButton rsvpButton = new JButton("RSVP");
    rsvpButton.setBounds(600, 350, 100, 30);
    
    rsvpButton.addActionListener(new finalizeRSVP(frame, eventName, commentField));

    layeredPane.add(back, Integer.valueOf(0)); 
    layeredPane.add(titleLabel, Integer.valueOf(1)); 
    layeredPane.add(nameLabel, Integer.valueOf(2)); 
    layeredPane.add(commentField, Integer.valueOf(3)); 
    layeredPane.add(rsvpButton, Integer.valueOf(4)); 
    
            
    frame.setContentPane(layeredPane); //this method ensures that the layered pane i have created occupies the entire center of the frame (which is f in this case)
    frame.pack(); // sizes the frame to make sure all the contents are at preferred sizes
      
    frame.setVisible(true);
}
    
}
    