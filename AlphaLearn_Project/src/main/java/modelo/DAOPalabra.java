/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public interface DAOPalabra {
    public String obtenerPalabraDesordenada() throws Exception;
    public Palabra obtenerPalabraConImagenAleatoria() throws Exception; 
    public void agregarPalabra(Palabra palabra) throws Exception;
    public void eliminarPalabra(int id) throws Exception;

}
