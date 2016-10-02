package project_euler;

import java.util.Scanner;

public class Prime_Products 
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Enter any Number to find Prime Factors:  ");  
		long number=input.nextLong();
		input.close();
		
		System.out.print("\nGiven Number is : " + number);
		System.out.print("\nPrime Factors are : " );
		
		        for (int i = 2; i <= number; i++) 
		        {
		 
		            while (number % i == 0) 
		            {
		                System.out.print(i + "  ");
		                number = number / i;
		            }
		        
		        }
		        if (number < 1) System.out.print("\n"+number);
	}

}
