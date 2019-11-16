/*
ID: bdsomme1
LANG: JAVA
TASK: concom
*/
import java.io.*;
import java.util.*;
import javax.script.*;

class concom {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("concom.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
    
int companies = Integer.parseInt(f.readLine());
int[][] owners = new int[companies][3];
for (int i = 0; i < companies; i++)
{
	StringTokenizer reader = new StringTokenzer(f.readLine());
	owners[i][0] = Integer.parseInt(reader.nextToken());
	owners[i][1] = Integer.parseInt(reader.nextToken());
	owners[i][2] = Integer.parseInt(reader.nextToken());
}

out.close();
}

}