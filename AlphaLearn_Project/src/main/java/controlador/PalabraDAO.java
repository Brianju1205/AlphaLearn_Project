/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DAOPalabra;
import modelo.Imagen;
import modelo.Palabra;

/**
 *
 * @author juare
 */

public class PalabraDAO implements DAOPalabra {
    private Conexion objConexion;
    private static PalabraDAO instancia; 

    private PalabraDAO() {
        objConexion = Conexion.getInstance(); 
    }
    
    public static PalabraDAO getInstance() {
        if (instancia == null) {
            instancia = new PalabraDAO();
        }
        return instancia;
    }

    @Override
    public String obtenerPalabraDesordenada() throws Exception {
        String palabra = "";
        try {
            ResultSet resultado = objConexion.getStatement().executeQuery("SELECT palabra FROM palabras ORDER BY RANDOM() LIMIT 1;");
            if (resultado.next()) {
                palabra = resultado.getString("palabra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PalabraDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Error al obtener palabra desordenada", ex);
        }
        return palabra;
    }

    @Override
    public Palabra obtenerPalabraConImagenAleatoria() throws Exception {
        Palabra palabra = null;
        try {
            String sql = "SELECT p.id AS palabra_id, p.palabra, i.id AS imagen_id, i.ruta " +
                         "FROM palabras p " +
                         "JOIN imagenes i ON p.id = i.palabra_id " +
                         "ORDER BY RANDOM() LIMIT 1;";
            ResultSet resultado = objConexion.getStatement().executeQuery(sql);

            if (resultado.next()) {
                palabra = new Palabra();
                palabra.setId(resultado.getInt("palabra_id"));
                palabra.setPalabra(resultado.getString("palabra"));

                Imagen imagen = new Imagen();
                imagen.setId(resultado.getInt("imagen_id"));
                imagen.setRuta(resultado.getString("ruta"));
                imagen.setPalabraId(resultado.getInt("palabra_id"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PalabraDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Error al obtener palabra con imagen", ex);
        }
        return palabra;
    }

    @Override
    public void agregarPalabra(Palabra palabra) throws Exception {
        try {
            String sql = "INSERT INTO palabras (palabra) VALUES (?);";
            PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql);
            stmt.setString(1, palabra.getPalabra());
            stmt.executeUpdate();
            System.out.println("Palabra agregada correctamente.");
        } catch (SQLException ex) {
            throw new Exception("Error al agregar palabra", ex);
        }
    }

    @Override
    public void eliminarPalabra(int id) throws Exception {
        try {
            String sql = "DELETE FROM palabras WHERE id = ?;";
            PreparedStatement stmt = objConexion.getConnection().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Palabra eliminada correctamente.");
        } catch (SQLException ex) {
            throw new Exception("Error al eliminar palabra", ex);
        }
    }
}