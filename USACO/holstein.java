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
    
    out.close();
   }
   
   public static ArrayList<ArrayList<Integer>> generate 
   (ArrayList<Integer> requirements, ArrayList<ArrayList<Integer>> nutrients, int limit)
   {
       ArrayList<ArrayList<Integer>> feeds = new ArrayList<>();
       if (limit == 1)
       {
           ArrayList<Integer> temp = new ArrayList<>();
           temp.add(0);
           feeds.add(temp);
        }
       else
       {
           ArrayList<ArrayList<Integer>> previous = generate(requirements, nutrients, limit - 1);
           if (check(requirements, nutrients, previous.get(0)))
           {
               feeds.add(previous.get(0));
               return feeds;
           }
           
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
               gotten += nutrients.get(feeds.get(j)).get(i);
            }
           if (gotten < required)
                return false;
        }
       return true;
    }
}