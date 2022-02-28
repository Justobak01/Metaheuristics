


/**
 * Write a description of main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package Maxone;
import ec.Evolve;
import edu.duke.*;
import java.io.*;;
import java.util.ArrayList;


public  class Main {
    public static float [][] dataSetGenerate(String File){
        FileResource outStats = new FileResource(File); 
        // List of generations and fitness dinymically allocated
        ArrayList<Float> generationsList = new ArrayList<Float>(); 
        ArrayList<Float> fitnessList = new ArrayList<Float>();
        for (String line : outStats.lines()){
            System.out.println(line);
            String lineString = line.toString();
            if (lineString.startsWith("Generation")){
                generationsList.add(Float.parseFloat(lineString.substring(12,lineString.length())));
            }
            if (lineString.startsWith("Fitness")){
                fitnessList.add(Float.parseFloat(lineString.substring(9,lineString.length())));
            }
        }
        
        // converting the generations and fitness lists to arrays (from tutorialspoint)
        final float[] genarr= new float[generationsList.size()];
        int index = 0;
        for (final Float value: generationsList) {
            genarr[index++] = value;
        }
        final float[] finarr= new float[fitnessList.size()];
        int ind = 0;
        for (final Float value: fitnessList) {
            finarr[ind++] = value;
        }
        float [][]dataSet = new float[fitnessList.size()][2];
        dataSet[0]= genarr;
        dataSet[1]= finarr;
        return (dataSet);
    }
    public static void testDataSetGenerate(){
        String filePath = "D:\\Sauvegarde\\2021-2022\\Metaheuristics\\TP- S-Metaheuristic-Algorithm\\S-Metaheuristic-Algorithm\\Metaheuristics\\Maxoneout.stat";
        float [][] dataSet = dataSetGenerate(filePath);
        // Printing the data; Code from tutorialsPoint.
       System.out.println("Elements of float array...");
       for (Float i: dataSet[0]) {
         System.out.println(i);
        }
        for (Float i: dataSet[1]) {
         System.out.println(i);
        }
        
    }
    public static void main(String[] args) {
        String pathToFiles = "D:\\Sauvegarde\\2021-2022\\Metaheuristics\\TP- S-Metaheuristic-Algorithm\\S-Metaheuristic-Algorithm\\Metaheuristics\\Maxone";
        int numberOfJobs = 10;
// String statisticType = "ec.gp.koza.KozaShortStatistics";
        String[] runConfig = new String[] {
            Evolve.A_FILE, "D:\\Sauvegarde\\2021-2022\\Metaheuristics\\TP- S-Metaheuristic-Algorithm\\S-Metaheuristic-Algorithm\\Metaheuristics\\Maxone\\tutorial1.params",
// "-p", ("stat="+statisticType),
            "-p", ("stat.file=$"+pathToFiles+"out.stat"),
            "-p", ("jobs="+numberOfJobs)
            };
            Evolve.main(runConfig);
        String filePath = "D:\\Sauvegarde\\2021-2022\\Metaheuristics\\TP- S-Metaheuristic-Algorithm\\S-Metaheuristic-Algorithm\\Metaheuristics\\Maxoneout.stat";
        float [][] dataSet = dataSetGenerate(filePath);
        }
    

}
