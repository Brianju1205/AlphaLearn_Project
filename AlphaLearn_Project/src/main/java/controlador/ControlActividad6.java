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
 * Esta clase controla la actividad 6 que consiste en mostrar un texto para validar la comprension 
 * lectora del usuario mediante una pregunta que se le hace al finalizar la lectura del texto
 * 
 * Hereda de: AbstractSonido para reproducir los audios
 * Implementa: ActionListener para manejar acciones de botones
 * 
 * @author juare
 */
public class ControlActividad6 extends AbstractSonido implements ActionListener{
    private Actividad_6 acti6;                  // referencia a la vista actividad 6
    private CuentoPregunta conCuentos;          // referencia al modelo del cuento 
    private String seleccionUsuario;            // palabra que selecciono el usuario
    private Verificador v;                      // referencia a la clase verificador
    
    /**
     * Constructor de la actividad 6
     * @param acti6 
     */
    public ControlActividad6(Actividad_6 acti6) {
        this.acti6 = acti6;
        v = Verificador.getInstancia();
        acti6.getjButton1_Salir_act_5().addActionListener(this);
        acti6.getjButton1_cambiartexto().addActionListener(this);
        acti6.getjButton_audio_pregunta().addActionListener(this);
        acti6.getjButton1_repetir_cuento().addActionListener(this);
        mostrarInstruccion();
         
    }
    
    /**
     * Muestra la instrucción de la actividad si está habilitada en los ajustes
     * De no estar activa, pasa directamente a asignar los cuentos.
     */
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
    
     /**
     * Asigna un nuevo cuento y sus preguntas a la vista
     * También reproduce el audio correspondiente al cuento
     */
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
    
    /**
     * Verifica si la respuesta seleccionada por el usuario es correcta
     * Si es correcta, reproduce un sonido de acierto y asigna un nuevo cuento
     * Si es incorrecta, reproduce un sonido de error
     */
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

    /**
     * Asigna escuchadores de clic a los Jlabel de respuestas
     * Cada vez que el usuario haga clic en una opción, se verifica la respuesta
     */
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