/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vistas.Actividad_4;
import vistas.Menu;

/**
 *
 * @author almen
 */

public class ControlActividad4 extends AbstractSonido implements ActionListener {
    private Actividad_4 objActividad4;
    private Verificador v;
    private ControlGestorPalabras palabrasDAO;
    private String[] palabras; 
    private String palabraCorrecta;
    private boolean audioReproducido = false;
    private String seleccionUsuario = null;

    public ControlActividad4(Actividad_4 objActividad4) {
        this.objActividad4 = objActividad4;

        this.objActividad4.getjButton1_audio_palabra().addActionListener(this);
        this.objActividad4.getjButton1_Cambiar_audio_palabra().addActionListener(this);
        this.objActividad4.getjButton1_Salir_act_5().addActionListener(this);

       
        MouseAdapter mouseHoverAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();
                String palabra = label.getText();
                if (palabra != null && !palabra.isEmpty()) {
                    reproducirAudio(palabra);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getSource();
                seleccionUsuario = label.getText();
                verificarSeleccion();
            }
        };

       
        this.objActividad4.getjLabel_word1().addMouseListener(mouseHoverAdapter);
        this.objActividad4.getjLabel_word2().addMouseListener(mouseHoverAdapter);
        this.objActividad4.getjLabel_word3().addMouseListener(mouseHoverAdapter);

        v = Verificador.getInstancia();
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        this.palabrasDAO = ControlGestorPalabras.getInstance();

        asignarPalabraAJLabels();
        seleccionarPalabraCorrecta();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objActividad4.getjButton1_Salir_act_5()) {
            Menu m = new Menu();
            m.setVisible(true);
            if (objActividad4 != null) {
                objActividad4.dispose();
            }
            if (this.v.getNom() == null) {
                System.out.println("no hay usuario");
                return;
            } else {
                int tiempoTotal = (int) TiempoActivo.getInstancia().getTiempoActivo();
                ControlGestorTiempo.getInstancia().guardarTiempo(v.getId(), tiempoTotal);
            }
        } else if (e.getSource() == this.objActividad4.getjButton1_audio_palabra()) {
            reproducirAudio(palabraCorrecta);
            audioReproducido = true;
        } else if (e.getSource() == this.objActividad4.getjButton1_Cambiar_audio_palabra()) {
            asignarPalabraAJLabels();
            seleccionarPalabraCorrecta();
            reproducirAudio(palabraCorrecta);
            System.out.println("Nueva palabra correcta: " + palabraCorrecta);
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
        int indiceAleatorio = (int) (Math.random() * palabras.length);
        palabraCorrecta = palabras[indiceAleatorio];
        System.out.println("palabra correcta: " + palabraCorrecta);
    }

    private void reproducirAudio(String palabra) {
        String rutaAudio = "/resource/sounds/" + palabra + ".wav";
        reproducirSonido(rutaAudio);
    }

    private void verificarSeleccion() {
        if (!audioReproducido || seleccionUsuario == null) {
            reproducirSonido("/resource/sounds/audioUno.wav");
            JOptionPane.showMessageDialog(null, "Escucha el audio antes de seleccionar");
            return;
        }

        if (seleccionUsuario.equals(palabraCorrecta)) {
            reproducirSonido("/resource/sounds/muy_bien.wav");
            JOptionPane.showMessageDialog(null, "Correcto. La palabra era: " + palabraCorrecta);
            asignarPalabraAJLabels();
            seleccionarPalabraCorrecta();
            reproducirAudio(palabraCorrecta);
        } else {
            reproducirSonido("/resource/sounds/incorrecto.wav");
            JOptionPane.showMessageDialog(null, "Incorrecto. La palabra correcta era: " + palabraCorrecta);
        }
    }
}
