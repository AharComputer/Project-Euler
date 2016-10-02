package project_euler;
/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-String panDivisibility property.
Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
	d1=remaining to make pandigital
    d2d3d4=406 is Divisible by 2 8-d4 is div by 2
    d3d4d5=063 is Divisible by 3 9-given d5=3 or 9 and d4 is div by 2 {231,234,237,291,294,297,309,432,435,438,492,495,498,603,630,633,636,639,690,693,696,699,831,834,837,891,894,897}we can remove repeated{231,234,237,291,294,297,432,435,438,492,495,498,630,639,690,693,831,834,837,891,894,897}
    d4d5d6=635 is Divisible by 5 1-d6 must be 0 or 5 3-d6 is 5 9- given d5 and d6 are {03,09,35,95} we are left with{309,435,495,603} therefore 
    d5d6d7=357 is Divisible by 7 7-there are no number less than 1000 and divisiable by 7 and pandigital given that d6 d7 are 52 or 53 or 57 but 357 and 952 so d5d6d7d8d9{357289,952867}
    d6d7d8=572 is Divisible by 11 2-d6 can`t be 0 because every number less than 132 that is div by 11 is not pandigital 4- d6d7d8 are {506,517,528,539,561,572,583,594}
    d7d8d9=728 is Divisible by 13 5- there is no number less than 1000 and divisiable by 13 and pandigital that has the starting  06 or 17 or 61 or 94 ,so d6d7d8d9{5286,5390,5728,5832}
    d8d9d10=289 is Divisible by 17 6-there are no number less than 1000 and divisiable by 17 and pandigital , but {867,901,289} ,so d6d7d8d9d10 {52867,53901,57289}

Find the sum of all 0 to 9 pandigital numbers with this property.
by hand
 */
public class SubStringDivisibility 
{

	public static void main(String[] args) 
	{
		int i=102;
		while(i<=999)
		{
			i++;
			if(i%3==0)
				System.out.print(i+" ");
		}
		System.out.println(1430952867l +  1460357289l +  1406357289l + 4130952867l + 4160357289l +4106357289l);
	}

}
