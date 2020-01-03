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
int total = 0;
for(int i = 0; i < cows; i++)
{
    reader = new StringTokenizer(f.readLine());
    int weight = Integer.parseInt(reader.nextToken());;
    total += weight;
    places[i][0] = weight;
    places[i][1] = Integer.parseInt(reader.nextToken());
    places[i][2] = Integer.parseInt(reader.nextToken());
}
sort(places, 0, cows - 1);
int meetings = 0;
while(!done(places, length, total))
{
        /*
        for(int i = 0; i < cows; i++)
        {
           for(int j = 0; j < 3; j++)
           {
               System.out.print(places[i][j] + " ");
            }
           System.out.println();
        }
        System.out.println();
        */
        meetings += advance(places, length);
        
}
/*
for(int i = 0; i < cows; i++)
        {
           for(int j = 0; j < 3; j++)
           {
               System.out.print(places[i][j] + " ");
            }
           System.out.println();
        }
        System.out.println();
*/
out.println(meetings);
out.close();
}
  
public static int advance (int[][] places, int length)
{
    for(int i = 0; i < places.length; i++)
    {
        if(places[i][1] != 0 && places[i][1] != length)
        {
            places[i][1] += places[i][2];
        }
    }
    return fix(places, length);
}

public static int fix(int[][] places, int length)
{
    int meetings = 0;
    for(int i = 0; i < places.length - 1; i++)
    {
        if(places[i][1] != 0 && places[i][1] != length)
        {
        if(places[i][1] > places[i + 1][1])
        {  
            places[i][1] -= 1;
            places[i+1][1] += 1;
            places[i][2] = -1;
            places[i+1][2] = 1;
            meetings++;
        }
        else if(places[i][1] == places[i+1][1])
        {
            places[i][2] = -1;
            places[i+1][2] = 1;
            meetings++;
        }
    }
    }
    
    return meetings;
}
  
public static boolean done(int[][] places, int length, int weight)
{   
    int in = 0;
    int firstr = -1;
    for(int i = 0; i < places.length; i++)
    {
        if(places[i][2] == 1 && places[i][1] != 0)
        {
            firstr = i;
            break;
        }
    }
    int lastl = -1;
    for(int i = places.length - 1; i >= 0; i--)
    {
        if(places[i][2] == -1 && places[i][1] != length)
        {
            lastl = i;
            break;
        }
    }
    if(firstr > lastl || firstr == -1 || lastl == -1)
    {   
        return true;
    }
    for(int i = 0; i < places.length; i++)
    {
        
        if(places[i][1] == 0)
        {
            in += places[i][0];
        }
        else
        {
            break;
        }
    }
    for(int i = places.length - 1; i >= 0; i--)
    {
        
        if(places[i][1] == length)
        {
            in += places[i][0];
        }
        else
        {
            break;
        }
    }
    return (in * 2 >= weight);
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