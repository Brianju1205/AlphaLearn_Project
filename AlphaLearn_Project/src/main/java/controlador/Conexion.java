/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author almen
 */

public class Conexion {
    private static Conexion instanciaUnica; 
    private Connection connection;
    private Statement stmt;

    private static final String URL = "jdbc:postgresql://127.0.0.1/alphalearn";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    
    private Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = connection.createStatement();
            System.out.println("Conexionn establecida con exito.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
    }

    public static Conexion getInstance() {
        if (instanciaUnica == null) {
            synchronized (Conexion.class) { 
                if (instanciaUnica == null) {
                    instanciaUnica = new Conexion();
                }
            }
        }
        return instanciaUnica;
    }

  
    public Connection getConnection() {
        return connection;
    }

   
    public Statement getStatement() {
        return stmt;
    }

   
    public void cerrarConexion() {
        try {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
            System.out.println("Conexion cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstance();
        System.out.println(conexion.getConnection() != null ? "Conexión activa" : "Conexión fallida");
        conexion.cerrarConexion();
    }
    
}
