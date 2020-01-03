
/*
ID: bdsomme1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2 {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("milk2.out")));
    int farmers = Integer.parseInt(f.readLine());
    StringTokenizer reader = new StringTokenizer(f.readLine());
    ArrayList<Integer> starts = new ArrayList<>();
    ArrayList<Integer> ends = new ArrayList<>();
    starts.add(Integer.parseInt(reader.nextToken()));
    ends.add(Integer.parseInt(reader.nextToken()));
    int stime, etime;
    for (int i = 0; i < farmers - 1; i++)
    {
        StringTokenizer read = new StringTokenizer(f.readLine());
        stime = Integer.parseInt(read.nextToken());
        etime = Integer.parseInt(read.nextToken());
        int scounter = 0, ecounter = 0;
        while (scounter < starts.size() && starts.get(scounter) < stime)
        {
            scounter++;
        }
        while (ecounter < ends.size() && ends.get(ecounter) < etime)
        {
            ecounter++;
        }
        if (scounter <= ecounter)
        {
        for (int count = 0; count < ecounter - scounter; count++)
        {
            starts.remove(scounter);
            ends.remove(scounter);
        }
        if ((scounter != 0 && ends.get(scounter - 1) >= stime) && 
        (scounter != starts.size() && starts.get(scounter) <= etime))
        {
            ends.remove(scounter - 1);
            starts.remove(scounter);
        }
        else if (scounter != 0 && ends.get(scounter - 1) >= stime)
        {
            ends.set(scounter - 1, etime);
        }
        else if (scounter != starts.size() && starts.get(scounter) <= etime)
        {
             starts.set(scounter, stime);
        }
        else
        {
            starts.add(scounter, stime);
            ends.add(scounter, etime);
        }
    }
    }
    int maxidle = 0, maxwork = 0;
    for (int i = 0; i < starts.size(); i++)
    {
        if (ends.get(i) - starts.get(i) > maxwork)
            maxwork = ends.get(i) - starts.get(i);
        if (i > 0 && starts.get(i) - ends.get(i-1) > maxidle)
            maxidle = starts.get(i) - ends.get(i-1);
    }
    out.println(maxwork + " " + maxidle);
    out.close();
  }

}
