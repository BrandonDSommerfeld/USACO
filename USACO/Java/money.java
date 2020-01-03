/*
ID: bdsomme1
LANG: JAVA
TASK: money
*/
import java.io.*;
import java.util.*;

class money {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("money.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
    
StringTokenizer reader = new StringTokenizer(f.readLine());
int coins = Integer.parseInt(reader.nextToken());
int money = Integer.parseInt(reader.nextToken());
String temp = f.readLine();
ArrayList<Integer> values = new ArrayList<>();
while(temp != null)
{
    reader = new StringTokenizer(temp);
    while (reader.hasMoreTokens())
    {
        values.add(Integer.parseInt(reader.nextToken()));
    }
    temp = f.readLine();
}

Collections.sort(values);

long num = generate(money, values);
out.println(num);
out.close();
}


public static long generate(int money, ArrayList<Integer> values)
{
    long[] ways = new long[money + 1];
    ways[0] = 1;
    for (int i = 0; i < values.size(); i++)
    {
        for(int j = 0; j <= money; j++)
        {
            int current = values.get(i);
            boolean[] done = new boolean[money + 1];
            if (j + current <= money && !done[j + current])
            {
                ways[j + current] += ways[j];
            }
        }
    }
    return ways[money];
}
}