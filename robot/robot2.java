import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class robot2 extends JPanel implements ActionListener {
    Image robot;
    int x = 0;
    int y = 0;
    Timer timer;
    public robot2() {
        robot = new ImageIcon("robot.png").getImage();        
        timer = new Timer(1000 / 60, this);// 60 FPS timer
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Black background
        setBackground(Color.BLACK);
        // Draw robot image
        g.drawImage(robot, x, y, this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1; // move right
        repaint();
    }    public static void main(String[] args) {
        JFrame frame = new JFrame("Robot Animation");
        robot2 panel = new robot2();
        frame.add(panel);
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
