/*
ID: bdsomme1
LANG: JAVA
TASK: picture
*/
import java.io.*;
import java.util.*;

class picture{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("picture.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("picture.out")));
    
    int r = Integer.parseInt(f.readLine());
    int[][] lefts = new int[r][3];
    int[][] rights = new int[r][3];
    for(int i = 0; i < r; i++)
    {
    	StringTokenizer reader = new StringTokenizer(f.readLine());
    	int x1 = Integer.parseInt(reader.nextToken());
    	int y1 = Integer.parseInt(reader.nextToken());
    	int x2 = Integer.parseInt(reader.nextToken());
    	int y2 = Integer.parseInt(reader.nextToken());
    	lefts[i][0] = x1;
    	lefts[i][1] = y1;
    	lefts[i][2] = y2;
    	rights[i][0] = x2;
    	rights[i][1] = y1;
    	rights[i][2] = y2;
    }
    
    out.println(perimeter(lefts, rights, r));
    out.close();
	}
	
	public static int perimeter(int[][] lefts, int[][] rights, int size)
	{
		int p = 0;
		sort(lefts, 0, size);
		sort(rights, 0, size);
		
		int l = 0, r = 0;
		while(r < size)
		{
			if(lefts[l][0] < rights[r][0])
			{
				
				
				l++;
			}
			else
			{
				
				
				r++;
			}
		}
		
		return p;
	}
	
	public static int partition(int arr[][], int low, int high) 
    { 
        int pivot = arr[high][0];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j][0] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int[] temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int[] temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public static void sort(int[][] arr, int low, int high) 
    { 
        if (low < high) 
        { 
            
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }
}
    