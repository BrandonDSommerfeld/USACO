/*
ID: bdsomme1
LANG: JAVA
TASK: snail
*/
import java.io.*;
import java.util.*;

class snail{
	public static int[][] board = new int[125][125];
	public static boolean[][] vis = new boolean[125][125];
	public static int result = 1;
	public static int n = 1;
	
	public static void main (String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("snail.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snail.out")));
		
		StringTokenizer reader = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(reader.nextToken());
		int bars = Integer.parseInt(reader.nextToken());
		n = size;
		for(int i = 0; i < bars; i++)
		{
			String line = f.readLine();
			int row = Integer.parseInt(line.substring(1));
			int col = line.charAt(0)-64;
			board[row][col] = 1;
		}
		
		vis[1][1] = true;
		dfs(1, 1, 1, false);
		out.println(result);
		
		out.close();
	}
	
	public static boolean outOfBounds(int x, int y){
	    if(x <= 0 || y <= 0 || x > n || y > n)
	        return true;
	    return false;
	}
	 
	public static boolean available(int x, int y){
	    return (!outOfBounds(x, y) && !vis[x][y] && board[x][y] == 0);
	}
	 
	public static void dfs(int x, int y, int cnt, boolean isLast){ 
	    if(cnt > result)
	        result = cnt;
	    if(isLast){ 
	        return;
	    }
	 
	    int tmp;
	    if(available(x+1, y)){ 
	 
	        tmp = x;
	        while(available(++tmp, y));
	        for(int i = x+1; i < tmp; i++){
	            vis[i][y] = true;
	            cnt++;
	        }
	        dfs(tmp-1, y, cnt, vis[tmp][y]);
	        for(int i = x+1; i < tmp; i++){
	            vis[i][y] = false;
	            cnt--;
	        }
	    }
	    if(available(x-1, y)){ 
	 
	        tmp = x;
	        while(available(--tmp, y));
	        for(int i = x-1; i > tmp; i--){
	            vis[i][y] = true;
	            cnt++;
	           
	        }
	        dfs(tmp+1, y, cnt, vis[tmp][y]);
	        for(int i = x-1; i > tmp; i--){
	            vis[i][y] = false;
	            cnt--;
	        }
	    }
	    if(available(x, y+1)){
	 
	        tmp = y;
	        while(available(x, ++tmp));
	        for(int i = y+1; i < tmp; i++){
	            vis[x][i] = true;
	            cnt++;
	           
	        }
	        dfs(x, tmp-1, cnt, vis[x][tmp]);
	        for(int i = y+1; i < tmp; i++){
	            vis[x][i] = false;
	            cnt--;
	            
	        }
	    }
	    if(available(x, y-1)){
	 
	        tmp = y;
	        while(available(x, --tmp));
	        for(int i = y-1; i > tmp; i--){
	            vis[x][i] = true;
	            cnt++;
	        }
	        dfs(x, tmp+1, cnt, vis[x][tmp]);
	        for(int i = y-1; i > tmp; i--){
	            vis[x][i] = false;
	            cnt--;
	        }
	    }
	}
}