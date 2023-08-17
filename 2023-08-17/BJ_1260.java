import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1260 {

	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	static int N;
	static boolean[] isVisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		for (int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(adjList.get(i));
		}
			isVisited = new boolean[N + 1];
			dfs(V);
			System.out.println();
			bfs(V);
	}

	private static void dfs(int u) {
		isVisited[u] = true;
		System.out.print(u + " ");
		ArrayList<Integer> nextVList = adjList.get(u);
		for (Integer v : nextVList) {
			if (isVisited[v])
				continue;
			dfs(v);
		}
	}

	private static void bfs(int u) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N + 1];
		isVisited[u] = true;
		queue.add(u);
		while (!queue.isEmpty()) {
			u = queue.poll();
			System.out.print(u + " ");
			ArrayList<Integer> nextVList = adjList.get(u);
			for (Integer v : nextVList) {
				if (isVisited[v])
					continue;
				isVisited[v] = true;
				queue.add(v);
			}
		}
	}
}