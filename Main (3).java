import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/*
@author Ermina Ashraf

This program creates a rewards program for Northeast airlines that accumulates the total number of cancelled flights at the end of the year, then calculates the number of miles received, and puts passenger into a rewards program accordingly.

@param args
@throws IOException
*/

class Main {
  public static void main(String[] args) throws IOException {
    
    FileInputStream airlineData = null;  //file input stream
    Scanner input = null;  //Scanner object
    
    
    airlineData = new FileInputStream("flight-data.txt");  //open file for reading
    input = new Scanner(airlineData);  //creates new Scanner using airlineData
    
    ArrayList<Passenger> list = new ArrayList<Passenger>();
    
    int passID;
    String cancelFlight;
    String complaint = "N";
   
    /*
    this loop will iterate through each line in the file and save it into the coressponding primitive type/wrapper class
    */
    
    while (input.hasNextLine())  //while file has line
      {
        passID = input.nextInt();  //save next int into passID
        
        cancelFlight = input.next();  //save next String into cancelFlight

        if(cancelFlight.equals("Y"))  //if cancel flight is Y, then save next String into complaint
        {
          complaint = input.next();
        }


        /*
        the next for loop and if statement will accumulate the total number of cancelled flights for each passenger as well as determine if the passenger complained at all
        */
        
        boolean accountFound = false;  //initialize boolean to false
        for(int i = 0; i<list.size(); i++)  // iterate through arraylist
          {
            if(list.get(i).getID() == passID)  //this compares the passenger ID's throughout the file
            {
              accountFound = true;  //if passenger ID is same as current ID set to true
              if(cancelFlight.equals("Y"))  //if cancelFlight is Y
              {
                boolean cancelled = true; 
                list.get(i).addFlight(cancelled);  //addflight and pass true bool 
              }
              else
              {
                boolean cancelledd = false;      //else addflight and pass false bool
                list.get(i).addFlight(cancelledd);
              }
              if(complaint.equals("Y"))  //if complaint is Y pass false bool to set multiplier to set to false indefinitely
              {
                boolean m = false;
                list.get(i).setMult(m);
              }
            }
          }
        
        if(accountFound == false)  //if account was not found
        {
          Passenger p = new Passenger(passID, new NoTier(0,0), 0, 0);  //create a passenger object
          list.add(p);  //add passenger object to ArrayList
          
          if(cancelFlight.equals("Y"))  //if cancelFlight is Y
          {
            boolean cancelled = true; 
            p.addFlight(cancelled);  //addflight and pass true bool 
          }
          else
          {
            boolean cancelledd = false; //else addflight and pass false bool
            p.addFlight(cancelledd);
          }
          if(complaint.equals("Y"))  //if complaint is Y, pass false bool indefinitely 
          {
            boolean m = false;
            p.setMult(m);
          }
        }
        
        /*
        this for loop will read through the arraylist and determine whether or not the passenger should get the mileage multiplier through a series of if statements. if list has multiplier and the cancelled flights falls within the range 50-100 or 100> then program will call setPlatPro() or setSuperExec
        */
        
        for(int i = 0; i < list.size(); i++)
          { 
            if(list.get(i).hasMultiplier() && (list.get(i).getCancelledFlights() >= 50 && list.get(i).getCancelledFlights() < 100))
            {
              list.get(i).setPlatPro();
            }
            if(list.get(i).hasMultiplier() && (list.get(i).getCancelledFlights() >= 100))
            {
              list.get(i).setSuperExec();
            }
          }
      }

    Main callPrint = new Main();  //create main object to call print method and pass through array list
    callPrint.print(list);
    
    input.close();        //close everything
    airlineData.close();
  }
  public void print(ArrayList <Passenger> list) throws IOException
  {
    boolean IdCheck = false;
    int index = -1000;
    /* this will create an iterating menu that will only end if user enters 2 to quit. if user enters invalid number then menu will repeat until correct number is selected
    */
    int input = 0;
    while(input != 2)
      {
        System.out.println("\nMENU\n----------------------");
        System.out.println("1: Get Passenger Info");
        System.out.println("2: Quit");
        System.out.print("----------------------\nEnter menu option: \n");
        Scanner in = new Scanner(System.in);
        input = in.nextInt();
        
        switch(input)
          {
            case 1:
              System.out.print("\nEnter Passenger ID number: ");
              Scanner getPass = new Scanner(System.in);  //create scanner
              int passengerID = 0;
              passengerID = getPass.nextInt();  //get input
              System.out.print("\n");

              for(int i = 0; i < list.size(); i++)
              {
                if(passengerID == list.get(i).getID()) //if true store true in IdCheck 
                {
                  IdCheck = true;  
                  index = i;
                }
              }
              if(IdCheck)  //if idCheck is true print
              {
                System.out.println("Total flights cancelled: " + list.get(index).getCancelledFlights());
                System.out.println("Does passenger qualify for Mileage Multiplier?: " + list.get(index).hasMultiplier());
                System.out.println("Tier: " + list.get(index).getTier()); 
                System.out.println("Total miles: " + list.get(index).getMiles());
              }
              else  //otherwise invalid statement. re-enter 
              {
                System.out.println("invalid id!! ");
              }
            break;   
          } 
      }
  }
}