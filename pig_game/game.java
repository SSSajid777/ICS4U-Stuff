// imports for java swing, action events and random
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class game extends JFrame implements ActionListener {

    JLayeredPane layeredPane = new JLayeredPane();
    static JLabel diceLabel;
    static ImageIcon[] diceImages = new ImageIcon[6];
    public String dice1;
    public String dice2;
    public int dice1_value;
    public int dice2_value;
    // used to switch turns for player 1 and 2
    public boolean turn = true;
    // to add the scores from the dice
    public int number1;
    public int number2;
    public int p1ts = 0;
    public int p2ts = 0;
    public int score = 0;
    public static String p1 = "Player 1's Turn";
    public static String p2 = "Player 2's Turn";
    static Clip clip;

    // this is the labels used to display dice1 and dice2
    JLabel d1 = new JLabel();
    JLabel d2 = new JLabel();
    // creates the text fields used in the game
    JTextField f1, f2, f3, f4, f5;
    // creates the buttons used in the game
    JButton b1 = new JButton("Roll");
    JButton b2 = new JButton("Hold");
    JButton b3 = new JButton("Menu");
    JButton b4 = new JButton("Exit");

    public game() {
        // adds a title to the window
        super("Pig Game");
        // sets size of the screen
        setSize(1314, 730);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        music("game_music.wav");
        // layering setup
        layeredPane.setPreferredSize(getSize());
        setContentPane(layeredPane);

        // Images for the dice animation
        diceImages[0] = new ImageIcon("one.png");
        diceImages[1] = new ImageIcon("two.png");
        diceImages[2] = new ImageIcon("three.png");
        diceImages[3] = new ImageIcon("four.png");
        diceImages[4] = new ImageIcon("five.png");
        diceImages[5] = new ImageIcon("six.png");

        // game background image
        ImageIcon image1 = new ImageIcon("DiceBoard.png");
        JLabel bg = new JLabel(image1);
        bg.setBounds(0, 0, image1.getIconWidth(), image1.getIconHeight());
        layeredPane.add(bg, Integer.valueOf(0));

        // player 1 total score on the left side
        f1 = new JTextField(10);
        f1.setFont(new Font("Arial", Font.BOLD, 24));
        f1.setForeground(Color.BLUE);
        f1.setBounds(99, 221, 200, 60);
        f1.setText(String.valueOf(score));
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);

        // player 1 round score on the left side
        f3 = new JTextField(10);
        f3.setFont(new Font("Arial", Font.BOLD, 24));
        f3.setForeground(Color.BLUE);
        f3.setBounds(100, 476, 200, 60);
        f3.setText(String.valueOf(score));
        layeredPane.add(f3, JLayeredPane.PALETTE_LAYER);

        // player 2 total score on the right side
        f2 = new JTextField(10);
        f2.setFont(new Font("Arial", Font.BOLD, 24));
        f2.setForeground(Color.RED);
        f2.setBounds(1003, 222, 200, 60);
        f2.setText(String.valueOf(score));
        layeredPane.add(f2, JLayeredPane.PALETTE_LAYER);

        // player 2 round score on the right side
        f4 = new JTextField(10);
        f4.setFont(new Font("Arial", Font.BOLD, 24));
        f4.setForeground(Color.RED);
        f4.setBounds(1005, 474, 200, 60);
        f4.setText(String.valueOf(score));
        layeredPane.add(f4, JLayeredPane.PALETTE_LAYER);

        // adds the labels for the dice to the layeredpane
        d1.setIcon(new ImageIcon(dice1));
        d1.setBounds(450, 270, 100, 100);
        layeredPane.add(d1, JLayeredPane.PALETTE_LAYER);

        d2.setIcon(new ImageIcon(dice2));
        d2.setBounds(750, 270, 100, 100);
        layeredPane.add(d2, JLayeredPane.PALETTE_LAYER);

        // text field that will display which players turn it is
        f5 = new JTextField(10);
        f5.setFont(new Font("Arial", Font.BOLD, 28));
        f5.setForeground(Color.BLUE);
        f5.setBounds(450, 20, 400, 55);
        f5.setText(p1);
        layeredPane.add(f5, JLayeredPane.PALETTE_LAYER);

        // "Roll" button
        b1.setBackground(Color.GREEN);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.setPreferredSize(new Dimension(150, 55));
        b1.addActionListener(this); // calls action listner so that program is able to read user's input
        b1.setBounds(420, 490, 150, 55);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        // "Hold" button
        b2.setBackground(Color.ORANGE);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.setPreferredSize(new Dimension(150, 55));
        b2.addActionListener(this); // calls action listner so that program is able to read user's input
        b2.setBounds(720, 490, 150, 55);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        // "Menu" button
        b3.setBackground(Color.YELLOW);
        b3.setFont(new Font("Arial", Font.BOLD, 24));
        b3.setPreferredSize(new Dimension(150, 55));
        b3.addActionListener(this); // calls action listner so that program is able to read user's input
        b3.setBounds(720, 620, 150, 55);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        // "Exit" button
        b4.setBackground(Color.RED);
        b4.setFont(new Font("Arial", Font.BOLD, 24));
        b4.setPreferredSize(new Dimension(150, 55));
        b4.addActionListener(this); // calls action listner so that program is able to read user's input
        b4.setBounds(420, 620, 150, 55);
        layeredPane.add(b4, JLayeredPane.PALETTE_LAYER);
    }

    // method that runs commands depending on the button pressed
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand(); // gets user's command (eg. pressing button)

        // if user presses exit button, exit the program
        if (action.equals("Exit")) {
            System.exit(0);
        }
        // if user presses menu button, take them back to the menu
        if (action.equals("Menu")) {
            Main x = new Main();
            x.setVisible(true);
            dispose();
        }

        if (action.equals("Hold")) {
            // if player 1 presses hold
            if (turn) {
                p1ts += score;
                score = 0;
                f1.setText(String.valueOf(p1ts));
                f3.setText(String.valueOf(score));
                f5.setText(p2);
                f5.setForeground(Color.RED);
                turn = false;
            }
            // if player 2 presses hold
            else {
                p2ts += score;
                score = 0;
                f2.setText(String.valueOf(p2ts));
                f4.setText(String.valueOf(score));
                f5.setText(p1);
                f5.setForeground(Color.BLUE);
                turn = true;
            }

            if (p1ts >= 100) {
                win x = new win();
                x.setVisible(true);
                dispose();
            } else if (p2ts >= 100) {
                win2 x = new win2();
                x.setVisible(true);
                dispose();
            }
        }

        if (action.equals("Roll")) {
            Random rand = new Random();
            // the thread is a process that allows the animation to happen first
            new Thread(() -> {
                try {
                    number1 = 0;
                    number2 = 0;
                    music("Dice Rolling Sound.wav");
                    for (int i = 0; i < 10; i++) {
                        number1 = rand.nextInt(6);
                        number2 = rand.nextInt(6);
                        d1.setIcon(diceImages[number1]);
                        d2.setIcon(diceImages[number2]);
                        Thread.sleep(45);
                    }
                    System.out.println(number1 + 1);
                    System.out.println(number2 + 1);

                    // you need swingutilities so that it will work after the thread animation of the dice
                    SwingUtilities.invokeLater(() -> {
                        Random die1 = new Random();
                        Random die2 = new Random();
                        int dice1 = die1.nextInt(1, 7);
                        int dice2 = die2.nextInt(1, 7);

                        // if doubles are rolled, player must roll again so hold is disabled
                        if (dice1 == dice2 && dice1 > 1 && dice2 > 1) {
                            b2.setEnabled(false);
                        } else {
                            b2.setEnabled(true);
                        }

                        // if both dice are 1, total score resets and turn ends
                        if (dice1 == 1 && dice2 == 1) {
                            d1.setIcon(new ImageIcon("one.png"));
                            d1.setBounds(450, 270, 100, 100);
                            d2.setIcon(new ImageIcon("one.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score = 0;
                            if (turn == true) {
                                p1ts = 0;
                                f1.setText(String.valueOf(p1ts));
                                f3.setText(String.valueOf(score));
                                f5.setText(p2);
                                f5.setForeground(Color.RED);
                                turn = false;
                            } else if (turn == false) {
                                p2ts = 0;
                                f2.setText(String.valueOf(p2ts));
                                f4.setText(String.valueOf(score));
                                f5.setText(p1);
                                f5.setForeground(Color.BLUE);
                                turn = true;
                            }
                        } else if (dice1 == 1) {
                            d1.setIcon(new ImageIcon("one.png"));
                            d1.setBounds(450, 270, 100, 100);
                            score = 0;
                            if (turn == true) {
                                turn = false;
                                f3.setText(String.valueOf(score));
                                f5.setText(p2);
                                f5.setForeground(Color.RED);
                            } else if (turn == false) {
                                turn = true;
                                f4.setText(String.valueOf(score));
                                f5.setText(p1);
                                f5.setForeground(Color.BLUE);
                            }
                        } else if (dice1 == 2) {
                            d1.setIcon(new ImageIcon("two.png"));
                            d1.setBounds(450, 270, 100, 100);
                            score += 2;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 == 3) {
                            d1.setIcon(new ImageIcon("three.png"));
                            d1.setBounds(450, 270, 100, 100);
                            score += 3;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 == 4) {
                            d1.setIcon(new ImageIcon("four.png"));
                            d1.setBounds(450, 270, 100, 100);
                            score += 4;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 == 5) {
                            d1.setIcon(new ImageIcon("five.png"));
                            d1.setBounds(450, 270, 100, 100);
                            score += 5;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 == 6) {
                            d1.setIcon(new ImageIcon("six.png"));
                            d1.setBounds(450, 270, 100, 100);
                            score += 6;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        }
                        if (dice1 > 1 && dice2 == 1) {
                            d2.setIcon(new ImageIcon("one.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score = 0;
                            if (turn == true) {
                                turn = false;
                                f3.setText(String.valueOf(score));
                                f5.setText(p2);
                                f5.setForeground(Color.RED);
                            } else if (turn == false) {
                                turn = true;
                                f4.setText(String.valueOf(score));
                                f5.setText(p1);
                                f5.setForeground(Color.BLUE);
                            }
                        } else if (dice1 > 1 && dice2 == 2) {
                            d2.setIcon(new ImageIcon("two.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score += 2;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 > 1 && dice2 == 3) {
                            d2.setIcon(new ImageIcon("three.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score += 3;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 > 1 && dice2 == 4) {
                            d2.setIcon(new ImageIcon("four.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score += 4;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 > 1 && dice2 == 5) {
                            d2.setIcon(new ImageIcon("five.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score += 5;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        } else if (dice1 > 1 && dice2 == 6) {
                            d2.setIcon(new ImageIcon("six.png"));
                            d2.setBounds(750, 270, 100, 100);
                            score += 6;
                            if (turn == true) {
                                f3.setText(String.valueOf(score));
                            } else if (turn == false) {
                                f4.setText(String.valueOf(score));
                            }
                        }
                        if (turn == true) {
                            f5.setText(String.valueOf(p1));
                        } else if (turn == false) {
                            f5.setText(String.valueOf(p2));
                        }
                    });

                } catch (InterruptedException eg) {
                    eg.printStackTrace();
                }
            }).start();
        }
    }

    // function to play a sound/music
    public static void music(String sound) {
        File lol = new File(sound);
        try {
            if (clip != null) {
                clip.stop();
            }
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(lol));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        // adds a new class object and sets it to visible
        game y = new game();
        y.setVisible(true);
    }
}