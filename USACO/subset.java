/*
ID: bdsomme1
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;

class subset {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("subset.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
    int size = Integer.parseInt(f.readLine());
    int total = (size * (size + 1)) / 2;
    if (total % 2 == 1)
    {
        out.println("0");
    }
    else
    {
        out.println(calculate(size, (size * (size + 1)) / 4));
    }
    
    out.close();
}

public static int calculate (int size, int sum)
{
    int get = sum - size;
    if (get == 0)
    {
        return 1;
    }
    else if (get == 1)
    {
        return 1;
    }
    else if (get == 2)
    {
        return 1;
    }
    
    int min = 1;
    while ((min * (min + 1)) / 2 < get)
    {
        min++;
    }
    int count = 0;
    for (int i = size - 1; i >= min; i--)
    {
        if (i <= get)
        {
            count += calculate(i, get);
        }
    }
    
    return count;
}
}