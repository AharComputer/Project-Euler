package project_euler;

public class Prime_Sum 
{

	    static void findSum()
	    {
	        long i=3;
	        long sum=0;
	        int count=0;
	        boolean[] array = new boolean[2000000];
	        for(long j=0;j<array.length;j++)
	        {
	         if((j&1)==0)
	          array[(int)j]=false;   
	         else    
	         array[(int)j]=true;
	        }
	        array[1]=false;
	        array[2]=true;
	        for(;i<2000000;i+=2)
	        { 
	            if(array[(int)i] & isPrime(i))
	            {   
	                array[(int)i]=true;
	                for(long j=i+i;j<array.length;j+=i)array[(int)j]=false;
	            }
	        }
	        for(int j=0;j<array.length;j++)
	        {
	            if(array[j])
	            {   
	             count++;   
	             sum+=j;
	            }
	        }   
	        System.out.println("Sum="+sum +" Count="+count);
	    }
	    public static boolean isPrime(long num)
	    {
	        boolean flag=false;
	        long i=3;
	        long limit=(long)Math.sqrt(num);
	        for(;i<limit && !(flag);i+=2)
	        {
	            if(num%i==0)
	            {
	                flag=false;
	                break;
	            }   
	        }
	        if(i>=limit)
	         flag=true;
	        return flag;
	    }

	    public static void main(String args[])
	    {
	        long start=System.currentTimeMillis();
	        findSum();
	        long end=System.currentTimeMillis();
	        System.out.println("Time for execution="+(end-start)+"ms");
	    }

	}



