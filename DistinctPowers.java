package project_euler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class DistinctPowers 
{
	public static void main(String[] args) 
	{
		ArrayList<Double> ab=new ArrayList<Double>();
		for(int a=2;a<=100;a++)
			for(int b=2;b<=100;b++)
			{
				ab.add(Math.pow(a, b));
			}
		Set<Double> fix = new HashSet<>();
		fix.addAll(ab);
		ab.clear();
		ab.addAll(fix);
		System.out.print(ab.size());
	}

}
