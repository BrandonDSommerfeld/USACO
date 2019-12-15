/*
ID: bdsomme1
LANG: JAVA
TASK: whereami
*/
import java.io.*;
import java.util.*;

class whereami {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
int length = Integer.parseInt(f.readLine());
String input = f.readLine();
int min = 0;
HashMap<String, Integer> count = new HashMap<>();
count.put(input, 1);
for(int i = length - 1; i >= 0 && min == 0; i--)
{
	HashMap<String, Integer> temp = new HashMap<>();
	String edge = input.substring(0, i);
	temp.put(edge, 1);
	for(String seq: count.keySet())
	{
		String on = seq.substring(1);
		if(temp.get(on) == null)
		{
			temp.put(on, 1);
		}
		else
		{
			min = i + 1;
			break;
		}
	}
	count = temp;
}
out.println(min);
out.close();
}
  
}