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
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author juare
 */
public abstract class AbstractSonido {
    private Clip clip;
       
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
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
    public void stopSonido(){
        clip.stop();
    }
}
