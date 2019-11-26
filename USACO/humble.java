/*
ID: bdsomme1
LANG: JAVA
TASK: humble
*/
import java.io.*;
import java.util.*;

class humble {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("humble.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
    HashSet<Integer> primes = new HashSet<>();
    StringTokenizer reader = new StringTokenizer(f.readLine());
    reader.nextToken();
    int num = Integer.parseInt(reader.nextToken());
    reader = new StringTokenizer(f.readLine());
    while(reader.hasMoreTokens())
    {
        primes.add(Integer.parseInt(reader.nextToken()));
    }
    boolean[] possible = new boolean[Long.MAX_VALUE];
    out.println(place - 1);
    out.close();
}
}