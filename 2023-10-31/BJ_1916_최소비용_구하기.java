import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1916_최소비용_구하기 {
	static class V implements Comparable<V>{
		int v, distance;

		public V(int v, int distance) {
			this.v = v;
			this.distance = distance;
		}

		@Override
		public int compareTo(V other) {
			return this.distance - other.distance;
		}

		@Override
		public String toString() {
			return "V [v=" + v + ", distance=" + distance + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[N+1];
		int[] costArr = new int[N+1];
		int maxValue = Integer.MAX_VALUE;
		Arrays.fill(costArr, maxValue);
		
		ArrayList<ArrayList<V>> adjList = new ArrayList<>();
		for(int i = 0; i <= N; i++) adjList.add(new ArrayList<V>());
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList.get(u).add(new V(v, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		costArr[start] = 0;
		PriorityQueue<V> pq = new PriorityQueue<>();
		pq.add(new V(start, 0));
		
		while(!pq.isEmpty()) {
			V curV = pq.poll();
			
			if(visited[curV.v]) continue;
			
			for(V nextV : adjList.get(curV.v)) {
				if(visited[nextV.v]) continue;
				
				if(costArr[nextV.v] > costArr[curV.v] + nextV.distance) {
					costArr[nextV.v] = costArr[curV.v] + nextV.distance;
					pq.add(new V(nextV.v, costArr[nextV.v]));
				}
			}
			visited[curV.v] = true;
		}
		
		System.out.println(costArr[end]);
	
	}
}
