/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import vistas.Actividad_4;
import vistas.Menu;
import controlador.ControlGestorPalabras;

/**
 *
 * @author almen
 */

public class controladorActividad4 implements ActionListener  {
Actividad_4 objActividad4;
 private ControlGestorPalabras palabrasDAO;

    public controladorActividad4(Actividad_4 objActividad4) {
        this.objActividad4 = objActividad4;
        
        this.objActividad4.getjButton1_Salir_act_5().addActionListener(this);
        this.palabrasDAO = ControlGestorPalabras.getInstance();
        
        asignarPalabraAJLabels();
         
    }

        
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.objActividad4.getjButton1_Salir_act_5()){
              Menu m = new Menu();
              m.setVisible(true);
              if (objActividad4 != null) {   
                objActividad4.dispose(); 
                }
       }
    }

    private void asignarPalabraAJLabels() {
        try {
          
            String[] palabras = new String[3];
            palabras[0] = palabrasDAO.obtenerWord(); 
            palabras[1] = palabrasDAO.obtenerWord(); 
            palabras[2] = palabrasDAO.obtenerWord(); 

            
            JLabel[] labels = {
                objActividad4.getjLabel_word1(),
                objActividad4.getjLabel_word2(),
                objActividad4.getjLabel_word3(),
                
            };

            // Asignar cada palabra al que le pertenece
            for (int i = 0; i < labels.length; i++) {
                if (i < palabras.length) {
                    labels[i].setText(palabras[i]); 
                } else {
                    labels[i].setText(""); 
                }
            }
        } catch (Exception ex) {
            
            System.err.println("Error al obtener las palabras: " + ex.getMessage());
        }
    }
  
}
