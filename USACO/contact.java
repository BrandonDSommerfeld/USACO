/*
ID: bdsomme1
LANG: JAVA
TASK: contact
*/
import java.io.*;
import java.util.*;
import javax.script.*;

class contact {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("contact.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
    
StringTokenizer reader = new StringTokenizer(f.readLine());
int min = Integer.parseInt(reader.nextToken());
int max = Integer.parseInt(reader.nextToken());
int num = Integer.parseInt(reader.nextToken());

String first = f.readLine();
ArrayList<String> lines = new ArrayList<>();
while(first != null)
{
	lines.add(first);
	first = f.readLine();
}




out.close();
}
}