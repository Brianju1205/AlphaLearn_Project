/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 * Esta clase se encarga de manejar el control del volumen, proporcionando métodos
 * para obtener y modificar el volumen en un rango de 0 a 100, y convertir el valor
 * de volumen a decibelios, el volumen se almacena como un valor estático para ser accesible
 * globalmente
 *
 * @author juare
 */
public class ControlVolumen {
    private static int volumen = 100; 

    /**
     * Obtiene el volumen actual
     *
     * @return El valor del volumen actual en un rango de 0 a 100
     */
    public static int getVolumen() {
        return volumen;
    }

    /**
     * Establece un nuevo valor de volumen. Si el valor proporcionado es menor que 0
     * se ajusta al valor mínimo (0). Si es mayor que 100, se ajusta al valor máximo (100)
     *
     * @param nuevoVolumen El nuevo valor de volumen a establecer
     */
    public static void setVolumen(int nuevoVolumen) {
        if (nuevoVolumen < 0) nuevoVolumen = 0;
        if (nuevoVolumen > 100) nuevoVolumen = 100;
        volumen = nuevoVolumen;
    }

     /**
     * Convierte el valor actual de volumen en una escala de decibelios, si el volumen es 0,
     * devuelve -80.0f, que representa la ausencia de sonido y si no se utiliza la
     * fórmula logarítmica para calcular el valor de decibelios.
     *
     * @return El volumen actual en decibelios
     */
    public static float getVolumenEnDecibeles() {
        if (volumen == 0) return -80.0f; 
        return (float) (Math.log10(volumen / 100.0) * 20);
    }
}