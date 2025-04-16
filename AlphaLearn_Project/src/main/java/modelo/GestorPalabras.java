/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.ArrayList;


/**
 *
 * @author juare
 */
public interface GestorPalabras {
    public String obtenerPalabraDesordenada();
    public String obtenerWord();
    public ArrayList<Palabra> obtenerTresPalabrasConImagen();
    public void agregarPalabra(Palabra palabra);
    public void eliminarPalabra(int id);
    public  String[] obtenerOracionBase();
}
