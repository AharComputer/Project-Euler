package project_euler;
import java.math.BigInteger;
public class SquareRootConvergents
{

	public static void main(String[] args) 
	{
		BigInteger num=new BigInteger("3");
		BigInteger den=new BigInteger("2");
		BigInteger two=new BigInteger("2");
		int counter=0;
		for(int i=1;i<=1000;i++)
		{
			num=(den.multiply(two)).add(num);
			den=num.subtract(den);
			if(getLength(num).compareTo(getLength(den))==1)
				counter++;
		}
		System.out.println(counter);
		

	}

	private static BigInteger getLength(BigInteger num) 
	{
		BigInteger length=new BigInteger("0");
		BigInteger zero=new BigInteger("0");
		BigInteger one=new BigInteger("1");
		BigInteger ten=new BigInteger("10");
		while(!num.equals(zero))
		{
			num=num.divide(ten);
			length=length.add(one);
		}
			
		return length;
	}

}
