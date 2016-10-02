package project_euler;

import java.util.ArrayList;

public class PermutedMultiples 
{
	public static void main(String[] args) 
	{
		ArrayList<Long> PermutedMultiples=new ArrayList<Long>();
		for(long i=1;i<=1000000;i++)
		{
			if(sameCharsForFirstSixMultiaples(i))
				PermutedMultiples.add(i);
			System.out.println(" has procced "+ i);
		}
		System.out.println(PermutedMultiples);
	}
	private static boolean sameCharsForFirstSixMultiaples(long i) 
	{
		if(getDigitLength(i)==getDigitLength(i*6))
		{
			if(getSumDigits(i)==getSumDigits(i*2)&&getSumDigits(i)==getSumDigits(i*3)&&getSumDigits(i)==getSumDigits(i*4)&&getSumDigits(i)==getSumDigits(i*5)&&getSumDigits(i)==getSumDigits(i*6))
			{
				if(getProductDigits(i)==getProductDigits(i*2)&&getProductDigits(i)==getProductDigits(i*3)&&getProductDigits(i)==getProductDigits(i*4)&&getProductDigits(i)==getProductDigits(i*5)&&getProductDigits(i)==getProductDigits(i*6))
				{
					if(getMaxDigit(i)==getMaxDigit(i*2)&&getMaxDigit(i)==getMaxDigit(i*3)&&getMaxDigit(i)==getMaxDigit(i*4)&&getMaxDigit(i)==getMaxDigit(i*5)&&getMaxDigit(i)==getMaxDigit(i*6))
					{
						if(getMinDigit(i)==getMinDigit(i*2)&&getMinDigit(i)==getMinDigit(i*3)&&getMinDigit(i)==getMinDigit(i*4)&&getMinDigit(i)==getMinDigit(i*5)&&getMinDigit(i)==getMinDigit(i*6))
						{
							if(getSumDigitRemainder9(i)==getSumDigitRemainder9(i*2)&&getSumDigitRemainder9(i)==getSumDigitRemainder9(i*3)&&getSumDigitRemainder9(i)==getSumDigitRemainder9(i*4)&&getSumDigitRemainder9(i)==getSumDigitRemainder9(i*5)&&getSumDigitRemainder9(i)==getSumDigitRemainder9(i*6))
							{
								if(getSumDigitRemainder8(i)==getSumDigitRemainder8(i*2)&&getSumDigitRemainder8(i)==getSumDigitRemainder8(i*3)&&getSumDigitRemainder8(i)==getSumDigitRemainder8(i*4)&&getSumDigitRemainder8(i)==getSumDigitRemainder8(i*5)&&getSumDigitRemainder8(i)==getSumDigitRemainder8(i*6))
								{
									if(getSumDigitRemainder7(i)==getSumDigitRemainder7(i*2)&&getSumDigitRemainder7(i)==getSumDigitRemainder7(i*3)&&getSumDigitRemainder7(i)==getSumDigitRemainder7(i*4)&&getSumDigitRemainder7(i)==getSumDigitRemainder7(i*5)&&getSumDigitRemainder7(i)==getSumDigitRemainder7(i*6))
									{
									return true;
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	private static long getSumDigitRemainder7(long i) 
	{
		long sum=0;
		while(i!=0)
		{
			sum+=i%10%4;
			i/=10;
		}
		return sum;
		
	}
	private static long getSumDigitRemainder8(long i) 
	{
		long sum=0;
		while(i!=0)
		{
			sum+=i%10%3;
			i/=10;
		}
		return sum;
	}
	private static long getSumDigitRemainder9(long i) 
	{
		long sum=0;
		while(i!=0)
		{
			sum+=i%10%9;
			i/=10;
		}
		return sum;
	}
	private static long getMinDigit(long i) 
	{
		long min=9;
		while(i!=0)
		{
			if(min>i%10)
				min=i%10;
			i/=10;
		}
		return min;
	}
	private static long getMaxDigit(long i) 
	{
		long max=0;
		while(i!=0)
		{
			if(max<i%10)
				max=i%10;
			i/=10;
		}
		return max;

	}
	private static long getProductDigits(long i) 
	{
		long product=0;
		while(i!=0)
		{
			product+=i%10;
			i/=10;
		}
		return product;
	}
	private static long getSumDigits(long i) 
	{
		long sum=0;
		while(i!=0)
		{
			sum+=i%10;
			i/=10;
		}
		return sum;
	}
	private static long getDigitLength(long i) 
	{
		long digitLength=0;
		while(i!=0)
		{
			i/=10;
			digitLength++;
		}
		return digitLength;
	}


}
