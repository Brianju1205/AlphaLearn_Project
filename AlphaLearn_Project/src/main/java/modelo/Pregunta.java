/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa una pregunta asociada a un cuento, con sus respectivas opciones de respuesta
 * y la respuesta correcta y contiene la ruta del audio de la pregunta
 *
 * @author juare
 */
public class Pregunta {

    private int id;
    private int idCuento;
    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String respuestaCorrecta;
    private String rutaAudiop;
    
    /**
     * Constructor para crear una nueva instancia de Pregunta 
     * 
     * @param id el identificador único de la pregunta
     * @param idCuento el identificador del cuento relacionado
     * @param pregunta el texto de la pregunta
     * @param opcion1 la primera opción de respuesta
     * @param opcion2 la segunda opción de respuesta
     * @param opcion3 la tercera opción de respuesta
     * @param respuestaCorrecta la respuesta correcta de la pregunta
     * @param rutaAudiop la ruta del archivo de audio asociado a la pregunta
     */
    public Pregunta(int id, int idCuento, String pregunta, String opcion1, String opcion2, String opcion3, String respuestaCorrecta, String rutaAudiop) {
        this.id = id;
        this.idCuento = idCuento;
        this.pregunta = pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.respuestaCorrecta = respuestaCorrecta;
        this.rutaAudiop = rutaAudiop;
    }

    public String getRutaAudiop() {
        return rutaAudiop;
    }

    public void setRutaAudiop(String rutaAudiop) {
        this.rutaAudiop= rutaAudiop;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCuento() {
        return idCuento;
    }

    public void setIdCuento(int idCuento) {
        this.idCuento = idCuento;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
}

