/*
ID: bdsomme1
LANG: JAVA
TASK: hamming
*/
import java.io.*;
import java.util.*;


class hamming {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
		
		int n = Integer.parseInt(reader.nextToken());
		int b = Integer.parseInt(reader.nextToken());
		int d = Integer.parseInt(reader.nextToken());
		
		boolean found = false;
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < Math.round(Math.pow(2, b)) && !found; i++)
		{
			nums = new ArrayList<>();
			nums.add(i);
			for (int j = i + 1; j < Math.round(Math.pow(2,b)) && !found; j++)
			{
				boolean boi = true;
				for (int k = 0; k < nums.size() && boi; k++)
				{
					String first = binary(j, b);
					String second = binary(nums.get(k), b);
					if (hamming(first, second) < d)
						boi = false;
				}
				if (boi)
					nums.add(j);
				if (nums.size() == n)
					found = true;
			}
		}
		
		for(int i = 1; i <= nums.size(); i++)
		{
			out.print(nums.get(i - 1));
			if (i == nums.size())
				out.println();
			else if (i % 10 == 0)
				out.println();
			else if (i != nums.size())
				out.print(" ");
		}
		
		out.close();
	  }
		
		public static String binary (int num, int base)
		{
			String temp = "";
			while (base >= 0)
			{
				if (num >= Math.round(Math.pow(2, base)))
				{
					num -= Math.round(Math.pow(2, base));
					temp += "1";
				}
				else
				{
					temp += "0";
				}
				base--;
			}
			return temp;
		}
		
		public static int hamming (String num1, String num2)
		{
			int count = 0;
			for (int i = 0; i < num1.length(); i++)
			{
				if (num1.charAt(i) != num2.charAt(i))
					count++;
			}
			return count;
		}
		
}