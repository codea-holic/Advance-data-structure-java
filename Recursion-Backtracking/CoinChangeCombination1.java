import java.io.*;

// In this question:- You can select Each denomination only once in a subset.
public class CoinChangeCombination1 {

    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        // write your code here
        
        if(amtsf == tamt){
            System.out.println(asf + ".");
            return;
        }
        if(i == coins.length || amtsf > tamt){
            return;
        }
        
        // yea call
        coinChange(i + 1, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        
        // no call
        coinChange(i + 1, coins, amtsf, tamt, asf);
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        
        coinChange(0, coins, 0, amt, "");
    }
}