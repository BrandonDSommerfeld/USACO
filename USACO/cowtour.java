/*
ID: bdsomme1
LANG: JAVA
TASK: cowtour
*/
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class cowtour {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
    
int num = Integer.parseInt(f.readLine());
int[][] pastures = new int[num][2];
for (int i = 0; i < num; i++)
{
	StringTokenizer reader = new StringTokenizer(f.readLine());
	pastures[i][0] = Integer.parseInt(reader.nextToken());
	pastures[i][1] = Integer.parseInt(reader.nextToken());
}
double[][] distance = new double[num][num];
for (int i = 0; i < num; i++)
{
	String boi = f.readLine();
	for(int j = 0; j < num; j++)
	{
		int connected = Integer.parseInt(boi.substring(j, j+ 1));
		if (connected == 1)
		{
		distance[i][j] = Math.hypot(pastures[i][0] - pastures[j][0]
				, pastures[i][1] - pastures[j][1]);
			}
		else
		{
			distance[i][j] = 0;
			}
	}
}




double[][] shortest = algorithm(distance);
ArrayList<int[]> possible = new ArrayList<>();
for(int i = 0; i < num; i++)
{
	for(int j = 0; j < i; j++)
	{
		if(shortest[i][j] == 0)
		{
			int[] temp = new int[2];
			temp[0] = i;
			temp[1] = j;
			possible.add(temp);
		}
	}
}


double lowest = Integer.MAX_VALUE;
for(int i = 0; i < possible.size(); i++)
{
	double[][] tempd = shortest.clone();
	int[] extract = possible.get(i);
	int first = extract[0];
	int second = extract[1];
	double d = Math.hypot(pastures[first][0] - pastures[second][0]
				, pastures[first][1] - pastures[second][1]);
	tempd[first][second] = d;
	tempd[second][first] = d;
	for(int c = 0; c < num; c++)
	{
		for(int boi = 0; boi < num; boi++)
		{
			if(tempd[c][boi] == 0 && shortest[c][first] != 0 && shortest[second][boi] != 0 && c != boi)
			{
				tempd[c][boi] = shortest[c][first] + shortest[second][boi] + d;
			}
			else if(tempd[c][boi] == 0 && shortest[first][c] != 0 && shortest[boi][second] != 0 && c != boi)
			{
				tempd[c][boi] = shortest[first][c] + shortest[boi][second] + d;
			}
			else if(tempd[c][boi] == 0 && shortest[first][c] != 0 && shortest[second][boi] != 0 && c != boi)
			{
				tempd[c][boi] = shortest[first][c] + shortest[second][boi] + d;
			}
			else if(tempd[c][boi] == 0 && shortest[c][first] != 0 && shortest[boi][second] != 0 && c != boi)
			{
				tempd[c][boi] = shortest[c][first] + shortest[boi][second] + d;
			}
		}
	}
	double diameter = findmax(tempd);
	if (diameter < lowest)
	{
		System.out.println();
		System.out.println(first + " " + second);
		System.out.println();
		lowest = diameter;
		
		for(int succ = 0; succ < num; succ++)
		{
			for(int succc = 0; succc < num; succc++)
			{
				System.out.print(tempd[succ][succc] + " ");
			}
			System.out.println();
		}
		
	}
}

DecimalFormat format = new DecimalFormat("#######################.000000");
out.println(format.format(lowest));
out.close();
}


public static double[][] algorithm (double[][] distance)
{
	double[][] distances = distance.clone();
	int num = distance.length;
	boolean change = true;
	while (change)
	{
	change = false;
	for(int k = 0; k < num; k++)
{
	for(int i = 0; i < num; i++)
	{
		for(int j = 0; j < num; j++)
		{
			if((distances[i][j] == 0 || distances[i][k] + distances[k][j] < distances[i][j]) && distances[i][k] != 0 && distances[k][j] != 0 && i != j)
			{
				distances[i][j] = distances[i][k] + distances[k][j];
				change = true;
			}
		}
	}
}
}
return distances;

}

public static double findmax (double[][] distances)
{
double max = 0;
for (int i = 0; i < distances.length; i++)
{
	for(int j = 0; j < distances.length; j++)
	{
		if (distances[i][j] > max)
		{
			max = distances[i][j];
		}
	}
}

return max;
}
}
