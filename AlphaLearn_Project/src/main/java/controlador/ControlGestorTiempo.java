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
 * Clase ControlGestorTiempo
 * Implementa la interfaz GestorTiempo y se encarga de gestionar 
 * el tiempo de uso de un usuario en el sistema
 * 
 * Esta clase sigue el patrón Singleton para asegurar que solo exista una instancia
 *
 * @author juare
 */
public class ControlGestorTiempo implements GestorTiempo {

    private static ControlGestorTiempo instancia; // instancia unica
    private Conexion objConexion; // objeto para manejar la conexion a la base de datos

    /**
     * Constructor privado para evitar la creación directa de instancias
     * Se inicializa la conexión a la base de datos
     */
    private ControlGestorTiempo() {
        objConexion = Conexion.getInstance();
    }

    /**
     * Método para obtener la única instancia de ControlGestorTiempo
     * @return instancia única de ControlGestorTiempo
     */
    public static ControlGestorTiempo getInstancia() {
        if (instancia == null) {
            instancia = new ControlGestorTiempo();
        }
        return instancia;
    }

    /**
     * Guarda en la base de datos el tiempo activo de un usuario para el día actual
     * @param idUsuario ID del usuario
     * @param tiempo Tiempo de actividad
     */
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

    /**
     * Obtiene el tiempo total utilizado por el usuario en los últimos 7 días
     * Devuelve un mapa con la fecha como clave y el tiempo total como valor
     * @param idUsuario ID del usuario a consultar
     * @return Mapa con fechas y tiempos de uso correspondientes a cada día
     */
    @Override
    public Map<String, Integer> obtenerTiempoPorSemana(int idUsuario) {
        Map<String, Integer> datos = new HashMap<>();
        // Consulta SQL que selecciona la suma del tiempo por cada fecha de la semana actual
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
