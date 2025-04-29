/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Esta clase es un panel personalizado de Swing que permite dibujar líneas en el panel
 * a partir de una serie de puntos agregados dibujados por el usuario, las líneas se dibujan de forma continua
 * entre los puntos agregados y se actualiza automáticamente cuando se agregan o eliminan puntos
 * El panel también permite limpiar las líneas dibujadas o reiniciarlas completamente
 * 
 * @author juare
 */
public class PanelPatronConLineas extends JPanel {
    
    // Lista que almacena los puntos donde se dibujarán las líneas
    private ArrayList<Point> puntos = new ArrayList<>();

    /**
     * Agrega un punto a la lista de puntos y redibuja el panel
     *
     * @param p El punto a agregar a la lista
     */
    public void agregarPunto(Point p) {
        puntos.add(p);
        repaint();
    }

    /**
     * Limpia todos los puntos almacenados en la lista y redibuja el panel
     */
    public void limpiarPuntos() {
        puntos.clear();
        repaint();
    }

    /**
     * Método sobrescrito de JPanel que se encarga de dibujar el contenido del panel
     * Dibuja líneas entre los puntos almacenados en la lista puntos
     *
     * @param g El objeto Graphics es el que permite dibujar en el panel
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        // tiene que tener mas de dos puntos selecionados para dibujar la linea
        if (puntos.size() > 1) {
            g2.setColor(Color.BLACK); // color
            g2.setStroke(new BasicStroke(30)); // grosor

            // Dibuja líneas entre los puntos 
            for (int i = 0; i < puntos.size() - 1; i++) {
                Point p1 = puntos.get(i);
                Point p2 = puntos.get(i + 1);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
    
    /**
     * Reinicia el dibujo borrando todos los puntos y redibujando el panel
     */
    public void reiniciarLineas() {
        puntos.clear();
        repaint();
    }

}
