import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BellmonFord {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] str = br.readLine().split(" ");
        
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        int [][] arr = new int[m][3];
        
        for(int i = 0; i < m; i++){
            String [] st = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(st[0]) - 1;    // src
            arr[i][1] = Integer.parseInt(st[1]) - 1;    // neighbour
            arr[i][2] = Integer.parseInt(st[2]);    // paths
        }
        
        int [] paths  = new int[n];
        Arrays.fill(paths, Integer.MAX_VALUE);
        paths[0] = 0;
        
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                
                if(paths[arr[j][0]] == Integer.MAX_VALUE) continue;
                
                if(paths[arr[j][0]] + arr[j][2] < paths[arr[j][1]]){
                   paths[arr[j][1]] = paths[arr[j][0]] + arr[j][2];
                }
                
            }
        }
        
        for(int i = 1; i < paths.length; i++){
            if(paths[i] == Integer.MAX_VALUE){
                System.out.print("1000000000 ");
            }
            else System.out.print(paths[i]+ " ");
        }
        System.out.println();
	}
}
