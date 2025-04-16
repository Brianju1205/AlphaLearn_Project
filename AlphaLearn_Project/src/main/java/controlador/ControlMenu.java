/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import vistas.Actividad_1;
import vistas.Actividad_2;
import vistas.Actividad_3;
import vistas.Actividad_4;
import vistas.Actividad_5;
import vistas.Actividad_6;
import vistas.Menu;
import vistas.Menu_Actividades;
import vistas.Ajustes;
import vistas.Perfil;

/**
 *
 * @author juare
 */
public class ControlMenu extends AbstractSonido implements ActionListener{
    
    Menu objMenu;
    Menu_Actividades objMenuAc;
    Verificador v;
    public ControlMenu(Menu objMenu,Menu_Actividades objMenuAc ) {
        FlatLightLaf.setup();
        
        this.objMenu = objMenu;
        
        this.objMenuAc = objMenuAc;
        v = Verificador.getInstancia();
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        
        this.objMenuAc.getjButton_Actividad1().addActionListener(this);
        this.objMenuAc.getjButton_Actividad2().addActionListener(this);
        this.objMenuAc.getjButton_Actividad3().addActionListener(this);
        this.objMenuAc.getjButton_Actividad4().addActionListener(this);
        this.objMenuAc.getjButton_Actividad5().addActionListener(this);
        this.objMenuAc.getjButton_Actividad6().addActionListener(this);
        this.objMenu.getjButton5_Salir_Menu().addActionListener(this);
        this.objMenu.getjButton1_inicio().addActionListener(this);
        this.objMenu.getjButton2_ajustes().addActionListener(this);
        this.objMenu.getjButton3_ayuda().addActionListener(this);
        this.initContent();
        
        this.objMenu.getjLabel2_Bienvenida().setText("Bienvenido ");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.objMenuAc.getjButton_Actividad1()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_1 a = new Actividad_1();
            a.setVisible(true);
            if (objMenu != null) {
            
            objMenu.dispose(); 
            }
        }
        if(e.getSource() ==  this.objMenuAc.getjButton_Actividad2()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_2 a =new Actividad_2();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad3()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_3 a= new Actividad_3();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad4()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_4 a=new Actividad_4();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad5()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_5 a=new Actividad_5();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }     
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad6()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_6 a=new Actividad_6();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }  
        }
        if(e.getSource() == this.objMenu.getjButton5_Salir_Menu()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            if (objMenu != null) {  
            
            objMenu.dispose(); 
            }
            if(this.v.getNom()== null){
                System.out.println("no hay usuario");
                return;
            }
            else{
                int tiempoTotal = (int) TiempoActivo.getInstancia().getTiempoActivo();
                ControlGestorTiempo.getInstancia().guardarTiempo(v.getId(),tiempoTotal);
            }
        }
        if (e.getSource() == this.objMenu.getjButton1_inicio()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            panel(objMenuAc);
            
        }
        if (e.getSource() == this.objMenu.getjButton2_ajustes()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            panel(new Ajustes());
        }
        if (e.getSource() == this.objMenu.getjButton3_ayuda()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            panel(new Perfil());
        }
        

    }
    private void initContent(){
        panel(objMenuAc);
    }
    
    private void panel(JPanel p){
       
        p.setSize( 920, 540);
        p.setLocation(0, 0);
        objMenu.getjPanel_Contenido().removeAll();
        objMenu.getjPanel_Contenido().add(p, BorderLayout.CENTER);
        objMenu.getjPanel_Contenido().revalidate();
        objMenu.getjPanel_Contenido().repaint();
    }
   

}
