/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import modelo.GestorUsuario;

/**
 *
 * @author juare
 */
public class UsuarioDAO implements GestorUsuario{
    
    private Usuario objUsuario;
    private Conexion objConexion;
    private static UsuarioDAO instancia; 
    
    /**
     * Constructor privado para implementar Singleton
     * Inicializa la conexión a la base de datos
     */
    private UsuarioDAO() {
        this.objConexion = Conexion.getInstance(); 
    }
    
    /**
     * Obtiene la instancia única de UsuarioDAO
     * 
     * @return instancia única de UsuarioDAO
     */
    public static UsuarioDAO getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }
    
    /**
     * Inserta un nuevo usuario en la base de datos usando los datos del objeto Usuario
     * 
     * @throws Exception si ocurre un error durante la inserción
     */
    @Override
    public void crearUsuario() throws Exception {
        try {
            System.out.println("Insercion correcta en base de datos");

            objConexion.getStatement().execute("INSERT INTO usuarios (nombre, password) VALUES ('"
                + objUsuario.getNom() + "', '"
                + objUsuario.getPassword() + "');");

         } catch (SQLException ex) {
            throw new Exception("Error al insertar usuario", ex);
        }
    
    }

    /**
     * Busca un usuario por nombre y contraseña
     * 
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuario
     * @return objeto Usuario
     * @throws Exception si ocurre un error en la consulta
     */
    @Override
    public Usuario buscarUsuario(String nombre, String password) throws Exception {
        
         Usuario objUsuario = null;
        try {
            String sql = "SELECT * FROM usuarios WHERE nombre = ? AND password = ?";
            PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, password);

            ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            objUsuario = new Usuario();
            objUsuario.setNom(resultado.getString("nombre"));
            //objUsuario.setEdad(resultado.getInt("edad"));
            objUsuario.setContraseña(resultado.getString("password"));
        }
    } catch (SQLException ex) {
        throw new Exception("Error al buscar usuario", ex);
    }
    return objUsuario;
    }

    /**
     * Actualiza los datos de un usuario en la base de datos
     * 
     * @param usuario Usuario con datos actualizados
     * @throws Exception si ocurre un error durante la actualización
     */
    @Override
    public void actualizarUsuario(Usuario usuario) throws Exception {
        String sql = "UPDATE usuarios SET nombre=?, edad=?, nivel=?, password=? WHERE idUsuario=?";
        try (PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql)) {
            stmt.setString(1, usuario.getNom());
            //stmt.setInt(2, usuario.getEdad());
            stmt.setString(3, usuario.getNivel());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getIdUsuario());

            stmt.executeUpdate();
            System.out.println("Usuario actualizado con éxito.");
        } catch (SQLException ex) {
            throw new Exception("Error al actualizar usuario", ex);
        }
    }

    /**
     * Obtiene todos los usuarios registrados en la base de datos e imprime su información
     * 
     * @throws Exception si ocurre un error durante la consulta
     */
    @Override
    public void eliminarUsuario(String idUsuario) throws Exception {
        String sql = "DELETE FROM usuarios WHERE idUsuario=?";
        try (PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql)) {
            stmt.setString(1, idUsuario);

            stmt.executeUpdate();
            System.out.println("Usuario eliminado con éxito.");
        } catch (SQLException ex) {
            throw new Exception("Error al eliminar usuario", ex);
        }
    }

    @Override
    public void obtenerTodos() throws Exception {
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {
                System.out.println("ID: " + resultado.getString("idUsuario") +
                        ", Nombre: " + resultado.getString("nombre") +
                        ", Edad: " + resultado.getInt("edad") +
                        ", Nivel: " + resultado.getString("nivel"));
            }
        } catch (SQLException ex) {
            throw new Exception("Error al obtener todos los usuarios", ex);
        }
    }
   
    /**
     * Guarda un nuevo registro en el historial del usuario
     * 
     * @param usuarioId ID del usuario
     * @param palabra Palabra utilizada en el ejercicio
     * @param aciertos Número de aciertos del usuario
     * @throws Exception si ocurre un error durante la inserción
     */
    @Override
    public void guardarHistorial(int usuarioId, String palabra, int aciertos) throws Exception {
        String sql = "INSERT INTO historial(id_usuario, palabra, aciertos) VALUES (?, ?, ?)";
            Connection conn = Conexion.getInstance().getConnection();
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                try {
                    stmt.setInt(1, usuarioId);         
                    stmt.setString(2, palabra);       
                    stmt.setInt(3, aciertos);        
                    //stmt.setInt(4, errores);           
                    stmt.executeUpdate();
                } finally {
                    stmt.close(); // Solo cerramos el statement, no la conexión
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Error al guardar historial", ex);
            }
    }
     public Usuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(Usuario objUsuario) {
        this.objUsuario = objUsuario;
    }
    
}
    

