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
import utils.UtilidadesUI;
import vistas.Login_inclusivo_patron;
import vistas.Registro_patron;

/**
 *
 * @author juare
 */
public class ControlRegistroPatron extends AbstractSonido implements ActionListener {
    
    private Registro_patron r;              // Referencia a la vista de registro con patrón
    private Verificador objVerificador; 
    private UsuarioDAO objDAOU;
    
    // Listas para manejar botones del patrón y selección de íconos
    private ArrayList<JButton> iconosPerfilRegistro = new ArrayList<>();
    private ArrayList<JButton> PatronSeleccionadasRegistro = new ArrayList<>();
    private JButton iconoSeleccionadoRegistro = null;
    private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
    private ArrayList<Point> puntos = new ArrayList<>();
    
    private boolean estaDibujando = false;
    boolean mostrandoInstruccion = false;
    boolean usuarioGuardado = false;
    public ControlRegistroPatron(Registro_patron r) {
        this.r = r;
        colocarEscuchadores();
        objVerificador = Verificador.getInstancia();
        objDAOU = UsuarioDAO.getInstance();
        
        UtilidadesUI.escalarYAsignar(r.getjButton10_intruccion(), "/resource/informacion.png");
    }

    /**
     * Coloca los escuchadores a los botones del patrón y de los iconos de perfil
     */
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
    
                // Listeners para detectar el dibujo del patrón con mouse
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
                        if(!usuarioGuardado){
                            //guardarRegistro();
                            //reiniciarPatron();
                            usuarioGuardado = false;
                        }
                        
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

                if (!textoBoton.equals("Guardar") && !textoBoton.equals("Salir")&& !textoBoton.equals("instruccion")) {
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
        r.getjButton10_intruccion().addActionListener(this);
        r.getjButton1_Salir1().addActionListener(this);
        r.getjButton1_guardar().addActionListener(this);
    }
    /**
     * Agrega un botón al patrón seleccionado
     */
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
    
    /**
     * Reinicia la selección del patrón, íconos y líneas dibujadas.
     */
    public void reiniciarPatron() {
        for (JButton boton : botonesSeleccionados) {
            boton.setIcon(new ImageIcon(getClass().getResource("/resource/boton1.png"))); 
        }
        botonesSeleccionados.clear();
        puntos.clear();
        ((PanelPatronConLineas) r.getjPanel_patronR()).reiniciarLineas(); 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int vecesTocadas=0;
        Object source = e.getSource();
        for (JButton icono : iconosPerfilRegistro) {

            if (source == icono) {
                if (iconoSeleccionadoRegistro != null) {
                    iconoSeleccionadoRegistro.setBorder(null);
                }
                icono.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
                iconoSeleccionadoRegistro = icono;
                
                System.out.println("Índice del icono: " + icono.getActionCommand());
                 System.out.println("Seleccionado icono de registro: " + icono.getActionCommand());
                return;

            }
        }

        if (source == r.getjButton1_guardar()) {
            guardarRegistro();
            usuarioGuardado = true;
        }
        if(source == r.getjButton1_Salir1()){
            
            Login_inclusivo_patron L = new Login_inclusivo_patron();
            L.setVisible(true);
            if (r != null) {
                stopSonido();
                r.dispose();
            }
        }
      

        if (source == r.getjButton10_intruccion()) {
            if (!mostrandoInstruccion) {
                reproducirSonido("/resource/sounds/paraRegistrarte.wav");
                mostrarInstruccion(this.r.getjPanel_panelDerecha(), "/resource/imagenes/instructoramujer.png", -50, 240);
                mostrandoInstruccion = true;
            } else {
                stopSonido();
                
                mostrandoInstruccion = false;
            }
        }


    }
    
    /**
     * Valida y guarda un nuevo usuario en la base de datos
     */
    private void guardarRegistro(){
                     
             if (iconoSeleccionadoRegistro == null) {
                 reproducirSonido("/resource/sounds/debeElegir.wav");
                 mostrarInstruccion(this.r.getjPanel_panelDerecha(), "/resource/imagenes/instructoramujer.png", -50, 240);
                return;
            }
            if (botonesSeleccionados.size() < 2) {
                 reproducirSonido("/resource/sounds/debeTener.wav");
                 mostrarInstruccion(this.r.getjPanel_panelDerecha(), "/resource/imagenes/instructoramujer.png", -50, 240);
                return;
            }

            String iconoPerfilSeleccionado = obtenerIconoPerfilSeleccionado();
            String password = obtenerPasswordFinal();

            System.out.println("icono de perfil registro: " + iconoPerfilSeleccionado);
            System.out.println("Contraseña registro: " + password);
            if(objVerificador.existeUsuario1(objDAOU, iconoPerfilSeleccionado, password)){
               reproducirSonido("/resource/sounds/usuarioExiste.wav");
               mostrarInstruccion(this.r.getjPanel_panelDerecha(), "/resource/imagenes/instructoramujer.png", -50, 240);
               reiniciarPatron();
               //javax.swing.JOptionPane.showMessageDialog(r, "Usuario y contraseña ya existe ");
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


            Login_inclusivo_patron L = new Login_inclusivo_patron();
            L.setVisible(true);
            if (r != null) {
                stopSonido();
                r.dispose();
            }
    }
    
    /**
     * Retorna el comando del botón de ícono seleccionado
     */
    private String obtenerIconoPerfilSeleccionado() {
        if (iconoSeleccionadoRegistro != null) {
            return iconoSeleccionadoRegistro.getActionCommand();
        }
        return ""; 
    }
    
    /**
     * Retorna el índice del ícono seleccionado
     */
    private int obtenerIndiceIcono() {
        if (iconoSeleccionadoRegistro != null) {
            return (int) iconoSeleccionadoRegistro.getClientProperty("index");
        }
        return -1;
    }

    /**
     * Genera la contraseña en base a los índices de los botones del patrón seleccionados
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
