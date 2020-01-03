/*
ID: bdsomme1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

class crypt1 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("crypt1.out")));
    int num = Integer.parseInt(f.readLine());
    StringTokenizer reader = new StringTokenizer(f.readLine());
    TreeSet<Integer> numbers = new TreeSet<>();
    int num1, num2, num3, num4, count = 0;
    ArrayList<Integer> digits1, digits2, digits3;
    boolean true1 = true, true2 = true, true3 = true;
    while(reader.hasMoreTokens())
    {
        numbers.add(Integer.parseInt(reader.nextToken()));
    }
    for (Integer n1: numbers)
    {
     for (Integer n2: numbers)
     {
     for (Integer n3: numbers)
     {
     for (Integer n4: numbers)
     {
     for (Integer n5: numbers)
     {
         num1 = n1 * 100 + n2 * 10 + n3;
         num2 = n4;
         num3 = n5;
         num4 = n4 * 10 + n5;
         digits1 = digits(num1 * num2);
         digits2 = digits(num1 * num3);
         digits3 = digits(num1 * num4);
         if (digits1.size() > 3)
         {
             true1= false;
            }
         if (digits2.size() > 3)
         {
             true2= false;
            }
         if (digits3.size() > 4)
         {
             true3= false;
            }
         for (Integer digit: digits1)
         {
             if (!numbers.contains(digit))
             {
                 true1 = false;
                }
            }
         for (Integer digit: digits2)
         {
             if (!numbers.contains(digit))
             {
                 true2 = false;
                }
            }
         for (Integer digit: digits3)
         {
             if (!numbers.contains(digit))
             {
                 true3 = false;
                }
            }
         if (true1 && true2 && true3)
         {
             count++;
            }
         true1 = true;
         true2 = true;
         true3 = true;
        }
        }
        }
        }
    }
    out.println(count);
    out.close();
}

public static ArrayList<Integer> digits  (int number)
{
    ArrayList<Integer> temp = new ArrayList<>();
    while (number != 0)
    {
        temp.add(number % 10);
        number = number / 10;
    }
    return temp;
}
}