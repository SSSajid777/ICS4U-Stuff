import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Help extends JFrame implements ActionListener {

    JLayeredPane layeredPane = new JLayeredPane();
    // create labels
    JLabel l1;
    // create buttons
    JButton b1, b2, b3;
    static Clip clip;

    public Help() {
        // adds a title to the window
        super("Help Menu");
        // sets size of the screen
        setSize(1314, 730);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        music("rules_music.wav");
        // layering setup
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // game background image
        ImageIcon image1 = new ImageIcon("rules.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));

        // creates the buttons and sets them up to be used in actionPerformed
        JButton b1 = new JButton("Exit");
        b1.setBackground(Color.RED);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.addActionListener(this); // calls action listner so that program is able to read user's input
        b1.setBounds(150, 610, 200, 50);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        // "Menu" button
        JButton b2 = new JButton("Menu");
        b2.setBackground(Color.YELLOW);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.addActionListener(this); // calls action listner so that program is able to read user's input
        b2.setBounds(550, 610, 200, 50);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        // "Play" button
        JButton b3 = new JButton("Play");
        b3.setBackground(Color.GREEN);
        b3.setFont(new Font("Arial", Font.BOLD, 24));
        b3.addActionListener(this); // calls action listner so that program is able to read user's input
        b3.setBounds(950, 610, 200, 50);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);
    }

    // function to play a sound/music
    public static void music(String sound) {
        File lol = new File(sound);
        try {
            if (clip != null) {
                clip.stop();
            }
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
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
    //if button pressed is the menu button
    if (action.equals("Menu")) {
        if (clip != null) {
            clip.stop();
        }
        Main x = new Main();
        x.setVisible(true);
        dispose();
    }
    //if button pressed is the play button
    if (action.equals("Play")) {
        if (clip != null) {
            clip.stop();
        }
        game x = new game();
        x.setVisible(true);
        dispose();
    }
}

    public static void main(String args[]) {
        //adds a new class object and sets it to visible
        Help x = new Help();
        x.setVisible(true);
    }
}