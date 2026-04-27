import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Main extends JFrame implements ActionListener {

    // create buttons
    public Main() {
        // adds a title to the window

        setSize(1300, 730);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // game background image
        ImageIcon image1 = new ImageIcon("main_menu.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));

        // creates the buttons and sets them up to be used in actionPerformed
        JButton b1 = new JButton("Rules");
        b1.setBackground(Color.CYAN);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(150, 610, 200, 50);
        b1.addActionListener(this);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        JButton b2 = new JButton("Play");
        b2.setBackground(Color.GREEN);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setBounds(550, 610, 200, 50);
        b2.addActionListener(this);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        JButton b3 = new JButton("Exit");
        b3.setBackground(Color.RED);
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setBounds(950, 610, 200, 50);
        b3.addActionListener(this);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);
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

        // if button pressed is the exit button
        if (action.equals("Exit")) {
            System.exit(0);
        }
        // if button pressed is the play button
        if (action.equals("Play")) {
            game x = new game();
            x.setVisible(true);
            dispose();
        }
        // if button pressed is the rules button
        if (action.equals("Rules")) {
            Help x = new Help();
            x.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        // adds a new class object and sets it to visible
        music("menu_music.wav");
        Main x = new Main();
        x.setVisible(true);
    }
}