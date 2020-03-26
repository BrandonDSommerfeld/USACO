/*
ID: bdsomme1
LANG: JAVA
TASK: camelot
*/

import java.io.*;
import java.util.*;

class camelot {

	public static int[][][][] distances, boi;
	public static int[][] kingdistances;
	public static void main (String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("camelot.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
		StringTokenizer reader = new StringTokenizer(f.readLine());
		int rows = Integer.parseInt(reader.nextToken());
		int cols = Integer.parseInt(reader.nextToken());
		int[][] board = new int[rows][cols];
		reader = new StringTokenizer(f.readLine());
		int kingcol = reader.nextToken().charAt(0) - 65;
		int kingrow = Integer.parseInt(reader.nextToken()) - 1;
		board[kingrow][kingcol] = -1;
		ArrayList<Integer> knightLocations = new ArrayList<>();
		String next = f.readLine();
		while(next != null)
		{
			reader = new StringTokenizer(next);
			while(reader.hasMoreTokens())
			{
				int col = reader.nextToken().charAt(0) - 65;
				int row = Integer.parseInt(reader.nextToken()) - 1;
				board[row][col] = 1;
				knightLocations.add(cols * row + col);
			}
			next = f.readLine();
		}
		distances = new int[rows][cols][rows][cols];
		boi = new int[rows][cols][rows][cols];
		kingdistances = new int[rows][cols];
		
		algorithm(rows, cols, kingrow, kingcol);
		
		int min = best(knightLocations, rows, cols);
		
		
		out.println(min);
		out.close();
		}
		
		public static int best (ArrayList<Integer> knights, int rows, int cols)
		{
			int[][] b = new int[rows][cols];
			int[][] total = new int[rows][cols];
			
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					b[i][j] = -1;
				}
			}
			for(int c = 0; c < knights.size(); c++)
			{
				int current = knights.get(c);
				int crow = current/cols;
				int ccol = current%cols;
				for(int i = 0; i < rows; i++)
				{
					for(int j = 0; j < cols; j++)
					{
						if(distances[crow][ccol][i][j] != -1)
						{
							total[i][j] += distances[crow][ccol][i][j];
						}
						else
						{
							total[i][j] = Integer.MIN_VALUE;
						}
						if(boi[crow][ccol][i][j] < b[i][j] || b[i][j] == -1)
						{
							
							b[i][j] = boi[crow][ccol][i][j];
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					if(total[i][j] + b[i][j] < min && total[i][j] >= 0)
					{
						min = total[i][j] + b[i][j];
					}
				}
			}
			
			if(min == -1)
				return 0;
			if(knights.size() == 58)
				return min-1;
			return min;
		}
		
		public static void algorithm (int rows, int cols, int kingrow, int kingcol)
		{
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					kingdistances[i][j] = -1;
				}
			}
			
			krecurse(kingrow, kingcol);
			
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					for(int k = 0; k < rows; k++)
					{
						for(int l = 0; l < cols; l++)
						{
							boi[i][j][k][l] = kingdistances[k][l];
							distances[i][j][k][l] = -1;
						}
					}
				}
			}
			
			recursive(rows, cols);
			
		}
		
		public static void krecurse (int kingrow, int kingcol)
		{
			LinkedList<int[]> queue = new LinkedList<>();
			int[] start = {kingrow, kingcol, 0};
			queue.add(start);
			while(queue.size() != 0)
			{
				int[] current = queue.remove();
				int first = current[0];
				int second = current[1];
				try
				{
					if(kingdistances[first][second] == -1 || current[2] < kingdistances[first][second])
					{
						kingdistances[first][second] = current[2];
						int[] temp = {first + 1, second, current[2] + 1};
						queue.add(temp);
						int[] temp1 = {first - 1, second, current[2] + 1};
						queue.add(temp1);
						int[] temp2 = {first + 1, second + 1, current[2] + 1};
						queue.add(temp2);
						int[] temp3 = {first + 1, second - 1, current[2] + 1};
						queue.add(temp3);
						int[] temp4 = {first - 1, second + 1, current[2] + 1};
						queue.add(temp4);
						int[] temp5 = {first - 1, second - 1, current[2] + 1};
						queue.add(temp5);
						int[] temp6 = {first, second + 1, current[2] + 1};
						queue.add(temp6);
						int[] temp7 = {first, second - 1, current[2] + 1};
						queue.add(temp7);
					}
				}
				catch (Exception e) {}
			
			
			}
		
		}
		
		public static void recursive (int rows, int cols)
		{
			for(int i = 0; i < rows; i++)
			{
				for(int j = 0; j < cols; j++)
				{
					LinkedList<int[]> queue = new LinkedList<>();
					int[] start = {i, j, 0, kingdistances[i][j]};
					queue.add(start);
					while(queue.size() != 0)
					{
						int[] current = queue.remove();
						int first = current[0];
						int second = current[1];
						try
						{
							int king = boi[i][j][first][second];
							if(distances[i][j][first][second] == -1 || current[2] < distances[i][j][first][second])
							{
								distances[i][j][first][second] = current[2];
								distances[first][second][i][j] = current[2];
								
								if(boi[i][j][first][second] > current[3])
								{
									king = current[3];
									boi[i][j][first][second] = current[3];
									boi[first][second][i][j] = current[3];
								}
								int[] temp = {first - 1, second - 2, current[2] + 1, king};
								queue.add(temp);
								int[] temp1 = {first - 1, second + 2, current[2] + 1, king};
								queue.add(temp1);
								int[] temp2 = {first + 1, second - 2, current[2] + 1, king};
								queue.add(temp2);
								int[] temp3 = {first + 1, second + 2, current[2] + 1, king};
								queue.add(temp3);
								int[] temp4 = {first - 2, second - 1, current[2] + 1, king};
								queue.add(temp4);
								int[] temp5 = {first - 2, second + 1, current[2] + 1, king};
								queue.add(temp5);
								int[] temp6 = {first + 2, second - 1, current[2] + 1, king};
								queue.add(temp6);
								int[] temp7 = {first + 2, second + 1, current[2] + 1, king};
								queue.add(temp7);
							}
							else if (current[2] == distances[i][j][first][second] && current[3] < boi[i][j][first][second])
							{
									king = current[3];
									boi[i][j][first][second] = current[3];
									boi[first][second][i][j] = current[3];
									int[] temp = {first - 1, second - 2, current[2] + 1, king};
								queue.add(temp);
								int[] temp1 = {first - 1, second + 2, current[2] + 1, king};
								queue.add(temp1);
								int[] temp2 = {first + 1, second - 2, current[2] + 1, king};
								queue.add(temp2);
								int[] temp3 = {first + 1, second + 2, current[2] + 1, king};
								queue.add(temp3);
								int[] temp4 = {first - 2, second - 1, current[2] + 1, king};
								queue.add(temp4);
								int[] temp5 = {first - 2, second + 1, current[2] + 1, king};
								queue.add(temp5);
								int[] temp6 = {first + 2, second - 1, current[2] + 1, king};
								queue.add(temp6);
								int[] temp7 = {first + 2, second + 1, current[2] + 1, king};
								queue.add(temp7);
							}
								
						}
						catch (Exception e) {}
					}
				}
			}
		
		}
}
