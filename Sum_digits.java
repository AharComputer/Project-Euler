package project_euler;
import java.math.*;
public class Sum_digits
{
	public static void main(String[] args) {
		int sum =0;
		int digit;
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("2");
		for(int i = 1 ; i <= 1000 ; i++ )
		{
			a = a.multiply(b);
		}
		String A = a.toString();

		for(int i =0 ; i < A.length();i++)
		{
			digit = A.charAt(i) - '0'; 
			sum = sum + digit;
		}
		System.out.println(sum);
	}
}
