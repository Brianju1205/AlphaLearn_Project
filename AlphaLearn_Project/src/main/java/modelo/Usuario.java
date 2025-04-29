/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un usuario en el sistema con información sobre su identificación, nombre, 
 * nivel de acceso y contraseña
 * 
 * 
 * @author juare
 */
public class Usuario {
    private String idUsuario;
    private String nom;
    private String nivel;
    private String password;
    
    /**
     * Constructor vacío para crear una nueva instancia de Usuario sin valores iniciales
     */
    public Usuario(){
        
    }
    
    /**
     * Constructor para crear una nueva instancia de Usuario 
     * 
     * @param idUsuario el identificador único del usuario
     * @param nom el nombre del usuario
     * @param nivel el nivel de acceso del usuario
     * @param password la contraseña del usuario
     */
    public Usuario(String idUsuario, String nom, String nivel, String password) {
        this.idUsuario = idUsuario;
        this.nom = nom;
        
        this.nivel = nivel;
        this.password = password;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPassword() {
        return password;
    }

    public void setContraseña(String password) {
        this.password = password;
    }
    
    
}
