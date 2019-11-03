
/*
ID: bdsomme1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter
    (new FileWriter("beads.out")));
    int length = Integer.parseInt(f.readLine());
    String necklace = f.readLine();
    int max = 0, leftC = 0, rightC = 0;
    char left = '0', right = '0', current;
    boolean stopLeft = false, stopRight = false;
    for (int i = 0; i < length; i++)
    {
        for (int j = 0; j < length && !stopLeft; j++)
        {
            if (i - j < 0)
            {
                current = necklace.charAt(i - j + length);
                if (left == '0' && current == 'b')
                {
                    left = 'b';
                }
                else if (left == '0' && current == 'r')
                {
                    left = 'r';
                }
                if (current == left || current == 'w')
                {
                    leftC++;
                }
                else
                    stopLeft = true;
            }
            else
            {
                current = necklace.charAt(i - j);
                if (left == '0' && current == 'b')
                {
                    left = 'b';
                }
                else if (left == '0' && current == 'r')
                {
                    left = 'r';
                }
                if (current == left || current == 'w')
                {
                    leftC++;
                }
                else
                    stopLeft = true;
            }
        }
        for (int j = 0; j < length && !stopRight; j++)
        {
            if (i + 1 + j >= length)
            {
                current = necklace.charAt(i + 1 + j - length);
                if (right == '0' && current == 'b')
                {
                    right = 'b';
                }
                else if (right == '0' && current == 'r')
                {
                    right = 'r';
                }
                if (current == right || current == 'w')
                {
                    rightC++;
                }
                else
                    stopRight = true;
            }
            else
            {
                current = necklace.charAt(i + 1 + j);
                if (right == '0' && current == 'b')
                {
                    right = 'b';
                }
                else if (right == '0' && current == 'r')
                {
                    right = 'r';
                }
                if (current == right || current == 'w')
                {
                    rightC++;
                }
                else
                    stopRight = true;
            }
        }
        if (leftC + rightC > max)
            max = leftC + rightC;
        leftC = 0;
        rightC = 0;
        stopLeft = false;
        stopRight = false;
        left = '0'; 
        right = '0';
    }
    
    if (max > length)
        max = length;
    out.println(max);
    out.close();
  }
}