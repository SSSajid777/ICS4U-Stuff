import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class diceroll extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2;
    JLayeredPane layeredPane = new JLayeredPane();

    public diceroll() {

        super("Main Menu");
        setSize(750, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        ImageIcon image1 = new ImageIcon(getClass().getResource("/blank.png"));
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, 750, 500);
        layeredPane.add(bg, Integer.valueOf(0));

        l1 = new JLabel();
        l1.setIcon(new ImageIcon(getClass().getResource("/dice.png")));
        l1.setBounds(120, 30, 509, 360);
        layeredPane.add(l1, JLayeredPane.PALETTE_LAYER);

        b1 = new JButton("Run Program");
        b1.addActionListener(this);
        b1.setBounds(245, 390, 150, 45);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        b2 = new JButton("Quit");
        b2.addActionListener(this);
        b2.setBounds(355, 390, 150, 45);
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

        if (action.equals("Quit")) {
            System.exit(0);
        }

        if (action.equals("Run Program")) {
            DiceGame x = new DiceGame();
            x.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        diceroll x = new diceroll();
        music("back.wav");
        x.setVisible(true);
    }
}

class DiceGame extends JFrame implements ActionListener {

    JLabel l1;
    JLabel f1;
    JButton b1, b2, b3;
    JLayeredPane layeredPane = new JLayeredPane();

    String[] diceNames = {"one", "two", "three", "four", "five", "six"};
    Random rand = new Random();

    public DiceGame() {

        super("Dice Roll");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        l1 = new JLabel();
        l1.setIcon(new ImageIcon(getClass().getResource("one.png")));
        l1.setBounds(250, 30, 400, 400);
        layeredPane.add(l1, JLayeredPane.PALETTE_LAYER);

        b1 = new JButton("main");
        b1.addActionListener(this);
        b1.setBounds(60, 390, 80, 35);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        b2 = new JButton("roll");
        b2.addActionListener(this);
        b2.setBounds(150, 390, 80, 35);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        b3 = new JButton("Quit");
        b3.addActionListener(this);
        b3.setBounds(240, 390, 80, 35);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        f1 = new JLabel("Press roll to roll the dice!");
        f1.setBounds(340, 390, 220, 35);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);
    }

    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equals("roll")) {
            int roll = rand.nextInt(6);
            l1.setIcon(new ImageIcon(getClass().getResource(diceNames[roll] + ".png")));
            f1.setText("You rolled a " + diceNames[roll]);
        }

        if (action.equals("main")) {
            diceroll x = new diceroll();
            x.setVisible(true);
            dispose();
        }

        if (action.equals("Quit")) {
            System.exit(0);
        }
    }
}