package project_euler;

public class Fibonnaci_Even 
{

	public static void main(String[] args) 
	{
		int x1=1,x2=2,sum=x2;
	
		while(true)
		{
			x1+=x2;
			if (x1>=4000000)break;
			else if(x1%2==0) sum+=x1;
			System.out.print(x1+",");

			x2+=x1;
			if (x2>=4000000)break;
			else if (x2%2==0) sum+=x2;
			System.out.print(x2+",");
		}
		System.out.print("\n"+sum);

	}

}
