package project_euler;

import java.math.BigInteger;
import java.util.ArrayList;

//for a number written as [a0;a1,a2,a3,a4,...,an]
//the divergence will be  written as h(n)=(a(n)h(n-1)+h(n-2))/(a(n)k(n)-1+k(n-2))
//the numerator =a(n)h(n-1)+h(n-2)
//the denomenator will be (a(n)k(n-1)-1+k(n-2))
public class EulerConstant {
/*
 * 

The square root of 2 can be written as an infinite continued fraction.
The infinite continued fraction can be written, sqrt.2 = [1;(2)], (2) indicates that 2 repeats ad infinitum. In a similar way, sqrt23 = [4;(1,3,1,8)].
It turns out that the sequence of partial values of continued fractions for square roots provide the best rational approximations. Let us consider the convergents for sqrt2.
Hence the sequence of the first ten convergents for sqrt2 are:
1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
What is most surprising is that the important mathematical constant,
e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].

The first ten terms in the sequence of convergents for e are:
2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...

The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.

Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.

 */
	public static void main(String[] args) 
	{
		BigInteger TWO=new BigInteger("2");
		BigInteger ONE=new BigInteger("1");
		BigInteger k=new BigInteger("1");
		ArrayList<BigInteger>a=new ArrayList<BigInteger>();
		a.add(TWO);
		for(int i=0;i<=100;i++)
		{
			if(i%3==1)
			{
				a.add(TWO.multiply(k));
				k=k.add(ONE);
			}
			else
			a.add(ONE);
		}
		ArrayList<BigInteger>num=new ArrayList<BigInteger>();
		num.add(TWO);
		num.add(TWO.add(ONE));
		for(int n=2;n<=99;n++)
			num.add(((a.get(n).multiply(num.get(n-1)))).add(num.get(n-2)));
		/*
		ArrayList<Integer>den=new ArrayList<Integer>();
		den.add(1);
		den.add(1);
		for(int n=2;n<=100;n++)
			den.add(a.get(n)*den.get(n-1)+den.get(n-2));
			*/
		System.out.println(a);
		System.out.println(num);
		// h(n)=(a(n)h(n-1)+h(n-2))/(a(n)k(n)-1+k(n-2))
		System.out.println(getSum(num.get(num.size()-1)));
		
	}

private static BigInteger getSum(BigInteger bigInteger) 
{
	BigInteger TEN=new BigInteger("10");
	BigInteger ZERO=new BigInteger("0");
	BigInteger sum=new BigInteger("0");
	while(!bigInteger.equals(ZERO))
	{
		sum=sum.add(bigInteger.remainder(TEN));
		bigInteger=bigInteger.divide(TEN);
	}
	
	return sum;
}

}
