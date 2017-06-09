
// Problem Statement:
// ------------------------------------------------

// Write a Java program which fill a 2D-array square array as per a given patterns 1 and 2 and display them.  
// 
// Your program should proceed as follows: 
// 1.	Display a welcome message. 
// 2.	Prompt the user for an integer which is >=3. If the number entered is < 3, keep prompting the user until they enter a number >=3. 
//        This number will determine the size of the square array. 
// 3.	Fill the array as per pattern 1 and display it using printf to format the array. 
// 4.	Fill the same array as per pattern 2 and display it using printf to format the array.  
// 5.	Display a closing message.  
//
//
// Pattern 1:                  Pattern 2:
//
//   1  2  3  4  5              1  2  3  4  5
//  10  9  8  7  6             10  6  7  8  9
//  11 12 13 14 15             14 15 11 12 13
//  20 19 18 17 16             20 19 18 16 17
//  21 22 23 24 25             22 23 24 25 21
  

import static java.lang.System.out;
import java.util.Scanner;



class ArrayPatterns {
    
    private final Scanner input = new Scanner (System.in);
    private int [][]array;
    
    
    void displayWelcomeMessage(){
        
        out.println("\n [----------------]");
        out.println(" [ Array Patterns ]");
        out.println(" [----------------]");
        takeInput();
    }
    
    void diplayClosingMessage(){
        
        out.println("\n All done!!!!");
    }
    
    private void takeInput(){
        
        out.print("\n How many rows/columns do you want your array to have? (Must be atleast 3): ");
        int select = input.nextInt();
        
        if( select < 3 ){
            
            out.println(" Let's try this again ....");
            takeInput();
        }
        else{
            
            array = new int [select][select];
            this.poplateArray();
        }
        
    }
    
    private void poplateArray(){
        
        int number = 1;
      
        for (int[] array1 : array) {
            
            for (int j = 0; j < array1.length; j++) {
                
                array1[j] = number++;
            }
        }
    }
    
    void displayArray (){
        
        out.println();
        for (int[] array1 : array) {
            
            for (int j : array1) {
                
                out.printf("  %d", j);
            }
            out.println();
        }
    
    }
    
    void patternOne(){
        
        int [] temp = new int [array.length];
        
        
        for( int i = 1; i < array.length; i+= 2 ){  // odd rows
            
            int index = array.length - 1;
            System.arraycopy(array[i], 0, temp, 0, array.length);
            
            for(int j = 0; j < array.length; j++)
                
                array[i][j] = temp[index--];
        }
        
        out.println("\n Pattern 1:");
        this.displayArray();
        this.poplateArray();
    }
    
    void patternTwo(){
        
        int overwritePreviousValue = 0;
        int minusValue = 1;
        for ( int i = 1; i < array.length; i++ ) {
            
            this.shiftingElements(array[i], overwritePreviousValue++, minusValue++);
        }
        
        out.println("\n Pattern 2:");
        this.displayArray();
    
    
    }
    
    
    // My Algorithm 
    
    private void shiftingElements( int [] arr, int overwritePreviousValue, int minusValue ){
       
        int [] temp = new int [arr.length]; 
        System.arraycopy(arr, 0, temp, 0, arr.length);
        int hold;
        int index = arr.length - 1;
        
        
           for( int j = index; j >= 0; j-- ){
               
               if( overwritePreviousValue == j ){
                  
                   arr[j] = temp[index--]; 
               
                   overwritePreviousValue--;
               }
               else{
                    arr[j] = arr[j-minusValue];
                    
               }
           
       }
    }

}
    
----------------------------------------------------------------------------------------
        Main class
----------------------------------------------------------------------------------------


public class Main {
    
    public static void main(String [] args) {
       
       ArrayPatterns ap = new ArrayPatterns();
       
       ap.displayWelcomeMessage();
       ap.patternOne();
       ap.patternTwo();
       ap.diplayClosingMessage();
      
       
       System.out.println();
    }
       
}

