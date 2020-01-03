
/*
ID: bdsomme1
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

class wormhole {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
    int holes = Integer.parseInt(f.readLine());
    ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
    for (int i = 0; i < holes; i++)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        StringTokenizer reader = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(reader.nextToken());
        int y = Integer.parseInt(reader.nextToken());
        temp.add(y);
        temp.add(x);
        grid.add(temp);
    }
        
    for (int i = 0; i < holes - 1; i++)
    {
        ArrayList<Integer> temp = grid.get(i);
        int min = grid.get(i).get(0), loc = i;
        for (int j = i + 1; j < holes; j++)
        {
            if (grid.get(j).get(0) < min)
            {
                min = grid.get(j).get(0);
                loc = j;
            }
        }
        grid.set(i, grid.get(loc));
        grid.set(loc, temp);
    }
        
    int[][] realgrid = new int[13][13];
    for (int i = 0; i < 12; i++)
    {
        for (int j = 0; j < 12; j++)
        {
            realgrid[i][j] = 0;
        }
    }
    ArrayList<ArrayList<Integer>> realpairs = new ArrayList<>();
    int row = 0, column = 0, previous = grid.get(0).get(0);
    ArrayList<Integer> whocares = new ArrayList<>();
    whocares.add(0);
    whocares.add(0);
    realgrid[0][0] = 1;
    realpairs.add(whocares);
    for (int i = 1; i < holes; i++)
    {
        
        if (grid.get(i).get(0) != previous)
        {
            row++;
            previous = grid.get(i).get(0);
            column = 0;
        }
        else{
            column++;
        }
        realgrid[row][column] = 1;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(row);
        temp.add(column);
        realpairs.add(temp);
    }
    
    HashMap<ArrayList<Integer>, ArrayList<Integer>> pairs = new HashMap<>();
    int counter = 0, iterator;
    boolean stopped = false, found = false;
    ArrayList<Integer> startinglocation, location;
    for (int i = 1; i < holes; i++)
    {
       pairs.put(realpairs.get(i), realpairs.get(0));
       pairs.put(realpairs.get(0), realpairs.get(i));
       if (holes > 2)
       {
         ArrayList<ArrayList<Integer>> temp1 = new ArrayList<>();
         int count = 0;
         for (int count1 = 0; count < holes-2; count1++)
         {
            if (count1 != 0 && count1 != i)
            {
               temp1.add(realpairs.get(count1));
               count++;
            }
         }
                
         for (int j = 1; j < holes - 2; j++)
         {
            pairs.put(temp1.get(j), temp1.get(0));
            pairs.put(temp1.get(0), temp1.get(j));
            
       if (holes > 4)
       {
         ArrayList<ArrayList<Integer>> temp2 = new ArrayList<>();
         count = 0;
         for (int count1 = 0; count < holes-4; count1++)
         {
            if (count1 != 0 && count1 != j)
            {
               temp2.add(temp1.get(count1));
               count++;
            }
         }
                    
                for (int k = 1; k < holes - 4; k++)
                {
                   pairs.put(temp2.get(k), temp2.get(0));
       pairs.put(temp2.get(0), temp2.get(k));
       if (holes > 6)
       {
         ArrayList<ArrayList<Integer>> temp3 = new ArrayList<>();
         count = 0;
         for (int count1 = 0; count < holes-6; count1++)
         {
            if (count1 != 0 && count1 != k)
            {
               temp3.add(temp2.get(count1));
               count++;
            }
         }
                      for (int l = 1; l < holes - 6; l++)
                      {
                          pairs.put(temp3.get(l), temp3.get(0));
       pairs.put(temp3.get(0), temp3.get(l));
       if (holes > 8)
       {
         ArrayList<ArrayList<Integer>> temp4 = new ArrayList<>();
         count = 0;
         for (int count1 = 0; count < holes-8; count1++)
         {
            if (count1 != 0 && count1 != l)
            {
               temp4.add(temp3.get(count1));
               count++;
            }
         }
                             for (int m = 1; m < holes - 8; m++)
                             {
                               pairs.put(temp4.get(m), temp4.get(0));
       pairs.put(temp4.get(0), temp4.get(m));
       if (holes > 10)
       {
         ArrayList<ArrayList<Integer>> temp5 = new ArrayList<>();
         count = 0;
         for (int count1 = 0; count < holes-10; count1++)
         {
            if (count1 != 0 && count1 != m)
            {
               temp5.add(temp4.get(count1));
               count++;
            }
         }
                               pairs.put(temp5.get(0), temp5.get(1));
                               pairs.put(temp5.get(1), temp5.get(0));
                               iterator = 0;
                               found = false;
                               stopped = false;
                               while (iterator < holes && !found)
                               {
                                  startinglocation = (ArrayList<Integer>) realpairs.get(iterator).clone();
                                  location = (ArrayList<Integer>) startinglocation.clone();
                                  for (int step = 0; step < 20 && !stopped; step++)
                                  {
                                        location.set(1, location.get(1) + 1);
                                        if (pairs.get(location) != null)
                                        {
                                             location = (ArrayList<Integer>) pairs.get(location).clone();
                                             if (location.equals(startinglocation))
                                                   {
                                                            counter++;
                                                            found = true;
                                                            stopped = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        stopped = true;
                                                    }
                                                }
                                                stopped = false;
                                                iterator++;
                                            }
                                        }
                                        else{
                                            iterator = 0;
                               found = false;
                               stopped = false;
                               while (iterator < holes && !found)
                               {
                                  startinglocation = (ArrayList<Integer>) realpairs.get(iterator).clone();
                                  location = (ArrayList<Integer>) startinglocation.clone();
                                  for (int step = 0; step < 20 && !stopped; step++)
                                  {
                                        location.set(1,location.get(1) + 1);
                                        if (pairs.get(location) != null)
                                        {
                                             location = (ArrayList<Integer>) pairs.get(location).clone();
                                             if (location.equals(startinglocation))
                                                   {
                                                            counter++;
                                                            found = true;
                                                            stopped = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        stopped = true;
                                                    }
                                                }
                                                stopped = false;
                                                iterator++;
                                            }
                                        }
                                    }
                                }
                                else{
                                    iterator = 0;
                               found = false;
                               stopped = false;
                               while (iterator < holes && !found)
                               {
                                  startinglocation = (ArrayList<Integer>) realpairs.get(iterator).clone();
                                  location = (ArrayList<Integer>) startinglocation.clone();
                                  for (int step = 0; step < 20 && !stopped; step++)
                                  {
                                        location.set(1, location.get(1) + 1);
                                        if (pairs.get(location) != null)
                                        {
                                             location = (ArrayList<Integer>) pairs.get(location).clone();
                                             if (location.equals(startinglocation))
                                                   {
                                                            counter++;
                                                            found = true;
                                                            stopped = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        stopped = true;
                                                    }
                                                }
                                                stopped = false;
                                                iterator++;
                                            }
                                }
                            }
                            
                        }
                        else{
                            iterator = 0;
                               found = false;
                               stopped = false;
                               while (iterator < holes && !found)
                               {
                                  startinglocation = (ArrayList<Integer>) realpairs.get(iterator).clone();
                                  location = (ArrayList<Integer>) startinglocation.clone();
                                  for (int step = 0; step < 20 && !stopped; step++)
                                  {
                                        location.set(1, location.get(1) + 1);
                                        if (pairs.get(location) != null)
                                        {
                                             location = (ArrayList<Integer>) pairs.get(location).clone();
                                             if (location.equals(startinglocation))
                                                   {
                                                       
                                                            counter++;
                                                            found = true;
                                                            stopped = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        stopped = true;
                                                    }
                                                }
                                                stopped = false;
                                                iterator++;
                                            }
                        }
                    }
                    }
                    else{
                        
                        iterator = 0;
                               found = false;
                               stopped = false;
                               while (iterator < holes && !found)
                               {
                                  startinglocation = (ArrayList<Integer>) realpairs.get(iterator).clone();
                                  location = (ArrayList<Integer>) startinglocation.clone();
                                  for (int step = 0; step < 20 && !stopped; step++)
                                  {
                                        location.set(1, location.get(1) + 1);
                                        if (pairs.get(location) != null)
                                        {
                                             location = (ArrayList<Integer>) pairs.get(location).clone();
                                             if (location.equals(startinglocation))
                                                   {
                                                            counter++;
                                                            found = true;
                                                            stopped = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        stopped = true;
                                                    }
                                                }
                                                stopped = false;
                                                iterator++;
                                            }
                    }
                }
                }
                    else{
                        iterator = 0;
                               found = false;
                               stopped = false;
                               while (iterator < holes && !found)
                               {
                                  startinglocation = (ArrayList<Integer>) realpairs.get(iterator).clone();
                                  location = (ArrayList<Integer>) startinglocation.clone();
                                  for (int step = 0; step < 20 && !stopped; step++)
                                  {
                                        location.set(1, location.get(1) + 1);
                                        if (pairs.get(location) != null)
                                        {
                                             location = (ArrayList<Integer>) pairs.get(location).clone();
                                             if (location.equals(startinglocation))
                                                   {
                                                            counter++;
                                                            found = true;
                                                            stopped = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        stopped = true;
                                                    }
                                                }
                                                stopped = false;
                                                iterator++;
                                            }
                    
        }
            
      
        
    }
    out.println(counter);
    out.close();
    
}
}
