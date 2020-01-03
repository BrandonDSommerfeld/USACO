/*
ID: bdsomme1
LANG: JAVA
TASK: sort3
*/
import java.io.*;
import java.util.*;

class sort3 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		
		int size = Integer.parseInt(f.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int count1 = 0, count2 = 0, count3 = 0;
		for (int i = 0; i < size; i++)
		{
			int num = Integer.parseInt(f.readLine());
			list.add(num);
			if (num == 1)
				count1++;
			else if (num == 2)
				count2++;
			else
				count3++;
		}
		
		int count1in3 = 0, count2in3 = 0, count1in2 = 0, count2in1 = 0, count3in1 = 0,   	count3in2 = 0;
		for (int i = 0; i < list.size(); i++)
		{
			if (i < count1 && list.get(i) != 1)
			{
				if (list.get(i) == 2)
					count2in1++;
				else
					count3in1++;
			}
			else if (i >= count1 && i < count1 + count2 && list.get(i) != 2)
			{
				if (list.get(i) == 1)
					count1in2++;
				else
					count3in2++;
			}
			else if (i >= count1 + count2 && list.get(i) != 3)
			{
				if (list.get(i) == 1)
					count1in3++;
				else
					count2in3++;
			}
		}
		int swaps = 0;
		if (count1in3 >= count3in1)
		{
			count1in3 -= count3in1;
			swaps+= count3in1;
			count3in1 = 0;
		}
		else
		{
			count3in1 -= count1in3;
			swaps+= count1in3;
			count1in3 = 0;
		}
		if (count1in2 >= count2in1)
		{
			count1in2 -= count2in1;
			swaps+= count2in1;
			count2in1 = 0;
		}
		else
		{
			count2in1 -= count1in2;
			swaps+= count1in2;
			count1in2 = 0;
		}
		if (count3in2 >= count2in3)
		{
			count3in2 -= count2in3;
			swaps+= count2in3;
			count2in3 = 0;
		}
		else
		{
			count2in3 -= count3in2;
			swaps+= count3in2;
			count3in2 = 0;
		}
		int remaining = count1in2 + count2in1 + count1in3 + count3in1 + count2in3 + count3in2;
		swaps += (remaining / 3) * 2;
		
		out.println(swaps);
		out.close();
		}
}