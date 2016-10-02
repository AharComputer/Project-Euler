package project_euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/*

It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class GoldbachsOtherConjecture 
{
	public static void main(String[] args) 
	{
		ArrayList<Long> primes=new ArrayList<Long>();
		ArrayList<Long> squares=new ArrayList<Long>();
		ArrayList<Long> postiveComposites=new ArrayList<Long>();
		ArrayList<Long> negativeComposites=new ArrayList<Long>();
		for(Long i=2l;i<1000000;i++)
		{
			if(QuadraticPrimes.checkPrime(i))
			{
				primes.add(i);
			System.out.println("has added "+i+" to primes");
			}
		}
		for(long i=1;i<10000;i++)
		{
			squares.add(i*i);
			System.out.println("has addded the square "+i*i+" to squares");
		}
		for(Long i=0l;i<=1000000;i++)
		{
			if(isOddComposite(i))
			{
				for(int x=0;x<=primes.size()-1;x++)
				{
					if(primes.get(x)>=i)break;
					for(int y=0;y<=squares.size()-1;y++)
					{
						if(squares.get(y)*2>=i)break;
						if(primes.get(x)+squares.get(y)*2==i)
						{
							System.out.println(primes.get(x)+"+"+squares.get(y)*2+"= "+i);
							postiveComposites.add(i);
						}
					}
				}
			}
		}
		Set<Long> fix = new HashSet<>();
        fix.addAll(postiveComposites);
        postiveComposites.clear();
        postiveComposites.addAll(fix);
        Collections.sort(postiveComposites);
        System.out.println("Composites from 1-10000 that satisfies goldbachs conjecture are "+postiveComposites);
        for(long i=2;i<=100000;i++)
        	if(isOddComposite(i)&&!postiveComposites.contains(i))
        		negativeComposites.add(i);
        		
        	
		System.out.print("Odd Composites that do not satisfiy goldbach conjucture are "+negativeComposites);
	}

	public static boolean isOddComposite(long num) 
	{
		if(num%2==0)return false;
		return !QuadraticPrimes.checkPrime(num);
	}


}
