/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.security.Timestamp;
import modelo.CRUD;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Usuario;
/**
 *
 * @author Almen
 */
public class OperacionesBD extends CRUD{
    
    private Usuario objUsuario;
    Conexion objConexion;

    public Usuario getObjUsuario() {
        return objUsuario;
       
    }
    

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
    
    

    public OperacionesBD() {
        objConexion = new Conexion();
        objConexion.connectDatabase();
    }
   
    @Override
    public void create() {
        try{
            System.out.println("Insercion correcta en base de datos");
            
              // Asegúrate de que la contraseña esté correctamente delimitada entre comillas simples
            objConexion.stmt.execute("INSERT INTO usuarios (nombre, edad, password) VALUES ('"
             + objUsuario.getNom() + "', "
             + objUsuario.getEdad() + ", '"
             + objUsuario.getContraseña() + "');");

            
        }catch(SQLException ex){
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public ArrayList read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
       public Usuario buscarUsuario(String nombre, String contraseña) {
        Usuario objUsuario = null;
        try {
            ResultSet resultado = objConexion.stmt.executeQuery("SELECT * FROM usuarios WHERE nombre = '" + nombre + "' AND password = '" + contraseña + "';");
            
            if (resultado.next()) {
                objUsuario = new Usuario();
                objUsuario.setNom(resultado.getString("nombre"));
                objUsuario.setEdad(resultado.getInt("edad"));
                objUsuario.setContraseña(resultado.getString("contraseña"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUsuario;
    }
    
    
  

     
}
