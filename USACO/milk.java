
/*
ID: bdsomme1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class milk {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("milk.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("milk.out")));
    StringTokenizer read = new StringTokenizer(f.readLine());
    int totalmilk = Integer.parseInt(read.nextToken());
    int farmers = Integer.parseInt(read.nextToken());
    TreeMap<Integer, Integer> prices = new TreeMap<>();
    for (int i = 0; i < farmers; i++)
    {
        StringTokenizer reader = new StringTokenizer(f.readLine());
        int price = Integer.parseInt(reader.nextToken());
        int units = Integer.parseInt(reader.nextToken());
        if (prices.get(price) == null)
            prices.put(price, units);
        else
            prices.put(price, units + prices.get(price));
    }
    int totalcost = 0;
    for (Integer cost: prices.keySet())
    {
        int unit = prices.get(cost);
        if (totalmilk == 0)
            ;
        else if (totalmilk >= unit)
        {
            totalmilk -= unit;
            totalcost += (cost * unit);
        }
        else
        {
            totalcost += (cost*totalmilk);
            totalmilk = 0;
        }
    }
    out.println(totalcost);
    out.close();
}
}