/*
ID: bdsomme1
LANG: JAVA
TASK: fracdec
*/
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

class fracdec {
  public static void main (String [] args) throws IOException {
BufferedReader f = new BufferedReader(new FileReader("fracdec.in"));
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));

StringTokenizer reader = new StringTokenizer(f.readLine());
int num = Integer.parseInt(reader.nextToken());
int denom = Integer.parseInt(reader.nextToken());
int left = num/denom;
long r = num % denom;
DecimalFormat fmt = new DecimalFormat("0000000000.");
fmt.setRoundingMode(RoundingMode.FLOOR);
String ongoing = "";
boolean finished = false;
while(!finished)
{
	long boi = 1000000000;
	boi *= 10;
	long nextdigits = (r*boi) / denom;
	r = (r*boi) % denom;
	String boyo = fmt.format(nextdigits).toString();
	boyo = boyo.substring(0, boyo.length() - 1);
	String tempy;
	if (ongoing.length() > 17)
	{
		tempy = ongoing.substring(0, 17);
	}
	else
	{
		tempy = ongoing;
	}
	if(tempy.indexOf(boyo) == -1)
	{
		ongoing += boyo;
	}
	else if (nextdigits == 0)
	{
		boolean stop = false;
		for(int i = ongoing.length() - 1; i > 0 && !stop; i--)
		{
			if(ongoing.charAt(i) == '0')
			{
				ongoing = ongoing.substring(0, i);
			}
			else
			{
				stop = true;
			}
		}
		finished = true;
	}
	else
	{
		int maxboi = repeat(ongoing);
		String extra = shortcheck(ongoing);
		if (extra.length() < ongoing.length())
		{
			ongoing= extra;
		}
		else
		{
		String repeat = ongoing.substring(maxboi);
		ongoing = ongoing.substring(0, maxboi);
		int start = ongoing.indexOf(repeat);
		ongoing = ongoing.substring(0, start) + "(" + ongoing.substring(start) + ")";
		}
		finished = true;
	}
}

ongoing = left + "." + ongoing;
int count = 0;
while((count + 1) * 76 < ongoing.length())
{
	out.println(ongoing.substring(count*76, (count+1) * 76));
	count++;
}
out.println(ongoing.substring(count*76));

out.close();
}


public static int repeat (String ongoing)
{
	int foundbefore = ongoing.length();
	String first;
	if (ongoing.length() > 20)
	{
		first = ongoing.substring(0, 20);
	}
	else
	{
		first = ongoing;
	}
	for(int i = ongoing.length() - 1; i >= 0; i--)
	{
		int place = first.indexOf(ongoing.substring(i));
		if (place == -1)
		{
			return i + 1;
		}
	}
	return 0;
}


public static String shortcheck(String ongoing)
{
	int lengboi = ongoing.length();
	if (ongoing.charAt(lengboi - 1) == ongoing.charAt(lengboi - 2)
	&& ongoing.charAt(lengboi - 3) == ongoing.charAt(lengboi - 2)
	&& ongoing.charAt(lengboi - 3) == ongoing.charAt(lengboi - 4))
	{
		char repeat = ongoing.charAt(lengboi);
		while(ongoing.charAt(ongoing.length()-1) == repeat)
		{
			ongoing = ongoing.substring(0, ongoing.length() - 1);
		}
		ongoing = ongoing + "(" + repeat + ")";
	}
	else if (ongoing.charAt(lengboi - 1) == ongoing.charAt(lengboi - 3)
	&& ongoing.charAt(lengboi - 4) == ongoing.charAt(lengboi - 2))
	{
		String repeat = ongoing.substring(ongoing.length() - 2);
		String other = ongoing.substring(ongoing.length()-3, ongoing.length()-1);
		int first = ongoing.indexOf(repeat);
		int second = ongoing.indexOf(other);
		if (first < second)
		{
			ongoing = ongoing.substring(0, first) + "(" + repeat + ")";
		}
		else
		{
			ongoing = ongoing.substring(0, second) + "(" + other + ")";
		}
	}
	else if(ongoing.charAt(lengboi - 1) == ongoing.charAt(lengboi - 4)
	&& ongoing.charAt(lengboi - 5) == ongoing.charAt(lengboi - 2)
	&& ongoing.charAt(lengboi - 3) == ongoing.charAt(lengboi - 6))
	{
		String repeat = ongoing.substring(ongoing.length() - 3);
		String other = ongoing.substring(ongoing.length()-4, ongoing.length()-1);
		String other2 = ongoing.substring(ongoing.length()-5, ongoing.length()-2);
		int first = ongoing.indexOf(repeat);
		int second = ongoing.indexOf(other);
		int third = ongoing.indexOf(other2);
		if (first < second && first < third)
		{
			ongoing = ongoing.substring(0, first) + "(" + repeat + ")";
		}
		else if (second < third)
		{
			ongoing = ongoing.substring(0, second) + "(" + other + ")";
		}
		else
		{
			ongoing = ongoing.substring(0, third) + "(" + other2 + ")";
		}
	}
	else if(ongoing.charAt(lengboi - 1) == ongoing.charAt(lengboi - 5)
	&& ongoing.charAt(lengboi - 6) == ongoing.charAt(lengboi - 2)
	&& ongoing.charAt(lengboi - 3) == ongoing.charAt(lengboi - 7)
	&& ongoing.charAt(lengboi - 4) == ongoing.charAt(lengboi - 8))
	{
		String repeat = ongoing.substring(ongoing.length() - 4);
		String other = ongoing.substring(ongoing.length()-5, ongoing.length()-1);
		String other2 = ongoing.substring(ongoing.length()-6, ongoing.length()-2);
		String other3 = ongoing.substring(ongoing.length()-7, ongoing.length()-3);
		int first = ongoing.indexOf(repeat);
		int second = ongoing.indexOf(other);
		int third = ongoing.indexOf(other2);
		int fourth = ongoing.indexOf(other3);
		if (first < second && first < third && first < fourth)
		{
			ongoing = ongoing.substring(0, first) + "(" + repeat + ")";
		}
		else if (second < third && second < fourth)
		{
			ongoing = ongoing.substring(0, second) + "(" + other + ")";
		}
		else if(third < fourth)
		{
			ongoing = ongoing.substring(0, third) + "(" + other2 + ")";
		}
		else
		{
			ongoing = ongoing.substring(0, fourth) + "(" + other3 + ")";
		}
	}
	else if (ongoing.charAt(lengboi - 1) == ongoing.charAt(lengboi - 6)
	&& ongoing.charAt(lengboi - 7) == ongoing.charAt(lengboi - 2)
	&& ongoing.charAt(lengboi - 3) == ongoing.charAt(lengboi - 8)
	&& ongoing.charAt(lengboi - 4) == ongoing.charAt(lengboi - 9)
	&& ongoing.charAt(lengboi - 5) == ongoing.charAt(lengboi - 10))
	{
		String repeat = ongoing.substring(ongoing.length() - 5);
		String other = ongoing.substring(ongoing.length()-6, ongoing.length()-1);
		String other2 = ongoing.substring(ongoing.length()-7, ongoing.length()-2);
		String other3 = ongoing.substring(ongoing.length()-8, ongoing.length()-3);
		String other4 = ongoing.substring(ongoing.length()-9, ongoing.length()-4);
		int first = ongoing.indexOf(repeat);
		int second = ongoing.indexOf(other);
		int third = ongoing.indexOf(other2);
		int fourth = ongoing.indexOf(other3);
		int fifth = ongoing.indexOf(other4);
		if (first < second && first < third && first < fourth && first < fifth)
		{
			ongoing = ongoing.substring(0, first) + "(" + repeat + ")";
		}
		else if (second < third && second < fourth && second < fifth)
		{
			ongoing = ongoing.substring(0, second) + "(" + other + ")";
		}
		else if(third < fourth && third < fifth)
		{
			ongoing = ongoing.substring(0, third) + "(" + other2 + ")";
		}
		else if (fourth < fifth)
		{
			ongoing = ongoing.substring(0, fourth) + "(" + other3 + ")";
		}
		else
		{
			ongoing = ongoing.substring(0, fifth) + "(" + other4 + ")";
		}
	}
	else if (ongoing.charAt(lengboi - 1) == ongoing.charAt(lengboi - 7)
	&& ongoing.charAt(lengboi - 8) == ongoing.charAt(lengboi - 2)
	&& ongoing.charAt(lengboi - 3) == ongoing.charAt(lengboi - 9)
	&& ongoing.charAt(lengboi - 4) == ongoing.charAt(lengboi - 10)
	&& ongoing.charAt(lengboi - 5) == ongoing.charAt(lengboi - 11)
	&& ongoing.charAt(lengboi - 6) == ongoing.charAt(lengboi - 12))
	{
		String repeat = ongoing.substring(ongoing.length() - 6);
		String other = ongoing.substring(ongoing.length()-7, ongoing.length()-1);
		String other2 = ongoing.substring(ongoing.length()-8, ongoing.length()-2);
		String other3 = ongoing.substring(ongoing.length()-9, ongoing.length()-3);
		String other4 = ongoing.substring(ongoing.length()-10, ongoing.length()-4);
		String other5 = ongoing.substring(ongoing.length()-11, ongoing.length()-5);
		int first = ongoing.indexOf(repeat);
		int second = ongoing.indexOf(other);
		int third = ongoing.indexOf(other2);
		int fourth = ongoing.indexOf(other3);
		int fifth = ongoing.indexOf(other4);
		int sixth = ongoing.indexOf(other5);
		if (first < second && first < third && first < fourth && first < fifth && first < sixth)
		{
			ongoing = ongoing.substring(0, first) + "(" + repeat + ")";
		}
		else if (second < third && second < fourth && second < fifth && second < sixth)
		{
			ongoing = ongoing.substring(0, second) + "(" + other + ")";
		}
		else if(third < fourth && third < fifth && third < sixth)
		{
			ongoing = ongoing.substring(0, third) + "(" + other2 + ")";
		}
		else if (fourth < fifth && fourth < sixth)
		{
			ongoing = ongoing.substring(0, fourth) + "(" + other3 + ")";
		}
		else if (fifth < sixth)
		{
			ongoing = ongoing.substring(0, fifth) + "(" + other4 + ")";
		}
		else
		{
			ongoing = ongoing.substring(0, sixth) + "(" + other5 + ")";
		}
	}
	return ongoing;
}

}
