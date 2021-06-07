import java.util.*;


// This solution is alternate method of Printing Abbrevation i.e., in Recursion-Backtracing
// Using Bit Manipulation
public class PrintAbbrevation {

    public static void solve(String str){
        // write your code here
        long num = (1 << str.length());
        for(int i = 0; i < num; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                int b = str.length() - 1 - j;
                if((i & (1 << b)) == 0){
                    if(count == 0){
                        sb.append(ch);
                    } else{
                        sb.append(count);
                        sb.append(ch);
                        count = 0;
                    }
                } else {
                    count++;
                }
            }
            
            if(count > 0){
                sb.append(count);
            }
            System.out.println(sb);
        }
        
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
        scn.close();
    }
}