/*
ID: bdsomme1
LANG: JAVA
TASK: butter
*/
import java.io.*;
import java.util.*;

class butter{
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("butter.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int cows = Integer.parseInt(reader.nextToken());
int pastures = Integer.parseInt(reader.nextToken());
int paths = Integer.parseInt(reader.nextToken());
int[] starting = new int[cows];
for(int i = 0; i < cows; i++)
{
	starting[i] = Integer.parseInt(f.readLine());
}
int[][] lengths = new int[pastures + 1][pastures + 1];
ArrayList<Integer>[] adj = new ArrayList[pastures + 1];
for(int i = 0; i <= pastures; i++)
{
	adj[i] = new ArrayList<>();
}
for(int i = 0; i < paths; i++)
{
	reader = new StringTokenizer(f.readLine());
	int first = Integer.parseInt(reader.nextToken());
	int second = Integer.parseInt(reader.nextToken());
	int distance= Integer.parseInt(reader.nextToken());
	lengths[first][second] = distance;
	lengths[second][first] = distance;
	adj[first].add(second);
	adj[second].add(first);
}
lengths = algorithm(lengths, adj, starting);
int min = Integer.MAX_VALUE;
for(int i = 1; i <= pastures; i++)
{
	int total = 0;
	for(int j = 0; j < cows; j++)
	{
		total += lengths[starting[j]][i];
	}
	if(total < min)
	{
		min = total;
	}
}
out.println(min);
out.close();
}

public static int[][] algorithm (int[][] distance, ArrayList<Integer>[] adj, int[] starting)
{
	int[][] distances = new int[distance.length][distance.length];
	for(int i = 0; i < starting.length; i++)
	{
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(starting[i]);
		while(queue.peek() != null)
		{
			int current = queue.remove();
			for(int j = 0; j < adj[current].size(); j++)
			{
				if((distances[starting[i]][adj[current].get(j)] > distances[starting[i]][current] + distance[current][adj[current].get(j)] || distances[starting[i]][adj[current].get(j)] == 0) && adj[current].get(j) != starting[i])
				{
					queue.add(adj[current].get(j));
					distances[starting[i]][adj[current].get(j)] = distances[starting[i]][current] + distance[current][adj[current].get(j)];
				}
			}
		}
	}
	return distances;
}

}
