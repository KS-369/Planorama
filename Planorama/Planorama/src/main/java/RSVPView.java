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

//The  RSVPView class handles anything related to the RSVP screens for the UI

public class RSVPView {
    
    public static JLayeredPane layeredPane; //Making the layeredpane static to easiloy access it from other areas of the project
    
    // MAKE SCREEN METHOD:
    // Description:
    // Generates the screen where users can choose which event to RSVP to. Shows options with event name, price, location, etc
    // Inputs:
    // JFrame frame (the main application window tha the other elements are added to, such as the background and the buttons)
    // Output:
    // Does not return anything, but results in a ui screen with clickable RSVP options for three different events
    // Example:
    // RSVPView.makeScreen(frame);
    // Results in blue screen with three event options: : cheese tasting, dog yoga, and spring festival. Also shows one picture for each and has one rsvp button for each.
    
    public static void makeScreen(JFrame frame){
    
    MyProgram.refreshFrame(frame); //clears previous frame
            
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1200, 700));
        
    // here i use the imagepanel class i made to create the background image
    ImagePanel back = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\eventOptions.png", 0, 0, 1200, 700);
    back.setBounds(0,0,1200,700);
    
    MyProgram.sidePannel(layeredPane, frame);
    
    //to create custom buttons, image panels are created for the button "background", followed by a transparent background to sit ontop, acting as the button
    //rsvp button for first event
    ImagePanel firstRSVPPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\RSVPPic.png", 0, 0, 150, 50);
    firstRSVPPic.setBounds(700,250, 150, 50);
    
    JButton firstRSVPBut = new JButton();
    firstRSVPBut.setBounds(700, 250, 150, 50);
    firstRSVPBut.setContentAreaFilled(false);
    
    //rsvp button for second event
    ImagePanel secondRSVPPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\RSVPPic.png", 0, 0, 150, 50);
    secondRSVPPic.setBounds(700,420, 150, 50);
    
    JButton secondRSVPBut = new JButton();
    secondRSVPBut.setBounds(700, 420, 150, 50);
    secondRSVPBut.setContentAreaFilled(false);
    
    //rsvp button for third event
    ImagePanel thirdRSVPPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\RSVPPic.png", 0, 0, 150, 50);
    thirdRSVPPic.setBounds(700,590, 150, 50);
    
    JButton thirdRSVPBut = new JButton();
    thirdRSVPBut.setBounds(700, 590, 150, 50);
    thirdRSVPBut.setContentAreaFilled(false);
    
    //adding action listeners to provide an actual purpose to the button. Notice how they all use the same constructor, just with different arguments for the event name (allows for more reusable code)
    firstRSVPBut.addActionListener(new RSVPBut("Cheese Tasting", frame));
    secondRSVPBut.addActionListener(new RSVPBut("Dog Yoga", frame));
    thirdRSVPBut.addActionListener(new RSVPBut("Spring Festival", frame));
        
    // using add method to add all elements (e.g. images and buttons to layered pane)
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
    
    public static JTextField commentField; //Making the textbox static so that its input can easily be accesed later on as well
    
    // REFRESH FRAME METHOD:
    // Description:
    // RSVPScreen creates the screen to finalize RSVP details, allowing the user to enter their comment to the host, and to submit the rsvp
    // Input:
    // JFrame frame (main window that elements are added ontop of), String eventName (selected event)
    // Output: 
    // The method returns nothing, but results in a ui where user confirms RSVP with name and comment
    // Example usage: 
    // RSVPView.RSVPScreen(frame, "Dog Yoga"); - takes user to screen titled rsvp showing the event name, the user name, a text box for comments and the rsvp button
     
    public static void RSVPScreen(JFrame frame, String eventName){
    
    MyProgram.refreshFrame(frame); //clears frame
    
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1200, 700));
        
    // setting background
    ImagePanel back = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\plainBack.png", 0, 0, 1200, 700);
    back.setBounds(0,0,1200,700);
    
    // event name
    JLabel titleLabel = new JLabel("Event: " + eventName);
    titleLabel.setBounds(500, 200, 200, 30);

    // user name
    JLabel nameLabel = new JLabel("Name: Melika Shaban");
    nameLabel.setBounds(500, 250, 200, 30);

    // textfield for user's comment
    commentField = new JTextField("Enter your comment...");
    commentField.setBounds(500, 300, 200, 30);

    // button to submit rsvp 
    JButton rsvpButton = new JButton("RSVP");
    rsvpButton.setBounds(600, 350, 100, 30);
    
    rsvpButton.addActionListener(new finalizeRSVP(frame, eventName, commentField));

    // add elements to layered pane in proper order
    layeredPane.add(back, Integer.valueOf(0)); 
    layeredPane.add(titleLabel, Integer.valueOf(1)); 
    layeredPane.add(nameLabel, Integer.valueOf(2)); 
    layeredPane.add(commentField, Integer.valueOf(3)); 
    layeredPane.add(rsvpButton, Integer.valueOf(4)); 
    
           
    frame.setContentPane(layeredPane); //this method ensures that the layered pane i have created occupies the entire center of the frame (which is f in this case)
    frame.pack(); // sizes the frame to make sure all the contents are at preferred sizes
      
    frame.setVisible(true); // show frame
}
    
}
    