import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_05214_환승 {
	static class Info implements Comparable<Info>{
		int vertex, distance;

		public Info(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Info other) {
			return this.distance - other.distance;
		}

		@Override
		public String toString() {
			return "Info [vertex=" + vertex + ", distance=" + distance + "]";
		}
		
	}
	static int N, K, M;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	static int[] vistied; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		vistied = new int[N+M+1];
		Arrays.fill(vistied, Integer.MAX_VALUE);
		for(int i = 0; i < N+M+1; i++) adjList.add(new ArrayList<>());
		
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < K; k++) {
				int vertex = Integer.parseInt(st.nextToken());
				adjList.get(m+N).add(vertex);
				adjList.get(vertex).add(m+N);
			}
		}
		
		System.out.println(dfs());
		
	}
	private static int dfs() {
		if(1 == N) return 1;
		
		Queue<Info> queue = new ArrayDeque<>();
		queue.add(new Info(1, 1));
		vistied[1] = 1;
		
		while(!queue.isEmpty()) {
			Info curStatus = queue.poll();
//			System.out.println(curStatus);
			for(int v : adjList.get(curStatus.vertex)) {
				if(vistied[v] > curStatus.distance + 1) {
					int nextDis = curStatus.distance;
					if(v <= N) nextDis += 1;
					queue.add(new Info(v, nextDis));
					vistied[v] = nextDis;
					if(v == N) {
						return vistied[v];
					}
				}
			}
			
		
		}
		return -1;
	}
}