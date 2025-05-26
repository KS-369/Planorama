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


// Image panel is a custom Jpanel class that displays an image at a specific location and size on the screen

class ImagePanel extends JPanel {
    
    // creating fields
    BufferedImage the_image; // bufferedimage is a subclass of the image class that helps handle the image data
    int height;
    int width;
    int X;
    int Y;
    String the_path; // path to image file
    
    //CONSTRUCTOR
    // Descripton: 
    // Constructor for the ImagePanel class (allows us to make ImagePanel objects by supplying appropraite arguments)
    // Inputs:
    // image_path (string containing file path to image file), theX and theY (integers representing x and y coords (where image will be drawn), theWidth and theHeight (integers representing w and h respectively (scales image))
    // Output:
    // A new panel that is all ready to display the specified image at the right location with the proper dimensions.
    // Example: 
    // Creating an object/using constructor: ImagePanel panel = new ImagePanel("hello/dog.png", 25, 25, 100, 100);
    // When the imagepanel object is added to the screen in some way (e.g. through a frame or layered pane), the image contained within the specific fied will be displayed at the coords. (25,25) with a length and width of 100.
    public ImagePanel(String image_path, int theX, int theY, int theWidth, int theHeight){

        this.height = theHeight;
        this.width = theWidth;
        this.X = theX;
        this.Y = theY;
        this.the_path = image_path;
        
        
        // using try and catch in case there are any issues with the image path, e.g. if it doesn't exist
        
        try {
            File myFile = new File(image_path);
            the_image = ImageIO.read(myFile);
        } catch (IOException e){
            e.printStackTrace();
            
     
        }
    }
        
    
    // PAINT COMPONENT METHOD:
    // Description: 
    // Draws the actual image on the panel, ensures it can be viewed on the GUI
    // Inputs:
    // A Graphics object (stored in var. g) that is used to draw on the panel
    // Output:
    // Nothing is returned, but this method ensures that images (objects of this class) are put on the screen at the specified coordinates and dimensions
    // Example: 
    // This method is run automatically with the creation of an image panel object, meaning we never call this ourselves
    
    @Override //here i override the paint component method so that my images are properly able to be displayed on the screen at the wanted coordinates and with the desired size
    protected void paintComponent(Graphics g){
            
        super.paintComponent(g);
            
        if (the_image != null){ //the indented block of code (within curly brackets) will only run if there is actually an image, preventing issues
            g.drawImage(the_image, this.X, this.Y, this.width, this.height, null);
        }
    }
        
    
}

//MyProgram class contains key methods relating to the creation of the GUI, including the home page creator method and the page refresher method (that removes previous screen elements)


public class MyProgram {
    
    public static JLayeredPane layeredPane; //this is made static so that elements can be added to this specific layered pane from other areas of the project

    // HOMESCREEN METHOD:
    // Description:
    // Displays the homescreen with the background and add buttons (essentially just makes home screen)
    // Inputs:
    // JFrame frame (the main application window that is used throughout the majority of the program. The method uses the frame to add all the elements on top and display them).
    // Output:
    // The frame is udpated with a layered pane containing visual elements and buttons 
    // Example usage:
    // MyProgram.homescreen(frame); (assuming frame is a JFrame object)
    // Result - the blue screen with an event picture in the middle, a description in the middle, and a navigation panel to the left side with other page options
    
    public static void homeScreen(JFrame frame){
            
    layeredPane = new JLayeredPane();
    layeredPane.setPreferredSize(new Dimension(1200, 700));
        
    // here i use the imagepanel class i made to create the background image, and specify the location and dimensions using the setbounds method
    ImagePanel back = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\Planorama.png", 0, 0, 1200, 700);
    back.setBounds(0,0,1200,700);
        
    // the add method is used with the layered pane to add the background
    layeredPane.add(back, Integer.valueOf(0));

    sidePannel(layeredPane, frame);
    
    frame.setContentPane(layeredPane); //this method ensures that the layered pane i have created occupies the entire center of the frame (which is f in this case)
    frame.pack(); // sizes the frame to make sure all the contents are at preferred sizes
      
    frame.setVisible(true); //ensures the frame can actually be seen!
   
    }
    
    // REFRESH FRAME METHOD:
    // Description:
    // Clears and refreshes anything within the frame (in other words just empties it, leaving just the frame). This way the program doesn't simply add more and more layers as the user uses the platform, which keeps everything running much more efficiently
    // Input:
    // JFrame frame (the main frame to be refreshed)
    // Output: 
    // Nothing is returned, but the frame is emptied and redrawn
    // Example:
    // If my program was displaying my home screen but then this function was called: MyProgram.refreshFrame(frame);, the home page would dissapear leaving just the blank frame
    
    public static void sidePannel(JLayeredPane layeredPane, JFrame frame){
         
    // the next lines are simply a pattern of making image panel objects for the buttons (and using the set bounds method for location/dimensions), then making a button object, placing it in the same location, and making it transparent so that the image is seen
    // these result in more proffesional looking buttons with custom icons 
    
    //Events near you button
    ImagePanel eventsNearYouPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\eventsnearu.png", 0, 0, 150, 50);
    eventsNearYouPic.setBounds(70,290, 150, 50);
        
    JButton eventsNearYouBut = new JButton();
    eventsNearYouBut.setBounds(70, 290, 150, 50);
    eventsNearYouBut.setContentAreaFilled(false);
    
    // the action listener methods are used to give an actual function to the button to perform. the tasks that the button does are manually created by making classes for each action, shown in the button actions file
    
    eventsNearYouBut.addActionListener(new EventsNearYou(frame));
    
    //Create event button
    ImagePanel createEventPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\createEvent.png", 0, 0, 150, 50);
    createEventPic.setBounds(70,440, 150, 50);
        
    JButton createEventBut = new JButton();
    createEventBut.setBounds(70, 440, 150, 50);
    createEventBut.setContentAreaFilled(false);
    
    //About us button
    ImagePanel aboutUsPic = new ImagePanel("C:\\Users\\shabm2770\\OneDrive - Waterloo Region District School Board\\Documents\\NetBeansProjects\\Planorama\\src\\main\\java\\aboutUs.png", 0, 0, 150, 50);
    aboutUsPic.setBounds(70,580, 150, 50);
        
    JButton aboutUsBut = new JButton();
    aboutUsBut.setBounds(70, 580, 150, 50);
    aboutUsBut.setContentAreaFilled(false);
        
    // the add method is used with the layered pane to add the actual elements to the panee, for instance the pictures and buttons are manually added to the layer specific in the brackets
    
    layeredPane.add(eventsNearYouPic, Integer.valueOf(1));
    layeredPane.add(eventsNearYouBut, Integer.valueOf(2));
    layeredPane.add(createEventPic, Integer.valueOf(3));
    layeredPane.add(createEventBut, Integer.valueOf(4));
    layeredPane.add(aboutUsPic, Integer.valueOf(5));
    layeredPane.add(aboutUsBut, Integer.valueOf(6));

    frame.setContentPane(layeredPane); //this method ensures that the layered pane i have created occupies the entire center of the frame (which is f in this case)
    frame.pack(); // sizes the frame to make sure all the contents are at preferred sizes
      
    frame.setVisible(true); //ensures the frame can actually be seen!
   
    }
    
    public static void refreshFrame(JFrame frame) {
        frame.getContentPane().removeAll(); // clears current components
        frame.revalidate(); // tells the layout manager to recalculate layout
        frame.repaint();    // tells Swing to redraw the frame
    }

    // MAIN  METHOD:
    // The main method simply launches the application. Alongside this, it makes the first initial frame and specifies some of its properties so that it is ready to be used with the other methods. The home sceen method is also called, allowing the user to access all the buttons
    
    public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(1200, 700); //dimensions
    frame.setLayout(null); //essentially ensures there is a set size and there is full control over placement
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); ///when user closes window, program ends5
    homeScreen(frame); //makes home screen
    }
}
