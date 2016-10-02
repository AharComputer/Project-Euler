package project_euler;

import java.util.HashSet;

public class PrimeDigitReplacements 
{
	private static int sieveArray(boolean[] arr){
		arr[0]=true;arr[1]=true;
		int c=2;
		for(int j = 4; j < arr.length; j+=2){
			arr[j] = true;
			c++;
		}

		for(int i=3;i<Math.sqrt(arr.length);i+=2){
			if(arr[i]) continue;
			int ii = 2 * i;
			for(int j = i*i; j < arr.length; j+=ii){
				if(arr[j]) continue;
				arr[j] = true;
				c++;
			}
		}
		return arr.length - c;
	}

	private static HashSet<String> convertArr(int n, boolean[] arr2)
	{	
		HashSet<String> arr = new HashSet<String>();
		for(int i=0;i<arr2.length;i++){
			if(!arr2[i])
			{
				arr.add(i+"");
			}
		}
		return arr;
	}

	public static void main (String[] args) 
	{
		long time = System.currentTimeMillis();

		boolean[] primesieve = new boolean[1000000];//000
		int numOfPrimes = sieveArray(primesieve);
		System.out.println("sieveArray time: "+(System.currentTimeMillis() - time));

		//Used HashSet to exploit the log(n) "contains" check speed.
		HashSet<String> primes = convertArr(numOfPrimes, primesieve);
		System.out.println("convertArr time: "+(System.currentTimeMillis() - time));

		primesieve = null;
		System.gc();

		int lfamily = 0;
		String soultion = "9999999999";
		for(String p: primes){//For Each Prime			
			for(int i=0;i<10;i++){//iterate from 0..9
				int family = 1;

				for(int j=1;j<10;j++){//Push 0+1... 0+9 [1..9] 
					char newChar = (char)(48+((i+j)%10));

					boolean found = false;
					StringBuffer check = new StringBuffer();

					for(int k=0;k<p.length();k++){//For Each Character in String
						if(p.charAt(k) == i+48){
							check.append(newChar);
							found = true;
						}else{
							check.append(p.charAt(k));
						}
					}

					if(found && primes.contains(check.toString())){
						family++;
					}
				}

				if(family > lfamily){
					lfamily = family;
					soultion=p;
				}else if(family == lfamily){
					if(p.compareTo(soultion) < 0){
						soultion = p;
					}
				}
			}
		}
		System.out.println("soultion is "+soultion+" len:"+lfamily);
		System.out.println("time: "+(System.currentTimeMillis() - time));
	}
}