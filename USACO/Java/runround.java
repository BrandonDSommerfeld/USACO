/*
ID: bdsomme1
LANG: JAVA
TASK: runround
*/
import java.io.*;
import java.util.*;

class runround {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("runround.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
    String boi = f.readLine();
    
		out.println(next(boi));
		
		
		out.close();
		
		}
		
		public static String next (String boi)
		{
			int temp = Integer.parseInt(boi);
			temp++;
			boi = "" + temp;
			boolean fixed = false, found = false;
			while (!found)
			{
				while (!fixed)
				{
					boolean[] succ = new boolean[10];
					boolean wat = false;
					for (int i = 0; i < boi.length() && !wat; i++)
					{
						int succc = Integer.parseInt(boi.substring(i, i + 1));
						if (!succ[succc] && succc != 0)
						{
							succ[succc] = true;
						}
						else
						{
							wat = true;
							int change = Integer.parseInt(boi.substring(0, i + 1));
							change++;
							String last = "";
							if (i != boi.length() - 1)
							{
								last = boi.substring(i + 1);
							}
							boi = change + last;
						}
						
					}
					if (!wat)
					{
						fixed = true;
					}
				}
				boolean[] bois = new boolean[boi.length()];
				int place = 0;
				for (int i = 0; i < boi.length(); i++)
				{
					bois[place] = true;
					int steps = Integer.parseInt(boi.substring(place, place + 1));
					for (int j = 0; j < steps; j++)
					{
						place++;
						if (place == boi.length())
						{
							place = 0;
						}
					}
				}
				boolean worked = true;
				for (int i = 0; i < bois.length; i++)
				{
					if (!bois[i])
					{
						worked = false;
					}
				}
				if (worked && place == 0)
				{
					found = true;
				}
				else
				{
					int current = Integer.parseInt(boi);
					current++;
					boi = "" + current;
					fixed = false;
				}
			}
			return boi;
		}
}