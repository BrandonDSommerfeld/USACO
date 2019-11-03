
/*
ID: bdsomme1
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

class ariprog {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
    int length = Integer.parseInt(f.readLine());
    int limit = Integer.parseInt(f.readLine());
    TreeSet<Integer> bisquares = new TreeSet<>();
    int[] lookup = new int[limit * limit * 2 + 1];
    for (int i = 0; i <= limit; i++)
    {
        for (int j = i; j <= limit; j++)
        {
           int square = (int) (Math.round(Math.pow(i, 2)) + Math.round(Math.pow(j, 2)));
           bisquares.add(square);
           lookup[square] = 1;
        }
    }
    
    ArrayList<ArrayList<Integer>> sequences = new ArrayList<>();
    
    
    for (int difference = 1; difference < 
        (2 * Math.pow(limit, 2) + 1) / (length - 1); difference++)
    {
        Iterator iterator = bisquares.iterator();
        int start = ((int) iterator.next());
        while (iterator.hasNext() &&  start < 2 * Math.pow(limit, 2) + 1 - difference * (length - 1))
        {
         boolean stopped = false;
         if (lookup[start + difference * (length - 1)] == 1)
         {
         for (int count = 1; count < length && !stopped; count++)
         {
          if(lookup[start + count * difference] != 1)
          {
             stopped = true; 
                    }
          if (count == length - 1)
          {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(difference);
            sequences.add(temp);
          }
         }
        }
         start = ((int) iterator.next());
         
        }
    }
    if (sequences.size() == 0)
    {
        out.println("NONE");
    }
    else
    {
    for (ArrayList<Integer> nums: sequences)
    {
        out.println(nums.get(0) + " " + nums.get(1));
    }
    } 
    out.close();
}
}