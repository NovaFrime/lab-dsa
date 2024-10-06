//********************************************************************
//  GasMileage.java       Author: Lewis/Loftus
//
//  Demonstrates the use of the Scanner class to read numeric data.
//********************************************************************

import java.util.Scanner;

public class GasMileage
{
   //-----------------------------------------------------------------
   //  Calculates fuel efficiency based on values entered by the
   //  user.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      double gallons, mpg;
      Scanner scan = new Scanner(System.in);
      for (int i = 0; i < 2; i++) {
        System.out.print("Enter the car name, miles, and gallons (separated by blanks): ");
        
        String carName = scan.next(); 
        
        //double miles = scan.nextDouble();
        //1st way, we make sure that the input work with integer as float
        int miles = (int) Math.ceil(scan.nextDouble());
        //2nd way, we can round that number and convert it back to an integer        gallons = scan.nextDouble(); 

        gallons = scan.nextDouble(); 

        mpg = miles / gallons; 
        System.out.println(carName + " - Miles Per Gallon: " + mpg);
     }
   }
}
