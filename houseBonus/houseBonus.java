/*
 * Date: May 13, 2026
 * Name: [Your Name Here]
 * Description: ICS4U Programming Assignment Part 4. 
 * Corrected line rendering for stairs, balcony, and Japanese text.
 * Written sequentially with NO helper methods.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class houseBonus extends JPanel {
    private JFrame mainFrame;

    public houseBonus() {
        mainFrame = new JFrame();
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
        int w = getWidth();
        int h = getHeight();

        // ==========================================
        // 1. SKY & CLOUDS
        // ==========================================
        g.setColor(new Color(60, 130, 190));
        g.fillRect(0, 0, w, h);

        // Fixed Left Cloud (Using Ovals instead of polygons)
        g.setColor(Color.WHITE);
        g.fillOval(30, 80, 80, 40);
        g.fillOval(60, 60, 90, 50);
        
        // Right Clouds
        g.fillOval(760, 25, 130, 45); 
        g.fillOval(820, 15, 90, 55);  

        // ==========================================
        // 2. BACKGROUND HOUSES ("BLUE STUFF")
        // ==========================================
        // Left Background House
        g.setColor(new Color(180, 200, 220)); 
        int[] bgLeftBodyX = {0, 132, 132, 0}; 
        int[] bgLeftBodyY = {380, 380, 600, 600};
        g.fillPolygon(bgLeftBodyX, bgLeftBodyY, 4);

        g.setColor(new Color(60, 100, 150)); // Left BG Window
        g.fillRect(30, 400, 25, 45);

        g.setColor(new Color(20, 60, 110)); // Left BG Roof
        int[] bgLeftRoofX = {0, 140, 100, 0};
        int[] bgLeftRoofY = {380, 380, 340, 340};
        g.fillPolygon(bgLeftRoofX, bgLeftRoofY, 4);

        // Right Background House 
        g.setColor(new Color(180, 200, 220)); 
        g.fillRect(841, 352, 160, 260); 

        g.setColor(new Color(20, 60, 110)); // Right BG Roof
        int[] bgRightRoofX = {841, 1000, 1000, 880};
        int[] bgRightRoofY = {352, 352, 320, 320};
        g.fillPolygon(bgRightRoofX, bgRightRoofY, 4);

        // ==========================================
        // 3. MAIN HOUSE BODY
        // ==========================================
        g.setColor(new Color(110, 60, 70)); 
        int[] houseBodyX = {159, 831, 831, 159};
        int[] houseBodyY = {260, 260, 715, 715};
        g.fillPolygon(houseBodyX, houseBodyY, 4);
        
        // Vertical Wood Lines
        g.setColor(new Color(70, 30, 40)); 
        g2.setStroke(new BasicStroke(1));
        for (int i = 169; i < 831; i += 32) {
            g.drawLine(i, 260, i, 715);
        }
        
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(houseBodyX, houseBodyY, 4);

        // Concrete Foundation Base
        g.setColor(new Color(150, 160, 170));
        g.fillRect(159, 680, 672, 35);
        g.setColor(Color.BLACK);
        g.drawRect(159, 680, 672, 35);

        // ==========================================
        // 4. MAIN ROOF
        // ==========================================
        // Red Roof Trim
        g.setColor(new Color(180, 40, 40)); 
        int[] redX = {100, 495, 890, 880, 495, 110};
        int[] redY = {255, 60, 258, 269, 80, 267};
        g.fillPolygon(redX, redY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(redX, redY, 6);

        // Grey Roof Outer 
        g.setColor(new Color(150, 160, 170)); 
        int[] greyX = {115, 495, 875, 865, 495, 122};
        int[] greyY = {253, 70, 256, 267, 90, 265};
        g.fillPolygon(greyX, greyY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(greyX, greyY, 6);

        // Inner Grey Peak 
        g.setColor(new Color(180, 190, 200)); 
        int[] innerX = {159, 495, 831};
        int[] innerY = {259, 102, 258};
        g.fillPolygon(innerX, innerY, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(innerX, innerY, 3);

        // Roof Vent
        g2.setStroke(new BasicStroke(3));
        g.drawLine(480, 130, 510, 130);
        g.drawLine(480, 145, 510, 145);
        g.drawLine(490, 120, 490, 155);
        g.drawLine(500, 120, 500, 155);
        
        // Antenna
        g2.setStroke(new BasicStroke(2));
        g.drawLine(278, 168, 278, 113); // Main pole
        g.drawLine(278, 113, 212, 121); // Left branch
        g.drawLine(212, 121, 254, 91);  // Left fork
        g.drawLine(278, 113, 322, 116); // Right branch
        g.drawLine(322, 116, 262, 110); // Right fork

        // ==========================================
        // 5. SIGNBOARD & JAPANESE TEXT (Cleaned up)
        // ==========================================
        g.setColor(Color.WHITE);
        g.fillRect(315, 195, 360, 65);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g.drawRect(315, 195, 360, 65);
        
        // Tile 1
        g.setColor(Color.WHITE); g.fillRect(325, 203, 48, 48);
        g.setColor(Color.BLACK); g.drawRect(325, 203, 48, 48);
        g.drawLine(335, 220, 365, 220); 
        g.drawLine(340, 210, 340, 240); 
        g.drawOval(350, 225, 10, 10);

        // Tile 2
        g.setColor(Color.WHITE); g.fillRect(385, 203, 48, 48);
        g.setColor(Color.BLACK); g.drawRect(385, 203, 48, 48);
        g.drawLine(405, 210, 405, 240); 
        g.drawOval(415, 215, 12, 12);

        // Tile 3 (Crooked Tile)
        g.setColor(Color.WHITE);
        int[] crookedX = {452, 477, 530, 515};
        int[] crookedY = {253, 198, 225, 257};
        g.fillPolygon(crookedX, crookedY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(crookedX, crookedY, 4);
        g.drawLine(470, 230, 490, 210); 
        g.drawOval(495, 225, 12, 12);

        // Tile 4
        g.setColor(Color.WHITE); g.fillRect(545, 203, 48, 48);
        g.setColor(Color.BLACK); g.drawRect(545, 203, 48, 48);
        g.drawLine(560, 210, 560, 240); 
        g.drawLine(560, 225, 580, 215);

        // Tile 5
        g.setColor(Color.WHITE); g.fillRect(605, 203, 48, 48);
        g.setColor(Color.BLACK); g.drawRect(605, 203, 48, 48);
        g.drawLine(615, 215, 635, 215); 
        g.drawLine(625, 210, 625, 235);

        // ==========================================
        // 6. WINDOWS
        // ==========================================
        g2.setStroke(new BasicStroke(3));
        
        // Left Window
        g.setColor(new Color(40, 140, 160)); 
        g.fillRect(328, 307, 37, 44);
        g.setColor(Color.BLACK);
        g.drawRect(328, 307, 37, 44);
        g.drawLine(346, 307, 346, 351); 

        // Right Window 
        g.setColor(new Color(40, 140, 160)); 
        g.fillRect(620, 307, 37, 44);
        g.setColor(Color.BLACK);
        g.drawRect(620, 307, 37, 44);
        g.drawLine(638, 307, 638, 351); 

        // ==========================================
        // 7. DOORS & AC UNIT
        // ==========================================
        // Top Floor Door 
        g.setColor(new Color(20, 30, 50)); 
        g.fillRect(447, 287, 93, 114);
        g.setColor(Color.BLACK);
        g.drawRect(447, 287, 93, 114);

        // Bottom Floor Door (Fixed black triangle issue)
        g.setColor(new Color(20, 30, 50)); 
        g.fillRect(447, 560, 93, 120);
        g.setColor(Color.BLACK);
        g.drawRect(447, 560, 93, 120);

        // AC Unit 
        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(569, 545, 73, 50);
        g.setColor(Color.BLACK);
        g.drawRect(569, 545, 73, 50);
        g2.setStroke(new BasicStroke(2));
        for(int i = 575; i < 635; i += 8) g.drawLine(i, 545, i, 594); 

        // ==========================================
        // 8. BALCONY & STAIRS (Fixed with proper lines)
        // ==========================================
        // Balcony Support Posts 
        g.setColor(new Color(110, 130, 150));
        g.fillRect(440, 421, 8, 259);
        g.fillRect(540, 421, 8, 259);
        g.setColor(Color.BLACK);
        g.drawRect(440, 421, 8, 259);
        g.drawRect(540, 421, 8, 259);

        // Balcony Floor
        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(420, 401, 145, 20);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(420, 401, 145, 20);

        // Balcony Railings 
        g.drawLine(420, 350, 565, 350); // Top rail
        for (int i = 425; i <= 560; i += 15) {
            g.drawLine(i, 350, i, 401); // Vertical spindles
        }

        // Stairs Diagonal Base (Filled grey, no weird boxes)
        g.setColor(new Color(140, 150, 160)); 
        int[] stairBaseX = {160, 420, 420, 160};
        int[] stairBaseY = {660, 400, 421, 681};
        g.fillPolygon(stairBaseX, stairBaseY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(stairBaseX, stairBaseY, 4);

        // Stairs Railings
        g2.setStroke(new BasicStroke(4));
        g.drawLine(160, 600, 420, 340); // Top diagonal handrail
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i <= 10; i++) {
            int currentX = 160 + (i * 26);
            int topY = 600 - (i * 26); 
            int bottomY = 660 - (i * 26); 
            g.drawLine(currentX, topY, currentX, bottomY); // Vertical spindles
        }

        // ==========================================
        // 9. BUSHES / TREES 
        // ==========================================
        // Left Bush
        g.setColor(new Color(30, 130, 50)); 
        int[] leftBushX = {0, 15, 45, 75, 80, 0};
        int[] leftBushY = {600, 540, 550, 570, 600, 600}; 
        g.fillPolygon(leftBushX, leftBushY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(leftBushX, leftBushY, 6);
        
        // Right Tree 
        g.setColor(new Color(30, 130, 50));
        int[] rightTreeX = {781, 760, 775, 820, 825, 896, 973, 1000, 1000, 783};
        int[] rightTreeY = {611, 560, 468, 476, 438, 421, 426, 455, 611, 611};
        g.fillPolygon(rightTreeX, rightTreeY, 10);
        g.setColor(Color.BLACK);
        g.drawPolygon(rightTreeX, rightTreeY, 10);

        // ==========================================
        // 10. FRONT WALL FENCES (Cleaned up right bounds)
        // ==========================================
        g.setColor(new Color(245, 230, 180)); 
        g.fillRect(0, 612, 273, 135);     // Left Wall
        g.fillRect(526, 612, 474, 135);   // Right Wall
        
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        // Horizontal brick lines
        for (int y = 612; y <= 747; y += 35) {
            g.drawLine(0, y, 273, y);
            g.drawLine(526, y, 1000, y);
        }
        
        // Vertical staggered brick lines
        for (int y = 612; y < 747; y += 35) {
            int offset = (y == 612 || y == 682) ? 35 : 0;
            
            // Left Wall Vertical Bricks
            for (int x = 0; x <= 273; x += 70) {
                if (x + offset <= 273) g.drawLine(x + offset, y, x + offset, y + 35);
            }
            
            // Right Wall Vertical Bricks
            for (int x = 526; x <= 1000; x += 70) {
                if (x + offset <= 1000) g.drawLine(x + offset, y, x + offset, y + 35);
            }
        }

        // ==========================================
        // 11. GATE PILLARS 
        // ==========================================
        // Left Pillar 
        g.setColor(new Color(130, 140, 150)); 
        g.fillRect(273, 607, 54, 140);
        g.setColor(Color.BLACK); 
        g.drawRect(273, 607, 54, 140);
        
        g.setColor(new Color(160, 170, 180)); 
        g.fillRect(263, 597, 74, 10); // Left Cap
        g.setColor(Color.BLACK); 
        g.drawRect(263, 597, 74, 10);

        // Right Pillar 
        g.setColor(new Color(130, 140, 150)); 
        g.fillRect(471, 607, 54, 140);
        g.setColor(Color.BLACK); 
        g.drawRect(471, 607, 54, 140);
        
        g.setColor(new Color(160, 170, 180)); 
        g.fillRect(461, 597, 74, 10); // Right Cap
        g.setColor(Color.BLACK); 
        g.drawRect(461, 597, 74, 10);

        // Nameplate
        g.setColor(new Color(150, 130, 60)); 
        g.fillRect(485, 650, 27, 45);
        g.setColor(Color.BLACK);
        g.drawRect(485, 650, 27, 45);
        
        // Base ground line
        g.drawLine(0, 747, 1000, 747); 
    }

    public static void main(String[] args) {
        houseBonus x = new houseBonus();
    }
}