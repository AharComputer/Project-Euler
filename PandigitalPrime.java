package project_euler;
import java.util.ArrayList;
public class PandigitalPrime
{
	//two digit Pandigital removed because % by3
	//three digit pandigital removed because % by3
	//five digit pandigital removed because % by3
	//six digit pandigital removed because % by 3
	//eight digit pandigital removed because % by 3
	//nine digit pandigital removed because % by 3
	public static void main(String[] args) 
	{
		ArrayList<Integer> pandigitalPrime=new ArrayList<Integer>();
		for(int i=1000;i<=9999;i++)
		{
			if(isPandigitalPrime(Integer.toString(i)))
				pandigitalPrime.add(i);
			System.out.println("has procced "+i);
		}
		for(int i=1000000;i<=9999999;i++)
		{
			if(isPandigitalPrime(Integer.toString(i)))pandigitalPrime.add(i);
			System.out.println("has procced "+i);
		}
		System.out.println("there is "+pandigitalPrime.size()+" pandigital primes and they are "+pandigitalPrime);
		System.out.print("The largest one is "+pandigitalPrime.get(pandigitalPrime.size()-1));
	}
	public static boolean isPandigitalPrime(String temp1)
	{
		String temp2=temp1;
		if(CircularPrimes.numberOfDigits(Long.valueOf(temp1))==7)
		{
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('1'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('2'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('3'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('4'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('5'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('6'));
			if(temp1.equals("7")&&QuadraticPrimes.checkPrime(Long.valueOf(temp2)))
				return true;
		}
		else if(CircularPrimes.numberOfDigits(Long.valueOf(temp1))==4)
		{
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('1'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('2'));
			temp1=PandigitalProducts.removeCharAt(temp1,temp1.indexOf('3'));
			if(temp1.equals("4")&&QuadraticPrimes.checkPrime(Long.valueOf(temp2)))
				return true;
		}
		return false;
	}
}
