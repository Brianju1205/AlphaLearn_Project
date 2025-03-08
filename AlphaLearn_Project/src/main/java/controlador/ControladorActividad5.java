package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import vistas.Actividad_5;
import vistas.Menu;

public class ControladorActividad5 implements ActionListener {
    private Actividad_5 objActividad5;
    private OperacionesBD objOperacionesBD;
    private String palabraActual;
    private Point[] coordenadasEspecificas = {
        new Point(110, 90), 
        new Point(240, 90),
        new Point(370, 90),
        new Point(500, 90), 
        new Point(640, 90),
        new Point(780, 90)
    };
    
    private JLabel[] labelsOrigen;

    public ControladorActividad5(Actividad_5 objActividad5) {
        this.objActividad5 = objActividad5;
        this.objOperacionesBD = OperacionesBD.getInstance();

        palabraActual = objOperacionesBD.obtenerPalabraDesordenada();
        if (palabraActual != null && !palabraActual.isEmpty()) {
            asignarLetrasAJLabels(palabraActual);
        }
        
        objActividad5.getjPanel1().setLayout(null);
        this.objActividad5.getjButton1_Salir_act_5().addActionListener(this);
        this.objActividad5.getjButton1_Vericicar_respuesta().addActionListener(this);
    }

    private void asignarLetrasAJLabels(String palabra) {
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
                agregarEventosArrastre(labelsOrigen[i], coordenadasEspecificas[i]);
            }
        }
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

            objActividad5.getjPanel1().add(label);
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
        } else if (e.getSource() == this.objActividad5.getjButton1_Vericicar_respuesta()) {
            verificarRespuesta();
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
            if (!label.getText().isEmpty()) {
                palabraFormada.append(label.getText());
            }
        }

        if (palabraFormada.toString().equalsIgnoreCase(palabraActual)) {
            System.out.println("¡Respuesta correcta!");
        } else {
            System.out.println("Respuesta incorrecta. Intenta de nuevo.");
        }
    }
}
