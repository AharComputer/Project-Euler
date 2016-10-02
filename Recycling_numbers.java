package project_euler;

public class Recycling_numbers 
{
	public static int getLCM(int a,int b)
	{
	    int i =(a>b)?a:b;
		for(;;i++)
			if(i%a==0&&i%b==0)
				return i;
	}

	public static void main(String[] args) 
	{
		int sequenceNumber = 0,i=1000;
		 
		for (; i > 1; i--) {
		    if (sequenceNumber >= i) {
		        break;
		    }
		 
		    int[] foundRemainders = new int[i];
		    int value = 1;
		    int where = 0;
		 
		    while (foundRemainders[value] == 0 && value != 0) {
		        foundRemainders[value] = where;
		        value *= 10;
		        value %= i;
		        where++;
		    }
		 
		    if (where - foundRemainders[value] > sequenceNumber) {
		        sequenceNumber = where - foundRemainders[value];
		    }
		}
		System.out.print(i+1);

	}

}
