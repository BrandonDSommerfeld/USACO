
/*
ID: bdsomme1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("palsquare.out")));
    int base = Integer.parseInt(f.readLine());
    for (int i = 1; i <= 300; i++)
    {
        int square = ((int) Math.round(Math.pow(i, 2)));
        if (palindrome(toBase(square, base)))
        {
            out.println(toBase(i, base) + " " + toBase(square, base));
        }
    }
    out.close();
}

public static boolean palindrome (String word)
{
    for (int i = 0; i < word.length()/2; i++)
    {
        if (word.charAt(i) != word.charAt(word.length() - 1 - i))
        {
            return false;
        }
    }
    return true;
}

public static String toBase (int num, int base)
{
    int power = 0;
    String temp = "";
    int counter = 0;
    while (num >= ((int)Math.round(Math.pow(base, power))))
    {
        power++;
    }
    power--;
    boolean first = true;
    while (power >= 0)
    {
        while (num >= (int) Math.round(Math.pow(base, power)))
        {
            num -= ((int) Math.round(Math.pow(base, power)));
            counter++;
        }
        if (!first && counter == 0)
        {
            temp += "0";
        }
        else if (counter != 0 && counter < 10)
            temp += counter;
        else if (counter == 10)
        {
            temp += "A";
        }
        else if (counter == 11)
        {
            temp += "B";
        }
        else if (counter == 12)
        {
            temp += "C";
        }
        else if (counter == 13)
        {
            temp += "D";
        }
        else if (counter == 14)
        {
            temp += "E";
        }
        else if (counter == 15)
        {
            temp += "F";
        }
        else if (counter == 16)
        {
            temp += "G";
        }
        else if (counter == 17)
        {
            temp += "H";
        }
        else if (counter == 18)
        {
            temp += "I";
        }
        else if (counter == 19)
        {
            temp += "J";
        }
        power --;
        counter = 0;
        first = false;
    }
    return temp;
}
}
