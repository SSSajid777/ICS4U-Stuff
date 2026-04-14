import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class simpleCalculator extends JFrame implements ActionListener {

    // display textfield - declared the same way as f1, f2, f3 in add2nums
    JTextField display;

    // number buttons
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;

    // operation buttons
    JButton bAdd, bSub, bMul, bDiv, bEquals, bPlusMinus, bCE;

    // remembers the first number and the chosen operation
    float firstNum = 0;
    String operator = "";

    // true means the next digit starts a brand new number on the display
    boolean freshInput = true;

    // layered pane from the MainMenu template
    JLayeredPane layeredPane = new JLayeredPane();

    public simpleCalculator() {

        super("Simple Calculator");
        setSize(480, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // same layered pane setup as MainMenu template
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // display textfield 
        display = new JTextField(20);
        display.setEditable(false);
        display.setText("0");
        display.setBounds(35, 50, 295, 42);
        layeredPane.add(display, JLayeredPane.PALETTE_LAYER);

        //NUMBER BUTTONS
        b1 = new JButton("1");
        b1.addActionListener(this);
        b1.setBounds(35, 115, 80, 55);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        b2 = new JButton("2");
        b2.addActionListener(this);
        b2.setBounds(125, 115, 80, 55);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        b3 = new JButton("3");
        b3.addActionListener(this);
        b3.setBounds(215, 115, 80, 55);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        b4 = new JButton("4");
        b4.addActionListener(this);
        b4.setBounds(35, 180, 80, 55);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);

        b5 = new JButton("5");
        b5.addActionListener(this);
        b5.setBounds(125, 180, 80, 55);
        layeredPane.add(b5, JLayeredPane.PALETTE_LAYER);


        b6 = new JButton("6");
        b5.addActionListener(this);
        b5.setBounds(125, 180, 80, 55);
        layeredPane.add(b5, JLayeredPane.PALETTE_LAYER);



        b7 = new JButton("7");
        b5.addActionListener(this);
        b5.setBounds(125, 180, 80, 55);
        layeredPane.add(b5, JLayeredPane.PALETTE_LAYER);



        b8 = new JButton("8");
        b5.addActionListener(this);
        b5.setBounds(125, 180, 80, 55);
        layeredPane.add(b5, JLayeredPane.PALETTE_LAYER);



        b5 = new JButton("5");
        b5.addActionListener(this);
        b5.setBounds(125, 180, 80, 55);
        layeredPane.add(b5, JLayeredPane.PALETTE_LAYER);

        

