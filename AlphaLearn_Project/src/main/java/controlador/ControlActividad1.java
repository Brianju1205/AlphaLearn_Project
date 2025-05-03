/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.AjustesM;
import vistas.Abecedario;
import vistas.Actividad_1;
import vistas.Ajustes;
import vistas.Menu;
import vistas.Vocal_A;
import vistas.Vocal_E;
import vistas.Vocal_I;
import vistas.Vocal_O;
import vistas.Vocal_U;

 /**
 * Controlador de la vista  Actividad_1.
 * Extiende  AbstractSonido para heredar la funcionalidad de reproducción de audio.
 * Implementa ActionListener para reaccionar a las acciones del usuario.
 * 
 * @author juare
 */
public class ControlActividad1 extends AbstractSonido implements ActionListener {
    private Actividad_1 objActividad;
    private Abecedario objAbc;
    private Verificador v;
    private Vocal_A va;
    private Vocal_E ve;
    private Vocal_I vi;
    private Vocal_O vo;
    private Vocal_U vu;
    private JPanel paneles[];
    private int indicador=0;
    private AjustesM ajustes;
    int toces=0;
    /**
     * Constructor Actividad 1
     * @param objActividad objeto actividad
     * @param objAbc referencia panel Abecedario
     * @param va panel vocal a
     * @param ve panel vocal e
     * @param vi panel vocal i
     * @param vo panel vocal o
     * @param vu panel vocal u
     */
    public ControlActividad1(Actividad_1 objActividad,Abecedario objAbc,Vocal_A va,Vocal_E ve,Vocal_I vi,Vocal_O vo,Vocal_U vu) {
        this.objActividad = objActividad;
        this.objAbc = objAbc;
        this.va=va;
        this.ve=ve;
        this.vi=vi;
        this.vo=vo;
        this.vu=vu;
        this.paneles = new JPanel[]{objAbc, va, ve, vi, vo, vu};
        
        v = Verificador.getInstancia();
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        colocarEscuchadores();
        colocarEscuchadores2();
        initContent();
        //this.mostrarInstruccion(objActividad.jPanel_Actividad_1, "/resource/imagenes/presentador.png",870,470);
        //reproducirSonido("/resource/sounds/modulo1.1.wav");
        mostrarInstruccion();
        
    }
    /**
     * Muestra las instrucciones de la actividad si están habilitadas en ajustes.
     */
    private void mostrarInstruccion(){
       AjustesM ajustes = ControlGestorAjustes.getInstance().obtenerAjustes(v.getId());
        if(ajustes.isInstruccionesActivas()){
           this.mostrarInstruccion(objActividad.jPanel_Actividad_1, "/resource/imagenes/presentador.png",870,380);
           reproducirSonido("/resource/sounds/modulo1.1.wav"); 
        }
        else{
            System.out.println("instrucciones desactivadas");
        }
    }
    
    /**
     * Agrega escuchadores a los botones de la vista principal.
     */
    private void colocarEscuchadores(){
       // = this.objActividad.jPanel_Actividad_1.getComponents();
       for(Object obj: this.objActividad.jPanel_Actividad_1.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
    }
    
    /**
     * Agrega escuchadores a los botones de todos los subpaneles.
     */
    private void colocarEscuchadores2(){

       for(Object obj: objAbc.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
       for(Object obj: va.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
       for(Object obj: ve.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
       for(Object obj: vi.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
       for(Object obj: vo.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
       for(Object obj: vu.getComponents()){
           if(obj instanceof JButton bt){
               bt.addActionListener(this);
           }
       }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource() == this.objActividad.getjButton1_Salir_act_1()){
                reproducirSonido("/resource/sounds/burbuja.wav");
                ControlDialogSalir cD = new ControlDialogSalir(objActividad);
                cD.mostrarDialogo(); 

                if (cD.isSalirConfirmado()) {
                    stopSonido();
                    objActividad.dispose(); 
                    Menu m = new Menu();
                    m.setVisible(true);     
                }
                if(this.v.getNom()== null){
                System.out.println("no hay usuario");
                return;
                }
                else{
                int tiempoTotal = (int) TiempoActivo.getInstancia().getTiempoActivo();
                ControlGestorTiempo.getInstancia().guardarTiempo(v.getId(),tiempoTotal);

                }
            }
            else if(e.getSource() == this.objActividad.getjButton_REGRESAR()){
               reproducirSonido("/resource/sounds/burbuja.wav");
               if (indicador > 0) {
                indicador--;
                panel(paneles[indicador]);
                
            }
           }else if(e.getSource() == this.objActividad.getjButton_Siguiente()){
               reproducirSonido("/resource/sounds/burbuja.wav");
                
                if (indicador < paneles.length - 1) {         
                indicador++;
                panel(paneles[indicador]);
                } else {
                    indicador = 0;
                    panel(paneles[indicador]);
                    
                }
                
                if(indicador==1){
                    this.mostrarInstruccion(objActividad.jPanel_Actividad_1, "/resource/imagenes/presentador.png",870,470);
                    reproducirSonido("/resource/sounds/submodulo1_1.wav");
                }
           }
           JButton bt = (JButton)e.getSource();
           if(bt.getName().equals("siguiente") || bt.getName().equals("salir")||bt.getName().equals("regresar") ){
               return;
           }
           
           String ruta = "/resource/sounds/"+bt.getName()+".wav";
           reproducirSonido(ruta);
        
    }
    
    /**
     * Inicializa el primer panel que se mostrará en la vista.
     */
    private void initContent(){
        panel(paneles[indicador]);
    }
    
    /**
     * Cambia el panel visible en la vista principal.
     * 
     * @param p indice de Panel a mostrar.
     */
    private void panel(JPanel p){
        
        p.setSize( 807, 470);
        p.setLocation(0, 0);
        objActividad.getjPanel1_Abecedario().removeAll();
        objActividad.getjPanel1_Abecedario().add(p, BorderLayout.CENTER);
        objActividad.getjPanel1_Abecedario().revalidate();
        objActividad.getjPanel1_Abecedario().repaint();
    }
}
