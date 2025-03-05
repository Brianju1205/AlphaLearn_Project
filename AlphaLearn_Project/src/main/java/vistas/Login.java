/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import alphalearnproject.AlphaLearnProject.*;
import controlador.ControlLogin;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author juare
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Loginc
     */
    ControlLogin ControlLogin;
    public Login() {
        initComponents();
       // ControlLogin =new ControlLogin(this);
    }

    public JButton getjB_iniciar_sesion() {
        return jB_iniciar_sesion;
    }

    public void setjB_iniciar_sesion(JButton jB_iniciar_sesion) {
        this.jB_iniciar_sesion = jB_iniciar_sesion;
    }

    public JButton getjB_ir_Registro() {
        return jB_ir_Registro;
    }

    public void setjB_ir_Registro(JButton jB_ir_Registro) {
        this.jB_ir_Registro = jB_ir_Registro;
    }

    public JPanel getJP_info_regis() {
        return JP_info_regis;
    }

    public void setJP_info_regis(JPanel JP_info_regis) {
        this.JP_info_regis = JP_info_regis;
    }

    public JButton getjButton1_guardar() {
        return jButton1_guardar;
    }

    public void setjButton1_guardar(JButton jButton1_guardar) {
        this.jButton1_guardar = jButton1_guardar;
    }

    

    public JPanel getjPanel_Registrar() {
        return jPanel_Registrar;
    }

    public void setjPanel_Registrar(JPanel jPanel_Registrar) {
        this.jPanel_Registrar = jPanel_Registrar;
    }

    

    public JPanel getJpLogin() {
        return jpLogin;
    }

    public void setJpLogin(JPanel jpLogin) {
        this.jpLogin = jpLogin;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        JP_info_regis = new javax.swing.JPanel();
        jB_ir_Registro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel_Registrar = new javax.swing.JPanel();
        jButton1_guardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_Nom_User = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jTextField1_Edad = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jPasswordField2_Registrar = new javax.swing.JPasswordField();
        jSeparator8 = new javax.swing.JSeparator();
        jpLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jText_Nom_Usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jB_iniciar_sesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JP_info_regis.setBackground(new java.awt.Color(153, 153, 255));
        JP_info_regis.setForeground(new java.awt.Color(102, 102, 255));
        JP_info_regis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB_ir_Registro.setBackground(new java.awt.Color(51, 51, 255));
        jB_ir_Registro.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jB_ir_Registro.setText("REGISTRAR");
        JP_info_regis.add(jB_ir_Registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 465, 252, 51));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logo-removebg-preview (1)_1.png"))); // NOI18N
        JP_info_regis.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 279, 323));

        jPanel_Registrar.setBackground(new java.awt.Color(102, 102, 255));
        jPanel_Registrar.setForeground(new java.awt.Color(51, 51, 255));
        jPanel_Registrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1_guardar.setBackground(new java.awt.Color(0, 0, 255));
        jButton1_guardar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1_guardar.setText("Guardar");
        jButton1_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_guardarActionPerformed(evt);
            }
        });
        jPanel_Registrar.add(jButton1_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, 178, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Logo.Usuario_1.png"))); // NOI18N
        jPanel_Registrar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, 140));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nombre de Usuario:");
        jPanel_Registrar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jTextField1_Nom_User.setBackground(new java.awt.Color(102, 102, 255));
        jTextField1_Nom_User.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1_Nom_User.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1_Nom_User.setBorder(null);
        jTextField1_Nom_User.setOpaque(true);
        jPanel_Registrar.add(jTextField1_Nom_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 230, 40));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Registrar.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 240, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Edad");
        jPanel_Registrar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 40, -1));

        jTextField1_Edad.setBackground(new java.awt.Color(102, 102, 255));
        jTextField1_Edad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1_Edad.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Registrar.add(jTextField1_Edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 80, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Registrar.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Contraseña");
        jPanel_Registrar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, -1, -1));

        jPasswordField2_Registrar.setBackground(new java.awt.Color(102, 102, 255));
        jPasswordField2_Registrar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Registrar.add(jPasswordField2_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 240, 40));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_Registrar.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 240, 40));

        JP_info_regis.add(jPanel_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -600, 490, 610));

        jLayeredPane1.add(JP_info_regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 610));

        jpLogin.setBackground(new java.awt.Color(255, 255, 255));
        jpLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Logo.Usuario_1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jpLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 75, 146, 143));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre de usuario");
        jpLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 224, -1, -1));

        jText_Nom_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        jText_Nom_Usuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jText_Nom_Usuario.setForeground(new java.awt.Color(0, 0, 0));
        jText_Nom_Usuario.setBorder(null);
        jpLogin.add(jText_Nom_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 233, 30));
        jpLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        jpLogin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 300, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/N.Usuario.png"))); // NOI18N
        jpLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, 40));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contraseña");
        jpLogin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(51, 51, 51));
        jpLogin.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 300, 20));

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setBorder(null);
        jpLogin.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 326, 240, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Icon.contraseña_2.png"))); // NOI18N
        jpLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 40, 40));

        jB_iniciar_sesion.setBackground(new java.awt.Color(102, 102, 255));
        jB_iniciar_sesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jB_iniciar_sesion.setText("Iniciar");
        jpLogin.add(jB_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 150, 50));

        jLayeredPane1.add(jpLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 520, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_guardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1_guardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JP_info_regis;
    private javax.swing.JButton jB_iniciar_sesion;
    private javax.swing.JButton jB_ir_Registro;
    private javax.swing.JButton jButton1_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel_Registrar;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2_Registrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField1_Edad;
    private javax.swing.JTextField jTextField1_Nom_User;
    private javax.swing.JTextField jText_Nom_Usuario;
    private javax.swing.JPanel jpLogin;
    // End of variables declaration//GEN-END:variables
}
