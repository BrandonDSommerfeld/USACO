/*
ID: bdsomme1
LANG: JAVA
TASK: bigbrn
*/
import java.io.*;
import java.util.*;

class bigbrn{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("bigbrn.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bigbrn.out")));
    
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int size = Integer.parseInt(reader.nextToken());
    int trees = Integer.parseInt(reader.nextToken());
    boolean[][] grid = new boolean[size][size];
    for(int i = 0; i < trees; i++)
    {
    	reader = new StringTokenizer(f.readLine());
    	int row = Integer.parseInt(reader.nextToken()) - 1;
    	int col = Integer.parseInt(reader.nextToken()) - 1;
    	grid[row][col] = true;
    }
    int max = 0;
    int[][] best = new int[size][size];
    for(int row = 0; row < size; row++)
    {
    	for(int col = 0; col < size; col++)
    	{
    		if(!grid[row][col])
    		{
    			if(row == 0 || col == 0)
    			{
    				best[row][col] = 1;
    				if(1 > max)
    				{
    					max = 1;
    				}
    			}
    			else
    			{
    				best[row][col] = Math.min(Math.min(best[row-1][col], best[row][col-1]), best[row-1][col-1]) + 1;
    				if(best[row][col] > max)
    				{
    					max = best[row][col];
    				}
    			}
    		}
    	}
    }
    
    out.println(max);
    out.close();
	}
}
    