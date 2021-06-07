import java.util.*;

public class XorOfSumofAllPairs {

  public static int solution(int[] arr) {
    //write your code here

    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      ans = (ans ^ arr[i]);
    }

    return 2 * ans;
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    scn.close();
    System.out.println(solution(arr));
  }

}