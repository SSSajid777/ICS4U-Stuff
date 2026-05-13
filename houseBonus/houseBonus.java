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
        //sets up screen
        mainFrame.setSize(1000, 750);
        mainFrame.setLocation(50, 50);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Matazure Sou - Shinchan");
        this.setLocation(0, 0);
        mainFrame.getContentPane().add(this);
        mainFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        // sky gradient
        GradientPaint gp = new GradientPaint(
                0, 0, new Color(40, 110, 180),
                0, h / 2, new Color(135, 206, 235));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        // left cloud from desmos
        g.setColor(Color.WHITE);
        int[] cloudX = {110, 35, 90, 165, 192, 169, 153, 114};
        int[] cloudY = {95, 125, 170, 167, 155, 131, 126, 93};
        g.fillPolygon(cloudX, cloudY, 8);
        
        // right clouds
        g.fillOval(760, 25, 130, 45); 
        g.fillOval(820, 15, 90, 55);  

        // left background house
        g.setColor(new Color(180, 200, 220)); 
        int[] bgLeftBodyX = {14, 15, 132, 132, 14};
        int[] bgLeftBodyY = {526, 379, 380, 526, 526};
        g.fillPolygon(bgLeftBodyX, bgLeftBodyY, 5);

        // left background window
        g.setColor(new Color(60, 100, 150)); 
        int[] bgLeftWinX = {36, 57, 58, 36, 36};
        int[] bgLeftWinY = {395, 395, 441, 440, 396};
        g.fillPolygon(bgLeftWinX, bgLeftWinY, 5);

        // left background roof
        g.setColor(new Color(20, 60, 110)); 
        int[] bgLeftRoofX = {132, 14, 47, 150, 133};
        int[] bgLeftRoofY = {377, 376, 333, 332, 376};
        g.fillPolygon(bgLeftRoofX, bgLeftRoofY, 5);

        // right background house
        g.setColor(new Color(180, 200, 220)); 
        g.fillRect(841, 352, 160, 260); 

        // right background roof
        g.setColor(new Color(20, 60, 110)); 
        int[] bgRightRoofX = {841, 959, 998, 1001, 835, 842};
        int[] bgRightRoofY = {352, 351, 370, 400, 403, 352};
        g.fillPolygon(bgRightRoofX, bgRightRoofY, 6);

        // main house body
        g.setColor(new Color(110, 60, 70)); 
        int[] houseBodyX = {159, 831, 831, 159};
        int[] houseBodyY = {260, 260, 715, 715};
        g.fillPolygon(houseBodyX, houseBodyY, 4);
        
        // vertical wood lines
        g.setColor(new Color(70, 30, 40)); 
        g2.setStroke(new BasicStroke(1));
        for (int i = 169; i < 831; i += 32) {
            g.drawLine(i, 260, i, 715);
        }
        
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(houseBodyX, houseBodyY, 4);

        // foundation
        g.setColor(new Color(150, 160, 170));
        g.fillRect(159, 680, 672, 35);
        g.setColor(Color.BLACK);
        g.drawRect(159, 680, 672, 35);

        // red roof trim
        g.setColor(new Color(180, 40, 40)); 
        int[] redX = {100, 495, 890, 880, 495, 110};
        int[] redY = {255, 60, 258, 269, 80, 267};
        g.fillPolygon(redX, redY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(redX, redY, 6);

        // grey roof outer
        g.setColor(new Color(150, 160, 170)); 
        int[] greyX = {115, 493, 875, 865, 494, 122, 115};
        int[] greyY = {253, 70, 256, 267, 90, 265, 254};
        g.fillPolygon(greyX, greyY, 7);
        g.setColor(Color.BLACK);
        g.drawPolygon(greyX, greyY, 7);

        // inner grey peak
        g.setColor(new Color(180, 190, 200)); 
        int[] innerX = {159, 497, 831, 159};
        int[] innerY = {259, 102, 258, 260};
        g.fillPolygon(innerX, innerY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(innerX, innerY, 4);

        // roof vent
        g.drawLine(480, 130, 510, 130);
        g.drawLine(480, 145, 510, 145);
        g.drawLine(490, 120, 490, 155);
        g.drawLine(500, 120, 500, 155);
        
        // antenna
        g2.setStroke(new BasicStroke(2));
        int[] antX = {277, 278, 254, 212, 262, 322};
        int[] antY = {168, 113, 91, 121, 110, 116};
        g.drawLine(antX[0], antY[0], antX[1], antY[1]); 
        g.drawLine(antX[1], antY[1], antX[3], antY[3]); 
        g.drawLine(antX[3], antY[3], antX[2], antY[2]);  
        g.drawLine(antX[1], antY[1], antX[5], antY[5]); 
        g.drawLine(antX[5], antY[5], antX[4], antY[4]); 

        // signboard base
        g.setColor(Color.WHITE);
        g.fillRect(315, 195, 360, 65);
        g.setColor(Color.BLACK);
        g.drawRect(315, 195, 360, 65);
        
        // tile 1
        g.setColor(Color.WHITE);
        int[] tile1X = {343, 342, 395, 395, 343};
        int[] tile1Y = {205, 255, 254, 203, 204};
        g.fillPolygon(tile1X, tile1Y, 5);
        g.setColor(Color.BLACK);
        g.drawPolygon(tile1X, tile1Y, 5);
        g.drawLine(355, 220, 355, 240);
        g.drawOval(360, 225, 10, 10);
        g.drawLine(375, 220, 385, 220);
        
        // tile 2
        g.setColor(Color.WHITE); 
        g.fillRect(400, 203, 48, 48);
        g.setColor(Color.BLACK); 
        g.drawRect(400, 203, 48, 48);
        int[] text2X = {408, 418, 415};
        int[] text2Y = {219, 211, 244};
        g.drawPolyline(text2X, text2Y, 3);
        g.drawOval(425, 220, 10, 8);

        // tile 3 crooked
        g.setColor(Color.WHITE);
        int[] crookedX = {452, 477, 530, 515};
        int[] crookedY = {253, 198, 225, 257};
        g.fillPolygon(crookedX, crookedY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(crookedX, crookedY, 4);
        g.drawLine(470, 230, 490, 210); 
        g.drawOval(495, 225, 12, 12);

        // tile 4
        g.setColor(Color.WHITE); 
        g.fillRect(530, 203, 48, 48);
        g.setColor(Color.BLACK); 
        g.drawRect(530, 203, 48, 48);
        int[] text4X = {539, 538, 561, 555, 566};
        int[] text4Y = {212, 247, 215, 233, 248};
        g.drawPolyline(text4X, text4Y, 5);

        // tile 5 shifted from left
        g.setColor(Color.WHITE); 
        g.fillRect(590, 203, 48, 48);
        g.setColor(Color.BLACK); 
        g.drawRect(590, 203, 48, 48);
        int[] text5X = {367, 355, 374, 358, 376, 363, 356, 376};
        int[] text5Y = {212, 219, 217, 230, 228, 248, 240, 243};
        for(int i = 0; i < text5X.length; i++) text5X[i] += 235; 
        g.drawPolyline(text5X, text5Y, 8);

        // left window
        g.setColor(new Color(40, 140, 160)); 
        int[] winLeftX = {365, 328, 328, 365};
        int[] winLeftY = {307, 307, 351, 351};
        g.fillPolygon(winLeftX, winLeftY, 4);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(winLeftX, winLeftY, 4);
        g.drawLine(346, 307, 346, 351); 

        // right window duplicated bounds
        g.setColor(new Color(40, 140, 160)); 
        g.fillRect(620, 307, 37, 44);
        g.setColor(Color.BLACK);
        g.drawRect(620, 307, 37, 44);
        g.drawLine(638, 307, 638, 351); 

        // top floor door
        g.setColor(new Color(20, 30, 50)); 
        int[] topDoorX = {448, 447, 540, 539};
        int[] topDoorY = {477, 288, 287, 398};
        g.fillPolygon(topDoorX, topDoorY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(topDoorX, topDoorY, 4);

        // bottom floor door
        g.setColor(new Color(20, 30, 50)); 
        g.fillRect(447, 560, 93, 120);
        g.setColor(Color.BLACK);
        g.drawRect(447, 560, 93, 120);

        // ac unit
        g.setColor(new Color(110, 140, 170)); 
        int[] acX = {569, 642, 642, 572};
        int[] acY = {545, 546, 594, 595};
        g.fillPolygon(acX, acY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(acX, acY, 4);
        g2.setStroke(new BasicStroke(2));
        for(int i = 575; i < 635; i += 8) {
            g.drawLine(i, 545, i, 594); 
        }

        // balcony support posts
        g.setColor(new Color(110, 130, 150));
        g.fillRect(440, 421, 8, 259);
        g.fillRect(540, 421, 8, 259);
        g.setColor(Color.BLACK);
        g.drawRect(440, 421, 8, 259);
        g.drawRect(540, 421, 8, 259);

        // balcony floor
        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(420, 401, 145, 20);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(420, 401, 145, 20);

        // balcony railings
        g.drawLine(420, 350, 565, 350); 
        for (int i = 425; i <= 560; i += 15) {
            g.drawLine(i, 350, i, 401); 
        }

        // stairs base body
        g.setColor(new Color(140, 150, 160)); 
        int[] stairBaseX = {160, 420, 420, 160};
        int[] stairBaseY = {660, 400, 421, 681};
        g.fillPolygon(stairBaseX, stairBaseY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(stairBaseX, stairBaseY, 4);

        // stairs handrail and vertical posts
        g2.setStroke(new BasicStroke(4));
        g.drawLine(160, 600, 420, 340); 
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i <= 10; i++) {
            int currentX = 160 + (i * 26);
            int topY = 600 - (i * 26); 
            int bottomY = 660 - (i * 26); 
            g.drawLine(currentX, topY, currentX, bottomY); 
        }

        // left bush
        g.setColor(new Color(30, 130, 50)); 
        int[] leftBushX = {4, 38, 68, 71, 0, 0};
        int[] leftBushY = {534, 541, 561, 600, 600, 534}; 
        g.fillPolygon(leftBushX, leftBushY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(leftBushX, leftBushY, 6);
        
        // right tree
        g.setColor(new Color(30, 130, 50));
        int[] rightTreeX = {781, 758, 771, 776, 819, 824, 896, 973, 999, 984, 998, 999, 783};
        int[] rightTreeY = {611, 560, 527, 468, 476, 438, 421, 426, 455, 517, 551, 610, 611};
        g.fillPolygon(rightTreeX, rightTreeY, 13);
        g.setColor(Color.BLACK);
        g.drawPolygon(rightTreeX, rightTreeY, 13);

        // front wall fences
        g.setColor(new Color(245, 230, 180)); 
        g.fillRect(0, 612, 273, 135);     
        
        int[] fenceRightX = {998, 526, 526, 999};
        int[] fenceRightY = {613, 612, 747, 746};
        g.fillPolygon(fenceRightX, fenceRightY, 4);
        
        g.setColor(Color.BLACK);

        // fence horizontal lines
        for (int y = 612; y <= 747; y += 35) {
            g.drawLine(0, y, 273, y);
            g.drawLine(526, y, 1000, y);
        }
        
        // fence vertical bricks
        for (int y = 612; y < 747; y += 35) {
            int offset = (y == 612 || y == 682) ? 35 : 0;
            
            for (int x = 0; x <= 273; x += 70) {
                if (x + offset <= 273) g.drawLine(x + offset, y, x + offset, y + 35);
            }
            
            for (int x = 526; x <= 1000; x += 70) {
                if (x + offset <= 1000) g.drawLine(x + offset, y, x + offset, y + 35);
            }
        }

        // right gate pillar
        g.setColor(new Color(130, 140, 150)); 
        int[] pillarRightX = {525, 472, 471, 526};
        int[] pillarRightY = {607, 607, 745, 747};
        g.fillPolygon(pillarRightX, pillarRightY, 4);
        g.setColor(Color.BLACK); 
        g.drawPolygon(pillarRightX, pillarRightY, 4);
        
        g.setColor(new Color(160, 170, 180)); 
        g.fillRect(461, 597, 74, 10); 
        g.setColor(Color.BLACK); 
        g.drawRect(461, 597, 74, 10);

        // left gate pillar
        g.setColor(new Color(130, 140, 150)); 
        g.fillRect(273, 607, 54, 140);
        g.setColor(Color.BLACK); 
        g.drawRect(273, 607, 54, 140);
        
        g.setColor(new Color(160, 170, 180)); 
        g.fillRect(263, 597, 74, 10); 
        g.setColor(Color.BLACK); 
        g.drawRect(263, 597, 74, 10);

        // pillar nameplate
        g.setColor(new Color(150, 130, 60)); 
        g.fillRect(485, 650, 27, 45);
        g.setColor(Color.BLACK);
        g.drawRect(485, 650, 27, 45);
        
        // ground line
        g.drawLine(0, 747, 1000, 747); 
    }

    public static void main(String[] args) {
        houseBonus x = new houseBonus();
        x.setVisible(true);
    }
}