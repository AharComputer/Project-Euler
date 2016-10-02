package project_euler;

import java.util.ArrayList;


public class ConsecutivePrimeSum 
{
	public static void main(String[] args) 
	{
		ArrayList<Long> primes=new ArrayList<Long>();
		for(long i=2;i<=1000000;i++)
		{
			if(QuadraticPrimes.checkPrime(i))
				primes.add(i);
			System.out.println("has procced "+i);
		}
		long sum=0,counter=0,sumMax=0,counterMax=0;
		int j=0;
		for(int i=0 ;i<=primes.size()-1;i++)
		{
			sum+=primes.get(i);
			counter++;
			if(primes.contains(sum)&&primes.get(i)!=sum)
			{
				System.out.println("found "+counter+" consective prime sum");
				if(counterMax<counter)
				{
					counterMax=counter;
					sumMax=sum;
				}
			}
			if(counterMax>primes.size()-1-i)break;
			if(i==primes.size()-1&&j!=primes.size()-1||sum>=1000000)
			{  
				j++;
				i=j;
				sum=0;
				counter=0;
			}

		}
		System.out.println("the highest consective sum was "+sumMax+" with "+counterMax+" terms");
	}

}
