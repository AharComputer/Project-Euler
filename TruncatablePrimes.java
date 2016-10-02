package project_euler;

import java.util.ArrayList;

public class TruncatablePrimes 
{
	static ArrayList<Integer> primes=new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		ArrayList<Integer> truncPrime=new ArrayList<Integer>();
		for(int i=2;i<1000000;i++)
		{
			if(QuadraticPrimes.checkPrime(i))primes.add(i);
			System.out.println("has procced "+i);
		}
		for(int i=4;i<primes.size()-1;i++)
		{
			if(isTrunPrime(primes.get(i)))truncPrime.add(primes.get(i));
		}
		int sum=0;
		for(int i=0;i<=truncPrime.size()-1;i++)
			sum+=truncPrime.get(i);
		System.out.print("there are 11 truncPrimes which are ");
		System.out.print(truncPrime);
		System.out.print(" and there sum is "+sum);

	}
	public static boolean isTrunPrime(int num)
	{
		String prime=Long.toString(num),temp1=prime,temp2=prime;
		while(temp1.length()!=0)
		{
			if(!primes.contains(Integer.valueOf(temp1)))return false;
			temp1=PandigitalProducts.removeCharAt(temp1,0);
		}
		while(temp2.length()!=0)
		{
			if(!primes.contains(Integer.valueOf(temp2)))return false;
			temp2=PandigitalProducts.removeCharAt(temp2,temp2.length()-1);
		}
		return true;
	}

}
