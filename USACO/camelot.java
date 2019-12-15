/*
ID: bdsomme1
LANG: JAVA
TASK: camelot
*/
import java.io.*;
import java.util.*;

class camelot {
    private static int[] path;
    private static int position;
  public static void main (String [] args) throws IOException {
  BufferedReader f = new BufferedReader(new FileReader("camelot.in"));
  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
  StringTokenizer reader = new StringTokenizer(f.readLine());
	int rows = Integer.parseInt(reader.nextToken());
	int columns = Integer.parseInt(reader.nextToken());
	int[][] board = new int[rows][columns];
	reader = new StringTokenizer(f.readLine());
	int kingcol = (reader.nextToken().charAt(0) - 65);
	int kingrow = Integer.parseInt(reader.nextToken()) - 1;
	board[kingrow][kingcol] = -1;
	String next = f.readLine();
	while(next != null)
	{
		reader = new StringTokenizer(next);
		while(reader.hasMoreTokens())
		{
			int col = (reader.nextToken().charAt(0) - 65);
			int row = Integer.parseInt(reader.nextToken()) - 1;
			board[row][col] = 1;
		}
		next = f.readLine();
	}
	int[][] distances = algorithm(board, kingrow, kingcol);
	out.println(min(distances));
	out.close();
}
public static int[][] algorithm (int[][] board, int kingrow, int kingcol)
{
	int rows = board.length;
	int cols = board[0].length;
	int[][] knightdistance = new int[rows][cols];
	int[][] kingdistances = kingdistances(rows, cols, kingrow, kingcol);
	int[][] kingdistance = new int[rows][cols];
	for(int i = 0; i < rows; i++)
	{
		for(int j = 0; j < cols; j++)
		{
			if(board[i][j] == 1)
			{
				LinkedList<int[]> queue = new LinkedList<>();
				int[][] thisdistance = new int[rows][cols];
				int[] on = {i, j, kingdistances[i][j]};
				queue.add(on);
				while(queue.size() != 0)
				{
					int[] current = queue.remove();
					int row = current[0];
					int col = current[1];
					int prev = current[2];
					if(kingdistances[row][col] < kingdistance[i][j] || (kingdistance[i][j] == 0 && (row != i || col != j)))
					{
						kingdistance[i][j] = kingdistances[row][col];
						prev = kingdistances[row][col];
					}
					int[][] neighbors = neighbors(row, col);
					for(int count = 0; count < 8; count++)
					{
						try
						{
							int r = neighbors[i][0];
							int c = neighbors[i][1];
							if(knightdistance[r][c] == 0 && (r != i || c != j))
							{
								knightdistance[r][c] = knightdistance[row][col] + 1;
								int[] temp = {r, c,prev};
								queue.add(temp);
							}
						}
						catch (Exception e)
						{
						
						}
					}
				}
			}
		}
	}
	for(int i = 0; i < rows; i++)
	{
		for(int j = 0; j < cols; j++)
		{
			System.out.print(kingdistances[i][j] + " ");
			knightdistance[i][j] += kingdistance[i][j];
		}
		System.out.println();
	}
	return knightdistance;
}

public static int[][] kingdistances(int rows, int cols, int kingrow, int kingcol)
{
	int[][] kingdistance = new int[rows][cols];
	LinkedList<int[]> queue = new LinkedList<>();
	int[] start = {kingrow, kingcol};
	queue.add(start);
	while(queue.size() != 0)
	{
		int[] current = queue.remove();
		int row = current[0];
		int col = current[1];
		int[][] neighbors = kingneighbors(row, col);
		for(int i = 0; i < 4; i++)
		{
			try
			{
				int r = neighbors[i][0];
				int c = neighbors[i][1];
				if(kingdistance[r][c] == 0 && (r != kingrow || c != kingcol))
				{
					if(kingdistance[row][col] < 2)
					{
						kingdistance[r][c] = kingdistance[row][col] + 1;
					}
					else
					{
						int min = Integer.MAX_VALUE;
						int[][] knights = neighbors(r, c);
						for(int j = 0; j < 8; j++)
						{
							try
							{
								int ro = knights[i][0];
								int co = knights[i][1];
								if(kingdistance[ro][co] + 2 < min)
								{
									min = kingdistance[ro][co] + 2;
								}
							}
							catch (Exception e)
							{
								
							}
						}
						kingdistance[r][c] = min;
					}
					int[] temp = {r, c};
					queue.add(temp);
				}
			}
			catch (Exception e)
			{
			
			}
		}
	}
	
	return kingdistance;
}
public static int[][] kingneighbors(int row, int col)
{
	int[][] neighbors = new int[4][2];
	neighbors[0][0] = row - 1;
	neighbors[0][1] = col;
	
	neighbors[1][0] = row + 1;
	neighbors[1][1] = col;
	
	neighbors[2][0] = row;
	neighbors[2][1] = col - 1;
	
	neighbors[3][0] = row;
	neighbors[3][1] = col + 1;
	
	return neighbors;
}

public static int[][] neighbors (int row, int col)
{
	int[][] neighbors = new int[8][2];
	neighbors[0][0] = row - 2;
	neighbors[0][1] = col - 1;
	
	neighbors[1][0] = row + 2;
	neighbors[1][1] = col - 1;
	
	neighbors[2][0] = row - 2;
	neighbors[2][1] = col + 1;
	
	neighbors[3][0] = row + 2;
	neighbors[3][1] = col + 1;
	
	neighbors[4][0] = row - 1;
	neighbors[4][1] = col - 2;
	
	neighbors[5][0] = row + 1;
	neighbors[5][1] = col - 2;
	
	neighbors[6][0] = row - 1;
	neighbors[6][1] = col + 2;
	
	neighbors[7][0] = row + 1;
	neighbors[7][1] = col + 2;
	
	return neighbors;
}

public static int min(int[][] distances)
{
	int min = Integer.MAX_VALUE;
	for(int i = 0; i < distances.length; i++)
	{
		for(int j = 0; j < distances[0].length; j++)
		{
			if(distances[i][j] < min && distances[i][j] != 0)
			{
				min = distances[i][j];
			}
		}
	}
	if(min == Integer.MAX_VALUE)
	{
		return 0;
	}
	return min;
}

}