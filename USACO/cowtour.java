/*
ID: bdsomme1
LANG: JAVA
TASK: cowtour
*/
import java.io.*;
import java.util.*;

class cowtour {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
    
int num = Integer.parseInt(f.readLine());
int[][] pastures = new int[num][2];
for (int i = 0; i < num; i++)
{
	StringTokenizer reader = new StringTokenizer(f.readLine());
	int[] temp = new int[2];
	temp[0] = Integer.parseInt(reader.nextToken());
	temp[1] = Integer.parseInt(reader.nextToken());
}
int[][] adj = new int[num][num];
double[][] distance = new double[num][num];
for (int i = 0; i < num; i++)
{
	String boi = f.readLine();
	for(int j = 0; j < num; j++)
	{
		adj[i][j] = Integer.parseInt(boi.substring(j, j+ 1));
		distance[i][j] = Math.hypot(pastures[i][0] = pastures[j][0]
				, pastures[i][1] - pastures[j][1]);
	}
}
double min = Integer.MAX_VALUE;
for(int i = 0; i < num; i++)
{
	for(int j = 0; j < i; j++)
	{
		double bois = diameter(pastures, adj, i, j, distance);
		if (bois < min)
		{
			min = bois;
		}
	}
}
out.println(min);
out.close();
}
  
  public static double diameter(int[][] pastures, int[][] adj, int in, int jn,
		  double[][] distances)
  {
	  double[][] betterdistances = distances.clone();
	  boolean change = true;
	  while (change)
	  {
		  change = false;
	  for(int i = 0; i < pastures.length - 1; i++)
	  {
		  for(int j = i + 1; j < pastures.length; j++)
		  {
			  for (int k = 0; k < pastures.length; k++)
			  {
				  if ((adj[i][k] == 1 || (i == in && k == jn)|| (k == in && i == jn)) &&
						  (adj[k][j] == 1 || (k == in && j == jn)|| (j == in && k == jn)))
				  {
					  if (betterdistances[i][k] + betterdistances[k][j] < betterdistances[i][j] ||
							  betterdistances[j][k] + betterdistances[k][i]< betterdistances[j][i]
									  && k != i && k != j)
					  {
						  betterdistances[i][j] = betterdistances[i][k] + betterdistances[k][j];
						  betterdistances[j][i]= betterdistances[j][k] + betterdistances[k][i];
						  change = true;
					  }
				  }
			  }
		  }
	  }
	  }
	  double max = 0;
	  for(int i = 0; i < pastures.length; i++)
	  {
	  	for(int j = 0; j < i; j++)
	  	{
	  		if (betterdistances[i][j] > max)
	  		{
	  			max = betterdistances[i][j];
	  		}
	  	}
	  }
	  return max;
	  
  }
  
}