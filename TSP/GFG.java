
/**
 * Write a description of Encoding here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Random;



/* Code Form geeksforgeeks.com*/
public class GFG {
    // Function to print binary number
    static void printBinary(int[] binary, int id)
    {
        // Iteration over array
        for (int i = id - 1; i >= 0; i--)
            System.out.print(binary[i] + "");
    }
 
    // Function converting decimal to binary
    static public int[] decimalToBinary(int num)
    {
        // Creating and assigning binary array size
        int[] binary = new int[5];
        int id = 0;
 
        // Number should be positive
        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }
 
        
        return binary;
    }
    
    public static int [] neighbor_generator( int [] binary_encoded_solution, int index){
        int [] neighbor = new int[4]; 
        for (int i =0; i<4; i++){
           if (i != index){
           neighbor[i] = binary_encoded_solution [i];
        }
        if (i == index){
            int index_unit = binary_encoded_solution [i]; 
            if (index_unit ==1){
                neighbor[i] = 0; 
            }
            if (index_unit ==0){
                neighbor[i] = 1;
            }
        }
    }
        return neighbor; 
    }
    public int [] meta_iter_best(int [] binary_solution, int numiter_max){ 
        int [] iter = new int[4]; 
        int [] curr_Iter = new int[4];
        int [] local_Iter = new int[4];
        double curr_Objective = 0;
        int num_iter= 0;
        double global_objective = objective_function(binary_solution); 
        curr_Iter = neighbor_generator(binary_solution, 0);
        iter = binary_solution;
        while(num_iter<numiter_max){
          System.out.println("iterations n :"+num_iter);
          curr_Objective = objective_function(curr_Iter);
          // Selecting the bests in between neighbors
          for (int i = 1; i<4; i++){
            local_Iter = neighbor_generator(binary_solution, i);
            double local_Objective = objective_function(local_Iter);
            if (local_Objective < curr_Objective){
                curr_Iter = local_Iter;
            }
        }
           // Selecting the best between local best and solution, if local best is better than the global best we have found our global optimum
            if (curr_Objective <= global_objective){
                iter = curr_Iter;
                break;
            }
            num_iter++;
        }
        return iter;
    }
    
    
    public void test_meta_iter_best(){
        Random rand = new Random (); 
        int rand_int = rand.nextInt(31);
        int [] rand_solution= new int [4];
        int [] best_solution= new int [4];
        // Calling Our Above Function
        rand_solution= decimalToBinary(rand_int);
        System.out.println("Random Solution:");
        printBinary(rand_solution,4);
        best_solution = meta_iter_best(rand_solution, 500);
        double Objective = objective_function(rand_solution);
        System.out.println("Random Solution:"+rand_int);
        double global_best = binToDecimal(best_solution);
        System.out.println("Random Solution's Quality:"+Objective);
        System.out.println("Best Solution:" + global_best);
        Objective =objective_function(best_solution);
        System.out.println("Best Solution's Quality:"+Objective);
    }
    
    static public void test_neighbor_generator(){
        Random rand = new Random (); 
        int rand_int= rand.nextInt(31);
        int []  binary_representation = new int[4];
        int []  binary_neighbor = new int[4];
        // Print random integers
        System.out.println("Random Integer: "+rand_int);
        // Calling Our Above Function
        binary_representation = decimalToBinary(rand_int);
        
        // Print Binary
        System.out.println("Binary representation \n");
        printBinary(binary_representation,4);
        binary_neighbor  = neighbor_generator(binary_representation,2);
        System.out.println("\n Neighbor: ");
        printBinary(binary_neighbor,4);
    }
        
        public double binToDecimal(int [] Binary_rep){
        int integer_value = 0;
        for (int i =0 ; i<4; i++){
            integer_value+= Binary_rep[i]*(Math.pow(2,i)); 
        }
        return integer_value;
    }
    
    public double objective_function (int [] random_binary){
        double objective = 0; 
        double integer_value = binToDecimal(random_binary);
        objective = Math.pow(integer_value,3) - 60*Math.pow(integer_value,2)- 900*((double)integer_value); 
        return objective;
    }
    
 
    //Main Driver Code
    public static void main(String[] args)
    {
      // Entered number to be convert into binary
        Random rand = new Random (); 
        int rand_int = rand.nextInt(31);
        int [] rand_binary = new int [4];
        // Print random integers
        System.out.println("Random Solution:");
       
        // Calling Our Above Function
        rand_binary = decimalToBinary(rand_int);
        printBinary(rand_binary,4);
        test_neighbor_generator();
       
    }
    
    
}