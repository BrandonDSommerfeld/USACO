/*
ID: bdsomme1
LANG: JAVA
TASK: msquare
*/
import java.io.*;
import java.util.*;

class msquare{
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
ArrayList<Integer> target = new ArrayList<>();
ArrayList<Integer> start = new ArrayList<>();
start.add(1);
start.add(2);
start.add(3);
start.add(4);
start.add(8);
start.add(7);
start.add(6);
start.add(5);
for(int i = 0; i < 4; i++)
{
	target.add(Integer.parseInt(reader.nextToken()));
}
for(int i = 0; i < 4; i++)
{
	target.add(4, Integer.parseInt(reader.nextToken()));
}

LinkedList<ArrayList<Integer>> inprog = new LinkedList<>();
HashSet<ArrayList<Integer>> visited = new HashSet<>();
HashMap<ArrayList<Integer>, String> mapping = new HashMap<>();
inprog.add(start);
visited.add(start);
mapping.put(start, "");
boolean found = false;
while(!found)
{
	ArrayList<Integer> tempy = inprog.remove();
	ArrayList<Integer> current1 = (ArrayList<Integer>) tempy.clone();
	ArrayList<Integer> current2 = (ArrayList<Integer>) tempy.clone();
	ArrayList<Integer> current3 = (ArrayList<Integer>) tempy.clone();
	if(tempy.equals(target))
	{
		found = true;
		out.println(mapping.get(tempy).length());
		out.println(mapping.get(tempy));
	}
	a(current1);
	if(!visited.contains(current1))
	{
		inprog.add(current1);
		visited.add(current1);
		mapping.put(current1, mapping.get(tempy) + "A");
	}
	b(current2);
	if(!visited.contains(current2))
	{
		inprog.add(current2);
		visited.add(current2);
		mapping.put(current2, mapping.get(tempy) + "B");
	}
	c(current3);
	if(!visited.contains(current3))
	{
		inprog.add(current3);
		visited.add(current3);
		mapping.put(current3, mapping.get(tempy) + "C");
	}
}

out.close();
}

public static void a (ArrayList<Integer> current)
{
    for(int i = 0; i < 4; i++)
		{
			int temp = current.get(i);
			current.set(i, current.get(i + 4));
			current.set(i + 4, temp);
		}
}

public static void b (ArrayList<Integer> current)
{
    for(int i = 0; i < 2; i++)
		{
			int temp = current.get(4*i + 3);
			for(int j = 3; j > 0; j--)
			{
				current.set(4*i + j, current.get(4 * i + j - 1));
			}
			current.set(4 * i, temp);
		}
}

public static void c (ArrayList<Integer> current)
{
    int temp = current.get(1);
		current.set(1, current.get(5));
		current.set(5, current.get(6));
		current.set(6, current.get(2));
		current.set(2, temp);
}

}
