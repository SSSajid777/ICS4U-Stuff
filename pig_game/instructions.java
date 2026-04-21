import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class instructions extends JFrame implements ActionListener {

    public instructions() {
        JTextArea f1;

        String intro = """

Instructions:

Each turn, a player repeatedly rolls two dice until a 1 is rolled or the player decides to hold.

If a single 1 is rolled, the player scores nothing and the turn ends.

If two 1s are rolled, the player's entire score is lost and the turn ends.

If the player rolls any other number, it is added to their turn total and the turn continues.

If a double is rolled, the total is added but the player must roll again.

If a player chooses to hold, their turn total is added to their score and it becomes the next player's turn.

The first player to 100 or more points wins.
                """;

        f1 = new JTextArea();

        setSize(975, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        f1.setBounds(0, 0, 700, 400);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);
        f1.setText(String.valueOf(intro));

        JButton b1 = new JButton("Exit");
        b1.setBounds(65, 400, 70, 35);
        b1.addActionListener(this);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        JButton b2 = new JButton("Menu");
        b2.setBounds(170, 400, 70, 35);
        b2.addActionListener(this);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);
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
        instructions x = new instructions();
        x.setVisible(true);
    }
}