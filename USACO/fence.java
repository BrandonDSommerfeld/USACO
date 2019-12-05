/*
ID: bdsomme1
LANG: JAVA
TASK: fence
*/
import java.io.*;
import java.util.*;

class fence {
	private static int[] path;
	private static int position;
  public static void main (String [] args) throws IOException {
  BufferedReader f = new BufferedReader(new FileReader("fence.in"));
  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
  int lines = Integer.parseInt(f.readLine());
	path = new int[lines + 1];
	position = 0;
  ArrayList<Integer>[] adj = new ArrayList[501];
  for(int i = 0; i <= 500; i++)
  {
      adj[i] = new ArrayList<>();
    }
  for(int i = 0; i < lines; i++)
  {
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int first = Integer.parseInt(reader.nextToken());
    int second = Integer.parseInt(reader.nextToken());
    adj[first].add(second);
    adj[second].add(first);
  }
  for(int i = 1; i <= 500; i++)
  {
      Collections.sort(adj[i]);
  }
  ArrayList<Integer> odds = degree(adj);
	int first = 0;
	if(odds.size() != 0)
	{
		first = odds.get(0);
	}
	else
	{
		for(int i = 1; i < adj.length; i++)
		{
			if(adj[i].size() != 0)
			{
				first = i;
				break;
			}
		}
	}
  tour(adj, first);
  for(int i = path.length - 1; i >= 0; i--)
  {
      out.println(path[i]);
  }
  

  out.close();
  }
  
  public static void tour (ArrayList<Integer>[] adj, int node)
  {
      
			if(adj[node].size() == 0)
			{
				path[position] = node;
				position++;
			}
			else
			{
				for(int i = 0; i < adj[node].size();)
				{
					int next = adj[node].get(i);
					adj[next].remove(new Integer(node));
					adj[node].remove(0);
					tour(adj, next);
				}
				path[position] = node;
				position++;
			}
  }
  
  public static ArrayList<Integer> degree(ArrayList<Integer>[] adj)
  {
      ArrayList<Integer> temp = new ArrayList<>();
      for(int i = 1; i < adj.length; i++)
      {
          if(adj[i].size() % 2 == 1)
          {
              temp.add(i);
          }
      }
      return temp;
  }

}
