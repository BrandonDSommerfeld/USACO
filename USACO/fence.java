/*
ID: bdsomme1
LANG: JAVA
TASK: fence
*/
import java.io.*;
import java.util.*;

class fence {
  public static void main (String [] args) throws IOException {
  BufferedReader f = new BufferedReader(new FileReader("fence.in"));
  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
  int lines = Integer.parseInt(f.readLine());
  ArrayList<Integer>[] adj = new ArrayList[501];
  for(int i = 0; i <= 500; i++)
  {
      adj[i] = new ArrayList<>();
    }
  for(int i = 0; i < lines; i++)
  {
    StringTokenizer reader = new StringTokenizer(f.readLine());
    int first = Integer.parseInt(reader.nextToken());
    int second = Integer.parseInt(reader.nextToken());
    adj[first].add(second);
    adj[second].add(first);
  }
  for(int i = 1; i <= 500; i++)
  {
      Collections.sort(adj[i]);
  }
  
  ArrayList<Integer> path = tour(adj);
  for(int i = 0; i < path.size(); i++)
  {
      out.println(path.get(i));
  }
  

  out.close();
  }
  
  public static ArrayList<Integer> tour (ArrayList<Integer>[] adj)
  {
      ArrayList<Integer> odds = degree(adj);
      ArrayList<Integer> path = new ArrayList<>();
      if(odds.size() != 0)
      {
          
      }
      else
      {
          Stack<Integer> todo = new Stack<>();
          todo.push(1);
          while(!todo.empty())
          {
              int current = todo.pop();
              if(adj[current].size() == 0)
              {
                  
              }
              else
              {
                  int next = adj[current].get(0);
                  todo.push(next);
                  adj[current].remove(0);
                  adj[next].remove(new Integer(current));
                  path.add(current);
              }
          }
      
      
      }
      return path;
  }
  
  public static ArrayList<Integer> degree(ArrayList<Integer>[] adj)
  {
      ArrayList<Integer> temp = new ArrayList<>();
      for(int i = 1; i < adj.length; i++)
      {
          if(adj[i].size() % 2 == 1)
          {
              temp.add(i);
          }
      }
      return temp;
  }

}