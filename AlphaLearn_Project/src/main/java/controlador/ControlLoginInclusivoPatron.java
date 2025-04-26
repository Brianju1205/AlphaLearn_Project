/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import utils.PanelPatronConLineas;
import utils.Slide;
import vistas.Login_inclusivo;
import vistas.Login_inclusivo_patron;
import vistas.Menu;
import vistas.Registro;
import vistas.Registro_patron;

/**
 *
 * @author juare
 */

public class ControlLoginInclusivoPatron extends AbstractSonido implements ActionListener {
    private Login_inclusivo_patron logi;
    private Slide slide;
    private UsuarioDAO objDAOU;
    private Verificador objVerificador;
    private ArrayList<JButton> iconosPerfilLogin = new ArrayList<>();
    private ArrayList<JButton> PatronSeleccionadasLogin = new ArrayList<>();
    private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
    private ArrayList<Point> puntos = new ArrayList<>();
    private boolean estaDibujando = false;

    private JButton iconoSeleccionadoRegistro = null;
    private JButton iconoSeleccionadoLogin = null;
    private int intentos;
    public ControlLoginInclusivoPatron(Login_inclusivo_patron logi) {
        this.logi = logi;
        slide = new Slide();
        objVerificador = Verificador.getInstancia();
        objDAOU = UsuarioDAO.getInstance();
        colocarEscuchadores();
    }

    private void colocarEscuchadores() {
        int index = 0;
        int indexr =0;
        int IndexR = 0;
        int IndexL = 0;

        indexr = 0;
        for (Component comp : logi.getJpanel_Patron().getComponents()) {
            if (comp instanceof JButton bt) {
                bt.addActionListener(this);
                bt.setActionCommand("button" + indexr);
                bt.putClientProperty("index", indexr);
                
                bt.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        estaDibujando = true;
                        agregarBoton(bt);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (estaDibujando) {
                            agregarBoton(bt);
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        estaDibujando = false;
                        iniciarSesion();
                        reiniciarPatron();
                    }
                });
            
            PatronSeleccionadasLogin.add(bt);
            indexr++;
            }   
        }
       
        for (Component comp : logi.getJpLogin().getComponents()) {
            if (comp instanceof JButton bt) {
                String textoBoton = bt.getText(); 

                if (!textoBoton.equals("Iniciar")) { 
                    bt.addActionListener(this);
                    bt.setActionCommand("index" + index);
                    bt.setBorderPainted(true);
                    bt.setFocusPainted(false);
                    bt.setEnabled(true);

                    iconosPerfilLogin.add(bt);
                    index++;
                }
            }
        }

        //logi.getjButton1_guardar().addActionListener(this);
        logi.getjB_iniciar_sesion().addActionListener(this);
        logi.getjB_ir_Registro().addActionListener(this);
    }
    private void agregarBoton(JButton bt) {
        if (!botonesSeleccionados.contains(bt)) {
            botonesSeleccionados.add(bt);

            bt.setIcon(new ImageIcon(getClass().getResource("/resource/boton3.png")));

            Point punto = bt.getLocation();
            SwingUtilities.convertPointToScreen(punto, bt.getParent());
            SwingUtilities.convertPointFromScreen(punto, logi.getJpanel_Patron());
            punto.translate(bt.getWidth() / 2, bt.getHeight() / 2);
            puntos.add(punto);

            ((PanelPatronConLineas) logi.getJpanel_Patron()).agregarPunto(punto);
        }
    }

    public void reiniciarPatron() {
        for (JButton boton : botonesSeleccionados) {
            boton.setIcon(new ImageIcon(getClass().getResource("/resource/boton1.png"))); // Ícono original
        }
        botonesSeleccionados.clear(); // Vacía la lista de botones seleccionados
        puntos.clear(); // Borra los puntos del patrón
        ((PanelPatronConLineas) logi.getJpanel_Patron()).reiniciarLineas(); // Este método lo deberías tener en tu panel para limpiar las líneas
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        for (JButton icono : iconosPerfilLogin) {
            
            if (e.getSource() == icono) {
                if (iconoSeleccionadoLogin != null) {
                    iconoSeleccionadoLogin.setBorder(null);
                }
                icono.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                iconoSeleccionadoLogin = icono;
                //System.out.println("Seleccionado icono de login: " + icono.getActionCommand());
                return;
            }
        }
       /* for (JButton boton : PatronSeleccionadasLogin) {
            if (e.getSource() == boton && !botonesSeleccionados.contains(boton)) {
                botonesSeleccionados.add(boton);

               
                Point punto = boton.getLocation();
                SwingUtilities.convertPointToScreen(punto, boton.getParent());
                SwingUtilities.convertPointFromScreen(punto, logi.getJpanel_Patron());
                punto.translate(boton.getWidth() / 2, boton.getHeight() / 2);
                puntos.add(punto);

                ((PanelPatronConLineas) logi.getJpanel_Patron()).agregarPunto(punto);
                return;
            }
        }*/
    
        if (e.getSource() == logi.getjB_iniciar_sesion()) {
            iniciarSesion();
        }

        if (e.getSource() == logi.getjB_ir_Registro()) {
           Registro_patron r = new Registro_patron();
           r.setVisible(true);
           if(logi!= null){
               logi.dispose();
           }
        }
    }

    private void iniciarSesion() {
        if (iconoSeleccionadoLogin == null) {
           // JOptionPane.showMessageDialog(null, "Debe seleccionar su icono.");
            return;  
        }

        /*if (formasSeleccionadasLogin.size() != 4) {
           // JOptionPane.showMessageDialog(null, "Debe seleccionar 4 formas para su contraseña.");
            return;  
        }*/
        String iconoPerfilSeleccionado = obtenerIconoPerfilSeleccionado();
        String password = obtenerPasswordFinal();
        System.out.println("icono de perfil: " + iconoPerfilSeleccionado);
        System.out.println("Contraseña: " + password);
        if(intentos==3){
            reproducirSonido("/resource/sounds/instruccioniniciosesion.wav");
            mostrarInstruccion(this.logi.getJpLogin(),"/resource/imagenes/instructoramujer.png",180,290);
        }
        if (!objVerificador.validaUsuario(iconoPerfilSeleccionado,password)) {
            intentos++;
            return;
        } else {
                Menu m = new Menu();
                m.setVisible(true);
                if (logi != null) {
                    logi.dispose();
                }
            }
    }

    private String obtenerIconoPerfilSeleccionado() {
        if (iconoSeleccionadoLogin != null) {
            return iconoSeleccionadoLogin.getActionCommand();
        }
        return ""; 
    }
    private int obtenerIndiceIcono() {
        if (iconoSeleccionadoRegistro != null) {
            return (int) iconoSeleccionadoRegistro.getClientProperty("index");
        }
        return -1;
    }

    private String obtenerPasswordFinal() {
        StringBuilder password = new StringBuilder();
        for (JButton btn : botonesSeleccionados) {
            Object indexObj = btn.getClientProperty("index");
            if (indexObj instanceof Integer) {
                password.append((int) indexObj);
            }
        }
        return password.toString();
    }

}