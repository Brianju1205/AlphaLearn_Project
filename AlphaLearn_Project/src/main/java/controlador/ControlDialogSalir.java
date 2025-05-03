/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vistas.Dialog_Salir;

/**
 *
 * @author juare
 */
public class ControlDialogSalir implements ActionListener{
    
    private Dialog_Salir vista;
    private JFrame ventanaPadre;
    private boolean salirConfirmado = false;
    public ControlDialogSalir(JFrame ventanaPadre) {
        this.ventanaPadre = ventanaPadre;
        this.vista = new Dialog_Salir(ventanaPadre, true);
        vista.getjButton_cancelar().addActionListener(this);
        vista.getjButton_Salir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.getjButton_Salir()){
            salirConfirmado = true;
            vista.dispose();
        }else if(e.getSource() == vista.getjButton_cancelar()){
            salirConfirmado = false;
            vista.dispose();
        }
    }

    public void mostrarDialogo() {
        vista.setLocationRelativeTo(ventanaPadre);
        vista.setVisible(true);
    }  
    public boolean isSalirConfirmado() {
        return salirConfirmado;
    }
}
