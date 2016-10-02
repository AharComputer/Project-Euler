package project_euler;

/*
 * 

There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation, 5C3 = 10.

In general,
nCr = 	
n!/(r!(n-r)!)
	,where r <= n, n! = n×(n-1)×...×3×2×1, and 0! = 1.

It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.

How many, not necessarily distinct, values of  nCr, for 1 <= n <= 100, are greater than one-million?

 */
public class CombinatoricSelections 
{
	
	public static void main(String[] args) 
	{
		int counter=0;
		for(int n=1;n<=100;n++)
			for(int r=2;r<n-1;r++)
				if(getCombinations(n,r)>1000000)counter++;
		System.out.println("there is "+counter);
	}

	private static double getCombinations(int i, int j) 
	{
		return getFactorial(i)/(getFactorial(j)*(getFactorial(i-j)));
	}

	private static double getFactorial(long factorial) 
	{
		double result=1;
		for(long i=factorial;i>0;i--)
			result*=i;
		return result;
			
	}

}
