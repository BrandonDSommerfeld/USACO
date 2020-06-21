/*
ID: bdsomme1
LANG: JAVA
TASK: twofive
*/
import java.io.*;
import java.util.*;

class twofive{
    public static int states = 6*6*6*6*6;
    public static int[] snums = new int[states];
    public static int[] filled = new int[6];
    public static int[] known = new int[26];
    public static int[] kncol = new int[26];
    public static int place;
    public static void main (String[] args) throws IOException {
	BufferedReader f = new BufferedReader(new FileReader("twofive.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("twofive.out")));
    String input = f.readLine();
    long num = -1;
    String goal = "?";
    if(input.equals("N"))
    {
    	num = Long.parseLong(f.readLine());
    }
    else
    {
    	goal = f.readLine();
    }
    
    
    out.println(algorithm(num, goal));
    out.close();
    }
    public static String algorithm(long num, String goal)
    {
        String output = "";
        if(num != -1)
        {
           clearfixed();
           char[] str = new char[30];
           for(int j = 1; j < 6; j++)
           {
               for(int i = 1;i < 6; i++)
                {
                    for(int k = 1; k < 26; k++)
                    {
                        if(known[k] < 0)
                        {
                            known[k] = j;
                            kncol[k] = i;
                            str[i + (j-1) * 5] = (char) (k + 64);
                            int a = numconts();
                            if(num - a < 1)
                            {
                                break;
                            }
                            num -= a;
                            known[k] = -1;
                        }
                    }
                }
           }
           for(int i = 1; i < 26; i++)
           {
               output += str[i];
           }
        }
        else
        {
           clearfixed();
           int cnum = 1;
           int cchar;
           for(int j = 1; j < 6; j++)
           {
               for(int i = 1; i < 6; i++)
               {
                    cchar = goal.charAt(i + (j-1)*5-1) - 64;
                    for(int k = 1; k < cchar; k++)
                    {
                        if(known[k] < 0)
                        {
                            known[k] = j;
                            kncol[k] = i;
                            cnum += numconts();
                            known[k] = -1;
                        }
                    }
                    known[cchar] = j;
                    kncol[cchar] = i;
               }
           }
           output += cnum;
        }
        return output;
    }

    public static String display ()
    {
        int[][] table = new int[6][6];
        String output = "";
        for(int i = 1; i < 26; i++)
        {
            if(known[i] > 0)
            {
                table[known[i]][kncol[i]] = i;
            }
        }
        for(int i = 1; i < 6; i++)
        {
            for(int j = 1; j < 6; j++)
            {
                output += ((char) (table[i][j] + 64));
            }
        }
        return output;
    }

    public static void clearfixed ()
    {
        for(int i = 1; i < 26; i++)
        {
            known[i] = -1;
        }
    }

    public static int numconts ()
    {
        filled[0] = 5;
        for(int i =1; i < 6; i++)
        {
            filled[i] = 0;
        }
        for(int i = 0; i < states-1; i++)
        {
            snums[i] = -1;
        }
        snums[states-1] = 1;
        place = 0;
        return recur();
    }

    public static int recur ()
    {
        place++;
        int a = 0;
        for(int i = 1; i < 6; i++)
        {
            a = (a*6) + filled[i];
        }
        if(snums[a] < 0)
        {
            int b = 0;
            int c = known[place];
            if(c < 0)
            {
                for(int i = 1; i < 6; i++)
                {
                    if(filled[i-1] > filled[i])
                    {
                        filled[i]++;
                        b += recur();
                        filled[i]--;
                    }
                }
            }
            else
            {
                if(filled[c-1] > filled[c] && filled[c] + 1 == kncol[place])
                {
                    filled[c]++;
                    b += recur();
                    filled[c]--;
                }
            }
            snums[a] = b;
        }
        place--;
        return snums[a];
    }

    
  
}