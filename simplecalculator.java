import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class simpleCalculator extends JFrame implements ActionListener {

    // create text field
    JTextField f1;

    // create buttons
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton b10, b11, b12, b13, b14, b15, b16;

    // create layered pane window
    JLayeredPane layeredPane = new JLayeredPane();
    float firstNum = 0;
    String operator = "";
    boolean freshInput = true;

    public simpleCalculator() {

        // adds a title to the window
        super("Simple Calculator");

        // sets size of the screen
        setSize(480, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LAYERING SETUP
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // display textfield
        f1 = new JTextField(20);
        f1.setEditable(false);
        f1.setText("0");
        f1.setBounds(35, 50, 295, 42);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);

        // "1" button
        b1 = new JButton("1");
        b1.addActionListener(this);
        b1.setBounds(35, 115, 80, 55);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        // "2" button
        b2 = new JButton("2");
        b2.addActionListener(this);
        b2.setBounds(125, 115, 80, 55);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        // "3" button
        b3 = new JButton("3");
        b3.addActionListener(this);
        b3.setBounds(215, 115, 80, 55);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        // "4" button
        b4 = new JButton("4");
        b4.addActionListener(this);
        b4.setBounds(35, 180, 80, 55);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);

        // "5" button
        b5 = new JButton("5");
        b5.addActionListener(this);
        b5.setBounds(125, 180, 80, 55);
        layeredPane.add(b5, JLayeredPane.PALETTE_LAYER);

        // "6" button
        b6 = new JButton("6");
        b6.addActionListener(this);
        b6.setBounds(215, 180, 80, 55);
        layeredPane.add(b6, JLayeredPane.PALETTE_LAYER);

        // "7" button
        b7 = new JButton("7");
        b7.addActionListener(this);
        b7.setBounds(35, 245, 80, 55);
        layeredPane.add(b7, JLayeredPane.PALETTE_LAYER);

        // "8" button
        b8 = new JButton("8");
        b8.addActionListener(this);
        b8.setBounds(125, 245, 80, 55);
        layeredPane.add(b8, JLayeredPane.PALETTE_LAYER);

        // "9" button
        b9 = new JButton("9");
        b9.addActionListener(this);
        b9.setBounds(215, 245, 80, 55);
        layeredPane.add(b9, JLayeredPane.PALETTE_LAYER);

        // "0" button
        b0 = new JButton("0");
        b0.addActionListener(this);
        b0.setBounds(35, 310, 80, 55);
        layeredPane.add(b0, JLayeredPane.PALETTE_LAYER);

        // "+/-" button
        b10 = new JButton("+/-");
        b10.addActionListener(this);
        b10.setBounds(125, 310, 80, 55);
        layeredPane.add(b10, JLayeredPane.PALETTE_LAYER);

        // "CE" button
        b11 = new JButton("CE");
        b11.addActionListener(this);
        b11.setBounds(215, 310, 80, 55);
        layeredPane.add(b11, JLayeredPane.PALETTE_LAYER);

        // "+" button
        b12 = new JButton("+");
        b12.addActionListener(this);
        b12.setBounds(345, 115, 80, 46);
        layeredPane.add(b12, JLayeredPane.PALETTE_LAYER);

        // "-" button
        b13 = new JButton("-");
        b13.addActionListener(this);
        b13.setBounds(345, 167, 80, 46);
        layeredPane.add(b13, JLayeredPane.PALETTE_LAYER);

        // "*" button
        b14 = new JButton("*");
        b14.addActionListener(this);
        b14.setBounds(345, 219, 80, 46);
        layeredPane.add(b14, JLayeredPane.PALETTE_LAYER);

        // "/" button
        b15 = new JButton("/");
        b15.addActionListener(this);
        b15.setBounds(345, 271, 80, 46);
        layeredPane.add(b15, JLayeredPane.PALETTE_LAYER);

        // "=" button
        b16 = new JButton("=");
        b16.addActionListener(this);
        b16.setBounds(345, 323, 80, 46);
        layeredPane.add(b16, JLayeredPane.PALETTE_LAYER);
    }

    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        if (action.equals("1") || action.equals("2") || action.equals("3") ||
           action.equals("4") || action.equals("5") || action.equals("6") ||
           action.equals("7") || action.equals("8") || action.equals("9") ||
           action.equals("0")) 
           {if (freshInput){
            f1.setText(action);
            freshInput=false;
           }
           else{
            f1.setText(f1.getText()+action);
           }

    }

        if (action.equals("+") || action.equals("-") || action.equals("*") || action.equals("/")) {
         firstNum = Float.parseFloat(f1.getText());
         operator = action;
         freshInput = true;
}

    public static void main(String args[]) {
        simpleCalculator x = new simpleCalculator();
        x.setVisible(true);
    }
}