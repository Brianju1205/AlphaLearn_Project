/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author juare
 */
public class UtilidadesUI {
    
    public static void aplicarIconoEscalado(JLabel etiqueta, String rutaImagen) {
        etiqueta.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                escalarYAsignar(etiqueta, rutaImagen);
            }
        });

        escalarYAsignar(etiqueta, rutaImagen); 
    }

    
    public static void aplicarIconosInteractivos(JComponent componente, String rutaNormal, String rutaHover, String rutaPressed) {
        escalarYAsignar(componente, rutaNormal); 
        componente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                escalarYAsignar(componente, rutaHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                escalarYAsignar(componente, rutaNormal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                escalarYAsignar(componente, rutaPressed);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                escalarYAsignar(componente, rutaHover);
            }
        });

       
        componente.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                escalarYAsignar(componente, rutaNormal);
            }
        });
    }

    public static void escalarYAsignar(JComponent componente, String rutaImagen) {
        int width = componente.getWidth();
        int height = componente.getHeight();

        if (width == 0 || height == 0) return; 

        ImageIcon iconoOriginal = new ImageIcon(UtilidadesUI.class.getResource(rutaImagen));
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon iconoFinal = new ImageIcon(imagenEscalada);

        if (componente instanceof JLabel label) {
            label.setIcon(iconoFinal);
        } else if (componente instanceof JButton boton) {
            boton.setIcon(iconoFinal);
            boton.setBorderPainted(false);
            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
        }
    }
}

