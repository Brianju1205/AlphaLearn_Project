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
 *
 * @author juare
 */

public class ControlGestorPalabras implements GestorPalabras {
    private Conexion objConexion;
    private static ControlGestorPalabras instancia; 

    private ControlGestorPalabras() {
        objConexion = Conexion.getInstance(); 
    }
    
    public static ControlGestorPalabras getInstance() {
        if (instancia == null) {
            instancia = new ControlGestorPalabras();
        }
        return instancia;
    }

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