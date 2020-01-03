/*
ID: bdsomme1
LANG: JAVA
TASK: agrinet
*/
import java.io.*;
import java.util.*;

class agrinet {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));
   int farms = Integer.parseInt(f.readLine());
   int[][] adj = new int[farms][farms];
   String in = f.readLine();
   int place = 0;
   while(in != null)
   {
	   StringTokenizer reader = new StringTokenizer(in);
	   while(reader.hasMoreTokens())
	   {
		   int temp = Integer.parseInt(reader.nextToken());
		   adj[place / farms][place % farms] = temp;
		   place++;
	   }
	   in = f.readLine();
   }
   
   	out.println(shortest(adj));
    out.close();
    
  }
  
 public static int shortest (int[][] adj)
 {
	 int length = 0;
	 HashSet<Integer> inmap = new HashSet<>();
	 inmap.add(0);
	 HashSet<Integer> notinmap = new HashSet<>();
	 for(int i = 1; i < adj.length; i++)
	 {
		notinmap.add(i);
	 }
	 while(!notinmap.isEmpty())
	 {
		 int shortest = Integer.MAX_VALUE;
		 int place = 0;
		 for(Integer num: inmap)
		 {
			 for(Integer boi: notinmap)
			 {
				 if(adj[num][boi] < shortest)
				 {
					 shortest = adj[num][boi];
					 place = boi;
				 }
			 }
		 }
		 inmap.add(place);
		 notinmap.remove(place);
		 length += shortest;
     }
	 return length;
 }
}