package project_euler;

public class Special_Pythagorean_triplet 
{

	public static void main(String[] args) 
	{
		int a=0,b=0,c=0;
		for (c = 1; c <= 1000; ++ c) 
		{ 
			for (b = 1; b <= 1000; ++ b) 
			{
				for(a=1;a<=1000;++a)
				{
					if(a*a+b*b==c*c)
					{
						System.out.printf(" %d,%d,%d is a phythagreon triplet", a,b,c);
						System.out.printf((a+b+c==1000)?" the one your looking for is this one and the answer is %d \n":"\n",a*b*c);
					}
				}
			}
		}
	}


}


