/*
ID: bdsomme1
LANG: JAVA
TASK: lineup
*/
import java.io.*;
import java.util.*;

class lineup {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
int conditions= Integer.parseInt(f.readLine());
int[][] adj = new int[8][8];
ArrayList<String> names = new ArrayList<>();
names.add("Beatrice");
names.add("Belinda");
names.add("Bella");
names.add("Bessie");
names.add("Betsy");
names.add("Blue");
names.add("Buttercup");
names.add("Sue");
for(int i = 0; i < conditions; i++)
{
	StringTokenizer reader = new StringTokenizer(f.readLine());
	int first = names.indexOf(reader.nextToken());
	reader.nextToken();
	reader.nextToken();
	reader.nextToken();
	reader.nextToken();
	int second = names.indexOf(reader.nextToken());
	adj[first][second] = 1;
	adj[second][first] = 1;
}

String first = best(adj);
for(int i = 0; i < 8; i++)
{
	int current = Integer.parseInt(first.substring(i, i + 1));
	out.println(names.get(current));
}

out.close();
}
  
public static String best(int[][] adj)
{
	ArrayList<String> sequences = generate(8, new ArrayList<>());
	Collections.sort(sequences);
	for(int i = 0; i < sequences.size(); i++)
	{
		if(check(sequences.get(i), adj))
		{
			return sequences.get(i);
		}
	}
	return null;
}

public static boolean check(String seq, int[][] adj)
{
	for(int i = 0; i < 8; i++)
	{
		try
		{
			int current = Integer.parseInt(seq.substring(i, i + 1));
			int n1 = -1, n2 = -1;
			for(int j = 0; j < 8; j++)
			{
				if(adj[current][j] == 1)
				{
					if(n1 == -1)
					{
						n1 = j;
					}
					else
					{
						n2 = j;
					}
				}
			}
			if(n2 != -1)
			{
				if((i == 0 || i == 7))
				{
					return false;
				}
				int ne1 = Integer.parseInt(seq.substring(i-1, i));
				int ne2 = Integer.parseInt(seq.substring(i + 1, i + 2));
				if((n1 == ne1 && n2 == ne2) || (n1 == ne2 && n2 == ne1))
				{
					
				}
				else
				{
					return false;
				}
			}
			else if (n1 != -1)
			{
				if(i == 0)
				{
					int ne1 = Integer.parseInt(seq.substring(i + 1, i + 2));
					if(n1 != ne1)
					{
						return false;
					}
				}
				else if (i == 7)
				{
					int ne1 = Integer.parseInt(seq.substring(i - 1, i));
					if(n1 != ne1)
					{
						return false;
					}
				}
				else
				{
					int ne1 = Integer.parseInt(seq.substring(i-1, i));
					int ne2 = Integer.parseInt(seq.substring(i + 1, i + 2));
					if(n1 == ne1 || n1 == ne2)
					{
						
					}
					else
					{
						return false;
					}
				}
			}
		}
		catch (Exception e)
		{
			
		}
	}
	return true;
}

public static ArrayList<String> generate (int size, ArrayList<Integer> exclude)
{
	ArrayList<String> sequences = new ArrayList<>();
	if(size == 0)
	{
		sequences.add("");
		return sequences;
	}
	for(int i = 0; i < 8; i++)
	{
		if(exclude.indexOf(i) == -1)
		{
			ArrayList<Integer> copy = (ArrayList<Integer>) exclude.clone();
			copy.add(i);
			ArrayList<String> previous = generate(size - 1, copy);
			for(int j = 0; j < previous.size(); j++)
			{
				sequences.add(i + previous.get(j));
			}
		}
	}
	return sequences;
}
  
}