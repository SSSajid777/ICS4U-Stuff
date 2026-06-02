import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JPanel implements MouseListener, MouseMotionListener {

    int mouseX = 0;
    int mouseY = 0;
    Image bg = new ImageIcon("menu.png").getImage();
    public menu() {
        setPreferredSize(new Dimension(1300, 700));
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, 1300, 700, this);

        g.setFont(new Font("Courier New", Font.BOLD, 40));

        //play button (center)
        if (mouseX > 500 && mouseX < 800 && mouseY > 230 && mouseY < 300) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(500, 230, 300, 70);
        g.setColor(Color.WHITE);
        g.drawRect(500, 230, 300, 70);
        if (mouseX > 500 && mouseX < 800 && mouseY > 230 && mouseY < 300) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString("PLAY", 603, 277);

        //help button (center)
        if (mouseX > 500 && mouseX < 800 && mouseY > 340 && mouseY < 410) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(500, 340, 300, 70);
        g.setColor(Color.WHITE);
        g.drawRect(500, 340, 300, 70);
        if (mouseX > 500 && mouseX < 800 && mouseY > 340 && mouseY < 410) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString("HELP", 603, 387);

        //exit button (center)
        if (mouseX > 500 && mouseX < 800 && mouseY > 450 && mouseY < 520) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(500, 450, 300, 70);
        g.setColor(Color.WHITE);
        g.drawRect(500, 450, 300, 70);
        if (mouseX > 500 && mouseX < 800 && mouseY > 450 && mouseY < 520) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString("EXIT", 603, 497);
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //play button
        if (x > 500 && x < 800 && y > 230 && y < 300) {
            //goes to game screen (add later)
        }

        //help button
        if (x > 500 && x < 800 && y > 340 && y < 410) {
            help xy = new help();
            JFrame gameWindow = new JFrame("Help");
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
        if (x > 500 && x < 800 && y > 450 && y < 520) {
            System.exit(0);
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

        JFrame window = new JFrame("Menu");

        menu menu = new menu();

        window.add(menu);
        window.setUndecorated(true);
        window.pack();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}