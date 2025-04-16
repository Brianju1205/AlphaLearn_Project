/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vistas.Actividad_3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import modelo.Imagen;
import modelo.Palabra;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import vistas.Menu;

/**
 * Controlador para manejar el arrastre y soltar palabras en los JLabel destino.
 * 
 * @author juare
 */
public class ControlActividad3 extends AbstractSonido implements ActionListener {
    private Actividad_3 vista;
    private Verificador v;
    private int poaX, poaY;
    private Point posicionOriginal;
    private boolean clicDerechoPresionado = false;
    private ControlGestorPalabras gestospa;
    private Point coordenadasPalabra1 = new Point(650, 140);
    private Point coordenadasPalabra2 = new Point(650, 320);
    private Point coordenadasPalabra3 = new Point(650, 500);
    private Point[] coordenadasEspecificas = {
        new Point(650, 140),
        new Point(650, 320),
        new Point(650, 500)
       
    };
    private Imagen imRuta;
    private Palabra p;
    private JLabel[] labelsOrigen;
    
    public ControlActividad3(Actividad_3 vista) {
        this.vista = vista;
        
        this.gestospa = ControlGestorPalabras.getInstance();
        v = Verificador.getInstancia();
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        vista.getjPanel3_fondo().setLayout(null);
      
        agregarEventosArrastre(vista.getjLabel1_palabra1(), coordenadasPalabra1);
        agregarEventosArrastre(vista.getjLabel3_palabra2(), coordenadasPalabra2);
        agregarEventosArrastre(vista.getjLabel2_palabra3(), coordenadasPalabra3);

        this.vista.getjButton1_Salir().addActionListener(this);
        this.vista.getjButton_verificar().addActionListener(this);
        this.vista.getjButton_cambiar().addActionListener(this);
        //nfigurarPosicionesLabelsImagen();
        cargarPalabrasEnLabels();
        this.mostrarInstruccion(vista.getjPanel3_fondo(), "/resource/imagenes/presentador.png",870,470);
        reproducirSonido("/resource/sounds/modulo3.wav");
        
    }
    private void cargarPalabrasEnLabels() {
        JLabel[] labelsDestino = {
            vista.getjLabel_destino1(),
            vista.getjLabel_destino2(),
            vista.getjLabel_destino3()
        };

        for (JLabel label : labelsDestino) {
            label.setText(""); 
            label.removeAll(); 
            label.revalidate(); 
            label.repaint(); 
        }

     
        labelsOrigen = new JLabel[] {
            vista.getjLabel1_palabra1(),
            vista.getjLabel2_palabra3(),
            vista.getjLabel3_palabra2()
        };

        for (JLabel label : labelsOrigen) {
            for (MouseListener listener : label.getMouseListeners()) {
                label.removeMouseListener(listener);
            }
            for (MouseMotionListener listener : label.getMouseMotionListeners()) {
                label.removeMouseMotionListener(listener);
            }
        }

        for (int i = 0; i < labelsOrigen.length; i++) {
            if (labelsOrigen[i] != null) {
                labelsOrigen[i].setText("");
                labelsOrigen[i].setLocation(coordenadasEspecificas[i]); 

                AbsoluteConstraints constraints = new AbsoluteConstraints(
                        coordenadasEspecificas[i].x,
                        coordenadasEspecificas[i].y,
                        labelsOrigen[i].getWidth(),
                        labelsOrigen[i].getHeight()
                );

                vista.getjPanel3_fondo().add(labelsOrigen[i], constraints);
                vista.getjPanel3_fondo().setComponentZOrder(labelsOrigen[i], 0);

                agregarEventosArrastre(labelsOrigen[i], coordenadasEspecificas[i]);
            }
        }

        
        try {
            ArrayList<Palabra> palabras = gestospa.obtenerTresPalabrasConImagen();

            if (palabras.size() >= 3) {
                vista.getjLabel1_palabra1().setText(palabras.get(0).getPalabra());
                this.asignarImagen(vista.getJlabel_image2(), palabras.get(0).getImagen().getRuta());
                vista.getJlabel_image2().setText(palabras.get(0).getPalabra());

                vista.getjLabel2_palabra3().setText(palabras.get(1).getPalabra());
                this.asignarImagen(vista.getJlabel_image3(), palabras.get(1).getImagen().getRuta());
                vista.getJlabel_image3().setText(palabras.get(1).getPalabra());

                vista.getjLabel3_palabra2().setText(palabras.get(2).getPalabra());
                this.asignarImagen(vista.getJlabel_image1(), palabras.get(2).getImagen().getRuta());
                vista.getJlabel_image1().setText(palabras.get(2).getPalabra());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al cargar palabras con imágenes.");
        }

        vista.getjPanel3_fondo().revalidate();
        vista.getjPanel3_fondo().repaint();
    }
    
    private void compararPalabras() {
        boolean todasCorrectas = true; 
        resetearComprobacion();

        JLabel[] destinos = {
            vista.getjLabel_destino1(),
            vista.getjLabel_destino2(),
            vista.getjLabel_destino3()
        };

        JLabel[] imagenes = {
            vista.getJlabel_image1(),
            vista.getJlabel_image2(),
            vista.getJlabel_image3()
        };

        JLabel[] palabras = {
            vista.getjLabel1_palabra1(),
            vista.getjLabel3_palabra2(),
            vista.getjLabel2_palabra3()
        };

        Point[] coordenadas = { 
            coordenadasPalabra1, 
            coordenadasPalabra2, 
            coordenadasPalabra3 
        };

        for (int i = 0; i < destinos.length; i++) {
            if (destinos[i].getText().equals(imagenes[i].getText())) {
                Comprobar(i + 1, "/resource/imagenes/check.png");
                System.out.println("Correcto: " + destinos[i].getText());
            } else {
                Comprobar(i + 1, "/resource/imagenes/close.png");
                System.out.println("Incorrecto: " + destinos[i].getText());
                todasCorrectas = false;


                for (int j = 0; j < palabras.length; j++) {
                    if (palabras[j].getText().equals(destinos[i].getText())) {
                        this.liberarDelDestino(palabras[j], coordenadas[j]);
                        break; 
                    }
                }
            }
        }

        if (todasCorrectas) {
            this.cargarPalabrasEnLabels();
        }
    }

    private void resetearComprobacion() {
        Comprobar(1, ""); 
        Comprobar(2, ""); 
        Comprobar(3, ""); 
    }
    
    private void asignarImagen(JLabel label, String rutaImagen) {
        try {
         
            URL imgURL = getClass().getResource(rutaImagen);
            if (imgURL != null) {
                ImageIcon icono = new ImageIcon(imgURL);
                Image imgEscalada = icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imgEscalada));
            } else {
                System.out.println("No se encontro la imagen en: " + rutaImagen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void agregarEventosArrastre(JLabel label, Point coordenadasEspecificas) {
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
                JLabel destino1 = vista.getjLabel_destino1();
                JLabel destino2 = vista.getjLabel_destino2();
                JLabel destino3 = vista.getjLabel_destino3();
                
                Point puntoGlobal = SwingUtilities.convertPoint(label, evt.getPoint(), vista.getjPanel3_fondo());
 
                
                if (destino1.getBounds().contains(puntoGlobal)) {
                    pegarEnDestino(label, destino1);
                } else if (destino2.getBounds().contains(puntoGlobal)) {
                    pegarEnDestino(label, destino2);
                } else if (destino3.getBounds().contains(puntoGlobal)) {
                    pegarEnDestino(label, destino3);
                } else {
                    liberarDelDestino(label, coordenadasEspecificas);
                }
            }
        });

        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent evt) {
                int newX = label.getX() + (evt.getX() - poaX);
                int newY = label.getY() + (evt.getY() - poaY);

                if (newX < 0 || newY < 0 || newX + label.getWidth() > vista.getjPanel3_fondo().getWidth()  || 
                    newY + label.getHeight() > vista.getjPanel3_fondo().getHeight()) {
                    liberarDelDestino(label, coordenadasEspecificas);
                } else {
                    label.setLocation(newX, newY);
                }
             
            }
        });
    }

    private void pegarEnDestino(JLabel label, JLabel destino) {
        destino.setLayout(new BorderLayout());
        
        destino.setText(label.getText());
        
        
        label.setSize(destino.getSize());
        label.setLocation(0, 0);

        destino.add(label, BorderLayout.CENTER);
        destino.revalidate();
        destino.repaint();
        
    }

         
    private void liberarDelDestino(JLabel label, Point coordenadasEspecificas) {
        JLabel destino1 = vista.getjLabel_destino1();
        JLabel destino2 = vista.getjLabel_destino2();
        JLabel destino3 = vista.getjLabel_destino3();
       
        if (label.getParent() == destino1) {
            destino1.setText("");

        } else if (label.getParent() == destino2) {
            destino2.setText("");

        } else if (label.getParent() == destino3) {
            destino3.setText("");

        }

        if (label.getParent() != null) {
            Container parent = label.getParent();
            parent.remove(label);
            
            
            label.setLocation(coordenadasEspecificas);

            AbsoluteConstraints constraints = new AbsoluteConstraints(
                coordenadasEspecificas.x, 
                coordenadasEspecificas.y, 
                label.getWidth(), 
                label.getHeight()
            );
             vista.getjPanel3_fondo().add(label, constraints);
             vista.getjPanel3_fondo().setComponentZOrder(label, 0);
             vista.getjPanel3_fondo().revalidate();
             vista.getjPanel3_fondo().repaint();
        }
 
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.getjButton1_Salir()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            Menu m = new vistas.Menu();
            m.setVisible(true);
            stopSonido();
            if (vista != null) {
                vista.dispose();
            }
            if(this.v.getNom()== null){
            System.out.println("no hay usuario");
            return;
            }
            else{
            int tiempoTotal = (int) TiempoActivo.getInstancia().getTiempoActivo();
            ControlGestorTiempo.getInstancia().guardarTiempo(v.getId(),tiempoTotal);
            }
        }else if(e.getSource() == this.vista.getjButton_verificar()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            this.compararPalabras();
        }else if(e.getSource() == this.vista.getjButton_cambiar()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            this.cargarPalabrasEnLabels();
        }
    }
    private void Comprobar(int num, String mensaje) {
        JLabel labelError = new JLabel(new ImageIcon(getClass().getResource(mensaje)));
        labelError.setSize(180, 180);

        int x = 250; 
        int y = 110; 

        switch (num) {
            case 1:
                y = 110;
                break;
            case 2:
                y = 290;
                break;
            case 3:
                y = 470;
                break;
        }

        if (!(vista.getjPanel3_fondo().getLayout() instanceof org.netbeans.lib.awtextra.AbsoluteLayout)) {
            vista.getjPanel3_fondo().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        }

        vista.getjPanel3_fondo().invalidate();
        vista.getjPanel3_fondo().add(labelError, new org.netbeans.lib.awtextra.AbsoluteConstraints(x, y, 180, 180));
        vista.getjPanel3_fondo().setComponentZOrder(labelError, 0);
        vista.getjPanel3_fondo().validate();
        vista.getjPanel3_fondo().repaint();
       
        Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    vista.getjPanel3_fondo().remove(labelError);
                    vista.getjPanel3_fondo().revalidate();
                    vista.getjPanel3_fondo().repaint();
                }
            });
            timer.setRepeats(false);
            timer.start();
    }

}
