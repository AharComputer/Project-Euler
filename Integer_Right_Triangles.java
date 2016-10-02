package project_euler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Integer_Right_Triangles 
{
	static ArrayList<Integer> perimeters=new ArrayList<Integer>();
	static ArrayList<Integer> perimeters1=new ArrayList<Integer>();
	public static void main(String[] args) 
	{
		
		int a=0,b=0,c=0;
		for (c = 1; c <= 1000; ++ c) 
			for (b = 1; b <= 1000; ++ b) 
				for(a=b;a<=1000;++a)
					if(a*a+b*b==c*c&&a+b+c<=1000)perimeters.add(a+b+c);
		while(perimeters.size()!=1)
		{
		removeRepeats();;
		removeIndex();
		}
		System.out.println(perimeters);
	
		
	}
	public static void removeRepeats()
	{
		perimeters1.clear();
		Set<Integer> fix = new HashSet<>();
        fix.addAll(perimeters);
        perimeters1.addAll(fix);
	}
	public static void removeIndex()
	{
		for(int i=perimeters.size()-1;i>=0;i--)
		{
			if(perimeters1.size()==0)
				break;
			for(int j=perimeters1.size()-1;j>=0;j--)
				if(perimeters.get(i)==perimeters1.get(j))
				{
					perimeters.remove(i);
					perimeters1.remove(j);
					i=perimeters.size()-1;
					j=perimeters1.size()-1;
				}
		}
	}

}
