/*
ID: bdsomme1
LANG: JAVA
TASK: zerosum
*/
import java.io.*;
import java.util.*;
import javax.script.*;

class zerosum {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
    
        int n = Integer.parseInt(f.readLine());
        ArrayList<String> ways = generate(n);
        Collections.sort(ways);
        for(int i = 0; i < ways.size(); i++)
        {
                if (evaluate(ways.get(i)))
                    out.println(ways.get(i));
        }   
        
        out.close();
}



public static ArrayList<String> generate(int num)
{
    ArrayList<String> temp = new ArrayList<>();
    if (num == 1)
    {
        String boi = "1";
        temp.add(boi);
    }
    else
    {
        ArrayList<String> previous = generate(num - 1);
        for (int i = 0; i < previous.size(); i++)
        {
            String current = previous.get(i);
            temp.add(current + "+" + num);
            
            temp.add(current + "-" + num);
            if (num == 2 || current.charAt(current.length() - 2) != ' ')
            {
              temp.add(current + " " + num);   
            }
        }
    }
    return temp;
}


public static boolean evaluate (String in)
{
    StringTokenizer reader = new StringTokenizer(in);
    String input = "";
    while(reader.hasMoreTokens())
    {
        input += reader.nextToken();
    }
    return (toInt(input) == 0);
}


public static int toInt (String in)
{
    String input = "+" + in;
    Scanner scan = new Scanner(input);
    scan.useDelimiter("\\+|\\-");
    ArrayList<String> nums = new ArrayList<>();
    while(scan.hasNext())
    {
        nums.add(scan.next());
    }
    int ongoing = 0;
    int num = 0;
    for(int i = 0; i < input.length(); i++)
    {
        if(input.charAt(i) == '+')
        {
            ongoing += Integer.parseInt(nums.get(num));
            num++;
        }
        else if (input.charAt(i) == '-')
        {
            ongoing -= Integer.parseInt(nums.get(num));
            num++;
        }
    }
    return ongoing;
}


}