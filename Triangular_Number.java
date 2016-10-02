package project_euler;

public class Triangular_Number 
{
	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		long triangle=1,amount=0,maxTriangle=1,maxDivisor=0;
		for(int n =1;amount<=500;n++)
		{
			amount=0;
			triangle=n*(n+1)/2;
			for (long divisor = 1; divisor <= triangle/2; divisor++) 
				if (triangle % divisor == 0)amount++;

			if(amount>maxDivisor)
			{
				maxTriangle=triangle;
				maxDivisor=amount;
			}
		}
		System.out.println(maxTriangle);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("this program took "+totalTime);
	}
}
