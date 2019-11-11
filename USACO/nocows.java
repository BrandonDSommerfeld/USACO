/*
ID: bdsomme1
LANG: JAVA
TASK: nocows
*/
import java.io.*;
import java.util.*;

class nocows {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int nodes = Integer.parseInt(reader.nextToken());
    int height = Integer.parseInt(reader.nextToken());
    
    int[][][] ways = new int[height + 1][nodes + 1][9901];
    ways[1][1][1] = 1;
    ways[2][3][2] = 1;
    ways[2][5][4] = 1;
    
    out.close();
}
}