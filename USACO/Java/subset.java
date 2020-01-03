/*
ID: bdsomme1
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;

class subset {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("subset.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
    int size = Integer.parseInt(f.readLine());
    int total = (size * (size + 1)) / 2;
    if (total % 2 == 1)
    {
        out.println("0");
    }
    else
    {
        out.println(calculate(size, (size * (size + 1)) / 4));
    }
    
    out.close();
}

public static int calculate (int size, int sum)
{
    int[][] ways = new int[size + 1][sum + 1];
		ways[1][1] = 1;
		ways[0][1] = 1;
		for (int i = 2; i < ways.length; i++)
		{
			for (int j = 0; j < ways[0].length; j++)
			{
				if (j >= i)
				{
					ways[i][j] = ways[i - 1][j] + ways[i - 1][j - i];
				}
				else
				{
					ways[i][j] = ways[i-1][j];
				}
			}
		}
		return ways[size][sum];
}
}