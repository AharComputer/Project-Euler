package project_euler;
import java.util.ArrayList;
public class DistinctPrimes 
{
	static ArrayList<Integer> primes=new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		for(int i=2;i<=10000;i++)
			if(QuadraticPrimes.checkPrime(i))
				primes.add(i);
		
		for(int i=2;;i++)
			if(getDistinictPrimesNumber(i)==4&&getDistinictPrimesNumber(i+1)==4&&getDistinictPrimesNumber(i+2)==4&&getDistinictPrimesNumber(i+3)==4)
			{
				System.out.print("The number "+i+" and " +(i+1)+" and "+(i+2)+" and"+(i+3)+"have 4 distinct prime divisors and are the smallest adjacent numbers to do that");
				break;
			}
	}

	public static long getDistinictPrimesNumber(int num) 
	{
		int distinictPrimes=0;
		for(int i=0;i<=primes.size()-1;i++)
		{
			if(num%primes.get(i)==0)
			{
				num/=primes.get(i);
				while(num%primes.get(i)==0)
					num/=primes.get(i);
				distinictPrimes++;
			}
		}
		return distinictPrimes;
	}
}
