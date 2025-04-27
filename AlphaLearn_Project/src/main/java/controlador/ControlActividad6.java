/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import modelo.AjustesM;
import modelo.CuentoPregunta;
import vistas.Actividad_6;
import vistas.Menu;

/**
 *
 * @author juare
 */
public class ControlActividad6 extends AbstractSonido implements ActionListener{
    private Actividad_6 acti6;
    private CuentoPregunta conCuentos;
    private String seleccionUsuario;
    private Verificador v;
    public ControlActividad6(Actividad_6 acti6) {
        this.acti6 = acti6;
        v = Verificador.getInstancia();
        acti6.getjButton1_Salir_act_5().addActionListener(this);
        acti6.getjButton1_cambiartexto().addActionListener(this);
        acti6.getjButton_audio_pregunta().addActionListener(this);
        acti6.getjButton1_repetir_cuento().addActionListener(this);
        mostrarInstruccion();
         
    }
    private void mostrarInstruccion() {
        AjustesM ajustes = ControlGestorAjustes.getInstance().obtenerAjustes(v.getId());
        if (ajustes.isInstruccionesActivas()) {
            this.mostrarInstruccion(acti6.getjPanel1_fondo(), "/resource/imagenes/presentador.png", 410, 260);
            reproducirSonido("/resource/sounds/instruccion actividad6.wav");

            new javax.swing.Timer(18000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((javax.swing.Timer) e.getSource()).stop();
                    escuchadoresLabel();
                    asignarCuento();
                }
            }).start();

        } else {
            escuchadoresLabel();
            asignarCuento(); 
            System.out.println("instrucciones desactivadas");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == acti6.getjButton1_Salir_act_5() ){
            reproducirSonido("/resource/sounds/burbuja.wav");
            
            Menu m = new Menu();
            m.setVisible(true);
           
            if (acti6 != null) {
                stopSonido();
                acti6.dispose(); 
            }
        }
        if(e.getSource() ==acti6.getjButton1_cambiartexto()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            asignarCuento();
        }
        if(e.getSource() == acti6.getjButton_audio_pregunta()){
            String ruta = conCuentos.getPregunta().getRutaAudiop();
            reproducirSonido(ruta);
        }
        if(e.getSource() == acti6.getjButton1_repetir_cuento()){
            String ruta = conCuentos.getCuento().getRutaAudio();
            reproducirSonido(ruta);
        }
        
    }
    private void asignarCuento() {  
        conCuentos = ControlGestorCuentos.getInstance().obtenerCuentos();

            if (conCuentos != null) {
                acti6.getjLabel_texto().setText( "<html><body style='width: t00px'>"+ conCuentos.getCuento().getCuento() + "</body></html>");
                String ruta = conCuentos.getCuento().getRutaAudio();
                reproducirSonido(ruta);
                acti6.getjLabel_respuesta1().setText(conCuentos.getPregunta().getOpcion1());
                acti6.getjLabel_respuesta2().setText(conCuentos.getPregunta().getOpcion2());
                acti6.getjLabel_respuesta3().setText(conCuentos.getPregunta().getOpcion3());
                acti6.getjLabel_pregunta().setText(conCuentos.getPregunta().getPregunta());
                acti6.getjLabelTitulo().setText(conCuentos.getCuento().getTitulo());
            }
        
    }
    
    private void verificarRespuesta(){
        if(seleccionUsuario == null){
            return;
        }
        if(seleccionUsuario.equals(conCuentos.getPregunta().getRespuestaCorrecta())){
            reproducirSonido("/resource/sounds/cute.wav");
            System.out.println("respuesta correcta");
            asignarCuento();
        }
        else{
            reproducirSonido("/resource/sounds/errorr.wav");
            System.out.println("error");
        }
    }

    private void escuchadoresLabel(){
        
        this.acti6.getjLabel_respuesta1().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                reproducirSonido("/resource/sounds/burbuja.wav");
                seleccionUsuario = acti6.getjLabel_respuesta1().getText();
                verificarRespuesta();
            }

        });
        this.acti6.getjLabel_respuesta2().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                reproducirSonido("/resource/sounds/burbuja.wav");
                seleccionUsuario = acti6.getjLabel_respuesta2().getText();
                verificarRespuesta();
            }

        });
        this.acti6.getjLabel_respuesta3().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                reproducirSonido("/resource/sounds/burbuja.wav");
                seleccionUsuario = acti6.getjLabel_respuesta3().getText();
                verificarRespuesta();
            }

        });
    } 
}