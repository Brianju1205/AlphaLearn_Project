/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Menu;
import vistas.Actividad_5;

/**
 *
 * @author almen
 */

public class ControlActividad5 extends AbstractSonido implements ActionListener {
    private Actividad_5 objActividad5;
    private ControlGestorPalabras palabrasDAO;
    private String seleccionUsuario = null;
    private boolean verificado= false;
    
    private String[] oracionActual;
    private String opcionCorrecta; 

    public ControlActividad5(Actividad_5 objActividad5) {
        this.objActividad5 = objActividad5;
        this.palabrasDAO = ControlGestorPalabras.getInstance();
        
      
        this.objActividad5.getjButton1_Salir_act_5().addActionListener(this);
        this.objActividad5.getjButton1_Cambiar_oracion().addActionListener(this);
      
        
      this.objActividad5.getjLabel_opcionUno().addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked (MouseEvent e){
              seleccionUsuario = objActividad5.getjLabel_opcionUno().getText();
              verificarRespuesta();
          }
          
      });
       this.objActividad5.getjLabel_palabraOpcionDos().addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked (MouseEvent e){
              seleccionUsuario = objActividad5.getjLabel_palabraOpcionDos().getText();
              verificarRespuesta();
          }
          
      });
        this.objActividad5.getjLabel_palabraOpcionTres().addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked (MouseEvent e){
              seleccionUsuario = objActividad5.getjLabel_palabraOpcionTres().getText();
              verificarRespuesta();
          }
          
      });
      
        cargarNuevaOracion();
    }
   
    
    private void cargarNuevaOracion() {
        try {
            verificado = false;
            oracionActual = palabrasDAO.obtenerOracionBase();
            
            objActividad5.getjLabel3_oracion().setText(oracionActual[0]);
            objActividad5.getjLabel3_oracion().setOpaque(true);
            objActividad5.getjLabel3_oracion().setBackground(new Color(255,255,204));
            objActividad5.getjLabel3_oracion().setForeground(new Color(0, 51, 102)); 
            objActividad5.getjLabel3_oracion().setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 2));
            
            objActividad5.getjLabel_opcionUno().setText(oracionActual[1]); // O
            objActividad5.getjLabel_palabraOpcionDos().setText(oracionActual[2]); //2
            objActividad5.getjLabel_palabraOpcionTres().setText(oracionActual[3]); // 3
            
          
            opcionCorrecta = oracionActual[4];
            seleccionUsuario = null;
         
            
        } catch (Exception ex) {
            Logger.getLogger(ControlActividad5.class.getName()).log(Level.SEVERE, null, ex);
            objActividad5.getjLabel3_oracion().setText("Error al cargar oración");
        }
    }

 
   
    private void verificarRespuesta() {
        if (verificado)return;
        
        if (seleccionUsuario == null) {
            //JOptionPane.showMessageDialog(objActividad5, "Por favor selecciona una palabra");
            return;
        }
        
        
        if (seleccionUsuario.equals(opcionCorrecta)) {
           // reproducirSonido("acierto.wav"); por si ponemos audios 
           verificado = true;
            objActividad5.getjLabel3_oracion().setBackground(new Color(204, 255, 204)); // color verde
           // JOptionPane.showMessageDialog(objActividad5, "Correcto, La respuesta es verdadera");
            cargarNuevaOracion();
        } else {
             objActividad5.getjLabel3_oracion().setBackground(new Color(255, 204, 204)); // color rojo
            //JOptionPane.showMessageDialog(objActividad5, "Incorrecto. Intenta nuevamente");
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == objActividad5.getjButton1_Salir_act_5()) {
            Menu m = new Menu();
            m.setVisible(true);
            objActividad5.dispose(); 
        } 
         else if (e.getSource() == objActividad5.getjButton1_Cambiar_oracion()) {
            cargarNuevaOracion();
        } 
    }
}