/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public class Imagen {
    private int id;
    private String ruta; 
    private int palabraId; 

    public Imagen() {}

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