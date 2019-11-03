
/*
ID: bdsomme1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

class combo {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("combo.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("combo.out")));
    int length = Integer.parseInt(f.readLine());
    StringTokenizer reader = new StringTokenizer(f.readLine());
    StringTokenizer read = new StringTokenizer(f.readLine());
    int[] combo1 = {Integer.parseInt(reader.nextToken()), 
        Integer.parseInt(reader.nextToken()), Integer.parseInt(reader.nextToken())};
    int[] combo2 = {Integer.parseInt(read.nextToken()), 
        Integer.parseInt(read.nextToken()), Integer.parseInt(read.nextToken())}; 
    int count = 0;
    for(int i = 1; i <= length; i++)
    {
        for(int j = 1; j <= length; j++)
    {
        for(int k = 1; k <= length; k++)
    {
        if (within2(i, combo1[0], length) && 
        within2(j, combo1[1], length) && within2(k, combo1[2], length))
        {
            count++;
        }
        else if (within2(i, combo2[0], length) && 
        within2(j, combo2[1], length) && within2(k, combo2[2], length))
        {
            count++;
        }
    }
    }
    }
    out.println(count);
    out.close();
}

public static boolean within2 (int num1, int num2, int length)
{
    if (Math.abs(num1 - num2) <= 2)
        return true;
    if ((num1 == 1 && (num2 == length || num2 == length-1))
    || (num1 == 2 && num2 == length) || (num2 == 1 && (num1 == length || num1 == length-1))
    || (num2 == 2 && num1 == length))
        return true;
    
    
    return false;
}
}