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
    int mouseX = 0;
    int mouseY = 0;
    boolean toUp = false;
    boolean toDown = false;

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
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void keyPressed(KeyEvent e) {
    }
    public void keyReleased(KeyEvent e) {
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