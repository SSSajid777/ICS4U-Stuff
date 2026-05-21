import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RobotRandom extends JPanel {
    private Image robot;
    private int[] xs = new int[1000];
    private int[] ys = new int[1000];

    public RobotRandom() {
        robot = new ImageIcon("robot.png").getImage();
        setPreferredSize(new Dimension(640, 480));
        setBackground(Color.BLACK);

        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            xs[i] = rand.nextInt(640);
            ys[i] = rand.nextInt(480);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 1000; i++) {
            g.drawImage(robot, xs[i], ys[i], this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("1000 Random Robots");
        RobotRandom panel = new RobotRandom();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}