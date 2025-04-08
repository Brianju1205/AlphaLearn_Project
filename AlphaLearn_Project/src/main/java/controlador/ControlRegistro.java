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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import modelo.Usuario;
import vistas.Login_inclusivo;
import vistas.Registro;

/**
 *
 * @author juare
 */
public class ControlRegistro implements ActionListener {
    private Registro r;
    private Verificador objVerificador; 
    private UsuarioDAO objDAOU;
    private ArrayList<JButton> iconosPerfilRegistro = new ArrayList<>();
    private ArrayList<JToggleButton> formasSeleccionadas = new ArrayList<>();
    private JButton iconoSeleccionadoRegistro = null;

    public ControlRegistro(Registro r) {
        this.r = r;
        colocarEscuchadores();
        objVerificador = Verificador.getInstancia();
        objDAOU = UsuarioDAO.getInstance();
    }

    private void colocarEscuchadores() {
        int index = 0;
        int indexr = 0;
        int IndexR = 0;
        int IndexL = 0;

        for (Component comp : r.getjPanel_Registrar().getComponents()) {
            if (comp instanceof JButton bt) {
                String textoBoton = bt.getText();
                String comandoBoton = bt.getActionCommand();

                if (!textoBoton.equals("Guardar") && !textoBoton.equals("Salir")) {
                    bt.addActionListener(this);
                    bt.setActionCommand("index"+index);

                    // bt.setActionCommand("iconoRegistro_" + index);
                    bt.setBorderPainted(true);
                    bt.setFocusPainted(false);
                    bt.setEnabled(true);

                    iconosPerfilRegistro.add(bt);
                    index++;
                }
            }
            /*if (comp instanceof JToggleButton tg) {
                tg.addActionListener(this);
                formasSeleccionadas.add(tg);
                IndexR++;
                tg.putClientProperty("index", IndexR);
                // tg.setActionCommand("formaRegistro_" + IndexR);
            }*/
            if (comp instanceof JToggleButton tg) {
                IndexR++;
                tg.putClientProperty("index", IndexR);

                tg.addItemListener(e -> {
                    if (e.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                        if (formasSeleccionadas.size() >= 4) {
                            JToggleButton removida = formasSeleccionadas.remove(0);
                            removida.setSelected(false);
                            removida.setOpaque(false);
                            removida.setContentAreaFilled(false);
                        }
                        formasSeleccionadas.add(tg);
                        tg.setOpaque(true);
                        tg.setContentAreaFilled(true);
                        //System.out.println("Seleccionada forma en registro: " + tg.getClientProperty("index"));
                    } else {
                        formasSeleccionadas.remove(tg);
                        tg.setOpaque(false);
                        tg.setContentAreaFilled(false);
                    }
                });
            }
        }
        r.getjButton1_Salir1().addActionListener(this);
        r.getjButton1_guardar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (JButton icono : iconosPerfilRegistro) {

            if (source == icono) {
                if (iconoSeleccionadoRegistro != null) {
                    iconoSeleccionadoRegistro.setBorder(null);
                }
                icono.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                iconoSeleccionadoRegistro = icono;
                
                //System.out.println("Índice del icono: " + icono.getActionCommand());
                // System.out.println("Seleccionado icono de registro: " + icono.getActionCommand());
                return;

            }
        }

        if (source == r.getjButton1_guardar()) {
             
             if (iconoSeleccionadoRegistro == null) {
                javax.swing.JOptionPane.showMessageDialog(r, "Por favor, selecciona un ícono de perfil antes de continuar.");
                return;
            }
            if (formasSeleccionadas.size() != 4) {
                javax.swing.JOptionPane.showMessageDialog(r, "Debes seleccionar exactamente 4 formas para tu contraseña.");
                return;
            }
            String iconoPerfilSeleccionado = obtenerIconoPerfilSeleccionado();
            //int iconoPerfil = obtenerIndiceIcono();
            String password = obtenerPasswordFinal();

            /*System.out.println("icono de perfil: " + iconoPerfilSeleccionado);
            System.out.println("Contraseña: " + password);*/
            if(objVerificador.existeUsuario1(objDAOU, iconoPerfilSeleccionado, password)){
               javax.swing.JOptionPane.showMessageDialog(r, "Usuario y contraseña ya existe ");
            return;
            }
            Usuario objUsuario = new Usuario();
            objUsuario.setNom(iconoPerfilSeleccionado);
            objUsuario.setContraseña(password);
            objDAOU.setObjUsuario(objUsuario);
            try {
                objDAOU.crearUsuario();
            } catch (Exception ex) {
                Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }


            Login_inclusivo l = new Login_inclusivo();
            /*l.setVisible(true);
            if (r != null) {
                r.dispose();
            }*/
        }
        if(source == r.getjButton1_Salir1()){
            Login_inclusivo L = new Login_inclusivo();
            L.setVisible(true);
            if (r != null) {
                r.dispose();
            }
        }
    }
    private String obtenerIconoPerfilSeleccionado() {
        if (iconoSeleccionadoRegistro != null) {
            return iconoSeleccionadoRegistro.getActionCommand();
        }
        return ""; // o null si prefieres
    }
    private int obtenerIndiceIcono() {
        if (iconoSeleccionadoRegistro != null) {
            return (int) iconoSeleccionadoRegistro.getClientProperty("index");
        }
        return -1;
    }

    private String obtenerPasswordFinal() {
        StringBuilder password = new StringBuilder();
        for (JToggleButton f : formasSeleccionadas) {
            Object indexObj = f.getClientProperty("index");
            if (indexObj instanceof Integer) {
                password.append((int) indexObj);
            }
        }
        return password.toString();
    }
}
