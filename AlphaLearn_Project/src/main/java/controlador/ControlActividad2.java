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
    private Actividad_2 objActividad5;
    private ControlGestorPalabras palabrasDAO;
    private String palabraActual;
    private int respuestaCorrectas=0;
    private int respuestasMalas=0;
    private Verificador v;
    private Point[] coordenadasEspecificas = {
        new Point(110, 90), 
        new Point(240, 90),
        new Point(370, 90),
        new Point(500, 90), 
        new Point(640, 90),
        new Point(780, 90)
    };
    
    private JLabel[] labelsOrigen;

    public ControlActividad2(Actividad_2 objActividad5) {
        this.objActividad5 = objActividad5;
        this.v = Verificador.getInstancia();
        System.out.println("El id es: " + v.getId() + ", nombre es: " + v.getNom());

        //this.objOperacionesBD = OperacionesBD.getInstance();
        this.palabrasDAO = ControlGestorPalabras.getInstance();
         
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
                objActividad5.getjPanel1().add(labelsOrigen[i], constraints); // Esto sirve para agregar los label al panel forzadamente con restricciones

                // Se tienen que eliminar los eventos de arrastre
                for (MouseListener listener : labelsOrigen[i].getMouseListeners()) {
                    labelsOrigen[i].removeMouseListener(listener);
                }
                for (MouseMotionListener listener : labelsOrigen[i].getMouseMotionListeners()) {
                    labelsOrigen[i].removeMouseMotionListener(listener);
                }

              
                agregarEventosArrastre(labelsOrigen[i], coordenadasEspecificas[i]);
            }
        }

       
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
                label.getParent().setComponentZOrder(label, 0);
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
                int newX = label.getX() + evt.getX() - label.getWidth() / 2;
                int newY = label.getY() + evt.getY() - label.getHeight() / 2;
                label.setLocation(newX, newY);
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

            objActividad5.getjPanel1().revalidate();
            objActividad5.getjPanel1().repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objActividad5.getjButton1_Salir_act_5()) {
            Menu m = new Menu();
            m.setVisible(true);
            objActividad5.dispose();
        }
        else if(e.getSource() == this.objActividad5.getjButton1_instrucciones()){  
           reproducirSonido("/resource/sounds/instrucciones.wav");
        }else if (e.getSource() == this.objActividad5.getjButton1_Vericicar_respuesta()) {
            verificarRespuesta();
        }else if (e.getSource()== this.objActividad5.getjButton1_Cambiar_Palabra()){
            cambiarPalabra();
        }
        
        
    }

    private void verificarRespuesta() {
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
            JOptionPane.showMessageDialog(objActividad5, "¡Respuesta correcta!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            reiniciarActividad();
            respuestaCorrectas++;
        } else {
            JOptionPane.showMessageDialog(objActividad5, "Respuesta incorrecta. Intenta de nuevo.", "Resultado", JOptionPane.ERROR_MESSAGE);
            
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
        }

        objActividad5.getjPanel1().revalidate();
        objActividad5.getjPanel1().repaint();
    }
    private void GuardarHistorial() {
        String word=objActividad5.getjLabel_detino1().getText()+
                    objActividad5.getjLabel_destino2().getText()+
                    objActividad5.getjLabel_destino3().getText()+
                    objActividad5.getjLabel_destino4().getText()+
                    objActividad5.getjLabel_destino5().getText()+
                    objActividad5.getjLabel_destino6().getText() ;
        
        System.out.println("HISTORIAL GUARDADO: "+word);
        System.out.println("Las palabras buenas que llevas son: "+respuestaCorrectas);
        System.out.println("Las palabras malas que llevas son: "+respuestasMalas);
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
            URL url = getClass().getResource(ruta);
            if (url == null) {
                System.err.println("No se encontro el archivo: " + ruta);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }
}