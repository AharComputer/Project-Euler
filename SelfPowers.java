package project_euler;
import java.math.BigInteger;
public class SelfPowers 
{
	public static void main(String[] args) 
	{
		BigInteger selfPower=new BigInteger("0");
		BigInteger sum=new BigInteger("0");
		BigInteger one=new BigInteger("1");
		for(int i=1;i<=1000;i++)
		{
			selfPower=selfPower.add(one);
			sum = sum.add(selfPower.pow(i));
		}
		System.out.print(sum);
	}
}
