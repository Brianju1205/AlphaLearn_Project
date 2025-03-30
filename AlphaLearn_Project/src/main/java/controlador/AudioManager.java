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
    private double musicVolume = 1.0;  
    private double effectsVolume = 1.0; 

   
    public static AudioManager getInstance() {
        if (instance == null) {
            instance = new AudioManager();
        }
        return instance;
    }

    public void playMusic(String musicFilePath) {
        if (musicPlayer != null) {
            musicPlayer.stop(); 
        }
        Media music = new Media(getClass().getResource("/resources/sounds/" + musicFilePath).toString());
        musicPlayer = new MediaPlayer(music);
        musicPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
        musicPlayer.setVolume(musicVolume);  
        musicPlayer.play(); 
    }

    public void stopMusic() {
        if (musicPlayer != null) {
            musicPlayer.stop();
        }
    }

    public void playEffect(String soundFilePath) {
        AudioClip sound = new AudioClip(getClass().getResource("/resources/sounds/" + soundFilePath).toString());
        sound.setVolume(effectsVolume); 
        sound.play();  
    }

    public void setMusicVolume(double volume) {
        musicVolume = volume;
        if (musicPlayer != null) {
            musicPlayer.setVolume(musicVolume);
        }
    }

    public void setEffectsVolume(double volume) {
        effectsVolume = volume;
    }
}
