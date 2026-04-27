import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Help extends JFrame implements ActionListener {

    // create buttons
    public Help() {

        setSize(1300, 730);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layering setup
        JLayeredPane layeredPane = new JLayeredPane();
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
        b1.setBounds(150, 610, 200, 50);
        b1.addActionListener(this); // calls action listner so that program is able to read user's input
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        // "Menu" button
        JButton b2 = new JButton("Menu");
        b2.setBackground(Color.YELLOW);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.setBounds(550, 610, 200, 50);
        b2.addActionListener(this); // calls action listner so that program is able to read user's input
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        // "Play" button
        JButton b3 = new JButton("Play");
        b3.setBackground(Color.GREEN);
        b3.setFont(new Font("Arial", Font.BOLD, 24));
        b3.setBounds(950, 610, 200, 50);
        b3.addActionListener(this); // calls action listner so that program is able to read user's input
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        //if button pressed is the exit button
        if (action.equals("Exit")) {
            System.exit(0);
        }
        //if button pressed is the menu button
        if (action.equals("Menu")) {
            Main x = new Main();
            x.setVisible(true);
            dispose();
        }
        //if button pressed is the play button
        if (action.equals("Play")) {
            game x = new game();
            x.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        // adds a new class object and sets it to visible
        Help x = new Help();
        x.setVisible(true);
    }
}