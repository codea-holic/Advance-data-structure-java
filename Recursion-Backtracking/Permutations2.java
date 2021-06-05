import java.io.*;
import java.util.*;

/* In this method keep boxes on levels instead of keeping items on level
  for more info you can refer Permutation1 code */
public class Permutations2 {
    // cb ->  current box
    // tb -> total box
    // [] items -> which item are done
    // ssf -> selection so far
    // ti -> total items
    // asf -> answer so far
  public static void permutations(int cb, int tb, int[] items, int ssf, int ti, String asf){
    if(cb > tb){
        if(ssf == ti){
            System.out.println(asf);
        }
        return;
    }
    
    for(int i = 0; i < ti; i++){
        if(items[i] == 0){
            items[i] = 1;
            permutations(cb + 1, tb, items, ssf + 1, ti, asf + (i + 1));
            items[i] = 0;
        }
    }
    permutations(cb + 1, tb, items, ssf, ti, asf + "0");
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}