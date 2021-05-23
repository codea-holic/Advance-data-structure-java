import java.io.*;
import java.util.*;

public class MaximumOfWordProblem {

  public static int max = 0;

  public static void solution(String[] words, int[] farr, int[] score, int lmax,  int idx) {
    //write your code here
    if(idx == words.length){
        if(lmax > max){
            max = lmax;
        }
        return;
    }
    
    // check Is it possible to take this word in subset
    String word = words[idx];
    boolean flag = true;
    int localscore = 0;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      farr[ch - 'a']--;
      localscore += score[ch - 'a'];
      if (farr[ch - 'a'] < 0) {
        flag = false;
      }
    }
    if(flag) {
      solution(words, farr, score, lmax + localscore, idx + 1);
    } 
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        farr[ch - 'a']++;
    }
    solution(words, farr, score, lmax, idx + 1);
  }

  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int nofWords = scn.nextInt();
    String[] words = new String[nofWords];
    for (int i = 0 ; i < words.length; i++) {
      words[i] = scn.next();
    }
    int nofLetters = scn.nextInt();
    char[] letters = new char[nofLetters];
    for (int i = 0; i < letters.length; i++) {
      letters[i] = scn.next().charAt(0);
    }
    int[] score = new int[26];
    for (int i = 0; i < score.length; i++) {
      score[i] = scn.nextInt();
    }
    if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
        || score.length == 0) {
      System.out.println(0);
      return;
    }
    int[] farr = new int[score.length];
    for (char ch : letters) {
      farr[ch - 'a']++;
    }
    solution(words, farr, score, 0, 0);
    System.out.println(max);

  }
}