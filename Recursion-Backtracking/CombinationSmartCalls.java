import java.io.*;

public class CombinationSmartCalls {
// cb -> current box
// tb -> total box
// ssf -> selection so far
// ts -> total selection
// asf -> answer so far
  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    // write your code here
	if(ssf == ts){
		System.out.println(asf);
		return;
	}
	// We can't put these check (cb > tb) above the first check(ssf == ts) bcoz  
	// it return  at that instant and we will not able to check for last box...
    if(cb > tb){
        return;
    }
    
    combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
    combinations(cb + 1, tb, ssf, ts, asf + "-");
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}