/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa la asociación entre un {@link Cuento} y una {@link Pregunta}
 * 
 * @author juare
 */
public class CuentoPregunta {
    private Cuento cuento;
    private Pregunta pregunta;

    /**
     * Constructor que permite inicializar la relación entre un cuento y una pregunta
     * 
     * @param cuento El cuento asociado
     * @param pregunta La pregunta asociada al cuento
     */
    public CuentoPregunta(Cuento cuento, Pregunta pregunta) {
        this.cuento = cuento;
        this.pregunta = pregunta;
    }
 
    /**
     * Obtiene el cuento asociado.
     * 
     * @return Objeto {@link Cuento}
     */
    public Cuento getCuento() {
        return cuento;
    }

    /**
     * Obtiene la pregunta asociada al cuento.
     * 
     * @return Objeto {@link Pregunta}
     */
    public Pregunta getPregunta() {
        return pregunta;
    }
}

