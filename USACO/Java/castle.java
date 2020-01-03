/*
ID: bdsomme1
LANG: JAVA
TASK: castle
*/
import java.io.*;
import java.util.*;


class castle {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("castle.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int columns = Integer.parseInt(reader.nextToken());
    int rows = Integer.parseInt(reader.nextToken());
    
    int[][] castle = new int[rows][columns];
    int[][] newcastle = new int[rows][columns];
    for (int i = 0; i < rows; i++)
    {
        reader = new StringTokenizer(f.readLine());
        for (int j = 0; j < columns; j++)
        {
            castle[i][j] = Integer.parseInt(reader.nextToken());
            newcastle[i][j] = 0;
        }
    }
    
    
    Stack<int[]> stacc = new Stack<>();
    int count = 1;
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            if (newcastle[i][j] == 0)
            {
                int[] start = {i, j};
                stacc.add(start);
                while(!stacc.empty())
                {
                    int[] temp1 = stacc.pop();
                    int row = temp1[0], column = temp1[1];
                    newcastle[row][column] = count;
                    
                    String temp = Integer.toBinaryString(
                    castle[row][column]);
                    ArrayList<Boolean> neighbors = binaryread(temp);
                    if (!neighbors.get(0) && newcastle[row + 1][column] == 0)
                    {
                        newcastle[row+1][column] = -1;
                        int[] temp2 = {row + 1, column};
                        stacc.add(temp2);
                    }
                    if (!neighbors.get(1) && newcastle[row][column + 1] == 0)
                    {
                        newcastle[row][column + 1] = -1;
                        int[] temp2 = {row, column + 1};
                        stacc.add(temp2);
                    }
                    if (!neighbors.get(2) && newcastle[row - 1][column] == 0)
                    {
                        newcastle[row-1][column] = -1;
                        int[] temp2 = {row - 1, column};
                        stacc.add(temp2);
                    }
                    if (!neighbors.get(3) && newcastle[row][column - 1] == 0)
                    {
                        newcastle[row][column - 1] = -1;
                        int[] temp2 = {row, column - 1};
                        stacc.add(temp2);
                    }
                }
                count++;
            }
        }
    }
    out.println(count - 1);
    
    
    ArrayList<Integer> counter = new ArrayList<>();
    for(int i = 0; i < count - 1; i++)
    {
        counter.add(0);
    }
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            counter.set(newcastle[i][j] -  1, counter.get(newcastle[i][j] - 1) + 1);
        }
    }
    
    out.println(max(counter));
    
    
    ArrayList<ArrayList<Object>> combined = new ArrayList<>();
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns - 1; j++)
        {
            if (newcastle[i][j] != newcastle[i][j+1])
            {
                ArrayList<Object> tempy = new ArrayList<>();
                tempy.add(counter.get(newcastle[i][j] - 1) +
                counter.get(newcastle[i][j+1] - 1));
                tempy.add(i + 1);
                tempy.add(j + 1);
                tempy.add("E");
                combined.add(tempy);
            }
        }
    }
    
    
    for (int i = 0; i < rows - 1; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            if (newcastle[i][j] != newcastle[i + 1][j])
            {
                ArrayList<Object> tempy = new ArrayList<>();
                tempy.add(counter.get(newcastle[i][j] - 1) +
                counter.get(newcastle[i + 1][j] - 1));
                tempy.add(i + 2);
                tempy.add(j + 1);
                tempy.add("N");
                combined.add(tempy);
            }
        }
    }
    
    
    ArrayList<Integer> doubleroom = new ArrayList<>();
    for (int i = 0; i < combined.size(); i++)
    {
        doubleroom.add(((int) combined.get(i).get(0)));
    }
    
    ArrayList<Object> best = combined.get(findmax(combined));
    out.println(best.get(0));
    out.println(best.get(1) + " " + best.get(2) + " " + best.get(3));
    out.close();
}

public static int findmax (ArrayList<ArrayList<Object>> in)
{   
    int maxplace = 0;
    for (int i = 0; i < in.size(); i++)
    {
        if (((int) in.get(i).get(0)) > ((int) in.get(maxplace).get(0)))
        {
            maxplace = i;
        }
        else if (((int) in.get(i).get(0)) == ((int) in.get(maxplace).get(0)))
        {
            if (((int) in.get(i).get(2)) < ((int) in.get(maxplace).get(2)))
            {
                maxplace = i;
            }
            else if (((int) in.get(i).get(2)) == ((int) in.get(maxplace).get(2)))
            {
                if (((int) in.get(i).get(1)) > ((int) in.get(maxplace).get(1)))
                {
                    maxplace = i;
                }
                else if (((int) in.get(i).get(1)) == ((int) in.get(maxplace).get(1)))
                {
                    if(((String) in.get(i).get(3)).equals("N"))
                    {
                        maxplace = i;
                    }
                }
            }
        }
    }
    
    return maxplace;
}

public static int max (ArrayList<Integer> in)
{
    int max = in.get(0);
    for (int i = 1; i < in.size(); i++)
    {
        if(in.get(i) > max)
        {
            max = in.get(i);
        }
    }
    return max;
}

public static ArrayList<Boolean> binaryread (String num)
{
    ArrayList<Boolean> temp = new ArrayList<>();
    
    if(num.length() == 1)
    {
        temp.add(false);
        temp.add(false);
        temp.add(false);
        if (num.equals("0"))
        {
            temp.add(false);
        }
        else
        {
            temp.add(true);
        }
    }
    else if(num.length() == 2)
    {
        temp.add(false);
        temp.add(false);
        temp.add(true);
        if(num.charAt(1) == '0')
            temp.add(false);
        else
            temp.add(true);
    }
    else if(num.length() == 3)
    {
        temp.add(false);
        temp.add(true);
        if(num.charAt(1) == '0')
            temp.add(false);
        else
            temp.add(true);
        if(num.charAt(2) == '0')
            temp.add(false);
        else
            temp.add(true);
    }
    else
    {
        temp.add(true);
        if(num.charAt(1) == '0')
            temp.add(false);
        else
            temp.add(true);
        if(num.charAt(2) == '0')
            temp.add(false);
        else
            temp.add(true);
        if(num.charAt(3) == '0')
            temp.add(false);
        else
            temp.add(true);
    }
    return temp;
}
}