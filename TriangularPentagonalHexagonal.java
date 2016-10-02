package project_euler;

public class TriangularPentagonalHexagonal 
{
	//every hexagonal(6sides) number is a  tringular number (3sides) the second if we start the tringular set at 3
	public static void main(String[] args) 
	{
		long result = 0;
		int i = 144;

		for(;!isPentagonal(result);i++)
			result = i * (2 * i - 1);
		System.out.println("The next number that tringular and hexagonal and pentagonal is "+result +" It is the "+i+" hexagonal number"+" and the "+(i*2-1)+" triangular number");
	}

	public static boolean isPentagonal(long result) 
	{
		if(Math.sqrt(1+24*result)%6==5)return true;
		return false;
	}

}
