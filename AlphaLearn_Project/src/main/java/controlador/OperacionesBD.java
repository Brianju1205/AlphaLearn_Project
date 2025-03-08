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
    private Conexion objConexion;
    private static OperacionesBD instancia; 

    private OperacionesBD() {
        objConexion = Conexion.getInstance(); 
    }
    
    public static OperacionesBD getInstance() {
        if (instancia == null) {
            instancia = new OperacionesBD();
        }
        return instancia;
    }

    @Override
    public void create() {
        try {
            System.out.println("Inserción correcta en base de datos");

            objConexion.getStatement().execute("INSERT INTO usuarios (nombre, edad, password) VALUES ('"
                + objUsuario.getNom() + "', "
                + objUsuario.getEdad() + ", '"
                + objUsuario.getPassword() + "');");

        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList read() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Usuario buscarUsuario(String nombre, String contraseña) {
        Usuario objUsuario = null;
        try {
            ResultSet resultado = objConexion.getStatement().executeQuery("SELECT * FROM usuarios WHERE nombre = '"
                + nombre + "' AND password = '" + contraseña + "';");

            if (resultado.next()) {
                objUsuario = new Usuario();
                objUsuario.setNom(resultado.getString("nombre"));
                objUsuario.setEdad(resultado.getInt("edad"));
                objUsuario.setContraseña(resultado.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objUsuario;
    }
    public String obtenerPalabraDesordenada() {
        String palabra = "";
        try {
            ResultSet resultado = objConexion.stmt.executeQuery("SELECT palabra FROM palabras ORDER BY RANDOM() LIMIT 1;");
            if (resultado.next()) {
                palabra = resultado.getString("palabra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return palabra;
    }
    public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
}
    
  
