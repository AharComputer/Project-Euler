package project_euler;

import java.util.ArrayList;

public class PrimePermutations 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> primes=new ArrayList<Integer>();
		for(int i=1000;i<=9999;i++)
			if(QuadraticPrimes.checkPrime(i))
			primes.add(i);
		for(int i=0;i<=primes.size()-1;i++)
		{
			for(int j=1;j<=4000;j++)
			{
				if(primes.contains(primes.get(i)+j)&&primes.contains(primes.get(i)+j*2)&&haveSameDigits(Integer.toString(primes.get(i)),Integer.toString(primes.get(i)+j),Integer.toString(primes.get(i)+j*2)))
						System.out.println(primes.get(i)+""+(primes.get(i)+j)+""+(primes.get(i)+j*2));
			}
		}

	}

	public static boolean haveSameDigits(String temp, String temp1, String temp2) 
	{
		temp1=PandigitalProducts.removeCharAt(temp1, temp1.indexOf(temp.charAt(0)));
		temp1=PandigitalProducts.removeCharAt(temp1, temp1.indexOf(temp.charAt(1)));
		temp1=PandigitalProducts.removeCharAt(temp1, temp1.indexOf(temp.charAt(2)));
		temp2=PandigitalProducts.removeCharAt(temp2, temp2.indexOf(temp.charAt(0)));
		temp2=PandigitalProducts.removeCharAt(temp2, temp2.indexOf(temp.charAt(1)));
		temp2=PandigitalProducts.removeCharAt(temp2, temp2.indexOf(temp.charAt(2)));
		temp=PandigitalProducts.removeCharAt(temp, temp.indexOf(temp.charAt(0)));
		temp=PandigitalProducts.removeCharAt(temp, temp.indexOf(temp.charAt(0)));
		temp=PandigitalProducts.removeCharAt(temp, temp.indexOf(temp.charAt(0)));
		if(temp.equals(temp1)&&temp1.equals(temp2))return true;
		
		
		return false;
	}


}
