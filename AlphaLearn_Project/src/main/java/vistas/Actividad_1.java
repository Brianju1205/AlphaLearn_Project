/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.ControlActividad1;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author juare
 */
public class Actividad_1 extends javax.swing.JFrame {

    /**
     * Creates new form Actividad_1
     */
    ControlActividad1 objcontrolActi;
    Abecedario objAbc;
    Vocal_A va;
    Vocal_E ve;
    Vocal_I vi;
    Vocal_O vo;
    Vocal_U vu;
    public Actividad_1() {
        
        initComponents(); 
        objAbc= new Abecedario();
        va= new Vocal_A();
        ve= new Vocal_E();
        vi= new Vocal_I();
        vo= new Vocal_O();
        vu= new Vocal_U();
        objcontrolActi= new ControlActividad1(this,objAbc,va,ve,vi,vo,vu);
        this.setLocationRelativeTo(null);
        initStyles();
    }
    private void initStyles(){
        jButton_Siguiente.putClientProperty( "JButton.buttonType", "roundRect" );
        
    }

    public JPanel getjPanel1_Abecedario() {
        return jPanel1_Abecedario;
    }
    

    public JButton getjButton1_Salir_act_1() {
        return jButton1_Salir_act_1;
    }

    public JButton getjButton_Siguiente() {
        return jButton_Siguiente;
    }

    public JButton getjButton_REGRESAR() {
        return jButton_REGRESAR;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Actividad_1 = new javax.swing.JPanel();
        jButton1_Salir_act_1 = new javax.swing.JButton();
        jButton_Siguiente = new javax.swing.JButton();
        jPanel1_Abecedario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_REGRESAR = new javax.swing.JButton();
        jButton2_instruccion_siguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1220, 690));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Actividad_1.setBackground(new java.awt.Color(116, 159, 183));
        jPanel_Actividad_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1_Salir_act_1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1_Salir_act_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Frame 105.png"))); // NOI18N
        jButton1_Salir_act_1.setBorder(null);
        jButton1_Salir_act_1.setContentAreaFilled(false);
        jButton1_Salir_act_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1_Salir_act_1.setName("salir"); // NOI18N
        jButton1_Salir_act_1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Frame 106.png"))); // NOI18N
        jButton1_Salir_act_1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/Frame 104.png"))); // NOI18N
        jPanel_Actividad_1.add(jButton1_Salir_act_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 100, 60));

        jButton_Siguiente.setBackground(new java.awt.Color(255, 0, 0));
        jButton_Siguiente.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton_Siguiente.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/abecedario/button_siguienten1.png"))); // NOI18N
        jButton_Siguiente.setBorderPainted(false);
        jButton_Siguiente.setContentAreaFilled(false);
        jButton_Siguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Siguiente.setName("siguiente"); // NOI18N
        jButton_Siguiente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/abecedario/button_siguientePressed.png"))); // NOI18N
        jButton_Siguiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/abecedario/button_siguientefill.png"))); // NOI18N
        jPanel_Actividad_1.add(jButton_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 157, 220, -1));

        jPanel1_Abecedario.setOpaque(false);
        jPanel_Actividad_1.add(jPanel1_Abecedario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 800, 470));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿CÓMO SE ESCUCHA?");
        jPanel_Actividad_1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 470, 80));

        jButton_REGRESAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/abecedario/button_regresar.png"))); // NOI18N
        jButton_REGRESAR.setBorderPainted(false);
        jButton_REGRESAR.setContentAreaFilled(false);
        jButton_REGRESAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_REGRESAR.setName("regresar"); // NOI18N
        jButton_REGRESAR.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/abecedario/button_regresarPressed.png"))); // NOI18N
        jButton_REGRESAR.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/abecedario/button_regresarfill.png"))); // NOI18N
        jPanel_Actividad_1.add(jButton_REGRESAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 300, -1, -1));

        jButton2_instruccion_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/sistemas-de-escucha-asistida.png"))); // NOI18N
        jButton2_instruccion_siguiente.setBorderPainted(false);
        jButton2_instruccion_siguiente.setContentAreaFilled(false);
        jPanel_Actividad_1.add(jButton2_instruccion_siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 170, -1, -1));

        getContentPane().add(jPanel_Actividad_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 690));

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
                new Actividad_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_Salir_act_1;
    private javax.swing.JButton jButton2_instruccion_siguiente;
    private javax.swing.JButton jButton_REGRESAR;
    private javax.swing.JButton jButton_Siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1_Abecedario;
    public javax.swing.JPanel jPanel_Actividad_1;
    // End of variables declaration//GEN-END:variables
    
}
