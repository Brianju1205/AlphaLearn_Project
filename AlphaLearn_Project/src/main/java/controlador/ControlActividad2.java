package controlador;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import vistas.Actividad_2;
import vistas.Menu;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author almen
 */
public class ControlActividad2 implements ActionListener {
    private Clip clip;
    private int poaX, poaY; 
    private Actividad_2 objActividad5;
    private ControlGestorPalabras palabrasDAO;
    private String palabraActual;
    private int respuestaCorrectas=0;
    private int respuestasMalas=0;
    private Verificador v;
    private UsuarioDAO usuarioDAO;
    private Point posicionOriginal;
    private Point[] coordenadasEspecificas = {
        new Point(260, 190), 
        new Point(380, 190),
        new Point(510, 190),
        new Point(640, 190), 
        new Point(770, 190),
        new Point(900, 190)
    };
    
    private JLabel[] labelsOrigen;

    public ControlActividad2(Actividad_2 objActividad5) {
        this.objActividad5 = objActividad5;
        this.v = Verificador.getInstancia();
        System.out.println("El id es: " + v.getId() + ", nombre es: " + v.getNom());

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
        
        objActividad5.getjPanel1().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        this.objActividad5.getjButton1_Salir_act_5().addActionListener(this);
        this.objActividad5.getjButton1_Vericicar_respuesta().addActionListener(this);
        this.objActividad5.getjButton1_Cambiar_Palabra().addActionListener(this);
        this.objActividad5.getjButton1_instrucciones().addActionListener(this);
        this.objActividad5.getjButton1_Repetir_PalabraAudio().addActionListener(this);
        reproducirSonido("/resource/sounds/intro.wav");
    }

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
        
        
        objActividad5.getjLabel9_fondo1().removeAll();
        for (int i = 0; i < palabra.length(); i++) {
            if (i < labelsOrigen.length) {
                labelsOrigen[i].setText(String.valueOf(palabra.charAt(i)));
                labelsOrigen[i].setLocation(coordenadasEspecificas[i]); 

                // Usar AbsoluteConstraints al agregar el label al panel
                AbsoluteConstraints constraints = new AbsoluteConstraints(
                    coordenadasEspecificas[i].x, 
                    coordenadasEspecificas[i].y, 
                    labelsOrigen[i].getWidth(), 
                    labelsOrigen[i].getHeight()
                );
                //objActividad5.getjPanel1().add(labelsOrigen[i], constraints); // Esto sirve para agregar los label al panel forzadamente con restricciones
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

    private void agregarEventosArrastre(JLabel label, Point coordenadaEspecifica) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                /*label.getParent().setComponentZOrder(label, 0);*/
                poaX = evt.getX();
                poaY = evt.getY();
                posicionOriginal = label.getLocation();
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

    private void pegarEnDestino(JLabel label, JLabel destino) {   
        destino.setLayout(new BorderLayout()); 
        destino.setText(""); 

        label.setSize(destino.getSize());
        label.setLocation(0, 0); 

        destino.add(label, BorderLayout.CENTER);
        destino.revalidate();
        destino.repaint();
    }

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
            Menu m = new Menu();
            m.setVisible(true);
            clip.stop();
            clip.close();
            objActividad5.dispose();
        }
        else if(e.getSource() == this.objActividad5.getjButton1_instrucciones()){  
           reproducirSonido("/resource/sounds/instrucciones.wav");
        }else if (e.getSource() == this.objActividad5.getjButton1_Vericicar_respuesta()) {
            try {
                verificarRespuesta();
            } catch (Exception ex) {
                Logger.getLogger(ControlActividad2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (e.getSource()== this.objActividad5.getjButton1_Cambiar_Palabra()){
            cambiarPalabra();
        }else if (e.getSource() ==this.objActividad5.getjButton1_Repetir_PalabraAudio()){
            reproducirAudioDePalabra(palabraActual);
        }
        
        
        
    }

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
            reproducirSonido("/resource/sounds/muy_bien.wav");
            
          //  JOptionPane.showMessageDialog(objActividad5, "¡Respuesta correcta!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            reiniciarActividad();
            Comprobar("/resource/imagenes/bienhecho.png"); 
            respuestaCorrectas++;
        } else {
            reproducirSonido("/resource/sounds/error.wav");
            reproducirSonido("/resource/sounds/Incorrecto.wav");
            Comprobar("/resource/imagenes/X.png"); 
            //JOptionPane.showMessageDialog(objActividad5, "Respuesta incorrecta. Intenta de nuevo.", "Resultado", JOptionPane.ERROR_MESSAGE);
            
            respuestasMalas++;
        }
        GuardarHistorial();
    }

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
        
        objActividad5.getjLabel9_fondo1().removeAll();
            for (int i = 0; i < labelsOrigen.length; i++) {
                if (labelsOrigen[i] != null) {
                    labelsOrigen[i].setText(""); 
                    labelsOrigen[i].setLocation(coordenadasEspecificas[i]); 

                    // elimina todos los listeners antiguos
                    for (MouseListener listener : labelsOrigen[i].getMouseListeners()) {
                        labelsOrigen[i].removeMouseListener(listener);
                    }
                    for (MouseMotionListener listener : labelsOrigen[i].getMouseMotionListeners()) {
                        labelsOrigen[i].removeMouseMotionListener(listener);
                    }
                    //agrega los label al panel
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
    
    private void reproducirAudioDePalabra(String palabra) {
        String rutaAudio = "/resource/sounds/" + palabra.toLowerCase() + ".wav";
        reproducirSonido(rutaAudio);
    }
    
    
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

   private void Comprobar(String mensaje) {
        objActividad5.getjPanel1().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabel labelError = new JLabel(new ImageIcon(getClass().getResource(mensaje))); 
        labelError.setSize(420, 460); 

        objActividad5.getjPanel1().add(labelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 420, 460));

        objActividad5.getjPanel1().setComponentZOrder(labelError, 0);  // 0 significa capa superior
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