/*
ID: bdsomme1
LANG: JAVA
TASK: shopping
*/
import java.io.*;
import java.util.*;

class shopping {
    private static int[] path;
    private static int position;
  public static void main (String [] args) throws IOException {
  BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
  int lines = Integer.parseInt(f.readLine());
  ArrayList<ArrayList<Integer>> offers = new ArrayList<>();
  for(int i = 0; i < lines; i++)
  {
      ArrayList<Integer> temp = new ArrayList<>();
      StringTokenizer reader = new StringTokenizer(f.readLine());
      while(reader.hasMoreTokens())
      {
          temp.add(Integer.parseInt(reader.nextToken()));
      }
      offers.add(temp);
  }
  int asdf = Integer.parseInt(f.readLine());
  int[][] products = new int[asdf][3];
  for(int i = 0; i < asdf; i++)
  {
      StringTokenizer reader = new StringTokenizer(f.readLine());
      for(int j = 0; j < 3; j++)
      {
          products[i][j] = Integer.parseInt(reader.nextToken());
      }
  }
  clean(offers);
  HashSet<ArrayList<Integer>> foundbefore = new HashSet<>();
  HashMap<ArrayList<Integer>, Integer> lengths = new HashMap<>();
  ArrayList<Integer> start = new ArrayList<>();
  start.add(0);
  start.add(0);
  foundbefore.add(start);
  lengths.put(start, 0);
  for(int i = 0; i < 5; i++)
  {
      for(ArrayList<Integer> current: foundbefore)
      {
          ArrayList<Integer> copy = (ArrayList<Integer>) current.clone();
          
      }
  }
  
  out.close();
}

public static void clean (ArrayList<ArrayList<Integer>> offers)
{
    for(int i = 0; i < offers.size(); i++)
    {
        for(int j = i + 1; j < offers.size();)
        {
            if(worse(offers.get(j), offers.get(i)))
            {
                offers.remove(j);
            }
            else
            {
                j++;
            }
        }
    }
}

public static boolean worse (ArrayList<Integer> possibly, ArrayList<Integer> checkagainst)
{
    int multiple = 0;
    for(int i = 1; i < possibly.size() - 1 || i < checkagainst.size() - 1; i += 2)
    {
        try
        {
        if(possibly.get(i) == checkagainst.get(i))
        {
            if(possibly.get(i + 1) % checkagainst.get(i + 1) == 0 && (multiple == 0 ||
            possibly.get(i + 1) / checkagainst.get(i + 1) == multiple))
            {
                multiple = possibly.get(i + 1) / checkagainst.get(i + 1);
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    catch (Exception e)
    {
    }
    }
    if(possibly.get(possibly.size() - 1) > multiple * checkagainst.get(checkagainst.size() - 1))
    {
        return true;
    }
    return false;
}

}