package project_euler;
public class First_Fabonnaci_number_with_four_digit 
{
	public static void main(String[] args)
	{
	   double x1=(int)1,x2=(int)2;
	   long counter=2;
	    while(true)
		{
			if(x1/Math.pow(10, 4)>=1)break;
			x1+=x2;
			counter++;
			System.out.println("\nhas prossed :"+x1);
			if(x2/Math.pow(10, 4)>=1)break;
			x2+=x1;
			counter++;
			System.out.println("\nhas prossed :"+x2);
		}
		System.out.print(counter);
	}
}
