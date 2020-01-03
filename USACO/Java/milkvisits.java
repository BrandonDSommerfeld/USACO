/*
ID: bdsomme1
LANG: JAVA
TASK: milkvisits
*/
import java.io.*;
import java.util.*;

class milkvisits {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int farms= Integer.parseInt(reader.nextToken());
int friends = Integer.parseInt(reader.nextToken());
char[] milks = new char[farms + 1];
String in = f.readLine();
for(int i = 0; i < farms; i++)
{
    milks[i + 1] = in.charAt(i);
}
int[][] adj = new int[farms + 1][farms + 1];
for(int i = 0; i < farms - 1; i++)
{
    reader = new StringTokenizer(f.readLine());
    int first = Integer.parseInt(reader.nextToken());
    int second = Integer.parseInt(reader.nextToken());
    adj[first][second] = 1;
    adj[second][first] = 1;
}

int[][] paths = algorithm(adj, milks);
String happy = "";
for(int i = 0; i < friends; i++)
{
    reader = new StringTokenizer(f.readLine());
    int first = Integer.parseInt(reader.nextToken());
    int second = Integer.parseInt(reader.nextToken());
    char doot = reader.nextToken().charAt(0);
    int got = paths[first][second];
    if(got == 3 || got == 0 || (got == 2 && doot == 'G') || (got == 1 && doot == 'H'))
    {
        happy += 1;
    }
    else
    {
        happy += 0;
    }
}

out.println(happy);
out.close();
}

public static int[][] algorithm(int[][] adj, char[] milks)
{
    int[][] milk = new int[adj.length][adj.length];
    for(int i = 1; i < adj.length; i++)
    {
        LinkedList<int[]> queue = new LinkedList<>();
        int[] start = {i, -1};
        queue.add(start);
        while(queue.size() != 0)
        {
            int[] on = queue.remove();
            int current = on[0];
            int previous = on[1];
            if(previous == -1)
            {
                if(milks[i] == 'H')
                {
                    milk[i][i] = 1;
                }
                else
                {
                    milk[i][i] = 2;
                }
            }
            else if (milk[i][previous] == 1)
            {
                if(milks[current] == 'H')
                {
                    
                    milk[i][current] = 1;
                }
                else
                {
                    
                    milk[i][current] = 3;
                }
            }
            else if (milk[i][previous] == 2)
            {
                if(milks[current] == 'H')
                {
                    
                    milk[i][current] = 3;
                }
                else
                {
                  
                    milk[i][current] = 2;
                }
            }
            else if (milk[i][previous] == 3)
            {
               milk[i][current] = 3;
            }
            for(int j = 1; j < adj.length; j++)
            {
                if(adj[current][j] == 1)
                {
                    if(milk[i][j] == 0)
                    {
                        int[] temp = {j, current};
                        queue.add(temp);
                    }
                }
            }
        }
        
    }
    
    
    
    return milk;
}
}