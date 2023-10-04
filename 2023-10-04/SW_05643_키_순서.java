import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import javax.crypto.spec.IvParameterSpec;

public class 신성현_SWEA_5643_키순서 {
	static int N, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			ArrayList<ArrayList<Integer>> adjList1 = new ArrayList<>();
			ArrayList<ArrayList<Integer>> adjList2 = new ArrayList<>();
			for(int n = 0; n <= N; n++) {
				adjList1.add(new ArrayList<Integer>());
				adjList2.add(new ArrayList<Integer>());
			}
			for(int m = 0; m < M; m++) {
				int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				adjList1.get(inp[0]).add(inp[1]);
				adjList2.get(inp[1]).add(inp[0]);
				
			}
			int result = 0;
			for(int n = 1; n <= N; n++) {
				if((dfs(n, adjList1) + dfs(n, adjList2)) == N-1) result++;
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	private static int dfs(int u, ArrayList<ArrayList<Integer>> adjList) {
		int count = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] check = new boolean[N+1];
		queue.add(u);
		while(!queue.isEmpty()) {
			u = queue.poll();
			
			List<Integer> list = adjList.get(u);
			for(int v : list) {
				if(check[v]) continue;
				
				check[v] = true;
				queue.add(v);
				count++;
			}
		}
		return count;
	}
}
