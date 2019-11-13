/*
ID: bdsomme1
LANG: JAVA
TASK: nocows
*/
import java.io.*;
import java.util.*;
import java.math.BigInteger;

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
    if (nodes == 1)
        ways = 1;
}
else if (height == 2)
{
    if (nodes == 3)
        ways = 1;
}
else if (nodes < height * 2 - 1)
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
                for (int count = 0; count < nodes; count+=2)
                {
                    counter += numbot[i - 1][previous][count] * combinations(count, k / 2);;
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
    if (chosen > num)
        return 0;
    if (chosen == num)
        return 1;
		ArrayList<Double> indiv = new ArrayList<>();
		for (int i = 1; i < num; i++)
		{
			if (i >= chosen)
			{
				double boi = i / (num - i);
				indiv.add(boi);
			}
		}
		indiv.add(((double) num));
		double comb = 1;
		for (int i = 0; i < indiv.size(); i++)
		{
			comb *= indiv.get(i);
			comb %= 9901;
		}
		return ((int) Math.round(comb));
}	

}
