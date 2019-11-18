/*
ID: bdsomme1
LANG: JAVA
TASK: cowtour
*/
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class cowtour {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
    
int num = Integer.parseInt(f.readLine());
int[][] pastures = new int[num][2];
for (int i = 0; i < num; i++)
{
    StringTokenizer reader = new StringTokenizer(f.readLine());
    pastures[i][0] = Integer.parseInt(reader.nextToken());
    pastures[i][1] = Integer.parseInt(reader.nextToken());
}
double[][] distance = new double[num][num];
for (int i = 0; i < num; i++)
{
    String boi = f.readLine();
    for(int j = 0; j < num; j++)
    {
        int connected = Integer.parseInt(boi.substring(j, j+ 1));
        if (connected == 1)
        {
        distance[i][j] = Math.hypot(pastures[i][0] - pastures[j][0]
                , pastures[i][1] - pastures[j][1]);
            }
        else
        {
            distance[i][j] = 0;
            }
    }
}




double[][] shortest = algorithm(distance);
ArrayList<HashSet<Integer>> separates = new ArrayList<>();
for(int i = 0; i < num; i++)
{
    if (!inside(separates, i))
    {
        HashSet<Integer> temp = new HashSet<>();
        temp.add(i);
        for(int j = i + 1; j < num; j++)
        {
            if (!equals(shortest[i][j], 0))
            {
                temp.add(j);
            }
        }
        separates.add(temp);
    }
}

double[] diams = new double[num];
for(HashSet<Integer> set1: separates)
{
for(Integer nu: set1)
{
    ArrayList<Double> lengs = new ArrayList<>();
    for(Integer boi: set1)
    {
        if(nu != boi)
        {
            lengs.add(shortest[nu][boi]);
        }
    }
    double max = 0;
    for(int i = 0; i < lengs.size(); i++)
    {
        if(lengs.get(i) > max)
        {
            max = lengs.get(i);
        }
    }
    diams[nu] = max;
}
}


double lowest = Integer.MAX_VALUE;
for(HashSet<Integer> set1: separates)
{
for(HashSet<Integer> set2: separates)
{
if(!set1.equals(set2))
{
for(Integer green: set1)
{
    for(Integer ladybug: set2)
    {
        double d = diams[green] + diams[ladybug] + 
        Math.hypot(pastures[green][0] - pastures[ladybug][0]
        , pastures[green][1] - pastures[ladybug][1]);
        if (d < lowest)
        {
            lowest = d;
        }
    }
}
}
}
}
double possible = findmax(shortest);
if (possible > lowest)
{
    lowest = possible;
}
DecimalFormat format = new DecimalFormat("#######################.000000");
out.println(format.format(lowest));
out.close();
}



public static double[][] algorithm (double[][] distance)
{
    double[][] distances = distance.clone();
    int num = distance.length;
    boolean change = true;
    while (change)
    {
    change = false;
    for(int k = 0; k < num; k++)
{
    for(int i = 0; i < num; i++)
    {
        for(int j = 0; j < num; j++)
        {
            if((distances[i][j] == 0 || distances[i][k] + distances[k][j] < distances[i][j]) && distances[i][k] != 0 && distances[k][j] != 0 && i != j)
            {
                distances[i][j] = distances[i][k] + distances[k][j];
                change = true;
            }
        }
    }
}
}
return distances;

}

public static double findmax (double[][] distances)
{
double max = 0;
for (int i = 0; i < distances.length; i++)
{
    for(int j = 0; j < distances.length; j++)
    {
        if (distances[i][j] > max)
        {
            max = distances[i][j];
        }
    }
}

return max;
}

public static boolean equals (double d1, double d2)
{
    return Math.abs(d1 - d2) < 0.001;
}

public static boolean inside(ArrayList<HashSet<Integer>> separates, int i)
{
    for(int count = 0; count < separates.size(); count++)
    {
        if(separates.get(count).contains(i))
        {
            return true;
        }
    }
    return false;
}
}
