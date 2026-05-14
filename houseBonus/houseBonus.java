// you need the statements below to be able to run graphics
import java.awt.Color;
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
        // sets up screen
        mainFrame.setSize(1000, 750);
        mainFrame.setLocation(50, 50);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Matazure Sou - Shinchan");
        this.setLocation(0, 0);
        mainFrame.getContentPane().add(this);
        mainFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; // needed for outline
        Graphics2D g2d = (Graphics2D) g; // needed for gradient
        int w = getWidth(); // gets the width of the window
        int h = getHeight(); // gets the height of the window

        // sky gradient
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(40, 110, 180),
                0, h / 2, new Color(135, 206, 235));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        // left cloud from desmos
        g.setColor(Color.white);
        int cloudX [] = {110, 35, 90, 165, 192, 169, 153, 114};
        int cloudY [] = {95, 125, 170, 167, 155, 131, 126, 93};
        g.fillPolygon(cloudX, cloudY, 8);
        
        // right clouds
        g.fillOval(760, 25, 130, 45); 
        g.fillOval(820, 15, 90, 55);  

        // left background house
        g.setColor(new Color(180, 200, 220)); 
        int bgLeftBodyX [] = {14, 15, 170, 170, 14};
        int bgLeftBodyY [] = {615, 379, 380, 615, 615};
        g.fillPolygon(bgLeftBodyX, bgLeftBodyY, 5);

        // left background window
        g.setColor(new Color(60, 100, 150)); 
        int bgLeftWinX [] = {36, 57, 58, 36, 36};
        int bgLeftWinY [] = {395, 395, 441, 440, 396};
        g.fillPolygon(bgLeftWinX, bgLeftWinY, 5);

        // left background roof
        g.setColor(new Color(20, 60, 110)); 
        int bgLeftRoofX [] = {170, 14, 47, 170, 170};
        int bgLeftRoofY [] = {377, 376, 333, 332, 377};
        g.fillPolygon(bgLeftRoofX, bgLeftRoofY, 5);

        // right background house
        g.setColor(new Color(180, 200, 220)); 
        g.fillRect(820, 352, 180, 263); 

        // right background roof
        g.setColor(new Color(20, 60, 110)); 
        int bgRightRoofX [] = {820, 959, 998, 1001, 820, 820};
        int bgRightRoofY [] = {352, 351, 370, 400, 403, 352};
        g.fillPolygon(bgRightRoofX, bgRightRoofY, 6);

        // main house body
        g.setColor(new Color(110, 60, 70)); 
        int houseBodyX [] = {159, 831, 831, 159};
        int houseBodyY [] = {260, 260, 715, 715};
        g.fillPolygon(houseBodyX, houseBodyY, 4);
        
        // vertical wood lines drawn manually (ZERO LOOPS)
        g.setColor(new Color(70, 30, 40)); 
        g2.setStroke(new BasicStroke(1));
        g.drawLine(169, 260, 169, 715);
        g.drawLine(201, 260, 201, 715);
        g.drawLine(233, 260, 233, 715);
        g.drawLine(265, 260, 265, 715);
        g.drawLine(297, 260, 297, 715);
        g.drawLine(329, 260, 329, 715);
        g.drawLine(361, 260, 361, 715);
        g.drawLine(393, 260, 393, 715);
        g.drawLine(425, 260, 425, 715);
        g.drawLine(457, 260, 457, 715);
        g.drawLine(489, 260, 489, 715);
        g.drawLine(521, 260, 521, 715);
        g.drawLine(553, 260, 553, 715);
        g.drawLine(585, 260, 585, 715);
        g.drawLine(617, 260, 617, 715);
        g.drawLine(649, 260, 649, 715);
        g.drawLine(681, 260, 681, 715);
        g.drawLine(713, 260, 713, 715);
        g.drawLine(745, 260, 745, 715);
        g.drawLine(777, 260, 777, 715);
        g.drawLine(809, 260, 809, 715);
        
        // outline
        g.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(houseBodyX, houseBodyY, 4);
        
        int innerBodyX [] = {158, 830, 830, 158};
        int innerBodyY [] = {259, 259, 714, 714};
        g.drawPolygon(innerBodyX, innerBodyY, 4);

        // foundation
        g.setColor(new Color(150, 160, 170));
        g.fillRect(159, 680, 672, 35);
        g.setColor(Color.black);
        g.drawRect(159, 680, 672, 35);

        // red roof trim
        g.setColor(new Color(180, 40, 40)); 
        int redX [] = {100, 495, 890, 880, 495, 110};
        int redY [] = {255, 60, 258, 269, 80, 267};
        g.fillPolygon(redX, redY, 6);
        g.setColor(Color.black);
        g.drawPolygon(redX, redY, 6);

        // grey roof outer
        g.setColor(new Color(150, 160, 170)); 
        int greyX [] = {115, 493, 875, 865, 494, 122, 115};
        int greyY [] = {253, 70, 256, 267, 90, 265, 254};
        g.fillPolygon(greyX, greyY, 7);
        g.setColor(Color.black);
        g.drawPolygon(greyX, greyY, 7);

        // inner grey peak
        g.setColor(new Color(180, 190, 200)); 
        int innerX [] = {159, 497, 831, 159};
        int innerY [] = {259, 102, 258, 260};
        g.fillPolygon(innerX, innerY, 4);
        g.setColor(Color.black);
        g.drawPolygon(innerX, innerY, 4);

        // roof vent
        g.drawLine(480, 130, 510, 130);
        g.drawLine(480, 145, 510, 145);
        g.drawLine(490, 120, 490, 155);
        g.drawLine(500, 120, 500, 155);
        
        // antenna from desmos
        g2.setStroke(new BasicStroke(2));
        int antX [] = {277, 278, 254, 212, 262, 322};
        int antY [] = {168, 113, 91, 121, 110, 116};
        g.drawLine(antX[0], antY[0], antX[1], antY[1]); 
        g.drawLine(antX[1], antY[1], antX[3], antY[3]); 
        g.drawLine(antX[3], antY[3], antX[2], antY[2]);  
        g.drawLine(antX[1], antY[1], antX[5], antY[5]); 
        g.drawLine(antX[5], antY[5], antX[4], antY[4]); 

        // signboard base
        g.setColor(Color.white);
        g.fillRect(315, 195, 360, 65);
        g.setColor(Color.black);
        g.drawRect(315, 195, 360, 65);
        
        // tile 1
        g.setColor(Color.white);
        int tile1X [] = {343, 342, 395, 395, 343};
        int tile1Y [] = {205, 255, 254, 203, 204};
        g.fillPolygon(tile1X, tile1Y, 5);
        g.setColor(Color.black);
        g.drawPolygon(tile1X, tile1Y, 5);
        g.drawLine(355, 220, 355, 240);
        g.drawOval(360, 225, 10, 10);
        g.drawLine(375, 220, 385, 220);
        
        // tile 2
        g.setColor(Color.white); 
        g.fillRect(400, 203, 48, 48);
        g.setColor(Color.black); 
        g.drawRect(400, 203, 48, 48);
        int text2X [] = {408, 418, 415};
        int text2Y [] = {219, 211, 244};
        g.drawPolyline(text2X, text2Y, 3);
        g.drawOval(425, 220, 10, 8);

        // tile 3 crooked
        g.setColor(Color.white);
        int crookedX [] = {452, 477, 530, 515};
        int crookedY [] = {253, 198, 225, 257};
        g.fillPolygon(crookedX, crookedY, 4);
        g.setColor(Color.black);
        g.drawPolygon(crookedX, crookedY, 4);
        g.drawLine(470, 230, 490, 210); 
        g.drawOval(495, 225, 12, 12);

        // tile 4
        g.setColor(Color.white); 
        g.fillRect(530, 203, 48, 48);
        g.setColor(Color.black); 
        g.drawRect(530, 203, 48, 48);
        int text4X [] = {539, 538, 561, 555, 566};
        int text4Y [] = {212, 247, 215, 233, 248};
        g.drawPolyline(text4X, text4Y, 5);

        // tile 5
        g.setColor(Color.white); 
        g.fillRect(590, 203, 48, 48);
        g.setColor(Color.black); 
        g.drawRect(590, 203, 48, 48);
        int text5X [] = {602, 590, 609, 593, 611, 598, 591, 611};
        int text5Y [] = {212, 219, 217, 230, 228, 248, 240, 243};
        g.drawPolyline(text5X, text5Y, 8);

        // left window
        g.setColor(new Color(40, 140, 160)); 
        int winLeftX [] = {365, 328, 328, 365};
        int winLeftY [] = {307, 307, 351, 351};
        g.fillPolygon(winLeftX, winLeftY, 4);
        g.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(winLeftX, winLeftY, 4);
        g.drawLine(346, 307, 346, 351); 

        // right window
        g.setColor(new Color(40, 140, 160)); 
        g.fillRect(620, 307, 37, 44);
        g.setColor(Color.black);
        g.drawRect(620, 307, 37, 44);
        g.drawLine(638, 307, 638, 351); 

        // top door from desmos
        g.setColor(new Color(20, 30, 50)); 
        int topDoorX [] = {448, 447, 540, 539};
        int topDoorY [] = {401, 288, 287, 401}; 
        g.fillPolygon(topDoorX, topDoorY, 4);
        g.setColor(Color.black);
        g.drawPolygon(topDoorX, topDoorY, 4);

        // bottom floor door RESTORED 
        g.setColor(new Color(20, 30, 50)); 
        g.fillRect(447, 560, 93, 120);
        g.setColor(Color.black);
        g.drawRect(447, 560, 93, 120);

        // ac unit
        g.setColor(new Color(110, 140, 170)); 
        int acX [] = {569, 642, 642, 572};
        int acY [] = {545, 546, 594, 595};
        g.fillPolygon(acX, acY, 4);
        g.setColor(Color.black);
        g.drawPolygon(acX, acY, 4);
        g2.setStroke(new BasicStroke(2));
        
        // manually drawn AC vents (ZERO LOOPS)
        g.drawLine(575, 545, 575, 594);
        g.drawLine(583, 545, 583, 594);
        g.drawLine(591, 545, 591, 594);
        g.drawLine(599, 545, 599, 594);
        g.drawLine(607, 545, 607, 594);
        g.drawLine(615, 545, 615, 594);
        g.drawLine(623, 545, 623, 594);
        g.drawLine(631, 545, 631, 594);

        // balcony support posts
        g.setColor(new Color(110, 130, 150));
        g.fillRect(440, 421, 8, 259);
        g.fillRect(540, 421, 8, 259);
        g.setColor(Color.black);
        g.drawRect(440, 421, 8, 259);
        g.drawRect(540, 421, 8, 259);

        // balcony floor
        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(420, 401, 145, 20);
        g.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(420, 401, 145, 20);

        // balcony railings drawn manually (ZERO LOOPS)
        g.drawLine(420, 350, 565, 350); 
        g.drawLine(425, 350, 425, 401);
        g.drawLine(440, 350, 440, 401);
        g.drawLine(455, 350, 455, 401);
        g.drawLine(470, 350, 470, 401);
        g.drawLine(485, 350, 485, 401);
        g.drawLine(500, 350, 500, 401);
        g.drawLine(515, 350, 515, 401);
        g.drawLine(530, 350, 530, 401);
        g.drawLine(545, 350, 545, 401);
        g.drawLine(560, 350, 560, 401);

        // stairs base body 
        g.setColor(new Color(140, 150, 160)); 
        int stairBaseX [] = {160, 420, 420, 160};
        int stairBaseY [] = {660, 400, 421, 681}; 
        g.fillPolygon(stairBaseX, stairBaseY, 4);
        g.setColor(Color.black);
        g.drawPolygon(stairBaseX, stairBaseY, 4);

        // manually drawn stairs handrail and vertical posts (ZERO LOOPS)
        g2.setStroke(new BasicStroke(4));
        g.drawLine(160, 600, 420, 340); // Top rail
        
        g2.setStroke(new BasicStroke(2));
        g.drawLine(160, 610, 420, 350); // Parallel bottom rail 
        
        // Spindles perfectly connecting top and bottom rails
        g.drawLine(160, 600, 160, 660);
        g.drawLine(186, 574, 186, 634);
        g.drawLine(212, 548, 212, 608);
        g.drawLine(238, 522, 238, 582);
        g.drawLine(264, 496, 264, 556);
        g.drawLine(290, 470, 290, 530);
        g.drawLine(316, 444, 316, 504);
        g.drawLine(342, 418, 342, 478);
        g.drawLine(368, 392, 368, 452);
        g.drawLine(394, 366, 394, 426);
        g.drawLine(420, 340, 420, 400);

        // left bush
        g.setColor(new Color(30, 130, 50)); 
        int leftBushX [] = {4, 38, 68, 71, 0, 0};
        int leftBushY [] = {534, 541, 561, 600, 600, 534}; 
        g.fillPolygon(leftBushX, leftBushY, 6);
        g.setColor(Color.black);
        g.drawPolygon(leftBushX, leftBushY, 6);
        
        // right tree
        g.setColor(new Color(30, 130, 50));
        int rightTreeX [] = {781, 758, 771, 776, 819, 824, 896, 973, 999, 984, 998, 999, 783};
        int rightTreeY [] = {611, 560, 527, 468, 476, 438, 421, 426, 455, 517, 551, 610, 611};
        g.fillPolygon(rightTreeX, rightTreeY, 13);
        g.setColor(Color.black);
        g.drawPolygon(rightTreeX, rightTreeY, 13);

        // left fence wall base
        g.setColor(new Color(245, 230, 180)); 
        g.fillRect(0, 612, 273, 135);     
        g.setColor(Color.black);
        g.drawRect(0, 612, 273, 135);
        
        // right fence body 
        g.setColor(new Color(245, 230, 180)); 
        int fenceRightX [] = {998, 526, 526, 999};
        int fenceRightY [] = {613, 612, 747, 746};
        g.fillPolygon(fenceRightX, fenceRightY, 4);
        g.setColor(Color.black);
        g.drawPolygon(fenceRightX, fenceRightY, 4);

        // manually drawn inner fence horizontal lines (Removed overlapping top/bottom borders)
        g.drawLine(0, 646, 273, 646);
        g.drawLine(0, 680, 273, 680);
        g.drawLine(0, 714, 273, 714);
        
        g.drawLine(526, 646, 1000, 646);
        g.drawLine(526, 680, 1000, 680);
        g.drawLine(526, 714, 1000, 714);

        // manually drawn inner fence vertical lines left wall (ZERO LOOPS)
        g.drawLine(55, 612, 55, 747);
        g.drawLine(110, 612, 110, 747);
        g.drawLine(165, 612, 165, 747);
        g.drawLine(220, 612, 220, 747);

        // manually drawn inner fence vertical lines right wall (ZERO LOOPS)
        g.drawLine(582, 612, 582, 747);
        g.drawLine(638, 612, 638, 747);
        g.drawLine(694, 612, 694, 747);
        g.drawLine(750, 612, 750, 747);
        g.drawLine(806, 612, 806, 747);
        g.drawLine(862, 612, 862, 747);
        g.drawLine(918, 612, 918, 747);
        g.drawLine(974, 612, 974, 747);

        // right gate pillar
        g.setColor(new Color(130, 140, 150)); 
        int pillarRightX [] = {525, 472, 471, 526};
        int pillarRightY [] = {607, 607, 745, 747};
        g.fillPolygon(pillarRightX, pillarRightY, 4);
        g.setColor(Color.black); 
        g.drawPolygon(pillarRightX, pillarRightY, 4);
        
        g.setColor(new Color(160, 170, 180)); 
        g.fillRect(461, 597, 74, 10); 
        g.setColor(Color.black); 
        g.drawRect(461, 597, 74, 10);

        // left gate pillar
        g.setColor(new Color(130, 140, 150)); 
        g.fillRect(273, 607, 54, 140);
        g.setColor(Color.black); 
        g.drawRect(273, 607, 54, 140);
        
        g.setColor(new Color(160, 170, 180)); 
        g.fillRect(263, 597, 74, 10); 
        g.setColor(Color.black); 
        g.drawRect(263, 597, 74, 10);

        // pillar nameplate
        g.setColor(new Color(150, 130, 60)); 
        g.fillRect(485, 650, 27, 45);
        g.setColor(Color.black);
        g.drawRect(485, 650, 27, 45);
        
        // ground line
        g.drawLine(0, 747, 1000, 747); 
    }

    public static void main(String[] args) {
        houseBonus x = new houseBonus();
        x.setVisible(true);
    }
}