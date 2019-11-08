/*
ID: bdsomme1
LANG: JAVA
TASK: prefix
*/
import java.io.*;
import java.util.*;

class prefix {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
    
        
HashSet<String> prefixes = new HashSet<>();
String temp = "";
while (!temp.equals("."))
{
    StringTokenizer reader = new StringTokenizer(f.readLine());
    while (reader.hasMoreTokens())
    {
        temp = reader.nextToken();
        prefixes.add(temp);
    }
}
        
ArrayList<Boolean> possible = new ArrayList<>();
possible.add(true);
String start = f.readLine();
int size = start.length();
boolean found= false;
int max = 0;
for (int i = 0; i < start.length() && !found; i++)
{
    if (possible.get(i) && prefixes.contains(start.substring(i, i + 1)))
    {
                    possible.add(true);
    }
    else if (i > 0 && possible.get(i - 1) && prefixes.contains(start.substring(i - 1, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 1 && possible.get(i - 2) && prefixes.contains(start.substring(i - 2, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 2 && possible.get(i - 3) && prefixes.contains(start.substring(i - 3, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 3 && possible.get(i - 4) && prefixes.contains(start.substring(i - 4, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 4 && possible.get(i - 5) && prefixes.contains(start.substring(i - 5, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 5 && possible.get(i - 6) && prefixes.contains(start.substring(i - 6, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 6 && possible.get(i - 7) && prefixes.contains(start.substring(i - 7, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 7 && possible.get(i - 8) && prefixes.contains(start.substring(i -8, i + 1)))
    {
        possible.add(true);
    }
    else if (i > 8 && possible.get(i - 9) && prefixes.contains(start.substring(i - 9, i + 1)))
    {
        possible.add(true);
    }
    else
    {
        possible.add(false);
    }
    if (check(possible))
    {
        found = true;
        max = i - 9;
    }
}

int line = size;
String temps = start;
String temp2 = f.readLine();
start += temp2;

int lines = 1;
while (temp2 != null && !found)
{
    for (int i = line; i < start.length() && !found; i++)
{
    if (possible.get(i + size - line) && prefixes.contains(start.substring(i, i + 1)))
    {
                    possible.add(true);
    }
    else if (possible.get(i - 1 + size - line) && prefixes.contains(start.substring(i - 1, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 2 + size - line) && prefixes.contains(start.substring(i - 2, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 3 + size - line) && prefixes.contains(start.substring(i - 3, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 4 + size - line) && prefixes.contains(start.substring(i - 4, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 5 + size - line) && prefixes.contains(start.substring(i - 5, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 6 + size - line) && prefixes.contains(start.substring(i - 6, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 7 + size - line) && prefixes.contains(start.substring(i - 7, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 8 + size - line) && prefixes.contains(start.substring(i -8, i + 1)))
    {
        possible.add(true);
    }
    else if (possible.get(i - 9 + size - line) && prefixes.contains(start.substring(i - 9, i + 1)))
    {
        possible.add(true);
    }
        else
        {
            possible.add(false);
        }
        if (check(possible))
        {
            found = true;
            max = i - 9 + size - line;
        }
}
    
		line = temp2.length();
		size += line;
		start = temp2;
		temp2 = f.readLine();
		
		start += temp2;
    lines++;
}
if (!found)
{
    for (int i = possible.size() - 1; i >= 0 && !found; i--)
    {
        if (possible.get(i))
        {
            max = i;
            found = true;
        }
    }
}
for (int i = possible.size() - 1; i >= possible.size() - 10; i--)
    {
        System.out.println(possible.get(i));
    }
out.println(max);
        
out.close();
}
 
 
 
 public static boolean check (ArrayList<Boolean> possible)
 {
    for (int i = possible.size() - 1; i >= possible.size() - 10; i--)
    {
        if (possible.get(i))
        {
            return false;
        }
    }
    return true;
 }
}
