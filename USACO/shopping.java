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
			int realcount = 0;
			int read = 0;
      while(reader.hasMoreTokens())
      {
					int qwerty = Integer.parseInt(reader.nextToken());
					if(read % 2 == 0 && read != 0)
					{
						realcount += qwerty;
					}
          temp.add(qwerty);
					read++;
      }
			temp.set(0, realcount);
      offers.add(temp);
  }
  int asdf = Integer.parseInt(f.readLine());
	int[] codes = new int[1000];
	ArrayList<Integer> target = new ArrayList<>();
  for(int i = 0; i < asdf; i++)
  {
      StringTokenizer reader = new StringTokenizer(f.readLine());
			ArrayList<Integer> partial = new ArrayList<>();
			partial.add(1);
      for(int j = 0; j < 3; j++)
      {
          partial.add(Integer.parseInt(reader.nextToken()));
      }
			codes[partial.get(1)] = i;
			target.add(partial.get(2));
			partial.set(2, 1);
			offers.add(0, partial);
  }
	while(target.size() < 5)
	{
		target.add(0);
	}
	quickSort(offers, 0, offers.size() - 1);
	clean(offers);
  int[][][][][] smallest = new int[6][6][6][6][6];
	LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
	ArrayList<Integer> start = new ArrayList<>();
	start.add(0);
	start.add(0);
	start.add(0);
	start.add(0);
	start.add(0);
	queue.add(start);
	while(queue.size() != 0)
	{
		ArrayList<Integer> current = queue.remove();
		int lengthnow = get(smallest, current);
		for(int i = 0; i < offers.size(); i++)
		{
			ArrayList<Integer> on = offers.get(i);
			int addon = on.get(on.size() - 1);
			if(equals(current, on, codes) &&  lengthnow < addon)
			{
				offers.remove(i);
				i--;
			}
			else
			{
			ArrayList<Integer> copy = (ArrayList<Integer>) current.clone();
			for(int j = 1; j < on.size() - 1; j += 2)
			{
				int place = codes[on.get(j)];
				copy.set(place, copy.get(place) + on.get(j + 1));
			}
			if(!bigger(copy, target))
			{
					int newlength = lengthnow + addon;
					Integer other = get(smallest, copy);
					if(other == 0 || newlength < other)
					{
						put(smallest, copy, newlength);
						queue.add(copy);
					}
			}
			}
		}
	}
	out.println(get(smallest, target));
  out.close();
}

public static void put (int[][][][][] smallest, ArrayList<Integer> offer, int newlength)
{
	 smallest[offer.get(0)][offer.get(1)][offer.get(2)][offer.get(3)][offer.get(4)] = newlength;
}

public static int get (int[][][][][] smallest, ArrayList<Integer> offer)
{
	return smallest[offer.get(0)][offer.get(1)][offer.get(2)][offer.get(3)][offer.get(4)];
}

public static void clean (ArrayList<ArrayList<Integer>> offers)
{
	for(int i = offers.size() - 1; i >= 0; i--)
	{
		ArrayList<Integer> checking = offers.get(i);
		for(int j = i - 1; j >= 0; j--)
		{
			ArrayList<Integer> against = offers.get(j);
			if(checking.get(0) % against.get(0) == 0 && checking.size() == against.size())
			{
				int multiple = 0;
				boolean worse = true;
				for(int count = 2; count < checking.size() - 1 && worse; count += 2)
				{
					if(checking.get(count - 1) == against.get(count - 1) && checking.get(count) % against.get(count) == 0)
					{
						if(multiple == 0)
						{
							multiple = checking.get(count) / against.get(count);
						}
						else
						{
							if(multiple != checking.get(count) / against.get(count))
							{
								worse = false;
							}
						}
					}
					else
					{
						worse = false;
					}
				}
				if(worse)
				{
					if(checking.get(checking.size() - 1) >= against.get(against.size() - 1) * multiple)
					{
						offers.remove(i);
						break;
					}
					else if (multiple == 1)
					{
						offers.remove(j);
						break;
					}
				}
			}
		}
	}
}

public static boolean equals (ArrayList<Integer> current, ArrayList<Integer> offer,int[] codes)
{
	for(int i = 1; i < offer.size() - 1; i += 2)
	{
		if(current.get(codes[offer.get(i)]) != offer.get(i + 1))
		{
			return false;
		}
	}
	return true;
}

public static boolean bigger (ArrayList<Integer> copy, ArrayList<Integer> target)
{
	for(int i = 0; i < target.size(); i++)
	{
		if(copy.get(i) > target.get(i))
		{
			return true;
		}
	}
	return false;
}

public static void quickSort(ArrayList<ArrayList<Integer>> arr, int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        } 
    } 

public static int partition(ArrayList<ArrayList<Integer>> arr, int low, int high) 
    { 
        int pivot = (Integer) arr.get(high).get(0);
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            if (arr.get(j).get(0) < pivot) 
            { 
                i++;
                ArrayList<Integer> temp = arr.get(i); 
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            } 
        }
        ArrayList<Integer> temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
		return i + 1;
}

}
