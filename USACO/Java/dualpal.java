
/*
ID: bdsomme1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("dualpal.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int num = Integer.parseInt(reader.nextToken());
    int start = Integer.parseInt(reader.nextToken());
    int count = 0;
    for (int i = start + 1; count < num; i++)
    {
        ArrayList<Boolean> trues = new ArrayList<>();
        if (palindrome(toBase(i, 2)))
        {
            trues.add(true);
        }
        if (palindrome(toBase(i, 3)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(toBase(i, 4)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(toBase(i, 5)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(toBase(i, 6)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(toBase(i, 7)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(toBase(i, 8)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(toBase(i, 9)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
        else
        {
        if (palindrome(Integer.toString(i)))
        {
            trues.add(true);
        }
        if (trues.size() > 1)
        {
            out.println(i);
            count++;
        }
    }
    }
    }
    }
    }
    }
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
        else
            temp += counter;
        power --;
        counter = 0;
        first = false;
    }
    return temp;
}
}