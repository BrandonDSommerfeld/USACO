/*
ID: bdsomme1
LANG: JAVA
TASK: stamps
*/
import java.io.*;
import java.util.*;

class stamps {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("stamps.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int total = Integer.parseInt(reader.nextToken());
HashSet<Integer> values = new HashSet<>();
String line = f.readLine();
int max = 0;
while(line != null)
{
	reader = new StringTokenizer(line);
	while(reader.hasMoreTokens())
	{
		int temp = Integer.parseInt(reader.nextToken());
		values.add(temp);
		if (temp > max)
		{
			max= temp;
		}
	}
	line = f.readLine();
}
int maxValue = total*max;
boolean[][] possible = new boolean[maxValue + 1][total + 1];
possible[0][0] = true;
for(Integer num: values)
{
	possible[num][1] = true;
}
out.close();
  }
}
    