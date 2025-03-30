/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import vistas.Abecedario;
import vistas.Actividad_1;
import vistas.Menu;

/**
 *
 * @author juare
 */
public class ControlActividad1 extends AbstractSonido implements ActionListener {
    Actividad_1 objActividad;
    Abecedario objAbc;
    
    public ControlActividad1(Actividad_1 objActividad,Abecedario objAbc) {
        this.objActividad = objActividad;
        this.objAbc = objAbc;
        TiempoActivo.getInstancia().iniciarContador();
        colocarEscuchadores();
        colocarEscuchadores2();
        reproducirSonido("/resource/sounds/indicaciones.wav");
        initContent();
        
    }
    
   private void colocarEscuchadores(){
       // = this.objActividad.jPanel_Actividad_1.getComponents();
       for(Object obj: this.objActividad.jPanel_Actividad_1.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
   }
    private void colocarEscuchadores2(){
       // = this.objActividad.jPanel_Actividad_1.getComponents();
       for(Object obj: objAbc.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
   }
    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource() == this.objActividad.getjButton1_Salir_act_1()){
                Menu m = new Menu();
                m.setVisible(true);
                 long tiempoTotal = TiempoActivo.getInstancia().getTiempoActivo();
                System.out.println("Tiempo total activo: " + tiempoTotal + " segundos");
                stopSonido();
                if (objActividad != null) {
               
                objActividad.dispose(); 
                }
            }
           JButton bt = (JButton)e.getSource();
           if(bt.getName().equals("siguiente") || bt.getName().equals("salir")){
               return;
           }
           
           String ruta = "/resource/sounds/"+bt.getName()+".wav";
           reproducirSonido(ruta);
        
    }

    private void initContent(){
        panel(objAbc);
    }
    private void panel(JPanel p){
        
        p.setSize( 807, 470);
        p.setLocation(0, 0);
        objActividad.getjPanel1_Abecedario().removeAll();
        objActividad.getjPanel1_Abecedario().add(p, BorderLayout.CENTER);
        objActividad.getjPanel1_Abecedario().revalidate();
        objActividad.getjPanel1_Abecedario().repaint();
    }
    
    
}
