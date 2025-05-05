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
 * Esta clase implementa el patrón Singleton para gestionar una única conexión
 * a una base de datos PostgreSQL, Permite obtener la conexión y cerrar la conexión.
 * 
 * @Autor almen
 */
public class Conexion {
    
    // Instancia única de la clase
    private static Conexion instanciaUnica; 
    
    // Objeto de conexión a la base de datos
    private Connection connection;
    
    // Objeto para ejecutar sentencias
    Statement stmt;

    private static final String URL = "jdbc:postgresql://127.0.0.1/alphalearn";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2005";

    /**
     * Constructor privado para evitar instancias no deseadas
     * Establece la conexión con la base de datos.
     */
    private Conexion() {
        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // Crear el objeto para ejecutar sentencias
            stmt = connection.createStatement();
            System.out.println("Conexión establecida con éxito.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
        }
    }

    /**
     * Método estático para obtener la instancia única de la conexión.
     * Si no hay instancia la crea.
     * @return instancia única de Conexion
     */
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

    /**
     * Obtiene la conexión activa a la base de datos.
     * 
     * @return objeto Connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Obtiene el objeto Statement para ejecutar consultas
     * 
     * @return objeto Statement
     */
    public Statement getStatement() {
        return stmt;
    }

    /**
     * Cierra la conexión y el objeto de sentencias.
     */
    public void cerrarConexion() {
        try {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    /**
     * Main de la clase 
     * @param args 
     */
    public static void main(String[] args) {
        Conexion conexion = Conexion.getInstance();
        System.out.println(conexion.getConnection() != null ? "Conexión activa" : "Conexión fallida");
        conexion.cerrarConexion();
    }
}
