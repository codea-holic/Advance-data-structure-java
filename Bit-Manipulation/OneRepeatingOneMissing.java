// Leetcode Question 287. Duplicate Numbers

import java.io.*;
import java.util.*;

public class OneRepeatingOneMissing {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
   //write your code here
   int xor = 0;
   for(int val : arr){
       xor = (xor ^ val);
   }
   for(int i = 1; i <= arr.length; i++){
       xor = (xor ^ i);
   }
   
   int rsbm = xor & -xor;
   
   int x = 0;
   int y = 0;
   
   for(int i = 0; i <= arr.length; i++){
       if((rsbm & i) == 0){
           x = (x ^ i);
       } else{
           y = (y ^ i);
       }
  }
  
  for(int val : arr){
      if(val == x){
          System.out.println("Missing Number -> " + y);
          System.out.println("Repeating Number -> " + x);
          break;
      } 
      else if(val == y){
          System.out.println("Missing Number -> " + x);
          System.out.println("Repeating Number -> " + y);
          break;
      }
  }
}

















}
