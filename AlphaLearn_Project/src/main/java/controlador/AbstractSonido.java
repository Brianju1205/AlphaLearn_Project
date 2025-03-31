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
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juare
 */
public abstract class AbstractSonido {
    private Clip clip;
    private JLabel labelInstruccion;
    private JPanel panel;
    public void reproducirSonido(String ruta) {
        
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            URL url = getClass().getResource(ruta);
            if (url == null) {
                System.err.println("No se encontro el archivo: " + ruta);
                return;
            }
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            clip.start();
             clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    ocultarImagen();
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    public void stopSonido(){
        clip.stop();
    }
    public void mostrarInstruccion(JPanel panel, String rutaImagen) {
        if (panel == null || rutaImagen == null) return;

        this.panel = panel; 

        labelInstruccion = new JLabel(new ImageIcon(getClass().getResource(rutaImagen)));
        labelInstruccion.setSize(400, 400);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel.add(labelInstruccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, 400, 400));
        panel.setComponentZOrder(labelInstruccion, 0);
        panel.revalidate();
        panel.repaint();
    }

    public void ocultarImagen() {
        if (panel != null && labelInstruccion != null) {
            panel.remove(labelInstruccion);
            panel.revalidate();
            panel.repaint();
            labelInstruccion = null; 
        }
    }
}
