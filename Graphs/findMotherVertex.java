import java.util.*;
import java.io.*;


// finding of Mother vertex
public class findMotherVertex{

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String [] str = br.readLine().split(" ");
    int v = Integer.parseInt(str[0]);
    int e = Integer.parseInt(str[1]);
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    for(int i = 0; i < v; i++){
      graph.add(new ArrayList<>());
    }

    for(int i = 0; i < e; i++){
      str = br.readLine().split(" ");
      int src = Integer.parseInt(str[0]) - 1;
      int nbr = Integer.parseInt(str[1]) - 1;
      graph.get(src).add(nbr);
    }

    // System.out.println(graph);

    System.out.println(findMotherVertex(graph, v));
  }

  private static int findMotherVertex(ArrayList<ArrayList<Integer>> graph, int v){
    int mV;
    boolean [] visited = new boolean[v];
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < v; i++){
      if(visited[i] == false){
        dfs(graph, i, visited, st);
      }
    }
    // while(st.size() > 0){
    //   System.out.println(st.pop());
    // }

    Arrays.fill(visited, false);

    int pmV;
    if(st.size() > 0) pmV = st.peek();
    else return -1;
    
    // System.out.println(pmV);

    mV = dfs(graph, pmV, visited, st.size());  // pmV -> potential Mother Vertex;
    if(mV == 1) return pmV + 1;
    else return -1;
  }

  private static int dfs(ArrayList<ArrayList<Integer>> graph, int pmV, boolean [] visited, int size) {
    if(size == 1){
      return 1;
    }

    int res = 0;
    visited[pmV] = true;
    for(int edge : graph.get(pmV)){
      if(visited[edge] == false){
        res = dfs(graph, edge, visited, size - 1);
      }
    }

    return res;
  }

  private static void dfs(ArrayList<ArrayList<Integer>> graph, int i, boolean[] visited, Stack<Integer> st) {
    visited[i] = true;

    for(Integer edge : graph.get(i)){
      if(visited[edge] == false){
        dfs(graph, edge, visited, st);
      }
    }

    st.push(i);

  }
}