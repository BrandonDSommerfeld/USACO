/*
ID: bdsomme1
LANG: JAVA
TASK: humble
*/
import java.io.*;
import java.util.*;

class humble {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("humble.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
    ArrayList<Integer> primes = new ArrayList<>();
    StringTokenizer reader = new StringTokenizer(f.readLine());
    reader.nextToken();
    int num = Integer.parseInt(reader.nextToken());
    reader = new StringTokenizer(f.readLine());
    while(reader.hasMoreTokens())
    {
        primes.add(Integer.parseInt(reader.nextToken()));
    }
    Collections.sort(primes);
    ArrayList<Integer> humbles = new ArrayList<>();
    HashSet<Integer> container = new HashSet<>();
    humbles.add(1);
    container.add(1);
    boolean stop = false, big = false;
    for(int i = 0; i < num && !stop; i++)
    {
    	for(int j = 0; j < primes.size(); j++)
    	{
    		int prime = primes.get(j);
    		int humble = humbles.get(i);
    		if (!big && humbles.size() > num)
    		{
    			big = true;
    		}
    		if (big && prime * humble >= humbles.get(num))
    		{
    			primes.remove(new Integer(prime));
    		}
    		else if (!container.contains(prime*humble))
    		{
    			container.add(prime*humble);
				addSorted(humbles, prime*humble);
    			if(big)
    			{
    				humbles.remove(num + 1);
    			}
    			
    				
    		}
    	}
    	if (primes.size() == 0)
    	{
    	     stop = true;
    	}
    }
    out.println(humbles.get(num));
    out.close();
}
  
public static void addSorted(ArrayList<Integer> data, int element)
{
	if(data.size() == 1)
	{
		if (element > data.get(0))
		{
			data.add(element);
			return;
		}
		else
		{
			data.add(0, element);
			return;
		}
	}
	if(element > data.get(data.size() - 1))
	{
		data.add(element);
		return;
	}
	int low = 0;
	int high = data.size() - 1;
	while (low < high)
	{
		int mid = low + (high - low)/2;
		if(element < data.get(mid))
		{
			high = mid;
		}
		else
		{
			low = mid + 1;
		}
		
	}
	data.add(low, element);
	return;
}


}