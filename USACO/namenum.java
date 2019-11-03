
/*
ID: bdsomme1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("namenum.out")));
    BufferedReader g = new BufferedReader(new FileReader("dict.txt"));
    TreeSet<String> namelist = new TreeSet<>();
    while(g.ready())
    {
        StringTokenizer read = new StringTokenizer(g.readLine());
        while (read.hasMoreTokens())
        {
            namelist.add(read.nextToken());
        }
    }
    String serial = f.readLine();
    ArrayList<String> legalnames = new ArrayList<>();
    for(String name: namelist)
    {
        if (possible(name, serial))
        {
            legalnames.add(name);
        }
    }
    for (String name: legalnames)
    {
        out.println(name);
    }
    if (legalnames.size() == 0)
    {
        out.println("NONE");
    }
    out.close();
}

public static boolean possible(String name, String ser)
{
    if (name.length() != ser.length() || name.contains("Q") || name.contains("Z"))
        return false;
    for (int i = 0; i < name.length(); i++)
    {
        if ((name.charAt(i) == 'A' || name.charAt(i) == 'B' 
        || name.charAt(i) == 'C') && ser.charAt(i) != '2')
        {
            return false;
        }
        else if ((name.charAt(i) == 'D' || name.charAt(i) == 'E' 
        || name.charAt(i) == 'F') && ser.charAt(i) != '3')
        {
            return false;
        }
        else if ((name.charAt(i) == 'G' || name.charAt(i) == 'H' 
        || name.charAt(i) == 'I') && ser.charAt(i) != '4')
        {
            return false;
        }
        else if ((name.charAt(i) == 'J' || name.charAt(i) == 'K' 
        || name.charAt(i) == 'L') && ser.charAt(i) != '5')
        {
            return false;
        }
        else if ((name.charAt(i) == 'M' || name.charAt(i) == 'N' 
        || name.charAt(i) == 'O') && ser.charAt(i) != '6')
        {
            return false;
        }
        else if ((name.charAt(i) == 'P' || name.charAt(i) == 'R' 
        || name.charAt(i) == 'S') && ser.charAt(i) != '7')
        {
            return false;
        }
        else if ((name.charAt(i) == 'T' || name.charAt(i) == 'U' 
        || name.charAt(i) == 'V') && ser.charAt(i) != '8')
        {
            return false;
        }
        else if ((name.charAt(i) == 'W' || name.charAt(i) == 'X' 
        || name.charAt(i) == 'Y') && ser.charAt(i) != '9')
        {
            return false;
        }
    }
    return true;
}
}
