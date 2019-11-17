/*
ID: bdsomme1
LANG: JAVA
TASK: concom
*/
import java.io.*;
import java.util.*;
import javax.script.*;

class concom {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("concom.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
    
int companies = Integer.parseInt(f.readLine());
int[][] owners = new int[companies][3];
HashSet<Integer>[] subs = new HashSet[101];
for(int i = 1; i <= 100; i++)
{
	subs[i] = new HashSet<>();
	subs[i].add(i);
}
boolean[] possible = new boolean[101];
int[] percents = new int[101];
for (int i = 0; i < companies; i++)
{
	StringTokenizer reader = new StringTokenizer(f.readLine());
	int owner = Integer.parseInt(reader.nextToken());
	int owned = Integer.parseInt(reader.nextToken());
	int percent = Integer.parseInt(reader.nextToken());
	owners[i][0] = owner;
	owners[i][1] = owned;
	owners[i][2] = percent;
	if (percent > 50)
	{
		subs[owner].add(owned);
		possible[owned] = true;
	}
	else
	{
		percents[owned] += percent;
		if (percents[owned] > 50)
		{
			possible[owned] = true;
		}
	}
	
}

boolean[] change = new boolean[101];
while(evaluate(change))
{
	for (int i = 1; i <= 100; i++)
	{
		if (boi(subs[i], change))
		{
		change[i] = true;
		for (int j = 1; j <= 100; j++)
		{
			if (possible[j] && !subs[i].contains(j))
			{
				int o = 0;
				boolean great = false;
				for (int k = 0; k< companies && !great; k++)
				{
					if (subs[i].contains(owners[k][0]) && owners[k][1] == j)
					{
						o += owners[k][2];
					}
					if (o > 50)
					{
						great = true;
					}
				}
				if (o > 50)
				{
					subs[i].add(j);
					change[i] = false;
				}
			}
		}
		}
	}
}


for(int i = 1; i <= 100; i++)
{
	ArrayList<Integer> temp = new ArrayList<>();
	for (Integer num: subs[i])
	{
		if (i != num)
		{
			temp.add(num);
		}
	}
	Collections.sort(temp);
	for (int j = 0; j < temp.size(); j++)
	{
		out.println(i + " " + temp.get(j));
	}
}




out.close();
}

public static boolean evaluate(boolean[] change)
{
	for(int i = 1; i < 101; i++)
	{
		if (!change[i])
			return true;
	}
	return false;
}

public static boolean boi (HashSet<Integer> subs, boolean[] change)
{
	for (Integer num: subs)
	{
		if (!change[num])
			return true;
	}
	return false;
}

}