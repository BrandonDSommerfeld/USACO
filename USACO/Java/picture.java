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
    int[][] rects = new int[10000][5];
    int k, npt = 0;
    for(int i = 0; i < r; i++)
    {
    	StringTokenizer reader = new StringTokenizer(f.readLine());
    	int x1 = Integer.parseInt(reader.nextToken());
    	int y1 = Integer.parseInt(reader.nextToken());
    	int x2 = Integer.parseInt(reader.nextToken());
    	int y2 = Integer.parseInt(reader.nextToken());
    	k = npt++;
    	rects[i][0] = x1;
    	rects[i][1] = x2;
    	rects[i][2] = y1;
    	rects[i][3] = y2;
    	rects[i][4] = 1;
    	for(int j = 0; j < k; j++)
    	{
    		rects[npt] = intersect  (rects[j] , rects[k]);
    		if ((rects[npt][1] > rects[npt][0] && rects[npt][3] >= rects[npt][2]) || (rects[npt][1] == rects[npt][0] && rects[npt][3] > rects[npt][2]))
    		{

    	         if (rects[npt][0] == rects[k][0] && rects[npt][1] == rects[k][1] && rects[npt][2] == rects[k][2] && rects[npt][3] == rects[k][3])
    	         {  

    	            npt = k;

    	            break;

    	         }
    	         else 
    	        	 npt++;

    	     }
    	}
    }
    int perim = 0;
    for (int i = 0; i < npt; i++)
    {
    	perim += rects[i][4] * 2 * (rects[i][1] - rects[i][0] + rects[i][3] - rects[i][2]);
    }
    	
    out.println(perim);
    out.close();
	}
	
	public static int[] intersect (int[] rect1, int[] rect2)
	{
		int[] put = new int[5];
		put[0] = Math.max(rect1[0], rect2[0]);
		put[1] = Math.max(rect1[1], rect2[1]);
		put[2] = Math.min(rect1[2], rect2[2]);
		put[3] = Math.min(rect1[3], rect2[3]);
		put[4] = -1 * rect1[4] * rect2[4];
		return put;
	}
	
}
    