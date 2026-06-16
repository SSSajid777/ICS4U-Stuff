
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;

public class game extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

    Timer timer;
    Random random = new Random();
    final int WIDTH = 1300;
    final int HEIGHT = 700;
    Image bg = new ImageIcon("gamebg.png").getImage();
    Image player = new ImageIcon("player.jpg").getImage();
    Image powerupImg = new ImageIcon("powerup.png").getImage();
    Clip music;
    Clip winSound;
    int mouseX = 0;
    int mouseY = 0;

    //scores and streak
    int score1 = 0;
    int score2 = 0;
    int hitStreak = 0;
    int lastHitter = 0;
    boolean gameOver = false;
    boolean paused = false;
    boolean winSoundPlayed = false;

    //player 1 paddle (left)
    int p1X = 60;
    int p1Y = HEIGHT / 2 - 60;
    int p1Width = 20;
    int p1Height = 120;
    int p1Speed = 11;
    boolean p1Up = false;
    boolean p1Down = false;

    //player 2 paddle (right)
    int p2X = 1220;
    int p2Y = HEIGHT / 2 - 60;
    int p2Width = 20;
    int p2Height = 120;
    int p2Speed = 11;
    boolean p2Up = false;
    boolean p2Down = false;

    //ball
    int ballX = WIDTH / 2;
    int ballY = HEIGHT / 2;
    int ballSize = 20;
    int dx = 9;
    int dy = 9;

    //powerup
    boolean powerupOnScreen = false;
    boolean powerupActive = false;
    int powerupOwner = 0;
    int powerupType = 0;
    int powerupX = 0;
    int powerupY = 0;
    int powerupSize = 75;

    public game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        timer = new Timer(16, this);
        timer.start();
        if (random.nextInt(2) == 0) {
            dx = -dx;
        }
        if (random.nextInt(2) == 0) {
            dy = -dy;
        }
        //play music
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("whee_whoo_days.wav"));
            music = AudioSystem.getClip();
            music.open(audio);
            music.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Music file not found.");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //pause screen
        if (paused) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 60));
            g.drawString("PAUSED", 540, 260);

            //resume button
            if (mouseX > 500 && mouseX < 800 && mouseY > 300 && mouseY < 355) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(500, 300, 300, 55);
            g.setColor(Color.WHITE);
            g.drawRect(500, 300, 300, 55);
            if (mouseX > 500 && mouseX < 800 && mouseY > 300 && mouseY < 355) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString("RESUME", 593, 337);

            //menu button
            if (mouseX > 500 && mouseX < 800 && mouseY > 380 && mouseY < 435) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(500, 380, 300, 55);
            g.setColor(Color.WHITE);
            g.drawRect(500, 380, 300, 55);
            if (mouseX > 500 && mouseX < 800 && mouseY > 380 && mouseY < 435) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString("MENU", 612, 417);

            //exit button
            if (mouseX > 500 && mouseX < 800 && mouseY > 460 && mouseY < 515) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(500, 460, 300, 55);
            g.setColor(Color.WHITE);
            g.drawRect(500, 460, 300, 55);
            if (mouseX > 500 && mouseX < 800 && mouseY > 460 && mouseY < 515) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString("EXIT", 612, 497);
            return;
        }

        g.drawImage(bg, 0, 0, WIDTH, HEIGHT, this);

        //paddles
        g.drawImage(player, p1X, p1Y, p1Width, p1Height, this);
        g.drawImage(player, p2X, p2Y, p2Width, p2Height, this);

        //ball
        g.setColor(Color.WHITE);
        g.fillRect(ballX, ballY, ballSize, ballSize);

        //powerup
        if (powerupOnScreen) {
            g.drawImage(powerupImg, powerupX, powerupY, powerupSize, powerupSize, this);
        }

        //scores
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 70));
        g.drawString("" + score1, 590, 115);
        g.drawString("" + score2, 661, 115);

        //streak number
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString("" + hitStreak, 660, 675);

        //win screen
        if (gameOver) {
            g.setColor(Color.BLACK);
            g.fillRect(350, 230, 600, 270);
            g.setColor(Color.WHITE);
            g.drawRect(350, 230, 600, 270);

            //win text
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            if (score1 == 7) {
                g.drawString("PLAYER 1 WINS", 463, 300);
            }
            if (score2 == 7) {
                g.drawString("PLAYER 2 WINS", 463, 300);
            }

            //exit button (small, left)
            if (mouseX > 370 && mouseX < 590 && mouseY > 335 && mouseY < 390) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(370, 335, 220, 55);
            g.setColor(Color.WHITE);
            g.drawRect(370, 335, 220, 55);
            if (mouseX > 370 && mouseX < 590 && mouseY > 335 && mouseY < 390) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font("Courier New", Font.BOLD, 25));
            g.drawString("EXIT", 449, 372);

            //menu button (small, right)
            if (mouseX > 710 && mouseX < 930 && mouseY > 335 && mouseY < 390) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(710, 335, 220, 55);
            g.setColor(Color.WHITE);
            g.drawRect(710, 335, 220, 55);
            if (mouseX > 710 && mouseX < 930 && mouseY > 335 && mouseY < 390) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString("MENU", 787, 372);

            //play again button
            if (mouseX > 370 && mouseX < 930 && mouseY > 415 && mouseY < 470) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(370, 415, 560, 55);
            g.setColor(Color.WHITE);
            g.drawRect(370, 415, 560, 55);
            if (mouseX > 370 && mouseX < 930 && mouseY > 415 && mouseY < 470) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString("PLAY AGAIN", 570, 452);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (!gameOver && !paused) {

            //move ball
            ballX += dx;
            ballY += dy;

            //bounce off top and bottom border
            if (ballY <= 65) {
                ballY = 65;
                dy = -dy;
            }
            if (ballY + ballSize >= 635) {
                ballY = 635 - ballSize;
                dy = -dy;
            }

            //collision rectangles
            Rectangle ballRect = new Rectangle(ballX, ballY, ballSize, ballSize);
            Rectangle p1Rect = new Rectangle(p1X, p1Y, p1Width, p1Height);
            Rectangle p2Rect = new Rectangle(p2X, p2Y, p2Width, p2Height);
            Rectangle powerupRect = new Rectangle(powerupX, powerupY, powerupSize, powerupSize);

            //ball hits player 1 paddle
            if (ballRect.intersects(p1Rect)) {
                dx = -dx;
                //ball direction based on paddle movement
                if (p1Up) {
                    if (dy > 0) {
                        dy = -dy;
                    }
                }
                if (p1Down) {
                    if (dy < 0) {
                        dy = -dy;
                    }
                }
                ballX = p1X + p1Width;
                hitStreak++;
                lastHitter = 1;
                //spawn powerup at streak multiple of 4
                if (hitStreak > 0 && hitStreak % 4 == 0) {
                    //clear active powerup first
                    if (powerupActive) {
                        //revert speed increase
                        if (powerupType == 1) {
                            if (powerupOwner == 1) {
                                p1Speed = 11;
                            }
                            if (powerupOwner == 2) {
                                p2Speed = 11;
                            }
                        }
                        //revert speed decrease
                        if (powerupType == 2) {
                            if (powerupOwner == 1) {
                                p2Speed = 11;
                            }
                            if (powerupOwner == 2) {
                                p1Speed = 11;
                            }
                        }
                        //revert size increase
                        if (powerupType == 3) {
                            if (powerupOwner == 1) {
                                p1Height = 120;
                            }
                            if (powerupOwner == 2) {
                                p2Height = 120;
                            }
                        }
                        powerupActive = false;
                        powerupOwner = 0;
                    }
                    powerupOnScreen = true;
                    powerupX = random.nextInt(900) + 200;
                    powerupY = random.nextInt(440) + 120;
                    powerupType = random.nextInt(3) + 1;
                }
            }

            //ball hits player 2 paddle
            if (ballRect.intersects(p2Rect)) {
                dx = -dx;
                //ball direction based on paddle movement
                if (p2Up) {
                    if (dy > 0) {
                        dy = -dy;
                    }
                }
                if (p2Down) {
                    if (dy < 0) {
                        dy = -dy;
                    }
                }
                ballX = p2X - ballSize;
                hitStreak++;
                lastHitter = 2;
                //spawn powerup at streak multiple of 4
                if (hitStreak > 0 && hitStreak % 4 == 0) {
                    //clear active powerup first
                    if (powerupActive) {
                        //revert speed increase
                        if (powerupType == 1) {
                            if (powerupOwner == 1) {
                                p1Speed = 11;
                            }
                            if (powerupOwner == 2) {
                                p2Speed = 11;
                            }
                        }
                        //revert speed decrease
                        if (powerupType == 2) {
                            if (powerupOwner == 1) {
                                p2Speed = 11;
                            }
                            if (powerupOwner == 2) {
                                p1Speed = 11;
                            }
                        }
                        //revert size increase
                        if (powerupType == 3) {
                            if (powerupOwner == 1) {
                                p1Height = 120;
                            }
                            if (powerupOwner == 2) {
                                p2Height = 120;
                            }
                        }
                        powerupActive = false;
                        powerupOwner = 0;
                    }
                    powerupOnScreen = true;
                    powerupX = random.nextInt(900) + 200;
                    powerupY = random.nextInt(440) + 120;
                    powerupType = random.nextInt(3) + 1;
                }
            }

            //ball hits powerup
            if (powerupOnScreen) {
                if (ballRect.intersects(powerupRect)) {
                    powerupOnScreen = false;
                    powerupActive = true;
                    powerupOwner = lastHitter;
                    //player speed increase (owner's paddle faster)
                    if (powerupType == 1) {
                        if (powerupOwner == 1) {
                            p1Speed = 16;
                        }
                        if (powerupOwner == 2) {
                            p2Speed = 16;
                        }
                    }
                    //opponent speed decrease (other player's paddle slower)
                    if (powerupType == 2) {
                        if (powerupOwner == 1) {
                            p2Speed = 5;
                        }
                        if (powerupOwner == 2) {
                            p1Speed = 5;
                        }
                    }
                    //player size increase (owner's paddle bigger)
                    if (powerupType == 3) {
                        if (powerupOwner == 1) {
                            p1Height = 200;
                        }
                        if (powerupOwner == 2) {
                            p2Height = 200;
                        }
                    }
                }
            }

            //ball exits left border - player 2 scores
            if (ballX < 15) {
                score2++;
                ballX = WIDTH / 2;
                ballY = HEIGHT / 2;
                dx = 9;
                dy = 9;
                if (random.nextInt(2) == 0) {
                    dx = -dx;
                }
                if (random.nextInt(2) == 0) {
                    dy = -dy;
                }
                hitStreak = 0;
                lastHitter = 0;
                powerupOnScreen = false;
                if (powerupActive) {
                    //revert speed increase
                    if (powerupType == 1) {
                        if (powerupOwner == 1) {
                            p1Speed = 11;
                        }
                        if (powerupOwner == 2) {
                            p2Speed = 11;
                        }
                    }
                    //revert speed decrease
                    if (powerupType == 2) {
                        if (powerupOwner == 1) {
                            p2Speed = 11;
                        }
                        if (powerupOwner == 2) {
                            p1Speed = 11;
                        }
                    }
                    //revert size increase
                    if (powerupType == 3) {
                        if (powerupOwner == 1) {
                            p1Height = 120;
                        }
                        if (powerupOwner == 2) {
                            p2Height = 120;
                        }
                    }
                    powerupActive = false;
                    powerupOwner = 0;
                }
                p1Height = 120;
                p2Height = 120;
                p1Speed = 11;
                p2Speed = 11;
            }

            //ball exits right border - player 1 scores
            if (ballX + ballSize > 1285) {
                score1++;
                ballX = WIDTH / 2;
                ballY = HEIGHT / 2;
                dx = 9;
                dy = 9;
                if (random.nextInt(2) == 0) {
                    dx = -dx;
                }
                if (random.nextInt(2) == 0) {
                    dy = -dy;
                }
                hitStreak = 0;
                lastHitter = 0;
                powerupOnScreen = false;
                if (powerupActive) {
                    //revert speed increase
                    if (powerupType == 1) {
                        if (powerupOwner == 1) {
                            p1Speed = 11;
                        }
                        if (powerupOwner == 2) {
                            p2Speed = 11;
                        }
                    }
                    //revert speed decrease
                    if (powerupType == 2) {
                        if (powerupOwner == 1) {
                            p2Speed = 11;
                        }
                        if (powerupOwner == 2) {
                            p1Speed = 11;
                        }
                    }
                    //revert size increase
                    if (powerupType == 3) {
                        if (powerupOwner == 1) {
                            p1Height = 120;
                        }
                        if (powerupOwner == 2) {
                            p2Height = 120;
                        }
                    }
                    powerupActive = false;
                    powerupOwner = 0;
                }
                p1Height = 120;
                p2Height = 120;
                p1Speed = 11;
                p2Speed = 11;
            }

            //player 1 movement (W/S)
            if (p1Up) {
                p1Y -= p1Speed;
            }
            if (p1Down) {
                p1Y += p1Speed;
            }

            //player 2 movement (up/down arrows)
            if (p2Up) {
                p2Y -= p2Speed;
            }
            if (p2Down) {
                p2Y += p2Speed;
            }

            //keep player 1 inside boundaries
            if (p1Y < 65) {
                p1Y = 65;
            }
            if (p1Y + p1Height > 635) {
                p1Y = 635 - p1Height;
            }

            //keep player 2 inside boundaries
            if (p2Y < 65) {
                p2Y = 65;
            }
            if (p2Y + p2Height > 635) {
                p2Y = 635 - p2Height;
            }

            //check first to 7
            if (score1 == 7 || score2 == 7) {
                gameOver = true;
                timer.stop();
                //stop music and play win sound
                if (!winSoundPlayed) {
                    if (music != null) {
                        music.stop();
                    }
                    try {
                        if (score1 == 7) {
                            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("win_1.wav"));
                            winSound = AudioSystem.getClip();
                            winSound.open(audio);
                            winSound.start();
                        }
                        if (score2 == 7) {
                            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("win_2.wav"));
                            winSound = AudioSystem.getClip();
                            winSound.open(audio);
                            winSound.start();
                        }
                    } catch (Exception ex) {
                        System.out.println("Win sound file not found.");
                    }
                    winSoundPlayed = true;
                }
            }
        }
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!gameOver) {
                paused = !paused;
                repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p1Up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p1Down = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p2Up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p2Down = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p1Up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p1Down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p2Up = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p2Down = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //pause screen buttons
        if (paused) {
            //resume button
            if (x > 500 && x < 800 && y > 300 && y < 355) {
                paused = false;
                repaint();
            }
            //menu button
            if (x > 500 && x < 800 && y > 380 && y < 435) {
                if (music != null) {
                    music.stop();
                }
                main xy = new main();
                JFrame gameWindow = new JFrame("Menu");
                gameWindow.add(xy);
                gameWindow.setUndecorated(true);
                gameWindow.pack();
                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameWindow.setLocationRelativeTo(null);
                gameWindow.setVisible(true);
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                currentFrame.dispose();
            }
            //exit button
            if (x > 500 && x < 800 && y > 460 && y < 515) {
                System.exit(0);
            }
        }

        //win screen buttons
        if (gameOver) {
            //exit button (small, left)
            if (x > 370 && x < 590 && y > 335 && y < 390) {
                System.exit(0);
            }
            //menu button (small, right)
            if (x > 710 && x < 930 && y > 335 && y < 390) {
                if (winSound != null) {
                    winSound.stop();
                }
                main xy = new main();
                JFrame gameWindow = new JFrame("Menu");
                gameWindow.add(xy);
                gameWindow.setUndecorated(true);
                gameWindow.pack();
                gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameWindow.setLocationRelativeTo(null);
                gameWindow.setVisible(true);
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                currentFrame.dispose();
            }
            //play again button (big, full width)
            if (x > 370 && x < 930 && y > 415 && y < 470) {
                if (winSound != null) {
                    winSound.stop();
                }
                score1 = 0;
                score2 = 0;
                hitStreak = 0;
                gameOver = false;
                winSoundPlayed = false;
                p1Y = HEIGHT / 2 - 60;
                p2Y = HEIGHT / 2 - 60;
                ballX = WIDTH / 2;
                ballY = HEIGHT / 2;
                dx = 9;
                dy = 9;
                if (random.nextInt(2) == 0) {
                    dx = -dx;
                }
                if (random.nextInt(2) == 0) {
                    dy = -dy;
                }
                lastHitter = 0;
                powerupOnScreen = false;
                powerupActive = false;
                powerupOwner = 0;
                p1Height = 120;
                p2Height = 120;
                p1Speed = 11;
                p2Speed = 11;
                if (music != null) {
                    music.setMicrosecondPosition(0);
                    music.loop(Clip.LOOP_CONTINUOUSLY);
                }
                timer.start();
            }
        }
    }

    //mouse movement
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        repaint();
    }
    public void mouseDragged(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {

        JFrame window = new JFrame("Game");

        game game = new game();

        window.add(game);
        window.setUndecorated(true);
        window.pack();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}