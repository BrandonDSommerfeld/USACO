
/*
ID: bdsomme1
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

class transform {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("transform.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("transform.out")));
    int size = Integer.parseInt(f.readLine());
    char[][] osquare = new char[size][size];
    char[][] nsquare = new char[size][size];
    boolean true1 = true, true2 = true, true3 = true, true4 = true, 
    true51 = true, true52 = true, true53 = true, true6 = true;
    for (int i = 0; i < size; i++)
    {
        String input = f.readLine();
        for (int j = 0; j < size; j++)
        {
            osquare[i][j] = input.charAt(j);
        }
    }
    for (int i = 0; i < size; i++)
    {
        String input = f.readLine();
        for (int j = 0; j < size; j++)
        {
            nsquare[i][j] = input.charAt(j);
        }
    }
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            if (!(osquare[i][j] == nsquare[j][size - 1 - i]))
            {
                true1 = false;
            }
            if (!(osquare[i][j] == nsquare[size - 1 - i][size - 1 - j]))
            {
                true2 = false;
            }
            if (!(osquare[i][j] == nsquare[size - 1 - j][i]))
            {
                true3 = false;
            }
            if (!(osquare[i][j] == nsquare[i][size - 1 - j]))
            {
                true4 = false;
            }
            if (!(osquare[i][size - 1 - j] == nsquare[size - 1 - j][i]))
            {
                true51 = false;
            }
            if (!(osquare[i][size - 1 - j] == nsquare[size - 1 - i][size - 1 - j]))
            {
                true52 = false;
            }
            if (!(osquare[i][size - 1 - j] == nsquare[j][size - 1 - i]))
            {
                true53 = false;
            }
            if (!(osquare[i][j] == nsquare[i][j]))
            {
                true6 = false;
            }
        }
    }
    if (true1)
    {
        out.println("1");
    }
    else if (true2)
    {
        out.println("2");
    }
    else if (true3)
    {
        out.println("3");
    }
    else if (true4)
    {
        out.println("4");
    }
    else if (true51 || true52 || true53)
    {
        out.println("5");
    }
    else if (true6)
    {
        out.println("6");
    }
    else
    {
        out.println("7");
    }
    out.close();
}
}