/*
 * Copyright 2014 Ghent University, Bayer CropScience.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Java program to illustrate reading data from file
// using nio.File
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
public class Metaheuristics
{
    // Reading file code from GeekforGeeks
  public static List<String> readFileInList(String fileName)
  {
 
    List<String> lines = Collections.emptyList();
    try
    {
      lines =
       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
 
    catch (IOException e)
    {
 
      // do something
      e.printStackTrace();
    }
    return lines;
  }

  
  public int[][] generateRMatrix(int[] solution, int[][] currRMatrix, int solutionSize){
      int [][] newRMatrix = new int[solutionSize][solutionSize];
      for (int currCity =0; currCity<solutionSize; currCity++){
          for (int rCityIndex =0; rCityIndex <solutionSize; rCityIndex++){
              int rScore = currRMatrix[currCity][rCityIndex];
                  for (int index = 0; index < solutionSize; index++){
                      if ((solution[index]==currCity) && (index == rCityIndex)){
                            newRMatrix[currCity][rCityIndex]=rScore+1;
                             for (int update =0; update< solutionSize && update != rCityIndex; update++){
                                    newRMatrix[currCity][update]=0;
                            }
                        }
           
                }
              
            }
        }
    return newRMatrix;
}
    public void printRMatrix(int[][] RMatrix, int solutionSize){
        System.out.println(" ");
        System.out.println("RMatrix: ");
    for (int i =0 ; i<solutionSize; i++){
        for (int j =0 ; j<solutionSize; j++){
            System.out.print(RMatrix[i][j] + " ");
        }
        System.out.println(" ");
    }
    }
    public void printRandSolution(int [] randSolution, int solutionSize){
         System.out.println("Random Solution: ");
        for (int i =0 ; i<solutionSize; i++){
            System.out.print(" "+randSolution[i]);
        }
        System.out.println(" ");
    }
    
    public int[] randomSolutionGenerator(int solutionSize){
        int [] randSolution = new int[solutionSize];
         int [] usedrand = new int[solutionSize];
        int i =0;
        for (i=0; i<solutionSize; i++){
            randSolution[i] = 0;
            usedrand[i] = 0; 
        }
        
        // Initializing the randomSolution vector with zeros (to avoid duplciate)
        i = 0;


        while ( i<solutionSize ){
            Random rand = new Random ();
            int randInt = rand.nextInt(solutionSize);
            randInt = rand.nextInt(solutionSize);
            for (int j=0; j<solutionSize ; j++){
               if (randInt != usedrand[j]&& usedrand[j]!=0){
                   randSolution[i] = randInt;
                   i++;
                }
            }
            
        }
        // i=1;
        // We compare with the value already generated to avoid duplicates
       // while (i<=solutionSize){
           // randInt = rand.nextInt(solutionSize);
           // if (randSolution[i-1] == randInt){
               // randInt = rand.nextInt(solutionSize);
               // randSolution[i] =randInt;
               // i+=1; 
            // }
            // else 
            // {
                // randSolution[i] =randInt;
                // i+=1; 
            // }
        // }
        return randSolution;
    }
    // Intializing the RMatrix with zeros
    public int [][] initRMatrixZ (int solutionSize){
        int [][] rMatrixInit = new int [solutionSize][solutionSize];
        for (int i= 0; i < solutionSize; i++){
            for (int j=0; j<solutionSize; j++){
                   rMatrixInit[i][j] = 0;
            }
        }
        return rMatrixInit;
    }
    // testgenerateRMatrix shows the evolution of the RMatrix; no arguments
    void testgenerateRMatrix(){
        int solutionSize = 5; 
        int [] randSolution = new int[solutionSize]; 
        randSolution = randomSolutionGenerator(solutionSize);
        printRandSolution(randSolution, solutionSize);
        int [][] RMatrix=  initRMatrixZ(solutionSize);       
        printRMatrix(RMatrix, solutionSize);
        RMatrix = generateRMatrix(randSolution,RMatrix , solutionSize); 
        printRMatrix(RMatrix, solutionSize);
    }
  public static void main(String[] args)
  {
    List l = readFileInList("five.19.tsp");
 
    Iterator<String> itr = l.iterator();
    while (itr.hasNext())
      System.out.println(itr.next());
  }
}