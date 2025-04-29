
package vistas;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.ControlLoginInclusivoPatron;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import utils.PanelPatronConLineas;


/**
 *
 * @author juare
 */
public class Login_inclusivo_patron extends javax.swing.JFrame {

    /**
     * Creates new form Loginc
     */
    ControlLoginInclusivoPatron ControlLoginInclusivo;
    
    public Login_inclusivo_patron() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        ControlLoginInclusivo =new ControlLoginInclusivoPatron(this);
        initStyles();
    }
    private void initStyles(){
        jButton1_guardar.putClientProperty( "JButton.buttonType", "roundRect" );
        jB_iniciar_sesion.putClientProperty( "JButton.buttonType", "roundRect" );
        jB_ir_Registro.putClientProperty( "JButton.buttonType", "roundRect" );
    }

    public PanelPatronConLineas getJpanel_Patron() {
        return Jpanel_Patron;
    }
    
    public JButton getjButton1_guardar1() {
        return jButton1_guardar1;
    }

    public JButton getjButton1_icono8() {
        return jButton1_icono8;
    }

    public JButton getjButton2_icono1() {
        return jButton2_icono1;
    }

    public JButton getjButton4_icono3() {
        return jButton4_icono3;
    }

    public JButton getjButton5_icono4() {
        return jButton5_icono4;
    }

    public JButton getjButton6_icono5() {
        return jButton6_icono5;
    }

    public JButton getjButton7_icono6() {
        return jButton7_icono6;
    }

    public JButton getjButton8_icono7() {
        return jButton8_icono7;
    }

    public JButton getjButton_icono2() {
        return jButton_icono2;
    }

    public JButton getjButton_iconoregistro1() {
        return jButton_iconoregistro1;
    }

    public JButton getjButton_iconoregistro2() {
        return jButton_iconoregistro2;
    }

    public JButton getjButton_iconoregistro3() {
        return jButton_iconoregistro3;
    }

    public JButton getjButton_iconoregistro4() {
        return jButton_iconoregistro4;
    }

    public JButton getjButton_iconoregistro5() {
        return jButton_iconoregistro5;
    }

    public JButton getjButton_iconoregistro6() {
        return jButton_iconoregistro6;
    }

    public JButton getjButton_iconoregistro7() {
        return jButton_iconoregistro7;
    }

    public JButton getjButton_iconoregistro8() {
        return jButton_iconoregistro8;
    }

    public JToggleButton getjToggleButtonRforma1() {
        return jToggleButtonRforma1;
    }

    public JToggleButton getjToggleButtonRforma10() {
        return jToggleButtonRforma10;
    }

    public JToggleButton getjToggleButtonRforma11() {
        return jToggleButtonRforma11;
    }

    public JToggleButton getjToggleButtonRforma12() {
        return jToggleButtonRforma12;
    }

    public JToggleButton getjToggleButtonRforma2() {
        return jToggleButtonRforma2;
    }

    public JToggleButton getjToggleButtonRforma3() {
        return jToggleButtonRforma3;
    }

    public JToggleButton getjToggleButtonRforma4() {
        return jToggleButtonRforma4;
    }

    public JToggleButton getjToggleButtonRforma5() {
        return jToggleButtonRforma5;
    }

    public JToggleButton getjToggleButtonRforma6() {
        return jToggleButtonRforma6;
    }

    public JToggleButton getjToggleButtonRforma7() {
        return jToggleButtonRforma7;
    }

    public JToggleButton getjToggleButtonRforma8() {
        return jToggleButtonRforma8;
    }

    public JToggleButton getjToggleButtonRforma9() {
        return jToggleButtonRforma9;
    }
    
    
    public JPanel getJP_info_regis() {
        return JP_info_regis;
    }

    public void setJP_info_regis(JPanel JP_info_regis) {
        this.JP_info_regis = JP_info_regis;
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
        jPanel_Registrar = new javax.swing.JPanel();
        jToggleButtonRforma12 = new javax.swing.JToggleButton();
        jToggleButtonRforma1 = new javax.swing.JToggleButton();
        jToggleButtonRforma2 = new javax.swing.JToggleButton();
        jToggleButtonRforma3 = new javax.swing.JToggleButton();
        jToggleButtonRforma4 = new javax.swing.JToggleButton();
        jToggleButtonRforma5 = new javax.swing.JToggleButton();
        jToggleButtonRforma6 = new javax.swing.JToggleButton();
        jToggleButtonRforma7 = new javax.swing.JToggleButton();
        jToggleButtonRforma8 = new javax.swing.JToggleButton();
        jToggleButtonRforma9 = new javax.swing.JToggleButton();
        jToggleButtonRforma10 = new javax.swing.JToggleButton();
        jToggleButtonRforma11 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jButton_iconoregistro8 = new javax.swing.JButton();
        jButton_iconoregistro1 = new javax.swing.JButton();
        jButton_iconoregistro2 = new javax.swing.JButton();
        jButton_iconoregistro3 = new javax.swing.JButton();
        jButton_iconoregistro4 = new javax.swing.JButton();
        jButton_iconoregistro5 = new javax.swing.JButton();
        jButton_iconoregistro6 = new javax.swing.JButton();
        jButton_iconoregistro7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1_guardar = new javax.swing.JButton();
        jButton1_guardar1 = new javax.swing.JButton();
        JP_info_regis = new javax.swing.JPanel();
        jB_ir_Registro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jpLogin = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jB_iniciar_sesion = new javax.swing.JButton();
        jButton1_icono8 = new javax.swing.JButton();
        jButton2_icono1 = new javax.swing.JButton();
        jButton_icono2 = new javax.swing.JButton();
        jButton4_icono3 = new javax.swing.JButton();
        jButton5_icono4 = new javax.swing.JButton();
        jButton6_icono5 = new javax.swing.JButton();
        jButton7_icono6 = new javax.swing.JButton();
        jButton8_icono7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Jpanel_Patron = new utils.PanelPatronConLineas();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Registrar.setBackground(new java.awt.Color(102, 102, 255));
        jPanel_Registrar.setForeground(new java.awt.Color(51, 51, 255));
        jPanel_Registrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButtonRforma12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin12.png"))); // NOI18N
        jToggleButtonRforma12.setBorderPainted(false);
        jToggleButtonRforma12.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 63, 63));

        jToggleButtonRforma1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin1.png"))); // NOI18N
        jToggleButtonRforma1.setBorderPainted(false);
        jToggleButtonRforma1.setContentAreaFilled(false);
        jToggleButtonRforma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRforma1ActionPerformed(evt);
            }
        });
        jPanel_Registrar.add(jToggleButtonRforma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 63, 63));

        jToggleButtonRforma2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin2.png"))); // NOI18N
        jToggleButtonRforma2.setBorderPainted(false);
        jToggleButtonRforma2.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 63, 63));

        jToggleButtonRforma3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin3.png"))); // NOI18N
        jToggleButtonRforma3.setBorderPainted(false);
        jToggleButtonRforma3.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 63, 63));

        jToggleButtonRforma4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin4.png"))); // NOI18N
        jToggleButtonRforma4.setText("jToggleButton1");
        jToggleButtonRforma4.setBorderPainted(false);
        jToggleButtonRforma4.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 63, 63));

        jToggleButtonRforma5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin5.png"))); // NOI18N
        jToggleButtonRforma5.setBorderPainted(false);
        jToggleButtonRforma5.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 63, 63));

        jToggleButtonRforma6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin6.png"))); // NOI18N
        jToggleButtonRforma6.setBorderPainted(false);
        jToggleButtonRforma6.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 63, 63));

        jToggleButtonRforma7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin7.png"))); // NOI18N
        jToggleButtonRforma7.setBorderPainted(false);
        jToggleButtonRforma7.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 63, 63));

        jToggleButtonRforma8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin8.png"))); // NOI18N
        jToggleButtonRforma8.setText("jToggleButton1");
        jToggleButtonRforma8.setBorderPainted(false);
        jToggleButtonRforma8.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 63, 63));

        jToggleButtonRforma9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin9.png"))); // NOI18N
        jToggleButtonRforma9.setBorderPainted(false);
        jToggleButtonRforma9.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 63, 63));

        jToggleButtonRforma10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin10.png"))); // NOI18N
        jToggleButtonRforma10.setBorderPainted(false);
        jToggleButtonRforma10.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 63, 63));

        jToggleButtonRforma11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/pin11.png"))); // NOI18N
        jToggleButtonRforma11.setBorderPainted(false);
        jToggleButtonRforma11.setContentAreaFilled(false);
        jPanel_Registrar.add(jToggleButtonRforma11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 63, 63));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/panel_azul.png"))); // NOI18N
        jPanel_Registrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 380, 260));

        jButton_iconoregistro8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/perfil_hombre3.png"))); // NOI18N
        jButton_iconoregistro8.setBorderPainted(false);
        jButton_iconoregistro8.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, 70));

        jButton_iconoregistro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icno_niña.png"))); // NOI18N
        jButton_iconoregistro1.setBorderPainted(false);
        jButton_iconoregistro1.setContentAreaFilled(false);
        jButton_iconoregistro1.setName(""); // NOI18N
        jPanel_Registrar.add(jButton_iconoregistro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, 70));

        jButton_iconoregistro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_hombre 2.png"))); // NOI18N
        jButton_iconoregistro2.setBorderPainted(false);
        jButton_iconoregistro2.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 70));

        jButton_iconoregistro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_hombre.png"))); // NOI18N
        jButton_iconoregistro3.setBorderPainted(false);
        jButton_iconoregistro3.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, 70));

        jButton_iconoregistro4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_mujer1.png"))); // NOI18N
        jButton_iconoregistro4.setBorderPainted(false);
        jButton_iconoregistro4.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, -1, 70));

        jButton_iconoregistro5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_mujer2.png"))); // NOI18N
        jButton_iconoregistro5.setBorderPainted(false);
        jButton_iconoregistro5.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 70));

        jButton_iconoregistro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_mujer3.png"))); // NOI18N
        jButton_iconoregistro6.setBorderPainted(false);
        jButton_iconoregistro6.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, 70));

        jButton_iconoregistro7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_señor.png"))); // NOI18N
        jButton_iconoregistro7.setBorderPainted(false);
        jButton_iconoregistro7.setContentAreaFilled(false);
        jPanel_Registrar.add(jButton_iconoregistro7, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 130, 90, 70));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Elige tu perfil");
        jPanel_Registrar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Contraseña");
        jPanel_Registrar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jButton1_guardar.setBackground(new java.awt.Color(0, 0, 255));
        jButton1_guardar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1_guardar.setText("Guardar");
        jButton1_guardar.setName("guardar"); // NOI18N
        jButton1_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_guardarActionPerformed(evt);
            }
        });
        jPanel_Registrar.add(jButton1_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 178, -1));

        jButton1_guardar1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1_guardar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1_guardar1.setText("Borrrar");
        jButton1_guardar1.setName("borrar"); // NOI18N
        jButton1_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_guardar1ActionPerformed(evt);
            }
        });
        jPanel_Registrar.add(jButton1_guardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 178, -1));

        jLayeredPane1.add(jPanel_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -600, 480, 610));

        JP_info_regis.setBackground(new java.awt.Color(89, 0, 253));
        JP_info_regis.setForeground(new java.awt.Color(102, 102, 255));
        JP_info_regis.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jB_ir_Registro.setBackground(new java.awt.Color(0, 0, 102));
        jB_ir_Registro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jB_ir_Registro.setForeground(new java.awt.Color(255, 255, 255));
        jB_ir_Registro.setText("REGISTRAR");
        jB_ir_Registro.setName("registrar"); // NOI18N
        JP_info_regis.add(jB_ir_Registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 252, 51));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/librason.png"))); // NOI18N
        JP_info_regis.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 280, 210));

        jLayeredPane1.add(JP_info_regis, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 610));

        jpLogin.setBackground(new java.awt.Color(255, 255, 255));
        jpLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpLogin.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        jB_iniciar_sesion.setBackground(new java.awt.Color(0, 0, 102));
        jB_iniciar_sesion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jB_iniciar_sesion.setForeground(new java.awt.Color(255, 255, 255));
        jB_iniciar_sesion.setText("Iniciar");
        jB_iniciar_sesion.setName("iniciar"); // NOI18N
        jB_iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_iniciar_sesionActionPerformed(evt);
            }
        });
        jpLogin.add(jB_iniciar_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 530, 150, 50));

        jButton1_icono8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/perfil_hombre3.png"))); // NOI18N
        jButton1_icono8.setBorderPainted(false);
        jButton1_icono8.setContentAreaFilled(false);
        jpLogin.add(jButton1_icono8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 70, 70));

        jButton2_icono1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icno_niña.png"))); // NOI18N
        jButton2_icono1.setBorderPainted(false);
        jButton2_icono1.setContentAreaFilled(false);
        jpLogin.add(jButton2_icono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 70, 70));

        jButton_icono2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_hombre 2.png"))); // NOI18N
        jButton_icono2.setBorderPainted(false);
        jButton_icono2.setContentAreaFilled(false);
        jpLogin.add(jButton_icono2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 70, 70));

        jButton4_icono3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_hombre.png"))); // NOI18N
        jButton4_icono3.setBorderPainted(false);
        jButton4_icono3.setContentAreaFilled(false);
        jpLogin.add(jButton4_icono3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 70, 70));

        jButton5_icono4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_mujer1.png"))); // NOI18N
        jButton5_icono4.setBorderPainted(false);
        jButton5_icono4.setContentAreaFilled(false);
        jpLogin.add(jButton5_icono4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 70, 70));

        jButton6_icono5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_mujer2.png"))); // NOI18N
        jButton6_icono5.setBorderPainted(false);
        jButton6_icono5.setContentAreaFilled(false);
        jpLogin.add(jButton6_icono5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 70, 70));

        jButton7_icono6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_mujer3.png"))); // NOI18N
        jButton7_icono6.setBorderPainted(false);
        jButton7_icono6.setContentAreaFilled(false);
        jpLogin.add(jButton7_icono6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 70, 70));

        jButton8_icono7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/icono_señor.png"))); // NOI18N
        jButton8_icono7.setBorderPainted(false);
        jButton8_icono7.setContentAreaFilled(false);
        jpLogin.add(jButton8_icono7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 70, 70));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Elige tu perfil");
        jpLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña");
        jpLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        Jpanel_Patron.setBackground(new java.awt.Color(255, 255, 255));
        Jpanel_Patron.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 70, 70));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 70, 70));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, 70));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 70, 70));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 70, 70));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 70));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 70, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton1.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/boton2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Jpanel_Patron.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 70, 70));

        jpLogin.add(Jpanel_Patron, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 360, 250));

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

    private void jB_iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_iniciar_sesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_iniciar_sesionActionPerformed

    private void jToggleButtonRforma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRforma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonRforma1ActionPerformed

    private void jButton1_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_guardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1_guardar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        FlatLightLaf.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_inclusivo_patron().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JP_info_regis;
    private utils.PanelPatronConLineas Jpanel_Patron;
    private javax.swing.JButton jB_iniciar_sesion;
    private javax.swing.JButton jB_ir_Registro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1_guardar;
    private javax.swing.JButton jButton1_guardar1;
    private javax.swing.JButton jButton1_icono8;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton2_icono1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton4_icono3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton5_icono4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton6_icono5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton7_icono6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton8_icono7;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_icono2;
    private javax.swing.JButton jButton_iconoregistro1;
    private javax.swing.JButton jButton_iconoregistro2;
    private javax.swing.JButton jButton_iconoregistro3;
    private javax.swing.JButton jButton_iconoregistro4;
    private javax.swing.JButton jButton_iconoregistro5;
    private javax.swing.JButton jButton_iconoregistro6;
    private javax.swing.JButton jButton_iconoregistro7;
    private javax.swing.JButton jButton_iconoregistro8;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel_Registrar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JToggleButton jToggleButtonRforma1;
    private javax.swing.JToggleButton jToggleButtonRforma10;
    private javax.swing.JToggleButton jToggleButtonRforma11;
    private javax.swing.JToggleButton jToggleButtonRforma12;
    private javax.swing.JToggleButton jToggleButtonRforma2;
    private javax.swing.JToggleButton jToggleButtonRforma3;
    private javax.swing.JToggleButton jToggleButtonRforma4;
    private javax.swing.JToggleButton jToggleButtonRforma5;
    private javax.swing.JToggleButton jToggleButtonRforma6;
    private javax.swing.JToggleButton jToggleButtonRforma7;
    private javax.swing.JToggleButton jToggleButtonRforma8;
    private javax.swing.JToggleButton jToggleButtonRforma9;
    private javax.swing.JPanel jpLogin;
    // End of variables declaration//GEN-END:variables
}
