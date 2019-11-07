/*
ID: bdsomme1
LANG: JAVA
TASK: lamps
*/
import java.io.*;
import java.util.*;

class lamps {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
    int num = Integer.parseInt(f.readLine());
		int presses = Integer.parseInt(f.readLine());
		ArrayList<Integer> on = new ArrayList<>();
		StringTokenizer reader = new StringTokenizer(f.readLine());
		while (reader.hasMoreTokens())
		{
			int temp = Integer.parseInt(reader.nextToken());
			if (temp != -1)
			{
				on.add(temp);
			}
		}
		ArrayList<Integer> off = new ArrayList<>();
		reader = new StringTokenizer(f.readLine());
		while (reader.hasMoreTokens())
		{
			int temp = Integer.parseInt(reader.nextToken());
			if (temp != -1)
			{
				off.add(temp);
			}
		}
    ArrayList<boolean[]> configs = generate(num, presses, on, off);
		ArrayList<String> output = new ArrayList<>();
		if (configs == null)
		{
			out.println("IMPOSSIBLE");
		}
		else
		{
			for (int i = 0; i < configs.size(); i++)
			{
				String boi = "";
				boolean[] bois = configs.get(i);
				for (int j = 0; j < num; j++)
				{
					if(bois[j])
					{
						boi += "1";
					}
					else
					{
						boi += "0";
					}
				}
				output.add(boi);
			}
		}
		
		Collections.sort(output);
		for (int i = 0; i < output.size(); i++)
		{
			out.println(output.get(i));
		}
		
		
		out.close();
		}
		
		public static ArrayList<boolean[]> generate(int num, int presses, ArrayList<Integer> on, ArrayList<Integer> off)
		{
			ArrayList<boolean[]> temp = new ArrayList<>();
			int[] mod6 = new int[6];
				for (int i = 0; i < on.size(); i++)
				{
					mod6[on.get(i) % 6] = 1;
				}
				boolean possible = true;
				for (int i = 0; i < off.size(); i++)
				{
					if (mod6[off.get(i) % 6] == 1)
					{
						possible = false;
					}
					mod6[off.get(i) % 6] = 2;
				}
			if (possible)
			{
			if (presses % 2 == 0)
			{
				if (off.size() == 0)
					temp.add(make(num, false, false, false, false));
			}
			else if (presses % 2 == 1)
			{
				if (mod6[1] != 1 && mod6[4] != 1 && mod6[0] != 2 && mod6[2] != 2 && mod6[3] != 2 && mod6[5] != 2)
				{
					temp.add(make(num, false, false, false, true));
				}
				if (mod6[1] != 1 && mod6[4] != 2 && mod6[0] != 2 && mod6[2] != 2 && mod6[3] != 1 && mod6[5] != 1)
				{
					temp.add(make(num, false, true, false, false));
				}
				if (mod6[1] != 2 && mod6[4] != 1 && mod6[0] != 1 && mod6[2] != 1 && mod6[3] != 2 && mod6[5] != 2)
				{
					temp.add(make(num, false, false, true, false));
				}
				if (mod6[1] != 1 && mod6[4] != 1 && mod6[0] != 1 && mod6[2] != 1 && mod6[3] != 1 && mod6[5] != 1)
				{
					temp.add(make(num, true, false, false, false));
				}
			}
			if (presses >= 2 && presses % 2 == 0)
			{
					if (mod6[0] != 1 && mod6[1] != 2 && mod6[2] != 1 && mod6[3] != 2 && mod6[4] != 1 && mod6[5] != 2)
					{
						temp.add(make(num, true, true, false, false));
					}
					if (mod6[0] != 2 && mod6[1] != 1 && mod6[2] != 2 && mod6[3] != 1 && mod6[4] != 2 && mod6[5] != 1)
					{
						temp.add(make(num, true, false, true, false));
					}
					if (mod6[0] != 1 && mod6[1] != 2 && mod6[2] != 1 && mod6[3] != 1 && mod6[4] != 2 && mod6[5] != 1)
					{
						temp.add(make(num, true, false, false, true));
					}
					if (mod6[0] != 1 && mod6[1] != 1 && mod6[2] != 1 && mod6[3] != 1 && mod6[4] != 1 && mod6[5] != 1)
					{
						temp.add(make(num, false, true, true, false));
					}
					if (mod6[0] != 2 && mod6[1] != 2 && mod6[2] != 2 && mod6[3] != 1 && mod6[4] != 1 && mod6[5] != 1)
					{
						temp.add(make(num, false, true, false, true));
					}
					if (mod6[0] != 1 && mod6[1] != 1 && mod6[2] != 1 && mod6[3] != 2 && mod6[4] != 2 && mod6[5] != 2)
					{
						temp.add(make(num, false, false, true, true));
					}
				}
			if (presses >= 3 && presses % 2 == 1)
			{
				if (mod6[0] != 2 && mod6[1] != 2 && mod6[2] != 2 && mod6[3] != 2 && mod6[4] != 2 && mod6[5] != 2)
					{
						temp.add(make(num, true, true, true, false));
					}
					if (mod6[0] != 1 && mod6[1] != 1 && mod6[2] != 1 && mod6[3] != 2 && mod6[4] != 2 && mod6[5] != 2)
					{
						temp.add(make(num, true, true, false, true));
					}
					if (mod6[0] != 2 && mod6[1] != 2 && mod6[2] != 2 && mod6[3] != 1 && mod6[4] != 1 && mod6[5] != 1)
					{
						temp.add(make(num, true, false, true, true));
					}
					if (mod6[0] != 1 && mod6[1] != 2 && mod6[2] != 1 && mod6[3] != 1 && mod6[4] != 2 && mod6[5] != 1)
					{
						temp.add(make(num, false, true, true, true));
					}
			}
			if (presses >= 4 && presses % 2 == 0)
			{
				if (mod6[0] != 2 && mod6[1] != 1 && mod6[2] != 2 && mod6[3] != 2 && mod6[4] != 1 && mod6[5] != 2)
					{
						temp.add(make(num, true, true, true, true));
					}
			}
			}
			if (temp.size() == 0)
				return null;
			return temp;
		
		}
		
		
		public static boolean[] make (int num, boolean flip1, boolean flip2, boolean flip3, boolean flip4)
		{
			boolean[] temp = new boolean[num];
			for (int i = 0; i < num; i++)
			{
				temp[i] = true;
			}
			if (flip1)
			{
				for (int i = 0; i < num; i++)
				{
					temp[i] = !temp[i];
				}
			}
			if (flip2)
			{
				for (int i = 0; i < num; i += 2)
				{
					temp[i] = !temp[i];
				}
			}
			if (flip3)
			{
				for (int i = 1; i < num; i += 2)
				{
					temp[i] = !temp[i];
				}
			}
			if (flip4)
			{
				for (int i = 0; i < num; i += 3)
				{
					temp[i] = !temp[i];
				}
			}
			return temp;
		}
}