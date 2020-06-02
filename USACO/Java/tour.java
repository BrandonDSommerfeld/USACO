/*
ID: bdsomme1
LANG: JAVA
TASK: tour
*/
import java.io.*;
import java.util.*;

class tour{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("tour.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tour.out")));
    
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int nodes = Integer.parseInt(reader.nextToken());
    int edges = Integer.parseInt(reader.nextToken());
    String[] cities = new String[nodes+1];
    for(int i = 1; i <= nodes; i++)
    {
    	cities[i] = f.readLine();
    }
    boolean[][] adj = new boolean[nodes+1][nodes+1];
    for(int i = 0; i < edges; i++)
    {
    	reader = new StringTokenizer(f.readLine());
    	String first = reader.nextToken();
    	String second = reader.nextToken();
    	int front = -1, back = -1;
    	for(int j = 1; j <= nodes; j++)
    	{
    		if(cities[j].equals(first))
    		{
    			front = j;
    		}
    		else if(cities[j].equals(second))
    		{
    			back = j;
    		}
    	}
    	
    	adj[front][back] = true;
    	adj[back][front] = true;
    }
    
    out.println(algorithm(adj, nodes));
    
    out.close();
	}
	
	public static int algorithm (boolean[][] adj, int n)
	{
		int[][] f = new int[n+1][n+1];
		f[1][1]=1;
		int ans=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=i+1;j<=n;j++)
			{
				for(int k=1;k<j;k++)
					if(adj[k][j])
					{
						if(k==i && i!=1) 
							continue;
						if(f[i][k]>0 && f[i][k]+1>f[i][j])
							f[i][j]=f[i][k]+1;
					}
				f[j][i]=f[i][j];
			}
			if(i==n)
			{
				if(f[n][n]-1>ans)
					ans=f[n][n]-1;
			}
			else
			if(adj[i][n] && f[i][n]>ans)
				ans=f[i][n];
		}
		
		return ans;
	}
}
    