package project_euler;
import java.util.ArrayList;
public class CyclicalFigurateNumbers 
{
	/*
Triangle 	  	P3,n=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
Square 	  		P4,n=n^2 	  		1, 4, 9, 16, 25, ...
Pentagonal 	  	P5,n=n(3n-1)/2 	  	1, 5, 12, 22, 35, ...
Hexagonal 	  	P6,n=n(2n-1) 	  	1, 6, 15, 28, 45, ...
Heptagonal 	  	P7,n=n(5n-3)/2 	  	1, 7, 18, 34, 55, ...
Octagonal 	  	P8,n=n(3n-2) 	  	1, 8, 21, 40, 65, ...
	 */
	static ArrayList<Integer> cycle=new ArrayList<Integer>();
	static ArrayList<Integer> triangle=new ArrayList<Integer>();
	static ArrayList<Integer> square=new ArrayList<Integer>();
	static ArrayList<Integer> pentagonal=new ArrayList<Integer>();
	static ArrayList<Integer> hexagonal=new ArrayList<Integer>();
	static ArrayList<Integer> heptagonal=new ArrayList<Integer>();
	static ArrayList<Integer> octagonal=new ArrayList<Integer>();
	static ArrayList<Integer> agonal=new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		for(int i=1000;i<=9999;i++)
		{
			if(isTriangle(i))triangle.add(i);
			if(isSquare(i))square.add(i);
			if(isPentagonal(i))pentagonal.add(i);
			if(isHexagonal(i))hexagonal.add(i);
			if(isHeptagonal(i))heptagonal.add(i);
			if(isOctagonal(i))octagonal.add(i);
		}
		for(int i=0;i<=square.size()-1;i++)
		{
					
		}
		System.out.println(triangle);
		System.out.println(square);
		System.out.println(pentagonal);
		System.out.println(hexagonal);
		System.out.println(heptagonal);
		System.out.println(octagonal);
		System.out.println(isTriangle(3));

	}


	private static boolean isOctagonal(int i) 
	{
		if(Math.sqrt(4+12*i)%6==4)return true;
		return false;
	}

	private static boolean isHeptagonal(int i) 
	{
		if(Math.sqrt(9+40*i)%10==7)return true;
		return false;
	}

	private static boolean isHexagonal(int i) 
	{
		if(Math.sqrt(1+8*i)%4==3)return true;
		return false;
	}

	private static boolean isPentagonal(int i) 
	{
		if(Math.sqrt(1+24*i)%6==5)return true;
		return false;
	}

	private static boolean isSquare(int i) 
	{
		if(Math.sqrt(i)%1==0)return true;
		return false;
	}

	private static boolean isTriangle(int i) 
	{
		if(Math.sqrt(1+8*i)%2==1)return true;
		return false;
	}

}
