/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import vistas.Abecedario;
import vistas.Actividad_1;
import vistas.Menu;

/**
 *
 * @author juare
 */
public class ControlActividad1 implements ActionListener {
    Actividad_1 objActividad;
    Abecedario objAbc;
    Clip clip;
    public ControlActividad1(Actividad_1 objActividad,Abecedario objAbc) {
        this.objActividad = objActividad;
        this.objAbc = objAbc;
        /*this.objActividad.getjButton_A().addActionListener(this);
        this.objActividad.getjButton_B().addActionListener(this);
        this.objActividad.getjButton_C().addActionListener(this);
        this.objActividad.getjButton4_D().addActionListener(this);
        this.objActividad.getjButton5_E().addActionListener(this);
        this.objActividad.getjButton6_F().addActionListener(this);
        this.objActividad.getjButton7_G().addActionListener(this);
        this.objActividad.getjButton8_H().addActionListener(this);
        this.objActividad.getjButton9_I().addActionListener(this);
        this.objActividad.getjButton10_J().addActionListener(this);
        this.objActividad.getjButton11_K().addActionListener(this);
        this.objActividad.getjButton12_L().addActionListener(this);
        this.objActividad.getjButton13_M().addActionListener(this);
        this.objActividad.getjButton14_N().addActionListener(this);
        this.objActividad.getjButton15_Ñ().addActionListener(this);
        this.objActividad.getjButton16_O().addActionListener(this);
        this.objActividad.getjButton17_P().addActionListener(this);
        this.objActividad.getjButton18_Q().addActionListener(this);
        this.objActividad.getjButton19_R().addActionListener(this);
        this.objActividad.getjButton20_S().addActionListener(this);
        this.objActividad.getjButton22_U().addActionListener(this);
        this.objActividad.getjButton21_T().addActionListener(this);
        this.objActividad.getjButton25_V().addActionListener(this);
        this.objActividad.getjButton26_W().addActionListener(this);
        this.objActividad.getjButton23_X().addActionListener(this);
        this.objActividad.getjButton24_Y().addActionListener(this);
        this.objActividad.getjButton1_Z().addActionListener(this);
        this.objActividad.getjButton1_Salir_act_1().addActionListener(this);*/
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
                clip.stop();
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
           
           
            /* if (e.getSource() == this.objActividad.getjButton_A()) {
            reproducirSonido("/resource/sounds/a.wav");
        } else if (e.getSource() == this.objActividad.getjButton_B()) {
            reproducirSonido("/resource/sounds/b.wav");
        } else if (e.getSource() == this.objActividad.getjButton_C()) {
            reproducirSonido("/resource/sounds/c.wav");
        } else if (e.getSource() == this.objActividad.getjButton4_D()) {
            reproducirSonido("/resource/sounds/d.wav");
        } else if (e.getSource() == this.objActividad.getjButton5_E()) {
            reproducirSonido("/resource/sounds/e.wav");
        } else if (e.getSource() == this.objActividad.getjButton6_F()) {
            reproducirSonido("/resource/sounds/f.wav");
        } else if (e.getSource() == this.objActividad.getjButton7_G()) {
            reproducirSonido("/resource/sounds/g.wav");
        } else if (e.getSource() == this.objActividad.getjButton8_H()) {
            reproducirSonido("/resource/sounds/h.wav");
        } else if (e.getSource() == this.objActividad.getjButton9_I()) {
            reproducirSonido("/resource/sounds/i.wav");
        } else if (e.getSource() == this.objActividad.getjButton10_J()) {
            reproducirSonido("/resource/sounds/j.wav");
        } else if (e.getSource() == this.objActividad.getjButton11_K()) {
            reproducirSonido("/resource/sounds/k.wav");
        } else if (e.getSource() == this.objActividad.getjButton12_L()) {
            reproducirSonido("/resource/sounds/l.wav");
        } else if (e.getSource() == this.objActividad.getjButton13_M()) {
            reproducirSonido("/resource/sounds/m.wav");
        } else if (e.getSource() == this.objActividad.getjButton14_N()) {
            reproducirSonido("/resource/sounds/n.wav");
        } else if (e.getSource() == this.objActividad.getjButton15_Ñ()) {
            reproducirSonido("/resource/sounds/ñ.wav");
        } else if (e.getSource() == this.objActividad.getjButton16_O()) {
            reproducirSonido("/resource/sounds/o.wav");
        } else if (e.getSource() == this.objActividad.getjButton17_P()) {
            reproducirSonido("/resource/sounds/p.wav");
        } else if (e.getSource() == this.objActividad.getjButton18_Q()) {
            reproducirSonido("/resource/sounds/q.wav");
        } else if (e.getSource() == this.objActividad.getjButton19_R()) {
            reproducirSonido("/resource/sounds/r.wav");
        } else if (e.getSource() == this.objActividad.getjButton20_S()) {
            reproducirSonido("/resource/sounds/s.wav");
        } else if (e.getSource() == this.objActividad.getjButton21_T()) {
            reproducirSonido("/resource/sounds/t.wav");
        } else if (e.getSource() == this.objActividad.getjButton22_U()){
            reproducirSonido("/resource/sounds/u.wav");
        }else if (e.getSource() == this.objActividad.getjButton25_V()) {
            reproducirSonido("/resource/sounds/v.wav");
        } else if (e.getSource() == this.objActividad.getjButton26_W()) {
            reproducirSonido("/resource/sounds/w.wav");
        } else if (e.getSource() == this.objActividad.getjButton23_X()) {
            reproducirSonido("/resource/sounds/x.wav");
        } else if (e.getSource() == this.objActividad.getjButton24_Y()) {
            reproducirSonido("/resource/sounds/y.wav");
        } else if (e.getSource() == this.objActividad.getjButton1_Z()) {
            reproducirSonido("/resource/sounds/z.wav");
        }*/
        
    }
    private void reproducirSonido(String ruta) {
        
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }
            URL url = getClass().getResource(ruta);
            if (url == null) {
                System.err.println("No se encontro el archivo: " + ruta);
                return;
            }
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
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
