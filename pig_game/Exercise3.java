import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Exercise3 extends JFrame implements ActionListener {

    public static JLabel d1 = new JLabel();
    public static JLabel d2 = new JLabel();
    public static int score = 0;
    public static int tscorep1 = 0;
    public static int tscorep2 = 0;
    public static boolean turn;
    JTextField f1, f2, f3, f4, f5;
    public static String p1, p2;

    public Exercise3() {
        turn = true;

        tscorep1 = 0;
        tscorep2 = 0;

        p1 = "Turn: Player 1";
        p2 = "Turn: Player 2";

        f1 = new JTextField(2);
        f2 = new JTextField(2);
        f3 = new JTextField(3);
        f4 = new JTextField(3);
        f5 = new JTextField(10);

        setSize(975, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        ImageIcon image1 = new ImageIcon("Background.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));

        d1.setIcon(new ImageIcon("one.png"));
        d1.setBounds(350, 130, 100, 100);
        layeredPane.add(d1, JLayeredPane.PALETTE_LAYER);

        d2.setIcon(new ImageIcon("two.png"));
        d2.setBounds(515, 130, 100, 100);
        layeredPane.add(d2, JLayeredPane.PALETTE_LAYER);

        f1.setBounds(160, 375, 30, 40);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);

        f2.setBounds(780, 375, 30, 40);
        layeredPane.add(f2, JLayeredPane.PALETTE_LAYER);

        f3.setBounds(160, 250, 30, 40);
        layeredPane.add(f3, JLayeredPane.PALETTE_LAYER);

        f4.setBounds(780, 250, 30, 40);
        layeredPane.add(f4, JLayeredPane.PALETTE_LAYER);

        f5.setBounds(387, 420, 200, 25);
        layeredPane.add(f5, JLayeredPane.PALETTE_LAYER);

        JButton b1 = new JButton("Roll");
        b1.setBounds(407, 270, 70, 35);
        b1.addActionListener(this);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        JButton b2 = new JButton("Hold");
        b2.setBounds(487, 270, 70, 35);
        b2.addActionListener(this);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        JButton b3 = new JButton("Menu");
        b3.setBounds(487, 325, 100, 35);
        b3.addActionListener(this);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        JButton b4 = new JButton("Exit");
        b4.setBounds(377, 325, 100, 35);
        b4.addActionListener(this);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);

        if (turn == true) {
            f5.setText(String.valueOf(p1));
        } else if (turn == false) {
            f5.setText(String.valueOf(p2));
        }
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if (action.equals("Exit")) {
            System.exit(0);
        }
        if (action.equals("Menu")) {
            menu x = new menu();
            x.setVisible(true);
            dispose();
        }
    }

    public static void main(String args[]) {
        // adds a new class object and sets it to visible
        Exercise3 x = new Exercise3();
        x.setVisible(true);
    }
}