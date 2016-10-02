package project_euler;

public class SpiralPrimes 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		long term=1,n=0,prime=0;
		double per=100;
		for(n=1;per>0.1;n++)
		{
			term=term+(2*(((n-1)/4)+1));
			if(QuadraticPrimes.checkPrime(term))
				prime++;

			if(isOddSquare(term))
			{
				per=prime*1.0/n;
				System.out.println("has reached "+per);			
			}
		}
		System.out.println(Math.sqrt(term));

	}

	private static boolean isOddSquare(long term) 
	{
		if(term%2==0)return false;
		if(Math.sqrt(term)%1==0)return true;
		return false;
	}

}
