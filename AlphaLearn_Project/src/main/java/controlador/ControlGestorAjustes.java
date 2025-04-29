/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.AjustesM;
import modelo.GestorAjustes;

/**
 * Clase encargada de controlar los ajustes de usuario
 * Implementa la interfaz GestorAjustes para cumplir con el modelo
 * Esta clase utiliza el patrón Singleton para asegurar una única instancia
 * 
 * 
 * @author juare
 */
public class ControlGestorAjustes implements GestorAjustes{
    
    private Conexion conexion; // Conexión a la base de datos
    private static ControlGestorAjustes instancia; // Instancia unica segun el patron singleton

    /**
     * Constructor privado para obtener la conexión desde la clase Conexion
     */
    public ControlGestorAjustes() {
        this.conexion = Conexion.getInstance();
    }
    
    /**
     * Obtiene la instancia única de ControlGestorAjustes
     * Si no existe, se crea una nueva
     *
     * @return instancia única de ControlGestorAjustes
     */
    public static ControlGestorAjustes getInstance() {
        if (instancia == null) {
            instancia = new ControlGestorAjustes();
        }
        return instancia;
    }
    
    /**
     * Guarda los ajustes del usuario en la base de datos
     * Si ya existen, se actualizan mediante una cláusula ON CONFLICT
     *
     * @param ajustes objeto AjustesM con los valores a guardar
     */
    @Override
    public void guardarAjustes(AjustesM ajustes) {
        String sql = "INSERT INTO ajustes_usuario (id_usuario, volumen, sonido_activado, instrucciones_visibles)\n" +
                        "VALUES (?, ?, ?, ?)\n" +
                        "ON CONFLICT (id_usuario) \n" +
                        "DO UPDATE SET volumen = EXCLUDED.volumen, "
                        + "sonido_activado = EXCLUDED.sonido_activado, instrucciones_visibles = "
                        + "EXCLUDED.instrucciones_visibles;";

        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, ajustes.getIdUsuario());
            ps.setFloat(2, ajustes.getVolumen());
            ps.setBoolean(3, ajustes.isSonidoActivo());
            ps.setBoolean(4, ajustes.isInstruccionesActivas());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Recupera los ajustes del usuario desde la base de datos
     *
     * @param idUsuario ID del usuario cuyos ajustes se quieren obtener
     * @return objeto AjustesM con los valores recuperados, o null si no existen
     */
    @Override
    public AjustesM obtenerAjustes(int idUsuario) {
        String sql = "SELECT volumen, sonido_activado, instrucciones_visibles FROM ajustes_usuario WHERE id_usuario = ?";
        AjustesM ajustes = null;

        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ajustes = new AjustesM();
                ajustes.setIdUsuario(idUsuario);
                ajustes.setVolumen(rs.getFloat("volumen"));
                ajustes.setSonidoActivo(rs.getBoolean("sonido_activado"));
                ajustes.setInstruccionesActivas(rs.getBoolean("instrucciones_visibles"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ajustes;
    }
    
}
