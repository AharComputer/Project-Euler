package project_euler;
import java.util.ArrayList;
public class DigitFifthPower 
{
	public static void main(String[] args) 
	{
		long temp1,temp2,sum;
		ArrayList<Long> fifth=new ArrayList<Long>();
		for(long num=2;num<=10000000;num++)
		{
			sum=0;
			for(temp1=num;temp1!=0;temp1/=10)
			{
				temp2=temp1%10;
				sum+=(temp2*temp2*temp2*temp2*temp2);
			}
			if(sum==num)fifth.add(num);
		}
		System.out.print(fifth);
		sum=0;
		for(int i=0;i<fifth.size();i++)sum+=fifth.get(i);
		System.out.print("The sum is "+sum);
		
	}

}
