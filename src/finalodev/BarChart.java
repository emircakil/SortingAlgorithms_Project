package finalodev;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;

public class BarChart extends JPanel {

    int insertion;
    int heap;
    int bubble;
    int selection;
    int quick;
    int merge;

    BarChart(int insertion, int heap, int bubble, int selection, int quick, int merge) {

        this.insertion = insertion;
        this.heap = heap;
        this.bubble = bubble;
        this.selection = selection;
        this.quick = quick;
        this.merge = merge;

    }

    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Serif", Font.BOLD, 30));

        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.BLACK);
        g2.drawLine(50, 10, 50, 400);
        g2.drawLine(50, 400, 450, 400);

        g2.setFont(new Font("Serif", Font.BOLD, 15));
        g2.drawString("0", 25, 400);
        g2.drawString("100", 22, 300);
        g2.drawString("200", 22, 200);
        g2.drawString("300", 22, 100);
        g2.drawString("400", 22, 20);

        g2.setStroke(new BasicStroke(2));

        g2.setColor(Color.BLUE);
        g2.drawLine(107, 400, 107, 400 - merge);
        g2.drawString("Merge", 70, 440);

        g2.setColor(Color.CYAN);
        g2.drawLine(164, 400, 164, 400 - insertion);
        g2.drawString("Insertion", 120, 440);

        g2.setColor(Color.ORANGE);
        g2.drawLine(221, 400, 221, 400 - selection);
        g2.drawString("Selection", 185, 440);

        g2.setColor(Color.red);
        g2.drawLine(278, 400, 278, 400 - quick);
        g2.drawString("Quick", 255, 440);

        g2.setColor(Color.green);
        g2.drawLine(335, 400, 335, 400 - bubble);
        g2.drawString("Bubble", 310, 440);

        g2.setColor(Color.yellow);
        g2.drawLine(392, 400, 392, 400 - heap);
        g2.drawString("Heap", 370, 440);

    }

}
