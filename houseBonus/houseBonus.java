/*
 * Date: May 11, 2026
 * Name: [Your Name Here]
 * Description: ICS4U Programming Assignment Part 4. 
 * This program draws a highly accurate landscape of "Matazure Sou" (The Falling Apartments) 
 * from Crayon Shinchan based on reference images. It features exact details including 
 * the red roof trim, slanted background roofs, two-pane windows with awnings, standalone 
 * staircase structure, balcony support pillars, the crooked signboard, and block walls.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class houseBonus extends JPanel {
    private JFrame mainFrame;

    public houseBonus() {
        mainFrame = new JFrame();
        // Sets up screen - Scaled to perfectly fit the blueprint bounds
        mainFrame.setSize(1050, 750);
        mainFrame.setLocation(50, 50);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Matazure Sou - Shinchan");
        this.setLocation(0, 0);
        mainFrame.getContentPane().add(this);
        mainFrame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; // needed for outline strokes
        Graphics2D g2d = (Graphics2D) g; // needed for gradient
        int w = getWidth();
        int h = getHeight();

        // ==========================================
        // 1. SKY WITH GRADIENT
        // ==========================================
        GradientPaint gp = new GradientPaint(
            0, 0, new Color(40, 110, 180), // Deep blue top
            0, h/2, new Color(135, 206, 235) // Light blue horizon
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        // ==========================================
        // 2. CLOUDS
        // ==========================================
        g.setColor(Color.WHITE);
        // Left cloud
        g.fillOval(80, 80, 90, 40);
        g.fillOval(120, 60, 70, 50);
        // Right cloud 
        g.fillOval(750, 30, 120, 40);
        g.fillOval(800, 10, 80, 50);

        // ==========================================
        // 3. BACKGROUND HOUSES (With Slanted Roofs)
        // ==========================================
        // Left Background Building
        g.setColor(new Color(180, 200, 220)); // Light blue-grey base
        g.fillRect(0, 350, 130, 250);
        g.setColor(new Color(60, 100, 150)); // Windows
        g.fillRect(20, 390, 25, 40);
        g.fillRect(70, 390, 25, 40);
        // Left Building Slanted Roof
        g.setColor(new Color(20, 60, 110)); // Dark Blue Roof
        int[] bgLeftRoofX = {0, 130, 90, 0};
        int[] bgLeftRoofY = {350, 350, 310, 310};
        g.fillPolygon(bgLeftRoofX, bgLeftRoofY, 4);

        // Right Background Building
        g.setColor(new Color(180, 200, 220));
        g.fillRect(860, 360, 190, 240);
        // Right Building Slanted Roof
        g.setColor(new Color(20, 60, 110)); 
        int[] bgRightRoofX = {860, 1050, 1050, 900};
        int[] bgRightRoofY = {360, 360, 320, 320};
        g.fillPolygon(bgRightRoofX, bgRightRoofY, 4);

        // ==========================================
        // 4. MAIN HOUSE BODY (Wood Base)
        // ==========================================
        g.setColor(new Color(110, 60, 70)); // Purplish dark wood
        int[] houseX = {158, 832, 832, 158};
        int[] houseY = {261, 261, 605, 605}; 
        g.fillPolygon(houseX, houseY, 4);
        
        // Wood Plank Vertical Lines
        g.setColor(new Color(70, 30, 40)); 
        g2.setStroke(new BasicStroke(1));
        for (int i = 170; i < 830; i += 30) {
            g.drawLine(i, 261, i, 605);
        }
        
        // House Base Outline
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(houseX, houseY, 4);

        // ==========================================
        // 5. MAIN ROOF (Red Trim + Grey Layers)
        // ==========================================
        // 5A. Red Roof Trim (The thick red border underneath)
        g.setColor(new Color(180, 40, 40)); // Dark Red
        int[] redX = {100, 495, 890, 880, 495, 110};
        int[] redY = {260, 60, 260, 275, 85, 275};
        g.fillPolygon(redX, redY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(redX, redY, 6);

        // 5B. Grey Outer Roof (Sits inside the red trim)
        g.setColor(new Color(150, 160, 170)); // Grey/Blue
        int[] greyX = {115, 495, 875, 865, 495, 125};
        int[] greyY = {257, 70, 257, 267, 92, 267};
        g.fillPolygon(greyX, greyY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(greyX, greyY, 6);

        // 5C. Main Inner Grey Peak
        g.setColor(new Color(180, 190, 200)); 
        int[] innerX = {160, 495, 830}; 
        int[] innerY = {260, 102, 260};
        g.fillPolygon(innerX, innerY, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(innerX, innerY, 3);

        // ==========================================
        // 6. ROOF DETAILS (# Vent & Antenna)
        // ==========================================
        g2.setStroke(new BasicStroke(3));
        // # Symbol
        g.drawLine(480, 130, 510, 130);
        g.drawLine(480, 145, 510, 145);
        g.drawLine(490, 120, 490, 155);
        g.drawLine(500, 120, 500, 155);

        // Antenna
        g2.setStroke(new BasicStroke(2));
        g.drawLine(250, 180, 250, 100); 
        g.drawLine(210, 130, 290, 130);  
        g.drawLine(210, 130, 230, 110);  
        g.drawLine(290, 130, 270, 110);  

        // ==========================================
        // 7. SIGN BOARD
        // ==========================================
        g.setColor(Color.WHITE);
        g.fillRect(320, 210, 340, 55);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g.drawRect(320, 210, 340, 55);
        
        // 5 Character Tiles (Middle one crooked)
        g.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue; // Skip middle
            int boxX = 330 + (i * 65);
            g.fillRect(boxX, 215, 50, 45);
            g.setColor(Color.BLACK);
            g.drawRect(boxX, 215, 50, 45);
            g.setColor(Color.WHITE);
        }
        
        // Crooked Middle Tile
        g.setColor(Color.WHITE);
        int[] crookedX = {455, 515, 505, 445};
        int[] crookedY = {205, 215, 260, 250};
        g.fillPolygon(crookedX, crookedY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(crookedX, crookedY, 4);

        // ==========================================
        // 8. TWO WINDOWS (2 Panes + Awnings)
        // ==========================================
        // Left Window
        g.setColor(new Color(40, 70, 110)); // Dark blue awning
        int[] leftAwningX = {310, 385, 375, 320};
        int[] leftAwningY = {305, 305, 295, 295};
        g.fillPolygon(leftAwningX, leftAwningY, 4);
        
        g.setColor(new Color(40, 140, 160)); // Cyan glass
        g.fillRect(315, 305, 60, 45);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(315, 305, 60, 45);
        g.drawLine(345, 305, 345, 350); // Vertical Divider (2 squares)

        // Right Window
        g.setColor(new Color(40, 70, 110)); // Dark blue awning
        int[] rightAwningX = {610, 685, 675, 620};
        int[] rightAwningY = {305, 305, 295, 295};
        g.fillPolygon(rightAwningX, rightAwningY, 4);

        g.setColor(new Color(40, 140, 160)); // Cyan glass
        g.fillRect(615, 305, 60, 45);
        g.setColor(Color.BLACK);
        g.drawRect(615, 305, 60, 45);
        g.drawLine(645, 305, 645, 350); // Vertical Divider (2 squares)

        // ==========================================
        // 9. DOORS & BALCONY STRUCTURE
        // ==========================================
        // 2nd Floor Door Inner Void
        g.setColor(new Color(20, 30, 50)); 
        g.fillRect(455, 280, 80, 120);
        g.setColor(Color.BLACK);
        g.drawRect(455, 280, 80, 120);

        // 1st Floor Door Inner Void
        g.setColor(new Color(20, 30, 50));
        g.fillRect(455, 440, 80, 120);
        g.setColor(Color.BLACK);
        g.drawRect(455, 440, 80, 120);

        // 1st Floor Wall Vent/AC Unit
        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(560, 490, 55, 50);
        g.setColor(Color.BLACK);
        g.drawRect(560, 490, 55, 50);
        g2.setStroke(new BasicStroke(2));
        for(int i = 565; i < 610; i += 7) g.drawLine(i, 490, i, 540);

        // Balcony Support Pillars (Going down to ground)
        g.setColor(new Color(110, 130, 150));
        g.fillRect(440, 425, 8, 180);
        g.fillRect(542, 425, 8, 180);
        g.setColor(Color.BLACK);
        g.drawRect(440, 425, 8, 180);
        g.drawRect(542, 425, 8, 180);

        // Balcony Platform
        g.setColor(new Color(110, 140, 170)); // Blueish grey
        g.fillRect(435, 400, 120, 25);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(435, 400, 120, 25);
        
        // Balcony Railings
        g.drawLine(435, 350, 555, 350); // Top horizontal rail
        for (int i = 440; i <= 550; i += 15) {
            g.drawLine(i, 350, i, 400); // Vertical balusters
        }

        // ==========================================
        // 10. DETACHED DIAGONAL STAIRS
        // ==========================================
        // The structural stringer/beam
        g.setColor(new Color(140, 150, 160)); // Grey metal
        int[] stairX = {150, 435, 435, 150};
        int[] stairY = {570, 400, 430, 600}; 
        g.fillPolygon(stairX, stairY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(stairX, stairY, 4);

        // Stair Railing Structure
        g2.setStroke(new BasicStroke(4));
        g.drawLine(150, 520, 435, 350); // Main handrail going up
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i <= 12; i++) {
            int rx = 150 + (i * 23);
            int ryTop = 520 - (i * 14); // Point on handrail
            int ryBot = 570 - (i * 14); // Point on stringer
            g.drawLine(rx, ryTop, rx, ryBot); 
        }

        // ==========================================
        // 11. BUSHES / VEGETATION
        // ==========================================
        g.setColor(new Color(30, 130, 50)); // Dark green
        // Left Bush
        g.fillOval(30, 520, 80, 80);
        g.setColor(Color.BLACK);
        g.drawOval(30, 520, 80, 80);
        
        // Right Bushes
        g.setColor(new Color(30, 130, 50));
        g.fillOval(740, 450, 180, 160); // Main large puff
        g.fillOval(860, 480, 120, 130); // Right edge puff
        g.fillOval(720, 530, 100, 80);  // Bottom left puff
        g.setColor(Color.BLACK);
        g.drawOval(740, 450, 180, 160);
        g.drawOval(860, 480, 120, 130);
        g.drawOval(720, 530, 100, 80);

        // ==========================================
        // 12. FRONT WALL / BLOCKS & GATE
        // ==========================================
        g.setColor(new Color(245, 230, 180)); // Pale yellow bricks
        g.fillRect(0, 600, 300, 120); // Left wall
        g.fillRect(550, 600, 500, 120); // Right wall

        // Wall Block Grid Lines
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        // Horizontals
        for (int y = 600; y <= 720; y += 40) {
            g.drawLine(0, y, 300, y);
            g.drawLine(550, y, 1050, y);
        }
        // Verticals (staggered for brick pattern)
        for (int y = 600; y < 720; y += 40) {
            int offset = (y % 80 == 0) ? 0 : 40;
            for (int x = 0; x < 300; x += 80) g.drawLine(x + offset, y, x + offset, y + 40);
            for (int x = 550; x < 1050; x += 80) g.drawLine(x + offset, y, x + offset, y + 40);
        }

        // Gate Pillars
        g.setColor(new Color(130, 140, 150)); // Grey pillars
        g.fillRect(260, 560, 60, 160);
        g.fillRect(520, 560, 60, 160);
        g.setColor(Color.BLACK);
        g.drawRect(260, 560, 60, 160);
        g.drawRect(520, 560, 60, 160);
        
        // Gate Pillar Caps
        g.setColor(new Color(160, 170, 180));
        g.fillRect(250, 550, 80, 10);
        g.fillRect(510, 550, 80, 10);
        g.setColor(Color.BLACK);
        g.drawRect(250, 550, 80, 10);
        g.drawRect(510, 550, 80, 10);

        // Nameplate on Right Pillar
        g.setColor(new Color(150, 130, 60)); // Gold/Bronze
        g.fillRect(535, 610, 30, 50);
        g.setColor(Color.BLACK);
        g.drawRect(535, 610, 30, 50);
        
        // Final Street/Ground Line
        g.drawLine(0, 715, 1050, 715);
    }

    public static void main(String[] args) {
        houseBonus x = new houseBonus();
    }
}