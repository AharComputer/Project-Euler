package project_euler;

public class Factorial_Sum 
{
	public static long getSumDigits(double i)
	{
		long temp1=0;
		while(i!=0){
			temp1+=i%10;
			while(i%10==0){i/=10;continue;}
			i=(long)i/10;
		}
		return temp1;
		
	}
	public static void main(String args[])
	{
		double number=1;
		for(double factorial=1;factorial<=100;factorial++){
			number=1;
			for(double n =factorial;n>1;n--)number*=n;
			System.out.printf("%.0f!=%.0f\t\t",factorial,number);}
		System.out.print("\n"+getSumDigits(number));
		
	}
}
