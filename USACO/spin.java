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
ArrayList<ArrayList<Integer>>[] start = new ArrayList[5];
for(int i = 0; i < 5; i++)
{
	StringTokenizer reader = new StringTokenizer(f.readLine());
	speeds[i] = Integer.parseInt(reader.nextToken());
	reader.nextToken();
	ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
	ArrayList<ArrayList<Integer>> boi = new ArrayList<>();
	while(reader.hasMoreTokens())
	{
		int starts = Integer.parseInt(reader.nextToken());
		int size = Integer.parseInt(reader.nextToken());
		ArrayList<Integer> wedge = new ArrayList<>();
		ArrayList<Integer> other = new ArrayList<>();
		wedge.add(starts);
		wedge.add(size);
		temp.add(wedge);
		other.add(starts);
		other.add(size);
		boi.add(other);
	}
	wedges[i] = temp;
	start[i] = boi;
}


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
	time++;
	
	
	if(equals(wedges,start) || time > 10000)
	{
		System.out.println(time);
		stop = true;
	}
}
if(stop)
{
	out.println("none");
}


out.close();

}

public static boolean equals (ArrayList<ArrayList<Integer>>[] wedges, ArrayList<ArrayList<Integer>>[] start)
{
	for(int i = 0; i < 5; i++)
	{
		for(int j = 0; j < wedges[i].size(); j++)
		{
			if (wedges[i].get(j).get(0) != start[i].get(j).get(0))
			{
				return false;
			}
		}
	}
	return true;
}

public static void advance(ArrayList<ArrayList<Integer>>[] wedges, int[] speeds)
{
	for(int i = 0; i < 5; i++)
	{
		ArrayList<ArrayList<Integer>> wedge = wedges[i];
		for(int j = 0; j < wedge.size(); j++)
		{
			wedge.get(j).set(0, (wedge.get(j).get(0) + speeds[i]) % 360);
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
				if(start1 >= start2 && end1 <= end2)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start1);
					
						gap.add(end1 - start1);
					
					
					temp.add(gap);
				}
				if (start2 >= start1 && end2 <= end1)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start2);
					
						gap.add(end2 - start2);
					
					
					temp.add(gap);
				}
				if(start1 >= start2 && start1 <= end2 && end1 >= end2)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start1);
					
						gap.add(end2 - start1);
					
					
					temp.add(gap);
				}
				if(start2 >= start1 && start2 <= end1 && end2 >= end1)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start2);
					
						gap.add(end1 - start2);
					
					
					temp.add(gap);
				}
				
				
				if(start1 + 360 >= start2 && end1 + 360 <= end2)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start1);
					
						gap.add((end1 - start1) % 360);
					
					
					temp.add(gap);
				}
				if (start2 + 360 >= start1 && end2 + 360 <= end1)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start2);
					
						gap.add((end2 - start2) % 360);
					
					
					temp.add(gap);
				}
				if(start1 + 360 >= start2 && start1 + 360 <= end2)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start1);
						gap.add((end2 - start1) % 360);
					
					
					temp.add(gap);
				}
				if(start2 + 360 >= start1 && start2 + 360 <= end1)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start2);

						gap.add((end1 - start2) % 360);
					
					
					temp.add(gap);
				}
				
				
				if(start1 >= start2 + 360 && end1 <= end2 + 360)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start1);
				
						gap.add((end1 - start1) % 360);
					
					
					temp.add(gap);
				}
				if (start2 >= start1 + 360 && end2 <= end1 + 360)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start2);
				
						gap.add((end2 - start2) % 360);
					
					
					temp.add(gap);
				}
				if(start1 >= start2 + 360 && start1 <= end2 + 360)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start1);
					
						gap.add((end2 - start1) % 360);
					
					
					temp.add(gap);
				}
				if(start2 >= start1 + 360 && start2 <= end1 + 360)
				{
					ArrayList<Integer> gap = new ArrayList<>();
					gap.add(start2);
						gap.add((end1 - start2) % 360);
					temp.add(gap);
				}
			}
		}
		gaps = temp;
	}
	
	
	return (gaps.size() != 0);
}


}



