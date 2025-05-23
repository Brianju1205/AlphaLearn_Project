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
import modelo.AjustesM;
import modelo.Imagen;
import modelo.Palabra;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import utils.JLabelRedondeado;
import utils.RotatableRoundedLabel;
import vistas.Menu;

/**
 * Controlador para manejar el arrastre y soltar palabras en los JLabel destino
 * 
 * @author juare
 */
public class ControlActividad3 extends AbstractSonido implements ActionListener {
    private Actividad_3 vista;                          // referencia de la vista actividad_3
    private Verificador v;                              // referencia a la clase verificador
    private int poaX, poaY;                             // posicion del mause
    private Point posicionOriginal;                     // posicion inicial de los Jlabel
    private boolean clicDerechoPresionado = false;      // bandera indicador de los clicks
    private ControlGestorPalabras gestospa;             // referencia del gestor palabrasDAO
    private int vidas=5;
    private JLabel[] corazones;
    private Point coordenadasPalabra1 = new Point(140, 450);
    private Point coordenadasPalabra2 = new Point(440, 450);
    private Point coordenadasPalabra3 = new Point(740, 450);
    private Point[] coordenadasEspecificas = {
        new Point(140, 450),
        new Point(440, 450),
        new Point(740, 450)
       
    };
    private Imagen imRuta;
    private Palabra p;
    private JLabel[] labelsOrigen;
    //private JLabelRedondeado[] labelsOrigen;
    /**
     * Controlador Actividad 3
     * @param vista objeto actividad 3
     */
    public ControlActividad3(Actividad_3 vista) {
        this.vista = vista;
        
        this.gestospa = ControlGestorPalabras.getInstance();
        v = Verificador.getInstancia();
        
        this.corazones=new JLabel[]{
            vista.getCorazon1(),
            vista.getCorazon2(),
            vista.getCorazon3(),
            vista.getCorazon4(),
            vista.getCorazon5(),
            
        };
        rutaimagen();
        
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
        mostrarInstruccion();
        
        
    }
    
    /**
     * Muestra la instrucción inicial si están activadas en los ajustes.
     */
    private void mostrarInstruccion(){
       AjustesM ajustes = ControlGestorAjustes.getInstance().obtenerAjustes(v.getId());
        if(ajustes.isInstruccionesActivas()){
           this.mostrarInstruccion(vista.getjPanel3_fondo(), "/resource/imagenes/presentador.png",870,380);
           reproducirSonido("/resource/sounds/modulo3.wav");
        }
        else{
            System.out.println("instrucciones desactivadas");
        }
    }
    
    /**
     * Carga nuevas palabras e imágenes en los Labels.
     */
    private void cargarPalabrasEnLabels() {
        //limpia el texto de los labels 
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

        // obtiene las palabras del gestor palabrasDAO
        try {
            ArrayList<Palabra> palabras = gestospa.obtenerTresPalabrasConImagen();

            if (palabras.size() >= 3) {
                
               //vista.getjLabel1_palabra1()= new RotatableRoundedLabel(String.valueOf(palabras.get(0).getPalabra()),0, 50);
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
    /**
     * Esta metodo compara que todas los Jlabels destino 
     * tengan el mismo nombre que las imagenes correctamente alineadas
     * 
     */
    private void compararPalabras() {
    boolean todasCorrectas = true; 
    boolean alMenosUnError = false; 
    
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
            alMenosUnError = true; 
        }
    }


    if (alMenosUnError) {
        vidas--;
        actualizarCorazones();
        
        
        for (int i = 0; i < destinos.length; i++) {
            if (!destinos[i].getText().equals(imagenes[i].getText())) {
                for (int j = 0; j < palabras.length; j++) {
                    if (palabras[j].getText().equals(destinos[i].getText())) {
                        this.liberarDelDestino(palabras[j], coordenadas[j]);
                        break;
                    }
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
    
    /**
     * Asignar la imagen a los label de manera redimensionada al tamaño del Jlabel
     * @param label Jlabel en el que se mostraran las imagenes
     * @param rutaImagen ruta de la imagen
     */
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

    /**
     * Agrega los eventos que permiten agarrar y arrastrar a los Jlabels hacia los Jlabels destino
     * @param label jLabel a la que se le asigna los listener
     * @param coordenadasEspecificas coordenadas a las que tiene que regresr en caso de no colocarlas correctamente
     */
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

    /**
     * Este metodo permite pegar el Jlabel que se esta arrastrando a los JLabel destino en donde se tiene que comparar
     * @param label Jlabel que se agarra y arrastra
     * @param destino Jlabel en el que se posiciona el nuevo Jlabel 
     */
    private void pegarEnDestino(JLabel label, JLabel destino) {
        destino.setLayout(new BorderLayout());
        
        destino.setText(label.getText());
        
        
        label.setSize(destino.getSize());
        label.setLocation(0, 0);

        destino.add(label, BorderLayout.CENTER);
        destino.revalidate();
        destino.repaint();
        
    }

    /**
     * Permite sacar los Jlabel de los Jlabel destino y regresarlo a la posicion original
     * @param label Jlabel que se desea regresar
     * @param coordenadasEspecificas Coordenadas a las que regresa automaticamente
     */     
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
            /*Menu m = new vistas.Menu();
            m.setVisible(true);
            stopSonido();
            if (vista != null) {
                vista.dispose();
            }*/
            ControlDialogSalir cD = new ControlDialogSalir(vista);
            cD.mostrarDialogo(); 

                if (cD.isSalirConfirmado()) {
                    stopSonido();
                    vista.dispose(); 
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
        }else if(e.getSource() == this.vista.getjButton_verificar()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            this.compararPalabras();
        }else if(e.getSource() == this.vista.getjButton_cambiar()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            this.cargarPalabrasEnLabels();
        }
    }
    
    /**
     * Se muestra en la vista una imagen visual si el usuario ordeno correctamente la palabra
     * @param mensaje ruta de la imagen 
     */
    private void Comprobar(int num, String mensaje) {
        JLabel labelError = new JLabel(new ImageIcon(getClass().getResource(mensaje)));
        labelError.setSize(180, 180);

        int x = 170; 
        int y = 280; 

        switch (num) {
            case 1:
                x = 170;
                break;
            case 2:
                x = 470;
                break;
            case 3:
                x = 770;
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
    
    
    private void rutaimagen() {
        for (JLabel corazon : corazones) {
            asignarImagen(corazon,"/resource/CORAZON.png");
            //corazon.setIcon(new ImageIcon(getClass().getResource("/resource/CORAZON.png"))); // Ruta correcta de la imagen
            corazon.setVisible(true);
        }
        vidas = 5; 
    }
    
    
    private void actualizarCorazones() {
    if (vidas >= 0 && vidas < corazones.length) {
        corazones[vidas].setVisible(false); 
    }

    if (vidas <= 0) {
        
        resetearCorazones(); 
        cargarPalabrasEnLabels();
        
        ControlDialogSInIntentos dialogo = new ControlDialogSInIntentos(vista);
        dialogo.mostrarDialogo();
      
       
       if(dialogo.isReintenar()){
           cargarPalabrasEnLabels();
           resetearCorazones(); 
       }else {
            stopSonido();
            vista.dispose();
            Menu m = new Menu();
            m.setVisible(true); 
           // new Menu().setVisible(true); // Volver al menú
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
