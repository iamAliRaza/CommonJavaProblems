
import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Scanner;

class HeartRate 
{
    
    private final String name;
    private final int age;
    
    private final int VALUE = 220;
    private final float LOWER_LIMIT = 50.0f;
    private final float UPPER_LIMIT = 85.0f;
    private static final Scanner INPUT = new Scanner (in);
	
    HeartRate( String n, int a )
    {       
        name = n;
        age = a;
    }
    
    String targetedHeartRate()
    {
        
        float lowEnd  =  maxHeartRate() * ( LOWER_LIMIT / 100.0f );
        float highEnd =  maxHeartRate() * ( UPPER_LIMIT / 100.0f ) ;
        
        String concatenate = (int)lowEnd + " - "+ (int)highEnd;
        return concatenate;
    }
    
    int maxHeartRate()
    {
         
        int result = VALUE - age;
        return result; 
    }
    
    void print()
    {
        
        out.println(" Name                      : " + name);
        out.println(" Age                       : " + age);
        out.println(" Maximum heart rate        : " + maxHeartRate() + " beats per minute");
        out.println(" Targeted heart rate range : " + targetedHeartRate() + " beats per minute");
    
    }

	public static void main(String [] args)
    {
        
        String temp;
        String name;
        int age;
        
        
        HeartRate [] obj;
        obj = new HeartRate [5];
        
        for( int i = 0; i < 5; i++ )
        {
            
            out.println();
            out.print(" Enter name person " + (i+1) + " : ");
            name = INPUT.nextLine();
            out.print(" Enter age person " + (i+1) + " : ");
            temp  = INPUT.nextLine();
            
            age = Integer.parseInt(temp); 
            
            if(age <= 0)
            {
                
                out.println();
                out.println("Invalid input !! Input again . .");
                i--;
                continue;
            }
            
            obj[i] = new HeartRate(name,age);
            out.println();
            obj[i].print();
            out.println();
        }
    
    }
    
}

