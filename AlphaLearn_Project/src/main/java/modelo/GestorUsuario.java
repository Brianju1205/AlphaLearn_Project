/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 * Interfaz que define las operaciones básicas de gestión de usuarios en el sistema
 * incluyendo creación, búsqueda, actualización, eliminación y manejo del historial de actividades
 * 
 * @author juare
 */
public interface GestorUsuario {
   public void crearUsuario() throws Exception;
   public Usuario buscarUsuario(String nombre, String password) throws Exception;
   public void actualizarUsuario(Usuario usuario) throws Exception;
   public void eliminarUsuario(String idUsuario) throws Exception;
   public void obtenerTodos() throws Exception;
   public void guardarHistorial(int usuarioId, String palabra, int aciertos) throws Exception;
}
