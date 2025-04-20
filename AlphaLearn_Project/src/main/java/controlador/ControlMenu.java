/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import modelo.AjustesM;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import utils.ControlVolumen;
import vistas.Actividad_1;
import vistas.Actividad_2;
import vistas.Actividad_3;
import vistas.Actividad_4;
import vistas.Actividad_5;
import vistas.Actividad_6;
import vistas.Menu;
import vistas.Menu_Actividades;
import vistas.Ajustes;
import vistas.Perfil;

/**
 *
 * @author juare
 */
public class ControlMenu extends AbstractSonido implements ActionListener,ChangeListener{
    private Ajustes objAjustes;
    private Perfil objPerfil;
    private Map<String, Integer> datos;
    private Menu objMenu;
    private Menu_Actividades objMenuAc;
    private Verificador v;
    
    public ControlMenu(Menu objMenu,Menu_Actividades objMenuAc, Ajustes objAjustes,Perfil objPerfil) {
        FlatLightLaf.setup();
        
        this.objMenu = objMenu;
        this.objAjustes = objAjustes;
        this.objPerfil = objPerfil;
        this.objMenuAc = objMenuAc;
        v = Verificador.getInstancia();
        ControlGestorTiempo.getInstancia();
        TiempoActivo.getInstancia().iniciarContador();
        
        this.objMenuAc.getjButton_Actividad1().addActionListener(this);
        this.objMenuAc.getjButton_Actividad2().addActionListener(this);
        this.objMenuAc.getjButton_Actividad3().addActionListener(this);
        this.objMenuAc.getjButton_Actividad4().addActionListener(this);
        this.objMenuAc.getjButton_Actividad5().addActionListener(this);
        this.objMenuAc.getjButton_Actividad6().addActionListener(this);
        this.objMenu.getjButton5_Salir_Menu().addActionListener(this);
        this.objMenu.getjButton1_inicio().addActionListener(this);
        this.objMenu.getjButton2_ajustes().addActionListener(this);
        this.objMenu.getjButton3_ayuda().addActionListener(this);
        objAjustes.getjButton_cambiar_contraseña().addActionListener(this);
        objAjustes.getjButton_guardarCambios().addActionListener(this);
        objAjustes.getjCheckBox1_sonido().addActionListener(this);
        objAjustes.getjCheckBox2_instrucciones().addActionListener(this);
        objAjustes.getjSlider1_volumen().addChangeListener(this);
        
        this.initContent();
        inicializarAjustes();
        this.objMenu.getjLabel2_Bienvenida().setText("Bienvenido ");
        
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == this.objAjustes.getjSlider1_volumen()){
           int valorSlider = objAjustes.getjSlider1_volumen().getValue();
           objAjustes.getjLabel7_numero_de_volumen().setText(valorSlider + " %");
           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.objMenuAc.getjButton_Actividad1()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_1 a = new Actividad_1();
            a.setVisible(true);
            if (objMenu != null) {
            
            objMenu.dispose(); 
            }
        }
        if(e.getSource() ==  this.objMenuAc.getjButton_Actividad2()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_2 a =new Actividad_2();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad3()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_3 a= new Actividad_3();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad4()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_4 a=new Actividad_4();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }
            
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad5()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_5 a=new Actividad_5();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }     
        }
        if(e.getSource() == this.objMenuAc.getjButton_Actividad6()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            Actividad_6 a=new Actividad_6();
            a.setVisible(true);
            if(objMenu !=null){
                objMenu.dispose();
            }  
        }
        if(e.getSource() == this.objMenu.getjButton5_Salir_Menu()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            if (objMenu != null) {  
            
            objMenu.dispose(); 
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
        if (e.getSource() == this.objMenu.getjButton1_inicio()){
            reproducirSonido("/resource/sounds/burbuja.wav");
            panel(objMenuAc);
            
        }
        if (e.getSource() == this.objMenu.getjButton2_ajustes()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            panel(objAjustes);
            //inicializarAjustes();
        }
        if (e.getSource() == this.objMenu.getjButton3_ayuda()) {
            reproducirSonido("/resource/sounds/burbuja.wav");
            panel(objPerfil);
            initPerfil();
        }
        if (e.getSource() == objAjustes.getjButton_guardarCambios()) {
            int volumenPorcentaje = (int) (objAjustes.getjSlider1_volumen().getValue() * 100.0);
            float volumenDecimal = volumenPorcentaje / 100f;
            ControlVolumen.setVolumen((int) volumenDecimal);
            boolean sonidoActivo = objAjustes.getjCheckBox1_sonido().isSelected(); 
            boolean instruccionesActivas = objAjustes.getjCheckBox2_instrucciones().isSelected();
            
            AjustesM ajustes = new AjustesM();
            ajustes.setIdUsuario(v.getId());  
            ajustes.setVolumen(volumenDecimal);
            ajustes.setSonidoActivo(sonidoActivo);
            ajustes.setInstruccionesActivas(instruccionesActivas);

            ControlGestorAjustes.getInstance().guardarAjustes(ajustes);

            System.out.println("Ajustes guardados correctamente.");
        }
        
        

    }
    
    private void initContent(){
        panel(objMenuAc);
    }
    
    private void panel(JPanel p){
       
        p.setSize( 920, 540);
        p.setLocation(0, 0);
        objMenu.getjPanel_Contenido().removeAll();
        objMenu.getjPanel_Contenido().add(p, BorderLayout.CENTER);
        objMenu.getjPanel_Contenido().revalidate();
        objMenu.getjPanel_Contenido().repaint();
    }
    
    private void initPerfil(){
        objPerfil.getjLabel3_Name().setText(" "+v.getNom());
        objPerfil.getjLabel3_Edad().setText(" "+v.getEdad());
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Tiempo Activo por Día",
                "Día de la Semana",
                "Minutos Activo",
                crearDataset()
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getRenderer().setSeriesPaint(0, Color.BLUE); 
        plot.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);

        
        objPerfil.getjPanel1_grafica().setLayout(new BorderLayout());  

        objPerfil.getjPanel1_grafica().add(chartPanel, BorderLayout.CENTER); 
    }
    private CategoryDataset crearDataset() {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            datos = ControlGestorTiempo.getInstancia().obtenerTiempoPorSemana(v.getId());

            String[] diasSemana = {"Lu", "Ma", "Mi", "Ju", "Vi", "Sa", "Do"};
            Map<String, Integer> acumuladoPorDia = new HashMap<>();

            for (int i = 1; i <= 7; i++) {
                String diaTexto = diasSemana[i - 1];
                acumuladoPorDia.put(diaTexto, 0);
            }

            for (Map.Entry<String, Integer> entry : datos.entrySet()) {
                String fecha = entry.getKey();
                int valor = entry.getValue();

                int numDia = obtenerDiaSemana(fecha);
                String diaTexto = diasSemana[numDia - 1];

                
                acumuladoPorDia.put(diaTexto, acumuladoPorDia.get(diaTexto) + valor);
            }

            for (String dia : diasSemana) {
                dataset.addValue(acumuladoPorDia.get(dia), "Tiempo Activo", dia);
            }

            return dataset;

    }

    private int obtenerDiaSemana(String fecha) {
        LocalDate date = LocalDate.parse(fecha); 
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getValue(); 
}

        
    private void inicializarAjustes() {
        
        AjustesM ajustes = ControlGestorAjustes.getInstance().obtenerAjustes(v.getId());

        if (ajustes != null) {
            //int volumenPorcentaje = (int) (objAjustes.getjSlider1_volumen().getValue() * 100.0);
            objAjustes.getjSlider1_volumen().setValue((int) ajustes.getVolumen());
            int volumenPorcentaje = (int) ajustes.getVolumen();
            //float volumenDecimal = volumenPorcentaje / 100f;
            ControlVolumen.setVolumen(volumenPorcentaje);

            
            objAjustes.getjCheckBox1_sonido().setSelected(ajustes.isSonidoActivo());
            objAjustes.getjCheckBox2_instrucciones().setSelected(ajustes.isInstruccionesActivas());
            if(ajustes.isSonidoActivo()==false){
                ControlVolumen.setVolumen(0);
            }
        }
        if(ajustes == null){
            ajustes = new AjustesM();
            ajustes.setIdUsuario(v.getId());  
            ajustes.setVolumen(100);
            ajustes.setSonidoActivo(true);
            ajustes.setInstruccionesActivas(true);

            ControlGestorAjustes.getInstance().guardarAjustes(ajustes);
        }
    }
}
