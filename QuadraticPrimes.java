package project_euler;
import java.util.ArrayList;
public class QuadraticPrimes 
{
	/*
	  n^2+an+b, where |a|<1000 and |b|<=1000
	  Find the product of the coefficients, a and b,
	  for the quadratic expression that produces the maximum number of primes for consecutive values of n,
	  starting with n=0.
	 */
	public static void main(String [] args)
	{
		int nMax=0,aMax=0,bMax=0;
		ArrayList<Integer> constant=new ArrayList<Integer>();
		constant.add(2);
		for(int prime=3,divisor;prime<1000;prime+=2)
		{
			for(divisor=2;prime%divisor!=0;divisor++);
			if(prime==divisor)constant.add(prime);
		}
		int n;
		for(int a=-1000;a<=1000;a++)
		{
			for(int i=0;i<=constant.size()-1;i++)
			{
				for(n=0;checkPrime(n*n+a*n+constant.get(i));n++);
				System.out.printf("The quadratic: n^2+%dn+%d has %d primes \n",a,constant.get(i),n);
				if(n>nMax)
				{
					nMax=n;
					aMax=a;
					bMax=constant.get(i);
				}
			}
		}
		System.out.printf("The quadratic: n^2+%dn+%d has the highest amount of primes with %d primes \n The product of its coefficients is %d",aMax,bMax,nMax,aMax*bMax);
	}
	public static boolean checkPrime(long prime)
	{
		long divisor;
		if(prime==2||prime==3)return true;
		if(prime%6==1||prime%6==5)
		{
		for(divisor=2;divisor<=Math.sqrt(prime)&&prime%divisor!=0;divisor++);
		if (divisor>Math.sqrt(prime))return true;
		}
		return false;
	}
}