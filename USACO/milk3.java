
/*
ID: bdsomme1
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.*;

class milk3 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int bucket1 = Integer.parseInt(reader.nextToken());
    int bucket2 = Integer.parseInt(reader.nextToken());
    int bucket3 = Integer.parseInt(reader.nextToken());
    TreeSet<Integer> amounts = new TreeSet<>();
    amounts.add(bucket3);
    if (bucket3 <= bucket1 && bucket3 <= bucket2)
    {
        amounts.add(0);
    }
    else if (bucket3 >= bucket1 && bucket3 <= bucket2)
    {
        amounts.add(0);
        for(int count = 1; count * bucket1 <= bucket3; count++)
        {
            amounts.add(count * bucket1);
            amounts.add(bucket3 - (count * bucket1));
        }
    }
    else if (bucket3 <= bucket1 && bucket3 >= bucket2)
    {
        amounts.add(bucket3 - bucket2);
        amounts.add(bucket3 - bucket3 % bucket2);
    }
    else if (bucket3 >= bucket1 && bucket3 >= bucket2)
    {
        if (bucket1 <= bucket2)
        {
          for (int count = 1; count * bucket1 <= bucket2; count++)
          {
              amounts.add(bucket3 - count*bucket1);
          }
          for (int count = 0; count * bucket1 <= bucket2; count++)
          {
              amounts.add(bucket3 + count*bucket1 - bucket2);
          }
          
          if (bucket1 + bucket2 >= bucket3)
          {
            for (int count = 1; count * bucket1 <= bucket3; count++)
            {
                  amounts.add(count*bucket1);
            }
            for (int count = 0; count * bucket1 + bucket3 <= 2*bucket2; count++)
            {
                  amounts.add(bucket2 - count*bucket1);
            }
            int mid = (bucket2 % bucket1);
            int initial = (bucket2 % bucket1);
            boolean first = true;
            while (mid >= 0 && mid + bucket2 <= bucket3 && (mid != initial || first))
            {
            for (int count = 1; (count-1) * bucket1 <= bucket2; count++)
            {
              amounts.add(bucket3 + count*bucket1 - bucket2 - mid);
            }
            mid = bucket2 + mid - bucket1 * (bucket2 / bucket1);
            if (mid >= bucket1)
                mid -= bucket1;
            first = false;
            }
            
            }
        }
        else
        {
          amounts.add(bucket3 - bucket2);
          amounts.add(bucket3 - (bucket1 % bucket2));
          if (bucket1 + bucket2 >= bucket3)
          {
              amounts.add(bucket1);
            }
        }
    }
    for (Integer num: amounts)
    {
        if (num >= bucket3 - bucket2 && num <= bucket3)
        {
            out.print(num);   
            if (num != bucket3)
                out.print(" ");
        }
    }
    
    out.println();
    out.close();
}
}