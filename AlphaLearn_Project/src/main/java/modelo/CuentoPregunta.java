/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public class CuentoPregunta {
    private Cuento cuento;
    private Pregunta pregunta;

    public CuentoPregunta(Cuento cuento, Pregunta pregunta) {
        this.cuento = cuento;
        this.pregunta = pregunta;
    }

    
    public Cuento getCuento() {
        return cuento;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }
}

