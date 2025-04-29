/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa una palabra que puede estar asociada a una imagen
 *
 * @author juare
 */
public class Palabra {
    private int id;
    private String palabra;
    private Imagen imagen;
    
    /**
     * Contructor vacio por si se requiere mas tarde
     */
    public Palabra() {}

     /**
     * Constructor para crear una nueva instancia de Palabra 
     * 
     * @param id el identificador único de la palabra
     * @param palabra la palabra representada como cadena de texto
     */
    public Palabra(int id, String palabra) {
        this.id = id;
        this.palabra = palabra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
    
}
