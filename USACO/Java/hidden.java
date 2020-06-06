/*
ID: bdsomme1
LANG: JAVA
TASK: hidden
*/
import java.io.*;
import java.util.*;

class hidden{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("hidden.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hidden.out")));
    
    int length = Integer.parseInt(f.readLine());
    char[] word = new char[length];
    String line = f.readLine();
    int place = 0;
    while(line != null)
    {
    	for(int i = 0; i < line.length(); i++)
    	{
    		word[place] = line.charAt(i);
    		place++;
    	}
    	line = f.readLine();
    }
    
   int[] best = new int[length];
   place = 0;
   char current = '{';
   for(int i = 0; i < length; i++)
   {
	   if(word[i] < current)
	   {
		  place = 0;
		  best[place] = i;
		  place++;
		  current = word[i];
	   }
	   else if (word[i] == current)
	   {
		   best[place] = i;
		   place++;
	   }
   }
   
   
   int[] secondary = new int[place];
   int shift = 1;
   boolean front = true, nfront = true;
   while(place != 1)
   {
	  int nplace = 0;
	  nfront = true;
	  current = '{';
	  boolean previous = true, next = true;
	  for(int i = 0; i < place; i++)
	  {
		  if(!front)
		  {
			  i++;
		  }
		  if(binarySearch(best, 0, place-1, (best[i] + shift) % length) != -1)
		  {
			  if(i == place-1)
			  {
				  nfront = false;
				  if(nplace == 0)
				  {
					  best[0] = (best[i] + shift) % length;
					  nplace++;
				  }
			  }
			  else
			  {
				  next = false;
			  }
		  }
		  if(word[(best[i]+shift) % length] < current)
		  {
			  nplace = 0;
			  secondary[nplace] = best[i];
			  nplace++;
			  current = word[(best[i]+shift) % length];
		  }
		  else if(word[(best[i]+shift) % length] == current && previous)
		  {
			  secondary[nplace] = best[i];
			  nplace++;
		  }
		  previous = next;
		  next = true;
	  }
	  front = nfront;
	  place = nplace;
	  shift++;
	  best = secondary;
	  secondary = new int[place];
   }
    
    out.println(best[0]);
    out.close();
	}
	
	public static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
           
            if (arr[mid] == x) 
                return mid; 
  
           
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
           
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        return -1; 
    }
}
    