/*
ID: bdsomme1
LANG: JAVA
TASK: maze1
*/
import java.io.*;
import java.util.*;

class maze1 {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));

StringTokenizer reader = new StringTokenizer(f.readLine());
int width = Integer.parseInt(reader.nextToken());
int height = Integer.parseInt(reader.nextToken());
char[][] input = new char[height * 2 + 1][width * 2 + 1];
for(int i = 0; i <= 2*height; i++)
{
	String line = f.readLine();
	for(int j = 0; j <= 2*width; j++)
	{
		input[i][j] = line.charAt(j);
	}
}

int[][][] adj = new int[height][width][4];
ArrayList<int[]> exits = new ArrayList<>();
for(int i = 0; i < height; i++)
{
	int ci = 2*i + 1;
	for(int j = 0; j < width; j++)
	{
		
		int cj = 2*j + 1;
		if (input[ci - 1][cj] == ' ')
		{
			
			if (i == 0)
			{
				int[] exit = {i, j};
				exits.add(exit);
			}
			else
			{
				adj[i][j][0] = 1;
			}
		}
		if (input[ci + 1][cj] == ' ')
		{
			
			if (i == height-1)
			{
				int[] exit = {i, j};
				exits.add(exit);
			}
			else
			{
				adj[i][j][2] = 1;
			}
		}
		if (input[ci][cj+1] == ' ')
		{
			
			if (j == width-1)
			{
				int[] exit = {i, j};
				exits.add(exit);
			}
			else
			{
				adj[i][j][1] = 1;
			}
		}
		if (input[ci][cj-1] == ' ')
		{
			
			if (j == 0)
			{
				int[] exit = {i, j};
				exits.add(exit);
			}
			else
			{
				adj[i][j][3] = 1;
			}
		}
	}
}
int[][] lengths = solve(adj, exits);
int max = 0;
for(int i = 0; i < height; i++)
{
	for(int j = 0; j < width; j++)
	{
		if (lengths[i][j] > max)
		{
			max = lengths[i][j];
		}
	}
}

out.println(max);
out.close();

}

public static int[][] solve (int[][][] adj, ArrayList<int[]> exits)
{
	int[][] lengths = new int[adj.length][adj[0].length];
	lengths[exits.get(0)[0]][exits.get(0)[1]] = 1;
	if (exits.size() > 1)
	{
		lengths[exits.get(1)[0]][exits.get(1)[1]] = 1;
	}
	LinkedList<int[]> q = new LinkedList<>();
	q.add(exits.get(0));
	if (exits.size() > 1)
	{
		q.add(exits.get(1));
	}
	while(!q.isEmpty())
	{
		int[] current = q.remove();
		int ci = current[0];
		int cj = current[1];
		int length = lengths[ci][cj];
		if(adj[ci][cj][0] == 1)
		{
			if(lengths[ci - 1][cj] == 0 || lengths[ci - 1][cj] > length + 1)
			{
				lengths[ci - 1][cj] = length + 1;
				int[] boi = {ci - 1, cj};
				q.add(boi);
			}
		}
		if(adj[ci][cj][1] == 1)
		{
			if(lengths[ci][cj+1] == 0 || lengths[ci][cj+1] > length + 1)
			{
				lengths[ci][cj+1] = length + 1;
				int[] boi = {ci, cj+1};
				q.add(boi);
			}
		}
		if(adj[ci][cj][2] == 1)
		{
			if(lengths[ci + 1][cj] == 0 || lengths[ci + 1][cj] > length + 1)
			{
				lengths[ci + 1][cj] = length + 1;
				int[] boi = {ci + 1, cj};
				q.add(boi);
			}
		}
		if(adj[ci][cj][3] == 1)
		{
			if(lengths[ci][cj-1] == 0 || lengths[ci][cj-1] > length + 1)
			{
				lengths[ci][cj-1] = length + 1;
				int[] boi = {ci, cj-1};
				q.add(boi);
			}
		}
	}
	return lengths;
}

}