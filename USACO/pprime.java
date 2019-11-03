
/*
ID: bdsomme1
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;

class pprime {
  
  
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int low = Integer.parseInt(reader.nextToken());
    int high = Integer.parseInt(reader.nextToken());
    
    ArrayList<Integer> found = new ArrayList<>();
    ArrayList<Integer> palindromes = palindromes(low, high);
    for (int i = 0; i < palindromes.size(); i++)
    {
        int temp = palindromes.get(i);
        if (temp >= low && temp <= high && isPrime(temp))
            found.add(temp);
    }
    for (Integer i: found)
    {
        out.println(i);
    }


    out.close();
}

public static ArrayList<Integer> palindromes (int low, int high)
{
    ArrayList<Integer> temp = new ArrayList<>();
    String low1 = new Integer(low).toString();
    String high1 = new Integer(high).toString();
    int lowlength = low1.length(), highlength = high1.length();
    
    if (lowlength <= 1 && highlength >= 1)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        String temp1 = "" + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    
    if (lowlength <= 2 && highlength >= 2)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        String temp1 = "" + i + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    
    if (lowlength <= 3 && highlength >= 3)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        for (int j = 0; j <= 9; j++)
        {
        String temp1 = "" + i + j + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    }
    
    if (lowlength <= 4 && highlength >= 4)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        for (int j = 0; j <= 9; j++)
        {
        String temp1 = "" + i + j + j + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    }
    
    if (lowlength <= 5 && highlength >= 5)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        for (int j = 0; j <= 9; j++)
        {
            for (int k = 0; k <= 9; k++)
            {
        String temp1 = "" + i + j + k + j + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    }
    }
    
    if (lowlength <= 6 && highlength >= 6)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        for (int j = 0; j <= 9; j++)
        {
            for (int k = 0; k <= 9; k++)
            {
        String temp1 = "" + i + j + k + k + j + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    }
    }
    
    if (lowlength <= 7 && highlength >= 7)
    {
    for (int i = 1; i <= 9; i+=2)
    {
        for (int j = 0; j <= 9; j++)
        {
            for (int k = 0; k <= 9; k++)
            {
                for (int l = 0; l <= 9; l++)
                {
        String temp1 = "" + i + j + k + l + k + j + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    }
    }
    }
    
    if (lowlength <= 8 && highlength >= 8)
    {
    for (int i = 1; i <= 9; i += 2)
    {
        for (int j = 0; j <= 9; j++)
        {
            for (int k = 0; k <= 9; k++)
            {
                for (int l = 0; l <= 9; l++)
                {
        String temp1 = "" + i + j + k + l + l + k + j + i;
        temp.add(Integer.parseInt(temp1));
    }
    }
    }
    }
    }
    
    return temp;
}

public static boolean isPrime (int num)
{
    if (num % 2 == 0)
        return false;
    
    for (int i = 3; i <= ((Math.floor(Math.sqrt(num)))); i += 2)
    {
        if (num % i == 0)
            return false;
    }
    return true;
}
}