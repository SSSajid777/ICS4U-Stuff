import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class menu extends JFrame implements ActionListener {

    // create buttons
    public menu() {

        setSize(1300, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        ImageIcon image1 = new ImageIcon("main_menu.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));

        // creates the buttons and sets them up to be used in actionPerformed
        JButton b1 = new JButton("Rules");
        b1.setBounds(150, 700, 200, 45);
        b1.addActionListener(this);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        JButton b2 = new JButton("Play");
        b2.setBounds(583, 700, 200, 45);
        b2.addActionListener(this);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        JButton b3 = new JButton("Exit");
        b3.setBounds(1010, 700, 200, 45);
        b3.addActionListener(this);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        JButton b4 = new JButton("Button Operation");
        b4.setBounds(1200, 10, 150, 35);
        b4.addActionListener(this);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Exit")) {
            System.exit(0);
        }
        if (action.equals("Play")) {
            Exercise3 x = new Exercise3();
            x.setVisible(true);
            dispose();
        }
        if (action.equals("Rules")) {
            instructions x = new instructions();
            x.setVisible(true);
            dispose();
        }
        if (action.equals("Button Operation")) {
            // opens button operation window
        }
    }

    public static void main(String args[]) {
        // adds a new class object and sets it to visible
        menu x = new menu();
        x.setVisible(true);
    }
}