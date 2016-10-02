package project_euler;
import java.util.ArrayList;
public class Palindrome_Base10_Base2 
{

	public static void main(String[] args) 
	{
		ArrayList<Long>palindromesBase10=new ArrayList<Long>();
		ArrayList<Long>palindromeBase10And2=new ArrayList<Long>();
		for(long palindrome=1,temp2;palindrome<=1000000;palindrome++)
		{
			temp2=0;
			for(long temp1=palindrome;temp1!=0;temp1/=10) 
				temp2 = temp2 * 10 + temp1 % 10; 

			if (temp2==palindrome)palindromesBase10.add(temp2);
		}
		for(int i=0;i<=palindromesBase10.size()-1;i++)
		{

			if(isPalindromeBase2(palindromesBase10.get(i)))
					palindromeBase10And2.add(palindromesBase10.get(i));
		}
		long sum=0;
		for(int i=0;i<=palindromeBase10And2.size()-1;i++)
			sum+=palindromeBase10And2.get(i);
		System.out.print("The sum of palindromes of base 10 and 2 less than one million is "+sum);
	}
	
	public static String toBase2(long num)
	{
		String temp1="";
		while(num!=0)
		{
			temp1+=num%2;
			num/=2;
		}
		String temp2=temp1,revTemp1="",firstChar="";
		while(temp2.length()!=0)
		{
			firstChar+=temp2.charAt(temp2.length()-1);
			temp2=PandigitalProducts.removeCharAt(temp2,temp2.length()-1);
			revTemp1+=firstChar;
			firstChar="";
		}
		if(revTemp1.charAt(0)=='0')revTemp1=PandigitalProducts.removeCharAt(revTemp1,0);
		return revTemp1;
	}
	public static boolean isPalindromeBase2(long num)
	{
		String palindrome=toBase2(num);
		String temp2=palindrome,revPalin="",firstChar="";
		while(temp2.length()!=0)
		{
			firstChar+=temp2.charAt(temp2.length()-1);
			temp2=PandigitalProducts.removeCharAt(temp2,temp2.length()-1);
			revPalin+=firstChar;
			firstChar="";
		}
		if(revPalin.charAt(0)=='0')revPalin=PandigitalProducts.removeCharAt(revPalin,0);
		if(palindrome.equals(revPalin))return true;
		return false;
	}

}
