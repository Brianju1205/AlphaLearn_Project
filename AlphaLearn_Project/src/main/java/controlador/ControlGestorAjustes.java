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
 *
 * @author juare
 */
public class ControlGestorAjustes implements GestorAjustes{
    
    private Conexion conexion;
    private static ControlGestorAjustes instancia;

    public ControlGestorAjustes() {
        this.conexion = Conexion.getInstance();
    }
    public static ControlGestorAjustes getInstance() {
        if (instancia == null) {
            instancia = new ControlGestorAjustes();
        }
        return instancia;
    }
    
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

    @Override
    public void cambiarContraseña(int idUsuario, String nuevaContrasenia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
