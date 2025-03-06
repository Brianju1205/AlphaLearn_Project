/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.Actividad_1;
import vistas.Menu;

/**
 *
 * @author juare
 */
public class ControlMenu implements ActionListener{
    
    Menu objMenu;

    public ControlMenu(Menu objMenu) {
        this.objMenu = objMenu;
        this.objMenu.getjButton_Actividad1().addActionListener(this);
        this.objMenu.getjButton_Actividad2().addActionListener(this);
        this.objMenu.getjButton_Actividad3().addActionListener(this);
        this.objMenu.getjButton_Actividad4().addActionListener(this);
        this.objMenu.getjButton_Actividad5().addActionListener(this);
        this.objMenu.getjButton_Actividad6().addActionListener(this);
        this.objMenu.getjButton5_Salir_Menu().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.objMenu.getjButton_Actividad1()){
            Actividad_1 a = new Actividad_1();
            a.setVisible(true);
            if (objMenu != null) {   
            objMenu.dispose(); 
            }
        }
        if(e.getSource() == this.objMenu.getjButton5_Salir_Menu()){
            if (objMenu != null) {   
            objMenu.dispose(); 
            }
        }
    }
    
}
