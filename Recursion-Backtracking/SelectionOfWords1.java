import java.util.*;

public class SelectionOfWords1 {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String st = scn.nextLine();
    int k = scn.nextInt();

    HashSet<Character> unique = new HashSet<>();
    String uString = "";
    for (char ch : st.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        uString += ch;
      }
    }
    scn.close();
    combination(0, uString, 0, k, "");
  }


  // ustr -> unique string
  // ts -> total spots
  // asf -> answer so far
  // ssf -> set so far(no. of character in asf string)
  public static void combination(int i, String ustr, int ssf, int ts, String asf ) {
    if(i == ustr.length()){
          if(ssf == ts){
              System.out.println(asf);
          }
          return;
      }
      
      // yes call
      char ch = ustr.charAt(i);
      combination(i + 1, ustr, ssf + 1, ts, asf + ch);
      
      //no call
      combination(i + 1, ustr, ssf, ts, asf);
  }

}