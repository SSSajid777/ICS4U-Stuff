import javax.swing.*;
import java.awt.*;
public class robot1 extends JPanel {
    private Image robot;
    public robot1() {
        robot = new ImageIcon("robot.png").getImage();
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.BLACK);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draws the robot image at (100, 50)
        g.drawImage(robot, 100, 50, this);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Robot");
        robot1 panel = new robot1();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
