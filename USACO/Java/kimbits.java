/*
ID: bdsomme1
LANG: JAVA
TASK: kimbits
*/
import java.io.*;
import java.util.*;

class kimbits {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("kimbits.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int length = Integer.parseInt(reader.nextToken());
int number = Integer.parseInt(reader.nextToken());
long index = Long.parseLong(reader.nextToken());

long place = 1;
long count = 0;
int onesLeft = number;
String building = "";
while (count != index && place <= length)
{
	int tempy = 0;
	for(int i = 0; i <= onesLeft; i++)
	{
		tempy += combinations(length - place, i);
	}
	if(count + tempy < index)
	{
		building += "1";
		count += tempy;
		place++;
		onesLeft--;
	}
	else
	{
		building += "0";
		place++;
	}
}
out.println(building);
out.close();
}

public static long combinations(long c, long r)
{
	if(r == 0)
	{
		return 1;
	}	
	long ongoing = 1;
	for(int i = 1; i < r; i++)
	{
		ongoing *= (c - i);
		ongoing /= i;
	}
	ongoing *= c;
	ongoing /= r;
	return ongoing;
}

}

