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

        setSize(1300, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // BACKGROUND
        ImageIcon image1 = new ImageIcon("DiceBoard.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));

        // DICES
        // PALETTE_LAYER is the front layer
        d1.setIcon(new ImageIcon("one.png"));
        d1.setBounds(450, 270, 100, 100);
        layeredPane.add(d1, JLayeredPane.PALETTE_LAYER);

        d2.setIcon(new ImageIcon("two.png"));
        d2.setBounds(750, 270, 100, 100);
        layeredPane.add(d2, JLayeredPane.PALETTE_LAYER);

        // SCORE FIELDS
        f3.setFont(new Font("Arial", Font.BOLD, 24));
        f3.setForeground(Color.BLUE);
        f3.setBounds(99, 221, 200, 60);
        layeredPane.add(f3, JLayeredPane.PALETTE_LAYER);

        f4.setFont(new Font("Arial", Font.BOLD, 24));
        f4.setForeground(Color.RED);
        f4.setBounds(1003, 222, 200, 60);
        layeredPane.add(f4, JLayeredPane.PALETTE_LAYER);

        f1.setFont(new Font("Arial", Font.BOLD, 24));
        f1.setForeground(Color.BLUE);
        f1.setBounds(100, 476, 200, 60);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);

        f2.setFont(new Font("Arial", Font.BOLD, 24));
        f2.setForeground(Color.RED);
        f2.setBounds(1005, 474, 200, 60);
        layeredPane.add(f2, JLayeredPane.PALETTE_LAYER);

        // turn indicator
        f5.setFont(new Font("Arial", Font.BOLD, 28));
        f5.setForeground(Color.WHITE);
        f5.setBackground(Color.BLACK);
        f5.setBounds(450, 20, 400, 55);
        layeredPane.add(f5, JLayeredPane.PALETTE_LAYER);

        // BUTTONS
        JButton b1 = new JButton("Roll");
        b1.setBackground(Color.GREEN);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.setPreferredSize(new Dimension(150, 55));
        b1.setBounds(420, 490, 150, 55);
        b1.addActionListener(this);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        JButton b2 = new JButton("Hold");
        b2.setBackground(Color.ORANGE);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.setPreferredSize(new Dimension(150, 55));
        b2.setBounds(720, 490, 150, 55);
        b2.addActionListener(this);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        JButton b4 = new JButton("Exit");
        b4.setBackground(Color.RED);
        b4.setFont(new Font("Arial", Font.BOLD, 24));
        b4.setPreferredSize(new Dimension(150, 55));
        b4.setBounds(420, 620, 150, 55);
        b4.addActionListener(this);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);

        JButton b3 = new JButton("Menu");
        b3.setBackground(Color.YELLOW);
        b3.setFont(new Font("Arial", Font.BOLD, 24));
        b3.setPreferredSize(new Dimension(150, 55));
        b3.setBounds(720, 620, 150, 55);
        b3.addActionListener(this);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

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