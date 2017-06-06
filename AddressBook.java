

class Person {
    
    final private String name;
    final private String address;
    final private String phNo;
    
    Person(String name, String address, String phNo){    // Parameterized Constructor 
        
        this.name = name;
        this.address = address;
        this.phNo = phNo;
    }

    public String getAddress() {
        return address;
    }

    public String getPhNo() {
        return phNo;
    }
    
   
    String getName(){
        
        return this.name;
    }
    
    void printInfo(){
        
        System.out.println(" \n Name: " + this.getName());
        System.out.println(" Address: " + this.getAddress());
        System.out.println(" PhoneNo.: " + this.getPhNo());
    }
}

//--------------------------------------------------------------------------------------


import java.util.ArrayList;
import java.util.Scanner;




class AddressBook {
    
    final private ArrayList <Person> al;
    final private Scanner input;
    
    AddressBook(){
        
        this.input = new Scanner(System.in);
        al = new ArrayList();
    }
    
    void addPerson (){
        
        String name;
        String address;
        String phNo;
        System.out.print("\n Enter Name: ");
        name = this.input.nextLine();
        System.out.print("\n Enter Address: ");
        address = this.input.nextLine();
        System.out.print("\n Enter phNo: ");
        phNo = this.input.nextLine();
        
        Person p = new Person (name, address, phNo);
        boolean b = al.add(p);
        if(b)
            System.out.println("\n Person Successfully added..");
        else
            System.out.println("\n Person not successfully added..");
    }
    
    void removePerson (String name){
        
        boolean check = false;
        
        for (Person temp : al) {
            
            if( name.equals(temp.getName()) ) {
                
                check = true;
                boolean b = al.remove(temp);
                if(b) System.out.println("\n Person Successfully removed..");
                else  System.out.println("\n Person not successfully removed..");
            }   
        }
        
        if(!check) System.out.println("\n Person not found ");
    }
    
    void searchPerson (String name){
        
        for (Person temp : al) {
            
            if(name.equals(temp.getName())){
                
                System.out.println("\n "+name+" is found at index "+ al.indexOf(temp));
                temp.printInfo();
            }
            else
                System.out.println("\n Person not found..");          
        }
    }
}

//--------------------------------------------------------------------------------------------

import java.util.Scanner;



public class Main {
    
    private final AddressBook obj = new AddressBook();
    private final Scanner input = new Scanner(System.in);
    
    
    public static void main(String [] args) {
        
        new Main().displayMenu();
        
       
        System.out.println();
       
    }
    
    void displayMenu (){
        
        while(true){
            
            String temp;
            int select = 0;
            System.out.print("\n Address Book\n\n 1: Add Person\n 2: Delete Person\n 3: Search Person\n 4: Exit\n\n Select: ");
            try{
                
                select = Integer.parseInt(input.nextLine());
            }
            catch(NumberFormatException nfe){
                
                System.out.println(nfe);
            }
            switch (select){
                
                case 1:
                    
                    obj.addPerson();
                    break;
                case 2:
                    
                    System.out.print("\n Enter the name: ");
                    temp = input.nextLine();
                    obj.removePerson(temp);
                    break;
                case 3:
                    
                    System.out.print("\n Enter the name: ");
                    temp = input.nextLine();
                    obj.searchPerson(temp);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Invalid input !!");
            }
        
        }
    }
    
}



