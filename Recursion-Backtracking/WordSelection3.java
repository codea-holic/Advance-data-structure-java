import java.io.*;
import java.util.*;

public class WordSelection3 {

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
          //frequency map
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    //0 -> selection so far
    wordsSelection(ustr, unique, 0, 0, k, "");
   
  }
  
  // ssf -> selection so far
  public static void wordsSelection(String ustr, HashMap<Character, Integer> fmap, int idx, int ssf, int ts, String asf){
      
      if(ssf == ts){
          System.out.println(asf);
          return;
      }
      if(idx == ustr.length() || ssf > ts){
          return;
      }
      
      char ch = ustr.charAt(idx);
    //   for(int i = fmap.get(ch); i >= 0; i--){
    //       String str = "";
    //       for(int j = 0; j < i; j++){
    //           str += ch;
    //       }
          
    //       wordsSelection(ustr, fmap, idx + 1, ssf + i, ts, asf + str);
    //   }

    if (fmap.get(ch) > 0) {
        fmap.put(ch, fmap.get(ch) - 1);
        wordsSelection(ustr, fmap, idx, ssf + 1, ts, asf + ch);
        fmap.put(ch, fmap.get(ch) + 1);
      }
      
      wordsSelection(ustr, fmap, idx + 1, ssf, ts, asf);
      
  }
  
}