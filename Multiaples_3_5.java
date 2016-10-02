package project_euler;

public class Multiaples_3_5 
{
	public static void main(String args[])
	{
		int sum=0, i;
		for(i=1;(i<1000);i++)
		{
			if(i%3==0||i%5==0)
			sum+=i;
		
		
		}
		System.out.print(sum);
	}

}
