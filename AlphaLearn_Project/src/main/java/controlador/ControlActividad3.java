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
        configurarPosicionesLabelsImagen();
        cargarPalabrasEnLabels();
        agregarEventosArrastre(vista.getjLabel1_palabra1(), coordenadasPalabra1);
        agregarEventosArrastre(vista.getjLabel2_palabra3(), coordenadasPalabra2);
        agregarEventosArrastre(vista.getjLabel3_palabra2(), coordenadasPalabra3);

        this.vista.getjButton1_Salir().addActionListener(this);

        
    }

    private void cargarPalabrasEnLabels() {
        try {
            ArrayList<Palabra> palabras = gestospa.obtenerTresPalabrasConImagen();

            if (palabras.size() >= 3) {
                vista.getjLabel1_palabra1().setText(palabras.get(0).getPalabra());
                String url1 = "/resource/imagenes/Gato.png"; 
                URL imageUrl1 = getClass().getResource(url1);
                if (imageUrl1 != null) {
                    JLabel label = vista.getJlabel_image1();
                    int labelWidth = label.getWidth();
                    int labelHeight = label.getHeight();
                    ImageIcon iconoOriginal = new ImageIcon(imageUrl1.getPath());
                    Image imgEscalada = iconoOriginal.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                    ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
                    label.setIcon(iconoEscalado);
                    label.revalidate();
                    label.repaint();
                } else {
                    System.out.println("Imagen no encontrada en: " + url1);
                }

                vista.getjLabel2_palabra3().setText(palabras.get(1).getPalabra());
                String url2 = "/resource/imagenes/" + palabras.get(1).getPalabra() + ".png";
                URL imageUrl2 = getClass().getResource(url2);
                if (imageUrl2 != null) {
                    JLabel label = vista.getJlabel_image2();
                    int labelWidth = label.getWidth();
                    int labelHeight = label.getHeight();
                    ImageIcon iconoOriginal = new ImageIcon(imageUrl2.getPath());
                    Image imgEscalada = iconoOriginal.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                    ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
                    label.setIcon(iconoEscalado);
                    label.revalidate();
                    label.repaint();
                } else {
                    System.out.println("Imagen no encontrada en: " + url2);
                }

                vista.getjLabel3_palabra2().setText(palabras.get(2).getPalabra());
                String url3 = "/resource/imagenes/" + palabras.get(2).getPalabra() + ".png";
                URL imageUrl3 = getClass().getResource(url3);
                if (imageUrl3 != null) {
                    JLabel label = vista.getJlabel_image3();
                    int labelWidth = label.getWidth();
                    int labelHeight = label.getHeight();
                    ImageIcon iconoOriginal = new ImageIcon(imageUrl3.getPath());
                    Image imgEscalada = iconoOriginal.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
                    ImageIcon iconoEscalado = new ImageIcon(imgEscalada);
                    label.setIcon(iconoEscalado);
                    label.revalidate();
                    label.repaint();
                } else {
                    System.out.println("Imagen no encontrada en: " + url3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(vista, "Error al cargar palabras con imágenes.");
        }
    }

    private void asignarImagen(JLabel label, String rutaImagen) {
        if (rutaImagen == null) return;

        ImageIcon icono = new ImageIcon(rutaImagen);

        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();
        if (labelWidth > 0 && labelHeight > 0) {
            Image imagen = icono.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            icono = new ImageIcon(imagen);
        }
        label.setIcon(icono);

        label.revalidate();
        label.repaint();
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
        }
    }
    
    private void configurarPosicionesLabelsImagen() {
        JLabel label1 = vista.getJlabel_image1();
        label1.setBounds(50, 119, 170, 160);

        JLabel label2 = vista.getJlabel_image2();
        label2.setBounds(50, 290, 170, 160);

        JLabel label3 = vista.getJlabel_image3();
        label3.setBounds(50, 470, 170, 160);
    }
}
