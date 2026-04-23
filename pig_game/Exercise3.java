import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Exercise3 extends JFrame implements ActionListener {

    public static JLabel d1 = new JLabel(); // dice 1 image
    public static JLabel d2 = new JLabel(); // dice 2 image
    static ImageIcon[] diceImages = new ImageIcon[6]; //array to load dice images
    public static int score = 0; // current round score
    public static int tscorep1 = 0; // player 1 total score
    public static int tscorep2 = 0; // player 2 total score
    public static boolean turn; // true = player 1, false = player 2
    JTextField f1, f2, f3, f4, f5;
    public static String p1, p2;

    public Exercise3() {
        turn = true;

        tscorep1 = 0;
        tscorep2 = 0;

        p1 = "Turn: Player 1";
        p2 = "Turn: Player 2";

        f1 = new JTextField(2); // player 1 round score
        f2 = new JTextField(2); // player 2 round score
        f3 = new JTextField(3); // player 1 total score
        f4 = new JTextField(3); // player 2 total score
        f5 = new JTextField(10); // whose turn it is

        setSize(1300, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // Load dice images
        diceImages[0] = new ImageIcon("one.png");
        diceImages[1] = new ImageIcon("two.png");
        diceImages[2] = new ImageIcon("three.png");
        diceImages[3] = new ImageIcon("four.png");
        diceImages[4] = new ImageIcon("five.png");
        diceImages[5] = new ImageIcon("six.png");

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

        // player 1 total score field on the left side
        f3.setFont(new Font("Arial", Font.BOLD, 24));
        f3.setForeground(Color.BLUE);
        f3.setBounds(99, 221, 200, 60);
        layeredPane.add(f3, JLayeredPane.PALETTE_LAYER);

        // player 2 total score field on the right side
        f4.setFont(new Font("Arial", Font.BOLD, 24));
        f4.setForeground(Color.RED);
        f4.setBounds(1003, 222, 200, 60);
        layeredPane.add(f4, JLayeredPane.PALETTE_LAYER);

        // player 1 round score field on the left side
        f1.setFont(new Font("Arial", Font.BOLD, 24));
        f1.setForeground(Color.BLUE);
        f1.setBounds(100, 476, 200, 60);
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);

        // player 2 round score field on the right side
        f2.setFont(new Font("Arial", Font.BOLD, 24));
        f2.setForeground(Color.RED);
        f2.setBounds(1005, 474, 200, 60);
        layeredPane.add(f2, JLayeredPane.PALETTE_LAYER);

        // shows whose turn it is at the top
        f5.setFont(new Font("Arial", Font.BOLD, 28));
        f5.setForeground(Color.WHITE);
        f5.setBackground(Color.BLACK);
        f5.setBounds(450, 20, 400, 55);
        layeredPane.add(f5, JLayeredPane.PALETTE_LAYER);

        // roll button to roll the dice
        JButton b1 = new JButton("Roll");
        b1.setBackground(Color.GREEN);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.setPreferredSize(new Dimension(150, 55));
        b1.setBounds(420, 490, 150, 55);
        b1.addActionListener(this);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        // hold button to bank the round score
        JButton b2 = new JButton("Hold");
        b2.setBackground(Color.ORANGE);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.setPreferredSize(new Dimension(150, 55));
        b2.setBounds(720, 490, 150, 55);
        b2.addActionListener(this);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        // exit button to close the game
        JButton b4 = new JButton("Exit");
        b4.setBackground(Color.RED);
        b4.setFont(new Font("Arial", Font.BOLD, 24));
        b4.setPreferredSize(new Dimension(150, 55));
        b4.setBounds(420, 620, 150, 55);
        b4.addActionListener(this);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);

        // menu button to go back to main menu
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

    //function to roll the dice animation
    public static void rollDice() {
        Random rand = new Random();
        new Thread(() -> {
            try {
                //for loop that will print random images in an animation
                for (int i = 0; i < 10; i++) {
                    int num = rand.nextInt(6);
                    d1.setIcon(diceImages[num]);
                    d2.setIcon(diceImages[rand.nextInt(6)]);
                    Thread.sleep(45); // delay for each dice
                }
                // Play sound
                music("Dice Rolling Sound.wav");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // function to play a sound/music
    public static void music(String sound) {
        File lol = new File(sound);
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        // if button pressed is the exit button
        if (action.equals("Roll")) {

            rollDice();

            Random die1 = new Random();
            Random die2 = new Random();
            int dice1 = die1.nextInt(1, 7);
            int dice2 = die2.nextInt(1, 7);

            if (dice1 == 1) {
                d1.setIcon(new ImageIcon("one.png"));
                d1.setBounds(450, 270, 100, 100);
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
                d1.setBounds(450, 270, 100, 100);
                score = 0;
                score = score + 2;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 3) {
                d1.setIcon(new ImageIcon("three.png"));
                d1.setBounds(450, 270, 100, 100);
                score = 0;
                score = score + 3;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 4) {
                d1.setIcon(new ImageIcon("four.png"));
                d1.setBounds(450, 270, 100, 100);
                score = 0;
                score = score + 4;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 5) {
                d1.setIcon(new ImageIcon("five.png"));
                d1.setBounds(450, 270, 100, 100);
                score = 0;
                score = score + 5;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 == 6) {
                d1.setIcon(new ImageIcon("six.png"));
                d1.setBounds(450, 270, 100, 100);
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
                d2.setBounds(750, 270, 100, 100);
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
                d2.setBounds(750, 270, 100, 100);
                score = score + 2;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 3) {
                d2.setIcon(new ImageIcon("three.png"));
                d2.setBounds(750, 270, 100, 100);
                score = score + 3;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 4) {
                d2.setIcon(new ImageIcon("four.png"));
                d2.setBounds(750, 270, 100, 100);
                score = score + 4;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 5) {
                d2.setIcon(new ImageIcon("five.png"));
                d2.setBounds(750, 270, 100, 100);
                score = score + 5;
                if (turn == true) {
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 > 1 && dice2 == 6) {
                d2.setIcon(new ImageIcon("six.png"));
                d2.setBounds(750, 270, 100, 100);
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
            } else if (dice1 != 1 && dice2 == 2) {
                if (turn == true) {
                    score = 0;
                    turn = false;
                    f1.setText(String.valueOf(score));
                } else if (turn == false) {
                    score = 0;
                    turn = true;
                    f2.setText(String.valueOf(score));
                }
            } else if (dice1 != 1 && dice2 == 3) {
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
            } else if (dice1 != 1 && dice2 == 4) {
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
            } else if (dice1 != 1 && dice2 == 5) {
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
            } else if (dice1 != 1 && dice2 == 6) {
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
                f1.setText(String.valueOf(score));
                f3.setText(String.valueOf(tscorep1));
                turn = false;
            } else if (turn == false) {
                tscorep2 = tscorep2 + score;
                score = 0;
                f2.setText(String.valueOf(score));
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
            } else if (tscorep2 >= 100) {
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