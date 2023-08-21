import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2252 {
	static int[] inDegree;
	static ArrayList<Integer> adjList[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		inDegree = new int[N+1];
		adjList = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].add(to);
			inDegree[to]++;
		}
		
		topologySort();
	}

	private static void topologySort() {
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i < inDegree.length; i++) {
			if(inDegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");
			for(int v : adjList[u]) {
				if(--inDegree[v] == 0) {
					queue.offer(v);
				}
			}
		}
		
	}

}
