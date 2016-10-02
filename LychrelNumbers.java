package project_euler;
import java.math.BigInteger;
public class LychrelNumbers
{
    public static void main(String[] args) 
    {
        int counter = 0;

        for (int i = 0; i < 10000; i++) {
            if (isLychrel(i)) {
                counter++;
            }
        }

        System.out.print(counter);
    }

    private static boolean isLychrel(int num) {
        BigInteger temp = BigInteger.valueOf(num);
        for (int i = 0; i < 50; i++) {
            temp = temp.add(new BigInteger(reverse(temp)));
            if (isPalindrome(temp)) {
                return false;
            }
        }

        return true;
    }

    private static String reverse(BigInteger num) {
        return new StringBuilder(num.toString()).reverse().toString();
    }

    private static boolean isPalindrome(BigInteger num) {
        return num.equals(new BigInteger(reverse(num)));
    }
}

