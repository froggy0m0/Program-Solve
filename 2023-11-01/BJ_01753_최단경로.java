
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_01753_최단경로 {
    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
        	
            return this.w - other.w;
        }

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
        
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int start = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Node>> adjList= new ArrayList<>();
        
        for(int v = 0; v <= V; v++) adjList.add(new ArrayList<Node>());
        
        for(int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            
            adjList.get(Integer.parseInt(st.nextToken()))
					.add(
							new Node(
									Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken())
							)
						);
        }
        
        int INF = Integer.MAX_VALUE;
        int[] disArr = new int[V+1];
        boolean[] check = new boolean[V+1];
        for(int v = 0; v <= V; v++) disArr[v] = INF; 
        disArr[start] = 0;
        check[start] = true;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node nextNode : adjList.get(start)) {
        	if(disArr[nextNode.v] > nextNode.w) {
        		disArr[nextNode.v] = nextNode.w;
        		pq.add(nextNode);
        	}
        }
        
        
        while(!pq.isEmpty()) {
            
            Node curNode = pq.poll();
            if(disArr[curNode.v] < curNode.w || check[curNode.v]) continue;
            
            check[curNode.v] = true;
            for(Node nextNode : adjList.get(curNode.v)) {
                
                if(check[nextNode.v] == false 
                		&& disArr[nextNode.v] > disArr[curNode.v] + nextNode.w) {
                    disArr[nextNode.v] = disArr[curNode.v] + nextNode.w;
                    pq.add(new Node( nextNode.v, disArr[nextNode.v]));
                }
            }
        }
        for(int v = 1; v <= V; v++) {
            System.out.println(disArr[v] == INF ? "INF" : disArr[v]);
        }
    }
}