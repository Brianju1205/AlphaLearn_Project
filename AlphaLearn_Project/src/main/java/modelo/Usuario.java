/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public class Usuario {
    private String idUsuario;
    private String nom;
    private String nivel;
    private String password;
    
    public Usuario(){
        
    }
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
