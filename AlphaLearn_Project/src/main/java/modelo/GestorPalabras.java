/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juare
 */
public interface GestorPalabras {
    public String obtenerPalabraDesordenada() throws Exception;
    public String obtenerWord() throws Exception;
    public ArrayList<Palabra> obtenerTresPalabrasConImagen() throws Exception;
    public void agregarPalabra(Palabra palabra) throws Exception;
    public void eliminarPalabra(int id) throws Exception;

}
