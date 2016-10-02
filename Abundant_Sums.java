package project_euler;

import java.util.ArrayList;

public class Abundant_Sums {


	public static void main(String[] args) 
	{

		ArrayList <Integer> AbundantStore = new ArrayList<Integer>();
		for( int i =12 ; i <= 28123; i++ )
		{
			if(abundant_Checker(i))
			{
				AbundantStore.add(i);
			}
		}

		boolean  nonAbundantNumberMark[] = new boolean[28124];
		for(int i = 0 ; i < AbundantStore.size(); i++)
		{
			for(int j= i; j < AbundantStore.size(); j++)
			{ 
				int abundantNumberSum = (AbundantStore.get(i)+AbundantStore.get(j));
				if(abundantNumberSum <= 28123)
					nonAbundantNumberMark[abundantNumberSum] = true;
			}
		}

		int nonAbundantNumberSum = 0;
		for( int i = 0 ; i <= 28123; i++ )
		{ if(!nonAbundantNumberMark[i])
		{
			nonAbundantNumberSum += i;
		}

		}
		System.out.println(nonAbundantNumberSum);
	}




	public static boolean abundant_Checker(int num)
	{
		if(sum_of_factor(num)> num)
			return true;
		else
			return false;
	}




	public static int sum_of_factor(int num)
	{
		int sum =0;
		for(int i= 1 ; i<=num/2 ; i++ )
		{
			if(num%i ==0)
				sum +=i;
		}

		return sum;
	}

}


