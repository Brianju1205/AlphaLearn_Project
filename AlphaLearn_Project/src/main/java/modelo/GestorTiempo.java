/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import java.util.Map;

/**
 * Interfaz que define las operaciones relacionadas con la gestión del tiempo de actividad
 * de los usuarios dentro del sistema
 * Permite guardar tiempos y consultar reportes semanales
 * 
 * @author juare
 */
public interface GestorTiempo {

    void guardarTiempo(int idUsuario, int tiempo);
    Map<String, Integer> obtenerTiempoPorSemana(int idUsuario);
}
