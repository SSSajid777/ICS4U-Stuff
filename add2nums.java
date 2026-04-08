import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class add2nums extends JFrame implements ActionListener {
    // create labels
    JLabel l1, l2, l3;
    // create textfields
    JTextField f1, f2, f3;
    // create buttons
    JButton b1, b2, b3;
    public add2nums() {        
        // adds a title to the window
        super("Adding 2 numbers");
       
        //addsd text to the 3 labels created
        l1 = new JLabel("First Number:");
        l2 = new JLabel("Second Number:");
        l3 = new JLabel("Result:");


        //creates 3 textfields of width 10
        f1 = new JTextField(10);
        f2 = new JTextField(10);
        f3 = new JTextField(10);
        f3.setEditable(false);
       
        //creates the buttons and sets them up to be used in actionPerformed
        b1 = new JButton("Exit");
        b1.addActionListener(this);
        b2 = new JButton("Clear");
        b2.addActionListener(this);
        b3 = new JButton("Sum");
        b3.addActionListener(this);


        // FlowLayout allows you to add one row after the next
        setLayout(new FlowLayout(FlowLayout.CENTER, 150, 10));
        //sets the size of the frame
        setSize(400, 400);


        //adds the elements to the frame
        add(l1);
        add(f1);
        add(l2);
        add(f2);
        add(l3);
        add(f3);
        add(b1);
        add(b2);
        add(b3);        
    }
    public void actionPerformed(ActionEvent e) {


        String action = e.getActionCommand();
        //if button pressed is the sum button
        if (action.equals("Sum")) {


            float x = Float.parseFloat(f1.getText());
            float y = Float.parseFloat(f2.getText());
            float sum = x + y;
            f3.setText(String.valueOf(sum));
        }
        //if button pressed is the exit button
         if (action.equals("Exit")) {
             System.exit(0);
         }
         //if button pressed is the clear button
          if (action.equals("Clear")) {
              f1.setText("");
              f2.setText("");
              f3.setText("");              
          }
    }
    public static void main(String args[]) {
        //adds a new class object and sets it to visible
        add2nums x = new add2nums();
        x.setVisible(true);
    }
}
