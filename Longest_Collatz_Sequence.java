package project_euler;

public class Longest_Collatz_Sequence 
{
	public static void main(String[] args) 
	{
        long start=System.currentTimeMillis();
		long steps=0,maxSteps=0,n=0,maxNumber=0;
		for(long number=2;number<=1000000;number++,steps=0)
		{
			
			n=number;
			while(n!=1)
			{
				if (n%2==0)
				{
					n/=2;steps++;
				}
				else
				{
					n=(3*n+1)/2;steps+=2;
				}

			}
			if(steps>maxSteps)
			{
				maxNumber=number;
				maxSteps=steps;
			}
			System.out.print("has prossed number :"+number+"\n");
		}
		System.out.println("the highest number is :"+maxNumber+" and it took "+maxSteps+" steps");
        long end=System.currentTimeMillis();
        System.out.println("Time for execution="+(end-start)+"ms");
	}
}
