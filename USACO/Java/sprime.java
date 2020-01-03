/*
ID: bdsomme1
LANG: JAVA
TASK: sprime
*/
import java.io.*;
import java.util.*;

class sprime {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
    int length = Integer.parseInt(f.readLine());
    ArrayList<Integer> nums = generate(length);
    for (Integer i: nums)
    {
        out.println(i);
    }
    out.close();
}

public static ArrayList<Integer> generate (int length)
{
    ArrayList<Integer> temp = new ArrayList<>();
    if (length == 1)
    {
        temp.add(2);
        temp.add(3);
        temp.add(5);
        temp.add(7);
    }
    else
    {
        ArrayList<Integer> previous = generate(length - 1);
        for (int i = 0; i < previous.size(); i++)
        {
            for (int j = 1; j <= 9; j+=2)
            {
                if (isPrime(10*previous.get(i) + j))
                    temp.add(10*previous.get(i) + j);
            }
        }
    }
    
    
    return temp;
}

public static boolean isPrime (int num)
{
    for (int i = 3; i <= ((Math.floor(Math.sqrt(num)))); i += 2)
    {
        if (num % i == 0)
            return false;
    }
    return true;
}
}