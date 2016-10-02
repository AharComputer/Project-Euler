package project_euler;
import java.util.ArrayList;
public class Digit_fraction 
{
	public static void main(String[] args) 
	{
		ArrayList<String>digits=new ArrayList<String>();
		for(int i=11;i<100;i++)
			for(int j=11;j<100;j++)
			{
				if(i==j)continue;
			{
				if(checkOneDigit(i,j))
					digits.add(Integer.toString(i)+"/"+Integer.toString(j));
			}
			}
		System.out.print(digits);
	}
	public static boolean checkOneDigit(int i,int j)
	{
		if(i>j)return false;
		String k=Integer.toString(i),h=(Integer.toString(j));
		for(int w=0;w<=k.length()-1;w++)
			for(int f=w;f<=h.length()-1;f++)
				if(k.charAt(w)==h.charAt(f))
				{
					k=PandigitalProducts.removeCharAt(k,w);
					h=PandigitalProducts.removeCharAt(h,f);
					if(Integer.valueOf(h)==0)return false;
					if((Integer.valueOf(k)/(Integer.valueOf(h)*1.0))==(i/j*1.0))return true;
				}
		return false;
	}
	static ArrayList<Integer> divisors=new ArrayList<Integer>();
	static ArrayList<Integer> divisor=new ArrayList<Integer>();
	public static void getDivisors(int num,int num1)
	{
		divisors.clear();
		divisor.clear();
		int i;
		for (i = 1; i <= num; i++) 
			if (num % i == 0)divisors.add(i);
		for (i = 1; i <= num1; i++) 
			if (num1 % i == 0)divisor.add(i);
	}
	public static boolean checkArray()
	{
		for(int i=0;i<=divisors.size()-1;i++)
			for(int j=0;j<=divisor.size()-1;j++)
				if(divisors.get(i)==divisor.get(j)-1)return true;
		return false;
	}
}
