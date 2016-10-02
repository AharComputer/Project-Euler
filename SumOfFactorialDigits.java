package project_euler;
import java.util.ArrayList;
public class SumOfFactorialDigits {

	public static void main(String[] args) 
	{
		ArrayList<Long> factorialSums=new ArrayList<Long>();
		for(long i=3;i<=3628800;i++)
		{
			if(isSumDigitFactorial(i))
				factorialSums.add(i);
			System.out.println("has procced "+i);
		}
		System.out.print(factorialSums);



	}
	public static long getFactorial(long i)
	{
		if(i==0)return 1;
		for(long n =i-1;n>1;n--)i*=n;
		return i;

	}
	public static boolean isSumDigitFactorial(long num) 
	{
		long temp1=num,temp2=0;
		while(temp1!=0)
		{
			temp2+=getFactorial(temp1%10);
			temp1/=10;
		}
		if(num==temp2)return true;
		return false;
	}

}
