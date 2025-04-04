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
import javax.swing.JOptionPane;

/**
 *
 * @author almen
 */

public class ControlActividad4 extends AbstractSonido implements ActionListener  {
    private Actividad_4 objActividad4;
    private Verificador v;
    private ControlGestorPalabras palabrasDAO;
    private String[]palabras; 
    private String palabraCorrecta;
    private boolean audioReproducido = false;
    private String seleccionUsuario =null;
    public ControlActividad4(Actividad_4 objActividad4) {
        this.objActividad4 = objActividad4;
        this.objActividad4.getjButton1_Salir_act_5().addActionListener(this);
        this.objActividad4.getjButton1_Vericicar_palabra_correcta().addActionListener(this);
        this.objActividad4.getjButton1_audio_palabra().addActionListener(this);
        
        
        this.objActividad4.getjButton1_opcionUno().addActionListener(this);
        this.objActividad4.getjButton2_opcionDos().addActionListener(this);
        this.objActividad4.getjButton3_opcionTres().addActionListener(this);
        this.objActividad4.getjButton1_Cambiar_audio_palabra().addActionListener(this);
        v = Verificador.getInstancia();
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        this.palabrasDAO = ControlGestorPalabras.getInstance();
        
        asignarPalabraAJLabels();
        seleccionarPalabraCorrecta();
        System.out.println("as");
        System.out.println("af");
        
    }
    
      
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.objActividad4.getjButton1_Salir_act_5()){
            Menu m = new Menu();
            m.setVisible(true);
            //stopSonido();
            if (objActividad4 != null) {   
                objActividad4.dispose(); 
            }
            if(this.v.getNom()== null){
                System.out.println("no hay usuario");
                return;
                }
            else{
                int tiempoTotal = (int) TiempoActivo.getInstancia().getTiempoActivo();
                ControlGestorTiempo.getInstancia().guardarTiempo(v.getId(),tiempoTotal);
            }
       }else if (e.getSource() ==this.objActividad4.getjButton1_audio_palabra()){
           reproducirAudio(palabraCorrecta);
           audioReproducido= true;
       }
       else if (e.getSource() == this.objActividad4.getjButton1_Vericicar_palabra_correcta()){
           verificarSeleccion();
       }
       else if (e.getSource() == this.objActividad4.getjButton1_Cambiar_audio_palabra()){
           asignarPalabraAJLabels(); 
           seleccionarPalabraCorrecta(); 
           reproducirAudio(palabraCorrecta); 
           System.out.println("Nueva palabra correcta: " + palabraCorrecta);
       }
       else if (e.getSource() ==this.objActividad4.getjButton1_opcionUno()){
           seleccionUsuario = objActividad4.getjLabel_word1().getText();
       }
       else if (e.getSource() ==this.objActividad4.getjButton2_opcionDos()){
           seleccionUsuario = objActividad4.getjLabel_word2().getText();
       }
       else if (e.getSource() ==this.objActividad4.getjButton3_opcionTres()){
           seleccionUsuario = objActividad4.getjLabel_word3().getText();
       }
    }

    private void asignarPalabraAJLabels() {
        try {
          
            palabras = new String[3];
            palabras[0] = palabrasDAO.obtenerWord(); 
            palabras[1] = palabrasDAO.obtenerWord(); 
            palabras[2] = palabrasDAO.obtenerWord(); 
            
            JLabel[] labels = {
                objActividad4.getjLabel_word1(),
                objActividad4.getjLabel_word2(),
                objActividad4.getjLabel_word3(),
                
            };

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
  
    private void seleccionarPalabraCorrecta() {
        int indiceAleatorio = (int) (Math.random()*palabras.length);
        palabraCorrecta=palabras[indiceAleatorio];
        System.out.println("palabra correcta: "+palabraCorrecta);
    }
    
    private void reproducirAudio(String palabraCorrecta) {
        String rutaAudio = "/resource/sounds/" + palabraCorrecta + ".wav"; 
        reproducirSonido(rutaAudio);
    }

    private void verificarSeleccion() {
        if(!audioReproducido || seleccionUsuario==null){
            reproducirSonido("/resource/sounds/audioUno.wav");
            JOptionPane.showMessageDialog(null,"Escucha el audio antes de seleccionar");
            return;
        } 
   
        if (seleccionUsuario.equals(palabraCorrecta)) {
             reproducirSonido("/resource/sounds/muy_bien.wav");
            JOptionPane.showMessageDialog(null, "Correcto La palabra era: " + palabraCorrecta);
        } else {
             reproducirSonido("/resource/sounds/incorrecto.wav");
            JOptionPane.showMessageDialog(null, "Incorrecto. La palabra correcta era: " + palabraCorrecta);
        }
    
    }

    private String obtenerSeleccionUsuario() {
       
        if (objActividad4.getjButton1_opcionUno().isSelected()) {
            return objActividad4.getjLabel_word1().getText();
        } else if (objActividad4.getjButton2_opcionDos().isSelected()) {
            return objActividad4.getjLabel_word2().getText();
        } else if (objActividad4.getjButton3_opcionTres().isSelected()){
            return objActividad4.getjLabel_word3().getText();
        }
        return seleccionUsuario;
    }

}