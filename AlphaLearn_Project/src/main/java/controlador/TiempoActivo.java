/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author juare
 */
public class TiempoActivo {
    private static TiempoActivo instancia;
    private long tiempoInicio;
    private long tiempoAcumulado;

    private TiempoActivo() {
        tiempoInicio = System.currentTimeMillis();
        tiempoAcumulado = 0;
    }

    public static TiempoActivo getInstancia() {
        if (instancia == null) {
            instancia = new TiempoActivo();
        }
        return instancia;
    }

    public void iniciarContador() {
        tiempoInicio = System.currentTimeMillis();
    }

    public void pausarContador() {
        tiempoAcumulado += (System.currentTimeMillis() - tiempoInicio) / 1000; 
    }

    public long getTiempoActivo() {
        return tiempoAcumulado + (System.currentTimeMillis() - tiempoInicio) / 1000/60;
    }

    public void reiniciarContador() {
        tiempoInicio = System.currentTimeMillis();
        tiempoAcumulado = 0;
    }
}
