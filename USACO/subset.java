/*
ID: bdsomme1
LANG: JAVA
TASK: sort3
*/
import java.io.*;
import java.util.*;

class sort3 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
    int size = Integer.parseInt(f.readLine());
    int total = (size * (size + 1)) / 2;
    if (total % 2 == 1)
    {
        out.println("0");
    }
    else
    {
        out.println(calculate(size));
    }
    
    out.close();
}

public static int calculate (int size)
{
    int sum = (size * (size + 1)) / 4;
    int min = 1;
    while ((min * (min + 1)) / 2 < sum)
    {
        min++;
    }
    int count = 0;
    for (int i = size; i >= min; i--)
    {
        
    }
    
    return count;
}
}