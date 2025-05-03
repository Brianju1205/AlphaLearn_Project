/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
/**
 *
 * @author juare
 */
public class JLabelRedondeado extends JLabel {
    
    private int radio = 20;

    public JLabelRedondeado(String texto) {
        super(texto);
        setOpaque(false); // permitimos dibujar fondo personalizado
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(Color.BLACK);
        setBackground(new Color(220, 220, 220)); // color de fondo por defecto
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radio, radio));

        super.paintComponent(g);
        g2.dispose();
    }

    public void setRadio(int radio) {
        this.radio = radio;
        repaint();
    }
}
