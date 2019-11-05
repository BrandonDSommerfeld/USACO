/*
ID: bdsomme1
LANG: JAVA
TASK: preface
*/
import java.io.*;
import java.util.*;


class preface {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("preface.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
    int limit = Integer.parseInt(f.readLine());
		
		ArrayList<String> pages = generate(limit);
		ArrayList<Integer> counter = new ArrayList<>();
		counter.add(0);
		counter.add(0);
		counter.add(0);
		counter.add(0);
		counter.add(0);
		counter.add(0);
		counter.add(0);
		
		for (int i = 0; i < limit; i++)
		{
			String temp = pages.get(i);
			for (int j = 0; j < temp.length(); j++)
			{
				if (temp.charAt(j) == 'I')
				{
					counter.set(0, counter.get(0) + 1);
				}
				else if (temp.charAt(j) == 'V')
				{
					counter.set(1, counter.get(1) + 1);
				}
				else if (temp.charAt(j) == 'X')
				{
					counter.set(2, counter.get(2) + 1);
				}
				else if (temp.charAt(j) == 'L')
				{
					counter.set(3, counter.get(3) + 1);
				}
				else if (temp.charAt(j) == 'C')
				{
					counter.set(4, counter.get(4) + 1);
				}
				else if (temp.charAt(j) == 'D')
				{
					counter.set(5, counter.get(5) + 1);
				}
				else if (temp.charAt(j) == 'M')
				{
					counter.set(6, counter.get(6) + 1);
				}
			}
		}
		
		if (counter.get(0) != 0)
		{
			out.println("I " + counter.get(0));
		}
		if (counter.get(1) != 0)
		{
			out.println("V " + counter.get(1));
		}
		if (counter.get(2) != 0)
		{
			out.println("X " + counter.get(2));
		}
		if (counter.get(3) != 0)
		{
			out.println("L " + counter.get(3));
		}
		if (counter.get(4) != 0)
		{
			out.println("C " + counter.get(4));
		}
		if (counter.get(5) != 0)
		{
			out.println("D " + counter.get(5));
		}
		if (counter.get(6) != 0)
		{
			out.println("M " + counter.get(6));
		}
		
		out.close();
		}
		
		public static ArrayList<String> generate (int limit)
		{
			ArrayList<String> temp = new ArrayList<>();
			for (int i = 1; i <= limit; i++)
			{
				int boi = i;
				String succ = "";
				while(boi >= 1000)
				{
					succ += "M";
					boi -= 1000;
				}
				if (boi >= 900)
				{
					succ += "CM";
					boi -= 900;
				}
				if (boi >= 500)
				{
					succ += "D";
					boi -= 500;
				}
				if (boi >= 400)
				{
					succ += "CD";
					boi -= 400;
				}
				while (boi >= 100)
				{
					succ += "C";
					boi -= 100;
				}
				if (boi >= 90)
				{
					succ += "XC";
					boi -= 90;
				}
				if (boi >= 50)
				{
					succ += "L";
					boi -= 50;
				}
				if (boi >= 40)
				{
					succ += "XL";
					boi -= 40;
				}
				while (boi >= 10)
				{
					succ += "X";
					boi -= 10;
				}
				if (boi >= 9)
				{
					succ += "IX";
					boi -= 9;
				}
				if (boi >= 5)
				{
					succ += "V";
					boi -= 5;
				}
				if (boi >= 4)
				{
					succ += "IV";
					boi -= 4;
				}
				while (boi >= 1)
				{
					succ += "I";
					boi -= 1;
				}
				temp.add(succ);
			}
			
			
			return temp;
		}
}