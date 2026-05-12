// Date: May 11, 2026
// Name: [Your Name Here]
// Description: ICS4U Programming Assignment Part 4. 

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
        mainFrame.setSize(1050, 750);
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

        // sky
        GradientPaint gp = new GradientPaint(
            0, 0, new Color(40, 110, 180), 
            0, h/2, new Color(135, 206, 235)
        );
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);

        // clouds
        g.setColor(Color.WHITE);
        g.fillOval(70, 70, 100, 45);
        g.fillOval(120, 50, 80, 55);
        g.fillOval(760, 25, 130, 45);
        g.fillOval(820, 15, 90, 55);

        // background left
        g.setColor(new Color(180, 200, 220)); 
        g.fillRect(0, 360, 180, 250); 
        g.setColor(new Color(60, 100, 150)); 
        g.fillRect(30, 400, 25, 40);
        g.fillRect(80, 400, 25, 40);
        
        g.setColor(new Color(20, 60, 110)); 
        int[] bgLeftRoofX = {0, 180, 130, 0};
        int[] bgLeftRoofY = {360, 360, 330, 330};
        g.fillPolygon(bgLeftRoofX, bgLeftRoofY, 4);

        // background right
        g.setColor(new Color(180, 200, 220));
        g.fillRect(800, 370, 250, 240); 
        
        g.setColor(new Color(20, 60, 110)); 
        int[] bgRightRoofX = {800, 1050, 1050, 840};
        int[] bgRightRoofY = {370, 370, 340, 340};
        g.fillPolygon(bgRightRoofX, bgRightRoofY, 4);

        // house base
        g.setColor(new Color(110, 60, 70)); 
        int[] houseX = {180, 800, 800, 180};
        int[] houseY = {260, 260, 715, 715}; 
        g.fillPolygon(houseX, houseY, 4);
        
        g.setColor(new Color(70, 30, 40)); 
        g2.setStroke(new BasicStroke(1));
        for (int i = 180; i < 800; i += 31) {
            g.drawLine(i, 260, i, 715);
        }
        
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawPolygon(houseX, houseY, 4);

        // foundation
        g.setColor(new Color(150, 160, 170));
        g.fillRect(180, 680, 620, 35);
        g.setColor(Color.BLACK);
        g.drawRect(180, 680, 620, 35);

        // red roof
        g.setColor(new Color(180, 40, 40)); 
        int[] redX = {110, 490, 870, 860, 490, 120};
        int[] redY = {260, 60, 260, 275, 85, 275};
        g.fillPolygon(redX, redY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(redX, redY, 6);

        // grey roof
        g.setColor(new Color(150, 160, 170)); 
        int[] greyX = {125, 490, 855, 845, 490, 135};
        int[] greyY = {258, 70, 258, 267, 92, 267};
        g.fillPolygon(greyX, greyY, 6);
        g.setColor(Color.BLACK);
        g.drawPolygon(greyX, greyY, 6);

        // inner peak
        g.setColor(new Color(180, 190, 200)); 
        int[] innerX = {180, 490, 800}; 
        int[] innerY = {260, 110, 260};
        g.fillPolygon(innerX, innerY, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(innerX, innerY, 3);

        // roof vent
        g2.setStroke(new BasicStroke(3));
        g.drawLine(475, 130, 505, 130);
        g.drawLine(475, 145, 505, 145);
        g.drawLine(485, 120, 485, 155);
        g.drawLine(495, 120, 495, 155);

        // antenna
        g2.setStroke(new BasicStroke(2));
        g.drawLine(250, 180, 250, 95); 
        g.drawLine(210, 125, 290, 125);  
        g.drawLine(210, 125, 230, 105);  
        g.drawLine(290, 125, 270, 105);  

        // signboard
        g.setColor(Color.WHITE);
        g.fillRect(320, 215, 340, 50);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g.drawRect(320, 215, 340, 50);
        
        g.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue; 
            int boxX = 325 + (i * 66);
            g.fillRect(boxX, 220, 45, 40);
            g.setColor(Color.BLACK);
            g.drawRect(boxX, 220, 45, 40);
            g.setColor(Color.WHITE);
        }
        
        // crooked tile
        g.setColor(Color.WHITE);
        int[] crookedX = {460, 510, 500, 450};
        int[] crookedY = {210, 220, 260, 250};
        g.fillPolygon(crookedX, crookedY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(crookedX, crookedY, 4);

        // japanese text
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3)); 
        g.drawLine(335, 230, 360, 230); 
        g.drawLine(335, 240, 360, 240); 
        g.drawLine(347, 225, 347, 250); 
        g.drawOval(340, 245, 12, 8);   
        g.drawLine(400, 230, 415, 230); 
        g.drawLine(405, 225, 410, 250); 
        g.drawLine(420, 235, 430, 235); 
        g.drawLine(420, 245, 430, 245); 
        g.drawLine(465, 225, 495, 230); 
        g.drawLine(490, 227, 475, 250); 
        g.drawOval(475, 245, 12, 8);   
        g.drawLine(495, 220, 500, 225); 
        g.drawLine(500, 218, 505, 223); 
        g.drawLine(535, 230, 535, 250); 
        g.drawLine(545, 230, 545, 245); 
        g.drawLine(545, 245, 555, 240); 
        g.drawLine(555, 240, 545, 260); 
        g.drawLine(545, 260, 560, 250); 
        g.drawLine(600, 227, 625, 227); 
        g.drawLine(610, 223, 610, 231); 
        g.drawLine(620, 223, 620, 231); 
        g.drawLine(605, 240, 605, 255); 
        g.drawLine(605, 240, 615, 240); 
        g.drawLine(605, 250, 615, 250); 
        g.drawLine(625, 235, 625, 255); 
        g.drawLine(618, 245, 632, 245); 
        g2.setStroke(new BasicStroke(2)); 

        // left window
        g.setColor(new Color(40, 140, 160)); 
        g.fillRect(320, 310, 60, 45);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(320, 310, 60, 45);
        g.drawLine(350, 310, 350, 355); 

        // right window
        g.setColor(new Color(40, 140, 160)); 
        g.fillRect(600, 310, 60, 45);
        g.setColor(Color.BLACK);
        g.drawRect(600, 310, 60, 45);
        g.drawLine(630, 310, 630, 355); 

        // doors
        g.setColor(new Color(20, 30, 50)); 
        g.fillRect(460, 280, 60, 120);
        g.setColor(Color.BLACK);
        g.drawRect(460, 280, 60, 120);

        g.setColor(new Color(20, 30, 50));
        g.fillRect(460, 560, 60, 120);
        g.setColor(Color.BLACK);
        g.drawRect(460, 560, 60, 120);

        // ac unit
        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(560, 540, 40, 40);
        g.setColor(Color.BLACK);
        g.drawRect(560, 540, 40, 40);
        g2.setStroke(new BasicStroke(2));
        for(int i = 565; i < 595; i += 7) g.drawLine(i, 540, i, 580);

        // balcony
        g.setColor(new Color(110, 130, 150));
        g.fillRect(445, 430, 8, 250);
        g.fillRect(525, 430, 8, 250);
        g.setColor(Color.BLACK);
        g.drawRect(445, 430, 8, 250);
        g.drawRect(525, 430, 8, 250);

        g.setColor(new Color(110, 140, 170)); 
        g.fillRect(420, 400, 140, 30);
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g.drawRect(420, 400, 140, 30);
        
        g.drawLine(420, 350, 560, 350); 
        for (int i = 425; i <= 555; i += 15) {
            g.drawLine(i, 350, i, 400); 
        }

        // stairs
        g.setColor(new Color(140, 150, 160)); 
        int[] stairX = {160, 420, 420, 160};
        int[] stairY = {660, 400, 430, 690}; 
        g.fillPolygon(stairX, stairY, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(stairX, stairY, 4);

        g2.setStroke(new BasicStroke(4));
        g.drawLine(160, 605, 420, 345); 
        g2.setStroke(new BasicStroke(2));
        for (int i = 0; i <= 11; i++) {
            int rx = 160 + (i * 24);
            int ryTop = 605 - (i * 24); 
            int ryBot = 660 - (i * 24); 
            g.drawLine(rx, ryTop, rx, ryBot); 
        }

        // left bush
        g.setColor(new Color(30, 130, 50)); 
        int[] lbX = {0, 20, 40, 80, 120, 160, 180, 0};
        int[] lbY = {600, 560, 540, 530, 540, 570, 600, 600};
        g.fillPolygon(lbX, lbY, 8);
        g.setColor(Color.BLACK);
        g.drawPolygon(lbX, lbY, 8);
        
        // tree
        g.setColor(new Color(30, 130, 50));
        int[] rbX = {800, 810, 830, 870, 920, 970, 1020, 1040, 1040, 1040, 800};
        int[] rbY = {600, 510, 450, 420, 420, 420, 440, 480, 540, 600, 600};
        g.fillPolygon(rbX, rbY, 11);
        g.setColor(Color.BLACK);
        g.drawPolygon(rbX, rbY, 11);

        // front wall
        g.setColor(new Color(245, 230, 180)); 
        g.fillRect(0, 600, 280, 150); 
        g.fillRect(560, 600, 490, 150); 

        // fence bricks
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        for (int y = 600; y <= 750; y += 40) {
            g.drawLine(0, y, 280, y);
            g.drawLine(560, y, 1050, y);
        }
        for (int y = 600; y < 750; y += 40) {
            int offset = (y == 600 || y == 680) ? 40 : 0;
            for (int x = 0; x <= 280; x += 80) {
                if (x + offset <= 280) g.drawLine(x + offset, y, x + offset, y + 40);
            }
            for (int x = 560; x <= 1050; x += 80) {
                if (x + offset <= 1050) g.drawLine(x + offset, y, x + offset, y + 40);
            }
        }

        // gate pillars
        g.setColor(new Color(130, 140, 150)); 
        g.fillRect(280, 560, 60, 190);
        g.fillRect(520, 560, 60, 190);
        g.setColor(Color.BLACK);
        g.drawRect(280, 560, 60, 190);
        g.drawRect(520, 560, 60, 190);
        
        // gate caps
        g.setColor(new Color(160, 170, 180));
        g.fillRect(270, 550, 80, 10);
        g.fillRect(510, 550, 80, 10);
        g.setColor(Color.BLACK);
        g.drawRect(270, 550, 80, 10);
        g.drawRect(510, 550, 80, 10);

        // nameplate
        g.setColor(new Color(150, 130, 60)); 
        g.fillRect(535, 610, 30, 50);
        g.setColor(Color.BLACK);
        g.drawRect(535, 610, 30, 50);
        
        g.drawLine(0, 715, 1050, 715);
    }

    public static void main(String[] args) {
        houseBonus x = new houseBonus();
    }
}