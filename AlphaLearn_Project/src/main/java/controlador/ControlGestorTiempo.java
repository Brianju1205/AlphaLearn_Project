/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import modelo.GestorTiempo;

/**
 *
 * @author juare
 */
public class ControlGestorTiempo implements GestorTiempo {

    private static ControlGestorTiempo instancia; 
    private Conexion objConexion;

    private ControlGestorTiempo() {
        objConexion = Conexion.getInstance();
    }

    public static ControlGestorTiempo getInstancia() {
        if (instancia == null) {
            instancia = new ControlGestorTiempo();
        }
        return instancia;
    }

    @Override
    public void guardarTiempo(int idUsuario, int tiempo) {
        String sql = "INSERT INTO tiempo_activo (id_usuario, fecha, tiempo) VALUES (?, ?, ?)";

        try (PreparedStatement ps = objConexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUsuario); 
            ps.setDate(2, java.sql.Date.valueOf(LocalDate.now())); 
            ps.setInt(3, tiempo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, Integer> obtenerTiempoPorSemana(int idUsuario) {
        Map<String, Integer> datos = new HashMap<>();
        String sql = "SELECT fecha, SUM(tiempo) AS tiempo \n" +
                     "FROM tiempo_activo \n" +
                     "WHERE id_usuario = ? \n" +
                     "  AND fecha >= CURRENT_DATE - (EXTRACT(DOW FROM CURRENT_DATE) || ' days')::INTERVAL \n" +
                     "  AND fecha < CURRENT_DATE - (EXTRACT(DOW FROM CURRENT_DATE) || ' days')::INTERVAL + INTERVAL '7 days'\n" +
                     "GROUP BY fecha \n" +
                     "ORDER BY fecha;";

        try (PreparedStatement ps = objConexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUsuario); 
            try (ResultSet resultado = ps.executeQuery()) {
                while (resultado.next()) {
                    String fecha = resultado.getDate("fecha").toString();
                    int tiempo = resultado.getInt("tiempo");
                    datos.put(fecha, tiempo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }
}
