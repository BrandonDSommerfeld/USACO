/*
ID: bdsomme1
LANG: JAVA
TASK: holstein
*/
import java.io.*;
import java.util.*;


class holstein {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
    int vitamins = Integer.parseInt(f.readLine());
    ArrayList<Integer> requirements = new ArrayList<>();
    StringTokenizer reader = new StringTokenizer(f.readLine());
    while (reader.hasMoreTokens())
    {
        requirements.add(Integer.parseInt(reader.nextToken()));
    }
    int feeds = Integer.parseInt(f.readLine());
    ArrayList<ArrayList<Integer>> nutrients = new ArrayList<>();
    for (int i = 0; i < feeds; i++)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        StringTokenizer line = new StringTokenizer(f.readLine());
        while (line.hasMoreTokens())
        {
            temp.add(Integer.parseInt(line.nextToken()));
        }
        nutrients.add(temp);
    }
		
		ArrayList<ArrayList<Integer>> possible = generate(feeds);
		ArrayList<Integer> bestfeeds = findbest(requirements, nutrients, possible);
		out.print(bestfeeds.size());
		for (int i = 0; i < bestfeeds.size(); i++)
		{
			out.print(" " + (bestfeeds.get(i) + 1));
		}
		out.println();
    
    out.close();
   }
	 
	 public static ArrayList<Integer> findbest (ArrayList<Integer> requirements,
	 ArrayList<ArrayList<Integer>> nutrients, ArrayList<ArrayList<Integer>> possible)
	 {
	 		ArrayList<ArrayList<Integer>> possibly = new ArrayList<>();
			for (int i = 0; i < possible.size(); i++)
			{
				if (check(requirements, nutrients, possible.get(i)))
					possibly.add(possible.get(i));
			}
	 	
	 	 ArrayList<Integer> best = possibly.get(0);
		 for (int i = 1; i < possibly.size(); i++)
		 {
		 		ArrayList<Integer> temp = possibly.get(i);
				if (temp.size() < best.size())
				{
					best = temp;
				}
				else if (temp.size() == best.size())
				{
					boolean found = false, not = false;
					for(int j = 0; !found && !not && j < temp.size(); j++)
					{
						if (temp.get(j) < best.get(j))
						{
							best = temp;
							found = true;
						}
						else if (best.get(j) < temp.get(j))
						{
							not = true;
						}
					}
				}
		 }
		 return best;
	 }
   
   public static ArrayList<ArrayList<Integer>> generate 
   (int size)
   {
       ArrayList<ArrayList<Integer>> feeds = new ArrayList<>();
       if (size == 1)
			 {
			 	ArrayList<Integer> temp = new ArrayList<>();
				temp.add(0);
			 	feeds.add(temp);
			 }
			 else
			 {
			 		ArrayList<ArrayList<Integer>> previous = generate(size - 1);
					for (int i = 0; i < previous.size(); i++)
					{
						ArrayList<Integer> temp = previous.get(i);
						feeds.add(((ArrayList<Integer>) temp.clone()));
						temp.add(size - 1);
						feeds.add(temp);
					}
					ArrayList<Integer> wat = new ArrayList<>();
					wat.add(size - 1);
					feeds.add(wat);
			 }
       
       
       return feeds;
    }
    
   public static boolean check (ArrayList<Integer> requirements, 
   ArrayList<ArrayList<Integer>> nutrients, ArrayList<Integer> feeds)
   {
       for (int i = 0; i < requirements.size(); i++)
       {
           int required = requirements.get(i);
           int gotten = 0;
           for (int j = 0; j < feeds.size(); j++)
           {
							
               gotten += (nutrients.get(feeds.get(j))).get(i);
            }
           if (gotten < required)
                return false;
        }
       return true;
    }
}
