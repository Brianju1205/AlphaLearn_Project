/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
// del text

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;


/** 
 *
 * @author almengor
 */

public class Verificador {
    private int id;
    private String nom;
    private Conexion objConexion;
    private static Verificador instancia;
    
    private Verificador() {
        this.objConexion = objConexion;
        this.objConexion = Conexion.getInstance();
        this.objConexion.getStatement();
        PreparedStatement preparedStatement = null;
    }
    public static Verificador getInstancia() {
        if (instancia == null) {
            instancia = new Verificador();
        }
        return instancia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public boolean verificaCajaTextoCadena(javax.swing.JTextField cajaTexto){
       if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"campo requerido" );
            return false;
        }
       return true;
   }
    public boolean verificaCajaTextoEntero(javax.swing.JTextField cajaTexto){
    if(cajaTexto.getText().isBlank()){
        JOptionPane.showMessageDialog(null, "Campo requerido");
        return false;
    }
   
    return true;
}

   /*public boolean existeUsuario(OperacionesBD operacionesBD, String nombre, String contra){
        Usuario usuario = operacionesBD.buscarUsuario(nombre, contra); 
        
       
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }*/
   public boolean existeUsuario1(UsuarioDAO usuarioDAO, String nombre, String password){
       // Usuario usuario = UsuarioDAO.buscarUsuario(nombre, contra); 
        Usuario usuario = null;
        try {
            usuario = usuarioDAO.buscarUsuario(nombre, password);
        } catch (Exception ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }
   public boolean validaUsuario(String nombre, String pin){
        
        try (PreparedStatement preparedStatement = objConexion.getConnection().prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND password = ?")) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, pin);

            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                this.id = resultado.getInt("id_usuario");
                this.nom=resultado.getString("nombre");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o PIN incorrecto");
                return false; 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
            return false;
        }
       
    }
    
}
