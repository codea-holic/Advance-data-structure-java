import java.io.*;
import java.util.*;

public class BitBasics {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //write your code here
    
    int onMask = (1 << i);
    int offMask = ~(1 << j);
    int tMask = (1 << k);   // toggle Mask
    int cMask = (1 << m);   // Check Mask
    
    System.out.println((n | onMask));
    System.out.println((n & offMask));
    System.out.println((n ^ tMask));
    if((n & cMask) > 0){
        System.out.println(true);
        
    } else{
        System.out.println(false);
    }
  }

}