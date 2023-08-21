import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BJ_2623 {
	static int[] inDegree;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = inpTemp[0];
		int M = inpTemp[1];
		
		inDegree = new int[N+1];
		adjList = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) adjList[i] = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			inpTemp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 1; j < inpTemp.length-1; j++) {
				int from = inpTemp[j];
				int to = inpTemp[j+1];
				adjList[from].add(to);
				inDegree[to]++;
			}
		}
		
		topologySort();
		
	}
	private static void topologySort() {
		Queue<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < inDegree.length; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
				sb.append(i + "\n");
			}
			
		}
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			for(int v : adjList[u]) {
				if(--inDegree[v] == 0) {
					queue.add(v);
					sb.append(v + "\n");
				}
			}
		}
		
		for(int i : inDegree) {
			if(i == 1) {
				sb = new StringBuilder();
				sb.append(0);
			}
		}
		System.out.println(sb.toString());
	}
}
