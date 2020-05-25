/*
ID: bdsomme1
LANG: JAVA
TASK: window
*/
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class window{
	public static int[][] locations = new int[128][4];
	public static int[] indexes = new int[128];
	public static int current = 0;
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("window.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("window.out")));
    
    String command = f.readLine();
    while(command != null)
    {
    	
    	char c = command.charAt(0);
    	if(c == 'w')
    	{
    		StringTokenizer reader = new StringTokenizer(command, ",");
    		char i = command.charAt(2);
    		reader.nextToken();
    		int x1 = Integer.parseInt(reader.nextToken());
    		int y1 = Integer.parseInt(reader.nextToken());
    		int x2 = Integer.parseInt(reader.nextToken());
    		String save = reader.nextToken();
    		int y2 = Integer.parseInt(save.substring(0,save.indexOf(")")));
    		if(x2 < x1)
    		{
    			int temp = x1;
    			x1 = x2;
    			x2 = temp;
    		}
    		if(y2 < y1)
    		{
    			int temp = y1;
    			y1 = y2;
    			y2 = temp;
    		}
    		create(i, x1, y1, x2, y2);
    	}
    	else if (c == 't')
    	{
    		top(command.charAt(2));
    	}
    	else if (c == 'b')
    	{
    		bottom(command.charAt(2));
    	}
    	else if (c == 'd')
    	{
    		destroy(command.charAt(2));
    	}
    	else
    	{
    		out.println(output(command.charAt(2)));
    	}
    	
    	command = f.readLine();
    }
    
    out.close();
	}
	
	public static String output (char id)
	{
		DecimalFormat formatter = new DecimalFormat("#0.000");
		int place = (int) id;
		int loc = indexes[place];
		int x1 = locations[place][0];
		int y1 = locations[place][1];
		int x2 = locations[place][2];
		int y2 = locations[place][3];
		
		
		int[] importantrows = new int[140];
		
		for(int i = 48; i < 123; i++)
		{
			
			if(indexes[i] != 0 && indexes[i] > loc)
			{
				int nx1 = locations[i][0];
				int ny1 = locations[i][1];
				int nx2 = locations[i][2];
				int ny2 = locations[i][3];
				
				if(((nx1 >= x1 && nx1 <= x2) || (nx2 >= x1 && nx2 <= x2) || (nx1 < x1 && nx2 > x2)) && ((ny1 >= y1 && ny1 <= y2) || (ny2 >= y1 && ny2 <= y2) || (ny1 < y1 && ny2 > y2)))
				{
					int startx = x1;
					if(nx1 > startx)
					{
						startx = nx1;
					}
					int endx = x2;
					if(nx2 < endx)
					{
						endx = nx2;
					}
					int starty = y1;
					if(ny1 > starty)
					{
						starty = ny1;
					}
					int endy = y2;
					if(ny2 < endy)
					{
						endy = ny2;
					}

					importantrows[importantrows[0]+1] = starty;
					importantrows[0]++;
					importantrows[importantrows[0]+1] = endy+1;
					importantrows[0]++;
				
					
				}
			}
		}
		
		Arrays.sort(importantrows, 1, importantrows[0]+1);
		int[][][] blocks = new int[importantrows[0]+2][70][2];
		for(int i = 48; i < 123; i++)
		{
			
			if(indexes[i] != 0 && indexes[i] > loc)
			{
				int nx1 = locations[i][0];
				int ny1 = locations[i][1];
				int nx2 = locations[i][2];
				int ny2 = locations[i][3];
				
				if(((nx1 >= x1 && nx1 <= x2) || (nx2 >= x1 && nx2 <= x2) || (nx1 < x1 && nx2 > x2)) && ((ny1 >= y1 && ny1 <= y2) || (ny2 >= y1 && ny2 <= y2) || (ny1 < y1 && ny2 > y2)))
				{
					int startx = x1;
					if(nx1 > startx)
					{
						startx = nx1;
					}
					int endx = x2;
					if(nx2 < endx)
					{
						endx = nx2;
					}
					int starty = y1;
					if(ny1 > starty)
					{
						starty = ny1;
					}
					int endy = y2;
					if(ny2 < endy)
					{
						endy = ny2;
					}

					for(int c = 1; c <= importantrows[0]; c++)
					{
						int row = importantrows[c];
						if(row >= starty && row <= endy) 
						{
							blocks[c][blocks[c][0][0] + 1][0] = startx;
							blocks[c][blocks[c][0][0] + 1][1] = endx;
							blocks[c][0][0]++;
						}
						
					}
				
					
				}
			}
		}
		
		
		int count = 0;
		
		int rowtotal = 0;
		int row = y1;
		for(int c = 1; c <= importantrows[0]+1; c++)
		{
			int next = importantrows[c];
			if(c == importantrows[0]+1)
			{
				next = y2+1;
			}
			if(blocks[c-1][0][0] > 0)
			{
				sort(blocks[c-1], 1, blocks[c-1][0][0]);
				
				int[] current = blocks[c-1][1];
				rowtotal += (current[0] - x1);
				for(int i = 2; i <= blocks[c-1][0][0]; i++)
				{
					
					if(blocks[c-1][i][0] > current[1])
					{
						rowtotal += blocks[c-1][i][0] - current[1] - 1;
						current = blocks[c-1][i];
					}
					else if (blocks[c-1][i][1] > current[1])
					{
						current[1] = blocks[c-1][i][1];
					}
				}
				rowtotal += (x2 - current[1]);
			}
			else
			{
				rowtotal += (x2-x1+1);
			}
			count += rowtotal * (next-row);
			row = next;
			rowtotal = 0;
		}
		
		double percent = 100 * ((double) count)/ ((x2-x1+1) * (y2-y1+1));
		return formatter.format(percent);
	}
	
	public static void create(char id, int x1, int y1, int x2, int y2)
	{
		int place = (int) id;
		locations[place][0] = x1;
		locations[place][1] = y1;
		locations[place][2] = x2-1;
		locations[place][3] = y2-1;
		current++;
		indexes[place] = current;
	}
	
	public static void top (char id)
	{
		int place = (int) id;
		int loc = indexes[place];
		for(int i = 48; i < 123; i++)
		{
			if(indexes[i] != 0 && indexes[i] > loc)
			{
				indexes[i]--;
			}
		}
		indexes[place] = current;
	}
	
	public static void bottom (char id)
	{
		int place = (int) id;
		int loc = indexes[place];
		for(int i = 48; i < 123; i++)
		{
			if(indexes[i] != 0 && indexes[i] < loc)
			{
				indexes[i]++;
			}
		}
		indexes[place] = 1;
		
	}
	
	public static void destroy (char id)
	{
		int place = (int) id;
		int loc = indexes[place];
		for(int i = 48; i < 123; i++)
		{
			if(indexes[i] != 0 && indexes[i] > loc)
			{
				indexes[i]--;
			}
		}
		indexes[place] = 0;
		current--;
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
    