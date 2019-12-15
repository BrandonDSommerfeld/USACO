/*
ID: bdsomme1
LANG: JAVA
TASK: gymnastics
*/
import java.io.*;
import java.util.*;

class gymnastics {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int sessions = Integer.parseInt(reader.nextToken());
int cows = Integer.parseInt(reader.nextToken());
int[][] rankings = new int[sessions][cows];
for(int i = 0; i < sessions; i++)
{
	reader = new StringTokenizer(f.readLine());
	for(int j = 0; j < cows; j++)
	{
		rankings[i][j] = Integer.parseInt(reader.nextToken());
	}
	
}
out.println(pairs(rankings));
out.close();
}
  
public static int pairs (int[][] rankings)
{
	int count = 0;
	int rows = rankings.length;
	int cols = rankings[0].length;
	for(int j = 0; j < cols - 1; j++)
	{
		for(int other = j + 1; other < cols; other++)
		{
			int pair1 = rankings[0][j];
			int pair2 = rankings[0][other];
			boolean works = true;
			for(int i = 1; i < rows && works; i++)
			{
				for(int col = 0; col < cols; col++)
				{
					if(rankings[i][col] == pair1)
					{
						break;
					}
					else if (rankings[i][col] == pair2)
					{
						works = false;
						break;
					}
				}
			}
			if(works)
			{
				count++;
			}
		}
	}
	
	
	return count;
}
  
}
    
        