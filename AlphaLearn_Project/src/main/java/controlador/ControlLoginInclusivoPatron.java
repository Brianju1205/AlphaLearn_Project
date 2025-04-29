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
import vistas.Login_inclusivo_patron;
import vistas.Menu;
import vistas.Registro_patron;

/**
 * Controlador para el login inclusivo con patrón, Este controlador
 * permite a los usuarios seleccionar un ícono de perfil 
 * y dibujar un patrón como contraseña
 * 
 * @author juare
 */

public class ControlLoginInclusivoPatron extends AbstractSonido implements ActionListener {
    
    private Login_inclusivo_patron logi;
    private Slide slide;
    private UsuarioDAO objDAOU;
    private Verificador objVerificador;
    
    // Listas de botones e íconos usados en el login
    private ArrayList<JButton> iconosPerfilLogin = new ArrayList<>();
    private ArrayList<JButton> PatronSeleccionadasLogin = new ArrayList<>();
    private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
    private ArrayList<Point> puntos = new ArrayList<>();
    private boolean estaDibujando = false;
    private JButton iconoSeleccionadoRegistro = null;
    private JButton iconoSeleccionadoLogin = null;
    private int intentos;
    
    /**
     * Constructor del login
     * @param logi 
     */
    public ControlLoginInclusivoPatron(Login_inclusivo_patron logi) {
        this.logi = logi;
        slide = new Slide();
        objVerificador = Verificador.getInstancia();
        objDAOU = UsuarioDAO.getInstance();
        colocarEscuchadores();
    }
    /**
     * Asocia los botones e íconos con sus respectivos escuchadores
     */
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
                
                // escuchadores para detectar el dibujo del patrón con el mouse
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
    
    /**
     * Agrega visualmente un boton seleccionado al momento de dibujar el patron
     */
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

    /**
     * Reinicia el patrón sin botones seleccionados
     */
    public void reiniciarPatron() {
        for (JButton boton : botonesSeleccionados) {
            boton.setIcon(new ImageIcon(getClass().getResource("/resource/boton1.png"))); 
        }
        botonesSeleccionados.clear(); 
        puntos.clear(); 
        ((PanelPatronConLineas) logi.getJpanel_Patron()).reiniciarLineas();
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        for (JButton icono : iconosPerfilLogin) {
            
            if (e.getSource() == icono) {
                if (iconoSeleccionadoLogin != null) {
                    iconoSeleccionadoLogin.setBorder(null);
                }
                icono.setBorder(BorderFactory.createLineBorder(Color.GREEN, 8));
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

    /**
     * Valida los datos ingresados y verifica si el usuario existe
     */
    private void iniciarSesion() {
        if (iconoSeleccionadoLogin == null) {
             reproducirSonido("/resource/sounds/debeElegir.wav");
             mostrarInstruccion(this.logi.getJpLogin(), "/resource/imagenes/instructoramujer.png", -50, 240);
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
        
        if (!objVerificador.validaUsuario(iconoPerfilSeleccionado,password)) {
            intentos++;

            if(intentos == 3){
                reproducirSonido("/resource/sounds/NoRegistro.wav");
               // mostrarInstruccion(this.logi.getJpLogin(), "/resource/imagenes/instructoramujer.png",180, 290);
                mostrarInstruccion(this.logi.getJP_info_regis(), "/resource/flecha.gif",40,250);
            } else {
                reproducirSonido("/resource/sounds/perfilOpatron.wav");
                mostrarInstruccion(this.logi.getJpLogin(), "/resource/imagenes/instructoramujer.png",180, 290);
                
            }

            return;
        }//
         else {
                Menu m = new Menu();
                m.setVisible(true);
                if (logi != null) {
                    logi.dispose();
                }
            }
    }

    /**
     * Obtiene el identificador del ícono de perfil seleccionado
     */
    private String obtenerIconoPerfilSeleccionado() {
        if (iconoSeleccionadoLogin != null) {
            return iconoSeleccionadoLogin.getActionCommand();
        }
        return ""; 
    }
    
    /**
     * Devuelve el índice del ícono seleccionado en registro
     */
    private int obtenerIndiceIcono() {
        if (iconoSeleccionadoRegistro != null) {
            return (int) iconoSeleccionadoRegistro.getClientProperty("index");
        }
        return -1;
    }

    /**
     * Apartir del patron seleccionado devuelve como cadena la contraseña
     * 
     */
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