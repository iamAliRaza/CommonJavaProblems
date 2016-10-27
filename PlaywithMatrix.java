
/**

This Program is based on 2 dimensional array. 
Lots of methods are defined below.
Each method perform different operations on a matrix.

*/

import java.util.Scanner;
import static java.lang.System.out;

class Matrix {
    
    private int rows;
    private int columns;
    private int [][]matrix;
    public static Scanner input;
    private int size;
    private int decrement;
    private int sum[];
    private int save[];
    
    static{
        
    input = new Scanner( System.in );
    
    }
    private boolean inputChecker () {
        
    return( this.rows == 0 && this.columns == 0 );
    
    }
    private void subFunction( final int check ) {
        
        int hold = 0;
        
        if ( check == 2 ) {
        
            hold = rows;
            rows = columns;
            columns = hold;
        }
    
        for ( int i = 0 ;i < rows ; i++ ) {
        
            for ( int j = 0; j < columns ; j++ ) {
            
                if ( check == 2 )
                    sum[i] = sum[i]+matrix[j][i];
                else
                    sum[i] = sum[i]+matrix[i][j];
                
            }
        }
        if ( check == 2 ){
                
            hold = columns;
            columns = rows;
            rows = hold;
        }
    }
    private void largestNumberFinder ( int check ) {
        
        int size = 0;
        int i=0;

        if( check == 1 ) size = this.rows;
        else size = this.columns;
        
        for ( i = 0 ; i < size ; i++ ) {
        
            switch ( check ) {
                case 3:
                    save[i] = this.matrix[rows-1][i];
                    break;
                case 2:
                    out.println("\tLargest number in column " + (i+1) + " = " + this.matrix[rows-1][i]);
                    break;
                default:
                    out.println("\tLargest number in row " + (i+1) + " = " + this.matrix[i][columns-1]);
                    break;
            }
        }   
        
    }
    
    private void displayError () {
    
        out.println(" Error : First of all input matrix values then you are able to use other functions ! ");
    }
    public void inputMatrix ( int rows,int columns ) {
        
        this.rows = rows;
        this.columns = columns;
        matrix = new int [rows][columns];
    
        out.println();
            
        for ( int i = 0; i < rows; i++ ) {
       
            for ( int j = 0; j < columns ; j++ ){
    
                out.print(" Enter the element number [ R:"+i+" , C:"+j+" ] : ");
                matrix[i][j] = input.nextInt();
            
                }
            System.out.println();
            }
    
        }

    public void displayMatrix () {
        
        if ( this.inputChecker () )
         
            this.displayError();
        
        else {
        out.println("\n\t   >>> Matrix in tabular format <<<\n");
        out.println();    
        for ( int i = 0; i < rows; i++ ) {
            
            out.print("\t\t[ ");
        
            for ( int j = 0; j < columns; j++ ){
                
				if ( j == columns-1 )
                    out.print(matrix[i][j]);

                else if ( matrix[i][j] < 10 )
                    out.print(matrix[i][j]+"     ");
                
				else
                    out.print(matrix[i][j]+"    ");
                }
                    out.println(" ]");
            }
        }
        
    }
    
    public void rowSort ( int check ) {
        
        if ( this.inputChecker () )
         
            this.displayError();
        
        else {
            
        this.size = this.columns - 1;
        int hold = 0;
        for ( int i = 0 ; i < rows ; i++ ){
            
            decrement = 1;
        
            for ( int support = 0 ; support < size ; support++ ){ 
           
                for ( int j = 0 ; j < columns - decrement ; j++ ){
            
                    if ( matrix [i][j] > matrix [i][j+1] ){
                    
                        hold = matrix [i][j];
                        matrix [i][j] = matrix [i][j+1];
                        matrix [i][j+1] = hold;
                    }
                }
                ++decrement;
            }
        }
		if ( check == 0 )
        this.displayMatrix();
      }
    }
    public void columnSort ( int check ) {
        
        if ( this.inputChecker () )
        
            this.displayError();
        
        else {
        
        this.size = this.rows - 1;
        int hold = 0;
        
		for ( int j = 0 ; j < columns ; j++ ){ 
        
            decrement = 1;
            
            for ( int support = 0 ; support < size; support++ ){
           
                for ( int i = 0 ; i < rows - decrement ; i++ ){
            
                    if ( matrix [i][j] > matrix [i+1][j] ){
                    
                        hold = matrix [i][j];
                        matrix [i][j] = matrix [i+1][j];
                        matrix [i+1][j] = hold;
                    }
                }
                ++decrement;
            }
        }
		if( check == 0 )
        this.displayMatrix();
      }
    }
    
    public void sumRow () {
       
         if ( this.inputChecker () )
        
            this.displayError();
        
        else {
        
        sum = null;
        sum = new int [rows];
        
        out.println();
        
        this.subFunction(1);
        
        this.displayMatrix();
        
        out.println();
        
        for ( int i = 0 ; i < sum.length ; i++ ) {
        
            out.println("\tSum of Rows "+ (i+1) + " = " + sum[i]);
            
            }
         }
        
    }
    
    public void sumColumn () {
        
         if( this.inputChecker () )
        
            this.displayError();
        
        else {
        
        sum = null;
        sum = new int [columns];
        
        this.subFunction(2);
        
        this.displayMatrix();
        
        out.println();
        
        for( int i = 0 ; i < sum.length ; i++ ){
        
            out.println("\tSum of Column "+ (i+1) + " = " + sum[i]);
            
            }
         }
        
    }
    
    public void sumWholeMatrix () {
        
         if ( this.inputChecker () )
        
            this.displayError();
        
        else { 
         
        sum = null;
        sum = new int [this.rows];
        this.subFunction(1);
        this.displayMatrix();
        int save = 0;
        
        for ( int i = 0; i < sum.length; i++ ) {
        
            save = save + sum[i];
            }
        out.println( "\n\tSum of Whole matrix = " + save );
         }
    }
    
    public void largestInEachRow(){
        
         if( this.inputChecker () )
        
            this.displayError();
        
        else {
        
		this.displayMatrix();
        this.rowSort(1);
        out.println();
        
        this.largestNumberFinder(1);
         }
    }
    
    public void largestInEachColumn () {
        
         if ( this.inputChecker () )
        
            this.displayError();
        
        else {

    	this.displayMatrix();
        this.columnSort(1);
        out.println();
        
        this.largestNumberFinder(2);
         }
    }
    
    public void largestInWholematrix(){
        
         if ( this.inputChecker () )
        
            this.displayError();
        
        else {
    
        save = new int[columns];
		this.displayMatrix();
        this.columnSort(1);
        out.println();
        
        this.largestNumberFinder(3);
        
        int max = save[0];
        for ( int i = 0; i < save.length;i++ ) {
        
            if ( save[i] > max )
                max = save[i];
            
            }
        out.println(" Largest number in a matrix = " + max);
        }
    }
}

public class PlaywithMatrix {
    
    private static void displayMenu ( final Matrix obj ) {
        
        
        int select = 0;
   
        char c = 'y';
        
        while(c!='n') {
            
            out.println("\n");
            out.print("   ------- Menu -------\n\n");
            out.println(" 1  : Input Matrix");
            out.println(" 2  : Display Matrix");
            out.println(" 3  : Row Wise Sort Matrix");
            out.println(" 4  : Column Wise Sort Matrix");
            out.println(" 5  : Display Sum of each row in Matrix");
            out.println(" 6  : Display Sum of each column in Matrix");
            out.println(" 7  : Display Sum of Whole Matrix");
            out.println(" 8  : Largest number in each row from Matrix");
            out.println(" 9  : Largest number in each column from Matrix");
            out.print(" 10 : Largest number in Whole Matrix\n\n Select : ");

            select = Matrix.input.nextInt();

            out.print("\n\n");

            switch ( select ) {

                case 1:

                    int row,column;
                    out.print(" Enter the number of rows : ");
                    row = Matrix.input.nextInt();
                    out.print(" Enter the number of columns : ");
                    column = Matrix.input.nextInt();
                    obj.inputMatrix(row, column);

                    break;
                case 2:
                    
                    obj.displayMatrix();

                    break;
                case 3:
                    out.println(" : After row wise Sorting : ");
                    obj.rowSort(0);

                    break;
                case 4:
                    out.println(" : After column wise Sorting : ");
                    obj.columnSort(0);

                    break;
                case 5:

                    obj.sumRow();

                    break;
                case 6:

                    obj.sumColumn();

                    break;
                case 7:

                    obj.sumWholeMatrix();

                    break;
                case 8:
                    
                    obj.largestInEachRow();
                    
                    break;
                case 9:
                    
                    obj.largestInEachColumn();
                    
                    break;
                case 10:
                    
                    obj.largestInWholematrix();
                    
                    break;
            }
            out.print("\n Do you want to use any other operation [ y / n ]  : ");
            c = Matrix.input.next().charAt(0);
        }
    
    }
    
    public static void main(String [] args){
        
        Matrix obj = new Matrix();
        
        displayMenu(obj);
        
    }
    
}

    
