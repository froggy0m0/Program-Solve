import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_01238_파티 {
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node other) {
			return this.w - other.w;
		}
		
	}
	static int N, M, X;
	static int[] result;
	static ArrayList<ArrayList<Node>> adjList1 = new ArrayList<>();
	static ArrayList<ArrayList<Node>> adjList2 = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		result = new int[N+1];
		for(int i = 0; i < N+1; i++) {
			adjList1.add(new ArrayList<>());
			adjList2.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList1.get(v).add(new Node(u, w));
			adjList2.get(u).add(new Node(v, w));
		}
		
		dijk(adjList1);
		dijk(adjList2);
		int maxValue = 0;
		for(int i = 1; i <= N; i++) {
			maxValue = Math.max(maxValue, result[i]);
		}
		System.out.println(maxValue);
	}
	private static void dijk(ArrayList<ArrayList<Node>> adjList) {
		int[] disArr = new int[N+1];
		Arrays.fill(disArr, 2002222222);
		disArr[X] = 0;
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(X, disArr[X]));
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(curNode.w > disArr[curNode.v]) continue;
			
			for(Node nextNode : adjList.get(curNode.v)) {
				if(disArr[nextNode.v] > curNode.w + nextNode.w) {
					disArr[nextNode.v] = curNode.w + nextNode.w;
					queue.add(new Node(nextNode.v, disArr[nextNode.v]));
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			result[i] += disArr[i];
		}
	}

}
