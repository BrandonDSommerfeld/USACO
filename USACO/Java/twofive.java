/*
ID: bdsomme1
LANG: JAVA
TASK: twofive
*/
import java.io.*;
import java.util.*;

class twofive{
	
	public static String output = "";
	public static int count = 0;
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("twofive.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("twofive.out")));
    String input = f.readLine();
    int num = -1;
    String goal = "?";
    if(input.equals("N"))
    {
    	num = Integer.parseInt(f.readLine());
    }
    else
    {
    	goal = f.readLine();
    }
    
    boolean[][][] allowed = new boolean[5][5][25];
    for(int row = 0; row < 5; row++)
    {
    	for(int col = 0; col < 5; col++)
    	{
    		for(int c = 0; c < 25; c++)
    		{
    			if((row+1) * (col+1) <= c+1 && (5-row) * (5-col) <= 25-c)
    			{
    				allowed[row][col][c] = true;
    			}
    		}
    	}
    }
    algorithm(allowed, num, goal);
    out.println(output);
    out.close();
	}
	
	public static void algorithm (boolean[][][] allowed, int num, String goal)
	{
		//Consider ways to allign 1 row, 2 rows, etc by doing choose garbage
	}
	
	public static boolean works (int[][] grid, int row, int col, int c)
	{
		for(int r = 0; r < row; r++)
		{
			if(grid[r][col] > c)
			{
				return false;
			}
		}
		for(int co = 0; co < col; co++)
		{
			if(grid[row][co] > c)
			{
				return false;
			}
		}
		return true;
	}
}