/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase abstracta que proporciona la funcion para reproducir sonidos
 * y mostrar o ocultar una imagen de instrucción asociada en un panel mientras
 * se reproduce el sonido.
 * 
 * @author juare
 */
public abstract class AbstractSonido {
    
    private Clip clip; // Objeto que maneja la reproducción de audio
    private JLabel labelInstruccion; // Imagen mostrada como instrucción
    private JPanel panel; // Panel donde se mostrará la imagen de instrucción

    /**
     * Reproduce un sonido a partir de la ruta
     * Si ya hay un sonido reproduciéndose, lo detiene primero
     *
     * @param ruta Ruta del archivo de audio dentro del proyecto
     */
    public void reproducirSonido(String ruta) {
        try {
            /** Si hay un clip reproduciendo, detenerlo y cerrarlo
             *  Esto nos sirve para evitar sobre cargar el metodo
             */
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            
            // Carga el archivo de sonido
            URL url = getClass().getResource(ruta);
            if (url == null) {
                System.err.println("No se encontró el archivo: " + ruta);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Controlar el volumen del clip
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(utils.ControlVolumen.getVolumenEnDecibeles());

            // Iniciar la reproducción
            clip.start();

            // Agregar un listener para detectar cuando termine la reproducción
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    ocultarImagen(); // Ocultar la imagen cuando el audio termine
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Detiene la reproducción de sonido, si hay uno activo,
     * y oculta cualquier imagen de instrucción mostrada
     */
    public void stopSonido() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        ocultarImagen();
    }

    /**
     * Muestra una imagen de instrucción sobre un panel en una posición específica
     * 
     * @param panel Panel donde se colocará la imagen
     * @param rutaImagen Ruta del archivo de la imagen
     * @param x Coordenada X donde se colocará la imagen en el panel
     * @param y Coordenada Y donde se colocará la imagen en el panel
     */
    public void mostrarInstruccion(JPanel panel, String rutaImagen, int x, int y) {
        if (panel == null || rutaImagen == null) return;

        this.panel = panel;

        // Crear un JLabel con la imagen
        labelInstruccion = new JLabel(new ImageIcon(getClass().getResource(rutaImagen)));
        labelInstruccion.setSize(400, 400);

        // Establecer el layout absoluto para permitir posicionamiento personalizado
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Agregar la imagen al panel en las coordenadas especificadas
        panel.add(labelInstruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, 400, 400));

        // Traer la imagen al frente de todos los componentes
        panel.setComponentZOrder(labelInstruccion, 0);

        // Actualizar el panel
        panel.revalidate();
        panel.repaint();
    }

    /**
     * Oculta y elimina del panel la imagen de instrucción mostrada, si existe
     */
    public void ocultarImagen() {
        if (panel != null && labelInstruccion != null) {
            panel.remove(labelInstruccion);
            panel.revalidate();
            panel.repaint();
            labelInstruccion = null;
        }
    }
}
