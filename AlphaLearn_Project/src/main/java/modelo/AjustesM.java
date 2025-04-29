/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase modelo que representa los ajustes personalizados de un usuario
 * 
 * Esta clase almacena la configuración individual de un usuario relacionada
 * con el sonido, la visualización de instrucciones y el volumen
 * 
 * @author juare
 */
public class AjustesM {
    private int idUsuario;
    private boolean sonidoActivo;
    private boolean instruccionesActivas;
    private float volumen;

    /**
     * Constructor vacío. 
     * por si se necesita crear nuevos objetos
     */
    public AjustesM() {
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos
     * 
     * @param idUsuario Identificador del usuario
     * @param sonidoActivo Estado del sonido (activo o no)
     * @param instruccionesActivas Estado de las instrucciones (activas o no)
     * @param volumen Valor del volumen configurado
     */
    public AjustesM(int idUsuario, boolean sonidoActivo, boolean instruccionesActivas, float volumen) {
        this.idUsuario = idUsuario;
        this.sonidoActivo = sonidoActivo;
        this.instruccionesActivas = instruccionesActivas;
        this.volumen = volumen;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isSonidoActivo() {
        return sonidoActivo;
    }

    public void setSonidoActivo(boolean sonidoActivo) {
        this.sonidoActivo = sonidoActivo;
    }

    public boolean isInstruccionesActivas() {
        return instruccionesActivas;
    }

    public void setInstruccionesActivas(boolean instruccionesActivas) {
        this.instruccionesActivas = instruccionesActivas;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }
    
    
}
