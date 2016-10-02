package project_euler;
import java.util.ArrayList;
public class PandigitalProducts
{
    static ArrayList<Long>pandigitals=new ArrayList<Long>();
    public static void main(String[] args)
    {
        for(long i=1;i<=4000;i++)
            for(long j=i;j<=4000;j++)
                if(checkIfPandigital(Long.toString(i)+Long.toString(j)+Long.toString(i*j)))
                    if(!pandigitals.contains(i*j))
                        pandigitals.add(i*j);
           
        System.out.println(pandigitals);
        System.out.print(getSumOfGlobalArray());
    }
    public static String removeCharAt(String s, int pos)
    {
        if(pos==-1)return "cpp";
        return s.substring(0, pos) + s.substring(pos + 1);
    }
    public static boolean checkIfPandigital(String temp1)
    {
            temp1=removeCharAt(temp1,temp1.indexOf('1'));
            temp1=removeCharAt(temp1,temp1.indexOf('2'));
            temp1=removeCharAt(temp1,temp1.indexOf('3'));
            temp1=removeCharAt(temp1,temp1.indexOf('4'));
            temp1=removeCharAt(temp1,temp1.indexOf('5'));
            temp1=removeCharAt(temp1,temp1.indexOf('6'));
            temp1=removeCharAt(temp1,temp1.indexOf('7'));
            temp1=removeCharAt(temp1,temp1.indexOf('8'));
            if(temp1.equals("9"))
                return true;
       
        return false;
    }
    public static long getSumOfGlobalArray()
    {
        long sum=0;
        for(int i=0;i<=pandigitals.size()-1;i++)sum+=pandigitals.get(i);
       
        return sum;
    }
}