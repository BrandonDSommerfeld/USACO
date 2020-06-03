/*
ID: bdsomme1
LANG: JAVA
TASK: telecow
*/
import java.io.*;
import java.util.*;

class telecow{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("telecow.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("telecow.out")));
    
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int nodes = Integer.parseInt(reader.nextToken());
    int edges = Integer.parseInt(reader.nextToken());
    int start = Integer.parseInt(reader.nextToken()) - 1;
    int end = Integer.parseInt(reader.nextToken()) - 1;
    
    int[][] adj = new int[2 * nodes][2 * nodes];
    for(int i = 0 ; i < edges; i++)
    {
    	reader = new StringTokenizer(f.readLine());
    	int first = Integer.parseInt(reader.nextToken()) - 1;
    	int second = Integer.parseInt(reader.nextToken()) -1;
    	adj[2 * first][2 * second + 1] = 1;
    	adj[2 * second][2 * first + 1] = 1;
    }
    for(int i = 0; i < nodes; i++)
    {
    	adj[2 * i+1][2 * i] = 1;
    }
    
    int[] small = algorithm(adj, nodes, start, end);
    out.println(small.length);
    for(int i = 0 ; i < small.length; i++)
    {
    	out.print(small[i] + 1);
    	if(i != small.length - 1)
    	{
    		out.print(" ");
    	}
    }
    out.println();
    out.close();
	}
	
	public static int[] algorithm (int[][] adj, int nodes, int start, int end)
	{
		int[][] copy = new int[nodes*2][nodes*2];
		for(int row = 0; row < nodes * 2; row++)
		{
			for(int col = 0; col < nodes*2; col++)
			{
				copy[row][col] = adj[row][col];
			}
		}
		int cuts = netflow(copy, nodes*2, start*2, end*2 + 1);
		int[] output = new int[cuts];
		int current = cuts;
		int made = 0;
		for(int i = 0; i < nodes; i++)
		{
			if(i != start && i != end && made < cuts)
			{
				adj[i*2+1][i*2] = 0;
				copy = new int[nodes*2][nodes*2];
				for(int row = 0; row < nodes * 2; row++)
				{
					for(int col = 0; col < nodes*2; col++)
					{
						copy[row][col] = adj[row][col];
					}
				}
				int after = netflow(copy, nodes*2, start*2, end*2 + 1);
				if(after < current)
				{
					output[made] = i;
					current = after;
					made++;
				}
				else
				{
					adj[i*2+1][i*2] = 1;
				}
			}
				
		}
		return output;
	}
	
	public static int netflow(int[][] adj, int nodes, int start, int end)
	{
		int total = 0;
		int[] previous = new int[nodes];
		while(true)
		{
			int[] flow = new int[nodes];
			boolean[] visited = new boolean[nodes];
			flow[start] = 1000;
			while(true)
			{
				int maxflow = 0;
				int maxplace = -1;
				for(int i = 0; i < nodes; i++)
				{
					if(flow[i] > maxflow && !visited[i])
					{
						maxflow = flow[i];
						maxplace = i;
					}
				}
				if(maxplace == -1)
				{
					break;
				}
					visited[maxplace] = true;
					for(int i = 0; i < nodes; i++)
					{
						if(!visited[i])
						{
							int num = Math.min(maxflow, adj[maxplace][i]);
							if(num > flow[i])
							{
								flow[i] = num;
								previous[i] = maxplace;
							}
						}
					}
			}
			if(flow[end] == 0)
				break;
				
			total += flow[end];
			int i = end;
			while(i != start)
			{
				int p = previous[i];
				adj[p][i] -= flow[end];
				adj[i][p] += flow[end];
				i=p;
			}
		}
		return total;
	}
}
    