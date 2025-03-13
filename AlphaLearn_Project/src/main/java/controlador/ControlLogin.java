
package controlador;

import vistas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
import utils.Slide;
import vistas.Menu;

/**
 *
 * @author juare
 */
public class ControlLogin implements ActionListener {
    private Login log;
    private Slide slide;
    private Verificador objVerificador; 
    private UsuarioDAO objDAOU;
    public ControlLogin(Login log) {
        this.log = log;
        slide = new Slide();
        log.getjB_iniciar_sesion().addActionListener(this);
        log.getjB_ir_Registro().addActionListener(this);
        log.getjButton1_guardar().addActionListener(this);
        //objVerificador = new Verificador();
        objVerificador = Verificador.getInstancia();
        objDAOU = UsuarioDAO.getInstance();
    }

    public void moverIzquierdaInfo() {
        slide.jPanelXIzquierda(0, -520, 10, 5, log.getJP_info_regis());
    }

    public void moverDerechaInfo() {
        slide.jPanelXDerecha(-520, 0, 10, 5, log.getJP_info_regis());
    }

    public void moverDerchaRegistro() {
        slide.jPanelYAbajo(-600, 0, 10, 5, log.getjPanel_Registrar());
    }

    public void moverArribaRegistro() {
        slide.jPanelYArriba(0, -600, 10, 5, log.getjPanel_Registrar());
    }

    public void limpiar() {
        log.getjTextField1_Nom_User_Registra().setText("");
        log.getjT_Edad_Registrar().setText("");
        log.getjPasswordField2_Registrar().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log.getjB_iniciar_sesion()) {
            if (!objVerificador.validaUsuario(
                    log.getjText_Nom_Usuario().getText(),
                    log.getjPasswordField1().getText())) {
                return;
            } else {
                Menu m = new Menu();
                m.setVisible(true);
                if (log != null) {
                    log.dispose();
                }
            }
        }

        if (e.getSource() == log.getjB_ir_Registro()) {
            moverIzquierdaInfo();
            moverDerchaRegistro();
        }

        if (e.getSource() == log.getjButton1_guardar()) {
            if (!validarDatos()) {
                return;
            }

            String nombreUsuario = log.getjTextField1_Nom_User_Registra().getText().trim();
            String contraseñaUsuario = log.getjPasswordField2_Registrar().getText().trim();

            System.out.println("Nombre de usuario: " + nombreUsuario);
            System.out.println("Contraseña: " + contraseñaUsuario);
            System.out.println("Edad: " + log.getjT_Edad_Registrar().getText().trim());

            /*if (objVerificador.existeUsuario(objOperacionesBDUsuario, nombreUsuario, contraseñaUsuario)) {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre o contraseña.");
                return;
            }*/
            if (objVerificador.existeUsuario1(objDAOU, nombreUsuario, contraseñaUsuario)) {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre o contraseña.");
                return;
            }
            Usuario objUsuario = new Usuario();
            objUsuario.setNom(nombreUsuario);
            objUsuario.setEdad(Integer.parseInt(log.getjT_Edad_Registrar().getText()));
            objUsuario.setContraseña(contraseñaUsuario);

            // Guardamos en la base de datos usando el Singleton
            /*objOperacionesBDUsuario.setObjUsuario(objUsuario);
            objOperacionesBDUsuario.create();*/
            objDAOU.setObjUsuario(objUsuario);
            try {
                objDAOU.crearUsuario();
            } catch (Exception ex) {
                Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");

            moverArribaRegistro();
            moverDerechaInfo();
            limpiar();
        }
    }

    public boolean validarDatos() {
        boolean validNombre = objVerificador.verificaCajaTextoCadena(log.getjTextField1_Nom_User_Registra());
        boolean validContraseña = objVerificador.verificaCajaTextoCadena(log.getjPasswordField2_Registrar());
        boolean validEdad = objVerificador.verificaCajaTextoEntero(log.getjPasswordField1());

        return validNombre && validContraseña && validEdad;
    }
    
    
}
