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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vistas.Menu;
import vistas.Actividad_5;

/**
 * Esta actividad permite aprender a identificar las palabras que le hacen falta a las oraciones
 * 
 * Hereda de: AbstractSonido para reproducir los audios
 * Implementa: ActionListener para manejar acciones de botones
 * 
 * @author almen
 */

public class ControlActividad5 extends AbstractSonido implements ActionListener {
    private Actividad_5 objActividad5;          // referencia al la vista Actividad 5
    private ControlGestorPalabras palabrasDAO;  // referencia a la gestor palabrasDAO
    private String seleccionUsuario = null;     // palabra que selecciono el usuario
    private boolean verificado= false;          // bandera de verificado
    private int vidas=5;
    private JLabel[] corazones;
    private String[] oracionActual;             // oracion que se muestra al iniciar
    private String opcionCorrecta;              // palabra correcta

    /**
     * Constructo de actividad5
     * @param objActividad5 
     */
    public ControlActividad5(Actividad_5 objActividad5) {
        this.objActividad5 = objActividad5;
        this.palabrasDAO = ControlGestorPalabras.getInstance();
        
        this.objActividad5.getjButton1_Salir_act_5().addActionListener(this);
        this.objActividad5.getjButton1_Cambiar_oracion().addActionListener(this);
        
        this.corazones=new JLabel[]{
            objActividad5.getCorazon1(),
            objActividad5.getCorazon2(),
            objActividad5.getCorazon3(),
            objActividad5.getCorazon4(),
            objActividad5.getCorazon5(),
            
        };
        rutaimagen();
        
        //agregar escuchadores de los Jlabels
        escuchadoresJlabel();
        cargarNuevaOracion();
    }
   
    /**
     * Agregar listener para los clicks sobre los Jlabels
     */
    private void escuchadoresJlabel(){
        this.objActividad5.getjLabel_opcionUno().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                reproducirSonido("/resource/sounds/burbuja.wav");
                seleccionUsuario = objActividad5.getjLabel_opcionUno().getText();
                verificarRespuesta();
            }

        });
         this.objActividad5.getjLabel_palabraOpcionDos().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                reproducirSonido("/resource/sounds/burbuja.wav");
                seleccionUsuario = objActividad5.getjLabel_palabraOpcionDos().getText();
                verificarRespuesta();
            }

        });
        this.objActividad5.getjLabel_palabraOpcionTres().addMouseListener(new MouseAdapter(){
          @Override
          public void mouseClicked (MouseEvent e){
              reproducirSonido("/resource/sounds/burbuja.wav");
              seleccionUsuario = objActividad5.getjLabel_palabraOpcionTres().getText();
              verificarRespuesta();
          }
          
        });
    }
    
    /**
     * Método para cargar una nueva oración
     * Se obtienen nuevas palabras y se actualiza la vista
     */
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

    /**
     * Método privado para verificar si la selección del usuario es correcta
     */
    private void verificarRespuesta() {
        if (verificado)return; 
        
        if (seleccionUsuario == null) {
            //JOptionPane.showMessageDialog(objActividad5, "Por favor selecciona una palabra");
            return;
        }
        
        if (seleccionUsuario.equals(opcionCorrecta)) {
            reproducirSonido("/resource/sounds/correct.wav");
           // reproducirSonido("acierto.wav"); por si ponemos audios 
           verificado = true;
            objActividad5.getjLabel3_oracion().setBackground(new Color(204, 255, 204)); // color verde
           // JOptionPane.showMessageDialog(objActividad5, "Correcto, La respuesta es verdadera");
            cargarNuevaOracion();
        } else {
             reproducirSonido("/resource/sounds/errorr.wav");
             objActividad5.getjLabel3_oracion().setBackground(new Color(255, 204, 204)); // color rojo
            //JOptionPane.showMessageDialog(objActividad5, "Incorrecto. Intenta nuevamente");
            vidas--;
            actualizarCorazones();
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == objActividad5.getjButton1_Salir_act_5()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            /*Menu m = new Menu();
            m.setVisible(true);
            objActividad5.dispose(); */
            ControlDialogSalir cD = new ControlDialogSalir(objActividad5);
            cD.mostrarDialogo(); 

                if (cD.isSalirConfirmado()) {
                    stopSonido();
                    objActividad5.dispose(); 
                    Menu m = new Menu();
                    m.setVisible(true);     
                }
        } 
         else if (e.getSource() == objActividad5.getjButton1_Cambiar_oracion()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            cargarNuevaOracion(); // cargar una nueva oración
        } 
    }
    
    
    
    private void rutaimagen() {
        for (JLabel corazon : corazones) {
            corazon.setIcon(new ImageIcon(getClass().getResource("/resource/CORAZON.png"))); // Ruta correcta de la imagen
            corazon.setVisible(true);
        }
        vidas = 5; 
    }
    
    
    private void actualizarCorazones() {
    if (vidas >= 0 && vidas < corazones.length) {
        corazones[vidas].setVisible(false); 
    }

    if (vidas <= 0) {
       ControlDialogSInIntentos obj = new  ControlDialogSInIntentos(objActividad5);
       obj.mostrarDialogo();
       
       if(obj.isReintenar()){
           cargarNuevaOracion();
           resetearCorazones();
       }else{
           objActividad5.dispose();
           Menu m = new Menu();
           m.setVisible(true);
       }
         
    }
}

    private void resetearCorazones() {
    vidas = 5; 
         for (JLabel corazon : corazones) {
             corazon.setIcon(new ImageIcon(getClass().getResource("/resource/CORAZON.png"))); 
             corazon.setVisible(true); 
         }
    }
    
}