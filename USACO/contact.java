/*
ID: bdsomme1
LANG: JAVA
TASK: contact
*/
import java.io.*;
import java.util.*;

class contact {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("contact.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
    
StringTokenizer reader = new StringTokenizer(f.readLine());
int min = Integer.parseInt(reader.nextToken());
int max = Integer.parseInt(reader.nextToken());
int num = Integer.parseInt(reader.nextToken());

String first = f.readLine();
String whole = "";
while(first != null)
{
	whole += first;
	first = f.readLine();
}
HashMap<String, Integer> count = new HashMap<>();
ArrayList<String> previous = new ArrayList<>();
for(int i = 0; i < whole.length() - max + 1; i++)
{
			try
			{
			String temp = whole.substring(i, i + max);
			if(count.get(temp) != null)
			{
				count.put(temp, count.get(temp) + 1);
			}
			else
			{
				count.put(temp, 1);
				previous.add(temp);
			}
			}
			catch (Exception e)
			{
			}
}
for(int i = max - 1; i >= min; i--)
{
	try
	{
	ArrayList<String> boyo = new ArrayList<>();
	for(int j = 0; j < previous.size(); j++)
	{
		String boi = previous.get(j).substring(1);
		if(count.get(boi) != null)
			{
				count.put(boi, count.get(boi) + count.get(previous.get(j)));
			}
			else
			{
				count.put(boi, count.get(previous.get(j)));
				boyo.add(boi);
			}
	}
	String edgecase = whole.substring(0, i);
	if(count.get(edgecase) != null)
			{
				count.put(edgecase, count.get(edgecase) + 1);
			}
			else
			{
				count.put(edgecase, 1);
				boyo.add(edgecase);
			}
	previous = boyo;
	}
	catch (Exception e)
	{
	}
}
ArrayList<ArrayList<Object>> toSort = new ArrayList<>();
for(String number: count.keySet())
{
	ArrayList<Object> temp = new ArrayList<>();
	temp.add(number);
	temp.add(count.get(number));
	toSort.add(temp);
}
quickSort(toSort, 0, toSort.size() - 1);
toSort = reverse(toSort);
int printed = 0;
int counted = 0;
while (counted < num && printed < toSort.size())
{
	int happens = (Integer) toSort.get(printed).get(1);
	ArrayList<String> all = new ArrayList<>();
	all.add((String) toSort.get(printed).get(0));
	printed++;
	boolean stop = false;
	for(int i = printed;!stop && i < toSort.size(); i++)
	{
		if (((Integer) toSort.get(i).get(1)).equals(happens))
		{
			all.add((String) toSort.get(i).get(0));
			printed++;
		}
		else
		{
			stop = true;
		}
	}
	out.println(happens);
	stringSort(all);
	int linecount = 0;
	for(int i = 0; i < all.size(); i++)
	{
		out.print(all.get(i));
		linecount++;
		if(linecount % 6 == 0 && i != all.size() - 1)
		{
			out.println();
		}
		else if (i != all.size() - 1)
		{
			out.print(" ");
		}
	}
	out.println();
	counted++;
}

out.close();
}
  
public static ArrayList<ArrayList<Object>> reverse (ArrayList<ArrayList<Object>> data)
{
	ArrayList<ArrayList<Object>> temp = new ArrayList<>();
	for(int i = data.size() - 1; i >= 0; i--)
	{
		temp.add(data.get(i));
	}
	return temp;
}

public static void stringSort (ArrayList<String> list)
{
	for(int i = 0; i < list.size() - 1; i++)
	{
		String min = "1111111111111111";
		int place = 0;
		for(int j = i; j < list.size(); j++)
		{
			if(list.get(j).length() < min.length())
			{
				min = list.get(j);
				place = j;
			}
			else if (list.get(j).length() == min.length())
			{
				if(list.get(j).compareTo(min) < 0)
				{
					min = list.get(j);
					place = j;
				}
			}
		}
		String temp = list.get(place);
		list.set(place, list.get(i));
		list.set(i, temp);
	}
}

public static void quickSort(ArrayList<ArrayList<Object>> arr, int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        } 
    } 

public static int partition(ArrayList<ArrayList<Object>> arr, int low, int high) 
    { 
        int pivot = (Integer) arr.get(high).get(1);
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            if ((Integer) arr.get(j).get(1) < pivot) 
            { 
                i++;
                ArrayList<Object> temp = arr.get(i); 
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            } 
        }
        ArrayList<Object> temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);
		return i + 1;
}

}
