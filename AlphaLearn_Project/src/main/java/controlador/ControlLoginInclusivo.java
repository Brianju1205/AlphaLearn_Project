/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import utils.Slide;
import vistas.Login_inclusivo;
import vistas.Menu;
import vistas.Registro;

/**
 *
 * @author juare
 */

public class ControlLoginInclusivo extends AbstractSonido implements ActionListener {
    private Login_inclusivo logi;
    private Slide slide;
    private UsuarioDAO objDAOU;
    private Verificador objVerificador;
    private ArrayList<JButton> iconosPerfilLogin = new ArrayList<>();
    private ArrayList<JToggleButton> formasSeleccionadasLogin = new ArrayList<>();
    private JButton iconoSeleccionadoRegistro = null;
    private JButton iconoSeleccionadoLogin = null;
    private int intentos;
    public ControlLoginInclusivo(Login_inclusivo logi) {
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
        for (Component comp : logi.getJpLogin().getComponents()) {
            if (comp instanceof JButton bt) {
                String textoBoton = bt.getText(); 

                if (!textoBoton.equals("Iniciar")) { 
                    bt.addActionListener(this);
                    bt.setActionCommand("index" + indexr);
                    bt.setBorderPainted(true);
                    bt.setFocusPainted(false);
                    bt.setEnabled(true);

                    iconosPerfilLogin.add(bt);
                    indexr++;
                }
            }
           /* if (comp instanceof JToggleButton tg) {
                tg.addActionListener(this);
                IndexL++;
                tg.setActionCommand("formaLogin_" + IndexL);
                formasSeleccionadasLogin.add(tg);
            }*/
           if (comp instanceof JToggleButton tg) {
                IndexL++;
                tg.putClientProperty("index", IndexL);

                tg.addItemListener(e -> {
                    if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                        if (formasSeleccionadasLogin.size() >= 4) {
                            JToggleButton removida = formasSeleccionadasLogin.remove(0);
                            removida.setSelected(false);
                            removida.setOpaque(false);
                            removida.setContentAreaFilled(false);
                        }
                        formasSeleccionadasLogin.add(tg);
                        tg.setOpaque(true);
                        tg.setContentAreaFilled(true);
                       // System.out.println("Seleccionada forma en registro: " + tg.getClientProperty("index"));
                    } else {
                        formasSeleccionadasLogin.remove(tg);
                        tg.setOpaque(false);
                        tg.setContentAreaFilled(false);
                    }
                });
            }
        }

        //logi.getjButton1_guardar().addActionListener(this);
        logi.getjB_iniciar_sesion().addActionListener(this);
        logi.getjB_ir_Registro().addActionListener(this);
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
    
        if (e.getSource() == logi.getjB_iniciar_sesion()) {
            iniciarSesion();
        }

        if (e.getSource() == logi.getjB_ir_Registro()) {
           Registro r = new Registro();
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

        if (formasSeleccionadasLogin.size() != 4) {
           // JOptionPane.showMessageDialog(null, "Debe seleccionar 4 formas para su contraseña.");
            return;  
        }
        String iconoPerfilSeleccionado = obtenerIconoPerfilSeleccionado();
        String password = obtenerPasswordFinal();
        /*System.out.println("icono de perfil: " + iconoPerfilSeleccionado);
        System.out.println("Contraseña: " + password);*/
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
        for (JToggleButton f : formasSeleccionadasLogin) {
            Object indexObj = f.getClientProperty("index");
            if (indexObj instanceof Integer) {
                password.append((int) indexObj);
            }
        }
        return password.toString();
    }
}