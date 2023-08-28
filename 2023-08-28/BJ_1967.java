import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1967 {
	static int N, tempVertex;
	static ArrayList<int[]>[] edgeArr;
	static int maxValue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		
		edgeArr = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			edgeArr[i] = new ArrayList<>();
		}
		for(int i = 0; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeArr[v].add(new int[] {u, w});
			edgeArr[u].add(new int[] {v, w});
		}
		bfs(1);
		if(tempVertex != 0) {
			bfs(tempVertex);
		}
		System.out.println(maxValue);
	}
	private static void bfs(int v) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {v, 0});
		boolean[] isVisited = new boolean[N+1];
		isVisited[v] = true; 
		
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int curV = info[0];
			int weight = info[1];
			if(maxValue < weight) {
				maxValue = weight;
				tempVertex = curV;
			}
			for(int[] nextInfo : edgeArr[curV]) {
				int nextV = nextInfo[0];
				int nextW = nextInfo[1];
				if(isVisited[nextV]) continue;
				isVisited[nextV] = true;
				queue.add(new int[] {nextV, weight+nextW});
			}
		}
		
	}
}
