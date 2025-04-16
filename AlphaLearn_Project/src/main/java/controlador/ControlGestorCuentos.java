/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cuento;
import modelo.CuentoPregunta;
import modelo.GestorCuentos;
import modelo.Pregunta;

/**
 *
 * @author juare
 */
public class ControlGestorCuentos implements GestorCuentos {
    private Conexion conexion;
    private static ControlGestorCuentos instancia;

    public ControlGestorCuentos() {
        this.conexion = Conexion.getInstance();
    }
    public static ControlGestorCuentos getInstance() {
        if (instancia == null) {
            instancia = new ControlGestorCuentos();
        }
        return instancia;
    }
    
    @Override
    public CuentoPregunta obtenerCuentos() {
        String sql = "SELECT " +
                    "c.id AS idCuento, " +
                    "c.titulo AS tituloCuento, " +
                    "c.cuento AS textoCuento, " +
                    "c.ruta_audio AS rutaAudio, " +
                    "p.id AS idPregunta, " +
                    "p.pregunta AS textoPregunta, " +
                    "p.opcion1, " +
                    "p.opcion2, " +
                    "p.opcion3, " +
                    "p.respuesta_correcta, " +
                    "p.ruta_audio_pregunta AS rutaAudioPregunta " +  // <--- espacio aquí
                    "FROM Cuentos c " +
                    "JOIN Preguntas p ON c.id = p.id_cuento " +
                    "ORDER BY RANDOM() " +
                    "LIMIT 1";


            CuentoPregunta cuentos = null;

       try{
           ResultSet resultado = conexion.getStatement().executeQuery(sql);
         
        if (resultado.next()) {
            Cuento cuento = new Cuento(
                resultado.getInt("idCuento"),
                resultado.getString("tituloCuento"),
                resultado.getString("textoCuento"),
                resultado.getString("rutaAudio")
            );

            
            Pregunta pregunta = new Pregunta(
                resultado.getInt("idPregunta"),
                resultado.getInt("idCuento"),
                resultado.getString("textoPregunta"),
                resultado.getString("opcion1"),
                resultado.getString("opcion2"),
                resultado.getString("opcion3"),
                resultado.getString("respuesta_correcta"),
                resultado.getString("rutaAudioPregunta")
            );
        
           
            cuentos = new CuentoPregunta(cuento, pregunta);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return cuentos;
             
    }
    
}
