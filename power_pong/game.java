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

        //scores
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 70));
        g.drawString(String.valueOf(score1), 590, 115);
        g.drawString(String.valueOf(score2), 661, 115);

        //streak number beside streak text
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString(String.valueOf(hitStreak), 660, 675);

        //win message
        if (gameOver) {
            g.setFont(new Font("Courier New", Font.BOLD, 60));
            if (score1 == 7) {
                g.drawString("PLAYER 1 WINS", 400, 370);
            }
            if (score2 == 7) {
                g.drawString("PLAYER 2 WINS", 400, 370);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (gameOver) {
            return;
        }

        //player 1 movement (W/S)
        if (p1Up) {
            p1Y -= 5;
        }
        if (p1Down) {
            p1Y += 5;
        }

        //player 2 movement (up/down arrows)
        if (p2Up) {
            p2Y -= 5;
        }
        if (p2Down) {
            p2Y += 5;
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