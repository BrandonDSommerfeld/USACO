/*
ID: bdsomme1
LANG: JAVA
TASK: milk4
*/
import java.io.*;
import java.util.*;

class milk4{
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("milk4.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk4.out")));
    
    int goal = Integer.parseInt(f.readLine());
    int buckets = Integer.parseInt(f.readLine());
    int[] capacities = new int[buckets];
    for(int i = 0; i < buckets; i++)
    {
    	capacities[i] = Integer.parseInt(f.readLine());
    }
    Arrays.sort(capacities, 0, buckets);
    
    int[] output = new int[1];
    for(int i = 1; i <= buckets; i++)
    {
    	output = algorithm(goal, capacities, 0, i);
    	if(output[0] != 0)
    	{
    		break;
    	}
    }
    
    out.print(output.length);
    for(int i = 0; i < output.length; i++)
    {
    	out.print(" " + output[i]);
    }
    out.println();
    out.close();
	}
	
	public static int[] algorithm (int goal, int[] capacities, int start, int num)
	{
		int[] works = new int[num];
		
		if(num == 1)
		{
			for(int i = start; i < capacities.length; i++)
			{
				if(goal % capacities[i] == 0)
				{
					works[0] = capacities[i];
					return works;
				}
			}
		}
		else
		{
			int[] output = new int[1];
			for(int i = start; i < capacities.length; i++)
			{
				for(int n = 1; goal - capacities[i]*n >= 0; n++)
				{
					int[] next = algorithm(goal-capacities[i]*n, capacities, i+1, num-1);
					if((output[0] == 0 && next[0] != 0) || (output[0] != 0 && next[0] != 0 && less(next, output)))
					{
						output = next;
					}
				}
				if(output[0] != 0)
				{
					works[0] = capacities[i];
					for(int c = 0; c < num-1; c++)
					{
						works[c+1] = output[c];
					}
					return works;
				}
				
			}
		}
		
		return works;
	}
	
	public static boolean less(int[] first, int[] second)
	{
		for(int i = 0; i < first.length; i++)
		{
			if(first[i] < second[i])
				return true;
			if(first[i] > second[i])
				return false;
		}
		return false;
	}
}
		