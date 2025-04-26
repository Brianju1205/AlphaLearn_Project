/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author juare
 */
public class PanelPatronConLineas extends JPanel {
    private ArrayList<Point> puntos = new ArrayList<>();

    public void agregarPunto(Point p) {
        puntos.add(p);
        repaint();
    }

    public void limpiarPuntos() {
        puntos.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (puntos.size() > 1) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(30));

            for (int i = 0; i < puntos.size() - 1; i++) {
                Point p1 = puntos.get(i);
                Point p2 = puntos.get(i + 1);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
    public void reiniciarLineas() {
        puntos.clear();
        repaint();
    }

}
