/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author juare
 */
public class ControlVolumen {
    private static int volumen = 100; 

    public static int getVolumen() {
        return volumen;
    }

    public static void setVolumen(int nuevoVolumen) {
        if (nuevoVolumen < 0) nuevoVolumen = 0;
        if (nuevoVolumen > 100) nuevoVolumen = 100;
        volumen = nuevoVolumen;
    }

    public static float getVolumenEnDecibeles() {
        if (volumen == 0) return -80.0f; 
        return (float) (Math.log10(volumen / 100.0) * 20);
    }
}