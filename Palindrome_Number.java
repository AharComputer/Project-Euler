package project_euler;
public class Palindrome_Number 
{

	public static void main(String[] args)
	{
				long product1,product2,max=0,palindrome=99900,temp2=0;
					for (product1 = 100; product1 <= 999; ++ product1) 
					{ 
						for (product2 = product1; product2 <= 999; ++ product2) 
						{

							for(long temp1=palindrome;temp1!=0;temp1/=10) 
								temp2 = temp2 * 10 + temp1 % 10; 
							
							if (temp2==palindrome&&(temp2>=max))max=palindrome;
							temp2=0;palindrome=product1*product2;
						}
					}
	System.out.print(max);
	}		
}


