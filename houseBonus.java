/*
 * Date:        May 8, 2026
 * Name:        Nasrin
 * Description: Draws the Matazore-so apartment building from the anime
 *              Crayon Shin-chan. The scene includes the main 2-storey
 *              building, red gable roof, sign board, windows, exterior
 *              staircase, decorative brick fence, flanking background
 *              buildings, green bushes, white clouds, and a TV antenna.
 *              All polygon coordinates were traced in Desmos and converted
 *              to Java panel coordinates via tx() and ty() helper methods.
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class houseBonus extends JPanel {

    private JFrame mainFrame;

    /* Constructor: creates and configures the JFrame window. */
    houseBonus() {
        mainFrame = new JFrame();
        mainFrame.setSize(1010, 750);                              // window size
        mainFrame.setLocation(50, 50);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Matazore-so — Crayon Shin-chan");
        this.setLocation(0, 0);
        mainFrame.getContentPane().add(this);
        mainFrame.setVisible(true);
    }

    /*
     * tx: converts a Desmos x-coordinate to a Java panel x-coordinate.
     * The x-axis is shared 1:1 (Desmos x-range 0..1001 maps to panel).
     */
    private static int tx(double dx) {
        return (int) Math.round(dx);
    }

    /*
     * ty: converts a Desmos y-coordinate (negative values, origin top-right)
     * to a Java panel y-coordinate (origin top-left, positive downward).
     * Offset 70 places the topmost cloud region at panel y = 0.
     */
    private static int ty(double dy) {
        return (int) Math.round(-dy - 70);
    }

    /* px: builds a Java x-array from a list of Desmos x-values. */
    private static int[] px(double... vals) {
        int[] a = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            a[i] = tx(vals[i]);
        }
        return a;
    }

    /* py: builds a Java y-array from a list of Desmos y-values. */
    private static int[] py(double... vals) {
        int[] a = new int[vals.length];
        for (int i = 0; i < vals.length; i++) {
            a[i] = ty(vals[i]);
        }
        return a;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        /* Enable anti-aliasing for smoother edges. */
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        /* ================================================================
         * LAYER 1: Sky gradient background (light blue top to pale blue bottom)
         * ================================================================ */
        GradientPaint sky = new GradientPaint(
                0, 0,    new Color(140, 210, 238),
                0, h,    new Color(190, 230, 245));
        g2.setPaint(sky);
        g2.fillRect(0, 0, w, h);

        /* ================================================================
         * LAYER 2: Ground / road area beneath the fence (warm gray-brown)
         * ================================================================ */
        g.setColor(new Color(160, 148, 130));
        g.fillRect(0, ty(-620), w, h - ty(-620));    // fills from fence bottom down

        /* ================================================================
         * LAYER 3: Far-right small background building (x17, pale gray-green)
         * ================================================================ */
        g.setColor(new Color(205, 215, 204));
        g.fillPolygon(
                px(855.5, 961, 1000, 1000, 837.5),
                py(-353,  -350, -368, -400.6, -402),
                5);

        /* ================================================================
         * LAYER 4: Right background building silhouette (x6, bluish-gray)
         * Irregular outline of a building behind the main structure.
         * ================================================================ */
        g.setColor(new Color(180, 198, 193));
        g.fillPolygon(
                px(781,   757.5, 771,  776,    819.3, 824,
                   896.4, 972.8, 998.6, 984.2, 999,   999.3),
                py(-611, -560,  -527, -468,   -475.6, -438,
                   -421, -426.3, -455.4, -517, -530,  -610),
                12);

        /* Right ground slab that forms the floor in front of x6 (x7). */
        g.setColor(new Color(185, 172, 152));
        g.fillPolygon(
                px(998, 526, 526, 999),
                py(-613, -612, -747, -746),
                4);

        /* ================================================================
         * LAYER 5: Left white apartment building
         * Three parts: lower body (x15), upper section (x16), base slope (x14)
         * ================================================================ */

        /* Lower triangular body of the left building (x15). */
        g.setColor(new Color(245, 245, 240));
        g.fillPolygon(
                px(14.3, 14.6, 131.2),
                py(-526.4, -378, -379),
                3);

        /* Upper rectangular section of the left building (x16). */
        g.setColor(new Color(245, 245, 240));
        g.fillPolygon(
                px(131.7, 14.2, 46,   140.4),
                py(-376.8, -375.6, -332.3, -333),
                4);

        /* Lower slope connecting the left building to the ground (x14). */
        g.setColor(new Color(220, 213, 200));
        g.fillPolygon(
                px(4,    37.7, 67.5, 71),
                py(-534, -540.5, -561.2, -600),
                4);

        /* Small window on the left building (x23, dark blue-gray rectangle). */
        g.setColor(new Color(110, 140, 170));
        g.fillPolygon(
                px(36.2, 56.8, 58,    36.3,  35.6),
                py(-394.9, -395, -441, -440.4, -395.7),
                5);

        /* ================================================================
         * LAYER 6: Main building body (x3, dark maroon/brown)
         * This quadrilateral covers the entire front wall of the building.
         * The bottom-right is raised because the staircase covers that corner.
         * ================================================================ */
        g.setColor(new Color(105, 50, 40));
        g.fillPolygon(
                px(158,  157,   832.3, 834.7),
                py(-605, -261.6, -260.7, -430.3),
                4);

        /* ================================================================
         * LAYER 7: Staircase tower (x9, slightly darker maroon rectangle)
         * The right-side external staircase column from top to bottom.
         * ================================================================ */
        g.setColor(new Color(95, 45, 36));
        g.fillPolygon(
                px(423,  424,   566.6, 564),
                py(-729, -270, -270.6, -610),
                4);

        /* Staircase base section at ground level (x8, darkest shade). */
        g.setColor(new Color(82, 40, 32));
        g.fillPolygon(
                px(525,   472.4, 471,  525.6),
                py(-606.6, -606.5, -745, -747),
                4);

        /* ================================================================
         * LAYER 8: Staircase details
         * ================================================================ */

        /* Tall balcony/railing panel running along the staircase (x11). */
        g.setColor(new Color(125, 62, 50));
        g.fillPolygon(
                px(448,  447,    540,   539.4),
                py(-477, -287.5, -287, -397.8),
                4);

        /* Mini roof / cover over the staircase landing (x12, deep red triangle). */
        g.setColor(new Color(162, 28, 28));
        g.fillPolygon(
                px(314,  419.5, 550),
                py(-591, -500,  -499),
                3);

        /* Upper staircase landing platform (x18). */
        g.setColor(new Color(115, 55, 43));
        g.fillPolygon(
                px(451.7, 477,  530.2, 515),
                py(-252.8, -198, -225, -257),
                4);

        /* Small cap at the top of the staircase railing (x19, 5 points). */
        g.setColor(new Color(95, 48, 37));
        g.fillPolygon(
                px(539,    538,    560.5,  555,    566),
                py(-212.3, -246.6, -214.6, -232.6, -247.7),
                5);

        /* Small left-side landing step or protrusion (x4, 7 points). */
        g.setColor(new Color(88, 44, 34));
        g.fillPolygon(
                px(154.8, 131,  143.3, 144.5,  131.5,  135.3,  154.2),
                py(-293.1, -295, -311, -364, -364.1, -389.8, -388.4),
                7);

        /* ================================================================
         * LAYER 9: Gable face (x2, light gray/off-white triangle)
         * The flat front face of the roof, visible as the light-colored
         * triangular section above the main building walls.
         * ================================================================ */
        g.setColor(new Color(210, 208, 202));
        g.fillPolygon(
                px(158.6, 497,   831.2, 159),
                py(-259.2, -101.6, -258, -260),
                4);

        /* ================================================================
         * LAYER 10: Roof outline, red sloped edges
         * Two thick red lines for the visible tiled roof slopes.
         * ================================================================ */
        g2.setStroke(new BasicStroke(7, BasicStroke.CAP_ROUND,
                                        BasicStroke.JOIN_ROUND));
        g.setColor(new Color(178, 28, 28));
        g.drawLine(tx(158.6), ty(-259.2), tx(497),   ty(-101.6));  // left slope
        g.drawLine(tx(497),   ty(-101.6), tx(831.2), ty(-258));     // right slope
        /* Eave line along the base of the gable. */
        g.drawLine(tx(158.6), ty(-258), tx(831.2), ty(-258));
        g2.setStroke(new BasicStroke(1));

        /* Small triangular accent near the gable peak (x1 / x27). */
        g.setColor(new Color(162, 28, 28));
        g.fillPolygon(
                px(408.4, 417.5, 415),
                py(-219,  -211,  -244),
                3);

        /* ================================================================
         * LAYER 11: TV antenna (manual, placed at the roof peak)
         * Vertical mast with two horizontal crossbars.
         * ================================================================ */
        g2.setStroke(new BasicStroke(2));
        g.setColor(Color.DARK_GRAY);
        g.drawLine(tx(497), ty(-101), tx(497), ty(-145));           // vertical mast
        g.drawLine(tx(478), ty(-120), tx(516), ty(-120));           // lower crossbar
        g.drawLine(tx(483), ty(-132), tx(511), ty(-132));           // upper crossbar
        g2.setStroke(new BasicStroke(1));

        /* Well-mark character (a decorative # on the gable, visible in the image). */
        g.setColor(new Color(60, 60, 60));
        g.setFont(new Font("SansSerif", Font.BOLD, 16));
        g.drawString("#", tx(490), ty(-155));

        /* ================================================================
         * LAYER 12: Sign board "またぞれ荘" on the gable face
         * White rectangle with a thin border and the building name.
         * ================================================================ */
        int signX = tx(258);
        int signY = ty(-232);
        int signW = 500;
        int signH = 38;

        g.setColor(new Color(252, 250, 245));       // off-white background
        g.fillRect(signX, signY, signW, signH);

        g2.setStroke(new BasicStroke(1.5f));
        g.setColor(new Color(50, 50, 50));          // thin dark border
        g.drawRect(signX, signY, signW, signH);
        g2.setStroke(new BasicStroke(1));

        /* Sign text: "またぞれ荘". Uses Dialog font for broad Unicode support. */
        g.setFont(new Font("Dialog", Font.BOLD, 24));
        g.setColor(new Color(25, 25, 25));
        g.drawString("\u307e\u305f\u305e\u308c\u8358", signX + 95, signY + 27);

        /* ================================================================
         * LAYER 13: Windows (filled dark blue then outlined with brown frame)
         * ================================================================ */

        /* Upper-floor left window (x5, rectangle). */
        g.setColor(new Color(78, 108, 142));
        g.fillPolygon(
                px(365, 327.6, 327.7, 365),
                py(-307, -307.4, -351, -351),
                4);
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(170, 135, 90));        // brown wooden frame
        g.drawPolygon(
                px(365, 327.6, 327.7, 365),
                py(-307, -307.4, -351, -351),
                4);
        g2.setStroke(new BasicStroke(1));

        /* Upper-floor right window near staircase (x13, rectangle). */
        g.setColor(new Color(78, 108, 142));
        g.fillPolygon(
                px(343,  342,    395,  395,   342.6),
                py(-205, -254.5, -254, -203, -204.3),
                5);
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(170, 135, 90));
        g.drawPolygon(
                px(343,  342,    395,  395,   342.6),
                py(-205, -254.5, -254, -203, -204.3),
                5);
        g2.setStroke(new BasicStroke(1));

        /* Ground-floor right window (x20, rectangle). */
        g.setColor(new Color(78, 108, 142));
        g.fillPolygon(
                px(569,    642.3, 642,    571.5),
                py(-545.3, -546, -594,   -594.8),
                4);
        g2.setStroke(new BasicStroke(2));
        g.setColor(new Color(170, 135, 90));
        g.drawPolygon(
                px(569,    642.3, 642,    571.5),
                py(-545.3, -546, -594,   -594.8),
                4);
        g2.setStroke(new BasicStroke(1));

        /* ================================================================
         * LAYER 14: Decorative brick fence (x10)
         * A 21-point zigzag polygon giving the impression of stacked bricks.
         * ================================================================ */
        g.setColor(new Color(212, 196, 155));
        g.fillPolygon(
                px(193.3, 249.6, 249.7, 270,   264,   289,   293,
                   317.6, 311.5, 333.5, 338.2, 358.4, 354.5, 377,
                   380,   403,   397.3, 420,   565,   565,   424),
                py(-602,  -554.7, -606.3, -605.4, -544.3, -522.7, -595.2,
                   -573.6, -504.4, -481, -553, -534.7, -463, -445.2,
                   -513.4, -493.6, -428, -403, -401, -483.3, -484.3),
                21);

        /* ================================================================
         * LAYER 15: Green bushes / shrubs on the right side of the building
         * Drawn as overlapping ovals to approximate the round bush shapes.
         * ================================================================ */
        g.setColor(new Color(30, 95, 28));          // dark forest green base
        g.fillOval(tx(610), ty(-525), 95, 85);      // left bush
        g.fillOval(tx(695), ty(-515), 105, 90);     // right bush
        g.setColor(new Color(45, 120, 38));          // lighter highlight layer
        g.fillOval(tx(622), ty(-508), 60, 52);
        g.fillOval(tx(710), ty(-498), 68, 58);

        /* ================================================================
         * LAYER 16: Ground line on right side (x21, subtle horizontal rule)
         * ================================================================ */
        g.setColor(new Color(95, 80, 62));
        g2.setStroke(new BasicStroke(2));
        g.drawLine(tx(530), ty(-645), tx(1001), ty(-644));
        g2.setStroke(new BasicStroke(1));

        /* Fence post vertical line on the right (x22). */
        g.setColor(new Color(125, 110, 88));
        g2.setStroke(new BasicStroke(2));
        g.drawLine(tx(581.6), ty(-619.5), tx(581), ty(-727.5));
        g2.setStroke(new BasicStroke(1));

        /* ================================================================
         * LAYER 17: Clouds (drawn last so they appear in front of everything)
         * ================================================================ */

        /* Left cloud (x25, 8-point polygon). */
        g.setColor(Color.WHITE);
        g.fillPolygon(
                px(110,   34.5, 90,   165,   192,   168.5, 152.5, 114),
                py(-95,  -125, -170, -167,  -155,  -131.4, -125.7, -93.4),
                8);

        /* Right cloud (x24, 6-point polygon). */
        g.setColor(Color.WHITE);
        g.fillPolygon(
                px(277,  278,  254,  212,    261.7, 321.5),
                py(-168, -113, -91, -121.3, -110,  -116),
                6);
    }

    public static void main(String[] args) {
        houseBonus x = new houseBonus();
        x.setVisible(true);
    }
}