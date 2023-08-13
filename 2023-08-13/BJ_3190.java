import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190 {
	static int[][] arr;
	static Queue<String[]> dirQueue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		arr = new int[N+2][N+2];
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			int[] applePos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			arr[applePos[0]][applePos[1]] = 1;
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i][0] = 9;
			arr[0][i] = 9;
			arr[N+1][i] = 9;
			arr[i][N+1] = 9;
		}

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dirQueue.add(new String[] { st.nextToken(), st.nextToken() });
		}

		System.out.println(func());
	}

	private static int func() {
		int t = 0;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { 1, 1 });
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int way = 0;
		while (deque.size() > 0) {
			int nx = deque.peekFirst()[0] + dx[(way) % 4];
			int ny = deque.peekFirst()[1] + dy[(way) % 4];
//			if ((-1 < nx && nx < arr.length) && (-1 < ny && ny < arr.length)) {
			if (arr[nx][ny] != 9) {
				for (int[] tempPos : deque) {
					if (tempPos[0] == nx && tempPos[1] == ny) return t+1;
				}
				deque.offerFirst(new int[] { nx, ny });
     				if (arr[nx][ny] != 1) deque.pollLast();
				else if (arr[nx][ny] == 1) arr[nx][ny] = 0;
				
			} else {
				return t+1;
			}
			t++;
			if (!dirQueue.isEmpty() && Integer.parseInt(dirQueue.peek()[0]) == t) {
				switch (dirQueue.peek()[1]) {
				case "L":
					way--;
					if(way < 0) way+=4;
					break;
				case "D":
					way++;
					break;
				}
				dirQueue.poll();
			}
		}
		return t;
	}
}
