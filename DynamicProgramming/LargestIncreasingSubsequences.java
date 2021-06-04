package DynamicProgramming;
import java.util.*;

public class LargestIncreasingSubsequences {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        int [] dp = new int[n];
        dp[0] = 1;  // at 0 pos only one number is present and that is valid LIS
        int omax = 1;   // overall max -> is 1 because dp[0] is solved already and omax = 1;
        
        
        for(int i = 0; i < n; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(arr[j] <= arr[i]){
                    if(dp[j] > max) max = dp[j];
                }
                
                dp[i] = max + 1;
                
                if(dp[i] > omax) omax = dp[i];
            }
        }
        
        System.out.println(omax);
        
    }

}