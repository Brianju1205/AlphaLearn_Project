/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author juare
 */
public class Ajustes extends javax.swing.JPanel {

    /**
     * Creates new form Sonido
     */
    public Ajustes() {
        initComponents();
    }

    public JLabel getjLabel7_numero_de_volumen() {
        return jLabel7_numero_de_volumen;
    }
    
    public JButton getjButton_cambiar_contraseña() {
        return jButton_cambiar_contraseña;
    }

    public JButton getjButton_guardarCambios() {
        return jButton_guardarCambios;
    }

    public JCheckBox getjCheckBox1_sonido() {
        return jCheckBox1_sonido;
    }

    public JCheckBox getjCheckBox2_instrucciones() {
        return jCheckBox2_instrucciones;
    }

    public JPanel getjPanel_Menu() {
        return jPanel_Menu;
    }

    public JSlider getjSlider1_volumen() {
        return jSlider1_volumen;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7_numero_de_volumen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1_sonido = new javax.swing.JCheckBox();
        jCheckBox2_instrucciones = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jButton_guardarCambios = new javax.swing.JButton();
        jButton_cambiar_contraseña = new javax.swing.JButton();
        jSlider1_volumen = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Menu.setBackground(new java.awt.Color(232, 232, 232));
        jPanel_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("AJUSTES");
        jPanel_Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 110, 34));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Instrucciones");
        jPanel_Menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Sonido");
        jPanel_Menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel7_numero_de_volumen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7_numero_de_volumen.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7_numero_de_volumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel_Menu.add(jLabel7_numero_de_volumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 50, 20));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Volumen");
        jPanel_Menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Menu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 350, 20));

        jCheckBox1_sonido.setSelected(true);
        jCheckBox1_sonido.setContentAreaFilled(false);
        jCheckBox1_sonido.setIconTextGap(10);
        jCheckBox1_sonido.setPreferredSize(null);
        jPanel_Menu.add(jCheckBox1_sonido, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 20, 30));

        jCheckBox2_instrucciones.setSelected(true);
        jCheckBox2_instrucciones.setContentAreaFilled(false);
        jCheckBox2_instrucciones.setIconTextGap(10);
        jCheckBox2_instrucciones.setPreferredSize(null);
        jPanel_Menu.add(jCheckBox2_instrucciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 20, 30));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cambiar contraseña");
        jPanel_Menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, -1, -1));

        jButton_guardarCambios.setBackground(new java.awt.Color(51, 51, 255));
        jButton_guardarCambios.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton_guardarCambios.setText("Guardar");
        jPanel_Menu.add(jButton_guardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 360, 60));

        jButton_cambiar_contraseña.setBackground(new java.awt.Color(102, 102, 255));
        jButton_cambiar_contraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_cambiar_contraseña.setText("Cambiar");
        jPanel_Menu.add(jButton_cambiar_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 360, -1));
        jPanel_Menu.add(jSlider1_volumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 230, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Ajustes frame.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel_Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 470, 560));

        add(jPanel_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 590));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cambiar_contraseña;
    private javax.swing.JButton jButton_guardarCambios;
    private javax.swing.JCheckBox jCheckBox1_sonido;
    private javax.swing.JCheckBox jCheckBox2_instrucciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7_numero_de_volumen;
    private javax.swing.JPanel jPanel_Menu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1_volumen;
    // End of variables declaration//GEN-END:variables
}
