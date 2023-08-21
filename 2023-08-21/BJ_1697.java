import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
	static int N, K, size;
	static int answer;
	static boolean[] isVisited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		size = Math.max(N, K) * 2;
		isVisited = new boolean[size+1];
		bfs();
	}
	private static void bfs() {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {N, 0});
		isVisited[N] = true;
		while(!queue.isEmpty()) {
			int[] info = queue.poll();
			int x = info[0];
			int t = info[1];
			if(x == K) {
				System.out.println(t);
			}
			if(0 <= x-1 && x-1 < size && isVisited[x-1] == false) {
				isVisited[x-1] = true;
				queue.add(new int[] {x-1 , t+1});
			}
			if(0 <= x+1 && x+1 < size && isVisited[x+1] == false) {
				isVisited[x+1] = true;
				queue.add(new int[] {x+1, t+1});
			}
			if(0 <= x*2 && x*2 < size && isVisited[x*2] == false) {
				isVisited[x*2] = true;
				queue.add(new int[] {x*2, t+1});
			}
				
		}
	}
}
