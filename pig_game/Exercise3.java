import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;


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


        // if button pressed is the exit button
        if (action.equals("Roll")) {


            Random die1 = new Random();
            Random die2 = new Random();
            int dice1 = die1.nextInt(1, 7);
            int dice2 = die2.nextInt(1, 7);


            if (dice1 == 1) {


                d1.setIcon(new ImageIcon("one.png"));
                d1.setBounds(350, 130, 100, 100);
                score = 0;
                if (turn == true) {
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 2) {


                d1.setIcon(new ImageIcon("two.png"));
                d1.setBounds(350, 130, 100, 100);
                score = 0;
                score = score + 2;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 3) {


                d1.setIcon(new ImageIcon("three.png"));
                d1.setBounds(350, 130, 100, 100);
                score = 0;
                score = score + 3;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 4) {


                d1.setIcon(new ImageIcon("four.png"));
                d1.setBounds(350, 130, 100, 100);
                score = 0;
                score = score + 4;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 5) {


                d1.setIcon(new ImageIcon("five.png"));
                d1.setBounds(350, 130, 100, 100);
                score = 0;
                score = score + 5;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 6) {


                d1.setIcon(new ImageIcon("six.png"));
                d1.setBounds(350, 130, 100, 100);
                score = 0;
                score = score + 6;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            }
            if (dice1 > 1 && dice2 == 1) {
                d2.setIcon(new ImageIcon("one.png"));
                d2.setBounds(515, 130, 100, 100);
                score = 0;
                if (turn == true) {
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    turn = true;
                    f2.setText(String.valueOf(score));
                }


            } else if (dice1 > 1 && dice2 == 2) {


                d2.setIcon(new ImageIcon("two.png"));
                d2.setBounds(515, 130, 100, 100);


                score = score + 2;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 3) {


                d2.setIcon(new ImageIcon("three.png"));
                d2.setBounds(515, 130, 100, 100);


                score = score + 3;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 4) {


                d2.setIcon(new ImageIcon("four.png"));
                d2.setBounds(515, 130, 100, 100);


                score = score + 4;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 5) {


                d2.setIcon(new ImageIcon("five.png"));
                d2.setBounds(515, 130, 100, 100);


                score = score + 5;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 6) {


                d2.setIcon(new ImageIcon("six.png"));
                d2.setBounds(515, 130, 100, 100);


                score = score + 6;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 != 1 && dice2 == 1) {
                if (turn == true) {
                    score = 0;
                    tscorep1 = 0;
                    f3.setText(String.valueOf(tscorep1));
                    f1.setText(String.valueOf(score));
                    turn = false;
                } else if (turn == false) {
                    score = 0;
                    tscorep2 = 0;
                    f4.setText(String.valueOf(tscorep2));
                    f2.setText(String.valueOf(score));
                    turn = true;
                }
            }


            else if (dice1 != 1 && dice2 == 2) {


                if (turn == true) {
                    score = 0;
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    score = 0;
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            }


            else if (dice1 != 1 && dice2 == 3) {
                score = 0;
                if (turn == true) {
                    score = 0;
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    score = 0;
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            }


            else if (dice1 != 1 && dice2 == 4) {
                score = 0;
                if (turn == true) {
                    score = 0;
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    score = 0;
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            }


            else if (dice1 != 1 && dice2 == 5) {
                score = 0;
                if (turn == true) {
                    score = 0;
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    score = 0;
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            }


            else if (dice1 != 1 && dice2 == 6) {
                score = 0;
                if (turn == true) {
                    score = 0;
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    score = 0;
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            }


            if (turn == true) {
                f5.setText(String.valueOf(p1));


            } else if (turn == false) {
                f5.setText(String.valueOf(p2));
            }


        }


        if (action.equals("Exit")) {
            System.exit(0);
        }
        if (action.equals("Menu")) {
            menu x = new menu();
            x.setVisible(true);
            dispose();
        }


        if (action.equals("Hold")) {
            if (turn == true) {


                tscorep1 = tscorep1 + score;
                score = 0;
                f2.setText(String.valueOf(score));
                f3.setText(String.valueOf(tscorep1));
                turn = false;
            }


            else if (turn == false) {
                tscorep2 = tscorep2 + score;
                score = 0;
                f1.setText(String.valueOf(score));
                f4.setText(String.valueOf(tscorep2));
                turn = true;
            }


            if (turn == true) {
                f5.setText(String.valueOf(p1));


            } else if (turn == false) {
                f5.setText(String.valueOf(p2));
            }


            if (tscorep1 >= 100) {
                win x = new win();
                x.setVisible(true);
                dispose();
            }
            else if (tscorep2 >= 100) {
                win2 x = new win2();
                x.setVisible(true);
                dispose();
            }
        }


    }


    public static void main(String args[]) {
        // adds a new class object and sets it to visible
        Exercise3 x = new Exercise3();
        x.setVisible(true);


    }


}
