import java.io.*;

public class CoinChangeCombination2 {

    public static void coinChange(int idx, int[] coins, int amtsf, int tamt, String asf) {
        // write your code here
        if(amtsf == tamt){
            System.out.println(asf + ".");
            return;
        } else if(amtsf > tamt || idx == coins.length) {
            return;
        } 
        
        
        //yes call
        for(int i = idx; i < coins.length; i++){
            coinChange(i, coins, amtsf + coins[i], tamt, asf + coins[i] + "-");
        }
        
        // no call
        coinChange(idx + 1, coins, amtsf, tamt, asf);
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