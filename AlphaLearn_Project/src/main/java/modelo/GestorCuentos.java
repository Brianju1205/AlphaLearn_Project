/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 * Interfaz que define el contrato para gestionar cuentos y sus respectivas preguntas
 * 
 * @author juare
 */
public interface GestorCuentos {
     /**
     * Obtiene una instancia de {@link CuentoPregunta}, que representa un cuento
     * junto con su pregunta relacionada
     *
     * @return un objeto {@link CuentoPregunta} que contiene un cuento y su pregunta
     */
    CuentoPregunta obtenerCuentos();
}
