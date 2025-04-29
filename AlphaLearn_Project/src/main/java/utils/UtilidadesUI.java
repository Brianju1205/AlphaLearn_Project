/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Clase de utilidad para la gestión de iconos y su escalado en componentes gráficos de la interfaz de usuario
 * Proporciona métodos para aplicar iconos escalados a Jlabels, botones y otros componentes,
 * incluyendo la interacción con los iconos (como cambios en el estado de los botones al pasar el mause por encima)
 *
 * @author juare
 */
public class UtilidadesUI {
    
    /**
     * Aplica un icono escalado a JLabels, de acuerdo con el tamaño. El icono
     * se ajusta automáticamente cada vez que el tamaño del Jlabel cambia
     * 
     * @param etiqueta Jlabel a la que se le aplicará el icono escalado
     * @param rutaImagen la ruta del archivo de imagen que se utilizará como icono
     */
    public static void aplicarIconoEscalado(JLabel etiqueta, String rutaImagen) {
        etiqueta.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                escalarYAsignar(etiqueta, rutaImagen);
            }
        });

        escalarYAsignar(etiqueta, rutaImagen); 
    }

     /**
     * Cambia el icono dependiendo del estado del mause:
     * 
     * @param componente el componente sobre el que se aplicarán los iconos
     * @param rutaNormal la ruta del icono cuando el componente está en su estado normal
     * @param rutaHover la ruta del icono cuando el mause está sobre el componente
     * @param rutaPressed la ruta del icono cuando el componente es presionado
     */
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

    /**
     * Escala una imagen al tamaño de un componente y la asigna al mismo
     * El componente puede ser un JLabel o un JButton, y la imagen será escalada para ajustarse
     * a las dimensiones actuales del componente
     * 
     * @param componente el componente al que se asignará la imagen escalada
     * @param rutaImagen la ruta del archivo de imagen que se escalará y asignará
     */
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

