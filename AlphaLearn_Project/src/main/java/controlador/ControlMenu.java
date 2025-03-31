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
import vistas.Menu;
import vistas.Menu_Actividades;
import vistas.Ajustes;
import vistas.Perfil;

/**
 *
 * @author juare
 */
public class ControlMenu implements ActionListener{
    
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
        
        this.objMenu.getjLabel2_Bienvenida().setText("Bienvenido, " + this.v.getNom());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.objMenuAc.getjButton_Actividad1()){
            
            Actividad_1 a = new Actividad_1();
            a.setVisible(true);
            if (objMenu != null) {
            
            objMenu.dispose(); 
            }
        }
        if(e.getSource() ==  this.objMenuAc.getjButton_Actividad2()){
            Actividad_2 a =new Actividad_2();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad3()){
            Actividad_3 a= new Actividad_3();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad4()){
            Actividad_4 a=new Actividad_4();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad5()){
                 
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad6()){
            
        }
        if(e.getSource() == this.objMenu.getjButton5_Salir_Menu()){
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
            panel(objMenuAc);
            
        }
        if (e.getSource() == this.objMenu.getjButton2_ajustes()) {
            panel(new Ajustes());
        }
        if (e.getSource() == this.objMenu.getjButton3_ayuda()) {
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
