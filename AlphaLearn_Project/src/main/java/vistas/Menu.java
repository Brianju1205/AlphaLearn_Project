/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.ControlMenu;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author juare
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    ControlMenu objControlMenu;
    Menu_Actividades obj;
    public Menu() {
        initComponents();
        setSize(1213, 700); 
        setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setVisible(true);
        obj = new Menu_Actividades(objControlMenu);
        objControlMenu = new ControlMenu(this,obj);

       
    }

    public JLabel getjLabel2_Bienvenida() {
        return jLabel2_Bienvenida;
    }
    

    public JButton getjButton5_Salir_Menu() {
        return jButton5_Salir_Menu;
    }


    public JButton getjButton1_inicio() {
        return jButton1_inicio;
    }

    public JButton getjButton2_ajustes() {
        return jButton2_ajustes;
    }

    public JButton getjButton3_ayuda() {
        return jButton3_ayuda;
    }

    public JPanel getjPanel_Contenido() {
        return jPanel_Contenido;
    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Opciones = new javax.swing.JPanel();
        jButton1_inicio = new javax.swing.JButton();
        jButton2_ajustes = new javax.swing.JButton();
        jButton3_ayuda = new javax.swing.JButton();
        jButton5_Salir_Menu = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel_Contenido = new javax.swing.JPanel();
        jPanel_Mensages = new javax.swing.JPanel();
        jLabel2_Bienvenida = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Opciones.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_Opciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1_inicio.setBackground(new java.awt.Color(45, 130, 181));
        jButton1_inicio.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1_inicio.setForeground(new java.awt.Color(0, 0, 0));
        jButton1_inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/inicio1.png"))); // NOI18N
        jButton1_inicio.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1_inicio.setBorderPainted(false);
        jButton1_inicio.setContentAreaFilled(false);
        jButton1_inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_inicio.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton1_inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1_inicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1_inicio.setIconTextGap(0);
        jButton1_inicio.setInheritsPopupMenu(true);
        jButton1_inicio.setMargin(new java.awt.Insets(10, 14, 3, 14));
        jButton1_inicio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/inicio3.png"))); // NOI18N
        jButton1_inicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/inicio2.png"))); // NOI18N
        jPanel_Opciones.add(jButton1_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 230, 40));

        jButton2_ajustes.setBackground(new java.awt.Color(45, 130, 181));
        jButton2_ajustes.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2_ajustes.setForeground(new java.awt.Color(0, 0, 0));
        jButton2_ajustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ajustes1.png"))); // NOI18N
        jButton2_ajustes.setText("AJUSTES");
        jButton2_ajustes.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2_ajustes.setBorderPainted(false);
        jButton2_ajustes.setContentAreaFilled(false);
        jButton2_ajustes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2_ajustes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2_ajustes.setIconTextGap(15);
        jButton2_ajustes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ajustes3.png"))); // NOI18N
        jButton2_ajustes.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/ajustes2.png"))); // NOI18N
        jPanel_Opciones.add(jButton2_ajustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 230, 40));

        jButton3_ayuda.setBackground(new java.awt.Color(45, 130, 181));
        jButton3_ayuda.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3_ayuda.setForeground(new java.awt.Color(0, 0, 0));
        jButton3_ayuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/perfil1.png"))); // NOI18N
        jButton3_ayuda.setText("AYUDA");
        jButton3_ayuda.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3_ayuda.setBorderPainted(false);
        jButton3_ayuda.setContentAreaFilled(false);
        jButton3_ayuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3_ayuda.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3_ayuda.setIconTextGap(15);
        jButton3_ayuda.setInheritsPopupMenu(true);
        jButton3_ayuda.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/perfil3.png"))); // NOI18N
        jButton3_ayuda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/perfil2.png"))); // NOI18N
        jPanel_Opciones.add(jButton3_ayuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, 40));

        jButton5_Salir_Menu.setBackground(new java.awt.Color(51, 51, 255));
        jButton5_Salir_Menu.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton5_Salir_Menu.setForeground(new java.awt.Color(0, 0, 0));
        jButton5_Salir_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/salir-alternativa.png"))); // NOI18N
        jButton5_Salir_Menu.setText("SALIR");
        jButton5_Salir_Menu.setBorder(null);
        jButton5_Salir_Menu.setBorderPainted(false);
        jButton5_Salir_Menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel_Opciones.add(jButton5_Salir_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 587, 230, 60));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);
        jPanel_Opciones.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/libros (1).png"))); // NOI18N
        jPanel_Opciones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 70, 80));

        getContentPane().add(jPanel_Opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 690));

        jPanel_Contenido.setBackground(new java.awt.Color(212, 255, 255));
        jPanel_Contenido.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel_Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 990, 610));

        jPanel_Mensages.setBackground(new java.awt.Color(255, 246, 246));
        jPanel_Mensages.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2_Bienvenida.setBackground(new java.awt.Color(0, 204, 255));
        jLabel2_Bienvenida.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jPanel_Mensages.add(jLabel2_Bienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/linea.png"))); // NOI18N
        jPanel_Mensages.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 990, 70));

        getContentPane().add(jPanel_Mensages, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 990, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        
        FlatLightLaf.setup();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_inicio;
    private javax.swing.JButton jButton2_ajustes;
    private javax.swing.JButton jButton3_ayuda;
    private javax.swing.JButton jButton5_Salir_Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2_Bienvenida;
    private javax.swing.JPanel jPanel_Contenido;
    private javax.swing.JPanel jPanel_Mensages;
    private javax.swing.JPanel jPanel_Opciones;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
