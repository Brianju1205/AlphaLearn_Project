/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public class AjustesM {
    private int idUsuario;
    private boolean sonidoActivo;
    private boolean instruccionesActivas;
    private float volumen;

    public AjustesM() {
    }

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
