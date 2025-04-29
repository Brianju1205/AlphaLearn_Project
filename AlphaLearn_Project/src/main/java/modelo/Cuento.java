/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase modelo que representa un cuento
 * 
 * Esta clase contiene los atributos básicos de un cuento, incluyendo su 
 * identificador, título, contenido textual y la ruta al archivo de audio
 * 
 *
 * @author juare
 */
public class Cuento {

    private int id;
    private String titulo;
    private String cuento;
    private String rutaAudio;
    
    /**
     * Constructor que inicializa todos los atributos del cuento
     * 
     * @param id Identificador único del cuento
     * @param titulo Título del cuento
     * @param cuento Texto completo del cuento
     * @param rutaAudio Ruta del archivo de audio asociado al cuento
     */
    public Cuento(int id, String titulo, String cuento, String rutaAudio) {
        this.id = id;
        this.titulo = titulo;
        this.cuento = cuento;
        this.rutaAudio = rutaAudio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuento() {
        return cuento;
    }

    public void setCuento(String cuento) {
        this.cuento = cuento;
    }

    public String getRutaAudio() {
        return rutaAudio;
    }

    public void setRutaAudio(String rutaAudio) {
        this.rutaAudio = rutaAudio;
    }
}

