import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class win extends JFrame implements ActionListener {

    // creates label
    JLabel l1;

    // creates button
    JButton b1, b2;

    // creates text field
    JTextField f1;

    // create layered pane window
    JLayeredPane layeredPane = new JLayeredPane();

    public win() {

        // adds a title to the window
        super("Game Over");
        music("win.wav");

        // sets size of the screen
        setSize(1314, 730);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // allows for user to exit the program

        // layering setup
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // image on panel
        ImageIcon image1 = new ImageIcon("P1 win.png");
        JLabel pic = new JLabel(image1);
        pic.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(pic, Integer.valueOf(0));

        //"Play Again" button
        JButton b1 = new JButton("Play Again");
        b1.setBackground(Color.GREEN);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.addActionListener(this); // calls action listner so that program is able to read user's input
        b1.setBounds(300, 610, 200, 50);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        //"Main" button
        JButton b2 = new JButton("Main");
        b2.setBackground(Color.YELLOW);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.addActionListener(this); // calls action listner so that program is able to read user's input
        b2.setBounds(800, 610, 200, 50);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);
    }

    // function to play a sound/music
    public static void music(String sound) {
        File lol = new File(sound);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        //if button pressed is the play again button
        if (action.equals("Play Again")) {
            game x = new game();
            x.setVisible(true);
            dispose();
        }
        //if button pressed is the main button
        if (action.equals("Main")) {
            Main x = new Main();
            x.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        //adds a new class object and sets it to visible
        win x = new win();
        x.setVisible(true);
    }
}