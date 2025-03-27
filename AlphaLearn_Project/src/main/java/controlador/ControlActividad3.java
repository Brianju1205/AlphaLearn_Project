package controlador;

import vistas.Actividad_3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import modelo.Imagen;
import modelo.Palabra;
import vistas.Menu;

/**
 * Controlador para manejar el arrastre y soltar palabras en los JLabel destino.
 * 
 * @author juare
 */
public class ControlActividad3 implements ActionListener {
    private Actividad_3 vista;
    
    private int poaX, poaY;
    private Point posicionOriginal;
    private boolean clicDerechoPresionado = false;
    private ControlGestorPalabras gestospa;
    private Point coordenadasPalabra1 = new Point(650, 140);
    private Point coordenadasPalabra2 = new Point(650, 320);
    private Point coordenadasPalabra3 = new Point(650, 500);
    private Imagen imRuta;
    private Palabra p;

    public ControlActividad3(Actividad_3 vista) {
        this.vista = vista;
        
        this.gestospa = ControlGestorPalabras.getInstance();

        vista.getjPanel3_fondo().setLayout(null);
        
        agregarEventosArrastre(vista.getjLabel1_palabra1(), coordenadasPalabra1);
        agregarEventosArrastre(vista.getjLabel2_palabra3(), coordenadasPalabra2);
        agregarEventosArrastre(vista.getjLabel3_palabra2(), coordenadasPalabra3);

        this.vista.getjButton1_Salir().addActionListener(this);
        this.vista.getjButton_verificar().addActionListener(this);
        this.vista.getjButton_cambiar().addActionListener(this);
        //nfigurarPosicionesLabelsImagen();
        cargarPalabrasEnLabels();
        
    }

    private void cargarPalabrasEnLabels() {
        try {
            ArrayList<Palabra> palabras = gestospa.obtenerTresPalabrasConImagen();

            if (palabras.size() >= 3) {
                vista.getjLabel1_palabra1().setText(palabras.get(0).getPalabra());
                this.asignarImagen(vista.getJlabel_image2(),palabras.get(0).getImagen().getRuta());
                vista.getJlabel_image2().setText(palabras.get(0).getPalabra());
                
                vista.getjLabel2_palabra3().setText(palabras.get(1).getPalabra());
                this.asignarImagen(vista.getJlabel_image3(),palabras.get(1).getImagen().getRuta());
                
                vista.getJlabel_image3().setText(palabras.get(1).getPalabra());
                vista.getjLabel3_palabra2().setText(palabras.get(2).getPalabra());
                
                this.asignarImagen(vista.getJlabel_image1(),palabras.get(2).getImagen().getRuta());
                vista.getJlabel_image1().setText(palabras.get(2).getPalabra());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al cargar palabras con imágenes.");
        }
    }
    
    private void compararPalabras() {
    
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

                if (newX < 0 || newY < 0 || newX + label.getWidth() > vista.getjPanel3_fondo().getWidth() ||
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
        destino.setText("");
        
        label.setSize(destino.getSize());
        label.setLocation(0, 0);

        destino.add(label, BorderLayout.CENTER);
        destino.revalidate();
        destino.repaint();
    }

    private void liberarDelDestino(JLabel label, Point coordenadasEspecificas) {
        if (label.getParent() != null) {
            Container parent = label.getParent();
            parent.remove(label);

            label.setLocation(coordenadasEspecificas);

            vista.getjPanel3_fondo().add(label);
            vista.getjPanel3_fondo().revalidate();
            vista.getjPanel3_fondo().repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.getjButton1_Salir()) {
            Menu m = new vistas.Menu();
            m.setVisible(true);
            if (vista != null) {
                vista.dispose();
            }
        }else if(e.getSource() == this.vista.getjButton_verificar()){
            this.compararPalabras();
        }else if(e.getSource() == this.vista.getjButton_cambiar()){
            
        }
    }
    
}
