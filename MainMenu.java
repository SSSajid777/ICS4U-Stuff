import java.awt.event.*;
import javax.swing.*;
//you need these library files to play a sound
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MainMenu extends JFrame implements ActionListener {
   
    // create labels
    JLabel l1;
    // create buttons
    JButton b1, b2;
    // create layered pane window
    JLayeredPane layeredPane = new JLayeredPane();


    public MainMenu() {
       
        // adds a title to the window
        super("Main Menu");


        // sets size of the screen
        setSize(750, 457);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows for user to exit the program
       
        // LAYERING SETUP      
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);


        // BACKGROUND
        ImageIcon image1 = new ImageIcon("background.jpg");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));  
       
        //"Run" button
        JButton b1 = new JButton("Run");
        b1.addActionListener(this); // calls actionlistner so that program is able to read user's input
        b1.setBounds(245, 270, 150, 45);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);
       
        //"Exit" button
        JButton b2 = new JButton("Exit");
        b2.addActionListener(this); // calls actionlistner so that program is able to read user's input
        b2.setBounds(245, 345, 150, 53);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);    
    }
    public static void music(String sound) {
        File lol = new File(sound);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent e) {


        String action = e.getActionCommand();
        //if button pressed is the exit button
         if (action.equals("Exit")) {
             System.exit(0);
         }
         //if button pressed is the run button
          if (action.equals("Run")) {
            game x = new game();
            x.setVisible(true);
            dispose();
          }
    }
    public static void main(String args[]) {
        //adds a new class object and sets it to visible
        MainMenu x = new MainMenu();
        music("back.wav");//plays the background music
        x.setVisible(true);
    }
}
