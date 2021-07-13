import java.io.*;
import java.util.*;

public class NegativeCycleDetection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		
		int v = Integer.parseInt(str[0]);
		int e = Integer.parseInt(str[1]);
		
		int [][] graph = new int[e][3];
		
		for(int i = 0; i < e; i++){
		    String [] st = br.readLine().split(" ");
		    graph[i][0] = Integer.parseInt(st[0]); // src
		    graph[i][1] = Integer.parseInt(st[1]);  // destination
		    graph[i][2] = Integer.parseInt(st[2]);  //weights
		}
		
		int [] path = new int[v];
		Arrays.fill(path, Integer.MAX_VALUE);
		
		path[0] = 0;
		
		for(int i = 0; i < v - 1; i++){
		    for(int j = 0; j < e; j++){
		        int src = graph[j][0];
		        int nbr = graph[j][1];
		        int wt = graph[j][2];
		        
		        if(path[src] == Integer.MAX_VALUE) continue;
		        
		        if(path[src] + wt < path[nbr]){
		            path[nbr] = path[src] + wt;
		        }
		    }
		}
		
		boolean flag = false;
	    for(int j = 0; j < e; j++){
	        int src = graph[j][0];
	        int nbr = graph[j][1];
	        int wt = graph[j][2];
	        
	        if(path[src] == Integer.MAX_VALUE) continue;
	        
	        if(path[src] + wt < path[nbr]){
	            flag = true;
	        }
	        
	        if(flag) break;
	    }
	    
	    System.out.println(flag == true ? "1":"0");
	}
}