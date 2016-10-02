package project_euler;
import java.util.Scanner;
import java.util.ArrayList;
public class Divisors 
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number :  ");
		ArrayList<Long> divisors=new ArrayList<Long>();
		long num = scanner.nextInt(),i;
		for (i = 1; i <= num; i++) 
			if (num % i == 0)divisors.add(i);
		System.out.println(divisors);
		System.out.println("The number of divisors is "+divisors.size());
		scanner.close();

	}

}
