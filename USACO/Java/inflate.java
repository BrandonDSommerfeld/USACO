/*
ID: bdsomme1
LANG: JAVA
TASK: inflate
*/
import java.io.*;
import java.util.*;

class inflate {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));
		StringTokenizer reader = new StringTokenizer(f.readLine());
		int minutes = Integer.parseInt(reader.nextToken());
		int categories = Integer.parseInt(reader.nextToken());
		ArrayList<ArrayList<Double>> data = new ArrayList<>();
		for(int i = 0; i < categories; i++)
		{
			reader = new StringTokenizer(f.readLine());
			int point = Integer.parseInt(reader.nextToken());
			int time = Integer.parseInt(reader.nextToken());
			ArrayList<Double> temp = new ArrayList<>();
			temp.add((double) point);
			temp.add((double) time);
			temp.add(((double) point)/time);
			add(data, temp);
		}
		int best = recursive(data, minutes, 0);
		out.println(best);
		out.close();

}


public static int recursive(ArrayList<ArrayList<Double>> data, int minutes, int start)
{
	if (minutes <= 0)
	{
		return 0;
	}
	if (start == data.size())
	{
		return 0;
	}
	if (!more(data, minutes, start))
	{
		return 0;
	}
	int time = (int) Math.round(data.get(start).get(1));
	int num = minutes / time;
	if (num != 0)
	{
	int first = ((int)(num * Math.round(data.get(start).get(0)))) + recursive(data, minutes - num * time, start + 1);
	int second = ((int) ((num - 1) * Math.round(data.get(start).get(0)))) + recursive(data, minutes - num * time + time, start + 1);
	ArrayList<Integer> bois = new ArrayList<>();
	bois.add(first);
	bois.add(second);
	if (num >= 2)
	{
	for(int i = start; i < data.size(); i++)
	{
		if(((double) data.get(start).get(2)) - ((double) data.get(i).get(2)) < 0.01)
		{
			int times = (int) Math.round(data.get(i).get(1));
	int numb = minutes / times;
	if (numb != 0)
	{
			int firsts = ((int)(numb * Math.round(data.get(i).get(0)))) + 	recursive(data, minutes - numb * times, i + 1);
	int seconds = ((int) ((numb - 1) * Math.round(data.get(i).get(0)))) + recursive(data, minutes - numb * times + times, i + 1);
		bois.add(firsts);
		bois.add(seconds);
		}
		}
	}
} 
	int nasdf = best(bois);
	return nasdf;
	}
	return recursive(data, minutes, start + 1);
}
public static void add(ArrayList<ArrayList<Double>> data, ArrayList<Double> temp)
{
	if(data.size() == 0)
	{
		data.add(temp);
		return;
	}
	for(int i = 0; i < data.size(); i++)
	{
		if(data.get(i).get(2) <= temp.get(2))
		{
			data.add(i, temp);
			return;
		}
	}
	data.add(temp);
	return;
}

public static int best (ArrayList<Integer> data)
{
	int max = 0; 
	for (int i = 0; i < data.size(); i++)
	{
		if(data.get(i) > max)
		{
			max = data.get(i);
		}
	}
	return max;
}

public static boolean more (ArrayList<ArrayList<Double>> data, int minutes, int start)
{
	for (int i = start; i < data.size(); i++)
	{
		if(data.get(i).get(1) - 0.1 <= minutes)
		{
			return true;
		}
	}
	return false;
}
}