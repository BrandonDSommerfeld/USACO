/*
ID: bdsomme1
LANG: JAVA
TASK: schlnet
*/
import java.io.*;
import java.util.*;

class schlnet{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("schlnet.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("schlnet.out")));
    
    int schools = Integer.parseInt(f.readLine());
    boolean[][] adj = new boolean[schools][schools];
    for(int i = 0; i < schools; i++)
    {
    	StringTokenizer reader = new StringTokenizer(f.readLine());
    	while(reader.hasMoreTokens())
    	{
    		int receiver = Integer.parseInt(reader.nextToken());
    		if(receiver != 0)
    		{
    			adj[i][receiver-1] = true;
    		}
    	}
    }
    
    int[][] totals = algorithm(adj, schools);
    out.println(needed(totals, adj, schools));
    out.println(addon(totals, adj, schools));
    
    out.close();
	}
	
	public static boolean finished (int[][] totals, int size)
	{
		for(int i = 0; i < size; i++)
		{
			if(totals[i][0] != size-1 || totals[i][1] != size-1)
			{
				return false;
			}
		}
		return true;
	}
	
	public static int addon(int[][] totals, boolean[][] adj, int size)
	{
		int count = 0;
		while(!finished(totals, size))
		{
			int lowest = 0, highest = size-1;
			for(int i = 0; i < size; i++)
			{
				if(totals[i][0] > totals[highest][0])
				{
					highest = i;
				}
				if(totals[i][0] < totals[lowest][0] || (totals[i][0] == totals[lowest][0] && totals[i][1] < totals[lowest][1]))
				{
					lowest = i;
				}
			}
			adj[lowest][highest] = true;
			count++;
			totals = algorithm(adj, size);
		}
		
		
		return count;
	}
	
	
	public static int needed (int[][] totals, boolean[][] adj, int size)
	{
		int count = 0;
		boolean[] visited = new boolean[size];
		while(!done(visited))
		{
			int max = -1;
			int place = -1;
			for(int i = 0; i < size; i++)
			{
				if(totals[i][0] > max && !visited[i])
				{
					max = totals[i][0];
					place = i;
				}
			}
			
			if(place != -1)
			{
				count++;
				Stack<Integer> queue = new Stack<>();
				queue.push(place);
				while(!queue.empty())
				{
					int current = queue.pop();
					if(!visited[current])
					{
						visited[current] = true;
						for(int j = 0; j < size; j++)
						{
							if(adj[current][j] && !visited[j])
							{
								queue.push(j);
							}
						}
					}
					
				}
			}
		}
		
		return count;
	}
	
	public static boolean done (boolean[] visited)
	{
		for(int i = 0; i < visited.length; i++)
		{
			if(!visited[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static int[][] algorithm (boolean[][] adj, int size)
	{
		int[][] temp = new int[size][2];
		
		for(int i = 0; i < size; i++)
		{
			boolean[] visited = new boolean[size];
			explore(temp, i, adj, size, i, visited);
		}
		
		return temp;
	}
	
	public static void explore (int[][] inout, int location, boolean[][] adj, int size, int original, boolean[] visited)
	{
		visited[location] = true;
		if(location != original)
		{
			inout[location][1]++;
			inout[original][0]++;
		}
		for(int i = 0; i < size; i++)
		{
			if(adj[location][i] && !visited[i])
			{
				explore(inout, i, adj, size, original, visited);
			}
		}
	}
}
    