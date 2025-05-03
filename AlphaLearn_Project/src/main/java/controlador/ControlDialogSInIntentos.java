/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vistas.Dialog_Terminado;

/**
 *
 * @author juare
 */
public class ControlDialogSInIntentos implements ActionListener{
    
    private Dialog_Terminado vista;
    private JFrame jframePadre;
    private boolean reintenar = false;
    private boolean salirConfirmado = false;
    public ControlDialogSInIntentos(JFrame jframePadre) {
        this.jframePadre = jframePadre;
        this.vista = new Dialog_Terminado(jframePadre, true);
        this.vista.getjButton_reintentar().addActionListener(this);
        this.vista.getjButton_Menu().addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getjButton_reintentar()){
            reintenar = true;
            vista.dispose();
        }else if(e.getSource() == vista.getjButton_Menu()){
            salirConfirmado = false;
            vista.dispose();
        }
    }
    
    
    public void mostrarDialogo() {
        vista.setLocationRelativeTo(jframePadre);
        vista.setVisible(true);
    }  

    public boolean isReintenar() {
        return reintenar;
    }

    public boolean isSalirConfirmado() {
        return salirConfirmado;
    }
    
}
