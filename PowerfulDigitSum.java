package project_euler;

import java.math.BigInteger;

public class PowerfulDigitSum 
{
	public static void main(String[]args)
	{
		BigInteger a=new BigInteger("1");
		BigInteger one=new BigInteger("1");
		BigInteger hundred=new BigInteger("99");

		long max=0;
		for(int i=1;i<=100;i++)
		{
			if(getDigitSum(a.pow(i))>max)
				max=getDigitSum(a.pow(i));
			if(a.equals(hundred)&&i==99)
				break;
			if(i==99)
			{
				a=a.add(one);
				i=1;
			}
		}
		System.out.println(max);
	}

	private static long getDigitSum(BigInteger pow) 
	{
		BigInteger zero=new BigInteger("0");
		BigInteger ten=new BigInteger("10");
		BigInteger digit=new BigInteger("0");
		long sum=0;
		while(!pow.equals(zero))
		{
			digit=pow.remainder(ten);
			sum+=digit.longValueExact();
			pow=pow.divide(ten);
		}
		return sum;
	}

}
