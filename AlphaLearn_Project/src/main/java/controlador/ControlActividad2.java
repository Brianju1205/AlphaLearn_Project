/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.*;
import modelo.AjustesM;
import vistas.Actividad_2;
import vistas.Menu;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import utils.RotatableRoundedLabel;
import utils.UtilidadesUI;
import static utils.UtilidadesUI.escalarYAsignar;

/**
 *
 * @author almen
 */
public class ControlActividad2 extends AbstractSonido implements ActionListener {
    private Clip clip;                          // manejo de los sonidos
    private int poaX, poaY;                     // posicion del mause al presionar una letra
    private Actividad_2 objActividad5;          // referencia de la vista principal
    private ControlGestorPalabras palabrasDAO;  // referencua controlador del gestor palabras
    private String palabraActual;               // palabra que debe de ordenarse
    private int respuestaCorrectas=0;
    private int respuestasMalas=0;
    private Verificador v;                      // referencia del verificador
    private UsuarioDAO usuarioDAO;              // referencia para manejar el gestor de usuarios
    private Point posicionOriginal;             //´posicion inicial de las letras
    private Point[] coordenadasEspecificas = {
        new Point(560, 160), 
        new Point(660, 160),
        new Point(760, 160),
        new Point(860, 160), 
        new Point(960, 160),
        new Point(1060, 160)
    };
    
    private JLabel[] labelsOrigen;               // Letras que seran arrastrada  
    /**
     * Constructor Actividad 2
     * @param objActividad5 objeto Actividad 2
     */
    public ControlActividad2(Actividad_2 objActividad5) {
        this.objActividad5 = objActividad5;
        this.v = Verificador.getInstancia();
        System.out.println("El id es: " + v.getId() + ", nombre es: " + v.getNom());
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        //this.objOperacionesBD = OperacionesBD.getInstance();
        this.palabrasDAO = ControlGestorPalabras.getInstance();
        this.usuarioDAO = UsuarioDAO.getInstance();
        try {
            palabraActual = palabrasDAO.obtenerPalabraDesordenada();
        } catch (Exception ex) {
            Logger.getLogger(ControlActividad2.class.getName()).log(Level.SEVERE, null, ex);
        }
        //palabraActual = objOperacionesBD.obtenerPalabraDesordenada();
        if (palabraActual != null && !palabraActual.isEmpty()) {
            asignarLetrasAJLabels(palabraActual);
        }
        //escalarYAsignar(objActividad5.getjButton1_Cambiar_Palabra(),"/resource/arrows.png");
        configuracionInicio();
        mostrarInstruccion();
        
    }
    /**
     * Configuracion inicial de la vista 
     */
    private void configuracionInicio(){
        objActividad5.getjPanel1().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        this.objActividad5.getjButton1_Salir_act_5().addActionListener(this);
        this.objActividad5.getjButton1_Vericicar_respuesta().addActionListener(this);
        this.objActividad5.getjButton1_Cambiar_Palabra().addActionListener(this);
        this.objActividad5.getjButton1_instrucciones().addActionListener(this);
        this.objActividad5.getjButton1_Repetir_PalabraAudio().addActionListener(this);
        //reproducirSonido("/resource/sounds/intro.wav");
        //UtilidadesUI.escalarYAsignar(this.objActividad5.getjButton1_Repetir_PalabraAudio(), "/resource/ltavoz.png");
    }
    
    /**
     * Mostrar instruccion si esta habilitada en ajustes
     */
    private void mostrarInstruccion(){
       AjustesM ajustes = ControlGestorAjustes.getInstance().obtenerAjustes(v.getId());
        if(ajustes.isInstruccionesActivas()){
           this.mostrarInstruccion(objActividad5.getjPanel1(), "/resource/imagenes/presentador.png",870,380);
           reproducirSonido("/resource/sounds/modulo2.wav");
        }
        else{
            System.out.println("instrucciones desactivadas");
        }
    }
    
     /**
     * Asigna las letras desordenadas de la palabra a los labels de origen en la vista
     * @param palabra palabra original a mostrar desordenada
     */
    private void asignarLetrasAJLabels(String palabra) {
        palabra = mezclarPalabra(palabra);
        labelsOrigen = new JLabel[]{
            objActividad5.getjLabel3(),
            objActividad5.getjLabel4(),
            objActividad5.getjLabel5(),
            objActividad5.getjLabel6(),
            objActividad5.getjLabel7(),
            objActividad5.getjLabel8()
        };
        
        for (Component comp : objActividad5.getjPanel1().getComponents()) {
            if (comp instanceof RotatableRoundedLabel) {
                objActividad5.getjPanel1().remove(comp);
            }
        }
        objActividad5.getjPanel1().revalidate();
        objActividad5.getjPanel1().repaint();

        //objActividad5.getjLabel9_fondo1().removeAll();
        for (int i = 0; i < palabra.length(); i++) {
            if (i < labelsOrigen.length) {
                //labelsOrigen[i].setSize(150, 150);
                labelsOrigen[i].setVisible(false);
                labelsOrigen[i] = new RotatableRoundedLabel(String.valueOf(palabra.charAt(i)),0, 50);
                labelsOrigen[i].setOpaque(true);
                labelsOrigen[i].setSize(90, 120);
                //labelsOrigen[i] = new RotatableLabel(String.valueOf(palabra.charAt(i)), 45);
               /* labelsOrigen[i].setBorder(new RoundedBorder(50));
                labelsOrigen[i].setText(String.valueOf(palabra.charAt(i)));*/
                labelsOrigen[i].setLocation(coordenadasEspecificas[i]); 
               /* labelsOrigen[i].setForeground(Color.BLUE);
                labelsOrigen[i].setOpaque(true);
                labelsOrigen[i].setBackground(Color.WHITE);*/

                
                //labelsOrigen[i].setOpaque(true);
                //labelsOrigen[i].setSize(90,120); 
                // Usar AbsoluteConstraints al agregar el label al panel
                AbsoluteConstraints constraints = new AbsoluteConstraints(
                    coordenadasEspecificas[i].x, 
                    coordenadasEspecificas[i].y, 
                    labelsOrigen[i].getWidth(), 
                    labelsOrigen[i].getHeight()
                );
                //objActividad5.getjPanel1().add(labelsOrigen[i], constraints); // Esto sirve para agregar los label al panel forzadamente 
                objActividad5.getjPanel1().add(labelsOrigen[i], constraints);
                objActividad5.getjPanel1().setComponentZOrder(labelsOrigen[i], 0);
                for (MouseListener listener : labelsOrigen[i].getMouseListeners()) {
                    labelsOrigen[i].removeMouseListener(listener);
                }
                for (MouseMotionListener listener : labelsOrigen[i].getMouseMotionListeners()) {
                    labelsOrigen[i].removeMouseMotionListener(listener);
                }

              
                agregarEventosArrastre(labelsOrigen[i], coordenadasEspecificas[i]);
            }
        }
        
       //
        objActividad5.getjPanel1().revalidate();
        objActividad5.getjPanel1().repaint();
        
    }
    
    /**
     * Mezcla las letras de una palabra al azar.
     * @param palabra palabra a mezclar
     * @return palabra mezclada
     */
    private String mezclarPalabra(String palabra) {
        char[] letras = palabra.toCharArray(); //de string a arreglo de caracter
        Random random = new Random();

        for (int i = 0; i < letras.length; i++) {
            int indiceAleatorio = random.nextInt(letras.length);

            // Intercambio de letras
            char temp = letras[i];
            letras[i] = letras[indiceAleatorio];
            letras[indiceAleatorio] = temp;
        }

        return new String(letras);
    }
 
    /**
     * Agrega eventos de arrastrar y soltar a los labels que contienen las letras
     * @param label JLabel letra
     * @param coordenadaEspecifica coordenada inicial
     */
    private void agregarEventosArrastre(JLabel label, Point coordenadaEspecifica) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                
                poaX = evt.getX();
                poaY = evt.getY();
                posicionOriginal = label.getLocation();
                reproducirSonido("/resource/sounds/mover.wav");
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                JLabel[] labelsDestino = {
                    objActividad5.getjLabel_detino1(),
                    objActividad5.getjLabel_destino2(),
                    objActividad5.getjLabel_destino3(),
                    objActividad5.getjLabel_destino4(),
                    objActividad5.getjLabel_destino5(),
                    objActividad5.getjLabel_destino6()
                };

                Point puntoGlobal = SwingUtilities.convertPoint(label, evt.getPoint(), objActividad5.getjPanel1());
                boolean colocado = false;
                for (JLabel destino : labelsDestino) {
                    if (destino.getBounds().contains(puntoGlobal) && destino.getText().isEmpty()) {
                        pegarEnDestino(label, destino);
                        colocado = true;
                        break;
                    }
                }
                if (!colocado) {
                    liberarDelDestino(label, coordenadaEspecifica);
                }
            }
        });
        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
               /* int newX = label.getX() + evt.getX() - label.getWidth() / 2;
                int newY = label.getY() + evt.getY() - label.getHeight() / 2;
                label.setLocation(newX, newY);*/
               int newX = label.getX() + (evt.getX() - poaX);
                int newY = label.getY() + (evt.getY() - poaY);

                if (newX < 0 || newY < 0 || newX + label.getWidth() > objActividad5.getjPanel1().getWidth() ||
                    newY + label.getHeight() > objActividad5.getjPanel1().getHeight()) {
                    liberarDelDestino(label, coordenadaEspecifica);
                } else {
                    label.setLocation(newX, newY);
                }
            }
        });
       
    }

    /**
     * Pega una letra en los label destino donde ordena las letras
     */
    private void pegarEnDestino(JLabel label, JLabel destino) {   
        destino.setLayout(new BorderLayout()); 
        destino.setText(""); 

        label.setSize(destino.getSize());
        label.setLocation(0, 0); 

        destino.add(label, BorderLayout.CENTER);
        destino.revalidate();
        destino.repaint();
    }

    /**
     * Libera la letra a la posicion original si no se soltó correctamente en los label 
     * destino
     */
    private void liberarDelDestino(JLabel label, Point coordenadaEspecifica) {
        if (label.getParent() != null) {
            Container parent = label.getParent();
            parent.remove(label);
            
            
            label.setLocation(coordenadaEspecifica);

            AbsoluteConstraints constraints = new AbsoluteConstraints(
                coordenadaEspecifica.x, 
                coordenadaEspecifica.y, 
                label.getWidth(), 
                label.getHeight()
            );
            objActividad5.getjPanel1().add(label, constraints);
            objActividad5.getjPanel1().setComponentZOrder(label, 0);
            objActividad5.getjPanel1().revalidate();
            objActividad5.getjPanel1().repaint();
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objActividad5.getjButton1_Salir_act_5()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            
            ControlDialogSalir cD = new ControlDialogSalir(objActividad5);
            cD.mostrarDialogo(); 

                if (cD.isSalirConfirmado()) {
                    stopSonido();
                    objActividad5.dispose(); 
                    Menu m = new Menu();
                    m.setVisible(true);     
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
        
        else if(e.getSource() == this.objActividad5.getjButton1_instrucciones()){ 
           reproducirSonido("/resource/sounds/instrucciones.wav");
        }else if (e.getSource() == this.objActividad5.getjButton1_Vericicar_respuesta()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            try {
                verificarRespuesta();
            } catch (Exception ex) {
                Logger.getLogger(ControlActividad2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource()== this.objActividad5.getjButton1_Cambiar_Palabra()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            cambiarPalabra();
        }else if (e.getSource() ==this.objActividad5.getjButton1_Repetir_PalabraAudio()){
            reproducirAudioDePalabra(palabraActual);
        }
        
        
        
    }

    /**
     * Verifica las letras pegadas en los label destino si correctamente forma la palabra actual
     * @throws Exception 
     */
    private void verificarRespuesta() throws Exception {
        JLabel[] labelsDestino = {
            objActividad5.getjLabel_detino1(),
            objActividad5.getjLabel_destino2(),
            objActividad5.getjLabel_destino3(),
            objActividad5.getjLabel_destino4(),
            objActividad5.getjLabel_destino5(),
            objActividad5.getjLabel_destino6()
        };

        StringBuilder palabraFormada = new StringBuilder();
        for (JLabel label : labelsDestino) {
            if (label.getComponentCount() > 0) {
                JLabel letra = (JLabel) label.getComponent(0);
                palabraFormada.append(letra.getText());
            }
        }

        if (palabraFormada.toString().equalsIgnoreCase(palabraActual)) {
            reproducirSonido("/resource/sounds/correct-6.wav");
            
          //  JOptionPane.showMessageDialog(objActividad5, "¡Respuesta correcta!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            reiniciarActividad();
            Comprobar("/resource/imagenes/bienhecho.png"); 
            respuestaCorrectas++;
        } else {
           //reproducirSonido("/resource/sounds/failed-2.wav");
            reproducirSonido("/resource/sounds/errorr.wav");
            Comprobar("/resource/imagenes/X.png"); 
            //JOptionPane.showMessageDialog(objActividad5, "Respuesta incorrecta. Intenta de nuevo.", "Resultado", JOptionPane.ERROR_MESSAGE);
            
            respuestasMalas++;
        }
        GuardarHistorial();
    }

    /**
     * Reinicia los labels para otra palabra desordenada
     * Reinicia los listener de las letras para evitar errores
     */
    private void reiniciarActividad() {
        JLabel[] labelsDestino = {
            objActividad5.getjLabel_detino1(),
            objActividad5.getjLabel_destino2(),
            objActividad5.getjLabel_destino3(),
            objActividad5.getjLabel_destino4(),
            objActividad5.getjLabel_destino5(),
            objActividad5.getjLabel_destino6()
        };

        for (JLabel label : labelsDestino) {
            label.removeAll(); 
            label.setText("");
            label.revalidate();
            label.repaint();
        }

        if (labelsOrigen != null) {
        
        //objActividad5.getjLabel9_fondo1().removeAll();
            for (int i = 0; i < labelsOrigen.length; i++) {
                if (labelsOrigen[i] != null) {
                    labelsOrigen[i].removeAll();
                    labelsOrigen[i].setText("");
                    labelsOrigen[i].revalidate();
                    labelsOrigen[i].repaint();
                    
                    labelsOrigen[i].setLocation(coordenadasEspecificas[i]); 

                    // elimina todos los listeners antiguos
                    for (MouseListener listener : labelsOrigen[i].getMouseListeners()) {
                        labelsOrigen[i].removeMouseListener(listener);
                    }
                    for (MouseMotionListener listener : labelsOrigen[i].getMouseMotionListeners()) {
                        labelsOrigen[i].removeMouseMotionListener(listener);
                    }
                    AbsoluteConstraints constraints = new AbsoluteConstraints(
                        coordenadasEspecificas[i].x, 
                        coordenadasEspecificas[i].y, 
                        labelsOrigen[i].getWidth(), 
                        labelsOrigen[i].getHeight()
                    );
                    objActividad5.getjPanel1().add(labelsOrigen[i], constraints);
                    objActividad5.getjPanel1().setComponentZOrder(labelsOrigen[i], 0);
                    agregarEventosArrastre(labelsOrigen[i], coordenadasEspecificas[i]);
                }
            }
            
        }

        try {
            palabraActual = palabrasDAO.obtenerPalabraDesordenada();
        } catch (Exception ex) {
            Logger.getLogger(ControlActividad2.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (palabraActual != null && !palabraActual.isEmpty()) {
            asignarLetrasAJLabels(palabraActual);
            reproducirAudioDePalabra(palabraActual); 
        }

        objActividad5.getjPanel1().revalidate();
        objActividad5.getjPanel1().repaint();
    }
    
    /**
     * Reproduce el audio de la palabra actual 
     * @param palabra ruta del sonido
     */
    private void reproducirAudioDePalabra(String palabra) {
        String rutaAudio = "/resource/sounds/" + palabra.toLowerCase() + ".wav";
        reproducirSonido(rutaAudio);
    }
    
    /**
     * Guardar en la base de datos la informacion
     * @throws Exception 
     */
    private void GuardarHistorial() throws Exception {
        if(this.v.getNom()== null){
            System.out.println("no hay usuario");
            return;
        }
        else{
        String word = objActividad5.getjLabel_detino1().getText() +
                      objActividad5.getjLabel_destino2().getText() +
                      objActividad5.getjLabel_destino3().getText() +
                      objActividad5.getjLabel_destino4().getText() +
                      objActividad5.getjLabel_destino5().getText() +
                      objActividad5.getjLabel_destino6().getText();
        int usuario_id = v.getId();
        String usuario_nombre = v.getNom();


        System.out.println("HISTORIAL GUARDADO: " + palabraActual);
        System.out.println("El nombre del usuario es: " + usuario_nombre);
        System.out.println("El id del usuario es: " + usuario_id);
        System.out.println("Las palabras buenas que llevas son: " + respuestaCorrectas);


        usuarioDAO.guardarHistorial(usuario_id, palabraActual, respuestaCorrectas);
        }
    }
    
    /**
     * Funcion para cambiar a otra palabra desordenada en caso de no entender actual
     * 
     */
    private void cambiarPalabra() {
       try{
           palabraActual= palabrasDAO.obtenerPalabraDesordenada();
       }catch(Exception ex){
           Logger.getLogger(ControlActividad2.class.getName()).log(Level.SEVERE, null, ex);
        return;
       }
       if(palabraActual !=null && !palabraActual.isEmpty()){
           reiniciarActividad();
           asignarLetrasAJLabels(palabraActual);
           
       }
    }
    
    /**
     * Se muestra en la vista una imagen visual si el usuario ordeno correctamente la palabra
     * @param mensaje ruta de la imagen 
     */
    private void Comprobar(String mensaje) {
        objActividad5.getjPanel1().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabel labelError = new JLabel(new ImageIcon(getClass().getResource(mensaje))); 
        labelError.setSize(420, 460); 

        objActividad5.getjPanel1().add(labelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 420, 460));

        objActividad5.getjPanel1().setComponentZOrder(labelError, 0); 
        objActividad5.getjPanel1().revalidate();
        objActividad5.getjPanel1().repaint();


        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objActividad5.getjPanel1().remove(labelError);
                objActividad5.getjPanel1().revalidate();
                objActividad5.getjPanel1().repaint();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

}