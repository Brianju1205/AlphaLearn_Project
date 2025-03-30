/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
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
    
    private Perfil objPerfil;
    private Verificador v;
    private Map<String, Integer> datos;
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

            datos = ControlGestorTiempo.getInstancia().obtenerTiempoPorSemana();

            String[] diasSemana = {"Lu", "Ma", "Mie", "Jue", "Vie", "Sa", "Dom"};

            for (String dia : diasSemana) {
                dataset.addValue(0, "Tiempo Activo", dia);
            }

            for (Map.Entry<String, Integer> entry : datos.entrySet()) {
                String diaSemana = obtenerDiaSemana(entry.getKey()); 
                dataset.addValue(entry.getValue(), "Tiempo Activo", diaSemana);
            }

            return dataset;
        }

        private String obtenerDiaSemana(String fecha) {
            LocalDate date = LocalDate.parse(fecha); 
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            return dayOfWeek.name(); 
        } 
}