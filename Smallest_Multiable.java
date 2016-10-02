package project_euler;

public class Smallest_Multiable 
{

	public static void main(String[] args) 
	{
	int i = 20;
	 
	while (i %  2 != 0 || i %  3 != 0 || i %  4 != 0 || i %  5 != 0 ||
	          i %  7 != 0 || i %  9 != 0 ||
	          i % 11 != 0 || i % 12 != 0 || i % 13 != 0 ||
	          i % 16 != 0 || i % 17 != 0 ||
	          i % 19 != 0 || i % 20 != 0) 
	    i += 20;
	System.out.print(i);
	}
}
