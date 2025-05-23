/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import controlador.ControlActividad6;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juare
 */
public class Actividad_6 extends javax.swing.JFrame {

    /**
     * Creates new form Actividad_6
     */
    
    ControlActividad6 controlActi6;
    public Actividad_6() {
        initComponents();
        controlActi6 = new ControlActividad6(this);
        this.setLocationRelativeTo(null);
    }

    public JButton getjButton1_repetir_cuento() {
        return jButton1_repetir_cuento;
    }
    
    public JLabel getjLabel_pregunta() {
        return jLabel_pregunta;
    }

    public JLabel getjLabelTitulo() {
        return jLabelTitulo;
    }

    public JButton getjButton_audio_pregunta() {
        return jButton_audio_pregunta;
    }
    
    public JButton getjButton1_Salir_act_5() {
        return jButton1_Salir_act_5;
    }

    public JButton getjButton1_cambiartexto() {
        return jButton1_cambiartexto;
    }

    public JLabel getjLabel_respuesta1() {
        return jLabel_respuesta1;
    }

    public JLabel getjLabel_respuesta2() {
        return jLabel_respuesta2;
    }

    public JLabel getjLabel_respuesta3() {
        return jLabel_respuesta3;
    }

    public JLabel getjLabel_texto() {
        return jLabel_texto;
    }

    public JPanel getjPanel1_fondo() {
        return jPanel1_fondo;
    }

    public JLabel getCorazon1() {
        return corazon1;
    }

    public JLabel getCorazon2() {
        return corazon2;
    }

    public JLabel getCorazon3() {
        return corazon3;
    }

    public JLabel getCorazon4() {
        return corazon4;
    }

    public JLabel getCorazon5() {
        return corazon5;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1_fondo = new javax.swing.JPanel();
        jLabel_respuesta1 = new javax.swing.JLabel();
        jLabel_respuesta2 = new javax.swing.JLabel();
        jLabel_respuesta3 = new javax.swing.JLabel();
        jButton_audio_pregunta = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabel_texto = new javax.swing.JLabel();
        jLabel_pregunta = new javax.swing.JLabel();
        jButton1_repetir_cuento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1_cambiartexto = new javax.swing.JButton();
        jButton1_Salir_act_5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        corazon1 = new javax.swing.JLabel();
        corazon2 = new javax.swing.JLabel();
        corazon3 = new javax.swing.JLabel();
        corazon4 = new javax.swing.JLabel();
        corazon5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1203, 671));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1_fondo.setBackground(new java.awt.Color(82, 160, 254));
        jPanel1_fondo.setMinimumSize(new java.awt.Dimension(1203, 671));
        jPanel1_fondo.setPreferredSize(new java.awt.Dimension(1203, 671));
        jPanel1_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_respuesta1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_respuesta1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_respuesta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1_fondo.add(jLabel_respuesta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 400, 50));

        jLabel_respuesta2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_respuesta2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_respuesta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1_fondo.add(jLabel_respuesta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 400, 50));

        jLabel_respuesta3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_respuesta3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_respuesta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1_fondo.add(jLabel_respuesta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 410, 50));

        jButton_audio_pregunta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/SONIDO.png"))); // NOI18N
        jButton_audio_pregunta.setBorderPainted(false);
        jButton_audio_pregunta.setContentAreaFilled(false);
        jButton_audio_pregunta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/SONIDOPRESSED.png"))); // NOI18N
        jPanel1_fondo.add(jButton_audio_pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 150, -1, -1));

        jLabelTitulo.setBackground(new java.awt.Color(51, 51, 255));
        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setOpaque(true);
        jPanel1_fondo.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 540, 40));

        jLabel_texto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_texto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1_fondo.add(jLabel_texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 480, 350));

        jLabel_pregunta.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_pregunta.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_pregunta.setToolTipText("");
        jPanel1_fondo.add(jLabel_pregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, 440, 70));

        jButton1_repetir_cuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/SONIDO.png"))); // NOI18N
        jButton1_repetir_cuento.setBorder(null);
        jButton1_repetir_cuento.setContentAreaFilled(false);
        jButton1_repetir_cuento.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/SONIDOPRESSED.png"))); // NOI18N
        jPanel1_fondo.add(jButton1_repetir_cuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PANELTEXT.png"))); // NOI18N
        jPanel1_fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 580, 450));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PANELOPCION3TEXT.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1_fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 460, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PANELOPCIONUNOTEXT.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jPanel1_fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 450, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PANELOPCION2TEXT.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jPanel1_fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 470, 70));

        jButton1_cambiartexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BOTONNEXT.png"))); // NOI18N
        jButton1_cambiartexto.setBorderPainted(false);
        jButton1_cambiartexto.setContentAreaFilled(false);
        jButton1_cambiartexto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/BOTTONNEXTPRESSED.png"))); // NOI18N
        jPanel1_fondo.add(jButton1_cambiartexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 540, 110, 140));

        jButton1_Salir_act_5.setBackground(new java.awt.Color(153, 51, 255));
        jButton1_Salir_act_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/salirrr.png"))); // NOI18N
        jButton1_Salir_act_5.setBorderPainted(false);
        jButton1_Salir_act_5.setContentAreaFilled(false);
        jButton1_Salir_act_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1_Salir_act_5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Frame 106.png"))); // NOI18N
        jButton1_Salir_act_5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Frame 104.png"))); // NOI18N
        jPanel1_fondo.add(jButton1_Salir_act_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PANELTEXTPREGUNTA.png"))); // NOI18N
        jPanel1_fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, -1, 110));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/PANELOPCIONES.png"))); // NOI18N
        jPanel1_fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, 480));
        jPanel1_fondo.add(corazon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 50, 40));
        jPanel1_fondo.add(corazon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 50, 40));
        jPanel1_fondo.add(corazon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 50, 40));
        jPanel1_fondo.add(corazon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 50, 40));
        jPanel1_fondo.add(corazon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 50, 40));

        getContentPane().add(jPanel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1203, 671));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Actividad_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividad_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividad_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividad_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividad_6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel corazon1;
    private javax.swing.JLabel corazon2;
    private javax.swing.JLabel corazon3;
    private javax.swing.JLabel corazon4;
    private javax.swing.JLabel corazon5;
    private javax.swing.JButton jButton1_Salir_act_5;
    private javax.swing.JButton jButton1_cambiartexto;
    private javax.swing.JButton jButton1_repetir_cuento;
    private javax.swing.JButton jButton_audio_pregunta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabel_pregunta;
    private javax.swing.JLabel jLabel_respuesta1;
    private javax.swing.JLabel jLabel_respuesta2;
    private javax.swing.JLabel jLabel_respuesta3;
    private javax.swing.JLabel jLabel_texto;
    private javax.swing.JPanel jPanel1_fondo;
    // End of variables declaration//GEN-END:variables
}
