/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author juare
 */



public class AudioManager {

    private static AudioManager instance;
    private MediaPlayer musicPlayer;
    private double musicVolume = 1.0;  // Volumen de música
    private double effectsVolume = 1.0;  // Volumen de efectos de sonido

    // Obtener la instancia única de AudioManager
    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    // Reproducir música de fondo
    public void playMusic(String musicFilePath) {
        if (musicPlayer != null) {
            musicPlayer.stop(); // Detener música si ya está reproduciéndose
        }
        Media music = new Media(getClass().getResource("/resources/sounds/" + musicFilePath).toString());
        musicPlayer = new MediaPlayer(music);
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);  // Reproducir en bucle
        musicPlayer.setVolume(musicVolume);  // Establecer volumen
        musicPlayer.play();  // Iniciar la música
    }

    // Detener la música
    public void stopMusic() {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }
    }

    // Reproducir un efecto de sonido
    public void playEffect(String soundFilePath) {
        AudioClip sound = new AudioClip(getClass().getResource("/resources/sounds/" + soundFilePath).toString());
        sound.setVolume(effectsVolume);  // Establecer volumen
        sound.play();  // Reproducir el sonido
    }

    // Configurar el volumen de la música
    public void setMusicVolume(double volume) {
        musicVolume = volume;
        if (musicPlayer != null) {
            musicPlayer.setVolume(musicVolume);
        }
    }

    // Configurar el volumen de los efectos
    public void setEffectsVolume(double volume) {
        effectsVolume = volume;
    }
}
