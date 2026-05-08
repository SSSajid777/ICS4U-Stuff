/*
 * Name: Nasrin [Last Name]
 * Date: May 8, 2026
 * Description: Shin-chan's apartment building, Matazure-sou (またずれ荘)
 *              Desmos y values are all negative, so java_y = -desmos_y
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class houseBonus extends JPanel {

    private JFrame mainFrame;

    houseBonus() {
        mainFrame = new JFrame();
        mainFrame.setSize(1010, 780);
        mainFrame.setLocation(50, 50);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Matazure-sou");
        this.setLocation(0, 0);
        mainFrame.getContentPane().add(this);
        mainFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        // sky gradient
        GradientPaint sky = new GradientPaint(0, 0, new Color(102, 188, 240), 0, 640, new Color(188, 228, 255));
        g2.setPaint(sky);
        g2.fillRect(0, 0, w, h);

        // left cloud
        g.setColor(Color.WHITE);
        int[] cx25 = {110, 34, 90, 165, 192, 168, 152, 114};
        int[] cy25 = {95, 125, 170, 167, 155, 131, 125, 93};
        g.fillPolygon(cx25, cy25, 8);

        // right cloud
        int[] cx24 = {277, 278, 254, 212, 261, 321};
        int[] cy24 = {168, 113, 91, 121, 110, 116};
        g.fillPolygon(cx24, cy24, 6);

        // left background building roof
        g.setColor(new Color(195, 195, 183));
        int[] lrX = {131, 14, 46, 140};
        int[] lrY = {376, 375, 332, 333};
        g.fillPolygon(lrX, lrY, 4);

        // left background building wall
        g.setColor(new Color(228, 228, 218));
        int[] lbX = {14, 14, 131};
        int[] lbY = {526, 378, 379};
        g.fillPolygon(lbX, lbY, 3);

        // window on left background building
        g.setColor(new Color(110, 148, 180));
        int[] lwX = {36, 56, 58, 36, 35};
        int[] lwY = {394, 395, 441, 440, 395};
        g.fillPolygon(lwX, lwY, 5);

        // base of left background building
        g.setColor(new Color(188, 178, 160));
        int[] lbaseX = {4, 37, 67, 71};
        int[] lbaseY = {534, 540, 561, 600};
        g.fillPolygon(lbaseX, lbaseY, 4);

        // right background building top
        g.setColor(new Color(222, 220, 210));
        int[] rbX = {855, 961, 1000, 1000, 837};
        int[] rbY = {353, 350, 368, 400, 402};
        g.fillPolygon(rbX, rbY, 5);

        // right green bush/hill
        g.setColor(new Color(55, 112, 48));
        int[] rtX = {781, 757, 771, 776, 819, 824, 896, 972, 998, 984, 999, 999};
        int[] rtY = {611, 560, 527, 468, 475, 438, 421, 426, 455, 517, 530, 610};
        g.fillPolygon(rtX, rtY, 12);

        // main building wall (x3/y3)
        g.setColor(new Color(90, 50, 22));
        int[] mwX = {158, 157, 832, 834};
        int[] mwY = {605, 261, 260, 430};
        g.fillPolygon(mwX, mwY, 4);

        // lower right section of building wall - this area isn't covered by the main polygon above
        // the main wall cuts off at y=430 on the right side, so we fill it in separately
        g.setColor(new Color(90, 50, 22));
        int[] lrwX = {564, 834, 834, 564};
        int[] lrwY = {430, 430, 605, 610};
        g.fillPolygon(lrwX, lrwY, 4);

        // left narrow side panel (x4/y4)
        g.setColor(new Color(70, 38, 15));
        int[] lpX = {154, 131, 143, 144, 131, 135, 154};
        int[] lpY = {293, 295, 311, 364, 364, 389, 388};
        g.fillPolygon(lpX, lpY, 7);

        // staircase enclosure (x9/y9)
        g.setColor(new Color(100, 58, 25));
        int[] seX = {423, 424, 566, 564};
        int[] seY = {729, 270, 270, 610};
        g.fillPolygon(seX, seY, 4);

        // lower staircase base (x8/y8)
        g.setColor(new Color(70, 40, 15));
        int[] sbX = {525, 472, 471, 525};
        int[] sbY = {606, 606, 745, 747};
        g.fillPolygon(sbX, sbY, 4);

        // roof main body (x1/y1)
        g.setColor(new Color(138, 27, 27));
        int[] roofX = {115, 493, 875, 864, 493, 122, 114};
        int[] roofY = {253, 70, 256, 266, 90, 265, 254};
        g.fillPolygon(roofX, roofY, 7);

        // roof front face, slightly lighter (x2/y2)
        g.setColor(new Color(155, 34, 34));
        int[] rfX = {158, 497, 831, 159};
        int[] rfY = {259, 101, 258, 260};
        g.fillPolygon(rfX, rfY, 4);

        // roof outline
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(62, 10, 10));
        g.drawPolygon(roofX, roofY, 7);

        // sign board white background
        g.setColor(Color.WHITE);
        g.fillRect(240, 264, 437, 52);
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
        g.drawRect(240, 264, 437, 52);
        g.drawLine(386, 264, 386, 316);
        g.drawLine(532, 264, 532, 316);

        // sign text - またずれ荘
        g.setFont(new Font("SansSerif", Font.BOLD, 34));
        g.drawString("\u307E\u305F", 258, 307);   // また
        g.drawString("\u305A\u308C", 402, 307);   // ずれ
        g.drawString("\u8358",       548, 307);   // 荘

        // left gable window, left pane (x13/y13 from Desmos)
        g.setColor(new Color(60, 70, 90));
        int[] w1X = {343, 342, 395, 395, 342};
        int[] w1Y = {205, 254, 254, 203, 204};
        g.fillPolygon(w1X, w1Y, 5);
        g2.setStroke(new BasicStroke(1));
        g.setColor(Color.BLACK);
        g.drawPolygon(w1X, w1Y, 5);

        // left gable window, right pane (added from image - Desmos only had half)
        g.setColor(new Color(60, 70, 90));
        g.fillRect(407, 203, 53, 51);
        g.setColor(Color.BLACK);
        g.drawRect(407, 203, 53, 51);

        // right gable window, left pane (added from image - not in Desmos at all)
        g.setColor(new Color(60, 70, 90));
        g.fillRect(529, 203, 53, 51);
        g.setColor(Color.BLACK);
        g.drawRect(529, 203, 53, 51);

        // right gable window, right pane
        g.setColor(new Color(60, 70, 90));
        g.fillRect(595, 203, 53, 51);
        g.setColor(Color.BLACK);
        g.drawRect(595, 203, 53, 51);

        // small door at top of stairs (x5/y5)
        g.setColor(new Color(165, 135, 65));
        int[] w2X = {365, 327, 327, 365, 365};
        int[] w2Y = {307, 307, 351, 351, 307};
        g.fillPolygon(w2X, w2Y, 5);
        g.setColor(new Color(88, 68, 28));
        g.drawPolygon(w2X, w2Y, 5);

        // lower left window (added from image)
        g.setColor(new Color(60, 70, 90));
        g.fillRect(225, 390, 65, 55);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        g.drawRect(225, 390, 65, 55);

        // lower right window (x20/y20 from Desmos)
        g.setColor(new Color(60, 70, 90));
        int[] w3X = {569, 642, 642, 571};
        int[] w3Y = {545, 546, 594, 594};
        g.fillPolygon(w3X, w3Y, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(w3X, w3Y, 4);

        // gray radiator/pipe panel on lower right - visible in the image
        g.setColor(new Color(105, 105, 115));
        g.fillRect(655, 435, 165, 160);
        g2.setStroke(new BasicStroke(1));
        g.setColor(new Color(72, 72, 82));
        for (int i = 0; i < 8; i++) {
            g.drawLine(655 + i * 21, 435, 655 + i * 21, 595);
        }

        // stair steps (x11/y11)
        g.setColor(new Color(118, 108, 98));
        int[] ssX = {448, 447, 540, 539};
        int[] ssY = {477, 287, 287, 397};
        g.fillPolygon(ssX, ssY, 4);
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(72, 68, 62));
        g.drawPolygon(ssX, ssY, 4);

        // step lines
        g2.setStroke(new BasicStroke(1));
        g.setColor(new Color(78, 73, 67));
        for (int i = 1; i < 9; i++) {
            int stepY = 287 + i * (477 - 287) / 9;
            g.drawLine(447, stepY, 540, stepY);
        }

        // stair landing (x18/y18)
        g.setColor(new Color(132, 122, 112));
        int[] landX = {451, 477, 530, 515};
        int[] landY = {252, 198, 225, 257};
        g.fillPolygon(landX, landY, 4);
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(82, 78, 72));
        g.drawPolygon(landX, landY, 4);

        // small railing post (x19/y19)
        g.setColor(new Color(115, 105, 95));
        int[] rpX = {539, 538, 560, 555, 566};
        int[] rpY = {212, 246, 214, 232, 247};
        g.fillPolygon(rpX, rpY, 5);

        // antenna pole
        g.setColor(new Color(42, 42, 42));
        g2.setStroke(new BasicStroke(2));
        g.drawLine(370, 72, 370, 215);

        // antenna arms (x26/y26)
        int[] antX = {367, 355, 374, 358, 376, 363, 356, 375};
        int[] antY = {212, 219, 217, 230, 228, 248, 240, 243};
        g.drawPolyline(antX, antY, 8);

        // antenna tip triangle (x27/y27)
        g2.setStroke(new BasicStroke(1));
        int[] atX = {408, 417, 415};
        int[] atY = {219, 211, 244};
        g.drawPolygon(atX, atY, 3);

        // building outline
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(38, 18, 6));
        g.drawPolygon(mwX, mwY, 4);

        // fence (x10/y10)
        g.setColor(new Color(198, 180, 102));
        int[] fenceX = {193, 249, 249, 270, 264, 289, 293, 317, 311,
                        333, 338, 358, 354, 377, 380, 403, 397, 420,
                        565, 565, 424};
        int[] fenceY = {602, 554, 606, 605, 544, 522, 595, 573, 504,
                        481, 553, 534, 463, 445, 513, 493, 428, 403,
                        401, 483, 484};
        g.fillPolygon(fenceX, fenceY, 21);
        g.setColor(new Color(145, 125, 65));
        g2.setStroke(new BasicStroke(1));
        g.drawPolygon(fenceX, fenceY, 21);

        // fence post (x22)
        g.setColor(new Color(172, 152, 86));
        g2.setStroke(new BasicStroke(3));
        g.drawLine(581, 619, 581, 727);

        // ground patch between fence and building (x12/y12)
        g.setColor(new Color(85, 118, 65));
        int[] gpX = {314, 419, 550};
        int[] gpY = {591, 500, 499};
        g.fillPolygon(gpX, gpY, 3);

        // right road (x7/y7)
        g.setColor(new Color(68, 68, 68));
        int[] rdX = {998, 526, 526, 999};
        int[] rdY = {613, 612, 747, 746};
        g.fillPolygon(rdX, rdY, 4);

        // horizon line (x21)
        g.setColor(new Color(48, 48, 48));
        g2.setStroke(new BasicStroke(2));
        g.drawLine(530, 645, 1001, 644);

        // left grass
        g.setColor(new Color(78, 118, 58));
        g.fillRect(0, 622, 530, 160);

        // left bushes
        g.setColor(new Color(45, 105, 40));
        g.fillOval(-18, 548, 98, 74);
        g.setColor(new Color(58, 120, 52));
        g.fillOval(15, 538, 75, 60);

        // right bushes
        g.setColor(new Color(45, 105, 40));
        g.fillOval(845, 555, 125, 78);
        g.setColor(new Color(58, 120, 52));
        g.fillOval(880, 545, 100, 62);
    }

    public static void main(String[] args) {
        houseBonus scene = new houseBonus();
        scene.setVisible(true);
    }
}