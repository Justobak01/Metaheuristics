package Maxone;
 import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  

/**
 * Write a description of maxOnePlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class maxOnePlot extends JFrame{
    
  private static final long serialVersionUID = 1L;  
  public maxOnePlot(String title) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Algorithm Optimization", // Chart title  
        "Fitness", // X-Axis Label  
        "Generation", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset() {  
  
    String series1 = "20 size Genome";  
     
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
     String filePath = "D:\\Sauvegarde\\2021-2022\\Metaheuristics\\TP- S-Metaheuristic-Algorithm\\S-Metaheuristic-Algorithm\\Metaheuristics\\Maxoneout.stat";
     float [][] maxOneDataSet = Main.dataSetGenerate(filePath);
     int Listlen = maxOneDataSet[0].length;
  
    for (int i = 0; i<Listlen; i++){
    dataset.addValue(maxOneDataSet[0][i], series1,Float.toString(maxOneDataSet[1][i]));  
    }
    return dataset; 
  }  
  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(() -> {  
      maxOnePlot example = new maxOnePlot("Line Chart Example");  
      example.setAlwaysOnTop(true);  
      example.pack();  
      example.setSize(600, 400);  
      //example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  


