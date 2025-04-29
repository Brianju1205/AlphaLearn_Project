/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 * Clase que gestiona el tiempo activo de una sesión o actividad
 * permitiendo iniciar, pausar, consultar y reiniciar el contador de tiempo
 * 
 * Utiliza el patrón Singleton para asegurar que solo haya una instancia de 
 * la clase en toda la aplicación
 * 
 * El tiempo se mide en segundos
 * 
 * @author juare
 */
public class TiempoActivo {
    private static TiempoActivo instancia; // instancia unica siguiendo el patron singleton
    private long tiempoInicio;             // marca de tiempo inicio
    private long tiempoAcumulado;          // tiempo acumulado

    /**
     * Constructor privado para evitar la creación de múltiples instancias
     * Inicializa el tiempo de inicio y el tiempo acumulado
     */
    private TiempoActivo() {
        tiempoInicio = System.currentTimeMillis();
        tiempoAcumulado = 0;
    }

    /**
     * Devuelve la instancia única de la clase TiempoActivo
     * Si no existe, la crea
     *
     * @return La instancia única de TiempoActivo
     */
    public static TiempoActivo getInstancia() {
        if (instancia == null) {
            instancia = new TiempoActivo();
        }
        return instancia;
    }

    /**
     * Reinicia el tiempo de inicio al momento actual
     * sin afectar el tiempo acumulado
     */
    public void iniciarContador() {
        tiempoInicio = System.currentTimeMillis();
    }

    /**
     * Pausa el contador de tiempo, agregando el tiempo transcurrido
     * desde el último inicio al tiempo acumulado
     */
    public void pausarContador() {
        tiempoAcumulado += (System.currentTimeMillis() - tiempoInicio) / 1000; 
    }

    /**
     * Obtiene el tiempo activo total, sumando el tiempo acumulado
     * y el tiempo transcurrido desde el último inicio
     *
     * @return Tiempo activo en segundos
     */
    public long getTiempoActivo() {
        return tiempoAcumulado + (System.currentTimeMillis() - tiempoInicio) / 1000;
    }

    /**
     * Reinicia completamente el contador, poniendo a cero el tiempo acumulado
     * y actualizando el tiempo de inicio al momento actual
     */
    public void reiniciarContador() {
        tiempoInicio = System.currentTimeMillis();
        tiempoAcumulado = 0;
    }
}
