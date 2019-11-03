
/*
ID: bdsomme1
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;

class pprime {
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
  
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int low = Integer.parseInt(reader.nextToken());
    int high = Integer.parseInt(reader.nextToken());
    
    if (low % 2 == 0)
        low++;
    if (high % 2 == 0)
        high--;
    ArrayList<Integer> found = new ArrayList<>();
    ArrayList<Integer> palindromes = palindromes(low, high);
    for (int i = 0; i < palindromes.size(); i++)
    {
        if (isPrime(palindromes.get(i)))
            found.add(i);
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
    String first = new Integer(low).toString();
    int begin = Integer.parseInt(first.substring(0, (first.length() + 1)/2) 
    + first.substring(0, (first.length() + 1)/2).reverse());
    
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