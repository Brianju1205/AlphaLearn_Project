/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public interface GestorAjustes {
    public void guardarAjustes(AjustesM ajustes);
    public AjustesM obtenerAjustes(int idUsuario);
}

