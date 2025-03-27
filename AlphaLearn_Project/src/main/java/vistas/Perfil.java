/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import controlador.ControlPerfil;
import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author juare
 */
public class Perfil extends javax.swing.JPanel {

    /**
     * Creates new form Progreso
     */
    ControlPerfil controlPerfil;
    public Perfil() {
        initComponents();
        controlPerfil = new ControlPerfil(this);
    }

    public JLabel getjLabel3_Edad() {
        return jLabel3_Edad;
    }

    public JLabel getjLabel3_Name() {
        return jLabel3_Name;
    }

    public JPanel getjPanel1_grafica() {
        return jPanel1_grafica;
    }

    public JPanel getjPanel_Menu() {
        return jPanel_Menu;
    }

    public JProgressBar getjProgressBar1_modulo_6() {
        return jProgressBar1_modulo_6;
    }

    public JProgressBar getjProgressBar2_modulo_1() {
        return jProgressBar2_modulo_1;
    }

    public JProgressBar getjProgressBar3_modulo_2() {
        return jProgressBar3_modulo_2;
    }

    public JProgressBar getjProgressBar4_modulo_3() {
        return jProgressBar4_modulo_3;
    }

    public JProgressBar getjProgressBar5_modulo_4() {
        return jProgressBar5_modulo_4;
    }

    public JProgressBar getjProgressBar6_modulo_5() {
        return jProgressBar6_modulo_5;
    }

    public static float getTOP_ALIGNMENT() {
        return TOP_ALIGNMENT;
    }

    public static float getCENTER_ALIGNMENT() {
        return CENTER_ALIGNMENT;
    }

    public static float getBOTTOM_ALIGNMENT() {
        return BOTTOM_ALIGNMENT;
    }

    public static float getLEFT_ALIGNMENT() {
        return LEFT_ALIGNMENT;
    }

    public static float getRIGHT_ALIGNMENT() {
        return RIGHT_ALIGNMENT;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getPROPERTIES() {
        return PROPERTIES;
    }

    public static int getSOMEBITS() {
        return SOMEBITS;
    }

    public static int getFRAMEBITS() {
        return FRAMEBITS;
    }

    public static int getALLBITS() {
        return ALLBITS;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getABORT() {
        return ABORT;
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
        jLabel3_Name = new javax.swing.JLabel();
        jLabel3_Edad = new javax.swing.JLabel();
        jPanel1_grafica = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jProgressBar1_modulo_6 = new javax.swing.JProgressBar();
        jProgressBar2_modulo_1 = new javax.swing.JProgressBar();
        jProgressBar3_modulo_2 = new javax.swing.JProgressBar();
        jProgressBar4_modulo_3 = new javax.swing.JProgressBar();
        jProgressBar5_modulo_4 = new javax.swing.JProgressBar();
        jProgressBar6_modulo_5 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPanel_Menu.setBackground(new java.awt.Color(232, 232, 232));
        jPanel_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono perfil.png"))); // NOI18N
        jPanel_Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel3_Name.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3_Name.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jPanel_Menu.add(jLabel3_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 110, 40));

        jLabel3_Edad.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jPanel_Menu.add(jLabel3_Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 80, 50));

        jPanel1_grafica.setOpaque(false);

        javax.swing.GroupLayout jPanel1_graficaLayout = new javax.swing.GroupLayout(jPanel1_grafica);
        jPanel1_grafica.setLayout(jPanel1_graficaLayout);
        jPanel1_graficaLayout.setHorizontalGroup(
            jPanel1_graficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel1_graficaLayout.setVerticalGroup(
            jPanel1_graficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );

        jPanel_Menu.add(jPanel1_grafica, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 420, 290));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(true);
        jPanel_Menu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 430, 300));

        jProgressBar1_modulo_6.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar1_modulo_6.setValue(10);
        jPanel_Menu.add(jProgressBar1_modulo_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 90, 80));

        jProgressBar2_modulo_1.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar2_modulo_1.setToolTipText("");
        jProgressBar2_modulo_1.setValue(10);
        jPanel_Menu.add(jProgressBar2_modulo_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 90, 80));

        jProgressBar3_modulo_2.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar3_modulo_2.setValue(10);
        jPanel_Menu.add(jProgressBar3_modulo_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 90, 80));

        jProgressBar4_modulo_3.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar4_modulo_3.setValue(10);
        jPanel_Menu.add(jProgressBar4_modulo_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 90, 80));

        jProgressBar5_modulo_4.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar5_modulo_4.setValue(10);
        jPanel_Menu.add(jProgressBar5_modulo_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 90, 80));

        jProgressBar6_modulo_5.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar6_modulo_5.setToolTipText("");
        jProgressBar6_modulo_5.setValue(10);
        jPanel_Menu.add(jProgressBar6_modulo_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 90, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Actividad reciente");
        jPanel_Menu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Palabras dificiles");
        jPanel_Menu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Perfil de Usuario");
        jPanel_Menu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 200, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Progreso de los modulos");
        jPanel_Menu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Perfil de usuario frame.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel_Menu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_Edad;
    private javax.swing.JLabel jLabel3_Name;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1_grafica;
    private javax.swing.JPanel jPanel_Menu;
    private javax.swing.JProgressBar jProgressBar1_modulo_6;
    private javax.swing.JProgressBar jProgressBar2_modulo_1;
    private javax.swing.JProgressBar jProgressBar3_modulo_2;
    private javax.swing.JProgressBar jProgressBar4_modulo_3;
    private javax.swing.JProgressBar jProgressBar5_modulo_4;
    private javax.swing.JProgressBar jProgressBar6_modulo_5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
