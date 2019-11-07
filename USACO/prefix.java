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
for (int i = 0; i < start.length(); i++)
{
    if (possible.get(i))
    {
        
    }
    if (i > 0 && possible.get(i - 1))
    {
        
    }
    if (i > 1 && possible.get(i - 2))
    {
        
    }
    if (i > 2 && possible.get(i - 3))
    {
        
    }
    if (i > 3 && possible.get(i - 4))
    {
        
    }
    if (i > 4 && possible.get(i - 5))
    {
        
    }
    if (i > 5 && possible.get(i - 6))
    {
        
    }
    if (i > 6 && possible.get(i - 7))
    {
        
    }
    if (i > 7 && possible.get(i - 8))
    {
        
    }
    if (i > 8 && possible.get(i - 9))
    {
        
    }
    
}
        
        
        
out.close();
 }
 
}