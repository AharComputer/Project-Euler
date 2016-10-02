package project_euler;

public class Lattice_paths 
{
//the lattice can can be determined using M+k binomialCoefficient k from point(0,0) to the point wanted
	private static void getBinomial(int n, int r)
    {
        if (r>n-r)
            r=n-r;
 
        long b=1;
        for (int i=1, m=n; i<=r; i++, m--)
            b=b*m/i;
        System.out.print(b);
        
    }
	public static void main(String[] args) 
	{
		getBinomial(40,20);
	}
}
