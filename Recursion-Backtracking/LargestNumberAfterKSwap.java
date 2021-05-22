import java.io.*;
import java.util.*;

/* You have to find the largest number after K swap (of digits)
 Question:- 
 1234567
 4

 Required Answer:- 7654321 
 For more info See Leetcode Q.no. 1505
 */

public class LargestNumberAfterKSwap {
    
    public static String swap(String str, int i, int j){
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        
        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1);
        
        return left + jth + middle + ith + right;
    }
    
	static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		if(Integer.parseInt(str) > Integer.parseInt(max)){
		    max = str;
		}
		
		if(k == 0){
		    return;
		}
		
		for(int i = 0; i < str.length() - 1; i++){
		    for(int j = i + 1; j < str.length(); j++){
		        if(str.charAt(j) > str.charAt(i)){
		            String swapped = swap(str, i, j);
    		        findMaximum(swapped, k - 1);
		        }
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}