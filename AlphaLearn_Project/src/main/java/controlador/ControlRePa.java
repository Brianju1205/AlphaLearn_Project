package controlador;

import vistas.RelacionarPalabras;
import javax.swing.*;
import java.awt.event.*;

/**
 * Controlador para el manejo de eventos de arrastre de palabras en la vista RelacionarPalabras
 * 
 * @author juare
 */
public class ControlRePa {
    private RelacionarPalabras vista;
    private int poaX, poaY;

    public ControlRePa(RelacionarPalabras vista) {
        this.vista = vista;

        agregarEventosArrastre(vista.getjLabel1_palabra1());
        agregarEventosArrastre(vista.getjLabel2_palabra3());
        agregarEventosArrastre(vista.getjLabel3_palabra2());
    }

    private void agregarEventosArrastre(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                poaX = evt.getX();
                poaY = evt.getY();
            }
        });

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                int newX = label.getX() + (evt.getX() - poaX);
                int newY = label.getY() + (evt.getY() - poaY);
                label.setLocation(newX, newY);
            }
        });
    }
}
