/*
ID: bdsomme1
LANG: JAVA
TASK: spin
*/
import java.io.*;
import java.util.*;

class spin{
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("spin.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
int[] speeds = new int[5];
ArrayList<ArrayList<Integer>>[] wedges = new ArrayList[5];

for(int i = 0; i < 5; i++)
{
	StringTokenizer reader = new StringTokenizer(f.readLine());
	speeds[i] = Integer.parseInt(reader.nextToken());
	reader.nextToken();
	ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
	while(reader.hasMoreTokens())
	{
		int start = Integer.parseInt(reader.nextToken());
		int size = Integer.parseInt(reader.nextToken());
		ArrayList<Integer> wedge = new ArrayList<>();
		wedge.add(start);
		wedge.add(size);
		temp.add(wedge);
	}
	wedges[i] = temp;
}

ArrayList<ArrayList<Integer>>[] start = wedges.clone();
boolean stop = false;
int time = 0;
while(!stop)
{
	if(overlap(wedges))
	{
		out.println(time);
		break;
	}
	advance(wedges, speeds);
	if(wedges.equals(start))
	{
		stop = true;
	}
}
if(stop)
{
	out.println("none");
}


out.close();

}

public static void advance(ArrayList<ArrayList<Integer>>[] wedges, int[] speeds)
{
	for(int i = 0; i < 5; i++)
	{
		ArrayList<ArrayList<Integer>> wedge = wedges[i];
		for(int j = 0; j < wedge.size(); j++)
		{
			wedge.get(j).set(0, wedge.get(j).get(0) + speeds[i]);
		}
	}
}

public static boolean overlap(ArrayList<ArrayList<Integer>>[] wedges)
{
	ArrayList<ArrayList<Integer>> gaps = new ArrayList<>();
	ArrayList<Integer> boi = new ArrayList<>();
	boi.add(0);
	boi.add(359);
	gaps.add(boi);
	for(int i = 0; i < 5; i++)
	{
		ArrayList<ArrayList<Integer>> wheel = wedges[i];
		ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
		for(int j = 0; j < wheel.size(); j++)
		{
			for(int k = 0; k < gaps.size(); k++)
			{
				int start1 = wheel.get(j).get(0);
				int end1 = wheel.get(j).get(0) + wheel.get(j).get(1);
				int start2 = gaps.get(k).get(0);
				int end2 = gaps.get(k).get(0) + gaps.get(k).get(1);
				
			}
		}
	}
	
	
	
	
	return (gaps.size() != 0);
}


}


