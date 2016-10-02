package project_euler;

import java.util.ArrayList;

public class Amicable_Pairs {

	public static void main(String[] args) 
	{
		int num=0,sum=0,sum1=0;
		ArrayList<Integer> amicable=new ArrayList<Integer>();
		for(;num<10000;num++,sum=0,sum1=0)
		{
			for (int i = 1; i < num; i++) 
				if (num % i == 0)sum+=i;			
			for (int i = 1; i < sum; i++) 
				if (sum % i == 0)sum1+=i;
			boolean contains =amicable.contains(num)&&amicable.contains(sum1);
			if(!(sum1==sum)&&num==sum1&& !(contains))
			{
				amicable.add(num);
				amicable.add(sum);
			}
		}
		System.out.println(amicable);
		System.out.print(amicable.stream().mapToInt(Integer::intValue).sum());
	}

}
