import javax.swing.*;
import java.awt.*;

public class RobotGrid extends JPanel {
    private Image robot;

    public RobotGrid() {
        robot = new ImageIcon("robot.png").getImage();
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int iw = robot.getWidth(this);
        int ih = robot.getHeight(this);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                g.drawImage(robot, col * iw, row * ih, this);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("100 Robots");
        RobotGrid panel = new RobotGrid();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}