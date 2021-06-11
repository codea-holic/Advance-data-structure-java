import java.util.*;

public class IsPowerOf2{

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    scn.close();
    //write your code here
    System.out.println((n & (n - 1)) == 0 ? true : false);
  }
  
  // Not give correct output for input:- 1610612736
  // Required Output:- false, Actual Output:- true. Why??
  public static boolean isPowerOf2(int n){
    if(n == 0) return true;
    int rsbm = (n & -n);
    int count = 0;
    
    while(rsbm != 0){
        if(count > 1){
            return false;
        }
        n = n - rsbm;
        count++;
        rsbm = (n & -n);
    }
    
    return true;
  }

}