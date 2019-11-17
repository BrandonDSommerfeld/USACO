/*
ID: bdsomme1
LANG: JAVA
TASK: ttwo
*/
import java.io.*;
import java.util.*;

class ttwo {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
int[][] grid = new int[10][10];
int[] johnstart = new int[2];
int[] cowstart = new int[2];
int[] johnplace = new int[2];
int[] cowplace = new int[2];
for (int i = 0; i < 10; i++)
{
	String in = f.readLine();
	for(int j = 0; j < 10; j++)
	{
		char curr = in.charAt(j);
		if (curr == '.')
		{
			grid[i][j] = 0;
		}
		else if (curr == '*')
		{
			grid[i][j] = 1;
		}
		else if (curr == 'F')
		{
			grid[i][j] = 2;
			johnstart[0] = i;
			johnstart[1] = j;
			johnplace[0] = i;
			johnplace[1] = j;
		}
		else
		{
			grid[i][j] = 3;
			cowstart[0] = i;
			cowstart[1] = j;
			cowplace[0] = i;
			cowplace[1] = j;
		}
	}
}
int[] fdir = new int[1];
int[] cdir = new int[1];
fdir[0] = 1;
cdir[0] = 1;

int count = 1;
boolean none = false;
int[] midj = new int[2];
int[] midc = new int[2];
int dirf = 0;
int dirc = 0;
while (!none && !step(grid, fdir, cdir, johnplace, cowplace))
{
	if (Arrays.equals(johnstart, johnplace) && Arrays.equals(cowstart, cowplace) && fdir[0] == 1 && cdir[0] == 1)
	{
		none = true;
		count = -1;
	}
	else if (Arrays.equals(midj, johnplace) && Arrays.equals(midc, cowplace) && fdir[0] == dirf && cdir[0] == dirc)
	{
		none = true;
		count = -1;
	}
	if (count == 50)
	{
		midj[0] = johnplace[0];
		midj[1] = johnplace[1];
		midc[0] = cowplace[0];
		midc[1] = cowplace[1];
		dirf = fdir[0];
		dirc = cdir[0];
	}
	count++;
}


out.println(count);
out.close();
}



public static boolean step(int[][] grid, int[] fdir, int[] cdir, int[] johnplace, int[] cowplace)
{
	if (fdir[0] == 1)
	{
		if (johnplace[0] == 0 || grid[johnplace[0] - 1][johnplace[1]] == 1)
		{
			fdir[0] = (fdir[0] % 4) + 1;
		}
		else
		{
			johnplace[0] -= 1;
		}
	}
	else if (fdir[0] == 2)
	{
		if (johnplace[1] == 9 || grid[johnplace[0]][johnplace[1] + 1] == 1)
		{
			fdir[0] = (fdir[0] % 4) + 1;
		}
		else
		{
			johnplace[1] += 1;
		}
	}
	else if (fdir[0] == 3)
	{
		if (johnplace[0] == 9 || grid[johnplace[0] + 1][johnplace[1]] == 1)
		{
			fdir[0] = (fdir[0] % 4) + 1;
		}
		else
		{
			johnplace[0] += 1;
		}
	}
	else
	{
		if (johnplace[1] == 0 || grid[johnplace[0]][johnplace[1] - 1] == 1)
		{
			fdir[0] = (fdir[0] % 4) + 1;
		}
		else
		{
			johnplace[1] -= 1;
		}
	}
	if (cdir[0] == 1)
	{
		if (cowplace[0] == 0 || grid[cowplace[0] - 1][cowplace[1]] == 1)
		{
			cdir[0] = (cdir[0] % 4) + 1;
		}
		else
		{
			cowplace[0] -= 1;
		}
	}
	else if (cdir[0] == 2)
	{
		if (cowplace[1] == 9 || grid[cowplace[0]][cowplace[1] + 1] == 1)
		{
			cdir[0] = (cdir[0] % 4) + 1;
		}
		else
		{
			cowplace[1] += 1;
		}
	}
	else if (cdir[0] == 3)
	{
		if (cowplace[0] == 9 || grid[cowplace[0] + 1][cowplace[1]] == 1)
		{
			cdir[0] = (cdir[0] % 4) + 1;
		}
		else
		{
			cowplace[0] += 1;
		}
	}
	else
	{
		if (cowplace[1] == 0 || grid[cowplace[0]][cowplace[1] - 1] == 1)
		{
			cdir[0] = (cdir[0] % 4) + 1;
		}
		else
		{
			cowplace[1] -= 1;
		}
	}
	return Arrays.equals(johnplace, cowplace);
}
}