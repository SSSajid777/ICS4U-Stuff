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
    // initialzes the player scores to zero to start the game
    public int player1_total_score = 0;
    public int player1_round_score = 0;
    public int player2_total_score = 0;
    public int player2_round_score = 0;
    // used to switch turns for player 1 and 2
    public int turn = 0;
    // to add the scores from the dice
    public int number1;
    public int number2;
    // this is the labels used to display dice1 and dice2
    JLabel d1 = new JLabel();
    JLabel d2 = new JLabel();
    // creates the text fields used in the game
    JTextField f1, f2, f3, f4, f5;

    public game() {
        // adds a title to the window
        super("Pig Game");
        // sets size of the screen
        setSize(1300, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // player 1 total score field on the left side
        f1 = new JTextField(10);
        f1.setFont(new Font("Arial", Font.BOLD, 24));
        f1.setForeground(Color.BLUE);
        f1.setBounds(99, 221, 200, 60);
        f1.setText(String.valueOf(player1_total_score));
        layeredPane.add(f1, JLayeredPane.PALETTE_LAYER);

        // player 1 round score field on the left side
        f3 = new JTextField(10);
        f3.setFont(new Font("Arial", Font.BOLD, 24));
        f3.setForeground(Color.BLUE);
        f3.setBounds(100, 476, 200, 60);
        f3.setText(String.valueOf(player1_round_score));
        layeredPane.add(f3, JLayeredPane.PALETTE_LAYER);

        // player 2 total score field on the right side
        f2 = new JTextField(10);
        f2.setFont(new Font("Arial", Font.BOLD, 24));
        f2.setForeground(Color.RED);
        f2.setBounds(1003, 222, 200, 60);
        f2.setText(String.valueOf(player2_total_score));
        layeredPane.add(f2, JLayeredPane.PALETTE_LAYER);

        // player 2 round score field on the right side
        f4 = new JTextField(10);
        f4.setFont(new Font("Arial", Font.BOLD, 24));
        f4.setForeground(Color.RED);
        f4.setBounds(1005, 474, 200, 60);
        f4.setText(String.valueOf(player2_round_score));
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
        f5.setForeground(Color.WHITE);
        f5.setBackground(Color.BLACK);
        f5.setBounds(450, 20, 400, 55);
        f5.setText("Player 1's Turn");
        layeredPane.add(f5, JLayeredPane.PALETTE_LAYER);

        // roll button to roll the dice
        JButton b1 = new JButton("Roll");
        b1.setBackground(Color.GREEN);
        b1.setFont(new Font("Arial", Font.BOLD, 24));
        b1.setPreferredSize(new Dimension(150, 55));
        b1.addActionListener(this); // calls action listner so that program is able to read user's input
        b1.setBounds(420, 490, 150, 55);
        layeredPane.add(b1, JLayeredPane.PALETTE_LAYER);

        // hold button to bank the round score
        JButton b2 = new JButton("Hold");
        b2.setBackground(Color.ORANGE);
        b2.setFont(new Font("Arial", Font.BOLD, 24));
        b2.setPreferredSize(new Dimension(150, 55));
        b2.addActionListener(this); // calls action listner so that program is able to read user's input
        b2.setBounds(720, 490, 150, 55);
        layeredPane.add(b2, JLayeredPane.PALETTE_LAYER);

        // menu button to go back to main menu
        JButton b3 = new JButton("Menu");
        b3.setBackground(Color.YELLOW);
        b3.setFont(new Font("Arial", Font.BOLD, 24));
        b3.setPreferredSize(new Dimension(150, 55));
        b3.addActionListener(this); // calls action listner so that program is able to read user's input
        b3.setBounds(720, 620, 150, 55);
        layeredPane.add(b3, JLayeredPane.PALETTE_LAYER);

        // exit button to close the game
        JButton b4 = new JButton("Exit");
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
            if (turn % 2 == 0) {
                player1_total_score += player1_round_score;
                player1_round_score = 0;

                f1.setText(String.valueOf(player1_total_score));
                f3.setText(String.valueOf(player1_round_score));

                f5.setText("Player 2's Turn");
            }
            // if player 2 presses hold
            else {
                player2_total_score += player2_round_score;
                player2_round_score = 0;

                f2.setText(String.valueOf(player2_total_score));
                f4.setText(String.valueOf(player2_round_score));

                f5.setText("Player 1's Turn");
            }
            turn++; // increase the turn number to switch turns

            if (player1_total_score >= 100) {
                win x = new win();
                x.setVisible(true);
                dispose();
            } else if (player2_total_score >= 100) {
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

                    // you need swingutilities so that it will work after the thread animation of the dice
                    SwingUtilities.invokeLater(() -> {

                        // if dice1 is 1, score resets and turn ends
                        if (number1 + 1 == 1) {
                            if (turn % 2 == 0) {
                                player1_round_score = 0;
                                f3.setText(String.valueOf(player1_round_score));
                                f5.setText("Player 2's Turn");
                            } else {
                                player2_round_score = 0;
                                f4.setText(String.valueOf(player2_round_score));
                                f5.setText("Player 1's Turn");
                            }
                            turn++;
                        // if dice1 is not 1 and dice2 is 1, score resets and turn ends
                        } else if (number1 + 1 != 1 && number2 + 1 == 1) {
                            // if both are 1 total score resets too
                            if (number1 + 1 == 1 && number2 + 1 == 1) {
                                if (turn % 2 == 0) {
                                    player1_total_score = 0;
                                    player1_round_score = 0;
                                    f1.setText(String.valueOf(player1_total_score));
                                    f3.setText(String.valueOf(player1_round_score));
                                    f5.setText("Player 2's Turn");
                                } else {
                                    player2_total_score = 0;
                                    player2_round_score = 0;
                                    f2.setText(String.valueOf(player2_total_score));
                                    f4.setText(String.valueOf(player2_round_score));
                                    f5.setText("Player 1's Turn");
                                }
                            } else {
                                if (turn % 2 == 0) {
                                    player1_round_score = 0;
                                    f3.setText(String.valueOf(player1_round_score));
                                    f5.setText("Player 2's Turn");
                                } else {
                                    player2_round_score = 0;
                                    f4.setText(String.valueOf(player2_round_score));
                                    f5.setText("Player 1's Turn");
                                }
                            }
                            turn++;
                        // no 1 rolled, add to round score
                        } else {
                            if (turn % 2 == 0) {
                                player1_round_score += (number1 + 1) + (number2 + 1);
                                f3.setText(String.valueOf(player1_round_score));
                            } else {
                                player2_round_score += (number1 + 1) + (number2 + 1);
                                f4.setText(String.valueOf(player2_round_score));
                            }
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
            Clip clip = AudioSystem.getClip();
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