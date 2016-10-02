package project_euler;
public class Prime_10001st 
{
	public static void main(String[] args) 
	{
		long start=System.currentTimeMillis();

		long amount=0,prime=2,divisor,number=12;
		for(;amount!=number;prime++)	
		{
			for(divisor=2;prime>divisor/2&&prime%divisor!=0;divisor++);
			if (prime==divisor)
			{
				amount++;
				System.out.println("Has prossed prime "+prime);
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("Time for execution="+(end-start)+"ms");
	}
}
