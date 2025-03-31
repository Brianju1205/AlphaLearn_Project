/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.Map;

/**
 *
 * @author juare
 */
public interface DAOTiempo {

    void guardarTiempo(int idUsuario, int tiempo);
    Map<String, Integer> obtenerTiempoPorSemana(int idUsuario);
}
