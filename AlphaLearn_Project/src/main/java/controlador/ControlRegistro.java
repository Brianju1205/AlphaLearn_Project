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

                if (!textoBoton.equals("Guardar") && !textoBoton.equals("Borrar")) {
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
            if (comp instanceof JToggleButton tg) {
                tg.addActionListener(this);
                formasSeleccionadas.add(tg);
                IndexR++;
                tg.putClientProperty("index", IndexR);
                // tg.setActionCommand("formaRegistro_" + IndexR);
            }

        }
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
                
                System.out.println("Índice del icono: " + icono.getActionCommand());
                // System.out.println("Seleccionado icono de registro: " + icono.getActionCommand());
                return;

            }
        }
        if (source instanceof JToggleButton forma) {
            int indiceForma = (int) forma.getClientProperty("index");

            if (formasSeleccionadas.contains(forma)) {
                
                formasSeleccionadas.remove(forma);
                forma.setSelected(false);
                forma.setOpaque(false);
                forma.setContentAreaFilled(false);
            } else {
                
                if (formasSeleccionadas.size() >= 4) {
                   
                    JToggleButton removida = formasSeleccionadas.remove(0);
                    removida.setSelected(false);
                    removida.setOpaque(false);
                    removida.setContentAreaFilled(false);
                }

               
                formasSeleccionadas.add(forma);
                forma.setSelected(true);
                forma.setOpaque(true);
                forma.setContentAreaFilled(true);
            }

            System.out.println("Seleccionada forma en registro: " + indiceForma);
        }

        if (source == r.getjButton1_guardar()) {
            String iconoPerfilSeleccionado = obtenerIconoPerfilSeleccionado();
            //int iconoPerfil = obtenerIndiceIcono();
            String password = obtenerPasswordFinal();

            System.out.println("Índice del icono: " + iconoPerfilSeleccionado);
            System.out.println("Contraseña: " + password);
            
            Usuario objUsuario = new Usuario();
            objUsuario.setNom(iconoPerfilSeleccionado);
            objUsuario.setContraseña(password);
            objDAOU.setObjUsuario(objUsuario);
            try {
                objDAOU.crearUsuario();
            } catch (Exception ex) {
                Logger.getLogger(ControlRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
         
            
            if (iconoSeleccionadoRegistro != null) {
                iconoSeleccionadoRegistro.setBorder(null);
                iconoSeleccionadoRegistro = null;
            }

            
            for (JToggleButton forma : formasSeleccionadas) {
                forma.setSelected(false);
                forma.setOpaque(false);
                forma.setContentAreaFilled(false);
            }
            formasSeleccionadas.clear();

            Login_inclusivo l = new Login_inclusivo();
            /*l.setVisible(true);
            if (r != null) {
                r.dispose();
            }*/
        }
    }
    private String obtenerIconoPerfilSeleccionado() {
        if (iconoSeleccionadoRegistro != null) {
            return iconoSeleccionadoRegistro.getActionCommand(); // Ejemplo: iconoRegistro_2
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
        return password.toString(); // ejemplo: "1234"
    }
}
