
/*
ID: bdsomme1
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

class skidesign {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
    int hills = Integer.parseInt(f.readLine());
    ArrayList<Integer> heights = new ArrayList<>();
    int sum = 0, height;
    for (int i = 0; i < hills; i++)
    {
      height = Integer.parseInt(f.readLine());
      heights.add(height);   
      sum += height;
    }
    
    int average = sum / hills;
    int cost = 0, min = Integer.MAX_VALUE;
    for (int i = average - 10; i < average + 11; i++)
    {
      for (int j = 0; j < hills; j++)
      {
         if (heights.get(j) > i + 8)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i - 8, 2));
            }
         else if (heights.get(j) < i - 9)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i + 9, 2));
            }
        }
      if (cost < min)
      {
         min = cost; 
        }
      cost = 0;
      for (int j = 0; j < hills; j++)
      {
         if (heights.get(j) > i + 9)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i - 9, 2));
            }
         else if (heights.get(j) < i - 8)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i + 8, 2));
            }
        }
      if (cost < min)
      {
         min = cost; 
        }
      cost = 0;
      for (int j = 0; j < hills; j++)
      {
         if (heights.get(j) > i + 10)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i - 10, 2));
            }
         else if (heights.get(j) < i - 7)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i + 7, 2));
            }
        }
      if (cost < min)
      {
         min = cost; 
        }
      cost = 0;
      for (int j = 0; j < hills; j++)
      {
         if (heights.get(j) > i + 7)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i - 7, 2));
            }
         else if (heights.get(j) < i - 10)
         {
             cost += (int) Math.round(Math.pow(heights.get(j) - i + 10, 2));
            }
        }
      if (cost < min)
      {
         min = cost; 
        }
      cost = 0;
    }
    out.println(min);
    out.close();
}
}