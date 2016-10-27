

class TwoLacPrimeSum
{
    
    public static boolean checkPrime ( final long number ) {
    
    final double limit = Math.floor ( Math.sqrt ( number ) );
        
    for( long i = 2; i <= limit ; i++ ){
    
        if( number % i == 0 ) return false;
        
    }
    
    return true;
    
    }
    
    public static void main( String [] args ) {
        
		long loop = 2;
        long counter = 0;
        long sum = 0;
        final long limit = 200000;
        
        while(true) {
        
            if ( Prime.checkPrime( loop ) ) {
            
                counter = counter + 1;
                sum = sum + loop;

             // System.out.println(i + "  " + sum);
        	}
            
        else if ( counter == limit ) break;
            
		++ loop;
    	}
    
		System.out.println( " \n Sum of 2 lac's Prime number = " + sum );
	}
}
