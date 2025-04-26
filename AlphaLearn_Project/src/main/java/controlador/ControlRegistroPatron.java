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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import modelo.Usuario;
import utils.PanelPatronConLineas;
import vistas.Login_inclusivo;
import vistas.Login_inclusivo_patron;
import vistas.Registro;
import vistas.Registro_patron;

/**
 *
 * @author juare
 */
public class ControlRegistroPatron extends AbstractSonido implements ActionListener {
    private Registro_patron r;
    private Verificador objVerificador; 
    private UsuarioDAO objDAOU;
    private ArrayList<JButton> iconosPerfilRegistro = new ArrayList<>();
    private ArrayList<JToggleButton> formasSeleccionadas = new ArrayList<>();
    private ArrayList<JButton> PatronSeleccionadasRegistro = new ArrayList<>();
    private JButton iconoSeleccionadoRegistro = null;
    private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
    private ArrayList<Point> puntos = new ArrayList<>();
    private boolean estaDibujando = false;
    public ControlRegistroPatron(Registro_patron r) {
        this.r = r;
        colocarEscuchadores();
        objVerificador = Verificador.getInstancia();
        objDAOU = UsuarioDAO.getInstance();
        reproducirSonido("/resource/sounds/instruccionregistrologin.wav");
        mostrarInstruccion(this.r.getjPanel_Registrar(),"/resource/imagenes/instructoramujer.png",180,290);
    }

    private void colocarEscuchadores() {
        int index = 0;
        int indexr = 0;
        int IndexR = 0;
        int IndexL = 0;
        
        for (Component comp : r.getjPanel_patronR().getComponents()) {
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
                        guardarRegistro();
                        reiniciarPatron();
                    }
                });
            
            PatronSeleccionadasRegistro.add(bt);
            indexr++;
            }   
        }
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
        }
        r.getjButton1_Salir1().addActionListener(this);
        r.getjButton1_guardar().addActionListener(this);
    }
    private void agregarBoton(JButton bt) {
        if (!botonesSeleccionados.contains(bt)) {
            botonesSeleccionados.add(bt);

            bt.setIcon(new ImageIcon(getClass().getResource("/resource/boton3.png")));

            Point punto = bt.getLocation();
            SwingUtilities.convertPointToScreen(punto, bt.getParent());
            SwingUtilities.convertPointFromScreen(punto, r.getjPanel_patronR());
            punto.translate(bt.getWidth() / 2, bt.getHeight() / 2);
            puntos.add(punto);

            ((PanelPatronConLineas) r.getjPanel_patronR()).agregarPunto(punto);
        }
    }
    public void reiniciarPatron() {
        for (JButton boton : botonesSeleccionados) {
            boton.setIcon(new ImageIcon(getClass().getResource("/resource/boton1.png"))); // Ícono original
        }
        botonesSeleccionados.clear(); // Vacía la lista de botones seleccionados
        puntos.clear(); // Borra los puntos del patrón
        ((PanelPatronConLineas) r.getjPanel_patronR()).reiniciarLineas(); // Este método lo deberías tener en tu panel para limpiar las líneas
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
                 System.out.println("Seleccionado icono de registro: " + icono.getActionCommand());
                return;

            }
        }

        if (source == r.getjButton1_guardar()) {

        }
        if(source == r.getjButton1_Salir1()){
            stopSonido();
            Login_inclusivo_patron L = new Login_inclusivo_patron();
            L.setVisible(true);
            if (r != null) {
                r.dispose();
            }
        }
    }
    private void guardarRegistro(){
                     
             if (iconoSeleccionadoRegistro == null) {
                javax.swing.JOptionPane.showMessageDialog(r, "Por favor, selecciona un ícono de perfil antes de continuar.");
                return;
            }
            if (botonesSeleccionados.size() < 3) {
                javax.swing.JOptionPane.showMessageDialog(r, "Debes seleccionar al menos 3 botones para tu contraseña.");
                return;
            }

            String iconoPerfilSeleccionado = obtenerIconoPerfilSeleccionado();
            //int iconoPerfil = obtenerIndiceIcono();
            String password = obtenerPasswordFinal();

            System.out.println("icono de perfil registro: " + iconoPerfilSeleccionado);
            System.out.println("Contraseña registro: " + password);
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
                Logger.getLogger(ControlRegistroPatron.class.getName()).log(Level.SEVERE, null, ex);
            }


            Login_inclusivo l = new Login_inclusivo();
            /*l.setVisible(true);
            if (r != null) {
                r.dispose();
            }*/
    }
    private String obtenerIconoPerfilSeleccionado() {
        if (iconoSeleccionadoRegistro != null) {
            return iconoSeleccionadoRegistro.getActionCommand();
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
