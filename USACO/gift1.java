
/*
ID: bdsomme1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("gift1.out")));
    int np = Integer.parseInt(f.readLine());
    LinkedHashMap<String, Integer> accounts = new LinkedHashMap<>();
    for (int i = 2; i < np + 2; i++)
    {
        accounts.put(f.readLine(), 0);
    }
    String person;
    int amount, numPeople, gift;
    for (int i = 0; i < np; i++)
    {
        person = f.readLine();
        StringTokenizer reader = new StringTokenizer(f.readLine());
        amount = Integer.parseInt(reader.nextToken());
        numPeople = Integer.parseInt(reader.nextToken());
        if (numPeople != 0)
        {
        gift = amount / numPeople;
        accounts.put(person, (accounts.get(person) - (gift * numPeople)));
        for (int j = 0; j < numPeople; j++)
        {
            String receiver = f.readLine();
            accounts.put(receiver, (accounts.get(receiver) + gift));
        }
    }
    }
    for (String per: accounts.keySet())
    {
        out.println(per + " " + accounts.get(per));
    }
    out.close();
  }
}
