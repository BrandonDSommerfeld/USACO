/*
ID: bdsomme1
LANG: JAVA
TASK: ratios
*/
import java.io.*;
import java.util.*;

class ratios{
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("ratios.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
StringTokenizer reader = new StringTokenizer(f.readLine());
int[] ideal = new int[3];
ideal[0] = Integer.parseInt(reader.nextToken());
ideal[1] = Integer.parseInt(reader.nextToken());
ideal[2] = Integer.parseInt(reader.nextToken());
int[][] available = new int[3][3];
for(int i = 0; i < 3; i++)
{
	reader = new StringTokenizer(f.readLine());
	for(int j = 0; j < 3; j++)
	{
		available[i][j] = Integer.parseInt(reader.nextToken());
	}
}
int min = Integer.MAX_VALUE;
int[] combo = new int[3];
int multiple = 0;
int multiples = 0;
for(int i = 0; i <= 100; i++)
{
	int first = (available[0][0] * i) % ideal[0];
	for(int j = 0; j <= 100; j++)
	{
		int second = (available[1][0] * j) % ideal[0];
		for(int k = 0; k <= 100; k++)
		{
			try
			{
			if((ideal[0] == 0 && (k * available[2][0] + first + second) == 0) || (k * available[2][0] + first + second) % ideal[0] == 0)
			{
				//System.out.println(1 + " " + i + " " + j + " " + k);
				if((ideal[1] == 0 && (i * available[0][1] + j * available[1][1] + k * available[2][1]) == 0) || (i * available[0][1] + j * available[1][1] + k * available[2][1]) % ideal[1] == 0)
				{
				//System.out.println(2 + " " + i + " " + j + " " + k);
					if((ideal[2] == 0 && (i * available[0][2] + j * available[1][2] + k * available[2][2]) == 0) || (i * available[0][2] + j * available[1][2] + k * available[2][2]) % ideal[2] == 0)
					{
					//System.out.println(3 + " " + i + " " + j + " " + k);
						if(!(i == 0 && j == 0 && k == 0))
						{
						//System.out.println(4 + " " + i + " " + j + " " + k);
							boolean works = true;
							multiple = -1;
							if (ideal[0] != 0)
							{
								multiple = (k * available[2][0] + i * available[0][0] + j * available[1][0]) / ideal[0];
							}
							else
							{
								if ((k * available[2][0] + first + second) == 0)
								{
									multiple = -1;
								}
								else
								{
									works = false;
									//System.out.println("First " + i + " " + j + " " + k);
								}
							}
							if(multiple != -1)
							{
								if(ideal[1] != 0)
								{
									if((i * available[0][1] + j * available[1][1] + k * available[2][1]) / ideal[1] != multiple)
									{
										works = false;
										//System.out.println("Second " + i + " " + j + " " + k);
									}
								}
								else
								{
									if((i * available[0][1] + j * available[1][1] + k * available[2][1]) != 0)
									{
										works = false;
										//System.out.println("Third " + i + " " + j + " " + k);
									}
								}
							}
							else
							{
								if(ideal[1] != 0)
								{
									multiple = (i * available[0][1] + j * available[1][1] + k * available[2][1]) / ideal[1];
								}
								else
								{
									if ((i * available[0][1] + j * available[1][1] + k * available[2][1]) == 0)
									{
										multiple = -1;
									}
									else
									{
										works = false;
										//System.out.println("Fourth " + i + " " + j + " " + k);
									}
								}
							}
								if(multiple != -1)
							{
								if(ideal[2] != 0)
								{
									if((i * available[0][2] + j * available[1][2] + k * available[2][2]) / ideal[2] != multiple)
									{
										works = false;
										//System.out.println("Fifth " + i + " " + j + " " + k);
									}
								}
								else
								{
									if((i * available[0][2] + j * available[1][2] + k * available[2][2]) != 0)
									{
										works = false;
										//System.out.println("Sixth " + i + " " + j + " " + k);
									}
								}
							}
							else
							{
								if(ideal[2] != 0)
								{
									multiple = (i * available[0][2] + j * available[1][2] + k * available[2][2]) / ideal[2];
								}
								else
								{
									if ((i * available[0][2] + j * available[1][2] + k * available[2][2]) == 0)
									{
										multiple = -1;
									}
									else
									{
										works = false;
										//System.out.println("Seventh " + i + " " + j + " " + k);
									}
								}
							}
							if(works && (i + j + k) < min)
							{
								System.out.println(5 + " " + i + " " + j + " " + k);
								multiples = multiple;
								min = i + j + k;
								combo[0] = i;
								combo[1] = j;
								combo[2] = k;
							}
						}
					}
				}
			}
			}
			catch (Exception e)
			{
			
			}
		}
	}
	if(i > min)
	{
		break;
	}
}

if(multiples != 0)
{
	out.println(combo[0] + " " + combo[1] + " " + combo[2] + " " + multiples);
}
else
{
	out.println("NONE");
}

out.close();

}

public static int lcm (int in1, int in2)
{
	if(in1 == 0)
		return in2;
	if(in2 == 0)
		return in1;
	return (in1 * in2) / (gcd(in1, in2));
}

public static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 


}