
/*
ID: bdsomme1
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

class numtri {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
    int rows = Integer.parseInt(f.readLine());
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    
    int row1 = Integer.parseInt(f.readLine());
    list1.add(row1);
    
    for (int row = 2; row <= rows; row++)
    {
        StringTokenizer reader = new StringTokenizer(f.readLine());
        for (int place = 0; place <= row - 1; place++)
        {
            if (place == 0)
            {
                list2.add(Integer.parseInt(reader.nextToken()) + list1.get(0)); 
            }
            else if (place == row - 1)
            {
                list2.add(Integer.parseInt(reader.nextToken()) + list1.get(row - 2));
            }
            else
            {
                int temp = list1.get(place-1);
                int temp1 = list1.get(place);
                if (temp >= temp1)
                {
                    list2.add(temp + Integer.parseInt(reader.nextToken()));
                }
                else
                {
                    list2.add(temp1 + Integer.parseInt(reader.nextToken()));
                }
            }
        }
        list1 = list2;
        list2 = new ArrayList<>();
    }
    
    out.println(findMax(list1));
    out.close();
}

public static int findMax (ArrayList<Integer> in)
{
    int temp = in.get(0);
    for (int i = 1; i < in.size(); i++)
    {
        if (in.get(i) > temp)
        {
            temp = in.get(i);
        }   
    }
    return temp;
}
}
