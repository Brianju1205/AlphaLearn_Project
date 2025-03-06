/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
// del text

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Usuario;


/** 
 *
 * @author almengor
 */

public class Verificador {
    
    public boolean verificaCajaTextoCadena(javax.swing.JTextField cajaTexto){
       if(cajaTexto.getText().isBlank()){
            JOptionPane.showMessageDialog(null,"campo requerido" );
            return false;
        }
       return true;
   }
    public boolean verificaCajaTextoEntero(javax.swing.JTextField cajaTexto){
    if(cajaTexto.getText().isBlank()){
        JOptionPane.showMessageDialog(null, "Campo requerido");
        return false;
    }
   
    return true;
}

   public boolean existeUsuario(OperacionesBD operacionesBD, String nombre, String contra){
        Usuario usuario = operacionesBD.buscarUsuario(nombre, contra); 
        
       
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }
    
}
