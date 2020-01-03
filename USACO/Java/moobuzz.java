/*
ID: bdsomme1
LANG: JAVA
TASK: moobuzz
*/
import java.io.*;
import java.util.*;

class moobuzz {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
long num = Long.parseLong(f.readLine());
long cycles = num / 8;
long start = cycles * 15 - 1;
long used = cycles * 8 - 1;
if(cycles == 0)
{
	start = 1;
	used = 0;
}
while(used < num)
{
	if(start % 3 == 0 || start % 5 == 0)
	{
		
	}
	else
	{
		used++;
	}
	start++;
}

out.println(start - 1);
out.close();
}
  
}