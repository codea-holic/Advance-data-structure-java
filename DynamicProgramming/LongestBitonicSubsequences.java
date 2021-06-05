package DynamicProgramming;

import java.util.*;

public class LongestBitonicSubsequences {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();

        int[] lis_dp = new int[n]; // longest increasing sequence
        lis_dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (lis_dp[j] > max)
                        max = lis_dp[j];
                }
                lis_dp[i] = max + 1;
            }
        }

        int[] lds_dp = new int[n]; // longest decresing sequence
        for (int i = lds_dp.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < lds_dp.length; j++) {
                if (arr[i] >= arr[j]) {
                    if (lds_dp[j] > max)
                        max = lds_dp[j];
                }
            }
            lds_dp[i] = max + 1;
        }

        // for(int i = 0; i < n; i++){
        // System.out.print(lis_dp[i] + " ");
        // }

        int omax = 0;
        for (int i = 0; i < n; i++) {
            if (lis_dp[i] + lds_dp[i] > omax)
                omax = lis_dp[i] + lds_dp[i];
        }

        System.out.println(omax - 1);
    }

}
