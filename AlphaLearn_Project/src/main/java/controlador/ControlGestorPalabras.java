/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Imagen;
import modelo.Palabra;
import modelo.GestorPalabras;

/**
 * Controlador para la gestión de palabras y oraciones en la base de datos
 * Implementa la interfaz GestorPalabras
 * 
 * @author juare
 */

public class ControlGestorPalabras implements GestorPalabras {
    private Conexion objConexion;  // Conexión a la base de datos
    private static ControlGestorPalabras instancia;  // instancia singleton

    /**
     * Constructor privado que inicializa la conexión con la base de datos
     * Utiliza el patrón Singleton para obtener la instancia de conexión
     */
    private ControlGestorPalabras() {
        objConexion = Conexion.getInstance(); 
    }
    
    /**
     * Método estático para obtener la instancia única del gestor de cuentos.
     * Si no existe, la crea
     * 
     * @return instancia única de ControlGestorCuentos
     */
    public static ControlGestorPalabras getInstance() {
        if (instancia == null) {
            instancia = new ControlGestorPalabras();
        }
        return instancia;
    }

    /**
     * Obtiene una palabra aleatoria de la base de datos "palabras".
     * @return Palabra obtenida o cadena vacía
     */
    @Override
    public String obtenerPalabraDesordenada() {
        String palabra = "";
        try {
            ResultSet resultado = objConexion.getStatement().executeQuery("SELECT palabra FROM palabras ORDER BY RANDOM() LIMIT 1;");
            if (resultado.next()) {
                palabra = resultado.getString("palabra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex);
            try {
                throw new Exception("Error al obtener palabra desordenada", ex);
            } catch (Exception ex1) {
                Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return palabra;
    }
    
    /**
     * Obtiene tres palabras aleatorias junto con sus respectivas imágenes
     * @return Lista de palabras, cada uno con su imagen asociada
     */
    @Override
    public ArrayList<Palabra> obtenerTresPalabrasConImagen(){
        ArrayList<Palabra> palabras = new ArrayList<>();
        try {  
            String sql = "SELECT p.idp AS palabra_id, p.palabrai, i.id AS imagen_id, i.ruta " +
                         "FROM palabrasi p " +
                         "JOIN imagenes i ON p.idp = i.palabra_id " +
                         "ORDER BY RANDOM() LIMIT 3;";

            ResultSet resultado = objConexion.getStatement().executeQuery(sql);

        while (resultado.next()) {
            Palabra palabra = new Palabra();
            palabra.setId(resultado.getInt("palabra_id"));
            palabra.setPalabra(resultado.getString("palabrai"));

            Imagen imagen = new Imagen();
            imagen.setId(resultado.getInt("imagen_id"));
            imagen.setRuta(resultado.getString("ruta"));
            imagen.setPalabraId(resultado.getInt("palabra_id"));

            palabra.setImagen(imagen); 
            palabras.add(palabra);
        }
            } catch (SQLException ex) {
                Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex);
            try {
                throw new Exception("Error al obtener palabras con imágenes", ex);
            } catch (Exception ex1) {
                Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex1);
            }
            }
        return palabras;
    }

    /**
     * Agrega una nueva palabra a la base de datos
     * @param palabra Objeto Palabra que contiene el texto a insertar
     */
    @Override
    public void agregarPalabra(Palabra palabra) {
        try {
            String sql = "INSERT INTO palabras (palabra) VALUES (?);";
            PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql);
            stmt.setString(1, palabra.getPalabra());
            stmt.executeUpdate();
            System.out.println("Palabra agregada correctamente.");
        } catch (SQLException ex) {
            try {
                throw new Exception("Error al agregar palabra", ex);
            } catch (Exception ex1) {
                Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Elimina una palabra de la base de datos por su ID
     * @param id Identificador de la palabra a eliminar
     */
    @Override
    public void eliminarPalabra(int id)  {
        try {
            String sql = "DELETE FROM palabras WHERE id = ?;";
            PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Palabra eliminada correctamente.");
        } catch (SQLException ex) {
            try {
                throw new Exception("Error al eliminar palabra", ex);
            } catch (Exception ex1) {
                Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Obtiene una palabra aleatoria de la tabla word
     * @return Palabra aleatoria obtenida 
     */
    @Override
    public String obtenerWord()  {
         String word = "";
        try {
            ResultSet resultado = objConexion.getStatement().executeQuery("SELECT palabra FROM word ORDER BY RANDOM() LIMIT 1;");
            if (resultado.next()) {
                word = resultado.getString("palabra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex);
             try {
                 throw new Exception("Error al obtener palabra desordenada", ex);
             } catch (Exception ex1) {
                 Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex1);
             }
        }
        return word;
       
    }

    /**
     * Obtiene una oración y sus tres opciones de respuesta de forma aleatoria
     * @return Arreglo de Strings [oración, opción1, opción2, opción3, respuesta correcta]
     */
    @Override
    public String[] obtenerOracionBase() {
        String[] oracionConOpciones = new String[5]; 
        try {
            String sql = "SELECT oraciones, opcion1, opcion2, opcion3, opcion_correcta FROM Oracion ORDER BY RANDOM() LIMIT 1;";
            ResultSet resultado = objConexion.getStatement().executeQuery(sql);

            if (resultado.next()) {
                oracionConOpciones[0] = resultado.getString("oraciones");
                oracionConOpciones[1] = resultado.getString("opcion1");
                oracionConOpciones[2] = resultado.getString("opcion2");
                oracionConOpciones[3] = resultado.getString("opcion3");
                oracionConOpciones[4] = resultado.getString("opcion_correcta");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex);
            try {
                throw new Exception("Error al obtener la oraciones y opciones", ex);
            } catch (Exception ex1) {
                Logger.getLogger(ControlGestorPalabras.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return oracionConOpciones;
    }  
   
}