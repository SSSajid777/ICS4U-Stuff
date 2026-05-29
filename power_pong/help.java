import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class help extends JPanel implements MouseListener, MouseMotionListener {

    int mouseX = 0;
    int mouseY = 0;
    Image bg = new ImageIcon("help.png").getImage();
    public help() {
        setPreferredSize(new Dimension(1300, 700));
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 1300, 700, this);

        //back button (bottom left)
        if (mouseX > 20 && mouseX < 220 && mouseY > 620 && mouseY < 690) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(20, 620, 200, 70);
        if (mouseX > 20 && mouseX < 220 && mouseY > 620 && mouseY < 690) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g.drawString("Back", 75, 665);

        //play button (bottom right)
        if (mouseX > 1080 && mouseX < 1280 && mouseY > 620 && mouseY < 690) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(1080, 620, 200, 70);
        if (mouseX > 1080 && mouseX < 1280 && mouseY > 620 && mouseY < 690) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString("Play", 1140, 665);
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //back button
        if (x > 20 && x < 220 && y > 620 && y < 690) {
            //goes to menu screen (add later)
        }

        //play button
        if (x > 1080 && x < 1280 && y > 620 && y < 690) {
            //goes to game screen (add later)
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

        JFrame window = new JFrame("Help");

        help help = new help();

        window.add(help);
        window.pack();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setUndecorated(true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}