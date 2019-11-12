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
int ways = 0;

if(height == 1)
{

}
else if (height == 2)
{

}
else
{
int[][][] numbot = new int[height + 1][nodes + 1][nodes];
numbot[1][1][1] = 1;
numbot[2][3][2] = 1;
for (int i = 3; i<= height; i++)
{
    for (int k = 2; k < nodes; k += 2)
    {
            for (int j = 2 * i - 3 + k; j <= nodes; j += 2)
            {
                int previous = j - k;
                int counter = 0;
                for (int count = 0; count < nodes; count++)
                {
                    counter += numbot[i - 1][previous][count] * combinations(previous, k / 2);;
                    counter %= 9901;
                }
                numbot[i][j][k] = counter % 9901;
            }
    }
}

ways = 0;
for (int i = 0; i < nodes; i++)
{
    ways += numbot[height][nodes][i];
    ways %= 9901;
}
}
out.println(ways);
out.close();
}

public static int combinations (int num, int chosen)
{
        int top = 1;
        for (int i = num; i > chosen; i--)
        {
            top *= i;
        }
        int bottom = 1;
        for (int i = chosen; i > 1; i--)
        {
            bottom *= i;
        }
        return top/bottom;
}

}
