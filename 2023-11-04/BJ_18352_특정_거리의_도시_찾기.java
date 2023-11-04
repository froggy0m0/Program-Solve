import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18352_특정_거리의_도시_찾기 {
	static class Node implements Comparable<Node>{
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node ohter) {
			return this.w - ohter.w;
		}

		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int targetDis = Integer.parseInt(st.nextToken());
		int startPos = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
		for(int i = 0; i <= N; i++) adjList.add(new ArrayList<>());
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			adjList.get(Integer.parseInt(st.nextToken()))
						.add(new Node(Integer.parseInt(st.nextToken()), 1));
		}
		
		int[] disArr = new int[N+1];
		Arrays.fill(disArr, 2000000000);
		disArr[startPos] = 0;
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(startPos, 0));
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			
			if(disArr[curNode.v] < curNode.w) continue;
			
			for(Node nextNode : adjList.get(curNode.v)) {
				if(disArr[nextNode.v] > disArr[curNode.v] + nextNode.w) {
					disArr[nextNode.v] = disArr[curNode.v] + nextNode.w;
					queue.add(new Node(nextNode.v, disArr[nextNode.v]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(disArr[i] == targetDis) sb.append(i+"\n");
		}
		if(sb.length() == 0) System.out.println(-1);
		else System.out.println(sb.toString());
	}
}
