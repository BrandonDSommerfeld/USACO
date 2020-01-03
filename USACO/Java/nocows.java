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
    for (int k = 2; k <= nodes - 2*i + 3; k += 2)
    {
            for (int j = 2 * i - 3 + k; j <= nodes - (height - i)*2; j += 2)
            {
                int previous = j - k;
                int counter = 0;
                for (int count = 2; count < nodes; count+=2)
                {
                    int current = numbot[i - 1][previous][count];
                    if (current != 0)
                    {
                    counter += current * combinations(count, k / 2);;
                    counter %= 9901;
                }
                }
                numbot[i][j][k] = counter % 9901;
            }
    }
}

ways = 0;
for (int i = 0; i < nodes; i++)
{
    ways += numbot[height][nodes][i];
}
ways %= 9901;
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
    int comb = 1;
    int r = 1;
    for (int i = chosen + 1; i <= num; i++)
    {
        comb *= i;
        int divide = (i - chosen);
        while (comb % divide != 0)
        {
            comb += 9901;
        }
        comb = comb/divide;
        comb %= 9901;
    }
    return comb;
}   

}
