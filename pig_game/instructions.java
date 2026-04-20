import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class instructions extends JFrame implements ActionListener {


    // create buttons
    public instructions() {
        JTextArea f1;


        String intro = """


Instructions:


Choose a starting player.


On your turn, you:


Roll the die.


If you roll a 1, your turn ends, and you score 0 points for that turn.


If you roll 2–6, you can:


Roll again, risking your turn total if you roll a 1.


Hold, ending your turn and adding your turn total to your overall score.


Pass the die to the next player after you roll a 1 or choose to hold.


Repeat until a player’s total score reaches 100 or more—they win!
                """;
        f1 = new JTextArea();
        // adds a title to the window


        setSize(975, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);


        f1.setBounds(0, 0, 700, 400);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);
        f1.setText(String.valueOf(intro));


        // creates the buttons and sets them up to be used in actionPerformed
        JButton b1= new JButton("Exit");
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
        // if button pressed is the sum button


        // if button pressed is the exit button
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
        instructions x = new instructions();
        x.setVisible(true);
    }
}
