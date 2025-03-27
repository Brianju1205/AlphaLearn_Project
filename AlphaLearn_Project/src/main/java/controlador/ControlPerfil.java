/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;
import vistas.Perfil;

/**
 *
 * @author juare
 */
public class ControlPerfil {
    
    Perfil objPerfil;
    Verificador v;

    public ControlPerfil(Perfil objPerfil) {
        this.objPerfil = objPerfil;
        v = Verificador.getInstancia();
        
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
        
        dataset.addValue(120, "Tiempo Activo", "Lunes");
        dataset.addValue(20, "Tiempo Activo", "Martes");
        dataset.addValue(150, "Tiempo Activo", "Miércoles");
        dataset.addValue(180, "Tiempo Activo", "Jueves");
        dataset.addValue(200, "Tiempo Activo", "Viernes");
        dataset.addValue(220, "Tiempo Activo", "Sábado");
        dataset.addValue(130, "Tiempo Activo", "Domingo");
        
        return dataset;
    }
    
    
    
}
