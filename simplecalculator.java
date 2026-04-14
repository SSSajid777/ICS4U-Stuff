import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class simpleCalculator extends JFrame implements ActionListener {

    // the display at the top of the calculator
    JTextField display;

    // number buttons
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;

    // operation buttons
    JButton bAdd, bSub, bMul, bDiv, bEquals, bPlusMinus, bCE;

    // keeps track of the first number entered and which operation was picked
    double firstNum = 0;
    String operator = "";

    // when true, the next digit pressed will start a brand new number on the display
    boolean freshInput = true;

    public simpleCalculator() {

        super("Simple Calculator");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout lets us put the display on top and buttons in the middle
        // Source: https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html
        setLayout(new BorderLayout());

        // set up the display textfield along the top
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 22));
        add(display, BorderLayout.NORTH);

        // a panel to hold all the buttons in a 5-row by 4-column grid
        // GridLayout source: https://docs.oracle.com/javase/tutorial/uiswing/layout/grid.html
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 6, 6));

        // creating all 17 buttons and hooking them up to actionPerformed
        b1 = new JButton("1");       b1.addActionListener(this);
        b2 = new JButton("2");       b2.addActionListener(this);
        b3 = new JButton("3");       b3.addActionListener(this);
        b4 = new JButton("4");       b4.addActionListener(this);
        b5 = new JButton("5");       b5.addActionListener(this);
        b6 = new JButton("6");       b6.addActionListener(this);
        b7 = new JButton("7");       b7.addActionListener(this);
        b8 = new JButton("8");       b8.addActionListener(this);
        b9 = new JButton("9");       b9.addActionListener(this);
        b0 = new JButton("0");       b0.addActionListener(this);
        bAdd      = new JButton("+");   bAdd.addActionListener(this);
        bSub      = new JButton("-");   bSub.addActionListener(this);
        bMul      = new JButton("*");   bMul.addActionListener(this);
        bDiv      = new JButton("/");   bDiv.addActionListener(this);
        bEquals   = new JButton("=");   bEquals.addActionListener(this);
        bPlusMinus = new JButton("+/-"); bPlusMinus.addActionListener(this);
        bCE       = new JButton("CE");  bCE.addActionListener(this);

        // adding buttons in the same order as the example image
        // row 1: 1, 2, 3, +
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(bAdd);
        // row 2: 4, 5, 6, -
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        buttonPanel.add(bSub);
        // row 3: 7, 8, 9, *
        buttonPanel.add(b7);
        buttonPanel.add(b8);
        buttonPanel.add(b9);
        buttonPanel.add(bMul);
        // row 4: 0, +/-, CE, /
        buttonPanel.add(b0);
        buttonPanel.add(bPlusMinus);
        buttonPanel.add(bCE);
        buttonPanel.add(bDiv);
        // row 5: three empty spots then =, to match the layout in the example
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(new JLabel());
        buttonPanel.add(bEquals);

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        // if a number was pressed, either start fresh or append to what's already there
        if (action.equals("0") || action.equals("1") || action.equals("2") ||
            action.equals("3") || action.equals("4") || action.equals("5") ||
            action.equals("6") || action.equals("7") || action.equals("8") ||
            action.equals("9")) {

            if (freshInput) {
                display.setText(action);
                freshInput = false;
            } else {
                display.setText(display.getText() + action);
            }
        }

        // if an operator was pressed, save the current number and wait for the second one
        if (action.equals("+") || action.equals("-") || action.equals("*") || action.equals("/")) {
            firstNum = Double.parseDouble(display.getText());
            operator = action;
            freshInput = true;
        }

        // equals button: do the math and show the result
        if (action.equals("=")) {
            double secondNum = Double.parseDouble(display.getText());
            double result = 0;

            if (operator.equals("+")) result = firstNum + secondNum;
            if (operator.equals("-")) result = firstNum - secondNum;
            if (operator.equals("*")) result = firstNum * secondNum;
            if (operator.equals("/")) {
                // can't divide by zero
                if (secondNum == 0) {
                    display.setText("Error");
                    freshInput = true;
                    return;
                }
                result = firstNum / secondNum;
            }

            // if the result is a whole number, drop the ".0" so it looks clean
            if (result % 1 == 0) {
                display.setText(String.valueOf((int) result));
            } else {
                display.setText(String.valueOf(result));
            }

            freshInput = true;
        }

        // flip the sign of whatever is on the display
        if (action.equals("+/-")) {
            if (!display.getText().equals("0") && !display.getText().equals("Error")) {
                double val = Double.parseDouble(display.getText());
                val = val * -1;
                if (val % 1 == 0) {
                    display.setText(String.valueOf((int) val));
                } else {
                    display.setText(String.valueOf(val));
                }
            }
        }

        // CE wipes everything and resets the calculator to its starting state
        if (action.equals("CE")) {
            display.setText("0");
            firstNum = 0;
            operator = "";
            freshInput = true;
        }
    }

    public static void main(String args[]) {
        simpleCalculator x = new simpleCalculator();
        x.setVisible(true);
    }
}