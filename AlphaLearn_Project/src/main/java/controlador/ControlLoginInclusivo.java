
package controlador;

import java.awt.Color;
import java.awt.Component;
import vistas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import modelo.Usuario;
import utils.Slide;
import vistas.Login_inclusivo;
import vistas.Menu;
import vistas.Registro;

/**
 *
 * @author juare
 */

public class ControlLoginInclusivo implements ActionListener {
    private Login_inclusivo logi;
    private Slide slide;
    private UsuarioDAO objDAOU;

    private ArrayList<JButton> iconosPerfilRegistro = new ArrayList<>();
    private ArrayList<JToggleButton> formasSeleccionadas = new ArrayList<>();
    private ArrayList<JButton> iconosPerfilLogin = new ArrayList<>();
    private ArrayList<JToggleButton> formasSeleccionadasLogin = new ArrayList<>();
    private JButton iconoSeleccionadoRegistro = null;
    private JButton iconoSeleccionadoLogin = null;

    public ControlLoginInclusivo(Login_inclusivo logi) {
        this.logi = logi;
        slide = new Slide();
        objDAOU = UsuarioDAO.getInstance();
        colocarEscuchadores();
    }

    private void colocarEscuchadores() {
        int index = 0;
        int indexr =0;
        int IndexR = 0;
        int IndexL = 0;

        /*for (Component comp : logi.getjPanel_Registrar().getComponents()) {
            if (comp instanceof JButton bt) {
                String textoBoton = bt.getText(); 
                String comandoBoton = bt.getActionCommand(); 

                if (!textoBoton.equals("Guardar") && !textoBoton.equals("Borrar")) { 
                    bt.addActionListener(this);
                    bt.setActionCommand("iconoRegistro_" + index); 
                    bt.setBorderPainted(true);
                    bt.setFocusPainted(false);
                    bt.setEnabled(true);

                    iconosPerfilRegistro.add(bt);
                    index++;
                }
            }
            if (comp instanceof JToggleButton tg) {
                tg.addActionListener(this);
                formasSeleccionadas.add(tg);
                IndexR++;
                tg.setActionCommand("formaRegistro_" + IndexR);
            }
        }*/

        indexr = 0;
        for (Component comp : logi.getJpLogin().getComponents()) {
            if (comp instanceof JButton bt) {
                String textoBoton = bt.getText(); 

                if (!textoBoton.equals("Iniciar")) { 
                    bt.addActionListener(this);
                    bt.setActionCommand("iconoLogin_" + indexr);
                    bt.setBorderPainted(true);
                    bt.setFocusPainted(false);
                    bt.setEnabled(true);

                    iconosPerfilLogin.add(bt);
                    indexr++;
                }
            }
            if (comp instanceof JToggleButton tg) {
                tg.addActionListener(this);
                IndexL++;
                tg.setActionCommand("formaLogin_" + IndexL);
                formasSeleccionadasLogin.add(tg);
            }
        }

        //logi.getjButton1_guardar().addActionListener(this);
        logi.getjB_iniciar_sesion().addActionListener(this);
        logi.getjB_ir_Registro().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (JButton icono : iconosPerfilLogin) {
            
            if (source == icono) {
                if (iconoSeleccionadoLogin != null) {
                    iconoSeleccionadoLogin.setBorder(null);
                }
                icono.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
                iconoSeleccionadoLogin = icono;
                System.out.println("Seleccionado icono de login: " + icono.getActionCommand());
                return;
            }
        }
        

        if (source instanceof JToggleButton forma) {
            if (formasSeleccionadasLogin.contains(forma)) {
                    formasSeleccionadasLogin.remove(forma);
                    forma.setSelected(false);
                    forma.setOpaque(false);
                    forma.setContentAreaFilled(false);
                } else {
                    if (formasSeleccionadasLogin.size() <= 3) {
                        JToggleButton removida = formasSeleccionadasLogin.remove(0);
                        removida.setSelected(false);
                        removida.setOpaque(false);
                        removida.setContentAreaFilled(false);
                    }
                    formasSeleccionadasLogin.add(forma);
                    forma.setSelected(true);
                    forma.setOpaque(true);
                    forma.setContentAreaFilled(true);
                    forma.setBackground(Color.GRAY);
                   // System.out.println("Seleccionada forma en registro: " + forma.getActionCommand());
            }
        }
    

        if (source == logi.getjB_iniciar_sesion()) {
            //iniciarSesion();
            Menu m = new Menu();
                m.setVisible(true);
                if (logi != null) {
                    logi.dispose();
                }
        }

        if (source == logi.getjB_ir_Registro()) {
           Registro r = new Registro();
           r.setVisible(true);
           if(logi!= null){
               logi.dispose();
           }
        }
    }

    private void registrarUsuario() {
        if (iconoSeleccionadoRegistro == null || formasSeleccionadas.size() < 3) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar 1 icono y 3 formas.");
            return;
        }

        String idIcono = iconoSeleccionadoRegistro.getActionCommand();
        String[] idFormas = new String[3];
        for (int i = 0; i < 3; i++) {
            idFormas[i] = formasSeleccionadas.get(i).getActionCommand();
        }

        //System.out.println("Usuario registrado con icono: " + idIcono + " y formas: " + String.join(", ", idFormas));

    }

    private void iniciarSesion() {
        if (iconoSeleccionadoLogin == null || formasSeleccionadasLogin.size() < 3) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar su icono y 3 formas.");
            return;
        }

        String idIcono = iconoSeleccionadoLogin.getActionCommand();
        String[] idFormas = new String[3];
        for (int i = 0; i < 3; i++) {
            idFormas[i] = formasSeleccionadasLogin.get(i).getActionCommand();
        }

        //System.out.println("inicio de sesiOn con icono: " + idIcono + " y formas: " + String.join(", ", idFormas));


    }

    public void moverIzquierdaInfo() {
        slide.jPanelXIzquierda(0, -520, 10, 5, logi.getJP_info_regis());
    }

    public void moverDerechaInfo() {
        slide.jPanelXDerecha(-520, 0, 10, 5, logi.getJP_info_regis());
    }

    public void moverDerechaRegistro() {
        slide.jPanelYAbajo(-600, 0, 10, 5, logi.getjPanel_Registrar());
    }

    public void moverArribaRegistro() {
        slide.jPanelYArriba(0, -600, 10, 5, logi.getjPanel_Registrar());
    }
}