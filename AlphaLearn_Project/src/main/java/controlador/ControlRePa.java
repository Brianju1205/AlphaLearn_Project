package controlador;

import vistas.RelacionarPalabras;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Controlador para manejar el arrastre y soltar palabras en los JLabel destino.
 * 
 * @author juare
 */
public class ControlRePa {
    private RelacionarPalabras vista;
    private int poaX, poaY; 
    private Point posicionOriginal; 
    private boolean clicDerechoPresionado = false;

    private Point coordenadasPalabra1 = new Point(779, 120); 
    private Point coordenadasPalabra2 = new Point(779, 250);
    private Point coordenadasPalabra3 = new Point(779, 400); 

    public ControlRePa(RelacionarPalabras vista) {
        this.vista = vista;

        agregarEventosArrastre(vista.getjLabel1_palabra1(), coordenadasPalabra1);
        agregarEventosArrastre(vista.getjLabel2_palabra3(), coordenadasPalabra2);
        agregarEventosArrastre(vista.getjLabel3_palabra2(), coordenadasPalabra3);
        vista.getjPanel3_fondo().setLayout(null);
    }

    private void agregarEventosArrastre(JLabel label, Point coordenadasEspecificas) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                poaX = evt.getX();
                poaY = evt.getY();
                posicionOriginal = label.getLocation();              
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                JLabel destino1 = vista.getjLabel_destino1();
                JLabel destino2 = vista.getjLabel_destino2();
                JLabel destino3 = vista.getjLabel_destino3();

                Point puntoGlobal = SwingUtilities.convertPoint(label, evt.getPoint(), vista.getjPanel3_fondo());

                if (destino1.getBounds().contains(puntoGlobal)) {
                    pegarEnDestino(label, destino1);
                } else if (destino2.getBounds().contains(puntoGlobal)) {
                    pegarEnDestino(label, destino2);
                } else if (destino3.getBounds().contains(puntoGlobal)) {
                    pegarEnDestino(label, destino3);
                } else {
                    liberarDelDestino(label, coordenadasEspecificas);
                }
            }
        });

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                int newX = label.getX() + (evt.getX() - poaX);
                int newY = label.getY() + (evt.getY() - poaY);

                if (newX < 0 || newY < 0 || newX + label.getWidth() > vista.getjPanel3_fondo().getWidth() ||
                    newY + label.getHeight() > vista.getjPanel3_fondo().getHeight()) {
                    liberarDelDestino(label, coordenadasEspecificas);
                } else {
                    label.setLocation(newX, newY);
                }
            }
        });
    }

    private void pegarEnDestino(JLabel label, JLabel destino) {
        destino.setLayout(new BorderLayout()); 
        destino.setText(""); 

        label.setSize(destino.getSize());
        label.setLocation(0, 0); 

        destino.add(label, BorderLayout.CENTER);
        destino.revalidate();
        destino.repaint();
    }

    private void liberarDelDestino(JLabel label, Point coordenadasEspecificas) {
        if (label.getParent() != null) {
            Container parent = label.getParent();
            parent.remove(label);  

            label.setLocation(coordenadasEspecificas);  

            vista.getjPanel3_fondo().add(label);
            vista.getjPanel3_fondo().revalidate();
            vista.getjPanel3_fondo().repaint();
        }
    }
}