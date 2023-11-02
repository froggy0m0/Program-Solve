import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class BJ_14938_서강그라운드 {
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node other) {
			return this.w - other.w;
		}
	}

	static int N, M, R;
	static int[] itemArr;
	static ArrayList<ArrayList<Node>> adjList;
	static int maxValue = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		itemArr = new int[N + 1];
		adjList = new ArrayList<>();
		for (int i = 0; i < N + 1; i++)
			adjList.add(new ArrayList<>());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			itemArr[i] = Integer.parseInt(st.nextToken());
		}

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			adjList.get(u).add(new Node(v, w));
			adjList.get(v).add(new Node(u, w));
		}

		for (int startPos = 1; startPos < N + 1; startPos++) {
			maxValue = Math.max(maxValue, dijk(startPos));
		}
		System.out.println(maxValue);
	}

	private static int dijk(int startPos) {
		int[] disArr = new int[N + 1];
		Arrays.fill(disArr, Integer.MAX_VALUE);
		disArr[startPos] = 0;

		PriorityBlockingQueue<Node> pq = new PriorityBlockingQueue<>();
		pq.add(new Node(startPos, 0));

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			if (disArr[curNode.v] < curNode.w)
				continue;

			for (Node nextNode : adjList.get(curNode.v)) {
				if (disArr[nextNode.v] > disArr[curNode.v] + nextNode.w) {
					// curNode.w + nextNode.w
					disArr[nextNode.v] = disArr[curNode.v] + nextNode.w;
					pq.add(new Node(nextNode.v, disArr[nextNode.v]));
				}
			}

		}
		int sum = 0;
		for (int idx = 1; idx < N + 1; idx++) {
			if (disArr[idx] > M) continue;
			
			sum += itemArr[idx];
		}
		return sum;
	}
}
