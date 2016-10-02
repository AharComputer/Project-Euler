package project_euler;
import java.util.ArrayList;
public class CircularPrimes 
{
	

	public static void main(String[] args)  
	{
		ArrayList<Long> circularPrimes=new ArrayList<Long>();
		for(long i=1;i<=1000000;i++)
		{
			if(isCircularPrimes(i))
				circularPrimes.add(i);
			System.out.println("has procced "+i);
		}
		System.out.print("The circular primes are "+circularPrimes+" and there is "+circularPrimes.size());
			
	} 
	public static boolean isCircularPrimes(long num)
	{
		String prime=Long.toString(num);
		String firstChar="";
		int i;
		for(i=1;i<=numberOfDigits(num);i++)
		{
			firstChar+=prime.charAt(0);
			prime=PandigitalProducts.removeCharAt(prime,0).concat(firstChar);
			firstChar="";
			if(!QuadraticPrimes.checkPrime(Integer.valueOf(prime)))break;
		}
		if(i==numberOfDigits(num)+1)return true;
		return false;
	}
	public static int numberOfDigits(long n)
	{
		int numberOfDigits=0;
		while(n>0)
		{
			n/=10;
			numberOfDigits++;
		}
		return numberOfDigits;
	}
}


