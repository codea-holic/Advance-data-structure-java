import java.io.*;
import java.util.*;

// Leetcode Question number 1534
public class TripletCount {

	public static void solution(int[] arr) {
		// write your code here
		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			for (int k = i + 1; k < arr.length; k++) {
				val = val ^ arr[k];

				if (val == 0) {
					c += (k - i);
				}
			}
		}
		System.out.println(c);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		solution(arr);
		scn.close();
	}

}