/*
ID: bdsomme1
LANG: JAVA
TASK: fact4
*/
import java.io.*;
import java.util.*;

class fact4 {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));
int num = Integer.parseInt(f.readLine());
out.println((digit(num)%10));

out.close();
}

public static int digit (int num)
{
	if (num == 1)
	{
		return 1;
	}
	else
	{
		int temp = num * digit(num - 1);
		while(temp % 10 == 0)
		{
			temp = temp / 10;
		}
		return temp % 10000;
	}
}
}
   