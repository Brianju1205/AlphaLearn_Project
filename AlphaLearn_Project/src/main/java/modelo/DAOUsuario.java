/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

/**
 *
 * @author juare
 */
public interface DAOUsuario {
   public void crearUsuario() throws Exception;
   public Usuario buscarUsuario(String nombre, String password) throws Exception;
   public void actualizarUsuario(Usuario usuario) throws Exception;
   public void eliminarUsuario(String idUsuario) throws Exception;
   public void obtenerTodos() throws Exception;
}
