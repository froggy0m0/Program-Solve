import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class SW_3214 {
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
 
        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
     
    static int find(int v) {
        if(parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
     
    static boolean union(int a, int b) {
        int aRoot = find(parents[a]);
        int bRoot = find(parents[b]);
        if(aRoot == bRoot) return false;
         
        parents[bRoot] = aRoot;
        return true;
    }
     
    static int[] parents;
    static Edge[] edges;
    static int V, E;
    static StringBuilder sb = new StringBuilder(); 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int[] tempInp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            V = tempInp[0];
            E = tempInp[1];
             
            parents = new int[V+1];
            for(int i = 1; i < V+1; i++) parents[i] = i;
             
            edges = new Edge[E];
             
            for(int i = 0; i < E; i++) {
                tempInp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                edges[i] = new Edge(tempInp[0], tempInp[1], tempInp[2]);
            }
            Arrays.sort(edges);
             
            long ans = 0;
            int count = 0;
            for(Edge edge : edges) {
                if(union(edge.from, edge.to)) {
                    ans += edge.weight;
                    if(++count == V-1) break;
                }
            }
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }
}