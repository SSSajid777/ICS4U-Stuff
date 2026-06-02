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

        g.setFont(new Font("Courier New", Font.BOLD, 33));

        //back button (bottom left)
        if (mouseX > 15 && mouseX < 165 && mouseY > 635 && mouseY < 690) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(15, 635, 150, 55);
        g.setColor(Color.WHITE);
        g.drawRect(15, 635, 150, 55);
        if (mouseX > 15 && mouseX < 165 && mouseY > 635 && mouseY < 690) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString("BACK", 49, 673);

        //play button (bottom right)
        if (mouseX > 1135 && mouseX < 1285 && mouseY > 635 && mouseY < 690) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.fillRect(1135, 635, 150, 55);
        g.setColor(Color.WHITE);
        g.drawRect(1135, 635, 150, 55);
        if (mouseX > 1135 && mouseX < 1285 && mouseY > 635 && mouseY < 690) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(Color.WHITE);
        }
        g.drawString("PLAY", 1168, 673);
    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        //back button
        if (x > 15 && x < 165 && y > 635 && y < 690) {
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

        //play button
        if (x > 1135 && x < 1285 && y > 635 && y < 690) {
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
        window.setUndecorated(true);
        window.pack();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}