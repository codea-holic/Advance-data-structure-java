import java.util.*;

// find Set Bit in a number in 0(1) time

public class FindSetBitsInO1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        table[0] = 0;
        for(int i = 1; i < table.length; i++){
            table[i] = (i & 1) + table[i/2];
        }
        int n = scn.nextInt();
        int res = 0;
        
        res += table[(n & 0xff)];
        n = (n >> 8);
        res += table[(n & 0xff)];
        n = (n >> 8);
        res += table[(n & 0xff)];
        n = (n >> 8);
        res += table[(n & 0xff)];
        n = (n >> 8);

        System.out.println(res);
    }

    static int [] table = new int[256]; 
}
