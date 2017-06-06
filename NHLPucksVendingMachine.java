
/*
Problem Statement of this Pucks Vending Machine:

There are 30 hockey teams in the NHL (National Hockey League). Some stores have 
vending machines that dispense miniature team hockey pucks for a toonie ($2) each. 
When you put in a toonie you never know which puck you will get; any one of the 30 team 
pucks is as likely as any other to be dispensed by the machine. 

They are given out at random. 

For this exercise we will limit the teams to 10.   
 
Your job is to write a program to simulate the dispensing of NHL miniature pucks 
until one of each 10 miniature team hockey pucks is dispensed. 
 
Your program should proceed as follows: 

1.	Display a welcome message and ask the user to enter their name.   
2.	Store your 10 favorite hockey teams’ name in an array of String. Assign the team names in the declaration statement directly. 
3.	Your program should loop(use a while loop) until at least one miniature puck of each team has been dispensed. Create an integer 
    array of size 10, which will serve as a counter array to keep track of the number of each team puck dispensed by the vending 
    machine. You will need to use the Math.random()function to randomly dispense a miniature puck. The Math.random() method 
    returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.  
4.	Once you have accumulated at least one of each puck, display how many of each team puck you had to purchase, the total number 
    of pucks purchased and the total cost in a personalized message.  


 * 
 */




import static java.lang.System.out;
import java.util.Scanner;


class NHLPucksVendingMachine {
    
    private static final int PUCK_PRICE;
    private static final int TEAM_SIZE;
    private int [] countEachPucks;
    private final String teamNames [];
    private int totalPucks;
    private String userName;
    private final int [] spaces;
  
    static{
        
        PUCK_PRICE = 2;
        TEAM_SIZE = 10;
    }

    NHLPucksVendingMachine() {
        
        this.teamNames = new String[]{"Montreal Canadians", "Boston Bruins", "Chicago BlackHawks", "Detroit Red Wings", "New York Rangers", 
                                       "Buffalo Sabres", "Philadelphia Flyers", "Winnipeg Jets", "Vancouver Canucks", "Ottawa Senators"};
        this.spaces = new int []{4,9,4,5,6,8,3,9,5,7};
    }
    
    private boolean checkArrayElements(){
        
        int counter = 0;
        
        for ( int value : this.countEachPucks ){
            
            if( value >= 1 ){ ++counter; }
        }
        
        return (counter == 10);     
    }

    void displayWelcomeMessage(){
        
        out.println(" = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0");
        out.println(" = 0                                                         = 0");
        out.println(" = 0       NHL Miniature Hockey Puck Vending Machine         = 0");
        out.println(" = 0                                                         = 0");
        out.println(" = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0 = 0");
        out.print("\n\n Hello, what is your first name?  ");
        
        userName = new Scanner(System.in).nextLine();
        
        out.println("\n Welcome "+userName+"! Let's see how much money you will need to spend to get all of the pucks.");
        
        this.logic(); // Function calling 
    }
    
    private void logic(){
        
        int tempCounter = 1;
        boolean check = false;
        
        this.countEachPucks = new int [NHLPucksVendingMachine.TEAM_SIZE];
        
        while ( true )
        {
            // Generate Random  number within the range of array Size [0-9]
            int random = (int) (Math.random() * (NHLPucksVendingMachine.TEAM_SIZE - 0)) + 0; 
            
            ++this.countEachPucks[random];    // Increment in array according to random index
            
            if(tempCounter >= 10){
                
                check = this.checkArrayElements(); // Function calling for checking that all indexes of array is populated or not  
            }
            
            if(check) break;
            ++tempCounter;
        }
        
        this.displayResult(); // Function calling
    }
    
    private void displayResult()
    {
        
        out.println("\n Here is the breakdown of the pucks dispensed:\n");
        
        for( int i = 0; i < NHLPucksVendingMachine.TEAM_SIZE; i++ )
        {
            
            out.println(String.format(" "+this.teamNames[i]+"%"+this.spaces[i]+"s "+this.countEachPucks[i],":"));
            
            this.totalPucks = this.totalPucks + this.countEachPucks[i];
        }
        out.println("\n Wow "+this.userName+", you bought a total of "+this.totalPucks+" pucks at a total cost of $"
                    +this.calculatePrice()+" to get a miniature puck of each team.  Enjoy them! ");
    }
    
    private int calculatePrice()
    {
        
        return ( this.totalPucks * NHLPucksVendingMachine.PUCK_PRICE );
    }
}
// ---------------------------------------------------------------------------------------
// End of NHLPucksVendingMachine class
// ----------------------------------------------------------------------------------------


public class Main {
    
    public static void main(String [] args) {
       
       new NHLPucksVendingMachine().displayWelcomeMessage(); 
       
       System.out.println();
       
    }
}


