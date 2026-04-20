import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Frame3 extends JFrame implements ActionListener{
   
   
    // ESTABLISH FRAME SIZE + RESET VARS
    public Frame3() {
             
        JTextField f1, f2, f3, f4, f5;
        setSize(662, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // LAYERING SETUP
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);


        // PIG BACKGROUND
        ImageIcon image1 = new ImageIcon("DiceBoard.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));


        // DICES
        // PALETTE_LAYER is the front layer
        JLabel d1 = new JLabel();
        d1.setIcon(new ImageIcon("one.png"));
        d1.setBounds(225, 60, 100, 100);
        layeredPane.add(d1, JLayeredPane.PALETTE_LAYER);
       
        JLabel d2 = new JLabel();
        d2.setIcon(new ImageIcon("two.png"));
        d2.setBounds(335, 60, 100, 100);
        layeredPane.add(d2, JLayeredPane.PALETTE_LAYER);
       
        // SCORE FIELDS
        f1 = new JTextField(10);
        f1.setBounds(31, 78, 135, 47);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);
       
        f2 = new JTextField(10);
        f2.setBounds(496, 78, 135, 47);
        layeredPane.add(f2, JLayeredPane.PALETTE_LAYER);
       
        f3 = new JTextField(10);
        f3.setBounds(31, 186, 135, 47);
        layeredPane.add(f3, JLayeredPane.PALETTE_LAYER);
       
        f4 = new JTextField(10);
        f4.setBounds(496, 186, 135, 47);
        layeredPane.add(f4, JLayeredPane.PALETTE_LAYER);
       
        f5 = new JTextField(10);
        f5.setBounds(240, 20, 200, 20);
        layeredPane.add(f5, JLayeredPane.PALETTE_LAYER);
       
         // BUTTONS
        JButton b = new JButton("Roll");
        b.addActionListener(this);
        b.setBounds(235, 170, 70, 35);
        layeredPane.add(b, JLayeredPane.PALETTE_LAYER);
       
        JButton b2 = new JButton("Hold");
        b2.addActionListener(this);
        b2.setBounds(370, 170, 70, 35);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);


        JButton b3 = new JButton("Menu");
        b3.addActionListener(this);
        b3.setBounds(350, 225, 100, 35);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);


        JButton b4 = new JButton("Exit");
        b4.addActionListener(this);
        b4.setBounds(220, 225, 100, 35);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);
           
    }
    public void actionPerformed(ActionEvent e) {


        String action = e.getActionCommand();
        //if button pressed is the exit button
         if (action.equals("Exit")) {
             System.exit(0);
         }
    }


    public static void main(String args[]) {
        //adds a new class object and sets it to visible
        Frame3 x = new Frame3();
        x.setVisible(true);
    }
}
