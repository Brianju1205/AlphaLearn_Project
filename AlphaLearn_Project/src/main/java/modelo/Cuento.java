/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public class Cuento {

    private int id;
    private String titulo;
    private String cuento;
    private String rutaAudio;

    
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

