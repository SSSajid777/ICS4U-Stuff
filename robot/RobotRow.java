import javax.swing.*;
import java.awt.*;

public class RobotRow extends JPanel {
    private Image robot;

    public RobotRow() {
        robot = new ImageIcon("robot.png").getImage();
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int iw = robot.getWidth(this);

        for (int i = 0; i < 10; i++) {
            g.drawImage(robot, i * iw, 0, this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ten Robots in a Row");
        RobotRow panel = new RobotRow();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}