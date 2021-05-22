import java.io.*;
import java.util.*;

public class InvalidParanthesisLeetcode {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		//write your code here
		if(minRemoval == 0){
		    int mrnow = getMin(str);
		    if(mrnow == 0){
		        if(!ans.contains(str)){
		            System.out.println(str);
		            ans.add(str);
		        }
		    }
		    
		    return;
		}
		
		for(int i = 0; i < str.length(); i++){
		    String left = str.substring(0, i);
		    String right = str.substring(i + 1);
		    solution(left + right, minRemoval - 1, ans);
		}
	}

	public static int getMin(String str){
		//write your code here
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++){
		    char ch = str.charAt(i);
		    if(ch == '('){
		        stack.push(ch);
		    } else{
		        if(stack.size() == 0){
		            stack.push(ch);
		        } else if(stack.peek() == ')'){
		            stack.push(ch);
		        } else if(stack.peek() == '('){
		            stack.pop();
		        }
		    }
		}
		
		return stack.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str), new HashSet<>());
        scn.close();
	}
		
}