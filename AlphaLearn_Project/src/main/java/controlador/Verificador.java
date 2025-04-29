/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;


/** 
 * Esta clase se usa para validar los requermientos para entrar a la hora de iniciar sesion
 * y registrarse, ya que valida si ya existe ese usuario o no
 * 
 * @author almengor
 */

public class Verificador {
    private int id,edad;  // Variables para almacenar la información del usuario
    private String nom;   // Nombre del usuario
    private Conexion objConexion; // Conexión a la base de datos
    private static Verificador instancia;
    
    private Verificador() {
        this.objConexion = objConexion;
        this.objConexion = Conexion.getInstance();
        this.objConexion.getStatement();
        PreparedStatement preparedStatement = null;
    }
    
    /**
     * Método para obtener la instancia única de la clase Verificador
     * 
     * @return Instancia única de Verificador
     */
    public static Verificador getInstancia() {
        if (instancia == null) {
            instancia = new Verificador();
        }
        return instancia;
    }
  
    /**
     * Valida si el campo de texto no está vacío
     * 
     * @param cajaTexto Campo de texto que se valida
     * @return true si el campo no está vacío, false en caso contrario
     */
    public boolean verificaCajaTextoCadena(javax.swing.JTextField cajaTexto){
       if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"campo requerido" );
            return false;
        }
       return true;
    }
    
    /**
     * Valida si el campo de texto no está vacío.
     * 
     * @param cajaTexto Campo de texto que se valida
     * @return true si el campo no está vacío, false en caso contrario
     */
    public boolean verificaCajaTextoEntero(javax.swing.JTextField cajaTexto){
        if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null, "Campo requerido");
            return false;
        }

        return true;
    }
    
    /**
     * Verifica si un usuario con el nombre y contraseña proporcionados existe en la base de datos
     * 
     * @param usuarioDAO Instancia del DAO de usuario
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuario
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean existeUsuario1(UsuarioDAO usuarioDAO, String nombre, String password){
        Usuario usuario = null;
        try {
            usuario = usuarioDAO.buscarUsuario(nombre, password); // Busca el usuario en la base de datos
        } catch (Exception ex) {
            Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
        }  
       
        if (usuario != null) {
            return true; // Si se encuentra el usuario
        } else {
            return false; // Si no encuentra el usuario
        }
    }
    
    /**
     * Valida si el usuario y la contraseña son correctos
     * 
     * @param nombre Nombre del usuario
     * @param pin Contraseña del usuario
     * @return true si el usuario y la contraseña son válidos, false en caso contrario
     */
    public boolean validaUsuario(String nombre, String pin){
        
        try (PreparedStatement preparedStatement = objConexion.getConnection().prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND password = ?")) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, pin);

            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                this.id = resultado.getInt("id_usuario"); // Recupera el ID del usuario
                this.nom=resultado.getString("nombre"); // Recupera el nombre del usuario
                return true; // retorna true, si los datos ingresados son validos
            } else {
                return false; // si no encuentra al usuario
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");
            ex.printStackTrace();
            return false;
        }
       
    }
    
    /**
     * Verifica si el usuario ya existe en la base de datos
     * 
     * @param nombre Nombre del usuario
     * @param pin Contraseña del usuario
     * @return true si el usuario existe, false en caso contrario
     */
    public boolean validaUsuarioExistente(String nombre, String pin){
        
        try (PreparedStatement preparedStatement = objConexion.getConnection().prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND password = ?")) {
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, pin);

            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                return true;
            }
        }   catch (SQLException ex) {
                Logger.getLogger(Verificador.class.getName()).log(Level.SEVERE, null, ex);
            }
    return true;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
