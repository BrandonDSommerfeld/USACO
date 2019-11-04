/*
ID: bdsomme1
LANG: JAVA
TASK: frac1
*/
import java.io.*;
import java.util.*;

class frac1 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		
		int limit = Integer.parseInt(f.readLine());
		ArrayList<ArrayList<Integer>> both = generate(limit);
		ArrayList<Integer> nums = both.get(0);
		ArrayList<Integer> denoms = both.get(1);
		
		for(int i = 0; i < nums.size(); i++)
		{
			out.println(nums.get(i) + "/" + denoms.get(i));
		}
		out.close();
		}
		
		public static ArrayList<ArrayList<Integer>> generate (int limit)
		{
			ArrayList<ArrayList<Integer>> both = new ArrayList<>();
			ArrayList<Integer> nums = new ArrayList<>();
			ArrayList<Integer> denoms = new ArrayList<>();
			
			if (limit == 1)
			{
				nums.add(0);
				nums.add(1);
				denoms.add(1);
				denoms.add(1);
			}
			else
			{
				ArrayList<ArrayList<Integer>> temp = generate(limit - 1);
				nums = temp.get(0);
				denoms = temp.get(1);
				for (int i = 0; i < nums.size() - 1; i++)
				{
					if (denoms.get(i) + denoms.get(i + 1) == limit)
					{
						nums.add(i + 1, nums.get(i) + nums.get(i + 1));
						denoms.add(i + 1, limit);
					}
				}
			}
			
			
			both.add(nums);
			both.add(denoms);
			return both;
		}
}