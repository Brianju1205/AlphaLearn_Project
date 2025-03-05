
package controlador;

import vistas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.Slide;

/**
 *
 * @author juare
 */
public class ControlLogin implements ActionListener{
    Login log;
    Slide slide;
    public ControlLogin(Login log) {
        this.log = log;
        slide= new Slide();
        log.getjB_ir_Registro().addActionListener(this);
        log.getjButton1_guardar().addActionListener(this);
    }
    public void moverIzquierdaInfo()
    {
        slide.jPanelXIzquierda(0, -520, 10, 5, log.getJP_info_regis());
    }
    
    public void moverDerechaInfo()
    {
        slide.jPanelXDerecha(-520, 0, 10, 5, log.getJP_info_regis());
    }
    
    public void moverDerchaRegistro()
    {
        slide.jPanelYAbajo(-600, 0, 10, 5, log.getjPanel_Registrar());
    }
    
    public void moverArribaRegistro()
    {
        slide.jPanelYArriba(0, -600, 10, 5, log.getjPanel_Registrar());
    }
    public void limpiar(){
        log.getjTextField1_Nom_User_Registra().setText("");
        log.getjT_Edad_Registrar().setText("");
        log.getjPasswordField2_Registrar().setText("");
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() ==log.getjB_ir_Registro()){
           moverIzquierdaInfo();
           moverDerchaRegistro();
       }
       if (e.getSource() == log.getjButton1_guardar()){
           moverArribaRegistro();
           moverDerechaInfo();
           limpiar();
        }
    }
    
    
}
