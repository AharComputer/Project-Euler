package project_euler;

public class ChampernownesConstants 
{

	public static void main(String[] args)
	{
		String champernownesConstant="";
		for(int i=1;champernownesConstant.length()<=1000002;i++)
			{
			champernownesConstant+=i;
			System.out.println("has reached "+champernownesConstant.length());
			}
		System.out.println(champernownesConstant.charAt(0));
		System.out.println(champernownesConstant.charAt(9));
		System.out.println(champernownesConstant.charAt(99));
		System.out.println(champernownesConstant.charAt(999));
		System.out.println(champernownesConstant.charAt(9999));
		System.out.println(champernownesConstant.charAt(99999));
		System.out.println(champernownesConstant.charAt(999999));
	
	}

}
