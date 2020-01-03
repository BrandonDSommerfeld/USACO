/*
ID: bdsomme1
LANG: JAVA
TASK: meetings
*/
import java.io.*;
import java.util.*;

class meetings {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("meetings.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int cows = Integer.parseInt(reader.nextToken());
int length = Integer.parseInt(reader.nextToken());
int[][] places = new int[cows][3];
for(int i = 0; i < cows; i++)
{
	reader = new StringTokenizer(f.readLine());
	places[i][0] = Integer.parseInt(reader.nextToken());
	places[i][1] = Integer.parseInt(reader.nextToken());
	places[i][2] = Integer.parseInt(reader.nextToken());
}
sort(places, 0, cows);
int meetings = 0;
while(!done(places, length))
{
	meetings += advance(places, length);
}
out.println(meetings);
out.close();
}
  
public static int advance (int[][] places, int length)
{
	int meetings = 0;
	for(int i = 0; i < places.length; i++)
	{
		if(places[i][1] != 0 && places[i][1] != length)
		{
			if(i != places.length - 1)
			{
				if(places[i][1] == places[i+1][1])
				{
					places[i][2] = -1;
					places[i + 1][2] = 1;
					places[i][1] -= 1;
					meetings++;
				}
				else if (places[i][1] + 1 == places[i+1][1])
				{
					if(places[i][2] == 1 && places[i+1][2] == -1)
					{
						meetings++;
						places[i][2] = -1;
						places[i + 1][2] = 1;
						i++;
					}
				}
				else
				{
					places[i][1] += (places[i][2]);
					if(places[i][1] == 0 || places[i][1] == length)
					{
						places[i][2] = 0;
					}
				}
			}
			else
			{
				places[i][1] += (places[i][2]);
				if(places[i][1] == 0 || places[i][1] == length)
				{
					places[i][2] = 0;
				}
			}
		}
	}
	
	
	return meetings;
}
  
public static boolean done(int[][] places, int length)
{	
	int in = 0;
	int total = 0;
	for(int i = 0; i < places.length; i++)
	{
		total += places[i][0];
		if(places[i][1] == 0 || places[i][1] == length)
		{
			in += places[i][0];
		}
	}
	return (in * 2 >= total);
}

public static int partition(int arr[][], int low, int high) 
{ 
    int pivot = arr[high][1];  
    int i = (low-1); // index of smaller element 
    for (int j=low; j<high; j++) 
    { 
        // If current element is smaller than the pivot 
        if (arr[j][1] < pivot) 
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
public static void sort(int arr[][], int low, int high) 
{ 
    if (low < high) 
    { 
        /* pi is partitioning index, arr[pi] is  
          now at right place */
        int pi = partition(arr, low, high); 

        // Recursively sort elements before 
        // partition and after partition 
        sort(arr, low, pi-1); 
        sort(arr, pi+1, high); 
    } 
}
}