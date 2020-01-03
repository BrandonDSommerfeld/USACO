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
int[] ways = new int[maxValue + 1];
for(Integer num: values)
{
	ways[num] = 1;
}
for(int i = 1; i <= maxValue; i++)
{
	int tempy = ways[i];
	if (tempy != total)
	{
		if(tempy != 0)
		{
			for(Integer num: values)
			{
				if(ways[i + num] == 0 || ways[i + num] > tempy + 1)
				{
					ways[i + num] = tempy + 1;
				}
			}
		}
		else
		{
			out.println(i - 1);
			break;
		}
	}
	if(i == maxValue)
	{
		out.println(maxValue);
	}
}
out.close();
  }
}
   
