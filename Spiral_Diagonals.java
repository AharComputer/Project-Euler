package project_euler;
import java.util.ArrayList;
public class Spiral_Diagonals 
{

	public static void main(String[] args)
	{
		int term=1;
		ArrayList<Integer> spiralDiagonals=new ArrayList<Integer>();
		for(int n=1;term<=1001*1001;n++)
		{
			spiralDiagonals.add(term);
			term=term+(2*(((n-1)/4)+1));
		}
		System.out.println(spiralDiagonals);
		int sum=0;
		for(int i=0;i<=spiralDiagonals.size()-1;i++)sum+=spiralDiagonals.get(i);
		System.out.print(sum);
	}

}
