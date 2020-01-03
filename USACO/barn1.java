
/*
ID: bdsomme1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

class barn1 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("barn1.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int boards = Integer.parseInt(reader.nextToken());
    int stalls = Integer.parseInt(reader.nextToken());
    int cows = Integer.parseInt(reader.nextToken());
    int[] occupied = new int[cows];
    for (int i = 0; i < cows; i++)
    {
        occupied[i] = Integer.parseInt(f.readLine());
    }
    Arrays.sort(occupied);
    ArrayList<Integer> gaps = new ArrayList<>();
    int gap;
    for (int i = 0; i < cows - 1; i++)
    {
        gaps.add(occupied[i+1] - occupied[i] - 1);
    }
    Collections.sort(gaps);
    while (gaps.size() > boards - 1)
    {
            gaps.remove(0);
    }
    int range = occupied[cows-1] - occupied[0] + 1;
    for (Integer missing: gaps)
    {
        range -= missing;
    }
    if (boards >= cows)
    {
        range = cows;
    }
    out.println(range);
    out.close();
}
}