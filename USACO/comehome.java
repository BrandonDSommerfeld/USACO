/*
ID: bdsomme1
LANG: JAVA
TASK: comehome
*/
import java.io.*;
import java.util.*;

class comehome {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
    
int connection = Integer.parseInt(f.readLine());
int[][] connections = new int[52][52];
for(int i = 0; i < connection; i++)
{
	StringTokenizer reader= new StringTokenizer(f.readLine());
	char first = reader.nextToken().charAt(0);
	char second = reader.nextToken().charAt(0);
	int length = Integer.parseInt(reader.nextToken());
	if (first > 96)
	{
		first -= 97;
	}
	else
	{
		first -= 39;
	}
	if (second > 96)
	{
		second -= 97;
	}
	else
	{
		second -= 39;
	}
	if (connections[first][second] == 0 || length < connections[first][second])
	{
	connections[first][second] = length;
	connections[second][first] = length;
	}
}

int[][] shortest = algorithm(connections);
int min = Integer.MAX_VALUE;
int place = 0;
for(int i = 26; i < 51; i++)
{
	if(shortest[51][i] != 0 && shortest[51][i] < min)
	{
		min = shortest[51][i];
		place = i;
	}
}
place += 39;
char c = (char) place;
out.println(c + " " + min);
out.close();
}

public static int[][] algorithm (int[][] distance)
{
	int[][] distances = distance.clone();
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
}
