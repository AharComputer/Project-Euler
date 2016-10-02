package project_euler;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class PokerHands 
{
	/*
    High Card: Highest value card..*
    One Pair: Two cards of the same value.
    Two Pairs: Two different pairs..*
    Three of a Kind: Three cards of the same value..*
    Straight: All cards are consecutive values...*
    Flush: All cards of the same suit..*
    Full House: Three of a kind and a pair..*
    Four of a Kind: Four cards of the same value..*
    Straight Flush: All cards are consecutive values of same suit..*
    Royal Flush: Ten, Jack, Queen, King, Ace, in same suit..*
	 */
	static ArrayList<String> playerOneHand=new ArrayList<String>();
	static ArrayList<String> playerTwoHand=new ArrayList<String>();
	private String path;
	public PokerHands (String file_path)
	{
		path=file_path;
	}
	public String[ ] OpenFile() throws IOException
	{
		FileReader fr=new FileReader(path);
		BufferedReader textReader= new BufferedReader(fr);


		int numberOfLines = readLines();
		String[ ] textData = new String[numberOfLines];


		int i;

		for (i=0; i < numberOfLines; i++) 
			textData[ i ] = textReader.readLine();

		textReader.close( );
		return textData;


	}
	int readLines() throws IOException 
	{
		FileReader file_to_read=new FileReader(path);
		BufferedReader bf=new BufferedReader (file_to_read);
		String aLine;

		int numberOfLines=0;

		while((aLine=bf.readLine())!=null)
		{
			numberOfLines++;
		}
		bf.close();
		return numberOfLines;
	}


	public static void main(String[] args)  throws IOException
	{
		String file_name="C:/Users/FREE USER/Desktop/p054_poker.txt";
		PokerHands file = new PokerHands( file_name );
		String[ ] aryLines = file.OpenFile( );
		int i;
		for(i=0;i<aryLines.length;i++)
			sepratePlayers(aryLines[i]);
		System.out.println(playerOneHand);
		System.out.println(playerTwoHand);
		int playerOne=0;
		String winner="";
		for(i=0;i<aryLines.length;i++)
		{
			winner=determineWinner(i);
			System.out.println("the winner of round "+(i+1)+" is "+winner);
			if(winner.equalsIgnoreCase("playerOne"))playerOne++;
		}
		playerOne-=44;
		System.out.println(" player one won "+playerOne);
	}





	private static String determineWinner(int i) 
	{
		String temp1=playerOneHand.get(i);
		String temp2=playerTwoHand.get(i);
		String temp1Value="";
		String temp2Value="";
		String firstChar="";
		String lastChar="";
		long temp1intValue=0;
		long temp2intValue=0;
		if(isSamesuit(temp1));
		{
			if(isConsecutive(temp1)!=null)
			{
				temp1Value+="Straight"+isConsecutive(temp1);
			}
			temp1Value+="Flush";
		}
		if(isConsecutive(temp1)!=null)temp1Value+="Straight"+isConsecutive(temp1);
		else
			temp1Value=havePair(temp1);


		if(temp1Value.equals("Royal"))
			return "playerOne";
		else if(temp1Value.contains("Straight")&&temp1Value.contains("Flush"))
			temp1intValue+=100000000;
		else if(temp1Value.contains("FourOfKind"))
			temp1intValue+=10000000;
		else if(isFullHouse(temp1Value))
			temp1intValue+=1000000;
		else if(temp1Value.equals("Flush"))
			temp1intValue+=100000;
		else if(temp1Value.contains("Straight"))
			temp1intValue+=10000;
		else if(temp1Value.contains("ThreeOfKind"))
			temp1intValue+=1000;
		else if(isTwoPairs(temp1Value))
			temp1intValue+=100;
		else if(temp1Value.contains("OnePair"))
			temp1intValue+=10;





		if(isSamesuit(temp2));
		{
			if(isConsecutive(temp2)!=null)
			{
				temp2Value+="Straight"+isConsecutive(temp2);
			}
			temp2Value+="Flush";
		}
		if(isConsecutive(temp2)!=null)temp2Value+="Straight"+isConsecutive(temp2);
		else
			temp2Value=havePair(temp2);
		if(temp2Value.contains("Royal"))return "playerTwo";
		else if(temp2Value.contains("Straight")&&temp2Value.contains("Flush"))
			temp2intValue+=100000000;
		else if(temp2Value.contains("FourOfKind"))
			temp2intValue+=10000000;
		else if(isFullHouse(temp2Value))
			temp2intValue+=1000000;
		else if(temp2Value.equals("Flush"))
			temp2intValue+=100000;
		else if(temp2Value.contains("Straight"))
			temp2intValue+=10000;
		else if(temp2Value.contains("ThreeOfKind"))
			temp2intValue+=1000;
		else if(isTwoPairs(temp2Value))
			temp2intValue+=100;
		else if(temp2Value.contains("OnePair"))
			temp2intValue+=10;



		if(temp1intValue==100000000&&temp2intValue==100000000)
		{
			firstChar+=temp1Value.charAt(8);
			lastChar+=temp2Value.charAt(8);
			temp1intValue+=Integer.valueOf(firstChar)*10000000;
			temp2intValue+=Integer.valueOf(lastChar)*10000000;
		}
		else if(temp1intValue==10000000&&temp2intValue==10000000)
		{
			firstChar+=temp1Value.charAt(10);
			lastChar+=temp2Value.charAt(10);
			temp1intValue+=Integer.valueOf(firstChar)*1000000;
			temp2intValue+=Integer.valueOf(lastChar)*1000000;
		}
		else if(temp1intValue==1000000&&temp2intValue==1000000)
		{
			temp1intValue+=getFullHouse(temp1Value)*100000;
			temp2intValue+=getFullHouse(temp2Value)*100000;
		}
		else if(temp1intValue==10000&&temp2intValue==10000)
		{
			firstChar+=temp1Value.charAt(8);
			lastChar+=temp2Value.charAt(8);
			temp1intValue+=Integer.valueOf(firstChar)*10000;
			temp2intValue+=Integer.valueOf(lastChar)*10000;
		}
		else if(temp1intValue==1000&&temp2intValue==1000)
		{
			temp1intValue+=getThreeOfKind(temp1Value)*1000;
			temp2intValue+=getThreeOfKind(temp2Value)*1000;
		}
		else if(temp1intValue==100&&temp2intValue==100)
		{

			temp1intValue+=getTwoPair(temp1Value)*100;
			temp2intValue+=getTwoPair(temp2Value)*100;
		}
		else if(temp1intValue==10&&temp2intValue==10)
		{
			temp1intValue+=getOnePair(temp1Value)*10;
			temp2intValue+=getOnePair(temp2Value)*10;
		}
		if(temp1intValue==temp2intValue)
			return getHighestCard(temp1,temp2);
		if(temp1intValue>temp2intValue)return "playerOne";
		return "playerTwo";
	}




	private static int getOnePair(String temp1Value) 
	{
		String firstChar="";
		temp1Value=temp1Value.replace("OnePairOf", "");
		if(temp1Value.charAt(0)=='A')return 14;
		if(temp1Value.charAt(0)=='K')return 13;
		if(temp1Value.charAt(0)=='Q')return 12;
		if(temp1Value.charAt(0)=='J')return 11;
		if(temp1Value.charAt(0)=='1')return 10;
		firstChar+=temp1Value.charAt(0);
		return Integer.valueOf(firstChar);
	}
	private static int getTwoPair(String temp1Value) 
	{
		String firstChar="";
		String lastChar="";
		temp1Value=temp1Value.replace("OnePairOf", "");
		firstChar+=temp1Value.charAt(0);
		
		if(temp1Value.charAt(0)=='A')firstChar+=14;
		if(temp1Value.charAt(0)=='K')firstChar+=13;
		if(temp1Value.charAt(0)=='Q')firstChar+=12;
		if(temp1Value.charAt(0)=='J')firstChar+=11;
		if(temp1Value.charAt(0)=='1')firstChar+= 10;
		temp1Value=removeCharAt(temp1Value,0);
		lastChar+=temp1Value.charAt(0);
		if(Integer.valueOf(firstChar)>Integer.valueOf(lastChar))
			return Integer.valueOf(firstChar);
		return Integer.valueOf(lastChar);

	}
	private static boolean isTwoPairs(String temp1Value) 
	{
		if(temp1Value.contains("OnePairOf"))
		{
			temp1Value=temp1Value.replace("OnePairOf", "");
			if(temp1Value.contains("OnePairOf"))return true;
		}
		return false;
	}
	private static int getThreeOfKind(String temp1Value) 
	{
		String firstChar="";
		temp1Value=temp1Value.replace("ThreeOfKind","");
		temp1Value=temp1Value.replace("OnePairOf","");
		firstChar+=temp1Value.charAt(0);
		return Integer.valueOf(firstChar);
	}
	private static int getFullHouse(String temp1Value) 
	{
		String firstChar="";
		String lastChar="";
		temp1Value=temp1Value.replace("ThreeOfKind","");
		firstChar+=temp1Value.charAt(9);
		lastChar+=temp1Value.charAt(temp1Value.length()-1);
		if(temp1Value.charAt(9)==temp1Value.charAt(10))
			return Integer.valueOf(firstChar);

		return Integer.valueOf(lastChar);
	}



	private static boolean isFullHouse(String temp1Value) 
	{
		if(temp1Value.contains("OnePairOf"))
		{
			temp1Value=temp1Value.substring(2);
			if(temp1Value.contains("OnePairOf")&&temp1Value.contains("ThreeOfKind"))
			{
				return true;
			}
		}
		return false;
	}
	private static String getHighestCard(String temp1, String temp2) 
	{
		if(temp1.contains("A")&&temp2.contains("A"))
		{
			temp1=temp1.replace("A", "");
			temp2=temp2.replace("A", "");
		}
		if(temp1.contains("K")&&temp2.contains("K"))
		{
			temp1=temp1.replace("K", "");
			temp2=temp2.replace("K", "");
		}
		if(temp1.contains("Q")&&temp2.contains("Q"))
		{
			temp1=temp1.replace("Q", "");
			temp2=temp2.replace("Q", "");
		}
		if(temp1.contains("J")&&temp2.contains("J"))
		{
			temp1=temp1.replace("J", "");
			temp2=temp2.replace("J", "");
		}
		if(temp1.contains("10")&&temp2.contains("10"))
		{
			temp1=temp1.replace("10", "");
			temp2=temp2.replace("10", "");
		}
		if(temp1.contains("9")&&temp2.contains("9"))
		{
			temp1=temp1.replace("9", "");
			temp2=temp2.replace("9", "");
		}
		if(temp1.contains("8")&&temp2.contains("8"))
		{
			temp1=temp1.replace("8", "");
			temp2=temp2.replace("8", "");
		}
		if(temp1.contains("7")&&temp2.contains("7"))
		{
			temp1=temp1.replace("7", "");
			temp2=temp2.replace("7", "");
		}
		if(temp1.contains("6")&&temp2.contains("6"))
		{
			temp1=temp1.replace("6", "");
			temp2=temp2.replace("6", "");
		}
		int temp1Value=0;

		if(temp1.contains("A"))
		{
			temp1Value=9;
		}
		if(temp1.contains("K"))
		{
			temp1Value=8;
		}
		if(temp1.contains("Q"))
		{
			temp1Value=7;
		}
		if(temp1.contains("J"))
		{
			temp1Value=6;
		}
		if(temp1.contains("10"))
		{
			temp1Value=5;
		}
		if(temp1.contains("9"))
		{
			temp1Value=4;
		}
		if(temp1.contains("8"))
		{
			temp1Value=3;
		}
		if(temp1.contains("7"))
		{
			temp1Value=2;
		}
		if(temp1.contains("6"))
		{
			temp1Value=1;
		}
		
		int temp2Value=0;
		
		if(temp2.contains("A"))
		{
			temp2Value=9;
		}
		if(temp2.contains("K"))
		{
			temp2Value=8;
		}
		if(temp2.contains("Q"))
		{
			temp2Value=7;
		}
		if(temp2.contains("J"))
		{
			temp2Value=6;
		}
		if(temp2.contains("10"))
		{
			temp2Value=5;
		}
		if(temp2.contains("9"))
		{
			temp2Value=4;
		}
		if(temp2.contains("8"))
		{
			temp2Value=3;
		}
		if(temp2.contains("7"))
		{
			temp2Value=2;
		}
		if(temp2.contains("6"))
		{
			temp2Value=1;
		}
		if(temp2Value>=temp1Value)return "Playertwo";
		return "playerOne";

	}


	private static String havePair(String temp1) 
	{
		String tempValue="";
		if(temp1.contains("2"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("2"));
			if(temp1.contains("2"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("2"));
				tempValue+="OnePairOf2";
				if(temp1.contains("2"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("2"));
					tempValue+="ThreeOfKind2";
					if(temp1.contains("2"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("2"));
						tempValue="FourOfKind2";
					}
				}

			}	
		}
		if(temp1.contains("3"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("3"));
			if(temp1.contains("3"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("3"));
				tempValue+="OnePairOf3";
				if(temp1.contains("3"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("3"));
					tempValue+="ThreeOfKind3";
					if(temp1.contains("3"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("3"));
						tempValue="FourOfKind3";
					}
				}

			}	
		}
		if(temp1.contains("4"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("4"));
			if(temp1.contains("4"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("4"));
				tempValue+="OnePairOf4";
				if(temp1.contains("4"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("4"));
					tempValue+="ThreeOfKind4";
					if(temp1.contains("4"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("4"));
						tempValue="FourOfKind4";
					}
				}

			}	
		}
		if(temp1.contains("5"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("5"));
			if(temp1.contains("5"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("5"));
				tempValue+="OnePairOf5";
				if(temp1.contains("5"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("5"));
					tempValue+="ThreeOfKind5";
					if(temp1.contains("5"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("5"));
						tempValue="FourOfKind5";
					}
				}

			}	
		}
		if(temp1.contains("6"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("6"));
			if(temp1.contains("6"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("6"));
				tempValue+="OnePairOf6";
				if(temp1.contains("6"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("6"));
					tempValue+="ThreeOfKind6";
					if(temp1.contains("6"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("6"));
						tempValue="FourOfKind6";
					}
				}

			}	
		}
		if(temp1.contains("7"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("7"));
			if(temp1.contains("7"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("7"));
				tempValue+="OnePairOf7";
				if(temp1.contains("7"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("7"));
					tempValue+="ThreeOfKind7";
					if(temp1.contains("7"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("7"));
						tempValue="FourOfKind7";
					}
				}

			}	
		}
		if(temp1.contains("8"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("8"));
			if(temp1.contains("8"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("8"));
				tempValue+="OnePairOf8";
				if(temp1.contains("8"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("8"));
					tempValue+="ThreeOfKind8";
					if(temp1.contains("8"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("8"));
						tempValue="FourOfKind8";
					}
				}

			}	
		}
		if(temp1.contains("9"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("9"));
			if(temp1.contains("9"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("9"));
				tempValue+="OnePairOf9";
				if(temp1.contains("9"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("9"));
					tempValue+="ThreeOfKind9";
					if(temp1.contains("9"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("9"));
						tempValue="FourOfKind9";
					}
				}

			}	
		}
		if(temp1.contains("10"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("10"));
			if(temp1.contains("10"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("10"));
				tempValue+="OnePairOf10";
				if(temp1.contains("10"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("10"));
					tempValue+="ThreeOfKind10";
					if(temp1.contains("10"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("10"));
						tempValue="FourOfKind10";
					}
				}

			}	
		}
		if(temp1.contains("J"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("J"));
			if(temp1.contains("J"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("J"));
				tempValue+="OnePairOfJ";
				if(temp1.contains("J"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("J"));
					tempValue+="ThreeOfKind2";
					if(temp1.contains("J"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("J"));
						tempValue="FourOfKindJ";
					}
				}

			}	
		}
		if(temp1.contains("Q"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("Q"));
			if(temp1.contains("Q"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("Q"));
				tempValue+="OnePairOfQ";
				if(temp1.contains("Q"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("Q"));
					tempValue+="ThreeOfKindQ";
					if(temp1.contains("Q"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("Q"));
						tempValue="FourOfKindQ";
					}
				}

			}	
		}
		if(temp1.contains("K"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("K"));
			if(temp1.contains("K"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("K"));
				tempValue+="OnePairOfK";
				if(temp1.contains("K"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("K"));
					tempValue+="ThreeOfKindK";
					if(temp1.contains("K"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("K"));
						tempValue="FourOfKindK";
					}
				}

			}	
		}
		if(temp1.contains("A"))
		{
			temp1=removeCharAt(temp1,temp1.indexOf("A"));
			if(temp1.contains("A"))
			{
				temp1=removeCharAt(temp1,temp1.indexOf("A"));
				tempValue+="OnePairOfA";
				if(temp1.contains("A"))
				{
					temp1=removeCharAt(temp1,temp1.indexOf("A"));
					tempValue+="ThreeOfKindA";
					if(temp1.contains("A"))
					{
						temp1=removeCharAt(temp1,temp1.indexOf("A"));
						tempValue="FourOfKindA";
					}
				}

			}	
		}
		return tempValue;
	}




	private static String isConsecutive(String temp1) 
	{
		if(temp1.contains("2")&&temp1.contains("3")&&temp1.contains("4")&&temp1.contains("5")&&temp1.contains("6"))return "0";
		if(temp1.contains("3")&&temp1.contains("4")&&temp1.contains("5")&&temp1.contains("6")&&temp1.contains("7"))return "1";
		if(temp1.contains("4")&&temp1.contains("5")&&temp1.contains("6")&&temp1.contains("7")&&temp1.contains("8"))return "2";
		if(temp1.contains("5")&&temp1.contains("6")&&temp1.contains("7")&&temp1.contains("8")&&temp1.contains("9"))return "3";
		if(temp1.contains("6")&&temp1.contains("7")&&temp1.contains("8")&&temp1.contains("9")&&temp1.contains("10"))return "4";
		if(temp1.contains("7")&&temp1.contains("8")&&temp1.contains("9")&&temp1.contains("10")&&temp1.contains("J"))return "5";
		if(temp1.contains("8")&&temp1.contains("9")&&temp1.contains("10")&&temp1.contains("J")&&temp1.contains("Q"))return "6";
		if(temp1.contains("9")&&temp1.contains("10")&&temp1.contains("J")&&temp1.contains("Q")&&temp1.contains("K"))return "7";
		if(temp1.contains("10")&&temp1.contains("J")&&temp1.contains("Q")&&temp1.contains("K")&&temp1.contains("A"))return "Royal";
		return null;
	}



	private static String removeCharAt(String temp1, int i) 
	{
		return temp1.substring(0,i)+temp1.substring(i+1);
	}

	private static boolean isSamesuit(String temp1) 
	{
		return temp1.charAt(1)==temp1.charAt(3)&&temp1.charAt(1)==temp1.charAt(5)&&temp1.charAt(1)==temp1.charAt(7)&&temp1.charAt(1)==temp1.charAt(9);

	}



	private static void sepratePlayers(String string) 
	{
		String[] hands = string.split(" ");
		String temp="";
		for(int i=0;i<5;i++)
		{
			System.out.println(hands[i]);
			temp+=hands[i].trim();
		}
		System.out.println("Player one hand");
		playerOneHand.add(temp.trim());
		temp="";
		for(int i=5;i<10;i++)
		{
			System.out.println(hands[i]);
			temp+=hands[i].trim();
		}
		System.out.println("Player two hand");
		playerTwoHand.add(temp.trim());
	}



}
