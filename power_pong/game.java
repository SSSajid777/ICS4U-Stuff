import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class game extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

    Timer timer;
    Random random = new Random();
    final int WIDTH = 1300;
    final int HEIGHT = 700;
    Image bg = new ImageIcon("gamebg.png").getImage();
    Image player = new ImageIcon("player.jpg").getImage();
    int mouseX = 0;
    int mouseY = 0;

    //scores and streak
    int score1 = 0;
    int score2 = 0;
    int hitStreak = 0;
    boolean gameOver = false;
    boolean paused = false;

    //player 1 paddle (left)
    int p1X = 60;
    int p1Y = HEIGHT / 2 - 60;
    int p1Width = 20;
    int p1Height = 120;
    boolean p1Up = false;
    boolean p1Down = false;

    //player 2 paddle (right)
    int p2X = 1220;
    int p2Y = HEIGHT / 2 - 60;
    int p2Width = 20;
    int p2Height = 120;
    boolean p2Up = false;
    boolean p2Down = false;

    //ball
    int ballX = WIDTH / 2;
    int ballY = HEIGHT / 2;
    int ballSize = 20;
    int dx = (random.nextInt(2) == 0) ? 7 : -7;
    int dy = (random.nextInt(2) == 0) ? 7 : -7;

    public game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        timer = new Timer(16, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, WIDTH, HEIGHT, this);

        //paddles
        g.drawImage(player, p1X, p1Y, p1Width, p1Height, this);
        g.drawImage(player, p2X, p2Y, p2Width, p2Height, this);

        //ball
        g.setColor(Color.WHITE);
        g.fillRect(ballX, ballY, ballSize, ballSize);

        //scores
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 70));
        g.drawString(String.valueOf(score1), 590, 115);
        g.drawString(String.valueOf(score2), 661, 115);

        //streak number
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString(String.valueOf(hitStreak), 660, 675);

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

            //play again button
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
            g.drawString("PLAY AGAIN", 395, 372);

            //menu button
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

            //exit button
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
            g.drawString("EXIT", 616, 452);
        }

        //pause screen
        if (paused) {
            g.setColor(Color.BLACK);
            g.fillRect(450, 180, 400, 370);
            g.setColor(Color.WHITE);
            g.drawRect(450, 180, 400, 370);

            //paused text
            g.setFont(new Font("Courier New", Font.BOLD, 55));
            g.drawString("PAUSED", 558, 255);

            //resume button
            if (mouseX > 500 && mouseX < 800 && mouseY > 285 && mouseY < 340) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(500, 285, 300, 55);
            g.setColor(Color.WHITE);
            g.drawRect(500, 285, 300, 55);
            if (mouseX > 500 && mouseX < 800 && mouseY > 285 && mouseY < 340) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString("RESUME", 595, 322);

            //menu button
            if (mouseX > 500 && mouseX < 800 && mouseY > 365 && mouseY < 420) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(500, 365, 300, 55);
            g.setColor(Color.WHITE);
            g.drawRect(500, 365, 300, 55);
            if (mouseX > 500 && mouseX < 800 && mouseY > 365 && mouseY < 420) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString("MENU", 612, 402);

            //exit button
            if (mouseX > 500 && mouseX < 800 && mouseY > 445 && mouseY < 500) {
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillRect(500, 445, 300, 55);
            g.setColor(Color.WHITE);
            g.drawRect(500, 445, 300, 55);
            if (mouseX > 500 && mouseX < 800 && mouseY > 445 && mouseY < 500) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString("EXIT", 612, 482);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (gameOver || paused) {
            return;
        }

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

        //ball hits player 1 paddle
        if (ballRect.intersects(p1Rect)) {
            dx = -dx;
            ballX = p1X + p1Width;
            hitStreak++;
        }

        //ball hits player 2 paddle
        if (ballRect.intersects(p2Rect)) {
            dx = -dx;
            ballX = p2X - ballSize;
            hitStreak++;
        }

        //ball exits left border - player 2 scores
        if (ballX < 15) {
            score2++;
            resetBall();
        }

        //ball exits right border - player 1 scores
        if (ballX + ballSize > 1285) {
            score1++;
            resetBall();
        }

        //player 1 movement (W/S)
        if (p1Up) {
            p1Y -= 8;
        }
        if (p1Down) {
            p1Y += 8;
        }

        //player 2 movement (up/down arrows)
        if (p2Up) {
            p2Y -= 8;
        }
        if (p2Down) {
            p2Y += 8;
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
        }

        repaint();
    }

    public void resetBall() {
        ballX = WIDTH / 2;
        ballY = HEIGHT / 2;
        dx = (random.nextInt(2) == 0) ? 7 : -7;
        dy = (random.nextInt(2) == 0) ? 7 : -7;
        hitStreak = 0;
    }

    public void resetGame() {
        score1 = 0;
        score2 = 0;
        hitStreak = 0;
        gameOver = false;
        paused = false;
        p1Y = HEIGHT / 2 - 60;
        p2Y = HEIGHT / 2 - 60;
        resetBall();
        timer.start();
    }

    public void keyPressed(KeyEvent e) {
        //player 1
        if (e.getKeyCode() == KeyEvent.VK_W) {
            p1Up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            p1Down = true;
        }
        //player 2
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            p2Up = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            p2Down = true;
        }
        //pause toggle
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!gameOver) {
                paused = !paused;
                repaint();
            }
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

        //win screen buttons
        if (gameOver) {
            //play again button
            if (x > 370 && x < 590 && y > 335 && y < 390) {
                resetGame();
            }
            //menu button
            if (x > 710 && x < 930 && y > 335 && y < 390) {
                menu xy = new menu();
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
            if (x > 370 && x < 930 && y > 415 && y < 470) {
                System.exit(0);
            }
        }

        //pause screen buttons
        if (paused) {
            //resume button
            if (x > 500 && x < 800 && y > 285 && y < 340) {
                paused = false;
                repaint();
            }
            //menu button
            if (x > 500 && x < 800 && y > 365 && y < 420) {
                menu xy = new menu();
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
            if (x > 500 && x < 800 && y > 445 && y < 500) {
                System.exit(0);
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