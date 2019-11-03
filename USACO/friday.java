
/*
ID: bdsomme1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("friday.out")));
    int years = Integer.parseInt(f.readLine());
    TreeMap<Integer, Integer> counter = new TreeMap<>();
    counter.put(0, 0);
    counter.put(1, 0);
    counter.put(2, 0);
    counter.put(3, 0);
    counter.put(4, 0);
    counter.put(5, 0);
    counter.put(6, 0);
    int day = 0;
    for (int i = 0; i < years; i++)
    {
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
        counter.put(day, counter.get(day) + 1);
        if (i % 4 == 0)
        {
            if (i % 100 == 0)
            {
                if (i == 100)
                {
                    day = (day + 29) % 7;
                }
                else
                {
                    day = (day + 28) % 7;
                }
            }
            else
            {
                day = (day + 29) % 7;
            }
        }
        else
        {
            day = (day + 28) % 7;
        }
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 30) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 30) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 30) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 30) % 7;
        counter.put(day, counter.get(day) + 1);
        day = (day + 31) % 7;
    }
    out.print(counter.get(0) + " ");
    out.print(counter.get(1) + " ");
    out.print(counter.get(2) + " ");
    out.print(counter.get(3) + " ");
    out.print(counter.get(4) + " ");
    out.print(counter.get(5) + " ");
    out.print(counter.get(6) + "\n");
    out.close();
   }   

}
