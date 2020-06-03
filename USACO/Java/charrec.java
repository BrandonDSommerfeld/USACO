/*
ID: bdsomme1
LANG: JAVA
TASK: charrec
*/
import java.io.*;
import java.util.*;

class charrec{
	
	public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("charrec.in"));
	BufferedReader ideal = new BufferedReader(new FileReader("font.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("charrec.out")));
    
    ideal.readLine();
    boolean[][][] characters = new boolean[27][20][20];
    for(int i = 0; i < 27; i++)
    {
    	for(int j = 0; j < 20; j++)
    	{
    		String line = ideal.readLine();
    		for(int k = 0; k < 20; k++)
    		{
    			if(line.charAt(k) == '1')
    			{
    				characters[i][j][k] = true;
    			}
    		}
    	}
    }
    
    int lines = Integer.parseInt(f.readLine());
    boolean[][] input = new boolean[lines][20];
    for(int l = 0; l < lines; l++)
    {
    	String keep = f.readLine();
    	for(int c = 0; c < 20; c++)
    	{
    		if(keep.charAt(c) == '1')
    		{
    			input[l][c] = true;
    		}
    	}
    }
    
    boolean[] backwards = new boolean[lines];
    backwards[lines-1] = true;
    backwards[lines-19] = true;
    if(lines > 19)
    {
    	backwards[lines-20] = true;
    }
    if(lines > 20)
    {
    	backwards[lines-21] = true;
    }
    for(int i = lines-19; i >= 0; i--)
    {
    	if(backwards[i])
    	{
    		try
    		{
    			backwards[i-19] = true;
    		}
    		catch (Exception e) {}
    		try
    		{
    			backwards[i-20] = true;
    		}
    		catch (Exception e) {}
    		try
    		{
    			backwards[i-21] = true;
    		}
    		catch (Exception e) {}
    	}
    }
    int[] smallest = new int[lines];
    for(int i = 1; i < lines; i++)
    {
    	smallest[i] = -1;
    }
    String[] sequence = new String[lines];
    sequence[0] = "";
    for(int i = 0; i < lines; i++)
    {
    	if(i == 0)
    	{
    		if(i + 18 < lines)
    		{
    			int[] best = removed(characters, input, i);
    			if(smallest[i+18] == -1 || smallest[i] + best[0] < smallest[i+18])
    			{
    				smallest[i+18] = smallest[i] + best[0];
    				char next = (char) (best[1] + 96);
    				if(best[1] == 0)
    				{
    					next = ' ';
    				}
    				if(best[0] > 114)
    				{
    					next = '?';
    				}
    				sequence[i+18] = sequence[i] + next;
    			}
    		}
    		if(i + 19 < lines)
    		{
    			int[] best = regular(characters, input, i);
    			if(smallest[i+19] == -1 || smallest[i] + best[0] < smallest[i+19])
    			{
    				smallest[i+19] = smallest[i] + best[0];
    				char next = (char) (best[1] + 96);
    				if(best[1] == 0)
    				{
    					next = ' ';
    				}
    				if(best[0] > 120)
    				{
    					next = '?';
    				}
    				sequence[i+19] = sequence[i] + next;
    			}
    		}
    		if(i + 20 < lines)
    		{
    			int[] best = duplicated(characters, input, i);
    			if(smallest[i+20] == -1 || smallest[i] + best[0] < smallest[i+20])
    			{
    				smallest[i+20] = smallest[i] + best[0];
    				char next = (char) (best[1] + 96);
    				if(best[1] == 0)
    				{
    					next = ' ';
    				}
    				if(best[0] > 126)
    				{
    					next = '?';
    				}
    				sequence[i+20] = sequence[i] + next;
    			}
    		}
    	}
    	else if (smallest[i] != -1)
    	{
    		if(i + 19 < lines && backwards[i+19])
    		{
    			int[] best = removed(characters, input, i+1);
    			if(smallest[i+19] == -1 || smallest[i] + best[0] < smallest[i+19])
    			{
    				smallest[i+19] = smallest[i] + best[0];
    				char next = (char) (best[1] + 96);
    				if(best[1] == 0)
    				{
    					next = ' ';
    				}
    				if(best[0] > 114)
    				{
    					next = '?';
    				}
    				sequence[i+19] = sequence[i] + next;
    			}
    		}
    		if(i + 20 < lines && backwards[i+20])
    		{
    			int[] best = regular(characters, input, i+1);
    			if(smallest[i+20] == -1 || smallest[i] + best[0] < smallest[i+20])
    			{
    				smallest[i+20] = smallest[i] + best[0];
    				char next = (char) (best[1] + 96);
    				if(best[1] == 0)
    				{
    					next = ' ';
    				}
    				if(best[0] > 120)
    				{
    					next = '?';
    				}
    				sequence[i+20] = sequence[i] + next;
    			}
    		}
    		if(i + 21 < lines && backwards[i+21])
    		{
    			int[] best = duplicated(characters, input, i+1);
    			if(smallest[i+21] == -1 || smallest[i] + best[0] < smallest[i+21])
    			{
    				smallest[i+21] = smallest[i] + best[0];
    				char next = (char) (best[1] + 96);
    				if(best[1] == 0)
    				{
    					next = ' ';
    				}
    				if(best[0] > 126)
    				{
    					next = '?';
    				}
    				sequence[i+21] = sequence[i] + next;
    			}
    		}
    	}
    }
    out.println(sequence[lines-1]);
    out.close();
	}
	
	public static int[] removed (boolean[][][] characters, boolean[][] current, int start)
	{
		int[] result = new int[2];
		result[0] = 1000;
		for(int c = 0; c < 27; c++)
		{
			for(int skip = start; skip < start+20; skip++)
			{
				int count = 0;
				for(int row = start; row < start+19; row++)
				{
					for(int col = 0; col < 20; col++)
					{
						if(row < skip)
						{
							if(characters[c][row-start][col] ^ current[row][col])
							{
								count++;
							}
						}
						else
						{
							if(characters[c][row+1-start][col] ^ current[row][col])
							{
								count++;
							}
						}
					}
					if(count >= result[0])
					{
						break;
					}
				}
				if(count < result[0])
				{
					result[0] = count;
					result[1] = c;
				}
				
			}
			
		}
		return result;
	}
	
	public static int[] regular (boolean[][][] characters, boolean[][] current, int start)
	{
		int[] result = new int[2];
		result[0] = 1000;
		for(int c = 0; c < 27; c++)
		{
				int count = 0;
				for(int row = start; row < start+20; row++)
				{
					for(int col = 0; col < 20; col++)
					{
						
						if(characters[c][row-start][col] ^ current[row][col])
						{
							count++;
						}
					}
					if(count >= result[0])
					{
						break;
					}
				}
				if(count < result[0])
				{
					result[0] = count;
					result[1] = c;
				}
				
		}
		return result;
	}
	
	public static int[] duplicated (boolean[][][] characters, boolean[][] current, int start)
	{
		int[] result = new int[2];
		result[0] = 1000;
		for(int c = 0; c < 27; c++)
		{
			for(int dup = start; dup < start+20; dup++)
			{
				int count = 0;
				for(int row = start; row < start+20; row++)
				{
					if(row != dup)
					{
						for(int col = 0; col < 20; col++)
						{
							if(row < dup)
							{
								if(characters[c][row-start][col] ^ current[row][col])
								{
									count++;
								}
							}
							else if (row > dup)
							{
								if(characters[c][row-start][col] ^ current[row+1][col])
								{
									count++;
								}
							}
							
						}
					}
					else
					{
						int lower = 25;
						int corrs1 = 0;
						int corrs2 = 0;
						for(int col = 0; col < 20; col++)
						{
							if(characters[c][row-start][col] ^ current[row][col])
							{
								corrs1++;
							}
							if(characters[c][row-start][col] ^ current[row+1][col])
							{
								corrs2++;
							}
						}
						lower = corrs1;
						if(corrs2 < lower)
						{
							lower = corrs2;
						}
						count += lower;
					}
					if(count >= result[0])
					{
						break;
					}
				}
				if(count < result[0])
				{
					result[0] = count;
					result[1] = c;
				}
				
			}
			
		}
		return result;
	}
}
    