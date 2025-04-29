/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa una imagen asociada a una palabra en el sistema
 * Cada imagen tiene un identificador único, una ruta del archivo de la imagen,
 * y un identificador de la palabra relacionada con la imagen
 * 
 * @author juare
 */
public class Imagen {
    private int id;
    private String ruta; 
    private int palabraId; 

    /**
     * Constructor vacio por si se requiere mas tarde
     */
    public Imagen() {}

    /**
     * Constructor para crear una nueva instancia de Imagen 
     * 
     * @param id el identificador único de la imagen
     * @param ruta la ruta del archivo de la imagen
     * @param palabraId el identificador de la palabra relacionada a la imagen
     */
    public Imagen(int id, String ruta, int palabraId) {
        this.id = id;
        this.ruta = ruta;
        this.palabraId = palabraId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getPalabraId() {
        return palabraId;
    }

    public void setPalabraId(int palabraId) {
        this.palabraId = palabraId;
    }
}